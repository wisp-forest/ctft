package com.chyzman.ctft.classes;

import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

public class CustomHorseArmorItem extends HorseArmorItem {
    public boolean isfoil;
    public String texturetype;
    public CustomHorseArmorItem(int bonus, String name, boolean isFoil, String textureType, Settings settings) {
        super(bonus, name, settings);
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
        return (new TranslatableText("ctft.item.horse_armor_preffix")
                .append(new TranslatableText(this.texturetype + ".minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_')).substring(0, baseitemname
                                .substring(0, baseitemname
                                        .lastIndexOf('_'))
                                .lastIndexOf('_'))))
                .append(new TranslatableText("ctft.item.horse_armor_suffix")));
    }
    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
