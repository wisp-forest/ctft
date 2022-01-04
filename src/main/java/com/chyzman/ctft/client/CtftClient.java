package com.chyzman.ctft.client;

import com.chyzman.ctft.mixin.WorldRendererInvoker;
import com.chyzman.ctft.util.CtftAoeDig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class CtftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WorldRenderEvents.BLOCK_OUTLINE.register((worldRenderContext, blockOutlineContext) -> {
            final MinecraftClient client = MinecraftClient.getInstance();
            if (!CtftAoeDig.canAoeDig(client.player)) {
                return true;
            }

            BlockState blockState;
            for (BlockPos pos : CtftAoeDig.getBlocksToDig(client.player)) {
                blockState = client.world.getBlockState(pos);
                if (!blockState.isAir()) {
                    WorldRendererInvoker.ctft_drawShapeOutline(worldRenderContext.matrixStack(), blockOutlineContext.vertexConsumer(), blockState.getOutlineShape(client.world, pos, ShapeContext.of(blockOutlineContext.entity())), (double) pos.getX() - blockOutlineContext.cameraX(), (double) pos.getY() - blockOutlineContext.cameraY(), (double) pos.getZ() - blockOutlineContext.cameraZ(), 0.0F, 0.0F, 0.0F, 0.4F);
                }
            }
            return true;
        });
    }
}