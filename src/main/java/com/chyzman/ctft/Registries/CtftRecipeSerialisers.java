package com.chyzman.ctft.Registries;

import com.chyzman.ctft.Recipes.CtftPickaxeRecipe;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;

import static com.chyzman.ctft.Ctft.id;

public final class CtftRecipeSerialisers {
    public static final SpecialRecipeSerializer<CtftPickaxeRecipe> CTFT_PICKAXE_RECIPE = new SpecialRecipeSerializer<>(CtftPickaxeRecipe::new);

    public static void init() {
        Registry.register(Registry.RECIPE_SERIALIZER, id("crafting_special_pickaxe"), CTFT_PICKAXE_RECIPE);
    }

}
