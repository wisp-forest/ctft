package com.chyzman.ctft.classes;

import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;

public class CustomHorseArmorItem extends HorseArmorItem {
    public boolean isfoil;

    public CustomHorseArmorItem(int bonus, String name, boolean isFoil, Settings settings) {
        super(bonus, name, settings);
        isfoil = isFoil;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
