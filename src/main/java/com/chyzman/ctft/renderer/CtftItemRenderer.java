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
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.command.argument.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.nbt.visitor.StringNbtWriter;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Random;

import static com.chyzman.ctft.client.CtftClient.CTFTESSELLATOR;
import static com.chyzman.ctft.util.CtftOverrideHelper.identifier;

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
        var nbt = itemStack.getNbt();
        Runnable piece;
        if (nbt != null && itemStack.getNbt().getString("material") != null) {
            var material = nbt.getString("material");
            var type = nbt.getString("material_type");
            var matcher = identifier.matcher(material);
            var id = Identifier.tryParse(matcher.find() ? material.substring(matcher.start(), matcher.end()) : material);
            if (!type.isEmpty()) {
                switch (type) {
                    case "item": {
                        if (material.equals("random")) {
                            Random random = new Random(world.getTime());
                            piece = () -> {
                                ItemStack stack = new ItemStack(Registries.ITEM.get(random.nextInt(Registries.ITEM.size())));
                                MinecraftClient.getInstance().getItemRenderer().renderItem(player, stack, ModelTransformationMode.NONE, lefthanded, matrices, vertexConsumers, world, light, overlay, world.random.nextInt());
                            };
                            renderMaterial(matrices, piece);
                            break;
                        }
                        try {
                            var result = ItemStringReader.item(Registries.ITEM.getReadOnlyWrapper(), new StringReader(material));
                            ItemStack stack = new ItemStackArgument(result.item(), result.nbt()).createStack(1, false);
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
                        } catch (CommandSyntaxException ignored) {
                        }
                    }
                    case "block": {
                        if (material.equals("random")) {
                            Random random = new Random(world.getTime());
                            piece = () -> {
                                matrices.translate(-0.5, -0.5, -0.5);
                                BlockState state = Registries.BLOCK.get(random.nextInt(Registries.BLOCK.size())).getDefaultState();
                                MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay);
                                matrices.translate(0.5, 0.5, 0.5);
                            };
                            renderMaterial(matrices, piece);
                            break;
                        }
                        try {
                            var state = BlockArgumentParser.block(Registries.BLOCK.getReadOnlyWrapper(), material, true).blockState();
                            piece = () -> {
                                matrices.translate(-0.5, -0.5, -0.5);
                                if (state.getBlock() instanceof BlockEntityProvider blockEntityProvider) {
                                    var blockEntity = blockEntityProvider.createBlockEntity(MinecraftClient.getInstance().player.getBlockPos(), state);
                                    blockEntity.setWorld(world);
                                    MinecraftClient.getInstance().getBlockEntityRenderDispatcher().render(blockEntity, world.getTime(), matrices, vertexConsumers);
                                }
                                MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay);
                                matrices.translate(0.5, 0.5, 0.5);
                            };
                            renderMaterial(matrices, piece);
                        } catch (CommandSyntaxException ignored) {
                        }
                    }
                    case "entity": {
                        if (material.equals("random")) {
                            Random random = new Random(world.getTime());
                            piece = () -> {
                                Entity entity = Registries.ENTITY_TYPE.stream().filter(EntityType::isSummonable).toList().get(random.nextInt(Registries.ENTITY_TYPE.stream().filter(EntityType::isSummonable).toList().size())).create(MinecraftClient.getInstance().world);
                                var scale = Math.min(1, 0.5f / Math.min(entity.getWidth(), entity.getHeight()));
                                matrices.scale(scale, scale, scale);
                                matrices.translate(0, -0.5 * entity.getHeight(), 0);
                                MinecraftClient.getInstance().getEntityRenderDispatcher().render(entity, 0, 0, 0, 0, 0, matrices, vertexConsumers, light);
                                matrices.translate(0, 0.5 * entity.getHeight(), 0);
                                matrices.scale(1 / scale, 1 / scale, 1 / scale);
                            };
                            renderMaterial(matrices, piece);
                            break;
                        }
                        try {
                            Entity entity;
                            if (material.contains(" ")) {
                                var entity_nbt = StringNbtReader.parse(material.substring(material.indexOf(" ")));
                                entity_nbt.putString("id", id.toString());
                                entity = EntityType.loadEntityWithPassengers(entity_nbt, world, entityx -> entityx);
                            } else {
                                entity = Registries.ENTITY_TYPE.get(id).create(MinecraftClient.getInstance().world);
                            }
                            if (entity != null) {
                                var scale = Math.min(1, 0.5f / Math.min(entity.getWidth(), entity.getHeight()));
                                piece = () -> {
                                    matrices.scale(scale, scale, scale);
                                    matrices.translate(0, -0.5 * entity.getHeight(), 0);
                                    MinecraftClient.getInstance().getEntityRenderDispatcher().render(entity, 0, 0, 0, 0, 0, matrices, vertexConsumers, light);
                                    renderPassengers(entity, matrices, vertexConsumers, light, 0);
                                    matrices.translate(0, 0.5 * entity.getHeight(), 0);
                                    matrices.scale(1 / scale, 1 / scale, 1 / scale);
                                };
                                renderMaterial(matrices, piece);
                            }
                        } catch (CommandSyntaxException ignored) {
                        }
                    }
                    case "particle": {
                        ParticleEffect particleEffect;
                        try {
                            particleEffect = ParticleEffectArgumentType.readParameters(new StringReader(itemStack.getNbt().getString("material")), Registries.PARTICLE_TYPE.getReadOnlyWrapper());

                            RenderSystem.setShaderTexture(0, SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE);
                            RenderSystem.setShader(GameRenderer::getParticleProgram);

                            Tessellator tessellator = CTFTESSELLATOR;
                            BufferBuilder bufferBuilder = tessellator.getBuffer();
                            bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);

                            var camera = MinecraftClient.getInstance().gameRenderer.getCamera();
                            var cameraRotation = camera.getRotation();
                            var cameraPos = camera.getPos();
                            ((CameraAccessor) camera).ctft$setRotation(new Quaternionf().rotationY((float) Math.PI));
                            ((CameraAccessor) camera).ctft$setPos(player.getEyePos());

                            var consumer = new TransformingVertexConsumer(bufferBuilder, matrices.peek());

                            piece = () -> {
                                var particle = ((ParticleManagerAccessor) MinecraftClient.getInstance().particleManager).ctft$CreateParticle(particleEffect, player.getX(), player.getEyeY(), player.getZ(), 0, 0, 0);
                                var box = particle.getBoundingBox();
                                float scale = (float) Math.max(box.maxX - box.minX, Math.max(box.maxY - box.minY, box.maxZ - box.minZ));
                                matrices.scale(16, 16, 16);
                                matrices.scale(scale, scale, scale);
                                particle.buildGeometry(consumer, camera, 0);
                                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                                particle.buildGeometry(consumer, camera, 0);
                                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-180));
                                matrices.scale(1 / scale, 1 / scale, 1 / scale);
                                matrices.scale(1 / 16f, 1 / 16f, 1 / 16f);
                            };
                            RenderSystem.enableDepthTest();
                            renderMaterial(matrices, piece);
                            tessellator.draw();
                            RenderSystem.disableDepthTest();

                            ((CameraAccessor) camera).ctft$setRotation(cameraRotation);
                            ((CameraAccessor) camera).ctft$setPos(cameraPos);
                        } catch (CommandSyntaxException ignored) {
                        }
                    }
                }
            } else if (id != null) {
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
                        particleEffect = ParticleEffectArgumentType.readParameters(new StringReader(itemStack.getNbt().getString("material")), Registries.PARTICLE_TYPE.getReadOnlyWrapper());
                    } catch (CommandSyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    RenderSystem.setShaderTexture(0, SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE);
                    RenderSystem.setShader(GameRenderer::getParticleProgram);

                    Tessellator tessellator = CTFTESSELLATOR;
                    BufferBuilder bufferBuilder = tessellator.getBuffer();
                    bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);

                    var camera = MinecraftClient.getInstance().gameRenderer.getCamera();
                    var cameraRotation = camera.getRotation();
                    var cameraPos = camera.getPos();
                    ((CameraAccessor) camera).ctft$setRotation(new Quaternionf().rotationY((float) Math.PI));
                    ((CameraAccessor) camera).ctft$setPos(player.getEyePos());

                    var consumer = new TransformingVertexConsumer(bufferBuilder, matrices.peek());

                    piece = () -> {
                        var particle = ((ParticleManagerAccessor) MinecraftClient.getInstance().particleManager).ctft$CreateParticle(particleEffect, player.getX(), player.getEyeY(), player.getZ(), 0, 0, 0);
                        var box = particle.getBoundingBox();
                        float scale = (float) Math.max(box.maxX - box.minX, Math.max(box.maxY - box.minY, box.maxZ - box.minZ));
                        matrices.scale(16, 16, 16);
                        matrices.scale(scale, scale, scale);
                        particle.buildGeometry(consumer, camera, 0);
                        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                        particle.buildGeometry(consumer, camera, 0);
                        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-180));
                        matrices.scale(1 / scale, 1 / scale, 1 / scale);
                        matrices.scale(1 / 16f, 1 / 16f, 1 / 16f);
                    };
                    RenderSystem.enableDepthTest();
                    renderMaterial(matrices, piece);
                    tessellator.draw();
                    RenderSystem.disableDepthTest();

                    ((CameraAccessor) camera).ctft$setRotation(cameraRotation);
                    ((CameraAccessor) camera).ctft$setPos(cameraPos);
                }
            }
        }
        matrices.pop();
    }

    public void renderMaterial(MatrixStack matrices, Runnable piece) {
        matrices.scale(1 / 16f, 1 / 16f, 1 / 16f);
    }

    public void renderPassengers(Entity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, double offset) {
        if (entity.hasPassengers()) {
            entity.getPassengerList().forEach(entity1 -> {
                MinecraftClient.getInstance().getEntityRenderDispatcher().render(entity1, 0, offset + entity.getMountedHeightOffset(), 0, 0, 0, matrices, vertexConsumers, light);
                renderPassengers(entity1, matrices, vertexConsumers, light, offset + entity.getMountedHeightOffset());
            });
        }
    }
}