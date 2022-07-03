package com.chyzman.ctft.classes;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;

public class CustomSignItem extends SignItem {
    public boolean isfoil;
    public String texturetype;

    public CustomSignItem(Block block, Block standingblock, boolean isFoil, String textureType, Settings settings) {
        super(settings, block, standingblock);
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
        return (Text.translatable("ctft.item.sign_prefix")
                .append(Text.translatable(this.texturetype + ".minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_'))))
                .append(Text.translatable("ctft.item.sign_suffix")));
    }

    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
