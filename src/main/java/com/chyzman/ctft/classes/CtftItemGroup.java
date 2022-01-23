package com.chyzman.ctft.classes;

import com.chyzman.ctft.Ctft;
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
        if(Ctft.CONFIG.swordsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_sword"))), "swords", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_swords")));
        }
        if(Ctft.CONFIG.pickaxesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pickaxe"))), "pickaxes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_pickaxes")));
        }
        if(Ctft.CONFIG.axesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_axe"))), "axes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_axes")));
        }
        if(Ctft.CONFIG.shovelsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shovel"))), "shovels", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shovels")));
        }
        if(Ctft.CONFIG.hoesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_hoe"))), "hoes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_hoes")));
        }
        if(Ctft.CONFIG.bowsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_bow"))), "bows", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_bows")));
        }
        if(Ctft.CONFIG.crossbowsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_crossbow"))), "crossbows", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_crossbows")));
        }
        if(Ctft.CONFIG.helmetsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_helmet"))), "helmets", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_helmets")));
        }
        if(Ctft.CONFIG.chestplatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_chestplate"))), "chestplates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_chestplates")));
        }
        if(Ctft.CONFIG.leggingsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_leggings"))), "leggings", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_leggings")));
        }
        if(Ctft.CONFIG.bootsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_boots"))), "boots", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_boots")));
        }
        if(Ctft.CONFIG.shieldsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shield"))), "shields", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shields")));
        }
        if(Ctft.CONFIG.shearsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shears"))), "shears", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shears")));
        }
        if(Ctft.CONFIG.fishingRodsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fishing_rod"))), "fishing_rods", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fishing_rods")));
        }
        if(Ctft.CONFIG.clocksEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_clock"))), "clocks", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_clocks")));
        }
        if(Ctft.CONFIG.compassesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_compass"))), "compasses", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compasses")));
        }
        if(Ctft.CONFIG.horseArmorEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_horse_armor"))), "horsearmor", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_horse_armor")));
        }
        if(Ctft.CONFIG.blocksEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_block"))), "blocks", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_blocks")));
        }
        if(Ctft.CONFIG.stairsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_stairs"))), "stairs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_stairs")));
        }
        if(Ctft.CONFIG.slabsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_slab"))), "slabs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_slabs")));
        }
        if(Ctft.CONFIG.wallsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_wall"))), "walls", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_walls")));
        }
        if(Ctft.CONFIG.fencesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fence"))), "fences", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fences")));
        }
        if(Ctft.CONFIG.fenceGatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fence_gate"))), "fence_gates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fence_gates")));
        }
        if(Ctft.CONFIG.doorsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_door"))), "doors", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_doors")));
        }
        if(Ctft.CONFIG.trapDoorsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_trapdoor"))), "trapdoors", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_trapdoors")));
        }
        if(Ctft.CONFIG.glassEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_glass"))), "glass", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_glass")));
        }
        if(Ctft.CONFIG.glassPanesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_glass_pane"))), "glass_panes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_glass_panes")));
        }
        if(Ctft.CONFIG.panesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pane"))), "panes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_panes")));
        }
        if(Ctft.CONFIG.pressurePlatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pressure_plate"))), "pressure_plates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_pressure_plates")));
        }
        if(Ctft.CONFIG.buttonsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_button"))), "buttons", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_buttons")));
        }
        if(Ctft.CONFIG.leversEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_lever"))), "levers", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_levers")));
        }
        if(Ctft.CONFIG.endRodsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_end_rod"))), "rods", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_end_rods")));
        }
        if(Ctft.CONFIG.signsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_sign"))), "signs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_signs")));
        }
        if(Ctft.CONFIG.torchesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_torch"))), "torches", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_torches")));
        }
        if(Ctft.CONFIG.lanternsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_lantern"))), "lanterns", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_lanterns")));
        }
        if(Ctft.CONFIG.layersEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_layer"))), "layers", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_layers")));
        }
        if(Ctft.CONFIG.laddersEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_ladder"))), "ladders", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_ladders")));
        }
        if(Ctft.CONFIG.chainsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_chain"))), "chains", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_chains")));
        }
        if (Ctft.CONFIG.compressionLevel >= 1) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed1"))), "compressed1", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed1")));
        }
        if (Ctft.CONFIG.compressionLevel >= 2) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed2"))), "compressed2", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed2")));
        }
        if (Ctft.CONFIG.compressionLevel >= 3) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed3"))), "compressed3", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed3")));
        }
        if (Ctft.CONFIG.compressionLevel >= 4) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed4"))), "compressed4", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed4")));
        }
        if (Ctft.CONFIG.compressionLevel >= 5) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed5"))), "compressed5", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed5")));
        }
        if (Ctft.CONFIG.compressionLevel >= 6) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed6"))), "compressed6", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed6")));
        }
        if (Ctft.CONFIG.compressionLevel >= 7) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed7"))), "compressed7", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed7")));
        }
        if (Ctft.CONFIG.compressionLevel >= 8) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed8"))), "compressed8", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed8")));
        }
        if (Ctft.CONFIG.compressionLevel >= 9) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed9"))), "compressed9", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed9")));
        }
        if (Ctft.CONFIG.compressionLevel >= 10) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed10"))), "compressed10", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed10")));
        }
        if (Ctft.CONFIG.compressionLevel >= 11) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed11"))), "compressed11", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed11")));
        }
        if (Ctft.CONFIG.compressionLevel >= 12) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed12"))), "compressed12", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed12")));
        }
        if (Ctft.CONFIG.compressionLevel >= 13) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed13"))), "compressed13", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed13")));
        }
        if (Ctft.CONFIG.compressionLevel >= 14) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed14"))), "compressed14", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed14")));
        }
        if (Ctft.CONFIG.compressionLevel >= 15) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed15"))), "compressed15", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed15")));
        }
        if (Ctft.CONFIG.kcolbsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_kcolb"))), "kcolb", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_kcolbs")));
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