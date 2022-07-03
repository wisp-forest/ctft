package com.chyzman.ctft.classes;

import com.chyzman.ctft.Ctft;
import com.chyzman.ctft.util.CtftRegistryHelper;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import io.wispforest.owo.itemgroup.Icon;
import net.minecraft.item.*;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CtftItemGroup extends OwoItemGroup {

    public CtftItemGroup(Identifier id) {
        super(id);
    }

    @Override
    protected void setup() {
        if(Ctft.CONFIG.swordsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_sword"))), "swords", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_swords")));
        }
        if(Ctft.CONFIG.pickaxesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pickaxe"))), "pickaxes", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_pickaxes")));
        }
        if(Ctft.CONFIG.axesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_axe"))), "axes", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_axes")));
        }
        if(Ctft.CONFIG.shovelsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shovel"))), "shovels", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_shovels")));
        }
        if(Ctft.CONFIG.hoesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_hoe"))), "hoes", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_hoes")));
        }
        if(Ctft.CONFIG.bowsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_bow"))), "bows", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_bows")));
        }
        if(Ctft.CONFIG.crossbowsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_crossbow"))), "crossbows", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_crossbows")));
        }
        if(Ctft.CONFIG.helmetsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_helmet"))), "helmets", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_helmets")));
        }
        if(Ctft.CONFIG.chestplatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_chestplate"))), "chestplates", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_chestplates")));
        }
        if(Ctft.CONFIG.leggingsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_leggings"))), "leggings", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_leggings")));
        }
        if(Ctft.CONFIG.bootsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_boots"))), "boots", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_boots")));
        }
        if(Ctft.CONFIG.shieldsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shield"))), "shields", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_shields")));
        }
        if(Ctft.CONFIG.shearsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shears"))), "shears", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_shears")));
        }
        if(Ctft.CONFIG.fishingRodsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fishing_rod"))), "fishing_rods", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_fishing_rods")));
        }
        if(Ctft.CONFIG.clocksEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_clock"))), "clocks", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_clocks")));
        }
        if(Ctft.CONFIG.compassesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_compass"))), "compasses", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_compasses")));
        }
        if(Ctft.CONFIG.horseArmorEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_horse_armor"))), "horsearmor", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_horse_armor")));
        }
        if(Ctft.CONFIG.blocksEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_block"))), "blocks", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_blocks")));
        }
        if(Ctft.CONFIG.stairsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_stairs"))), "stairs", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_stairs")));
        }
        if(Ctft.CONFIG.slabsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_slab"))), "slabs", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_slabs")));
        }
        if(Ctft.CONFIG.wallsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_wall"))), "walls", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_walls")));
        }
        if(Ctft.CONFIG.fencesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fence"))), "fences", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_fences")));
        }
        if(Ctft.CONFIG.fenceGatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fence_gate"))), "fence_gates", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_fence_gates")));
        }
        if(Ctft.CONFIG.doorsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_door"))), "doors", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_doors")));
        }
        if(Ctft.CONFIG.trapDoorsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_trapdoor"))), "trapdoors", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_trapdoors")));
        }
        if(Ctft.CONFIG.glassEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_glass"))), "glass", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_glass")));
        }
        if(Ctft.CONFIG.glassPanesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_glass_pane"))), "glass_panes", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_glass_panes")));
        }
        if(Ctft.CONFIG.panesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pane"))), "panes", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_panes")));
        }
        if(Ctft.CONFIG.pressurePlatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pressure_plate"))), "pressure_plates", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_pressure_plates")));
        }
        if(Ctft.CONFIG.buttonsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_button"))), "buttons", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_buttons")));
        }
        if(Ctft.CONFIG.leversEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_lever"))), "levers", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_levers")));
        }
        if(Ctft.CONFIG.endRodsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_end_rod"))), "rods", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_end_rods")));
        }
        if(Ctft.CONFIG.signsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_sign"))), "signs", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_signs")));
        }
        if(Ctft.CONFIG.torchesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_torch"))), "torches", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_torches")));
        }
        if(Ctft.CONFIG.lanternsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_lantern"))), "lanterns", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_lanterns")));
        }
        if(Ctft.CONFIG.layersEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_layer"))), "layers", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_layers")));
        }
        if(Ctft.CONFIG.laddersEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_ladder"))), "ladders", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_ladders")));
        }
        if(Ctft.CONFIG.chainsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_chain"))), "chains", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_chains")));
        }
        if (Ctft.CONFIG.kcolbsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_kcolb"))), "kcolb", TagKey.of(Registry.ITEM_KEY, CtftRegistryHelper.id("ctft_kcolbs")));
        }

        this.keepStaticTitle();
        this.hasScrollbar();
        this.setStackHeight(7);
        this.addButton(ItemGroupButton.github("https://github.com/chyzman/ctft"));
        this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/ctft"));
        this.addButton(ItemGroupButton.modrinth("https://modrinth.com/mod/ctft"));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.ITEM.get(new Identifier("ctft","ctft")));
    }
}