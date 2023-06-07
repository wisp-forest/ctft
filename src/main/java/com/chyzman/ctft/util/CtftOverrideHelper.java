package com.chyzman.ctft.util;

import com.chyzman.ctft.client.CtftCraftingDisplay;
import com.chyzman.ctft.recipe.CtftRecipe;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.command.argument.ItemStringReader;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.regex.Pattern;

import static com.chyzman.ctft.registries.CtftStats.MATERIALS;

public class CtftOverrideHelper {
    public static Pattern identifier = Pattern.compile("^(?:[a-z0-9_.\\-]+:)?[a-z0-9/._\\-]+");

    public static int getItemBarStep(ItemStack stack) {
        if (stack.getNbt() != null && stack.getNbt().getString("material") != null) {
            if (stack.getNbt().getString("material").equals("random")) {
                return Math.round(13.0F - (float) stack.getDamage() * 13.0F / stack.getMaxDamage());
            }
            var id = Identifier.tryParse(stack.getNbt().getString("material"));
            if (id == null) return 0;
            var material = MATERIALS.get(id);
            if (material == null) return 0;
            return Math.round(13.0F - (float) stack.getDamage() * 13.0F / material.durability);
        }
        return 0;
    }

    public static int getItemBarColor(ItemStack stack) {
        if (stack.getNbt() != null && stack.getNbt().getString("material") != null) {
            if (stack.getNbt().getString("material").equals("random")) {
                float f = Math.max(0.0F, (stack.getMaxDamage() - (float) stack.getDamage()) / stack.getMaxDamage());
                return MathHelper.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
            }
            var id = Identifier.tryParse(stack.getNbt().getString("material"));
            if (id == null) return 0;
            var material = MATERIALS.get(id);
            if (material == null) return 0;
            float f = Math.max(0.0F, (material.durability - (float) stack.getDamage()) / material.durability);
            return MathHelper.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
        }
        return 0;
    }

    public static float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (stack.getNbt() != null && stack.getNbt().getString("material") != null) {
            if (stack.getNbt().getString("material").equals("random")) {
                return new Random().nextInt(100);
            }
            var id = Identifier.tryParse(stack.getNbt().getString("material"));
            if (id == null) return 0;
            var material = MATERIALS.get(id);
            if (material == null) return 0;
            return (stack.getItem().isSuitableFor(state) ? material.efficiency : 1f);
        }
        return 0;
    }

    public static Text getName(ItemStack stack, String key, Function<ItemStack, Text> function) {
        if (stack.getNbt() != null && stack.getNbt().getString("material") != null) {
            var matcher = identifier.matcher(stack.getNbt().getString("material"));
            var id = Identifier.tryParse(matcher.find() ? stack.getNbt().getString("material").substring(matcher.start(), matcher.end()) : stack.getNbt().getString("material"));
            if (stack.getNbt().getString("material").equals("random")) {
                return (Text.translatable(key, Text.literal("random").formatted(Formatting.OBFUSCATED)));
            }
            if (id != null) {
                if (Registries.ITEM.containsId(id)) {
                    try {
                        var result = ItemStringReader.item(Registries.ITEM.getReadOnlyWrapper(), new StringReader(stack.getNbt().getString("material")));
                        return Text.translatable(key, new ItemStackArgument(result.item(), result.nbt()).createStack(1, false).getName());
                    } catch (CommandSyntaxException ignored) {
                    }
                } else if (Registries.BLOCK.containsId(id)) {
                    return Text.translatable(key, Registries.BLOCK.get(id).getName());
                } else if (Registries.ENTITY_TYPE.containsId(id)) {
                    return Text.translatable(key, Registries.ENTITY_TYPE.get(id).getName());
                } else {
                    return Text.translatable(key, "???");
                }
            }
        }
        return function.apply(stack);
    }

    public static void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        ItemStringReader.ItemResult result;
        try {
            result = ItemStringReader.item(Registries.ITEM.getReadOnlyWrapper(), new StringReader(stack.getNbt().getString("material")));
            ItemStack material_stack = new ItemStack(result.item());
            material_stack.setNbt(result.nbt());
            material_stack.addHideFlag(ItemStack.TooltipSection.MODIFIERS);
            var material_tooltip = material_stack.getTooltip(MinecraftClient.getInstance().player, TooltipContext.BASIC);
            if (material_tooltip.size() > 1) {
//                tooltip.add(Text.literal("Material:"));
//                tooltip.add(Text.literal("> ").append(material_tooltip.get(0)));
                material_tooltip.remove(0);
                tooltip.addAll(material_tooltip);
            }
        } catch (CommandSyntaxException ignored) {
        }
    }

    public static Optional<TooltipData> getTooltipData(ItemStack stack) {
        ItemStringReader.ItemResult result;
        try {
            result = ItemStringReader.item(Registries.ITEM.getReadOnlyWrapper(), new StringReader(stack.getNbt().getString("material")));
            ItemStack material_stack = new ItemStack(result.item());
            material_stack.setNbt(result.nbt());
            return material_stack.getTooltipData();
        } catch (CommandSyntaxException ignored) {
        }
        return Optional.empty();
    }
}