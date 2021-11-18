package com.chyzman.ctft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.chyzman.ctft.init.*;

public class Ctft implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger(Ctft.class);
    public static String MODID = "ctft";

    public static final ItemGroup ctft_swords = FabricItemGroupBuilder.build(
            id("ctft_swords"),
            () -> new ItemStack(Items.WOODEN_SWORD));
    public static final ItemGroup ctft_pickaxes = FabricItemGroupBuilder.build(
            id("ctft_pickaxes"),
            () -> new ItemStack(Items.WOODEN_PICKAXE));
    public static final ItemGroup ctft_axes = FabricItemGroupBuilder.build(
            id("ctft_axes"),
            () -> new ItemStack(Items.WOODEN_AXE));
    public static final ItemGroup ctft_shovels = FabricItemGroupBuilder.build(
            id("ctft_shovels"),
            () -> new ItemStack(Items.WOODEN_SHOVEL));
    public static final ItemGroup ctft_hoes = FabricItemGroupBuilder.build(
            id("ctft_hoes"),
            () -> new ItemStack(Items.WOODEN_HOE));
    public static final ItemGroup ctft_shields = FabricItemGroupBuilder.build(
            id("ctft_shields"),
            () -> new ItemStack(Items.SHIELD));
    public static final ItemGroup ctft_helmets = FabricItemGroupBuilder.build(
            id("ctft_helmets"),
            () -> new ItemStack(Items.LEATHER_HELMET));
    public static final ItemGroup ctft_chestplates = FabricItemGroupBuilder.build(
            id("ctft_chestplates"),
            () -> new ItemStack(Items.LEATHER_CHESTPLATE));
    public static final ItemGroup ctft_leggings = FabricItemGroupBuilder.build(
            id("ctft_leggings"),
            () -> new ItemStack(Items.LEATHER_LEGGINGS));
    public static final ItemGroup ctft_boots = FabricItemGroupBuilder.build(
            id("ctft_boots"),
            () -> new ItemStack(Items.LEATHER_BOOTS));
    public static final ItemGroup ctft_bows = FabricItemGroupBuilder.build(
            id("ctft_bows"),
            () -> new ItemStack(Items.BOW));
    public static final ItemGroup ctft_shears = FabricItemGroupBuilder.build(
            id("ctft_shears"),
            () -> new ItemStack(Items.SHEARS));
    public static final ItemGroup ctft_fishing_rods = FabricItemGroupBuilder.build(
            id("ctft_fishing_rods"),
            () -> new ItemStack(Items.FISHING_ROD));
    public static final ItemGroup ctft_clocks = FabricItemGroupBuilder.build(
            id("ctft_clocks"),
            () -> new ItemStack(Items.CLOCK));
    public static final ItemGroup ctft_compasses = FabricItemGroupBuilder.build(
            id("ctft_compasses"),
            () -> new ItemStack(Items.COMPASS));
    public static final ItemGroup ctft_horse_armor = FabricItemGroupBuilder.build(
            id("ctft_horse_armor"),
            () -> new ItemStack(Items.LEATHER_HORSE_ARMOR));



    @Override
    public void onInitialize() {
        log("Initialized Mod....");
        SwordInit.INIT();
        PickaxeInit.INIT();
        AxeInit.INIT();
        ShovelInit.INIT();
        HoeInit.INIT();
        ShieldInit.INIT();
        HelmetInit.INIT();
        ChestplateInit.INIT();
        LeggingsInit.INIT();
        BootsInit.INIT();
        BowInit.INIT();
        ShearInit.INIT();
        FishingRodInit.INIT();
        ClockInit.INIT();
        CompassInit.INIT();
        HorseArmorInit.INIT();
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    public static void log(String msg){
        LOGGER.info(msg);
    }
}