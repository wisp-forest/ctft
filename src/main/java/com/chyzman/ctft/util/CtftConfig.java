package com.chyzman.ctft.util;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "ctft")
@Config.Gui.Background("ctft:textures/items/ctft.png")
public class CtftConfig implements ConfigData {

    public CtftConfig() {
    }

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Swords?")
    public boolean swordsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Pickaxes?")
    public boolean pickaxesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Axes?")
    public boolean axesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Shovels?")
    public boolean shovelsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Hoes?")
    public boolean hoesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Helmets?")
    public boolean helmetsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Chestplates?")
    public boolean chestplatesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Leggings?")
    public boolean leggingsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Boots?")
    public boolean bootsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Bows?")
    public boolean bowsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Crossbows?")
    public boolean crossbowsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Shields?")
    public boolean shieldsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Shears?")
    public boolean shearsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Fishing Rods?")
    public boolean fishingRodsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Clocks?")
    public boolean clocksEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Compasses?")
    public boolean compassesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Horse Armor?")
    public boolean horseArmorEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Blocks?")
    public boolean blocksEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Stairs?")
    public boolean stairsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Slabs?")
    public boolean slabsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Glass?")
    public boolean glassEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Glass Panes?")
    public boolean glassPanesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Panes?")
    public boolean panesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Layers?")
    public boolean layersEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Fences?")
    public boolean fencesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Fence Gates?")
    public boolean fenceGatesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Walls?")
    public boolean wallsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Doors?")
    public boolean doorsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Trapdoors?")
    public boolean trapDoorsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Levers?")
    public boolean leversEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Buttons?")
    public boolean buttonsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Pressure Plates?")
    public boolean pressurePlatesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Torches?")
    public boolean torchesEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Lanterns?")
    public boolean lanternsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load End Rods?")
    public boolean endRodsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Signs?")
    public boolean signsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Ladders?")
    public boolean laddersEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Chains?")
    public boolean chainsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @Comment("Should Ctft Load Kcolbs?")
    public boolean kcolbsEnabled = true;

    @ConfigEntry.Category("toggletools")
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.BoundedDiscrete(min = 0, max = 63)
    @Comment("How Many Layers Of Compression Should Ctft Make?")
    public int compressionLevel = 63;
}