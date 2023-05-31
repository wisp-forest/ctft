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

public class CtftHoeRecipe extends SpecialCraftingRecipe {
    public CtftHoeRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        boolean left_handle = inventory.getStack(3).isOf(Items.STICK) && inventory.getStack(4).isEmpty() && inventory.getStack(5).isEmpty() && inventory.getStack(6).isOf(Items.STICK) && inventory.getStack(7).isEmpty() && inventory.getStack(8).isEmpty();
        boolean mid_handle = inventory.getStack(3).isEmpty() && inventory.getStack(4).isOf(Items.STICK) && inventory.getStack(5).isEmpty() && inventory.getStack(6).isEmpty() && inventory.getStack(7).isOf(Items.STICK) && inventory.getStack(8).isEmpty();
        boolean right_handle = inventory.getStack(3).isEmpty() && inventory.getStack(4).isEmpty() && inventory.getStack(5).isOf(Items.STICK) && inventory.getStack(6).isEmpty() && inventory.getStack(7).isEmpty() && inventory.getStack(8).isOf(Items.STICK);

        boolean left_top = inventory.getStack(0).getItem().equals(inventory.getStack(1).getItem()) && inventory.getStack(2).isEmpty();
        boolean right_top = inventory.getStack(1).getItem().equals(inventory.getStack(2).getItem()) && inventory.getStack(0).isEmpty();

        return (left_top && (left_handle || mid_handle)) || (right_top && (right_handle || mid_handle));
    }

    @Override
    public ItemStack craft(CraftingInventory inventory, DynamicRegistryManager registryManager) {
        ItemStack out = new ItemStack(CtftRegistry.CTFT_HOE);
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
        return CtftRecipeSerializers.CTFT_HOE_RECIPE;
    }

}