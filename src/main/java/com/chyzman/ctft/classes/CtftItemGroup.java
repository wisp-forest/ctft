package com.chyzman.ctft.classes;

import com.chyzman.ctft.util.CtftRegistryHelper;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import io.wispforest.owo.itemgroup.Icon;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CtftItemGroup extends OwoItemGroup {

    public CtftItemGroup(Identifier id) {
        super(id);
    }

    @Override
    protected void setup() {
        Icon.of(new Identifier("ctft","icon.png"),0,0,512,512);
        this.addTab(Icon.of(Items.WOODEN_SWORD), "swords", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_swords")));
        this.addTab(Icon.of(Items.WOODEN_PICKAXE), "pickaxes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_pickaxes")));
        this.addTab(Icon.of(Items.WOODEN_AXE), "axes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_axes")));
        this.addTab(Icon.of(Items.WOODEN_SHOVEL), "shovels", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shovels")));
        this.addTab(Icon.of(Items.WOODEN_HOE), "hoes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_hoes")));
        this.addTab(Icon.of(Items.BOW), "bows", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_bows")));
        this.addTab(Icon.of(Items.CROSSBOW), "crossbows", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_crossbows")));
        this.addTab(Icon.of(Items.LEATHER_HELMET), "helmets", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_helmets")));
        this.addTab(Icon.of(Items.LEATHER_CHESTPLATE), "chestplates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_chestplates")));
        this.addTab(Icon.of(Items.LEATHER_LEGGINGS), "leggings", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_leggings")));
        this.addTab(Icon.of(Items.LEATHER_BOOTS), "boots", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_boots")));
        this.addTab(Icon.of(Items.SHIELD), "shields", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shields")));
        this.addTab(Icon.of(Items.SHEARS), "shears", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shears")));
        this.addTab(Icon.of(Items.FISHING_ROD), "fishing_rods", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fishing_rods")));
        this.addTab(Icon.of(Items.CLOCK), "clocks", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_clocks")));
        this.addTab(Icon.of(Items.COMPASS), "compasses", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compasses")));
        this.addTab(Icon.of(Items.LEATHER_HORSE_ARMOR), "horsearmor", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_horse_armor")));
        this.setStackHeight(7);
        this.addButton(ItemGroupButton.github("https://github.com/chyzman/ctft"));
        this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/ctft"));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.ITEM.get(new Identifier("ctft","dirt_pickaxe")));
    }
}