package com.chyzman.ctft;

import com.chyzman.ctft.classes.CtftItemGroup;
import com.chyzman.ctft.resources.ModelGenerator;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.chyzman.ctft.init.*;

public class Ctft implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger(Ctft.class);
    public static String MODID = "ctft";

    public static final OwoItemGroup CTFT = new CtftItemGroup(id("ctft"));
    public static final RuntimeResourcePack CTFT_RESOURCES = RuntimeResourcePack.create("ctft");

    @Override
    public void onInitialize() {
        log("Initialized Mod....");
        HelmetInit.INIT();
        ChestplateInit.INIT();
        SwordInit.INIT();
        BootsInit.INIT();
        LeggingsInit.INIT();
        ShieldInit.INIT();
        ShearInit.INIT();
        HoeInit.INIT();
        BowInit.INIT();
        ClockInit.INIT();
        FishingRodInit.INIT();
        CompassInit.INIT();
        PickaxeInit.INIT();
        AxeInit.INIT();
        ShovelInit.INIT();
        HorseArmorInit.INIT();
        CrossbowInit.INIT();
        ModelGenerator.INIT();
        CrossbowInit.INIT();
        CTFT.initialize();
        FuelInit.INIT();
        RRPCallback.BEFORE_VANILLA.register(a -> a.add(CTFT_RESOURCES));
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    public static void log(String msg){
        LOGGER.info(msg);
    }
}