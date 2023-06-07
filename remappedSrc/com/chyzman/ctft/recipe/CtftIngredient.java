package com.chyzman.ctft.recipe;

import com.chyzman.ctft.registries.CtftRecipeSerializers;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.recipe.v1.ingredient.CustomIngredient;
import net.fabricmc.fabric.api.recipe.v1.ingredient.CustomIngredientSerializer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;

import static com.chyzman.ctft.util.CtftRegistryHelper.id;

public class CtftIngredient implements CustomIngredient {
    @Override
    public boolean test(ItemStack stack) {
        if (CtftRecipe.ingredient == null) {
            if (stack.isEmpty()) {
                return false;
            } else {
                CtftRecipe.ingredient = stack.copy();
                return true;
            }
        }
        return ItemStack.canCombine(CtftRecipe.ingredient, stack);
    }

    @Override
    public List<ItemStack> getMatchingStacks() {
        return Registries.ITEM.stream().map(ItemStack::new).toList();
    }

    @Override
    public boolean requiresTesting() {
        return true;
    }

    @Override
    public CustomIngredientSerializer<?> getSerializer() {
        return CtftRecipeSerializers.CTFT_INGREDIENT_SERIALIZER;
    }

    public static class Serializer implements CustomIngredientSerializer<CtftIngredient> {

        @Override
        public Identifier getIdentifier() {
            return id("ctft");
        }

        @Override
        public CtftIngredient read(JsonObject json) {
            return new CtftIngredient();
        }

        @Override
        public void write(JsonObject json, CtftIngredient ingredient) {
        }

        @Override
        public CtftIngredient read(PacketByteBuf buf) {
            return new CtftIngredient();
        }

        @Override
        public void write(PacketByteBuf buf, CtftIngredient ingredient) {
        }
    }
}