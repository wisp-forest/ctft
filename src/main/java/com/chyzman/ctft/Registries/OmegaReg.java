package com.chyzman.ctft.Registries;

import com.chyzman.ctft.Ctft;
import com.chyzman.ctft.classes.*;
import com.chyzman.ctft.mixin.accessor.SignTypeInvoker;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import io.wispforest.owo.util.TagInjector;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.HashSet;
import java.util.List;

import static com.chyzman.ctft.Ctft.id;

public class OmegaReg {
    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, id(name), item);
    }

    private static Block register(String name, Block block) {return Registry.register(Registry.BLOCK, id(name), block);}

    static HashSet<String> piglin_loved = new HashSet<>(List.of("gold_block", "gilded_blackstone", "light_weighted_pressure_plate", "gold_ingot", "bell", "clock", "golden_carrot", "glistering_melon_slice", "golden_apple", "enchanted_golden_apple", "golden_helmet", "golden_chestplate", "golden_leggings", "golden_boots", "golden_horse_armor", "golden_sword", "golden_pickaxe", "golden_shovel", "golden_axe", "golden_hoe", "raw_gold", "raw_gold_block", "gold_ore", "nether_gold_ore", "deepslate_gold_ore"));
    static HashSet<String> freeze_immune_wearables = new HashSet<>(List.of("leather", "leather_chestplate", "leather_chestplate", "leather_leggings", "leather_boots", "leather_horse_armor"));
    static HashSet<String> piglin_repellents = new HashSet<>(List.of("soul_torch", "soul_lantern", "soul_campfire"));

    public static void INIT() {
        CtftStats.MATERIALS.forEach((s, ctftMaterial) -> {
            if (ctftMaterial.namespace.equals("ctft")) {
                ctftMaterial.namespace = "ctft:blocks/" + ctftMaterial.texture_name + "_block";
            }
            if (ctftMaterial.namespace.equals("minecraft")) {
                ctftMaterial.namespace = "minecraft:block/" + ctftMaterial.texture_name;
            }
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/cube_all").textures((JModel.textures().var("all", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + ctftMaterial.recipe_ingredient.toLowerCase() + "_block"));
            Material material = Material.CARPET;
            Item.Settings settings = new Item.Settings().group(ItemGroup.SEARCH).rarity(Rarity.valueOf(ctftMaterial.rarity));
            ToolMaterial toolMaterial = new ConfiguredToolMaterial(ctftMaterial.durability, ctftMaterial.efficiency, ctftMaterial.base_damage, ctftMaterial.tier, ctftMaterial.enchant, Ingredient.ofItems(Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase()))));
            ArmorMaterial armorMaterial = new ConfiguredArmorMaterial(ctftMaterial.durability, ctftMaterial.helmet_protection, ctftMaterial.chestplate_protection, ctftMaterial.leggings_protection, ctftMaterial.boots_protection, ctftMaterial.enchant, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, "ctft/" + ctftMaterial.texture_name, ctftMaterial.armor_toughness, ctftMaterial.armor_knockback_resistance, Ingredient.ofItems(Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase()))));
            settings.maxCount(1);
            if (Ctft.CONFIG.swordsEnabled) {
                int multiplier = 2;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_sword", new CustomSwordItem(toolMaterial, ctftMaterial.sword_damage, ctftMaterial.sword_attack_speed, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/sword").textures((JModel.textures().var("0", "ctft:items/iron_sword").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_sword"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_sword_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2(" 0 ").row3(" 1 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:stick")), JResult.result("ctft:" + id + "_sword")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_swords"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.pickaxesEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_pickaxe", new CustomPickaxeItem(toolMaterial, ctftMaterial.pickaxe_damage, ctftMaterial.pickaxe_attack_speed, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/pickaxe").textures((JModel.textures().var("0", "ctft:items/iron_pickaxe").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_pickaxe"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_pickaxe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:stick")), JResult.result("ctft:" + id + "_pickaxe")));
                TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "cluster_max_harvestables"), item);
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_pickaxes"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.axesEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_axe", new CustomAxeItem(toolMaterial, ctftMaterial.axe_damage, ctftMaterial.axe_attack_speed, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/axe").textures((JModel.textures().var("0", "ctft:items/iron_axe").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_axe"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_axe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("00 ").row2("01 ").row3(" 1 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:stick")), JResult.result("ctft:" + id + "_axe")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_axes"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.shovelsEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_shovel", new CustomShovelItem(toolMaterial, ctftMaterial.shovel_damage, ctftMaterial.shovel_attack_speed, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shovel").textures((JModel.textures().var("0", "ctft:items/iron_shovel").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_shovel"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shovel_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:stick")), JResult.result("ctft:" + id + "_shovel")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_shovels"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.hoesEnabled) {
                int multiplier = 2;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_hoe", new CustomHoeItem(toolMaterial, ctftMaterial.hoe_damage, ctftMaterial.hoe_attack_speed, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/hoe").textures((JModel.textures().var("0", "ctft:items/iron_hoe").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_hoe"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_hoe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("00 ").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:stick")), JResult.result("ctft:" + id + "_hoe")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_hoes"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.helmetsEnabled) {
                int multiplier = 5;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_helmet", new CustomArmorItem(armorMaterial, EquipmentSlot.HEAD, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/helmet").textures((JModel.textures().var("0", "ctft:items/iron_helmet").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_helmet"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_helmet_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("0 0"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_helmet")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_helmets"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.chestplatesEnabled) {
                int multiplier = 8;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_chestplate", new CustomArmorItem(armorMaterial, EquipmentSlot.CHEST, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/chestplate").textures((JModel.textures().var("0", "ctft:items/iron_chestplate").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_chestplate"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_chestplate_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0 0").row2("000").row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_chestplate")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_chestplates"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.leggingsEnabled) {
                int multiplier = 7;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_leggings", new CustomArmorItem(armorMaterial, EquipmentSlot.LEGS, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/leggings").textures((JModel.textures().var("0", "ctft:items/iron_leggings").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_leggings"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_leggings_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2("0 0").row3("0 0"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_leggings")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_leggings"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.bootsEnabled) {
                int multiplier = 4;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_boots", new CustomArmorItem(armorMaterial, EquipmentSlot.FEET, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/boots").textures((JModel.textures().var("0", "ctft:items/iron_boots").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_boots"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_boots_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("0 0").row3("0 0"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_boots")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_boots"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.bowsEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_bow", new CustomBowItem(ctftMaterial.use_duration, ctftMaterial.velocity, ctftMaterial.accuracy_modifier, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow").textures((JModel.textures().var("0", "ctft:items/bow").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace)))
                        .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0), new Identifier("ctft", "item/" + id + "_bow_pulling_0")))
                        .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0).parameter("pull", 0.65), new Identifier("ctft", "item/" + id + "_bow_pulling_1")))
                        .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0).parameter("pull", 0.9), new Identifier("ctft", "item/" + id + "_bow_pulling_2"))), new Identifier("ctft", "item/" + id + "_bow"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_0").textures((JModel.textures().var("0", "ctft:items/bow_pulling_0").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_bow_pulling_0"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_1").textures((JModel.textures().var("0", "ctft:items/bow_pulling_1").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_bow_pulling_1"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_2").textures((JModel.textures().var("0", "ctft:items/bow_pulling_2").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_bow_pulling_2"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_bow_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 01").row2("0 1").row3(" 01"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:string")), JResult.result("ctft:" + id + "_bow")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_bows"), Registry.ITEM.get(new Identifier("ctft", id + "_bow")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.crossbowsEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_crossbow", new CustomCrossbowItem(ctftMaterial.use_duration, ctftMaterial.velocity, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_standby").textures((JModel.textures().var("0", "ctft:items/crossbow_standby").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace)))
                        .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_pulling_0")))
                        .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0).parameter("pull", 0.58), new Identifier("ctft", "item/" + id + "_crossbow_pulling_1")))
                        .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0).parameter("pull", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_pulling_2")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_arrow")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0).parameter("firework", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_firework")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0).parameter("ender_pearl", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_ender_pearl")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0).parameter("potion", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_potion")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0).parameter("experience_bottle", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_experience_bottle")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0).parameter("trident", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_trident")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0).parameter("egg", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_egg")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0).parameter("snowball", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_snowball")))
                        .addOverride(JModel.override(JModel.condition().parameter("charged", 1.0).parameter("fire_charge", 1.0), new Identifier("ctft", "item/" + id + "_crossbow_fire_charge"))), new Identifier("ctft", "item/" + id + "_crossbow"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_0").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_0").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_0"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_1").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_1").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_1"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_2").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_2").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_2"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_arrow").textures((JModel.textures().var("0", "ctft:items/crossbow_arrow").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_arrow"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_firework").textures((JModel.textures().var("0", "ctft:items/crossbow_firework").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_firework"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_ender_pearl").textures((JModel.textures().var("0", "ctft:items/crossbow_ender_pearl").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_ender_pearl"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_potion").textures((JModel.textures().var("0", "ctft:items/crossbow_potion").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_potion"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_experience_bottle").textures((JModel.textures().var("0", "ctft:items/crossbow_experience_bottle").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_experience_bottle"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_trident").textures((JModel.textures().var("0", "ctft:items/crossbow_trident").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_trident"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_egg").textures((JModel.textures().var("0", "ctft:items/crossbow_egg").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_egg"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_snowball").textures((JModel.textures().var("0", "ctft:items/crossbow_snowball").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_snowball"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_fire_charge").textures((JModel.textures().var("0", "ctft:items/crossbow_fire_charge").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_crossbow_fire_charge"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_crossbow_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("020").row2("131").row3(" 0 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:string")).key("2", JIngredient.ingredient().item("minecraft:iron_ingot")).key("3", JIngredient.ingredient().item("minecraft:tripwire_hook")), JResult.result("ctft:" + id + "_crossbow")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_crossbows"), Registry.ITEM.get(new Identifier("ctft", id + "_crossbow")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.shieldsEnabled) {
                int multiplier = 6;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_shield", new CustomShieldItem(ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shield").textures((JModel.textures().var("0", "ctft:items/shield_base").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))).addOverride(JModel.override(JModel.condition().parameter("blocking", 1.0), new Identifier("ctft", "item/" + id + "_shield_blocking"))), new Identifier("ctft", "item/" + id + "_shield"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shield_blocking").textures((JModel.textures().var("0", "ctft:items/shield_base").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_shield_blocking"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shield_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("010").row2("000").row3(" 0 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:iron_ingot")), JResult.result("ctft:" + id + "_shield")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_shields"), Registry.ITEM.get(new Identifier("ctft", id + "_shield")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.shearsEnabled) {
                int multiplier = 2;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_shears", new CustomShearsItem(ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shears").textures((JModel.textures().var("0", "ctft:items/shears").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_shears"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shears_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("0  "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_shears")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_shears"), Registry.ITEM.get(new Identifier("ctft", id + "_shears")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.fishingRodsEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_fishing_rod", new CustomFishingRodItem(ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/fishing_rod").textures((JModel.textures().var("0", "ctft:items/fishing_rod").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))).addOverride(JModel.override(JModel.condition().parameter("cast", 1.0), new Identifier("ctft", "item/" + id + "_fishing_rod_cast"))), new Identifier("ctft", "item/" + id + "_fishing_rod"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/fishing_rod_casting").textures((JModel.textures().var("0", "ctft:items/fishing_rod").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_fishing_rod_cast"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_fishing_rod_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("  0").row2(" 01").row3("0 1"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:string")), JResult.result("ctft:" + id + "_fishing_rod")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_fishing_rods"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            settings.maxDamage(0);
            settings.maxCount(64);
            if (Ctft.CONFIG.clocksEnabled) {
                int multiplier = 4;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_clock", new CustomClockItem(ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_00").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace)))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.0000000), new Identifier("ctft", "item/" + id + "_clock_00")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.0078125), new Identifier("ctft", "item/" + id + "_clock_01")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.0234375), new Identifier("ctft", "item/" + id + "_clock_02")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.0390625), new Identifier("ctft", "item/" + id + "_clock_03")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.0546875), new Identifier("ctft", "item/" + id + "_clock_04")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.0703125), new Identifier("ctft", "item/" + id + "_clock_05")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.0859375), new Identifier("ctft", "item/" + id + "_clock_06")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.1015625), new Identifier("ctft", "item/" + id + "_clock_07")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.1171875), new Identifier("ctft", "item/" + id + "_clock_08")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.1328125), new Identifier("ctft", "item/" + id + "_clock_09")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.1484375), new Identifier("ctft", "item/" + id + "_clock_10")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.1640625), new Identifier("ctft", "item/" + id + "_clock_11")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.1796875), new Identifier("ctft", "item/" + id + "_clock_12")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.1953125), new Identifier("ctft", "item/" + id + "_clock_13")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.2109375), new Identifier("ctft", "item/" + id + "_clock_14")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.2265625), new Identifier("ctft", "item/" + id + "_clock_15")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.2421875), new Identifier("ctft", "item/" + id + "_clock_16")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.2578125), new Identifier("ctft", "item/" + id + "_clock_17")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.2734375), new Identifier("ctft", "item/" + id + "_clock_18")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.2890625), new Identifier("ctft", "item/" + id + "_clock_19")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.3046875), new Identifier("ctft", "item/" + id + "_clock_20")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.3203125), new Identifier("ctft", "item/" + id + "_clock_21")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.3359375), new Identifier("ctft", "item/" + id + "_clock_22")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.3515625), new Identifier("ctft", "item/" + id + "_clock_23")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.3671875), new Identifier("ctft", "item/" + id + "_clock_24")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.3828125), new Identifier("ctft", "item/" + id + "_clock_25")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.3984375), new Identifier("ctft", "item/" + id + "_clock_26")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.4140625), new Identifier("ctft", "item/" + id + "_clock_27")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.4296875), new Identifier("ctft", "item/" + id + "_clock_28")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.4453125), new Identifier("ctft", "item/" + id + "_clock_29")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.4609375), new Identifier("ctft", "item/" + id + "_clock_30")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.4765625), new Identifier("ctft", "item/" + id + "_clock_31")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.4921875), new Identifier("ctft", "item/" + id + "_clock_32")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.5078125), new Identifier("ctft", "item/" + id + "_clock_33")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.5234375), new Identifier("ctft", "item/" + id + "_clock_34")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.5390625), new Identifier("ctft", "item/" + id + "_clock_35")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.5546875), new Identifier("ctft", "item/" + id + "_clock_36")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.5703125), new Identifier("ctft", "item/" + id + "_clock_37")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.5859375), new Identifier("ctft", "item/" + id + "_clock_38")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.6015625), new Identifier("ctft", "item/" + id + "_clock_39")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.6171875), new Identifier("ctft", "item/" + id + "_clock_40")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.6328125), new Identifier("ctft", "item/" + id + "_clock_41")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.6484375), new Identifier("ctft", "item/" + id + "_clock_42")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.6640625), new Identifier("ctft", "item/" + id + "_clock_43")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.6796875), new Identifier("ctft", "item/" + id + "_clock_44")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.6953125), new Identifier("ctft", "item/" + id + "_clock_45")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.7109375), new Identifier("ctft", "item/" + id + "_clock_46")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.7265625), new Identifier("ctft", "item/" + id + "_clock_47")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.7421875), new Identifier("ctft", "item/" + id + "_clock_48")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.7578125), new Identifier("ctft", "item/" + id + "_clock_49")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.7734375), new Identifier("ctft", "item/" + id + "_clock_50")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.7890625), new Identifier("ctft", "item/" + id + "_clock_51")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.8046875), new Identifier("ctft", "item/" + id + "_clock_52")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.8203125), new Identifier("ctft", "item/" + id + "_clock_53")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.8359375), new Identifier("ctft", "item/" + id + "_clock_54")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.8515625), new Identifier("ctft", "item/" + id + "_clock_55")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.8671875), new Identifier("ctft", "item/" + id + "_clock_56")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.8828125), new Identifier("ctft", "item/" + id + "_clock_57")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.8984375), new Identifier("ctft", "item/" + id + "_clock_58")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.9140625), new Identifier("ctft", "item/" + id + "_clock_59")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.9296875), new Identifier("ctft", "item/" + id + "_clock_60")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.9453125), new Identifier("ctft", "item/" + id + "_clock_61")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.9609375), new Identifier("ctft", "item/" + id + "_clock_62")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.9765625), new Identifier("ctft", "item/" + id + "_clock_63")))
                        .addOverride(JModel.override(JModel.condition().parameter("time", 0.9921875), new Identifier("ctft", "item/" + id + "_clock_00"))), new Identifier("ctft", "item/" + id + "_clock"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_00").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_00"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_01").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_01"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_02").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_02"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_03").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_03"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_04").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_04"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_05").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_05"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_06").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_06"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_07").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_07"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_08").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_08"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_09").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_09"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_10").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_10"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_11").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_11"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_12").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_12"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_13").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_13"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_14").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_14"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_15").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_15"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_16").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_16"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_17").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_17"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_18").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_18"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_19").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_19"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_20").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_20"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_21").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_21"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_22").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_22"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_23").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_23"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_24").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_24"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_25").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_25"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_26").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_26"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_27").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_27"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_28").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_28"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_29").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_29"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_30").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_30"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_31").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_31"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_32").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_32"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_33").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_33"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_34").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_34"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_35").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_35"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_36").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_36"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_37").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_37"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_38").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_38"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_39").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_39"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_40").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_40"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_41").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_41"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_42").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_42"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_43").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_43"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_44").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_44"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_45").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_45"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_46").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_46"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_47").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_47"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_48").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_48"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_49").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_49"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_50").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_50"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_51").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_51"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_52").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_52"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_53").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_53"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_54").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_54"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_55").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_55"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_56").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_56"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_57").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_57"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_58").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_58"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_59").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_59"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_60").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_60"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_61").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_61"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_62").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_62"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_63").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_clock_63"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_clock_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("010").row3(" 0 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:gold_ingot")), JResult.result("ctft:" + id + "_clock")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_clocks"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.compassesEnabled) {
                int multiplier = 4;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_compass", new CustomCompassItem(ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_16").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace)))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.000000), new Identifier("ctft", "item/" + id + "_compass_16")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.015625), new Identifier("ctft", "item/" + id + "_compass_17")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.046875), new Identifier("ctft", "item/" + id + "_compass_18")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.078125), new Identifier("ctft", "item/" + id + "_compass_19")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.109375), new Identifier("ctft", "item/" + id + "_compass_20")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.140625), new Identifier("ctft", "item/" + id + "_compass_21")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.171875), new Identifier("ctft", "item/" + id + "_compass_22")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.203125), new Identifier("ctft", "item/" + id + "_compass_23")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.234375), new Identifier("ctft", "item/" + id + "_compass_24")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.265625), new Identifier("ctft", "item/" + id + "_compass_25")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.296875), new Identifier("ctft", "item/" + id + "_compass_26")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.328125), new Identifier("ctft", "item/" + id + "_compass_27")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.359375), new Identifier("ctft", "item/" + id + "_compass_28")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.390625), new Identifier("ctft", "item/" + id + "_compass_29")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.421875), new Identifier("ctft", "item/" + id + "_compass_30")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.453125), new Identifier("ctft", "item/" + id + "_compass_31")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.484375), new Identifier("ctft", "item/" + id + "_compass_00")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.515625), new Identifier("ctft", "item/" + id + "_compass_01")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.546875), new Identifier("ctft", "item/" + id + "_compass_02")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.578125), new Identifier("ctft", "item/" + id + "_compass_03")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.609375), new Identifier("ctft", "item/" + id + "_compass_04")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.640625), new Identifier("ctft", "item/" + id + "_compass_05")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.671875), new Identifier("ctft", "item/" + id + "_compass_06")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.703125), new Identifier("ctft", "item/" + id + "_compass_07")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.734375), new Identifier("ctft", "item/" + id + "_compass_08")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.765625), new Identifier("ctft", "item/" + id + "_compass_09")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.796875), new Identifier("ctft", "item/" + id + "_compass_10")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.828125), new Identifier("ctft", "item/" + id + "_compass_11")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.859375), new Identifier("ctft", "item/" + id + "_compass_12")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.890625), new Identifier("ctft", "item/" + id + "_compass_13")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.921875), new Identifier("ctft", "item/" + id + "_compass_14")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.953125), new Identifier("ctft", "item/" + id + "_compass_15")))
                        .addOverride(JModel.override(JModel.condition().parameter("angle", 0.984375), new Identifier("ctft", "item/" + id + "_compass_16"))), new Identifier("ctft", "item/" + id + "_compass"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_00").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_00"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_01").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_01"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_02").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_02"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_03").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_03"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_04").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_04"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_05").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_05"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_06").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_06"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_07").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_07"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_08").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_08"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_09").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_09"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_10").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_10"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_11").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_11"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_12").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_12"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_13").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_13"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_14").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_14"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_15").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_15"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_16").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_16"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_17").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_17"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_18").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_18"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_19").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_19"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_20").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_20"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_21").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_21"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_22").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_22"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_23").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_23"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_24").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_24"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_25").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_25"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_26").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_26"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_27").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_27"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_28").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_28"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_29").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_29"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_30").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_30"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_31").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_compass_31"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_compass_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("010").row3(" 0 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:iron_ingot")), JResult.result("ctft:" + id + "_compass")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_compasses"), item);
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            settings.maxCount(1);
            if (Ctft.CONFIG.horseArmorEnabled) {
                int multiplier = 6;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_horse_armor", new CustomHorseArmorItem((ctftMaterial.helmet_protection + ctftMaterial.chestplate_protection + ctftMaterial.leggings_protection + ctftMaterial.boots_protection) / 4, "ctft_" + ctftMaterial.texture_name, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/horse_armor").textures((JModel.textures().var("0", "ctft:items/horse_armor").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_horse_armor"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_horse_armor_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("  0").row2("000").row3("0 0"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_horse_armor")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_horse_armor"), Registry.ITEM.get(new Identifier("ctft", id + "_horse_armor")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            settings.maxCount(64);
            if (Ctft.CONFIG.blocksEnabled) {
                int multiplier = 9;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_block", new Block(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_block", new CustomBlockItem(block, ctftMaterial.foil, "block", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("", JState.model("ctft:item/" + id + "_block"))
                ), new Identifier("ctft:" + id + "_block"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_block_from_material"), JRecipe.shaped(JPattern.pattern().row1("000").row2("000").row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_block")));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_material_from_block"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item("ctft:" + id + "_block")), JResult.stackedResult("minecraft:" + id, 9)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_block"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_block"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_blocks"), Registry.ITEM.get(new Identifier("ctft", id + "_block")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.stairsEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_stairs", new CustomStairsBlock(Registry.BLOCK.get(new Identifier("ctft", ctftMaterial.recipe_ingredient.toLowerCase() + "_block")).getDefaultState(), AbstractBlock.Settings.of(material).nonOpaque()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_stairs", new CustomBlockItem(block, ctftMaterial.foil, "stairs", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/stairs").textures((JModel.textures().var("bottom", ctftMaterial.namespace).var("top", ctftMaterial.namespace).var("side", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_stairs"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/inner_stairs").textures((JModel.textures().var("bottom", ctftMaterial.namespace).var("top", ctftMaterial.namespace).var("side", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_stairs_inner"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/outer_stairs").textures((JModel.textures().var("bottom", ctftMaterial.namespace).var("top", ctftMaterial.namespace).var("side", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_stairs_outer"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("facing=east,half=bottom,shape=inner_left", JState.model("ctft:block/" + id + "_stairs_inner").y(270).uvlock())
                        .put("facing=east,half=bottom,shape=inner_right", JState.model("ctft:block/" + id + "_stairs_inner"))
                        .put("facing=east,half=bottom,shape=outer_left", JState.model("ctft:block/" + id + "_stairs_outer").y(270).uvlock())
                        .put("facing=east,half=bottom,shape=outer_right", JState.model("ctft:block/" + id + "_stairs_outer"))
                        .put("facing=east,half=bottom,shape=straight", JState.model("ctft:item/" + id + "_stairs"))
                        .put("facing=east,half=top,shape=inner_left", JState.model("ctft:block/" + id + "_stairs_inner").x(180).uvlock())
                        .put("facing=east,half=top,shape=inner_right", JState.model("ctft:block/" + id + "_stairs_inner").x(180).y(90).uvlock())
                        .put("facing=east,half=top,shape=outer_left", JState.model("ctft:block/" + id + "_stairs_outer").x(180).uvlock())
                        .put("facing=east,half=top,shape=outer_right", JState.model("ctft:block/" + id + "_stairs_outer").x(180).y(90).uvlock())
                        .put("facing=east,half=top,shape=straight", JState.model("ctft:item/" + id + "_stairs").x(180).uvlock())
                        .put("facing=north,half=bottom,shape=inner_left", JState.model("ctft:block/" + id + "_stairs_inner").y(180).uvlock())
                        .put("facing=north,half=bottom,shape=inner_right", JState.model("ctft:block/" + id + "_stairs_inner").y(270).uvlock())
                        .put("facing=north,half=bottom,shape=outer_left", JState.model("ctft:block/" + id + "_stairs_outer").y(180).uvlock())
                        .put("facing=north,half=bottom,shape=outer_right", JState.model("ctft:block/" + id + "_stairs_outer").y(270).uvlock())
                        .put("facing=north,half=bottom,shape=straight", JState.model("ctft:item/" + id + "_stairs").y(270).uvlock())
                        .put("facing=north,half=top,shape=inner_left", JState.model("ctft:block/" + id + "_stairs_inner").x(180).y(270).uvlock())
                        .put("facing=north,half=top,shape=inner_right", JState.model("ctft:block/" + id + "_stairs_inner").x(180).uvlock())
                        .put("facing=north,half=top,shape=outer_left", JState.model("ctft:block/" + id + "_stairs_outer").x(180).y(270).uvlock())
                        .put("facing=north,half=top,shape=outer_right", JState.model("ctft:block/" + id + "_stairs_outer").x(180).uvlock())
                        .put("facing=north,half=top,shape=straight", JState.model("ctft:item/" + id + "_stairs").x(180).y(270).uvlock())
                        .put("facing=south,half=bottom,shape=inner_left", JState.model("ctft:block/" + id + "_stairs_inner"))
                        .put("facing=south,half=bottom,shape=inner_right", JState.model("ctft:block/" + id + "_stairs_inner").y(90).uvlock())
                        .put("facing=south,half=bottom,shape=outer_left", JState.model("ctft:block/" + id + "_stairs_outer"))
                        .put("facing=south,half=bottom,shape=outer_right", JState.model("ctft:block/" + id + "_stairs_outer").y(90).uvlock())
                        .put("facing=south,half=bottom,shape=straight", JState.model("ctft:item/" + id + "_stairs").y(90).uvlock())
                        .put("facing=south,half=top,shape=inner_left", JState.model("ctft:block/" + id + "_stairs_inner").x(180).y(90).uvlock())
                        .put("facing=south,half=top,shape=inner_right", JState.model("ctft:block/" + id + "_stairs_inner").x(180).y(180).uvlock())
                        .put("facing=south,half=top,shape=outer_left", JState.model("ctft:block/" + id + "_stairs_outer").x(180).y(90).uvlock())
                        .put("facing=south,half=top,shape=outer_right", JState.model("ctft:block/" + id + "_stairs_outer").x(180).y(180).uvlock())
                        .put("facing=south,half=top,shape=straight", JState.model("ctft:item/" + id + "_stairs").x(180).y(90).uvlock())
                        .put("facing=west,half=bottom,shape=inner_left", JState.model("ctft:block/" + id + "_stairs_inner").y(90).uvlock())
                        .put("facing=west,half=bottom,shape=inner_right", JState.model("ctft:block/" + id + "_stairs_inner").y(180).uvlock())
                        .put("facing=west,half=bottom,shape=outer_left", JState.model("ctft:block/" + id + "_stairs_outer").y(90).uvlock())
                        .put("facing=west,half=bottom,shape=outer_right", JState.model("ctft:block/" + id + "_stairs_outer").y(180).uvlock())
                        .put("facing=west,half=bottom,shape=straight", JState.model("ctft:item/" + id + "_stairs").y(180).uvlock())
                        .put("facing=west,half=top,shape=inner_left", JState.model("ctft:block/" + id + "_stairs_inner").x(180).y(180).uvlock())
                        .put("facing=west,half=top,shape=inner_right", JState.model("ctft:block/" + id + "_stairs_inner").x(180).y(270).uvlock())
                        .put("facing=west,half=top,shape=outer_left", JState.model("ctft:block/" + id + "_stairs_outer").x(180).y(180).uvlock())
                        .put("facing=west,half=top,shape=outer_right", JState.model("ctft:block/" + id + "_stairs_outer").x(180).y(270).uvlock())
                        .put("facing=west,half=top,shape=straight", JState.model("ctft:item/" + id + "_stairs").x(180).y(180).uvlock())
                ), new Identifier("ctft:" + id + "_stairs"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_stairs_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0  ").row2("00 ").row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.stackedResult("ctft:" + id + "_stairs", 4)));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_stairs_from_stonecutter"), JRecipe.stonecutting(JIngredient.ingredient().item("ctft:" + id + "_block"), JResult.stackedResult("ctft:" + id + "_stairs", 1)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_stairs"), JLootTable
                        .loot("block")
                        .pool(JLootTable
                                .pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_stairs"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_stairs"), Registry.ITEM.get(new Identifier("ctft", id + "_stairs")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.slabsEnabled) {
                int multiplier = 4;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_slab", new SlabBlock(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_slab", new CustomBlockItem(block, ctftMaterial.foil, "slab", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/slab").textures((JModel.textures().var("bottom", ctftMaterial.namespace).var("top", ctftMaterial.namespace).var("side", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_slab"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/slab_top").textures((JModel.textures().var("bottom", ctftMaterial.namespace).var("top", ctftMaterial.namespace).var("side", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_slab_top"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("type=bottom", JState.model("ctft:item/" + id + "_slab"))
                        .put("type=double", JState.model("ctft:item/" + id + "_block"))
                        .put("type=top", JState.model("ctft:block/" + id + "_slab_top"))
                ), new Identifier("ctft:" + id + "_slab"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_slab_from_crafting"), JRecipe.shaped(JPattern.pattern().row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("ctft:" + id + "_block")), JResult.stackedResult("ctft:" + id + "_slab", 6)));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_slab_from_stonecutter"), JRecipe.stonecutting(JIngredient.ingredient().item("minecraft:" + id), JResult.stackedResult("ctft:" + id + "_slab", 2)));
                var doubleslab = new JsonObject();
                doubleslab.addProperty("type", "double");
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_slab"), JLootTable
                        .loot("block")
                        .pool(JLootTable
                                .pool()
                                .rolls(1)
                                .entry(JLootTable.entry()
                                        .type("minecraft:item")
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_slab")
                                                        .parameter("properties", doubleslab)
                                                ).parameter("count", 2)
                                                .parameter("add", false)
                                        )
                                        .name("ctft:" + id + "_slab")
                                        .function(JLootTable
                                                .function("minecraft:explosion_decay")
                                        )
                                )
                        )
                );
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_slabs"), Registry.ITEM.get(new Identifier("ctft", id + "_slab")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.glassEnabled) {
                int multiplier = 9;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_glass", new GlassBlock(AbstractBlock.Settings.of(material).nonOpaque()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_glass", new CustomBlockItem(block, ctftMaterial.foil, "glass", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/cube_all").textures((JModel.textures().var("all", "ctft:blocks/" + ctftMaterial.texture_name + "_glass").particle("ctft:blocks/" + ctftMaterial.texture_name + "_glass"))), new Identifier("ctft", "item/" + id + "_glass"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("", JState.model("ctft:item/" + id + "_glass"))
                ), new Identifier("ctft:" + id + "_glass"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_glass_from_smelting"), JRecipe.smelting(JIngredient.ingredient().item("ctft:" + id + "_block"), JResult.result("ctft:" + id + "_glass")).cookingTime(200).experience(0.1f));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_glass"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_glass"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_glass"), Registry.ITEM.get(new Identifier("ctft", id + "_glass")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.glassPanesEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_glass_pane", new CustomPaneBlock(Registry.BLOCK.get(new Identifier("ctft", ctftMaterial.recipe_ingredient.toLowerCase() + "_block")).getDefaultState(), AbstractBlock.Settings.of(material).nonOpaque()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_glass_pane", new CustomBlockItem(block, ctftMaterial.foil, "glass_pane", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:item/generated").textures(JModel.textures().layer0("ctft:blocks/" + ctftMaterial.texture_name + "_glass").particle("ctft:blocks/" + ctftMaterial.texture_name + "_glass")), new Identifier("ctft", "item/" + id + "_glass_pane"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside").textures((JModel.textures().var("pane", "ctft:blocks/" + ctftMaterial.texture_name + "_glass").particle("ctft:blocks/" + ctftMaterial.texture_name + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_noside"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside_alt").textures((JModel.textures().var("pane", "ctft:blocks/" + ctftMaterial.texture_name + "_glass").particle("ctft:blocks/" + ctftMaterial.texture_name + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_noside_alt"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_post").textures((JModel.textures().var("pane", "ctft:blocks/" + ctftMaterial.texture_name + "_glass").var("edge", ctftMaterial.namespace).particle("ctft:blocks/" + ctftMaterial.texture_name + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_post"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side").textures((JModel.textures().var("pane", "ctft:blocks/" + ctftMaterial.texture_name + "_glass").var("edge", ctftMaterial.namespace).particle("ctft:blocks/" + ctftMaterial.texture_name + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_side"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side_alt").textures((JModel.textures().var("pane", "ctft:blocks/" + ctftMaterial.texture_name + "_glass").var("edge", ctftMaterial.namespace).particle("ctft:blocks/" + ctftMaterial.texture_name + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_side_alt"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_post")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_side")).when(JState.when().add("north", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_side").y(90)).when(JState.when().add("east", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_side_alt")).when(JState.when().add("south", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_side_alt").y(90)).when(JState.when().add("west", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_noside")).when(JState.when().add("north", "false")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_noside_alt")).when(JState.when().add("east", "false")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_noside_alt").y(90)).when(JState.when().add("south", "false")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_glass_pane_noside").y(270)).when(JState.when().add("west", "false")))
                        , new Identifier("ctft:" + id + "_glass_pane"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_glass_pane_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("ctft:" + id + "_glass")), JResult.stackedResult("ctft:" + id + "_glass_pane", 16)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_glass_pane"), JLootTable
                        .loot("block")
                        .pool(JLootTable
                                .pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_glass_pane"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_glass_panes"), Registry.ITEM.get(new Identifier("ctft", id + "_glass_pane")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.panesEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_pane", new CustomPaneBlock(Registry.BLOCK.get(new Identifier("ctft", ctftMaterial.recipe_ingredient.toLowerCase() + "_block")).getDefaultState(), AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_pane", new CustomBlockItem(block, ctftMaterial.foil, "pane", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:item/generated").textures(JModel.textures().layer0(ctftMaterial.namespace).particle(ctftMaterial.namespace)), new Identifier("ctft", "item/" + id + "_pane"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside").textures((JModel.textures().var("pane", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_pane_noside"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside_alt").textures((JModel.textures().var("pane", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_pane_noside_alt"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_post").textures((JModel.textures().var("pane", ctftMaterial.namespace).var("edge", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_pane_post"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side").textures((JModel.textures().var("pane", ctftMaterial.namespace).var("edge", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_pane_side"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side_alt").textures((JModel.textures().var("pane", ctftMaterial.namespace).var("edge", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_pane_side_alt"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_post")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_side")).when(JState.when().add("north", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_side").y(90)).when(JState.when().add("east", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_side_alt")).when(JState.when().add("south", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_side_alt").y(90)).when(JState.when().add("west", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_noside")).when(JState.when().add("north", "false")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_noside_alt")).when(JState.when().add("east", "false")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_noside_alt").y(90)).when(JState.when().add("south", "false")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_pane_noside").y(270)).when(JState.when().add("west", "false")))
                        , new Identifier("ctft:" + id + "_pane"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_pane_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("ctft:" + id + "_block")), JResult.stackedResult("ctft:" + id + "_pane", 16)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_pane"), JLootTable
                        .loot("block")
                        .pool(JLootTable
                                .pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_pane"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_panes"), Registry.ITEM.get(new Identifier("ctft", id + "_pane")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.layersEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_layer", new CustomSnowBlock(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_layer", new CustomBlockItem(block, ctftMaterial.foil, "layer", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height2").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_layer"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height4").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_layer_height4"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height6").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_layer_height6"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height8").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_layer_height8"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height10").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_layer_height10"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height12").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_layer_height12"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height14").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_layer_height14"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("layers=1", JState.model("ctft:item/" + id + "_layer"))
                        .put("layers=2", JState.model("ctft:block/" + id + "_layer_height4"))
                        .put("layers=3", JState.model("ctft:block/" + id + "_layer_height6"))
                        .put("layers=4", JState.model("ctft:block/" + id + "_layer_height8"))
                        .put("layers=5", JState.model("ctft:block/" + id + "_layer_height10"))
                        .put("layers=6", JState.model("ctft:block/" + id + "_layer_height12"))
                        .put("layers=7", JState.model("ctft:block/" + id + "_layer_height14"))
                        .put("layers=8", JState.model("ctft:item/" + id + "_block"))
                ), new Identifier("ctft:" + id + "_layer"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_layer_from_crafting"), JRecipe.shaped(JPattern.pattern().row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("ctft:" + id + "_slab")), JResult.stackedResult("ctft:" + id + "_layer", 12)));
                var layer2 = new JsonObject();
                var layer3 = new JsonObject();
                var layer4 = new JsonObject();
                var layer5 = new JsonObject();
                var layer6 = new JsonObject();
                var layer7 = new JsonObject();
                var layer8 = new JsonObject();
                layer2.addProperty("layers", "2");
                layer3.addProperty("layers", "3");
                layer4.addProperty("layers", "4");
                layer5.addProperty("layers", "5");
                layer6.addProperty("layers", "6");
                layer7.addProperty("layers", "7");
                layer8.addProperty("layers", "8");
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_layer"), JLootTable
                        .loot("block")
                        .pool(JLootTable
                                .pool()
                                .rolls(1)
                                .entry(JLootTable.entry()
                                        .type("minecraft:item")
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_layer")
                                                        .parameter("properties", layer2)
                                                ).parameter("count", 2)
                                                .parameter("add", false)
                                        )
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_layer")
                                                        .parameter("properties", layer3)
                                                ).parameter("count", 3)
                                                .parameter("add", false)
                                        )
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_layer")
                                                        .parameter("properties", layer4)
                                                ).parameter("count", 4)
                                                .parameter("add", false)
                                        )
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_layer")
                                                        .parameter("properties", layer5)
                                                ).parameter("count", 5)
                                                .parameter("add", false)
                                        )
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_layer")
                                                        .parameter("properties", layer6)
                                                ).parameter("count", 6)
                                                .parameter("add", false)
                                        )
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_layer")
                                                        .parameter("properties", layer7)
                                                ).parameter("count", 7)
                                                .parameter("add", false)
                                        )
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_layer")
                                                        .parameter("properties", layer8)
                                                ).parameter("count", 8)
                                                .parameter("add", false)
                                        )
                                        .name("ctft:" + id + "_layer")
                                        .function(JLootTable
                                                .function("minecraft:explosion_decay")
                                        )
                                )
                        )
                );
                if (Ctft.CONFIG.slabsEnabled) {
//                    Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_slab_from_layer"), JRecipe.shaped(JPattern.pattern().row2(" 00").row3(" 00"), JKeys.keys().key("0", JIngredient.ingredient().item("ctft:" + id + "_layer")), JResult.stackedResult("ctft:" + id + "_slab", 1)));
                }
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_layers"), Registry.ITEM.get(new Identifier("ctft", id + "_layer")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.fencesEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_fence", new FenceBlock(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_fence", new CustomBlockItem(block, ctftMaterial.foil, "fence", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_inventory").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_fence"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_post").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_fence_post"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_side").textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_fence_side"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_post")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_side")).when(JState.when().add("north", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_side").y(90)).when(JState.when().add("east", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_side").y(180)).when(JState.when().add("south", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_side").y(270)).when(JState.when().add("west", "true")))
                        , new Identifier("ctft:" + id + "_fence"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_fence_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("010").row3("010"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:stick")), JResult.stackedResult("ctft:" + id + "_fence", 3)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_fence"), JLootTable
                        .loot("block")
                        .pool(JLootTable
                                .pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_fence"))));
                TagInjector.inject(Registry.BLOCK, new Identifier("minecraft", "fences"), Registry.BLOCK.get(new Identifier("ctft", id + "_fence")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_fences"), Registry.ITEM.get(new Identifier("ctft", id + "_fence")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.fenceGatesEnabled) {
                int multiplier = 2;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_fence_gate", new FenceGateBlock(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_fence_gate", new CustomBlockItem(block, ctftMaterial.foil, "fence_gate", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_fence_gate").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_fence_gate"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_fence_gate_open").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_fence_gate_open"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_fence_gate_wall").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_fence_gate_wall_close"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_fence_gate_wall_open").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_fence_gate_wall_open"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("facing=east,in_wall=false,open=false", JState.model("ctft:item/" + id + "_fence_gate").uvlock().y(270))
                        .put("facing=east,in_wall=false,open=true", JState.model("ctft:block/" + id + "_fence_gate_open").uvlock().y(270))
                        .put("facing=east,in_wall=true,open=false", JState.model("ctft:block/" + id + "_fence_gate_wall_close").uvlock().y(270))
                        .put("facing=east,in_wall=true,open=true", JState.model("ctft:block/" + id + "_fence_gate_wall_open").uvlock().y(270))
                        .put("facing=north,in_wall=false,open=false", JState.model("ctft:item/" + id + "_fence_gate").uvlock().y(180))
                        .put("facing=north,in_wall=false,open=true", JState.model("ctft:block/" + id + "_fence_gate_open").uvlock().y(180))
                        .put("facing=north,in_wall=true,open=false", JState.model("ctft:block/" + id + "_fence_gate_wall_close").uvlock().y(180))
                        .put("facing=north,in_wall=true,open=true", JState.model("ctft:block/" + id + "_fence_gate_wall_open").uvlock().y(180))
                        .put("facing=south,in_wall=false,open=false", JState.model("ctft:item/" + id + "_fence_gate").uvlock())
                        .put("facing=south,in_wall=false,open=true", JState.model("ctft:block/" + id + "_fence_gate_open").uvlock())
                        .put("facing=south,in_wall=true,open=false", JState.model("ctft:block/" + id + "_fence_gate_wall_close").uvlock())
                        .put("facing=south,in_wall=true,open=true", JState.model("ctft:block/" + id + "_fence_gate_wall_open").uvlock())
                        .put("facing=west,in_wall=false,open=false", JState.model("ctft:item/" + id + "_fence_gate").uvlock().y(90))
                        .put("facing=west,in_wall=false,open=true", JState.model("ctft:block/" + id + "_fence_gate_open").uvlock().y(90))
                        .put("facing=west,in_wall=true,open=false", JState.model("ctft:block/" + id + "_fence_gate_wall_close").uvlock().y(90))
                        .put("facing=west,in_wall=true,open=true", JState.model("ctft:block/" + id + "_fence_gate_wall_open").uvlock().y(90))
                ), new Identifier("ctft:" + id + "_fence_gate"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_fence_gate_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("101").row3("101"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:stick")), JResult.result("ctft:" + id + "_fence_gate")));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_fence_gate"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_fence_gate"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_fence_gates"), Registry.ITEM.get(new Identifier("ctft", id + "_fence_gate")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.wallsEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_wall", new WallBlock(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_wall", new CustomBlockItem(block, ctftMaterial.foil, "wall", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/wall_inventory").textures((JModel.textures().var("wall", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_wall"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_post").textures((JModel.textures().var("wall", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_wall_post"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_side").textures((JModel.textures().var("wall", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_wall_side"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_side_tall").textures((JModel.textures().var("wall", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_wall_side_tall"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_post")).when(JState.when().add("up", "true")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_side").uvlock()).when(JState.when().add("north", "low")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_side").y(90).uvlock()).when(JState.when().add("east", "low")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_side").y(180).uvlock()).when(JState.when().add("south", "low")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_side").y(270).uvlock()).when(JState.when().add("west", "low")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_side_tall").uvlock()).when(JState.when().add("north", "tall")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_side_tall").y(90).uvlock()).when(JState.when().add("east", "tall")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_side_tall").y(180).uvlock()).when(JState.when().add("south", "tall")))
                                .add(JState.multipart(JState.model("ctft:block/" + id + "_wall_side_tall").y(270).uvlock()).when(JState.when().add("west", "tall")))
                        , new Identifier("ctft:" + id + "_wall"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_wall_from_stonecutter"), JRecipe.stonecutting(JIngredient.ingredient().item("minecraft:" + id), JResult.stackedResult("ctft:" + id + "_wall", 1)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_wall"), JLootTable
                        .loot("block")
                        .pool(JLootTable
                                .pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_wall"))));
                TagInjector.inject(Registry.BLOCK, new Identifier("minecraft", "walls"), Registry.BLOCK.get(new Identifier("ctft", id + "_wall")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_walls"), Registry.ITEM.get(new Identifier("ctft", id + "_wall")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.doorsEnabled) {
                int multiplier = 2;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_door", new CustomDoorBlock(AbstractBlock.Settings.of(material).nonOpaque()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_door", new CustomBlockItem(block, ctftMaterial.foil, "door", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/door").textures((JModel.textures().var("0", "minecraft:item/oak_door").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_door"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_bottom_left").textures((JModel.textures().var("bottom", "ctft:blocks/" + ctftMaterial.texture_name + "_door_bottom").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_door_bottom_left"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_bottom_right").textures((JModel.textures().var("bottom", "ctft:blocks/" + ctftMaterial.texture_name + "_door_bottom").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_door_bottom_right"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_bottom_left_open").textures((JModel.textures().var("bottom", "ctft:blocks/" + ctftMaterial.texture_name + "_door_bottom").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_door_bottom_left_open"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_bottom_right_open").textures((JModel.textures().var("bottom", "ctft:blocks/" + ctftMaterial.texture_name + "_door_bottom").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_door_bottom_right_open"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_top_left").textures((JModel.textures().var("top", "ctft:blocks/" + ctftMaterial.texture_name + "_door_top").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_door_top_left"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_top_right").textures((JModel.textures().var("top", "ctft:blocks/" + ctftMaterial.texture_name + "_door_top").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_door_top_right"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_top_left_open").textures((JModel.textures().var("top", "ctft:blocks/" + ctftMaterial.texture_name + "_door_top").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_door_top_left_open"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_top_right_open").textures((JModel.textures().var("top", "ctft:blocks/" + ctftMaterial.texture_name + "_door_top").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_door_top_right_open"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("facing=east,half=lower,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_bottom_left"))
                        .put("facing=east,half=lower,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_bottom_left_open").y(90))
                        .put("facing=east,half=lower,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_bottom_right"))
                        .put("facing=east,half=lower,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_bottom_right_open").y(270))
                        .put("facing=east,half=upper,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_top_left"))
                        .put("facing=east,half=upper,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_top_left_open").y(90))
                        .put("facing=east,half=upper,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_top_right"))
                        .put("facing=east,half=upper,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_top_right_open").y(270))
                        .put("facing=north,half=lower,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_bottom_left").y(270))
                        .put("facing=north,half=lower,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_bottom_left_open"))
                        .put("facing=north,half=lower,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_bottom_right").y(270))
                        .put("facing=north,half=lower,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_bottom_right_open").y(180))
                        .put("facing=north,half=upper,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_top_left").y(270))
                        .put("facing=north,half=upper,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_top_left_open"))
                        .put("facing=north,half=upper,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_top_right").y(270))
                        .put("facing=north,half=upper,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_top_right_open").y(180))
                        .put("facing=south,half=lower,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_bottom_left").y(90))
                        .put("facing=south,half=lower,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_bottom_left_open").y(180))
                        .put("facing=south,half=lower,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_bottom_right").y(90))
                        .put("facing=south,half=lower,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_bottom_right_open"))
                        .put("facing=south,half=upper,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_top_left").y(90))
                        .put("facing=south,half=upper,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_top_left_open").y(180))
                        .put("facing=south,half=upper,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_top_right").y(90))
                        .put("facing=south,half=upper,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_top_right_open"))
                        .put("facing=west,half=lower,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_bottom_left").y(180))
                        .put("facing=west,half=lower,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_bottom_left_open").y(270))
                        .put("facing=west,half=lower,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_bottom_right").y(180))
                        .put("facing=west,half=lower,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_bottom_right_open").y(90))
                        .put("facing=west,half=upper,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_top_left").y(180))
                        .put("facing=west,half=upper,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_top_left_open").y(270))
                        .put("facing=west,half=upper,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_top_right").y(180))
                        .put("facing=west,half=upper,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_top_right_open").y(90))
                ), new Identifier("ctft:" + id + "_door"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_door_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("00 ").row2("00 ").row3("00 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.stackedResult("ctft:" + id + "_door", 3)));
                var upperdoor = new JsonObject();
                upperdoor.addProperty("half", "upper");
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_door"), JLootTable
                        .loot("block")
                        .pool(JLootTable
                                .pool()
                                .rolls(1)
                                .entry(JLootTable.entry()
                                        .type("minecraft:item")
                                        .function(JLootTable
                                                .function("minecraft:set_count")
                                                .condition(JLootTable
                                                        .condition("minecraft:block_state_property")
                                                        .parameter("block", "ctft:" + id + "_door")
                                                        .parameter("properties", upperdoor)
                                                ).parameter("count", 0)
                                                .parameter("add", false)
                                        )
                                        .name("ctft:" + id + "_door")
                                        .function(JLootTable
                                                .function("minecraft:explosion_decay")
                                        )
                                )
                        )
                );
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_doors"), Registry.ITEM.get(new Identifier("ctft", id + "_door")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.trapDoorsEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_trapdoor", new CustomTrapdoorBlock(AbstractBlock.Settings.of(material).nonOpaque()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_trapdoor", new CustomBlockItem(block, ctftMaterial.foil, "trapdoor", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_trapdoor_bottom").textures((JModel.textures().var("texture", "ctft:blocks/" + ctftMaterial.texture_name + "_trapdoor").particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_trapdoor"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_trapdoor_open").textures((JModel.textures().var("texture", "ctft:blocks/" + ctftMaterial.texture_name + "_trapdoor").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_trapdoor_open"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_trapdoor_top").textures((JModel.textures().var("texture", "ctft:blocks/" + ctftMaterial.texture_name + "_trapdoor").particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_trapdoor_top"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("facing=east,half=bottom,open=false", JState.model("ctft:item/" + id + "_trapdoor").y(90))
                        .put("facing=east,half=bottom,open=true", JState.model("ctft:block/" + id + "_trapdoor_open").y(90))
                        .put("facing=east,half=top,open=false", JState.model("ctft:block/" + id + "_trapdoor_top").y(90))
                        .put("facing=east,half=top,open=true", JState.model("ctft:block/" + id + "_trapdoor_open").x(180).y(270))
                        .put("facing=north,half=bottom,open=false", JState.model("ctft:item/" + id + "_trapdoor"))
                        .put("facing=north,half=bottom,open=true", JState.model("ctft:block/" + id + "_trapdoor_open"))
                        .put("facing=north,half=top,open=false", JState.model("ctft:block/" + id + "_trapdoor_top"))
                        .put("facing=north,half=top,open=true", JState.model("ctft:block/" + id + "_trapdoor_open").x(180).y(180))
                        .put("facing=south,half=bottom,open=false", JState.model("ctft:item/" + id + "_trapdoor").y(180))
                        .put("facing=south,half=bottom,open=true", JState.model("ctft:block/" + id + "_trapdoor_open").y(180))
                        .put("facing=south,half=top,open=false", JState.model("ctft:block/" + id + "_trapdoor_top").y(180))
                        .put("facing=south,half=top,open=true", JState.model("ctft:block/" + id + "_trapdoor_open").x(180))
                        .put("facing=west,half=bottom,open=false", JState.model("ctft:item/" + id + "_trapdoor").y(270))
                        .put("facing=west,half=bottom,open=true", JState.model("ctft:block/" + id + "_trapdoor_open").y(270))
                        .put("facing=west,half=top,open=false", JState.model("ctft:block/" + id + "_trapdoor_top").y(270))
                        .put("facing=west,half=top,open=true", JState.model("ctft:block/" + id + "_trapdoor_open").x(180).y(90))
                ), new Identifier("ctft:" + id + "_trapdoor"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_trapdoor_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.stackedResult("ctft:" + id + "_trapdoor", 2)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_trapdoor"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_trapdoor"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_trapdoors"), Registry.ITEM.get(new Identifier("ctft", id + "_trapdoor")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.leversEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_lever", new CustomLeverBlock(AbstractBlock.Settings.of(material).noCollision()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_lever", new CustomBlockItem(block, ctftMaterial.foil, "lever", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/lever").textures(JModel.textures().var("0", "minecraft:block/lever").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace)), new Identifier("ctft", "item/" + id + "_lever"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/lever").textures((JModel.textures().var("lever", "minecraft:block/lever").var("base", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_lever_off"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/lever_on").textures((JModel.textures().var("lever", "minecraft:block/lever").var("base", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_lever_on"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("face=ceiling,facing=east,powered=true", JState.model("ctft:block/" + id + "_lever_off").x(180).y(270))
                        .put("face=ceiling,facing=east,powered=false", JState.model("ctft:block/" + id + "_lever_on").x(180).y(270))
                        .put("face=ceiling,facing=north,powered=true", JState.model("ctft:block/" + id + "_lever_off").x(180).y(180))
                        .put("face=ceiling,facing=north,powered=false", JState.model("ctft:block/" + id + "_lever_on").x(180).y(180))
                        .put("face=ceiling,facing=south,powered=true", JState.model("ctft:block/" + id + "_lever_off").x(180))
                        .put("face=ceiling,facing=south,powered=false", JState.model("ctft:block/" + id + "_lever_on").x(180))
                        .put("face=ceiling,facing=west,powered=true", JState.model("ctft:block/" + id + "_lever_off").x(180).y(90))
                        .put("face=ceiling,facing=west,powered=false", JState.model("ctft:block/" + id + "_lever_on").x(180).y(90))
                        .put("face=floor,facing=east,powered=true", JState.model("ctft:block/" + id + "_lever_off").y(90))
                        .put("face=floor,facing=east,powered=false", JState.model("ctft:block/" + id + "_lever_on").y(90))
                        .put("face=floor,facing=north,powered=true", JState.model("ctft:block/" + id + "_lever_off"))
                        .put("face=floor,facing=north,powered=false", JState.model("ctft:block/" + id + "_lever_on"))
                        .put("face=floor,facing=south,powered=true", JState.model("ctft:block/" + id + "_lever_off").y(180))
                        .put("face=floor,facing=south,powered=false", JState.model("ctft:block/" + id + "_lever_on").y(180))
                        .put("face=floor,facing=west,powered=true", JState.model("ctft:block/" + id + "_lever_off").y(270))
                        .put("face=floor,facing=west,powered=false", JState.model("ctft:block/" + id + "_lever_on").y(270))
                        .put("face=wall,facing=east,powered=true", JState.model("ctft:block/" + id + "_lever_off").x(90).y(90))
                        .put("face=wall,facing=east,powered=false", JState.model("ctft:block/" + id + "_lever_on").x(90).y(90))
                        .put("face=wall,facing=north,powered=true", JState.model("ctft:block/" + id + "_lever_off").x(90))
                        .put("face=wall,facing=north,powered=false", JState.model("ctft:block/" + id + "_lever_on").x(90))
                        .put("face=wall,facing=south,powered=true", JState.model("ctft:block/" + id + "_lever_off").x(90).y(180))
                        .put("face=wall,facing=south,powered=false", JState.model("ctft:block/" + id + "_lever_on").x(90).y(180))
                        .put("face=wall,facing=west,powered=true", JState.model("ctft:block/" + id + "_lever_off").x(90).y(270))
                        .put("face=wall,facing=west,powered=false", JState.model("ctft:block/" + id + "_lever_on").x(90).y(270))
                ), new Identifier("ctft:" + id + "_lever"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_lever_from_crafting"), JRecipe.shaped(JPattern.pattern().row2(" 0 ").row3(" 1 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:stick")).key("1", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_lever")));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_lever"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_lever"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_levers"), Registry.ITEM.get(new Identifier("ctft", id + "_lever")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.buttonsEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_button", new CustomButtonBlock(AbstractBlock.Settings.of(material).noCollision()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_button", new CustomBlockItem(block, ctftMaterial.foil, "button", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/button_inventory").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_button"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/button").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_button_off"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/button_pressed").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_button_on"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("face=ceiling,facing=east,powered=false", JState.model("ctft:block/" + id + "_button_off").x(180).y(270))
                        .put("face=ceiling,facing=east,powered=true", JState.model("ctft:block/" + id + "_button_on").x(180).y(270))
                        .put("face=ceiling,facing=north,powered=false", JState.model("ctft:block/" + id + "_button_off").x(180).y(180))
                        .put("face=ceiling,facing=north,powered=true", JState.model("ctft:block/" + id + "_button_on").x(180).y(180))
                        .put("face=ceiling,facing=south,powered=false", JState.model("ctft:block/" + id + "_button_off").x(180))
                        .put("face=ceiling,facing=south,powered=true", JState.model("ctft:block/" + id + "_button_on").x(180))
                        .put("face=ceiling,facing=west,powered=false", JState.model("ctft:block/" + id + "_button_off").x(180).y(90))
                        .put("face=ceiling,facing=west,powered=true", JState.model("ctft:block/" + id + "_button_on").x(180).y(90))
                        .put("face=floor,facing=east,powered=false", JState.model("ctft:block/" + id + "_button_off").y(90))
                        .put("face=floor,facing=east,powered=true", JState.model("ctft:block/" + id + "_button_on").y(90))
                        .put("face=floor,facing=north,powered=false", JState.model("ctft:block/" + id + "_button_off"))
                        .put("face=floor,facing=north,powered=true", JState.model("ctft:block/" + id + "_button_on"))
                        .put("face=floor,facing=south,powered=false", JState.model("ctft:block/" + id + "_button_off").y(180))
                        .put("face=floor,facing=south,powered=true", JState.model("ctft:block/" + id + "_button_on").y(180))
                        .put("face=floor,facing=west,powered=false", JState.model("ctft:block/" + id + "_button_off").y(270))
                        .put("face=floor,facing=west,powered=true", JState.model("ctft:block/" + id + "_button_on").y(270))
                        .put("face=wall,facing=east,powered=false", JState.model("ctft:block/" + id + "_button_off").x(90).y(90))
                        .put("face=wall,facing=east,powered=true", JState.model("ctft:block/" + id + "_button_on").x(90).y(90))
                        .put("face=wall,facing=north,powered=false", JState.model("ctft:block/" + id + "_button_off").x(90))
                        .put("face=wall,facing=north,powered=true", JState.model("ctft:block/" + id + "_button_on").x(90))
                        .put("face=wall,facing=south,powered=false", JState.model("ctft:block/" + id + "_button_off").x(90).y(180))
                        .put("face=wall,facing=south,powered=true", JState.model("ctft:block/" + id + "_button_on").x(90).y(180))
                        .put("face=wall,facing=west,powered=false", JState.model("ctft:block/" + id + "_button_off").x(90).y(270))
                        .put("face=wall,facing=west,powered=true", JState.model("ctft:block/" + id + "_button_on").x(90).y(270))
                ), new Identifier("ctft:" + id + "_button"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_button_from_stonecutter"), JRecipe.stonecutting(JIngredient.ingredient().item("minecraft:" + id), JResult.stackedResult("ctft:" + id + "_button", 1)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_button"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_button"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_buttons"), Registry.ITEM.get(new Identifier("ctft", id + "_button")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.pressurePlatesEnabled) {
                int multiplier = 2;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_pressure_plate", new CustomPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.of(material).noCollision()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_pressure_plate", new CustomBlockItem(block, ctftMaterial.foil, "pressure_plate", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/pressure_plate_up").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_pressure_plate"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/pressure_plate_down").textures((JModel.textures().var("texture", ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_pressure_plate_on"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("powered=false", JState.model("ctft:item/" + id + "_pressure_plate"))
                        .put("powered=true", JState.model("ctft:block/" + id + "_pressure_plate_on"))
                ), new Identifier("ctft:" + id + "_pressure_plate"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_pressure_plate_from_crafting"), JRecipe.shaped(JPattern.pattern().row3("00 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_pressure_plate")));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_pressure_plate"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_pressure_plate"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_pressure_plates"), Registry.ITEM.get(new Identifier("ctft", id + "_pressure_plate")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.torchesEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_torch", new CustomTorchBlock(AbstractBlock.Settings.of(material).noCollision().breakInstantly().luminance(state -> 14), ParticleTypes.FLAME));
                Block wallblock = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_walltorch", new CustomWallTorchBlock(AbstractBlock.Settings.of(material).noCollision().breakInstantly().luminance(state -> 14), ParticleTypes.FLAME));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_torch", new CustomWallStandingBlockItem(block, wallblock, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/torch").textures((JModel.textures().var("0", "minecraft:block/torch").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_torch"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/template_torch").textures((JModel.textures().var("0", "minecraft:block/torch").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_torch"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/template_torch_wall").textures((JModel.textures().var("1", "minecraft:block/torch").var("2", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_torch_wall"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("", JState.model("ctft:block/" + id + "_torch"))
                ), new Identifier("ctft:" + id + "_torch"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("facing=east", JState.model("ctft:block/" + id + "_torch_wall"))
                        .put("facing=north", JState.model("ctft:block/" + id + "_torch_wall").y(270))
                        .put("facing=south", JState.model("ctft:block/" + id + "_torch_wall").y(90))
                        .put("facing=west", JState.model("ctft:block/" + id + "_torch_wall").y(180))
                ), new Identifier("ctft:" + id + "_walltorch"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_torch_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 1 ").row2(" 0 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:coal")), JResult.stackedResult("ctft:" + id + "_torch", 4)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_torch"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_torch"))));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_walltorch"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_torch"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_torches"), Registry.ITEM.get(new Identifier("ctft", id + "_torch")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.lanternsEnabled) {
                int multiplier = 9;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_lantern", new LanternBlock(AbstractBlock.Settings.of(material).luminance(state -> 14)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_lantern", new CustomBlockItem(block, ctftMaterial.foil, "lantern", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/lantern").textures((JModel.textures().var("0", "minecraft:item/lantern").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_lantern"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/template_lantern").textures((JModel.textures().var("2", "minecraft:block/lantern").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_lantern"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/template_hanging_lantern").textures((JModel.textures().var("1", "minecraft:block/lantern").var("2", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_lantern_hanging"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("hanging=false", JState.model("ctft:block/" + id + "_lantern"))
                        .put("hanging=true", JState.model("ctft:block/" + id + "_lantern_hanging"))
                ), new Identifier("ctft:" + id + "_lantern"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_lantern_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2("010").row3("000"), JKeys.keys().key("1", JIngredient.ingredient().item("ctft:" + id + "_torch")).key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.result("ctft:" + id + "_lantern")));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_lantern"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_lantern"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_lanterns"), Registry.ITEM.get(new Identifier("ctft", id + "_lantern")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.endRodsEnabled) {
                int multiplier = 2;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_end_rod", new CustomEndRodBlock(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_end_rod", new CustomBlockItem(block, ctftMaterial.foil, "end_rod", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/end_rod").textures((JModel.textures().var("end_rod", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_end_rod"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("facing=down", JState.model("ctft:item/" + id + "_end_rod").x(180))
                        .put("facing=east", JState.model("ctft:item/" + id + "_end_rod").x(90).y(90))
                        .put("facing=north", JState.model("ctft:item/" + id + "_end_rod").x(90))
                        .put("facing=south", JState.model("ctft:item/" + id + "_end_rod").x(90).y(180))
                        .put("facing=up", JState.model("ctft:item/" + id + "_end_rod"))
                        .put("facing=west", JState.model("ctft:item/" + id + "_end_rod").x(90).y(270))
                ), new Identifier("ctft:" + id + "_end_rod"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_end_rod_from_stonecutter"), JRecipe.stonecutting(JIngredient.ingredient().item("minecraft:" + id), JResult.stackedResult("ctft:" + id + "_end_rod", 1)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_end_rod"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_end_rod"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_end_rods"), Registry.ITEM.get(new Identifier("ctft", id + "_end_rod")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            settings.maxCount(16);
            if (Ctft.CONFIG.signsEnabled) {
                int multiplier = 2;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                var signType = SignTypeInvoker.ctft$invokeNew(id);
                SignTypeInvoker.ctft$invokeRegister(signType);

                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_sign", new SignBlock(AbstractBlock.Settings.of(material), signType));
                Block wallblock = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_wallsign", new WallSignBlock(AbstractBlock.Settings.of(material), signType));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_sign", new CustomSignItem(block, wallblock, ctftMaterial.foil, ctftMaterial.lang_key, settings));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/sign").textures((JModel.textures().var("0", "minecraft:item/oak_sign").var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_sign"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_sign"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().textures((JModel.textures().var("texture", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "block/" + id + "_wallsign"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("", JState.model("ctft:block/" + id + "_sign"))
                ), new Identifier("ctft:" + id + "_sign"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("", JState.model("ctft:block/" + id + "_wallsign"))
                ), new Identifier("ctft:" + id + "_wallsign"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_sign_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2("000").row3(" 1 "), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)).key("1", JIngredient.ingredient().item("minecraft:stick")), JResult.stackedResult("ctft:" + id + "_sign", 3)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_sign"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_sign"))));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_wallsign"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_sign"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_signs"), Registry.ITEM.get(new Identifier("ctft", id + "_sign")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            settings.maxCount(64);
            if (Ctft.CONFIG.laddersEnabled) {
                int multiplier = 3;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_ladder", new CustomLadderBlock(AbstractBlock.Settings.of(material).nonOpaque().noCollision()));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_ladder", new CustomBlockItem(block, ctftMaterial.foil, "ladder", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:item/generated").textures(JModel.textures().layer0("ctft:blocks/" + ctftMaterial.texture_name + "_ladder").particle("ctft:blocks/" + ctftMaterial.texture_name + "_ladder")), new Identifier("ctft", "item/" + id + "_ladder"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/ladder").textures(JModel.textures().var("texture", "ctft:blocks/" + ctftMaterial.texture_name + "_ladder").particle("ctft:blocks/" + ctftMaterial.texture_name + "_ladder")), new Identifier("ctft", "block/" + id + "_ladder"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("facing=east", JState.model("ctft:block/" + id + "_ladder").y(90))
                        .put("facing=north", JState.model("ctft:block/" + id + "_ladder"))
                        .put("facing=south", JState.model("ctft:block/" + id + "_ladder").y(180))
                        .put("facing=west", JState.model("ctft:block/" + id + "_ladder").y(270))
                ), new Identifier("ctft:" + id + "_ladder"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_ladder_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0 0").row2("000").row3("0 0"), JKeys.keys().key("0", JIngredient.ingredient().item("minecraft:" + id)), JResult.stackedResult("ctft:" + id + "_ladder", 3)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_ladder"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_ladder"))));
                TagInjector.inject(Registry.BLOCK, new Identifier("minecraft", "climbable"), Registry.BLOCK.get(new Identifier("ctft", id + "_ladder")));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_ladders"), Registry.ITEM.get(new Identifier("ctft", id + "_ladder")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.chainsEnabled) {
                int multiplier = 1;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_chain", new ChainBlock(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_chain", new CustomBlockItem(block, ctftMaterial.foil, "chain", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/chain").textures(JModel.textures().var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace)), new Identifier("ctft", "item/" + id + "_chain"));
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/chain").textures(JModel.textures().var("1", ctftMaterial.namespace).particle(ctftMaterial.namespace)), new Identifier("ctft", "block/" + id + "_chain"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("axis=x", JState.model("ctft:block/" + id + "_chain").x(90).y(90))
                        .put("axis=y", JState.model("ctft:block/" + id + "_chain"))
                        .put("axis=z", JState.model("ctft:block/" + id + "_chain").x(90))
                ), new Identifier("ctft:" + id + "_chain"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_chain_from_stonecutter"), JRecipe.stonecutting(JIngredient.ingredient().item("minecraft:" + id), JResult.stackedResult("ctft:" + id + "_chain", 1)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_chain"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_chain"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_chains"), Registry.ITEM.get(new Identifier("ctft", id + "_chain")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            if (Ctft.CONFIG.compressionLevel >= 1) {
                int multiplier = 9;
                String lower = "block";
                String upper = "compressed1";
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_" + upper, new Block(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_" + upper, new CustomBlockItem(block, ctftMaterial.foil, upper, ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/" + upper).textures((JModel.textures().var("0", "ctft:blocks/" + ctftMaterial.texture_name + "_compressed").particle("ctft:blocks/" + ctftMaterial.texture_name + "_compressed"))), new Identifier("ctft", "item/" + id + "_" + upper));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("", JState.model("ctft:item/" + id + "_" + upper))
                ), new Identifier("ctft:" + id + "_" + upper));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_" + upper + "_from" + "_" + lower), JRecipe.shaped(JPattern.pattern().row1("000").row2("000").row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("ctft:" + id + "_" + lower)), JResult.result("ctft:" + id + "_" + upper)));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_" + lower + "_from" + "_" + upper), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item("ctft:" + id + "_" + upper)), JResult.stackedResult("ctft:" + id + "_" + lower, 9)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_" + upper), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_" + upper))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_" + upper), Registry.ITEM.get(new Identifier("ctft", id + "_" + upper)));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
            for (int i = 2; i < 64; i++) {
                if (Ctft.CONFIG.compressionLevel >= i) {
                    int multiplier = 9;
                    String lower = "compressed" + (i - 1);
                    String upper = "compressed" + (i);
                    if (ctftMaterial.is_food) {
                        final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                        if (ctftMaterial.is_meat) {
                            foodComponent.meat();
                        }
                        if (ctftMaterial.is_fast) {
                            foodComponent.snack();
                        }
                        if (ctftMaterial.can_always_eat) {
                            foodComponent.alwaysEdible();
                        }
                        if (ctftMaterial.food_effects) {
                            for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                                foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                            }
                        }
                        settings.food(foodComponent.build());
                    }
                    if (ctftMaterial.fire_immune) {
                        settings.fireproof();
                    }
                    Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_" + upper, new Block(AbstractBlock.Settings.of(material)));
                    Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_" + upper, new CustomBlockItem(block, ctftMaterial.foil, upper, ctftMaterial.lang_key, settings));
                    var id = ctftMaterial.recipe_ingredient.toLowerCase();
                    Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/" + upper).textures((JModel.textures().var("0", "ctft:blocks/" + ctftMaterial.texture_name + "_compressed").particle("ctft:blocks/" + ctftMaterial.texture_name + "_compressed"))), new Identifier("ctft", "item/" + id + "_" + upper));
                    Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                            .put("", JState.model("ctft:item/" + id + "_" + upper))
                    ), new Identifier("ctft:" + id + "_" + upper));
