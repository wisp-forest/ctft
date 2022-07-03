package com.chyzman.ctft.classes;

import com.chyzman.ctft.Ctft;
import com.chyzman.ctft.util.CtftRegistryHelper;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CtftCompressedItemGroup extends OwoItemGroup {

    public CtftCompressedItemGroup(Identifier id) {
        super(id);
    }

    @Override
    protected void setup() {
        for(int i = 1; i < 64; i++) {
            if (Ctft.CONFIG.compressionLevel >= i) {
                this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed" + i))), "compressed" + i, TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_compressed" + i)));
            }
        }

        this.keepStaticTitle();
        this.hasScrollbar();
        this.setStackHeight(8);
        this.addButton(ItemGroupButton.github("https://github.com/chyzman/ctft"));
        this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/ctft"));
        this.addButton(ItemGroupButton.modrinth("https://modrinth.com/mod/ctft"));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.ITEM.get(new Identifier("ctft","dirt_compressed1")));
    }
}