package com.chyzman.ctft.util;

import com.chyzman.ctft.Ctft;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import com.chyzman.ctft.Ctft;

public class CtftRegistryHelper {

    public static Identifier id(String path) {
        return new Identifier(Ctft.MODID, path);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String string) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, id(string));
    }

    public static void registerFeature(Identifier identifier, ConfiguredFeature<?, ?> feature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, identifier, feature);
    }
}