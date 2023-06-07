package com.chyzman.ctft.client;

import com.chyzman.ctft.recipe.CtftIngredient;
import com.chyzman.ctft.recipe.CtftRecipe;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.architectury.event.EventResult;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.display.DynamicDisplayGenerator;
import me.shedaniel.rei.api.client.view.ViewSearchBuilder;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import me.shedaniel.rei.plugin.common.displays.brewing.BrewingRecipe;
import me.shedaniel.rei.plugin.common.displays.crafting.DefaultCraftingDisplay;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.command.argument.ItemStringReader;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.chyzman.ctft.Ctft.MODID;

public class ReiCompat implements REIClientPlugin {
    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerVisibilityPredicate((category, display) -> {
            if (!category.getCategoryIdentifier().equals(BuiltinPlugin.CRAFTING)) return EventResult.pass();
            var recipe = registry.getDisplayOrigin(display);
            if (recipe instanceof CtftRecipe) {
                return EventResult.interruptFalse();
            }
            return EventResult.pass();
        });
        registry.registerDisplayGenerator(BuiltinPlugin.CRAFTING, new DynamicDisplayGenerator<>() {
            @Override
            public Optional<List<DefaultCraftingDisplay<?>>> getRecipeFor(EntryStack<?> entry) {
                var world = MinecraftClient.getInstance().world;
                var recipeManager = world.getRecipeManager();
                if (entry.castValue() instanceof ItemStack stack && Registries.ITEM.getId(stack.getItem()).getNamespace().equals(MODID)) {
                    return Optional.of((List<DefaultCraftingDisplay<?>>) (Object) recipeManager.listAllOfType(RecipeType.CRAFTING).stream()
                            .filter(craftingRecipe -> craftingRecipe.getOutput(MinecraftClient.getInstance().world.getRegistryManager()).getItem().equals(stack.getItem()))
                            .map(ctftRecipe -> {
                                ItemStringReader.ItemResult result = null;
                                try {
                                    result = ItemStringReader.item(Registries.ITEM.getReadOnlyWrapper(), new StringReader(stack.getNbt().getString("material")));
                                    ItemStack material_stack = new ItemStack(result.item());
                                    material_stack.setNbt(result.nbt());
                                    return new CtftCraftingDisplay((CtftRecipe) ctftRecipe, material_stack);
                                } catch (CommandSyntaxException ignored) {
                                }
                                return null;
                            })
                            .filter(Objects::nonNull)
                            .toList());
                }
                return DynamicDisplayGenerator.super.getRecipeFor(entry);
            }

            @Override
            public Optional<List<DefaultCraftingDisplay<?>>> getUsageFor(EntryStack<?> entry) {
                var world = MinecraftClient.getInstance().world;
                var recipeManager = world.getRecipeManager();
                return Optional.of((List<DefaultCraftingDisplay<?>>) (Object) recipeManager.listAllOfType(RecipeType.CRAFTING).stream()
                        .filter(CtftRecipe.class::isInstance)
                        .map(CtftRecipe.class::cast)
                        .map(ctftRecipe -> new CtftCraftingDisplay(ctftRecipe, entry.castValue()))
                        .toList());
            }
        });
    }
}