package com.chyzman.ctft.util;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import static com.chyzman.ctft.registries.CtftStats.MATERIALS;

public class CtftOverrideHelper {
    public static int getItemBarStep(ItemStack stack) {
        if (stack.getNbt() != null && stack.getNbt().getString("material") != null) {
            var id = Identifier.tryParse(stack.getNbt().getString("material"));
            if (id == null) return 0;
            var material = MATERIALS.get(id);
            if (material == null) return 0;
            return Math.round(13.0F - (float)stack.getDamage() * 13.0F / material.durability);
        }
        return 0;
    }

    public static int getItemBarColor(ItemStack stack) {
        if (stack.getNbt() != null && stack.getNbt().getString("material") != null) {
            var id = Identifier.tryParse(stack.getNbt().getString("material"));
            if (id == null) return 0;
            var material = MATERIALS.get(id);
            if (material == null) return 0;
            float f = Math.max(0.0F, (material.durability - (float)stack.getDamage()) / material.durability);
            return MathHelper.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
        }
        return 0;
    }

    public static float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (stack.getNbt() != null && stack.getNbt().getString("material") != null) {
            var id = Identifier.tryParse(stack.getNbt().getString("material"));
            if (id == null) return 0;
            var material = MATERIALS.get(id);
            if (material == null) return 0;
            return (material.efficiency);
        }
        return 0;
    }
}