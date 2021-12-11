package com.chyzman.ctft.classes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomClockItem extends Item {
    public boolean isfoil;
    public CustomClockItem(boolean isFoil, Settings settings) {
        super(settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
