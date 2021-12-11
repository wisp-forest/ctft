package com.chyzman.ctft.classes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class CustomPickaxeItem extends PickaxeItem {
    public boolean isfoil;
    public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, boolean isFoil, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
