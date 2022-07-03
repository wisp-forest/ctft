package com.chyzman.ctft.classes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;

public class CustomShovelItem extends ShovelItem {
    public boolean isfoil;
    public String texturetype;

    public CustomShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, boolean isFoil, String textureType, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        isfoil = isFoil;
        texturetype = textureType;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }

    @Override
    public Text getName() {
        var baseitemname = (Registry.ITEM.getId(this.asItem())).getPath();
        return (Text.translatable("ctft.item.shovel_prefix")
                .append(Text.translatable(this.texturetype + ".minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_'))))
                .append(Text.translatable("ctft.item.shovel_suffix")));
    }

    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
