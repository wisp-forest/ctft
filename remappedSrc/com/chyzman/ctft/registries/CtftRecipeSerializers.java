package com.chyzman.ctft.registries;

import com.chyzman.ctft.recipe.*;
import net.fabricmc.fabric.api.recipe.v1.ingredient.CustomIngredientSerializer;
import net.minecraft.recipe.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import javax.management.openmbean.SimpleType;

import static com.chyzman.ctft.util.CtftRegistryHelper.id;

public final class CtftRecipeSerializers {
    public static final RecipeType<CtftRecipe> CTFT = new RecipeType<CtftRecipe>() {
    };

    public static final CtftIngredient.Serializer CTFT_INGREDIENT_SERIALIZER = new CtftIngredient.Serializer();

    public static CtftRecipe.Serializer CTFT_SHAPED = Registry.register(Registries.RECIPE_SERIALIZER, id("crafting_shaped"), new CtftRecipe.Serializer());


    public static void Init() {
        Registry.register(Registries.RECIPE_TYPE, id("ctft"), CTFT);

        CustomIngredientSerializer.register(CTFT_INGREDIENT_SERIALIZER);
    }
}