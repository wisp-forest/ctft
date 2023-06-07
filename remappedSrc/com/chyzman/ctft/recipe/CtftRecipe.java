package com.chyzman.ctft.recipe;

import com.chyzman.ctft.mixin.ShapedRecipeAccessor;
import com.chyzman.ctft.registries.CtftRecipeSerializers;
import com.chyzman.ctft.registries.CtftRegistry;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;

public class CtftRecipe extends ShapedRecipe {

    static ItemStack ingredient = null;
    static WeakReference<World> world = null;

    public CtftRecipe(
            Identifier id,
            String group,
            CraftingRecipeCategory category,
            int width,
            int height,
            DefaultedList<Ingredient> input,
            ItemStack output
    ) {
        super(id, group, category, width, height, input, output);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CtftRecipeSerializers.CTFT_SHAPED;
    }

    @Override
    public RecipeType<?> getType() {
        return super.getType();
    }

    @Override
    public boolean matches(RecipeInputInventory inventory, World world) {
        CtftRecipe.ingredient = null;
        CtftRecipe.world = new WeakReference<>(world);
        return super.matches(inventory, world);
    }

    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        this.matches(inventory, world.get());
        return createOutputStack(ingredient, registryManager);
    }

    public ItemStack createOutputStack(ItemStack ingredient, DynamicRegistryManager registryManager) {
        ItemStack out = this.getOutput(registryManager).copy();
        var nbt = out.getOrCreateNbt();
        var material = Registries.ITEM.getId(ingredient.getItem()).toString();
        if (ingredient.hasNbt()) {
            material += ingredient.getNbt();
        }
        nbt.putString("material", material);
        nbt.putString("material_type", "item");
        out.setCount(1);
        return out;
    }


    public static class Serializer extends ShapedRecipe.Serializer {
        @Override
        public CtftRecipe read(Identifier identifier, JsonObject jsonObject) {
            final var recipe = super.read(identifier, jsonObject);
            return new CtftRecipe(recipe.getId(), recipe.getGroup(), recipe.getCategory(), recipe.getWidth(), recipe.getHeight(), recipe.getIngredients(), ((ShapedRecipeAccessor) recipe).ctft$getOutput());
        }

        @Override
        public CtftRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
            final var recipe = super.read(identifier, packetByteBuf);
            return new CtftRecipe(recipe.getId(), recipe.getGroup(), recipe.getCategory(), recipe.getWidth(), recipe.getHeight(), recipe.getIngredients(), ((ShapedRecipeAccessor) recipe).ctft$getOutput());
        }
    }

    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }

    @Override
    public boolean showNotification() {
        return false;
    }
}