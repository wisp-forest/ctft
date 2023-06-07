package com.chyzman.ctft.registries;

import com.chyzman.ctft.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.chyzman.ctft.util.CtftRegistryHelper.id;

public class CtftRegistry {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, id(name), item);
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, id(name), block);
    }

    public static final Item CTFT_SWORD = registerItem("sword", new CtftSwordItem(new FabricItemSettings()));
    public static final Item CTFT_PICKAXE = registerItem("pickaxe", new CtftPickaxeItem(new FabricItemSettings()));
    public static final Item CTFT_AXE = registerItem("axe", new CtftAxeItem(new FabricItemSettings()));
    public static final Item CTFT_SHOVEL = registerItem("shovel", new CtftShovelItem(new FabricItemSettings()));
    public static final Item CTFT_HOE = registerItem("hoe", new CtftHoeItem(new FabricItemSettings()));
    public static final Item CTFT_SHEARS = registerItem("shears", new CtftShearsItem(new FabricItemSettings()));
    public static final Item CTFT_BRUSH = registerItem("brush", new CtftBrushItem(new FabricItemSettings()));


    public static void Init() {
    }
}