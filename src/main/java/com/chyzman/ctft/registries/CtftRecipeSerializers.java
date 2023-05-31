package com.chyzman.ctft.registries;

import com.chyzman.ctft.recipe.*;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.chyzman.ctft.util.CtftRegistryHelper.id;

public final class CtftRecipeSerializers {
    public static final SpecialRecipeSerializer<CtftSwordRecipe> CTFT_SWORD_RECIPE = new SpecialRecipeSerializer<>(CtftSwordRecipe::new);
    public static final SpecialRecipeSerializer<CtftPickaxeRecipe> CTFT_PICKAXE_RECIPE = new SpecialRecipeSerializer<>(CtftPickaxeRecipe::new);
    public static final SpecialRecipeSerializer<CtftAxeRecipe> CTFT_AXE_RECIPE = new SpecialRecipeSerializer<>(CtftAxeRecipe::new);
    public static final SpecialRecipeSerializer<CtftShovelRecipe> CTFT_SHOVEL_RECIPE = new SpecialRecipeSerializer<>(CtftShovelRecipe::new);
    public static final SpecialRecipeSerializer<CtftHoeRecipe> CTFT_HOE_RECIPE = new SpecialRecipeSerializer<>(CtftHoeRecipe::new);

    public static void Init() {
        Registry.register(Registries.RECIPE_SERIALIZER, id("sword"), CTFT_SWORD_RECIPE);
        Registry.register(Registries.RECIPE_SERIALIZER, id("pickaxe"), CTFT_PICKAXE_RECIPE);
        Registry.register(Registries.RECIPE_SERIALIZER, id("axe"), CTFT_AXE_RECIPE);
        Registry.register(Registries.RECIPE_SERIALIZER, id("shovel"), CTFT_SHOVEL_RECIPE);
        Registry.register(Registries.RECIPE_SERIALIZER, id("hoe"), CTFT_HOE_RECIPE);

    }
}