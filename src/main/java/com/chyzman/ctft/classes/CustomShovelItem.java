package com.chyzman.ctft.classes;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class CustomShovelItem extends ShovelItem {
    public boolean isfoil;
    public CustomShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, boolean isFoil, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
