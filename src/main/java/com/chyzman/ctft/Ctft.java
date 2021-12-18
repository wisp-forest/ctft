package com.chyzman.ctft;

import com.chyzman.ctft.Blocks.*;
import com.chyzman.ctft.Registries.FuelInit;
import com.chyzman.ctft.classes.CtftItemGroup;
import com.chyzman.ctft.compat.CtftReiCompat;
import com.chyzman.ctft.resources.ResourceGenerator;
import com.chyzman.ctft.util.CtftCommandHandler;
import com.chyzman.ctft.util.CtftConfig;
import com.chyzman.ctft.util.CtftModMenuCompat;
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
        AutoConfig.register(CtftConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(CtftConfig.class).getConfig();
        if(CONFIG.tools_config.swordsEnabled){
            SwordInit.INIT();
            FuelInit.SWORD();
        }
        if(CONFIG.tools_config.pickaxesEnabled){
            PickaxeInit.INIT();
            FuelInit.PICKAXE();
        }
        if(CONFIG.tools_config.axesEnabled){
            AxeInit.INIT();
            FuelInit.AXE();
        }
        if(CONFIG.tools_config.shovelsEnabled){
            ShovelInit.INIT();
            FuelInit.SHOVEL();
        }
        if(CONFIG.tools_config.hoesEnabled){
            HoeInit.INIT();
            FuelInit.HOE();
        }
        if(CONFIG.tools_config.helmetsEnabled){
            HelmetInit.INIT();
            FuelInit.HELMET();
        }
        if(CONFIG.tools_config.chestplatesEnabled){
            ChestplateInit.INIT();
            FuelInit.CHESTPLATE();
        }
        if(CONFIG.tools_config.leggingsEnabled){
            LeggingsInit.INIT();
            FuelInit.LEGGINGS();
        }
        if(CONFIG.tools_config.bootsEnabled){
            BootsInit.INIT();
            FuelInit.BOOTS();
        }
        if(CONFIG.tools_config.bowsEnabled){
            BowInit.INIT();
            FuelInit.BOW();
        }
        if(CONFIG.tools_config.crossbowsEnabled){
            CrossbowInit.INIT();
            FuelInit.CROSSBOW();
        }
        if(CONFIG.tools_config.shieldsEnabled){
            ShieldInit.INIT();
            FuelInit.SHIELD();
        }
        if(CONFIG.tools_config.shearsEnabled){
            ShearInit.INIT();
            FuelInit.SHEARS();
        }
        if(CONFIG.tools_config.fishingRodsEnabled){
            FishingRodInit.INIT();
            FuelInit.FISHINGROD();
        }
        if(CONFIG.tools_config.clocksEnabled){
            ClockInit.INIT();
            FuelInit.CLOCK();
        }
        if(CONFIG.tools_config.compassesEnabled){
            CompassInit.INIT();
            FuelInit.COMPASS();
        }
        if(CONFIG.tools_config.horseArmorEnabled){
            HorseArmorInit.INIT();
            FuelInit.HORSEARMOR();
        }
        if(CONFIG.tools_config.blocksEnabled){
            BlockInit.INIT();
            BlockItemInit.INIT();
            FuelInit.BLOCK();
        }
        if(CONFIG.tools_config.stairsEnabled){
            StairsInit.INIT();
            StairsItemInit.INIT();
            FuelInit.STAIR();
        }
        if(CONFIG.tools_config.slabsEnabled){
            SlabInit.INIT();
            SlabItemInit.INIT();
            FuelInit.SLAB();
        }
        if(CONFIG.tools_config.glassEnabled){
            GlassInit.INIT();
            GlassItemInit.INIT();
            FuelInit.GLASS();
        }
        if(CONFIG.tools_config.glassPanesEnabled){
            GlassPaneInit.INIT();
            GlassPaneItemInit.INIT();
            FuelInit.GLASSPANE();
        }
        if(CONFIG.tools_config.panesEnabled){
            PaneInit.INIT();
            PaneItemInit.INIT();
            FuelInit.PANE();
        }
        if(CONFIG.tools_config.layersEnabled){
            LayerInit.INIT();
            LayerItemInit.INIT();
            FuelInit.LAYER();
        }
        if(CONFIG.tools_config.fencesEnabled){
            FenceInit.INIT();
            FenceItemInit.INIT();
            FuelInit.FENCE();
        }
        if(CONFIG.tools_config.fenceGatesEnabled){
            FenceGateInit.INIT();
            FenceGateItemInit.INIT();
            FuelInit.FENCEGATE();
        }
        if(CONFIG.tools_config.wallsEnabled){
            WallInit.INIT();
            WallItemInit.INIT();
            FuelInit.WALL();
        }
        if(CONFIG.tools_config.doorsEnabled){
            DoorInit.INIT();
            DoorItemInit.INIT();
            FuelInit.DOOR();
        }
        if(CONFIG.tools_config.trapDoorsEnabled){
            TrapdoorInit.INIT();
            TrapdoorItemInit.INIT();
            FuelInit.TRAPDOOR();
        }
        if(CONFIG.tools_config.leversEnabled){
            LeverInit.INIT();
            LeverItemInit.INIT();
            FuelInit.LEVER();
        }
        if(CONFIG.tools_config.buttonsEnabled){
            ButtonInit.INIT();
            ButtonItemInit.INIT();
            FuelInit.BUTTON();
        }
        if(CONFIG.tools_config.pressurePlatesEnabled){
            PressurePlateInit.INIT();
            PressurePlateItemInit.INIT();
            FuelInit.PRESSUREPLATE();
        }
        if(CONFIG.tools_config.torchesEnabled){
            TorchInit.INIT();
            WallTorchInit.INIT();
            TorchItemInit.INIT();
            FuelInit.TORCH();
        }
        if(CONFIG.tools_config.lanternsEnabled){
            LanternInit.INIT();
            LanternItemInit.INIT();
            FuelInit.LANTERN();
        }
        if(CONFIG.tools_config.endRodsEnabled){
            EndRodInit.INIT();
            EndRodItemInit.INIT();
            FuelInit.ENDROD();
        }
        if(CONFIG.tools_config.signsEnabled){
            SignInit.INIT();
            SignItemInit.INIT();
            FuelInit.SIGN();
        }
        if(CONFIG.tools_config.laddersEnabled){
            LadderInit.INIT();
            LadderItemInit.INIT();
            FuelInit.LADDER();
        }
        MiscInit.INIT();
        CTFT.initialize();
        ResourceGenerator.INIT();
        RRPCallback.BEFORE_VANILLA.register(a -> a.add(CTFT_RESOURCES));
        CommandRegistrationCallback.EVENT.register(CtftCommandHandler::register);
        log("Initialized Ctft....");
        log("Initialized " +(Registry.ITEM.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count()) + " Items");
        log("Initialized " +(Registry.BLOCK.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count()) + " Blocks");
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    public static void log(String msg){
        LOGGER.info(msg);
    }
}