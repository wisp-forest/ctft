package com.chyzman.ctft.classes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

public class CustomClockItem extends Item {
    public boolean isfoil;
    public CustomClockItem(boolean isFoil, Settings settings) {
        super(settings);
        isfoil = isFoil;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
    @Override
    public Text getName(){
        var baseitemname = (Registry.ITEM.getId(this.asItem())).getPath();
        return (new TranslatableText("ctft.item.clock_preffix")
                .append(new TranslatableText("item.minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_'))))
                .append(new TranslatableText("ctft.item.clock_suffix")));
    }
    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
