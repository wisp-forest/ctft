package com.chyzman.ctft.classes;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class CustomBlockItem extends BlockItem {
    public boolean isfoil;
    public CustomBlockItem(Block block, boolean isFoil, Settings settings) {
        super(block, settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
