package com.chyzman.ctft.recipe;

import com.chyzman.ctft.registries.CtftRecipeSerializers;
import com.chyzman.ctft.registries.CtftRegistry;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CtftPickaxeRecipe extends SpecialCraftingRecipe {
    public CtftPickaxeRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        boolean handle = inventory.getStack(4).isOf(Items.STICK) && inventory.getStack(7).isOf(Items.STICK);
        boolean empty = inventory.getStack(3).isEmpty() && inventory.getStack(5).isEmpty() && inventory.getStack(6).isEmpty() && inventory.getStack(8).isEmpty();
        boolean top = inventory.getStack(0).getItem().equals(inventory.getStack(1).getItem()) && inventory.getStack(0).getItem().equals(inventory.getStack(2).getItem());
        return handle && empty && top;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory, DynamicRegistryManager registryManager) {
        ItemStack out = new ItemStack(CtftRegistry.CTFT_PICKAXE);
        var nbt = out.getOrCreateNbt();
        nbt.putString("material", Registries.ITEM.getId(inventory.getStack(1).getItem()).toString());
        out.setNbt(nbt);
        out.setCount(1);
        return out;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CtftRecipeSerializers.CTFT_PICKAXE_RECIPE;
    }

}