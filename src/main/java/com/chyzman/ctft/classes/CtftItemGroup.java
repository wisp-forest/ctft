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
        if(Ctft.CONFIG.tools_config.swordsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_sword"))), "swords", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_swords")));
        }
        if(Ctft.CONFIG.tools_config.pickaxesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pickaxe"))), "pickaxes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_pickaxes")));
        }
        if(Ctft.CONFIG.tools_config.axesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_axe"))), "axes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_axes")));
        }
        if(Ctft.CONFIG.tools_config.shovelsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shovel"))), "shovels", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shovels")));
        }
        if(Ctft.CONFIG.tools_config.hoesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_hoe"))), "hoes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_hoes")));
        }
        if(Ctft.CONFIG.tools_config.bowsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_bow"))), "bows", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_bows")));
        }
        if(Ctft.CONFIG.tools_config.crossbowsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_crossbow"))), "crossbows", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_crossbows")));
        }
        if(Ctft.CONFIG.tools_config.helmetsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_helmet"))), "helmets", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_helmets")));
        }
        if(Ctft.CONFIG.tools_config.chestplatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_chestplate"))), "chestplates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_chestplates")));
        }
        if(Ctft.CONFIG.tools_config.leggingsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_leggings"))), "leggings", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_leggings")));
        }
        if(Ctft.CONFIG.tools_config.bootsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_boots"))), "boots", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_boots")));
        }
        if(Ctft.CONFIG.tools_config.shieldsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shield"))), "shields", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shields")));
        }
        if(Ctft.CONFIG.tools_config.shearsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_shears"))), "shears", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_shears")));
        }
        if(Ctft.CONFIG.tools_config.fishingRodsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fishing_rod"))), "fishing_rods", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fishing_rods")));
        }
        if(Ctft.CONFIG.tools_config.clocksEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_clock"))), "clocks", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_clocks")));
        }
        if(Ctft.CONFIG.tools_config.compassesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_compass"))), "compasses", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compasses")));
        }
        if(Ctft.CONFIG.tools_config.horseArmorEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_horse_armor"))), "horsearmor", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_horse_armor")));
        }
        if(Ctft.CONFIG.tools_config.blocksEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_block"))), "blocks", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_blocks")));
        }
        if(Ctft.CONFIG.tools_config.stairsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_stairs"))), "stairs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_stairs")));
        }
        if(Ctft.CONFIG.tools_config.slabsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_slab"))), "slabs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_slabs")));
        }
        if(Ctft.CONFIG.tools_config.wallsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_wall"))), "walls", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_walls")));
        }
        if(Ctft.CONFIG.tools_config.fencesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fence"))), "fences", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fences")));
        }
        if(Ctft.CONFIG.tools_config.fenceGatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_fence_gate"))), "fence_gates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_fence_gates")));
        }
        if(Ctft.CONFIG.tools_config.doorsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_door"))), "doors", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_doors")));
        }
        if(Ctft.CONFIG.tools_config.trapDoorsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_trapdoor"))), "trapdoors", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_trapdoors")));
        }
        if(Ctft.CONFIG.tools_config.glassEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_glass"))), "glass", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_glass")));
        }
        if(Ctft.CONFIG.tools_config.glassPanesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_glass_pane"))), "glass_panes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_glass_panes")));
        }
        if(Ctft.CONFIG.tools_config.panesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pane"))), "panes", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_panes")));
        }
        if(Ctft.CONFIG.tools_config.pressurePlatesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_pressure_plate"))), "pressure_plates", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_pressure_plates")));
        }
        if(Ctft.CONFIG.tools_config.buttonsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_button"))), "buttons", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_buttons")));
        }
        if(Ctft.CONFIG.tools_config.leversEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_lever"))), "levers", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_levers")));
        }
        if(Ctft.CONFIG.tools_config.endRodsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_end_rod"))), "rods", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_end_rods")));
        }
        if(Ctft.CONFIG.tools_config.signsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_sign"))), "signs", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_signs")));
        }
        if(Ctft.CONFIG.tools_config.torchesEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_torch"))), "torches", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_torches")));
        }
        if(Ctft.CONFIG.tools_config.lanternsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_lantern"))), "lanterns", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_lanterns")));
        }
        if(Ctft.CONFIG.tools_config.layersEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_layer"))), "layers", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_layers")));
        }
        if(Ctft.CONFIG.tools_config.laddersEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft","dirt_ladder"))), "ladders", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_ladders")));
        }
        if(Ctft.CONFIG.tools_config.chainsEnabled) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_chain"))), "chains", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_chains")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 1) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed1"))), "compressed1", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed1")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 2) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed2"))), "compressed2", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed2")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 3) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed3"))), "compressed3", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed3")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 4) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed4"))), "compressed4", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed4")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 5) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed5"))), "compressed5", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed5")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 6) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed6"))), "compressed6", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed6")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 7) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed7"))), "compressed7", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed7")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 8) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed8"))), "compressed8", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed8")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 9) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed9"))), "compressed9", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed9")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 10) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed10"))), "compressed10", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed10")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 11) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed11"))), "compressed11", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed11")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 12) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed12"))), "compressed12", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed12")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 13) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed13"))), "compressed13", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed13")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 14) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed14"))), "compressed14", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed14")));
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 15) {
            this.addTab(Icon.of(Registry.ITEM.get(new Identifier("ctft", "dirt_compressed15"))), "compressed15", TagFactory.ITEM.create(CtftRegistryHelper.id("ctft_compressed15")));
        }

        this.setStackHeight(7);
        this.addButton(ItemGroupButton.github("https://github.com/chyzman/ctft"));
        this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/ctft"));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.ITEM.get(new Identifier("ctft","ctft")));
    }
}