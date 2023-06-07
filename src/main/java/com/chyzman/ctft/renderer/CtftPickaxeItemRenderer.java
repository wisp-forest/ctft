package com.chyzman.ctft.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.BakedModelManagerHelper;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static com.chyzman.ctft.util.CtftRegistryHelper.id;

@Environment(EnvType.CLIENT)
public class CtftPickaxeItemRenderer extends CtftItemRenderer {
    public CtftPickaxeItemRenderer(Identifier id) {
        super(id);
    }

    @Override
    public void renderMaterial(MatrixStack matrices, Runnable piece) {
        super.renderMaterial(matrices, piece);
        matrices.translate(5.5, -2.5, 0.0);
        piece.run();
        matrices.translate(0.0, 1.0, 0.0);
        piece.run();
        matrices.translate(0.0, 1.0, 0.0);
        piece.run();
        matrices.translate(0.0, 1.0, 0.0);
        piece.run();
        matrices.translate(0.0, 1.0, 0.0);
        piece.run();
        matrices.translate(-1.0, 0.0, 0.0);
        piece.run();
        matrices.translate(0.0, 1.0, 0.0);
        piece.run();
        matrices.translate(-1.0, 0.0, 0.0);
        piece.run();
        matrices.translate(0.0, 1.0, 0.0);
        piece.run();
        matrices.translate(-1.0, 0.0, 0.0);
        piece.run();
        matrices.translate(0.0, 1.0, 0.0);
        piece.run();
        matrices.translate(-1.0, 0.0, 0.0);
        piece.run();
        matrices.translate(-1.0, 0.0, 0.0);
        piece.run();
        matrices.translate(-1.0, 0.0, 0.0);
        piece.run();
        matrices.translate(-1.0, 0.0, 0.0);
        piece.run();
    }
}