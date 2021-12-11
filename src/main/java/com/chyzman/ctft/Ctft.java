package com.chyzman.ctft;

import com.chyzman.ctft.Blocks.*;
import com.chyzman.ctft.Registries.FuelInit;
import com.chyzman.ctft.classes.CtftItemGroup;
import com.chyzman.ctft.resources.ResourceGenerator;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.chyzman.ctft.Items.*;

public class Ctft implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger(Ctft.class);
    public static String MODID = "ctft";

    public static final OwoItemGroup CTFT = new CtftItemGroup(id("ctft"));
    public static final RuntimeResourcePack CTFT_RESOURCES = RuntimeResourcePack.create("ctft");

    @Override
    public void onInitialize() {
        SwordInit.INIT();
        PickaxeInit.INIT();
        AxeInit.INIT();
        ShovelInit.INIT();
        HoeInit.INIT();
        BowInit.INIT();
        CrossbowInit.INIT();
        HelmetInit.INIT();
        ChestplateInit.INIT();
        LeggingsInit.INIT();
        BootsInit.INIT();
        ShieldInit.INIT();
        ShearInit.INIT();
        FishingRodInit.INIT();
        ClockInit.INIT();
        CompassInit.INIT();
        HorseArmorInit.INIT();
        MiscInit.INIT();
        BlockInit.INIT();
        StairsInit.INIT();
        SlabInit.INIT();
        GlassInit.INIT();
        GlassPaneInit.INIT();
        PaneInit.INIT();
        FenceInit.INIT();
        WallInit.INIT();
        LayerInit.INIT();
        BlockItemInit.INIT();
        StairsItemInit.INIT();
        SlabItemInit.INIT();
        GlassItemInit.INIT();
        GlassPaneItemInit.INIT();
        PaneItemInit.INIT();
        FenceItemInit.INIT();
        WallItemInit.INIT();
        LayerItemInit.INIT();
        ResourceGenerator.INIT();
        FuelInit.INIT();
        CTFT.initialize();
        RRPCallback.BEFORE_VANILLA.register(a -> a.add(CTFT_RESOURCES));
        log("Initialized Mod....");
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    public static void log(String msg){
        LOGGER.info(msg);
    }
}