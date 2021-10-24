package com.chyzman.ctft;

import java.time.Clock;
import java.util.stream.Collectors;

import com.chyzman.ctft.init.*;

import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ctft")
public class Ctft {
    public static final String modid = "ctft";
    public static final Logger logger = LogManager.getLogger(modid);
    public static final CreativeModeTab ctft_swords = new TabInit.CtftSwords();
    public static final CreativeModeTab ctft_pickaxes = new TabInit.CtftPickaxes();
    public static final CreativeModeTab ctft_axes = new TabInit.CtftAxes();
    public static final CreativeModeTab ctft_shovels = new TabInit.CtftShovels();
    public static final CreativeModeTab ctft_hoes = new TabInit.CtftHoes();
    public static final CreativeModeTab ctft_shears = new TabInit.CtftShears();
    public static final CreativeModeTab ctft_shields = new TabInit.CtftShields();
    public static final CreativeModeTab ctft_fishing_rods = new TabInit.CtftFishingRods();
    public static final CreativeModeTab ctft_clocks = new TabInit.CtftClocks();

    public Ctft() {
        SwordInit.SWORDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        PickaxeInit.PICKAXES.register(FMLJavaModLoadingContext.get().getModEventBus());
        AxeInit.AXES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ShovelInit.SHOVELS.register(FMLJavaModLoadingContext.get().getModEventBus());
        HoeInit.HOES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ShearInit.SHEARS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ShieldInit.SHIELDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FishingRodInit.FISHINGRODS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ClockInit.CLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        logger.info("Ctft common setup");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        logger.info("Ctft client setup");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("ctft", "hello world", () -> {
            logger.info("Ctft has loaded with all Items");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        logger.info("Ctft IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        logger.info("Ctft server setup");
    }
}
