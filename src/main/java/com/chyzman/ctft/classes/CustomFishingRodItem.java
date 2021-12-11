package com.chyzman.ctft.classes;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;

public class CustomFishingRodItem extends FishingRodItem {
    public boolean isfoil;
    public CustomFishingRodItem(boolean isFoil, Settings settings) {
        super(settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
