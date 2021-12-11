package com.chyzman.ctft.classes;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ToolMaterial;

public class CustomShearsItem extends ShearsItem {
    public boolean isfoil;
    public CustomShearsItem(boolean isFoil, Settings settings) {
        super(settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
