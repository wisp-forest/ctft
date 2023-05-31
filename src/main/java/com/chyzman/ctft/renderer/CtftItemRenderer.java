package com.chyzman.ctft.renderer;

import com.chyzman.ctft.client.TransformingVertexConsumer;
import com.chyzman.ctft.mixin.CameraAccessor;
import com.chyzman.ctft.mixin.ParticleManagerAccessor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.BakedModelManagerHelper;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.command.argument.ParticleEffectArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;

import static com.chyzman.ctft.client.CtftClient.CTFTESSELLATOR;

@Environment(EnvType.CLIENT)
public class CtftItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    private final Identifier modelId;

    public CtftItemRenderer(Identifier id) {
        this.modelId = id;
    }

    @Override
    public void render(ItemStack itemStack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        var player = MinecraftClient.getInstance().player;
        var world = player.getWorld();
        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        var lefthanded = mode.getIndex() == 1 || mode.getIndex() == 3;
        var base_model = BakedModelManagerHelper.getModel(MinecraftClient.getInstance().getBakedModelManager(), this.modelId);
        if (base_model != null) {
            MinecraftClient.getInstance().getItemRenderer().renderItem(itemStack, mode, lefthanded, matrices, vertexConsumers, light, overlay, base_model);
        }
        if (itemStack.getNbt() != null && itemStack.getNbt().getString("material") != null) {
            var id = Identifier.tryParse(itemStack.getNbt().getString("material"));
            if (id != null) {
                Runnable piece;
                if (Registries.ITEM.containsId(id)) {
                    ItemStack stack = new ItemStack(Registries.ITEM.get(id));
                    if (stack.getItem() instanceof SpawnEggItem) {
                        var entity = ((SpawnEggItem) stack.getItem()).getEntityType(stack.getNbt()).create(MinecraftClient.getInstance().world);
                        var scale = Math.min(1, 0.5f / Math.min(entity.getWidth(), entity.getHeight()));
                        piece = () -> {
                            matrices.scale(scale, scale, scale);
                            matrices.translate(0, -0.5 * entity.getHeight(), 0);
                            MinecraftClient.getInstance().getEntityRenderDispatcher().render(entity, 0, 0, 0, 0, 0, matrices, vertexConsumers, light);
                            matrices.translate(0, 0.5 * entity.getHeight(), 0);
                            matrices.scale(1 / scale, 1 / scale, 1 / scale);
                        };
                    } else {
                        piece = () -> {
                            MinecraftClient.getInstance().getItemRenderer().renderItem(player, stack, ModelTransformationMode.NONE, lefthanded, matrices, vertexConsumers, world, light, overlay, world.random.nextInt());
                        };
                    }
                    renderMaterial(matrices, piece);
                } else if (Registries.BLOCK.containsId(id)) {
                    var state = Registries.BLOCK.get(id).getDefaultState();
                    piece = () -> {
                        matrices.translate(-0.5, -0.5, -0.5);
                        if (Registries.BLOCK.get(id) instanceof BlockEntityProvider blockEntityProvider) {
                            var blockEntity = blockEntityProvider.createBlockEntity(MinecraftClient.getInstance().player.getBlockPos(), state);
                            blockEntity.setWorld(world);
                            MinecraftClient.getInstance().getBlockEntityRenderDispatcher().render(blockEntity, world.getTime(), matrices, vertexConsumers);
                        }
                        MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay);
                        matrices.translate(0.5, 0.5, 0.5);
                    };
                    renderMaterial(matrices, piece);
                } else if (Registries.ENTITY_TYPE.containsId(id)) {
                    var entity = Registries.ENTITY_TYPE.get(id).create(MinecraftClient.getInstance().world);
                    var scale = Math.min(1, 0.5f / Math.min(entity.getWidth(), entity.getHeight()));
                    piece = () -> {
                        matrices.scale(scale, scale, scale);
                        matrices.translate(0, -0.5 * entity.getHeight(), 0);
                        MinecraftClient.getInstance().getEntityRenderDispatcher().render(entity, 0, 0, 0, 0, 0, matrices, vertexConsumers, light);
                        matrices.translate(0, 0.5 * entity.getHeight(), 0);
                        matrices.scale(1 / scale, 1 / scale, 1 / scale);
                    };
                    renderMaterial(matrices, piece);
                } else if (Registries.PARTICLE_TYPE.containsId(id)) {
                    ParticleEffect particleEffect;
                    try {
                        particleEffect = ParticleEffectArgumentType.readParameters(new StringReader(id.toString()), Registries.PARTICLE_TYPE.getReadOnlyWrapper());
                    } catch (CommandSyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    Registries.PARTICLE_TYPE.get(id);
                        RenderSystem.enableBlend();
                        RenderSystem.defaultBlendFunc();
                        RenderSystem.depthMask(true);
                        RenderSystem.setShaderTexture(0, SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE);
                        RenderSystem.setShader(GameRenderer::getParticleProgram);

                        Tessellator tessellator = CTFTESSELLATOR;
                        BufferBuilder bufferBuilder = tessellator.getBuffer();
                        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);

                        var camera = MinecraftClient.getInstance().gameRenderer.getCamera();
                        var cameraRotation = camera.getRotation();
                        var cameraPos = camera.getPos();

                        ((CameraAccessor) camera).ctft$setRotation(new Quaternionf().rotationY((float) Math.PI));
                        ((CameraAccessor) camera).ctft$setPos(Vec3d.ZERO);

                        var consumer = new TransformingVertexConsumer(bufferBuilder, matrices.peek());

                        piece = () -> {
                            matrices.scale(16,16,16);
                            var particle = ((ParticleManagerAccessor) MinecraftClient.getInstance().particleManager).ctft$CreateParticle(particleEffect, 0, 0, 0, 0, 0, 0);
                            particle.buildGeometry(consumer, camera, 0);
                            matrices.scale(1/16f,1/16f,1/16f);
                        };
                        renderMaterial(matrices, piece);
                        tessellator.draw();

                        ((CameraAccessor) camera).ctft$setRotation(cameraRotation);
                        ((CameraAccessor) camera).ctft$setPos(cameraPos);
                }
            }
        }
        matrices.pop();
        RenderSystem.applyModelViewMatrix();
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
    }

    public void renderMaterial(MatrixStack matrices, Runnable piece) {
        matrices.scale(1 / 16f, 1 / 16f, 1 / 16f);
    }
}