//                    Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_" + upper + "_from" + "_" + lower), JRecipe.shaped(JPattern.pattern().row1("000").row2("000").row3("000"), JKeys.keys().key("0", JIngredient.ingredient().item("ctft:" + id + "_" + lower)), JResult.result("ctft:" + id + "_" + upper)));
//                    Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_" + lower + "_from" + "_" + upper), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item("ctft:" + id + "_" + upper)), JResult.stackedResult("ctft:" + id + "_" + lower, 9)));
                    Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_" + upper), JLootTable
                            .loot("block")
                            .pool(JLootTable.pool()
                                    .rolls(1)
                                    .entry(JLootTable
                                            .entry()
                                            .type("minecraft:item")
                                            .name("ctft:" + id + "_" + upper))));
                    TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_" + upper), Registry.ITEM.get(new Identifier("ctft", id + "_" + upper)));
                    if (piglin_loved.contains(id)) {
                        TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                    }
                    if (freeze_immune_wearables.contains(id)) {
                        TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                    }
                    if (piglin_repellents.contains(id)) {
                        TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                    }
                    if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
                }
            }
            if (Ctft.CONFIG.kcolbsEnabled) {
                int multiplier = 9;
                if (ctftMaterial.is_food) {
                    final FoodComponent.Builder foodComponent = (new FoodComponent.Builder()).hunger(ctftMaterial.nutrition * multiplier).saturationModifier(ctftMaterial.saturation / multiplier);
                    if (ctftMaterial.is_meat) {
                        foodComponent.meat();
                    }
                    if (ctftMaterial.is_fast) {
                        foodComponent.snack();
                    }
                    if (ctftMaterial.can_always_eat) {
                        foodComponent.alwaysEdible();
                    }
                    if (ctftMaterial.food_effects) {
                        for (Pair<StatusEffectInstance, Float> statusEffect : Registry.ITEM.get(new Identifier(ctftMaterial.recipe_ingredient.toLowerCase())).getFoodComponent().getStatusEffects()) {
                            foodComponent.statusEffect(statusEffect.getFirst(), statusEffect.getSecond());
                        }
                    }
                    settings.food(foodComponent.build());
                }
                if (ctftMaterial.fire_immune) {
                    settings.fireproof();
                }
                Block block = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_kcolb", new Block(AbstractBlock.Settings.of(material)));
                Item item = register(ctftMaterial.recipe_ingredient.toLowerCase() + "_kcolb", new CustomBlockItem(block, ctftMaterial.foil, "kcolb", ctftMaterial.lang_key, settings));
                var id = ctftMaterial.recipe_ingredient.toLowerCase();
                Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/kcolb").textures((JModel.textures().var("0", ctftMaterial.namespace).particle(ctftMaterial.namespace))), new Identifier("ctft", "item/" + id + "_kcolb"));
                Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                        .put("", JState.model("ctft:item/" + id + "_kcolb"))
                ), new Identifier("ctft:" + id + "_kcolb"));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_kcolb_from_stonecutter"), JRecipe.stonecutting(JIngredient.ingredient().item("ctft:" + id + "_block"), JResult.stackedResult("ctft:" + id + "_kcolb", 1)));
