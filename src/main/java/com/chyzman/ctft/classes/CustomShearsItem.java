package com.chyzman.ctft.classes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.text.Text;
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
        return (Text.translatable("ctft.item.shears_prefix")
                .append(Text.translatable(this.texturetype + ".minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_'))))
                .append(Text.translatable("ctft.item.shears_suffix")));
    }
    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
