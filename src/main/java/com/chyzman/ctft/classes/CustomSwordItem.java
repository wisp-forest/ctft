package com.chyzman.ctft.classes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class CustomSwordItem extends SwordItem {
    public boolean isfoil;
    public CustomSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, boolean isFoil, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
 }
