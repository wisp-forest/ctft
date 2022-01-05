package com.chyzman.ctft.classes;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

public class CustomAxeItem extends AxeItem {
    public boolean isfoil;
    public String texturetype;
    public CustomAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, boolean isFoil, String textureType , Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        isfoil = isFoil;
        texturetype = textureType;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }

    @Override
    public Text getName(){
        var baseitemname = (Registry.ITEM.getId(this.asItem())).getPath();
        return (new TranslatableText("ctft.item.axe_preffix")
                .append(new TranslatableText(this.texturetype + ".minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_'))))
                .append(new TranslatableText("ctft.item.axe_suffix")));
    }
    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
