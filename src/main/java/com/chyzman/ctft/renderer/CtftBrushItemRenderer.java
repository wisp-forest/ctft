package com.chyzman.ctft.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CtftBrushItemRenderer extends CtftItemRenderer {
    public CtftBrushItemRenderer(Identifier id) {
        super(id);
    }

    @Override
    public void renderMaterial(MatrixStack matrices, Runnable piece) {
        super.renderMaterial(matrices, piece);
        matrices.translate(-0.5, -0.5, 0);
        piece.run();
        matrices.translate(3, 0, 0);
        piece.run();
        matrices.translate(-4, 1, 0);
        piece.run();
        matrices.translate(2, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(2, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(-5, 1, 0);
        piece.run();
        matrices.translate(2, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(2, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(-6, 1, 0);
        piece.run();
        matrices.translate(3, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(2, 0, 0);
        piece.run();
        matrices.translate(-6, 1, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(2, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(-4, 1, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(2, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(1, 0, 0);
        piece.run();
        matrices.translate(-4, 1, 0);
        piece.run();
        matrices.translate(2, 0, 0);
        piece.run();
    }
}