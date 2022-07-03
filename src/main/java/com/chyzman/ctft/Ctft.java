package com.chyzman.ctft;

import com.chyzman.ctft.Items.MiscInit;
import com.chyzman.ctft.Registries.CtftRecipeSerialisers;
import com.chyzman.ctft.Registries.OmegaReg;
import com.chyzman.ctft.classes.CtftCompressedItemGroup;
import com.chyzman.ctft.classes.CtftItemGroup;
import com.chyzman.ctft.mixin.accessor.BlockEntityTypeAccessor;
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
import net.minecraft.block.Block;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.include.com.google.common.collect.ImmutableSet;

public class Ctft implements ModInitializer {
    public static final RuntimeResourcePack CTFT_RESOURCES = RuntimeResourcePack.create("ctft");
    private static final Logger LOGGER = LogManager.getLogger(Ctft.class);
    public static String MODID = "ctft";
    public static final OwoItemGroup CTFT = new CtftItemGroup(id("ctft"));
    public static final OwoItemGroup CTFTCOMPRESSED = new CtftCompressedItemGroup(id("ctftcompressed"));
    public static CtftConfig CONFIG;

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    public static void log(String msg) {
        LOGGER.info(msg);
    }

    @Override
    public void onInitialize() {
        log("Initializing Ctft....");
        AutoConfig.register(CtftConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(CtftConfig.class).getConfig();
        OmegaReg.INIT();
        CtftAoeDig.registerCommonEvents();
        MiscInit.INIT();
        CTFT.initialize();
        CtftRecipeSerialisers.init();
        if (Ctft.CONFIG.compressionLevel > 0) {
            CTFTCOMPRESSED.initialize();
        }
        if (Registry.ITEM.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count() > 10) {
            RRPCallback.BEFORE_VANILLA.register(a -> a.add(CTFT_RESOURCES));
            CommandRegistrationCallback.EVENT.register(CtftCommandHandler::register);
        }
        var signBlocks = ((BlockEntityTypeAccessor) BlockEntityType.SIGN).ctft$getBlocks();
        signBlocks = ImmutableSet.<Block>builder().addAll(signBlocks).addAll(Registry.BLOCK.stream().filter(block -> (block instanceof SignBlock || block instanceof WallSignBlock) && Registry.BLOCK.getId(block).getNamespace().equals("ctft")).toList()).build();
        ((BlockEntityTypeAccessor) BlockEntityType.SIGN).ctft$setBlocks(signBlocks);
        log("Registered " + (Registry.ITEM.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count()) + " Items");
        log("Registered " + (Registry.BLOCK.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count()) + " Blocks");
        log("Initialized Ctft....");
    }
}