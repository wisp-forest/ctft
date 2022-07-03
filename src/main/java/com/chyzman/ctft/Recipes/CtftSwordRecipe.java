package com.chyzman.ctft.Recipes;

import com.chyzman.ctft.Registries.CtftRecipeSerialisers;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CtftSwordRecipe extends ShapedRecipe {


    public CtftSwordRecipe(Identifier id, String group, int width, int height, DefaultedList<Ingredient> input, ItemStack output) {
        super(id, group, width, height, input, output);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        boolean handle = inventory.getStack(4).isOf(Items.STICK) && inventory.getStack(7).isOf(Items.STICK);
        boolean empty = inventory.getStack(3).isEmpty() && inventory.getStack(5).isEmpty() && inventory.getStack(6).isEmpty() && inventory.getStack(8).isEmpty();
        boolean top = inventory.getStack(1).getItem().equals(inventory.getStack(4).getItem());
        return handle && empty && top;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
            if (stack.isEmpty()) continue;

            ItemStack out = new ItemStack(Registry.ITEM.get(new Identifier("ctft", inventory.getStack(1).getItem().toString() + "_sword")));
            out.setCount(1);

            return out;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CtftRecipeSerialisers.CTFT_PICKAXE_RECIPE;
    }

}
