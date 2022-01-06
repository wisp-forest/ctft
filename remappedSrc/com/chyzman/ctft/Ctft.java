package com.chyzman.ctft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.chyzman.ctft.items.*;

public class Ctft implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger(Ctft.class);
    public static String MODID = "woodentools";

    public static final ItemGroup ctft_swords = FabricItemGroupBuilder.build(
            id("ctft_swords"),
            () -> new ItemStack(Items.WOODEN_SWORD));

    @Override
    public void onInitialize() {
        log("Initialized Mod....");
        SwordInit.INIT();
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    public static void log(String msg){
        LOGGER.info(msg);
    }
}