package com.chyzman.ctft.classes;


import blue.endless.jankson.annotation.Nullable;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class CtftIconItem extends Item {
    public CtftIconItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Items Loaded: " + Registry.ITEM.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count()));
        tooltip.add(Text.literal("Blocks Loaded: " + Registry.BLOCK.getIds().stream().filter(id -> id.getNamespace().equals("ctft")).count()));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
