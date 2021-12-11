package com.chyzman.ctft.classes;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class CustomArmorItem extends ArmorItem {
    public  boolean isfoil;
    public CustomArmorItem(ArmorMaterial material, EquipmentSlot slot, boolean isFoil, Settings settings) {
        super(material, slot, settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
}
