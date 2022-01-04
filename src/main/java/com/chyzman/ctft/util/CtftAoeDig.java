package com.chyzman.ctft.util;

import com.chyzman.ctft.classes.ChyzbladeItem;
import io.wispforest.owo.ops.WorldOps;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class CtftAoeDig {
    static int scopeLevel = 3;
    public static void registerCommonEvents() {
        PlayerBlockBreakEvents.BEFORE.register((world, playerEntity, blockPos, blockState, blockEntity) -> {

            if (!CtftAoeDig.canAoeDig(playerEntity)) return true;

            for (BlockPos pos : CtftAoeDig.getBlocksToDig(playerEntity)) {
                WorldOps.breakBlockWithItem(world, pos, playerEntity.getMainHandStack());

                playerEntity.getMainHandStack().damage(scopeLevel * 2, playerEntity, p -> p.sendToolBreakStatus(Hand.MAIN_HAND));
            }
            return true;
        });
    }

    public static boolean canAoeDig(PlayerEntity player) {
        return player.getMainHandStack().getItem() instanceof ChyzbladeItem;
    }

    public static List<BlockPos> getBlocksToDig(PlayerEntity player) {

        if (!(player.getMainHandStack().getItem() instanceof ChyzbladeItem))
            return new ArrayList<>();

        List<BlockPos> blocksToDig = new ArrayList<>();

        HitResult target = player.raycast(player.getAbilities().creativeMode ? 5.0F : 4.5F, 0, false);
        if (target.getType() != HitResult.Type.BLOCK) return blocksToDig;

        BlockPos hit = ((BlockHitResult) target).getBlockPos();
        BlockPos origin = hit;
        Direction side = ((BlockHitResult) target).getSide();


        if (player.getMainHandStack().getItem().getMiningSpeedMultiplier(player.getMainHandStack(), player.world.getBlockState(hit)) == 1) return blocksToDig;

        switch (side.getAxis()) {
            case X -> {
                hit = hit.add(0, -1 * scopeLevel, -1 * scopeLevel);
                for (int i = 0; i < 1 + 2 * scopeLevel; i++) {
                    for (int j = 0; j < 1 + 2 * scopeLevel; j++) {
                        blocksToDig.add(hit.add(0, i, j));
                    }
                }
            }
            case Y -> {
                hit = hit.add(-1 * scopeLevel, 0, -1 * scopeLevel);
                for (int i = 0; i < 1 + 2 * scopeLevel; i++) {
                    for (int j = 0; j < 1 + 2 * scopeLevel; j++) {
                        blocksToDig.add(hit.add(j, 0, i));
                    }
                }
            }
            case Z -> {
                hit = hit.add(-1 * scopeLevel, -1 * scopeLevel, 0);
                for (int i = 0; i < 1 + 2 * scopeLevel; i++) {
                    for (int j = 0; j < 1 + 2 * scopeLevel; j++) {
                        blocksToDig.add(hit.add(j, i, 0));
                    }
                }
            }
        }

        blocksToDig.removeIf(blockPos -> player.world.getBlockState(blockPos).getHardness(player.world, blockPos) <= 0 || player.getMainHandStack().getItem().getMiningSpeedMultiplier(player.getMainHandStack(), player.world.getBlockState(blockPos)) <= 1);
        blocksToDig.remove(origin);

        return blocksToDig;
    }

}
