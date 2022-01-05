package com.chyzman.ctft.classes;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;

public class CustomBlockItem extends BlockItem {
    public boolean isfoil;
    public String type;
    public String texturetype;

    public CustomBlockItem(Block block, boolean isFoil, String Type, String textureType, Settings settings) {
        super(block, settings);
        isfoil = isFoil;
        type = Type;
        texturetype = textureType;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }
    @Override
    public Text getName(){
        var baseitemname = (Registry.ITEM.getId(this.asItem())).getPath();
        return (new TranslatableText("ctft.item."+ this.type +"_preffix")
                .append(new TranslatableText( this.texturetype + ".minecraft." + baseitemname
                        .substring(0, baseitemname
                                .lastIndexOf('_' + this.type))))
                .append(new TranslatableText("ctft.item."+ this.type +"_suffix")));
    }
    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
