package com.chyzman.ctft.classes;

import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallStandingBlockItem;

public class CustomWallStandingBlockItem extends WallStandingBlockItem {
    public boolean isfoil;
    public CustomWallStandingBlockItem(Block standingBlock, Block wallBlock, boolean isFoil, Settings settings) {
        super(standingBlock, wallBlock, settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
