package com.chyzman.ctft.classes;

import com.chyzman.ctft.Items.*;
import com.chyzman.ctft.util.CtftRegistryHelper;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import io.wispforest.owo.itemgroup.Icon;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CtftItemGroup extends OwoItemGroup {

    public CtftItemGroup(Identifier id) {
        super(id);
    }

    @Override
    protected void setup() {
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_sword"))), "swords", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_swords")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pickaxe"))), "pickaxes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_pickaxes")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_axe"))), "axes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_axes")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shovel"))), "shovels", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shovels")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_hoe"))), "hoes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_hoes")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_bow"))), "bows", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_bows")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_crossbow"))), "crossbows", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_crossbows")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_helmet"))), "helmets", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_helmets")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_chestplate"))), "chestplates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_chestplates")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_leggings"))), "leggings", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_leggings")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_boots"))), "boots", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_boots")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shield"))), "shields", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shields")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shears"))), "shears", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shears")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fishing_rod"))), "fishing_rods", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fishing_rods")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_clock"))), "clocks", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_clocks")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_compass"))), "compasses", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compasses")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_horse_armor"))), "horsearmor", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_horse_armor")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_block"))), "blocks", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_blocks")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_stairs"))), "stairs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_stairs")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_slab"))), "slabs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_slabs")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_wall"))), "walls", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_walls")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fence"))), "fences", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fences")));
        this.addTab(Icon.of(Items.OAK_FENCE_GATE), "fence_gates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fence_gates")));
        this.addTab(Icon.of(Items.OAK_DOOR), "doors", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_doors")));
        this.addTab(Icon.of(Items.OAK_TRAPDOOR), "trapdoors", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_trapdoors")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_glass"))), "glass", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_glass")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_glass_pane"))), "glass_panes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_glass_panes")));
        this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pane"))), "panes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_panes")));
        this.addTab(Icon.of(Items.OAK_PRESSURE_PLATE), "pressure_plates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_pressure_plates")));
        this.addTab(Icon.of(Items.OAK_BUTTON), "buttons", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_buttons")));
        this.addTab(Icon.of(Items.LEVER), "levers", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_levers")));
        this.addTab(Icon.of(Items.END_ROD), "rods", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_rods")));
        this.addTab(Icon.of(Items.OAK_SIGN), "signs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_signs")));
        this.addTab(Icon.of(Items.TORCH), "torches", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_torches")));
        this.addTab(Icon.of(Items.LANTERN), "lanterns", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_lanterns")));
        this.addTab(Icon.of(Items.SNOW), "layers", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_layers")));
        this.setStackHeight(7);
        this.addButton(ItemGroupButton.github("https://github.com/chyzman/ctft"));
        this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/ctft"));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.ITEM.get(new Identifier("ctft","ctft")));
    }
}