//                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_block_from_kcolb"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item("ctft:" + id + "_kcolb")), JResult.stackedResult("ctft:" + id + "_block", 1)));
                Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_kcolb"), JLootTable
                        .loot("block")
                        .pool(JLootTable.pool()
                                .rolls(1)
                                .entry(JLootTable
                                        .entry()
                                        .type("minecraft:item")
                                        .name("ctft:" + id + "_kcolb"))));
                TagInjector.inject(Registry.ITEM, new Identifier("ctft", "ctft_kcolbs"), Registry.ITEM.get(new Identifier("ctft", id + "_kcolb")));
                if (piglin_loved.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_loved"));
                }
                if (freeze_immune_wearables.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "freeze_immune_wearables"));
                }
                if (piglin_repellents.contains(id)) {
                    TagInjector.inject(Registry.ITEM, new Identifier("minecraft", "piglin_repellents"));
                }
                if (ctftMaterial.combustion > 0) FuelRegistry.INSTANCE.add(item, ctftMaterial.combustion * multiplier);
            }
        });
    }

    public record ConfiguredToolMaterial(int getDurability,
                                         float getMiningSpeedMultiplier,
                                         float getAttackDamage,
                                         int getMiningLevel,
                                         int getEnchantability,
                                         Ingredient getRepairIngredient) implements ToolMaterial {
    }

    public record ConfiguredArmorMaterial(int getDurability,
                                          int helmetProtectionAmount,
                                          int chestplateProtectionAmount,
                                          int leggingsProtectionAmount,
                                          int bootsProtectionAmount,
                                          int getEnchantability,
                                          SoundEvent getEquipSound,
                                          String getName,
                                          float getToughness,
                                          float getKnockbackResistance,
                                          Ingredient getRepairIngredient) implements ArmorMaterial {
        @Override
        public int getDurability(EquipmentSlot slot) {
            return 0;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return switch (slot) {
                case HEAD -> helmetProtectionAmount;
                case CHEST -> chestplateProtectionAmount;
                case LEGS -> leggingsProtectionAmount;
                case FEET -> bootsProtectionAmount;
                default -> 0;
            };
        }
    }
}
