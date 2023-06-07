package com.chyzman.ctft.client;

import com.chyzman.ctft.recipe.CtftIngredient;
import com.chyzman.ctft.recipe.CtftRecipe;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.crafting.DefaultCraftingDisplay;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Optional;

public class CtftCraftingDisplay extends DefaultCraftingDisplay<CtftRecipe> {
    CtftRecipe recipe;
    public CtftCraftingDisplay(CtftRecipe recipe, ItemStack material) {
        super(recipe.getIngredients().stream().map(ingredient -> ingredient.getCustomIngredient() instanceof CtftIngredient ? EntryIngredients.of(single(material)) : EntryIngredients.ofIngredient(ingredient)).toList(),
                 List.of(EntryIngredients.of(recipe.createOutputStack(material, MinecraftClient.getInstance().world.getRegistryManager()))),
                Optional.of(recipe)
        );
        this.recipe = recipe;
    }

    @Override
    public int getWidth() {
        return recipe.getWidth();
    }

    @Override
    public int getHeight() {
        return recipe.getHeight();
    }

    public static ItemStack single (ItemStack itemStack) {
        itemStack.setCount(1);
        return itemStack;
    }
}