package com.chyzman.ctft.classes;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

public class CustomShearsItem extends ShearsItem {
    public boolean isfoil;
    public String texturetype;
    public CustomShearsItem(boolean isFoil, String textureType, Settings settings) {
        super(settings);
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
        return (new TranslatableText("ctft.item.shears_preffix")
                .append(new TranslatableText(this.texturetype + ".minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_'))))
                .append(new TranslatableText("ctft.item.shears_suffix")));
    }
    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
