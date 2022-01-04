package com.chyzman.ctft;

import com.chyzman.ctft.Blocks.*;
import com.chyzman.ctft.Registries.FuelInit;
import com.chyzman.ctft.classes.CtftItemGroup;
import com.chyzman.ctft.client.*;
import com.chyzman.ctft.resources.ResourceGenerator;
import com.chyzman.ctft.util.CtftAoeDig;
import com.chyzman.ctft.util.CtftCommandHandler;
import com.chyzman.ctft.util.CtftConfig;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.chyzman.ctft.Items.*;

public class Ctft implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger(Ctft.class);
    public static String MODID = "ctft";

    public static CtftConfig CONFIG;

    public static final OwoItemGroup CTFT = new CtftItemGroup(id("ctft"));
    public static final RuntimeResourcePack CTFT_RESOURCES = RuntimeResourcePack.create("ctft");

    @Override
    public void onInitialize() {
        log("Initializing Ctft....");
        AutoConfig.register(CtftConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(CtftConfig.class).getConfig();
        if(CONFIG.tools_config.swordsEnabled){
            ItemInit.genSwords();
            FuelInit.SWORD();
        }
        if(CONFIG.tools_config.pickaxesEnabled){
            ItemInit.genPickaxes();
            FuelInit.PICKAXE();
        }
        if(CONFIG.tools_config.axesEnabled){
            ItemInit.genAxes();
            FuelInit.AXE();
        }
        if(CONFIG.tools_config.shovelsEnabled){
            ItemInit.genShovels();
            FuelInit.SHOVEL();
        }
        if(CONFIG.tools_config.hoesEnabled){
            ItemInit.genHoes();
            FuelInit.HOE();
        }
        if(CONFIG.tools_config.helmetsEnabled){
            ItemInit.genHelmets();
            FuelInit.HELMET();
        }
        if(CONFIG.tools_config.chestplatesEnabled){
            ItemInit.genChestplates();
            FuelInit.CHESTPLATE();
        }
        if(CONFIG.tools_config.leggingsEnabled){
            ItemInit.genLeggings();
            FuelInit.LEGGINGS();
        }
        if(CONFIG.tools_config.bootsEnabled){
            ItemInit.genBoots();
            FuelInit.BOOTS();
        }
        if(CONFIG.tools_config.bowsEnabled){
            ItemInit.genBows();
            FuelInit.BOW();
            CtftBowClient.INIT();
        }
        if(CONFIG.tools_config.crossbowsEnabled){
            ItemInit.genCrossBows();
            FuelInit.CROSSBOW();
            CtftCrossbowClient.INIT();
            CtftCrossbowPullingClient.INIT();
            CtftCrossbowPotionClient.INIT();
            CtftCrossbowArrowClient.INIT();
            CtftCrossbowEggClient.INIT();
            CtftCrossbowEnderPearlClient.INIT();
            CtftCrossbowExperienceBottleClient.INIT();
            CtftCrossbowFireChargeClient.INIT();
            CtftCrossbowFireworkClient.INIT();
            CtftCrossbowSnowballClient.INIT();
            CtftCrossbowTridentClient.INIT();
        }
        if(CONFIG.tools_config.shieldsEnabled){
            ItemInit.genShields();
            FuelInit.SHIELD();
            CtftShieldClient.INIT();
        }
        if(CONFIG.tools_config.shearsEnabled){
            ItemInit.genShears();
            FuelInit.SHEARS();
        }
        if(CONFIG.tools_config.fishingRodsEnabled){
            ItemInit.genFishingRods();
            FuelInit.FISHINGROD();
            CtftFishingRodClient.INIT();
        }
        if(CONFIG.tools_config.clocksEnabled){
            ItemInit.genClocks();
            FuelInit.CLOCK();
            CtftClockClient.INIT();
        }
        if(CONFIG.tools_config.compassesEnabled){
            ItemInit.genCompasses();
            FuelInit.COMPASS();
            CtftCompassClient.INIT();
        }
        if(CONFIG.tools_config.horseArmorEnabled){
            ItemInit.genHorseArmor();
            FuelInit.HORSEARMOR();
        }
        if(CONFIG.tools_config.blocksEnabled){
            BlockInit.INIT();
            ItemInit.genBlocks();
            FuelInit.BLOCK();
        }
        if(CONFIG.tools_config.stairsEnabled){
            StairsInit.INIT();
            ItemInit.genStairs();
            FuelInit.STAIR();
        }
        if(CONFIG.tools_config.slabsEnabled){
            SlabInit.INIT();
            ItemInit.genSlabs();
            FuelInit.SLAB();
        }
        if(CONFIG.tools_config.glassEnabled){
            GlassInit.INIT();
            ItemInit.genGlass();
            FuelInit.GLASS();
            CtftGlassClient.INIT();
        }
        if(CONFIG.tools_config.glassPanesEnabled){
            GlassPaneInit.INIT();
            ItemInit.genGlassPanes();
            FuelInit.GLASSPANE();
            CtftGlassPaneClient.INIT();
        }
        if(CONFIG.tools_config.panesEnabled){
            PaneInit.INIT();
            ItemInit.genpanes();
            FuelInit.PANE();
        }
        if(CONFIG.tools_config.layersEnabled){
            LayerInit.INIT();
            ItemInit.genLayers();
            FuelInit.LAYER();
        }
        if(CONFIG.tools_config.fencesEnabled){
            FenceInit.INIT();
            ItemInit.genFences();
            FuelInit.FENCE();
        }
        if(CONFIG.tools_config.fenceGatesEnabled){
            FenceGateInit.INIT();
            ItemInit.genFenceGates();
            FuelInit.FENCEGATE();
        }
        if(CONFIG.tools_config.wallsEnabled){
            WallInit.INIT();
            ItemInit.genWalls();
            FuelInit.WALL();
        }
        if(CONFIG.tools_config.doorsEnabled){
            DoorInit.INIT();
            ItemInit.genDoors();
            FuelInit.DOOR();
            CtftDoorClient.INIT();
        }
        if(CONFIG.tools_config.trapDoorsEnabled){
            TrapdoorInit.INIT();
            ItemInit.genTrapdoors();
            FuelInit.TRAPDOOR();
            CtftTrapdoorClient.INIT();
        }
        if(CONFIG.tools_config.leversEnabled){
            LeverInit.INIT();
            ItemInit.genLevers();
            FuelInit.LEVER();
        }
        if(CONFIG.tools_config.buttonsEnabled){
            ButtonInit.INIT();
            ItemInit.genButtons();
            FuelInit.BUTTON();
        }
        if(CONFIG.tools_config.pressurePlatesEnabled){
            PressurePlateInit.INIT();
            ItemInit.genPressurePlates();
            FuelInit.PRESSUREPLATE();
        }
        if(CONFIG.tools_config.torchesEnabled){
            TorchInit.INIT();
            WallTorchInit.INIT();
            ItemInit.genLanterns();
            FuelInit.TORCH();
        }
        if(CONFIG.tools_config.lanternsEnabled){
            LanternInit.INIT();
            ItemInit.genLanterns();
            FuelInit.LANTERN();
        }
        if(CONFIG.tools_config.endRodsEnabled){
            EndRodInit.INIT();
            ItemInit.genEndRods();
            FuelInit.ENDROD();
        }
        if(CONFIG.tools_config.signsEnabled){
            SignInit.INIT();
            ItemInit.genSigns();
            FuelInit.SIGN();
        }
        if(CONFIG.tools_config.laddersEnabled){
            LadderInit.INIT();
            ItemInit.genLadders();
            FuelInit.LADDER();
        }
        if(CONFIG.tools_config.chainsEnabled){
            ChainInit.INIT();
            ItemInit.genChains();
            FuelInit.CHAIN();
            CtftChainClient.INIT();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 1) {
            Compressed1Init.INIT();
            ItemInit.genCompressed1();
            FuelInit.COMPRESSED1();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 2) {
            Compressed2Init.INIT();
            ItemInit.genCompressed2();
            FuelInit.COMPRESSED2();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 3) {
            Compressed3Init.INIT();
            ItemInit.genCompressed3();
            FuelInit.COMPRESSED3();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 4) {
            Compressed4Init.INIT();
            ItemInit.genCompressed4();
            FuelInit.COMPRESSED4();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 5) {
            Compressed5Init.INIT();
            ItemInit.genCompressed5();
            FuelInit.COMPRESSED5();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 6) {
            Compressed6Init.INIT();
            ItemInit.genCompressed6();
            FuelInit.COMPRESSED6();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 7) {
            Compressed7Init.INIT();
            ItemInit.genCompressed7();
            FuelInit.COMPRESSED7();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 8) {
            Compressed8Init.INIT();
            ItemInit.genCompressed8();
            FuelInit.COMPRESSED8();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 9) {
            Compressed9Init.INIT();
            ItemInit.genCompressed9();
            FuelInit.COMPRESSED9();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 10) {
            Compressed10Init.INIT();
            ItemInit.genCompressed10();
            FuelInit.COMPRESSED10();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 11) {
            Compressed11Init.INIT();
            ItemInit.genCompressed11();
            FuelInit.COMPRESSED11();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 12) {
            Compressed12Init.INIT();
            ItemInit.genCompressed12();
            FuelInit.COMPRESSED12();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 13) {
            Compressed13Init.INIT();
            ItemInit.genCompressed13();
            FuelInit.COMPRESSED13();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 14) {
            Compressed14Init.INIT();
            ItemInit.genCompressed14();
            FuelInit.COMPRESSED14();
        }
        if (Ctft.CONFIG.tools_config.compressionLevel >= 15) {
            Compressed15Init.INIT();
            ItemInit.genCompressed15();
            FuelInit.COMPRESSED15();
        }
        if (Ctft.CONFIG.tools_config.kcolbsEnabled) {
            KcolbInit.INIT();
            ItemInit.genKcolbs();
            FuelInit.KCOLB();
            CtftKcolbClient.INIT();
        }
        CtftAoeDig.registerCommonEvents();
        MiscInit.INIT();
        CTFT.initialize();
        if(Registry.ITEM.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count() > 10) {
            ResourceGenerator.INIT();
            RRPCallback.BEFORE_VANILLA.register(a -> a.add(CTFT_RESOURCES));
            CommandRegistrationCallback.EVENT.register(CtftCommandHandler::register);
        }
        log("Registered " + (Registry.ITEM.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count()) + " Items");
        log("Registered " + (Registry.BLOCK.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count()) + " Blocks");
        log("Initialized Ctft....");
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    public static void log(String msg){
        LOGGER.info(msg);
    }
}