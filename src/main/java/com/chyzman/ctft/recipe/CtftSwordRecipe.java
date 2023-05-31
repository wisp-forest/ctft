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

public class CtftSwordRecipe extends SpecialCraftingRecipe {
    public CtftSwordRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        boolean left_handle = inventory.getStack(6).isOf(Items.STICK);
        boolean mid_handle = inventory.getStack(7).isOf(Items.STICK);
        boolean right_handle = inventory.getStack(8).isOf(Items.STICK);
        boolean left_empty = inventory.getStack(1).isEmpty() && inventory.getStack(2).isEmpty() && inventory.getStack(4).isEmpty() && inventory.getStack(5).isEmpty() && inventory.getStack(7).isEmpty() && inventory.getStack(8).isEmpty();
        boolean mid_empty = inventory.getStack(0).isEmpty() && inventory.getStack(2).isEmpty() && inventory.getStack(3).isEmpty() && inventory.getStack(5).isEmpty() && inventory.getStack(6).isEmpty() && inventory.getStack(8).isEmpty();
        boolean right_empty = inventory.getStack(0).isEmpty() && inventory.getStack(1).isEmpty() && inventory.getStack(3).isEmpty() && inventory.getStack(4).isEmpty() && inventory.getStack(6).isEmpty() && inventory.getStack(7).isEmpty();
        boolean left_top = inventory.getStack(0).getItem().equals(inventory.getStack(3).getItem());
        boolean mid_top = inventory.getStack(1).getItem().equals(inventory.getStack(4).getItem());
        boolean right_top = inventory.getStack(2).getItem().equals(inventory.getStack(5).getItem());
        boolean left = left_handle && left_empty && left_top;
        boolean mid = mid_handle && mid_empty && mid_top;
        boolean right = right_handle && right_empty && right_top;
        return left || mid || right;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory, DynamicRegistryManager registryManager) {
        ItemStack out = new ItemStack(CtftRegistry.CTFT_SWORD);
        var nbt = out.getOrCreateNbt();
        nbt.putString("material", Registries.ITEM.getId(!inventory.getStack(0).isEmpty() ? inventory.getStack(0).getItem() : (!inventory.getStack(1).isEmpty() ? inventory.getStack(1).getItem() : inventory.getStack(2).getItem())).toString());
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
        return CtftRecipeSerializers.CTFT_SWORD_RECIPE;
    }

}