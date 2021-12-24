package com.chyzman.ctft.util;

import com.chyzman.ctft.Blocks.*;
import com.chyzman.ctft.Ctft;
import com.chyzman.ctft.Items.*;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "ctft")
@Config.Gui.Background("ctft/icon.png")
public class CtftConfig implements ConfigData {

    public CtftConfig() {
    }

    @ConfigEntry.Gui.CollapsibleObject
    public ToggleTools tools_config = new ToggleTools();

    public static class ToggleTools {

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Swords?")
        public boolean swordsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Pickaxes?")
        public boolean pickaxesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Axes?")
        public boolean axesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Shovels?")
        public boolean shovelsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Hoes?")
        public boolean hoesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Helmets?")
        public boolean helmetsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Chestplates?")
        public boolean chestplatesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Leggings?")
        public boolean leggingsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Boots?")
        public boolean bootsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Bows?")
        public boolean bowsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Crossbows?")
        public boolean crossbowsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Shields?")
        public boolean shieldsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Shears?")
        public boolean shearsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Fishing Rods?")
        public boolean fishingRodsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Clocks?")
        public boolean clocksEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Compasses?")
        public boolean compassesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Horse Armor?")
        public boolean horseArmorEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Blocks?")
        public boolean blocksEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Stairs?")
        public boolean stairsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Slabs?")
        public boolean slabsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Glass?")
        public boolean glassEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Glass Panes?")
        public boolean glassPanesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Panes?")
        public boolean panesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Layers?")
        public boolean layersEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Fences?")
        public boolean fencesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Fence Gates?")
        public boolean fenceGatesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Walls?")
        public boolean wallsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Doors?")
        public boolean doorsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Trapdoors?")
        public boolean trapDoorsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Levers?")
        public boolean leversEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Buttons?")
        public boolean buttonsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Pressure Plates?")
        public boolean pressurePlatesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Torches?")
        public boolean torchesEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Lanterns?")
        public boolean lanternsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load End Rods?")
        public boolean endRodsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Signs?")
        public boolean signsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Ladders?")
        public boolean laddersEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Should Ctft Load Chains?")
        public boolean chainsEnabled = true;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = 0, max = 15)
        @Comment("How Many Layers Of Compression Should Ctft Make?")
        public int compressionLevel = 15;
    }
}