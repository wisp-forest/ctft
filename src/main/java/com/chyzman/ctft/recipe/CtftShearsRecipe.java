package com.chyzman.ctft.recipe;

import com.chyzman.ctft.registries.CtftRecipeSerializers;
import com.chyzman.ctft.registries.CtftRegistry;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CtftShearsRecipe extends SpecialCraftingRecipe {
    public CtftShearsRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        var empty = inventory.getStack(0).isEmpty();
        for (int i = 1; i < inventory.size()-(inventory.getWidth()+1); i++) {
            if (inventory.getStack(i).getItem().equals(inventory.getStack(i+(inventory.getWidth()-1)).getItem())) {
                return empty;
            } else if (!inventory.getStack(i).isEmpty()){
                return false;
            }
        }
        return false;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory, DynamicRegistryManager registryManager) {
        ItemStack out = new ItemStack(CtftRegistry.CTFT_SHEARS);
        var nbt = out.getOrCreateNbt();
        for (int i = 1; i < inventory.size()-inventory.getWidth(); i++) {
            if (!inventory.getStack(i).isEmpty()) {
                nbt.putString("material", Registries.ITEM.getId(inventory.getStack(i).getItem()).toString());
                break;
            }
        }
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
        return CtftRecipeSerializers.CTFT_SHEARS_RECIPE;
    }

}