package com.chyzman.ctft.classes;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class CustomAxeItem extends AxeItem {
    public boolean isfoil;
    public CustomAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, boolean isFoil, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
