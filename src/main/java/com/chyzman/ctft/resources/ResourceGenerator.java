package com.chyzman.ctft.resources;

import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.blockstate.JWhen;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;

import com.chyzman.ctft.Ctft;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.util.Identifier;

public class ResourceGenerator {
    public static void INIT() {
        makeResources("acacia_boat", "acacia_boat");
        makeResources("acacia_planks", "acacia_button");
        makeResources("acacia_door", "acacia_door");
        makeResources("acacia_planks", "acacia_fence");
        makeResources("acacia_planks", "acacia_fence_gate");
        makeResources("acacia_leaves", "acacia_leaves");
        makeResources("acacia_log", "acacia_log");
        makeResources("acacia_planks", "acacia_planks");
        makeResources("acacia_planks", "acacia_pressure_plate");
        makeResources("acacia_sapling", "acacia_sapling");
        makeResources("acacia_planks", "acacia_sign");
        makeResources("acacia_planks", "acacia_slab");
        makeResources("acacia_planks", "acacia_stairs");
        makeResources("acacia_trapdoor", "acacia_trapdoor");
        makeResources("acacia_log", "acacia_wood");
        makeResources("activator_rail", "activator_rail");
        makeResources("allium", "allium");
        makeResources("amethyst_cluster", "amethyst_cluster");
        makeResources("amethyst_shard", "amethyst_shard");
        makeResources("ancient_debris_top", "ancient_debris");
        makeResources("andesite", "andesite");
        makeResources("andesite", "andesite_slab");
        makeResources("andesite", "andesite_stairs");
        makeResources("andesite", "andesite_wall");
        makeResources("anvil_top", "anvil");
        makeResources("apple", "apple");
        makeResources("armor_stand", "armor_stand");
        makeResources("arrow", "arrow");
        makeResources("axolotl", "axolotl_spawn_egg");
        makeResources("azalea_top", "azalea");
        makeResources("azalea_leaves", "azalea_leaves");
        makeResources("azure_bluet", "azure_bluet");
        makeResources("baked_potato", "baked_potato");
        makeResources("bamboo", "bamboo");
        makeResources("barrel_side", "barrel");
        makeResources("barrier", "barrier");
        makeResources("basalt_top", "basalt");
        makeResources("bat", "bat_spawn_egg");
        makeResources("beacon", "beacon");
        makeResources("bedrock", "bedrock");
        makeResources("bee_nest_side", "bee_nest");
        makeResources("bee", "bee_spawn_egg");
        makeResources("beehive_side", "beehive");
        makeResources("beetroot", "beetroot");
        makeResources("beetroot_seeds", "beetroot_seeds");
        makeResources("beetroot_soup", "beetroot_soup");
        makeResources("bell", "bell");
        makeResources("big_dripleaf_top", "big_dripleaf");
        makeResources("birch_boat", "birch_boat");
        makeResources("birch_planks", "birch_button");
        makeResources("birch_door", "birch_door");
        makeResources("birch_planks", "birch_fence");
        makeResources("birch_planks", "birch_fence_gate");
        makeResources("birch_leaves", "birch_leaves");
        makeResources("birch_log", "birch_log");
        makeResources("birch_planks", "birch_planks");
        makeResources("birch_planks", "birch_pressure_plate");
        makeResources("birch_sapling", "birch_sapling");
        makeResources("birch_planks", "birch_sign");
        makeResources("birch_planks", "birch_slab");
        makeResources("birch_planks", "birch_stairs");
        makeResources("birch_trapdoor", "birch_trapdoor");
        makeResources("birch_log", "birch_wood");
        makeResources("black_concrete", "black_banner");
        makeResources("black_wool", "black_bed");
        makeResources("black_candle", "black_candle");
        makeResources("black_wool", "black_carpet");
        makeResources("black_concrete", "black_concrete");
        makeResources("black_concrete_powder", "black_concrete_powder");
        makeResources("black_dye", "black_dye");
        makeResources("black_glazed_terracotta", "black_glazed_terracotta");
        makeResources("black_shulker_box", "black_shulker_box");
        makeResources("black_stained_glass", "black_stained_glass");
        makeResources("black_stained_glass", "black_stained_glass_pane");
        makeResources("black_terracotta", "black_terracotta");
        makeResources("black_wool", "black_wool");
        makeResources("blackstone", "blackstone");
        makeResources("blackstone", "blackstone_slab");
        makeResources("blackstone", "blackstone_stairs");
        makeResources("blackstone", "blackstone_wall");
        makeResources("blast_furnace_front", "blast_furnace");
        makeResources("blaze_powder", "blaze_powder");
        makeResources("blaze_rod", "blaze_rod");
        makeResources("blaze", "blaze_spawn_egg");
        makeResources("amethyst_block", "amethyst_block");
        makeResources("coal_block", "coal_block");
        makeResources("copper_block", "copper_block");
        makeResources("diamond_block", "diamond_block");
        makeResources("emerald_block", "emerald_block");
        makeResources("gold_block", "gold_block");
        makeResources("iron_block", "iron_block");
        makeResources("lapis_block", "lapis_block");
        makeResources("netherite_block", "netherite_block");
        makeResources("quartz_block_bottom", "quartz_block");
        makeResources("raw_copper_block", "raw_copper_block");
        makeResources("raw_gold_block", "raw_gold_block");
        makeResources("raw_iron_block", "raw_iron_block");
        makeResources("redstone_block", "redstone_block");
        makeResources("blue_concrete", "blue_banner");
        makeResources("blue_wool", "blue_bed");
        makeResources("blue_candle", "blue_candle");
        makeResources("blue_wool", "blue_carpet");
        makeResources("blue_concrete", "blue_concrete");
        makeResources("blue_concrete_powder", "blue_concrete_powder");
        makeResources("blue_dye", "blue_dye");
        makeResources("blue_glazed_terracotta", "blue_glazed_terracotta");
        makeResources("blue_ice", "blue_ice");
        makeResources("blue_orchid", "blue_orchid");
        makeResources("blue_shulker_box", "blue_shulker_box");
        makeResources("blue_stained_glass", "blue_stained_glass");
        makeResources("blue_stained_glass", "blue_stained_glass_pane");
        makeResources("blue_terracotta", "blue_terracotta");
        makeResources("blue_wool", "blue_wool");
        makeResources("bone", "bone");
        makeResources("bone_block_top", "bone_block");
        makeResources("bone_meal", "bone_meal");
        makeResources("book", "book");
        makeResources("bookshelf", "bookshelf");
        makeResources("bow", "bow");
        makeResources("bowl", "bowl");
        makeResources("brain_coral", "brain_coral");
        makeResources("brain_coral_block", "brain_coral_block");
        makeResources("brain_coral_fan", "brain_coral_fan");
        makeResources("bread", "bread");
        makeResources("brewing_stand", "brewing_stand");
        makeResources("brick", "brick");
        makeResources("bricks", "brick_slab");
        makeResources("bricks", "brick_stairs");
        makeResources("bricks", "brick_wall");
        makeResources("bricks", "bricks");
        makeResources("brown_concrete", "brown_banner");
        makeResources("brown_wool", "brown_bed");
        makeResources("brown_candle", "brown_candle");
        makeResources("brown_wool", "brown_carpet");
        makeResources("brown_concrete", "brown_concrete");
        makeResources("brown_concrete_powder", "brown_concrete_powder");
        makeResources("brown_dye", "brown_dye");
        makeResources("brown_glazed_terracotta", "brown_glazed_terracotta");
        makeResources("brown_mushroom", "brown_mushroom");
        makeResources("brown_mushroom_block", "brown_mushroom_block");
        makeResources("brown_shulker_box", "brown_shulker_box");
        makeResources("brown_stained_glass", "brown_stained_glass");
        makeResources("brown_stained_glass", "brown_stained_glass_pane");
        makeResources("brown_terracotta", "brown_terracotta");
        makeResources("brown_wool", "brown_wool");
        makeResources("bubble_coral", "bubble_coral");
        makeResources("bubble_coral_block", "bubble_coral_block");
        makeResources("bubble_coral_fan", "bubble_coral_fan");
        makeResources("bucket", "bucket");
        makeResources("axolotl_bucket", "axolotl_bucket");
        makeResources("budding_amethyst", "budding_amethyst");
        makeResources("bundle", "bundle");
        makeResources("cactus_side", "cactus");
        makeResources("cake", "cake");
        makeResources("calcite", "calcite");
        makeResources("campfire", "campfire");
        makeResources("candle", "candle");
        makeResources("carrot", "carrot");
        makeResources("carrot_on_a_stick", "carrot_on_a_stick");
        makeResources("cartography_table_side2", "cartography_table");
        makeResources("carved_pumpkin", "carved_pumpkin");
        makeResources("cat", "cat_spawn_egg");
        makeResources("cauldron", "cauldron");
        makeResources("cavespider", "cave_spider_spawn_egg");
        makeResources("chain", "chain");
        makeResources("chain_command_block_front", "chain_command_block");
        makeResources("chainmail_boots", "chainmail_boots");
        makeResources("chainmail_chestplate", "chainmail_chestplate");
        makeResources("chainmail_helmet", "chainmail_helmet");
        makeResources("chainmail_leggings", "chainmail_leggings");
        makeResources("charcoal", "charcoal");
        makeResources("chest", "chest");
        makeResources("chest_minecart", "chest_minecart");
        makeResources("chickenface", "chicken_spawn_egg");
        makeResources("chipped_anvil_top", "chipped_anvil");
        makeResources("chiseled_deepslate", "chiseled_deepslate");
        makeResources("chiseled_nether_bricks", "chiseled_nether_bricks");
        makeResources("chiseled_polished_blackstone", "chiseled_polished_blackstone");
        makeResources("chiseled_quartz_block", "chiseled_quartz_block");
        makeResources("chiseled_red_sandstone", "chiseled_red_sandstone");
        makeResources("chiseled_sandstone", "chiseled_sandstone");
        makeResources("chiseled_stone_bricks", "chiseled_stone_bricks");
        makeResources("chorus_flower", "chorus_flower");
        makeResources("chorus_fruit", "chorus_fruit");
        makeResources("chorus_plant", "chorus_plant");
        makeResources("clay", "clay");
        makeResources("clay_ball", "clay_ball");
        makeResources("clock_00", "clock");
        makeResources("coal", "coal");
        makeResources("coal_ore", "coal_ore");
        makeResources("coarse_dirt", "coarse_dirt");
        makeResources("cobbled_deepslate", "cobbled_deepslate");
        makeResources("cobbled_deepslate", "cobbled_deepslate_slab");
        makeResources("cobbled_deepslate", "cobbled_deepslate_stairs");
        makeResources("cobbled_deepslate", "deepslate_wall");
        makeResources("cobblestone", "cobblestone");
        makeResources("cobblestone", "cobblestone_slab");
        makeResources("cobblestone", "cobblestone_stairs");
        makeResources("cobblestone", "cobblestone_wall");
        makeResources("cobweb", "cobweb");
        makeResources("cocoa_beans", "cocoa_beans");
        makeResources("cod_bucket", "cod_bucket");
        makeResources("codface", "cod_spawn_egg");
        makeResources("command_block_front", "command_block");
        makeResources("command_block_minecart", "command_block_minecart");
        makeResources("comparator", "comparator");
        makeResources("compass_00", "compass");
        makeResources("composter_side", "composter");
        makeResources("conduit", "conduit");
        makeResources("cooked_chicken", "cooked_chicken");
        makeResources("cooked_cod", "cooked_cod");
        makeResources("cooked_mutton", "cooked_mutton");
        makeResources("cooked_porkchop", "cooked_porkchop");
        makeResources("cooked_rabbit", "cooked_rabbit");
        makeResources("cooked_salmon", "cooked_salmon");
        makeResources("cookie", "cookie");
        makeResources("copper_ingot", "copper_ingot");
        makeResources("copper_ore", "copper_ore");
        makeResources("cornflower", "cornflower");
        makeResources("cow", "cow_spawn_egg");
        makeResources("cracked_deepslate_bricks", "cracked_deepslate_bricks");
        makeResources("cracked_deepslate_tiles", "cracked_deepslate_tiles");
        makeResources("cracked_nether_bricks", "cracked_nether_bricks");
        makeResources("cracked_polished_blackstone_bricks", "cracked_polished_blackstone_bricks");
        makeResources("cracked_stone_bricks", "cracked_stone_bricks");
        makeResources("crafting_table_front", "crafting_table");
        makeResources("creeper_banner_pattern", "creeper_banner_pattern");
        makeResources("creeper_head", "creeper_head");
        makeResources("creeper", "creeper_spawn_egg");
        makeResources("crimson_planks", "crimson_button");
        makeResources("crimson_door", "crimson_door");
        makeResources("crimson_planks", "crimson_fence");
        makeResources("crimson_planks", "crimson_fence_gate");
        makeResources("crimson_fungus", "crimson_fungus");
        makeResources("crimson_stem", "crimson_hyphae");
        makeResources("crimson_nylium", "crimson_nylium");
        makeResources("crimson_planks", "crimson_planks");
        makeResources("crimson_planks", "crimson_pressure_plate");
        makeResources("crimson_roots", "crimson_roots");
        makeResources("crimson_sign", "crimson_sign");
        makeResources("crimson_planks", "crimson_slab");
        makeResources("crimson_planks", "crimson_stairs");
        makeResources("crimson_stem", "crimson_stem");
        makeResources("crimson_planks", "crimson_trapdoor");
        makeResources("crossbow_standby", "crossbow");
        makeResources("crying_obsidian", "crying_obsidian");
        makeResources("cut_copper", "cut_copper");
        makeResources("cut_copper", "cut_copper_slab");
        makeResources("cut_copper", "cut_copper_stairs");
        makeResources("cut_red_sandstone", "cut_red_sandstone");
        makeResources("cut_red_sandstone", "cut_red_sandstone_slab");
        makeResources("cut_sandstone", "cut_sandstone");
        makeResources("cut_sandstone", "cut_sandstone_slab");
        makeResources("cyan_concrete", "cyan_banner");
        makeResources("cyan_wool", "cyan_bed");
        makeResources("cyan_candle", "cyan_candle");
        makeResources("cyan_wool", "cyan_carpet");
        makeResources("cyan_concrete", "cyan_concrete");
        makeResources("cyan_concrete_powder", "cyan_concrete_powder");
        makeResources("cyan_dye", "cyan_dye");
        makeResources("cyan_glazed_terracotta", "cyan_glazed_terracotta");
        makeResources("cyan_shulker_box", "cyan_shulker_box");
        makeResources("cyan_stained_glass", "cyan_stained_glass");
        makeResources("cyan_stained_glass", "cyan_stained_glass_pane");
        makeResources("cyan_terracotta", "cyan_terracotta");
        makeResources("cyan_wool", "cyan_wool");
        makeResources("damaged_anvil_top", "damaged_anvil");
        makeResources("dandelion", "dandelion");
        makeResources("dark_oak_boat", "dark_oak_boat");
        makeResources("dark_oak_planks", "dark_oak_button");
        makeResources("dark_oak_door", "dark_oak_door");
        makeResources("dark_oak_planks", "dark_oak_fence");
        makeResources("dark_oak_planks", "dark_oak_fence_gate");
        makeResources("dark_oak_leaves", "dark_oak_leaves");
        makeResources("dark_oak_log", "dark_oak_log");
        makeResources("dark_oak_planks", "dark_oak_planks");
        makeResources("dark_oak_planks", "dark_oak_pressure_plate");
        makeResources("dark_oak_sapling", "dark_oak_sapling");
        makeResources("dark_oak_planks", "dark_oak_sign");
        makeResources("dark_oak_planks", "dark_oak_slab");
        makeResources("dark_oak_planks", "dark_oak_stairs");
        makeResources("dark_oak_trapdoor", "dark_oak_trapdoor");
        makeResources("dark_oak_log", "dark_oak_wood");
        makeResources("dark_prismarine", "dark_prismarine");
        makeResources("dark_prismarine", "dark_prismarine_slab");
        makeResources("dark_prismarine", "dark_prismarine_stairs");
        makeResources("daylight_detector_top", "daylight_detector");
        makeResources("dead_brain_coral", "dead_brain_coral");
        makeResources("dead_brain_coral_block", "dead_brain_coral_block");
        makeResources("dead_brain_coral_fan", "dead_brain_coral_fan");
        makeResources("dead_bubble_coral", "dead_bubble_coral");
        makeResources("dead_bubble_coral_block", "dead_bubble_coral_block");
        makeResources("dead_bubble_coral_fan", "dead_bubble_coral_fan");
        makeResources("dead_bush", "dead_bush");
        makeResources("dead_fire_coral", "dead_fire_coral");
        makeResources("dead_fire_coral_block", "dead_fire_coral_block");
        makeResources("dead_fire_coral_fan", "dead_fire_coral_fan");
        makeResources("dead_horn_coral", "dead_horn_coral");
        makeResources("dead_horn_coral_block", "dead_horn_coral_block");
        makeResources("dead_horn_coral_fan", "dead_horn_coral_fan");
        makeResources("dead_tube_coral", "dead_tube_coral");
        makeResources("dead_tube_coral_block", "dead_tube_coral_block");
        makeResources("dead_tube_coral_fan", "dead_tube_coral_fan");
        makeResources("stick", "debug_stick");
        makeResources("deepslate", "deepslate");
        makeResources("deepslate_bricks", "deepslate_brick_slab");
        makeResources("deepslate_bricks", "deepslate_brick_stairs");
        makeResources("deepslate_bricks", "deepslate_brick_wall");
        makeResources("deepslate_bricks", "deepslate_bricks");
        makeResources("deepslate_coal_ore", "deepslate_coal_ore");
        makeResources("deepslate_copper_ore", "deepslate_copper_ore");
        makeResources("deepslate_diamond_ore", "deepslate_diamond_ore");
        makeResources("deepslate_emerald_ore", "deepslate_emerald_ore");
        makeResources("deepslate_gold_ore", "deepslate_gold_ore");
        makeResources("deepslate_iron_ore", "deepslate_iron_ore");
        makeResources("deepslate_lapis_ore", "deepslate_lapis_ore");
        makeResources("deepslate_redstone_ore", "deepslate_redstone_ore");
        makeResources("deepslate_tiles", "deepslate_tile_slab");
        makeResources("deepslate_tiles", "deepslate_tile_stairs");
        makeResources("deepslate_tiles", "deepslate_tile_wall");
        makeResources("deepslate_tiles", "deepslate_tiles");
        makeResources("detector_rail", "detector_rail");
        makeResources("diamond", "diamond");
        makeResources("diamond_axe", "diamond_axe");
        makeResources("diamond_boots", "diamond_boots");
        makeResources("diamond_chestplate", "diamond_chestplate");
        makeResources("diamond_helmet", "diamond_helmet");
        makeResources("diamond_hoe", "diamond_hoe");
        makeResources("diamond_horse_armor", "diamond_horse_armor");
        makeResources("diamond_leggings", "diamond_leggings");
        makeResources("diamond_ore", "diamond_ore");
        makeResources("diamond_pickaxe", "diamond_pickaxe");
        makeResources("diamond_shovel", "diamond_shovel");
        makeResources("diamond_sword", "diamond_sword");
        makeResources("diorite", "diorite");
        makeResources("diorite", "diorite_slab");
        makeResources("diorite", "diorite_stairs");
        makeResources("diorite", "diorite_wall");
        makeResources("dirt", "dirt");
        makeResources("dispenser_front", "dispenser");
        makeResources("dolphin", "dolphin_spawn_egg");
        makeResources("donkey", "donkey_spawn_egg");
        makeResources("dragon_breath", "dragon_breath");
        makeResources("dragon_egg", "dragon_egg");
        makeResources("dragon_head", "dragon_head");
        makeResources("dried_kelp", "dried_kelp");
        makeResources("dried_kelp_side", "dried_kelp_block");
        makeResources("dripstone_block", "dripstone_block");
        makeResources("dropper_front", "dropper");
        makeResources("drowned", "drowned_spawn_egg");
        makeResources("egg", "egg");
        makeResources("elderguardian", "elder_guardian_spawn_egg");
        makeResources("elytra", "elytra");
        makeResources("emerald", "emerald");
        makeResources("emerald_ore", "emerald_ore");
        makeResources("enchanted_book", "enchanted_book");
        makeResources("golden_apple", "enchanted_golden_apple");
        makeResources("enchanting_table_side", "enchanting_table");
        makeResources("end_crystal", "end_crystal");
        makeResources("end_portal_frame_top", "end_portal_frame");
        makeResources("end_rod", "end_rod");
        makeResources("end_stone", "end_stone");
        makeResources("end_stone_bricks", "end_stone_brick_slab");
        makeResources("end_stone_bricks", "end_stone_brick_stairs");
        makeResources("end_stone_bricks", "end_stone_brick_wall");
        makeResources("end_stone_bricks", "end_stone_bricks");
        makeResources("ender_chest", "ender_chest");
        makeResources("ender_eye", "ender_eye");
        makeResources("ender_pearl", "ender_pearl");
        makeResources("enderman", "enderman_spawn_egg");
        makeResources("endermite", "endermite_spawn_egg");
        makeResources("evoker", "evoker_spawn_egg");
        makeResources("experience_bottle", "experience_bottle");
        makeResources("exposed_copper", "exposed_copper");
        makeResources("exposed_cut_copper", "exposed_cut_copper");
        makeResources("exposed_cut_copper", "exposed_cut_copper_slab");
        makeResources("exposed_cut_copper", "exposed_cut_copper_stairs");
        makeResources("farmland", "farmland");
        makeResources("feather", "feather");
        makeResources("fermented_spider_eye", "fermented_spider_eye");
        makeResources("fern", "fern");
        makeResources("filled_map", "filled_map");
        makeResources("fire_charge", "fire_charge");
        makeResources("fire_coral", "fire_coral");
        makeResources("fire_coral_block", "fire_coral_block");
        makeResources("fire_coral_fan", "fire_coral_fan");
        makeResources("firework_rocket", "firework_rocket");
        makeResources("firework_star", "firework_star");
        makeResources("fishing_rod", "fishing_rod");
        makeResources("fletching_table_front", "fletching_table");
        makeResources("flint", "flint");
        makeResources("flint_and_steel", "flint_and_steel");
        makeResources("flower_banner_pattern", "flower_banner_pattern");
        makeResources("flower_pot", "flower_pot");
        makeResources("flowering_azalea_top", "flowering_azalea");
        makeResources("flowering_azalea_leaves", "azalea_leaves_flowers");
        makeResources("fox", "fox_spawn_egg");
        makeResources("furnace_front", "furnace");
        makeResources("furnace_minecart", "furnace_minecart");
        makeResources("ghast", "ghast_spawn_egg");
        makeResources("ghast_tear", "ghast_tear");
        makeResources("gilded_blackstone", "gilded_blackstone");
        makeResources("glass", "glass");
        makeResources("glass_bottle", "glass_bottle");
        makeResources("glass", "glass_pane");
        makeResources("glistering_melon_slice", "glistering_melon_slice");
        makeResources("globe_banner_pattern", "globe_banner_pattern");
        makeResources("glow_berries", "glow_berries");
        makeResources("glow_ink_sac", "glow_ink_sac");
        makeResources("glow_item_frame", "glow_item_frame");
        makeResources("glow_lichen", "glow_lichen");
        makeResources("glowsquid", "glow_squid_spawn_egg");
        makeResources("glowstone", "glowstone");
        makeResources("glowstone_dust", "glowstone_dust");
        makeResources("goat", "goat_spawn_egg");
        makeResources("gold_ingot", "gold_ingot");
        makeResources("gold_nugget", "gold_nugget");
        makeResources("gold_ore", "gold_ore");
        makeResources("golden_apple", "golden_apple");
        makeResources("golden_axe", "golden_axe");
        makeResources("golden_boots", "golden_boots");
        makeResources("golden_carrot", "golden_carrot");
        makeResources("golden_chestplate", "golden_chestplate");
        makeResources("golden_helmet", "golden_helmet");
        makeResources("golden_hoe", "golden_hoe");
        makeResources("golden_horse_armor", "golden_horse_armor");
        makeResources("golden_leggings", "golden_leggings");
        makeResources("golden_pickaxe", "golden_pickaxe");
        makeResources("golden_shovel", "golden_shovel");
        makeResources("golden_sword", "golden_sword");
        makeResources("granite", "granite");
        makeResources("granite", "granite_slab");
        makeResources("granite", "granite_stairs");
        makeResources("granite", "granite_wall");
        makeResources("grass", "grass");
        makeResources("grass_block_side", "grass_block");
        makeResources("grass_path_side", "dirt_path");
        makeResources("gravel", "gravel");
        makeResources("gray_concrete", "gray_banner");
        makeResources("gray_wool", "gray_bed");
        makeResources("gray_candle", "gray_candle");
        makeResources("gray_wool", "gray_carpet");
        makeResources("gray_concrete", "gray_concrete");
        makeResources("gray_concrete_powder", "gray_concrete_powder");
        makeResources("gray_dye", "gray_dye");
        makeResources("gray_glazed_terracotta", "gray_glazed_terracotta");
        makeResources("gray_shulker_box", "gray_shulker_box");
        makeResources("gray_stained_glass", "gray_stained_glass");
        makeResources("gray_stained_glass", "gray_stained_glass_pane");
        makeResources("gray_terracotta", "gray_terracotta");
        makeResources("gray_wool", "gray_wool");
        makeResources("green_concrete", "green_banner");
        makeResources("green_wool", "green_bed");
        makeResources("green_candle", "green_candle");
        makeResources("green_wool", "green_carpet");
        makeResources("green_concrete", "green_concrete");
        makeResources("green_concrete_powder", "green_concrete_powder");
        makeResources("green_dye", "green_dye");
        makeResources("green_glazed_terracotta", "green_glazed_terracotta");
        makeResources("green_shulker_box", "green_shulker_box");
        makeResources("green_stained_glass", "green_stained_glass");
        makeResources("green_stained_glass", "green_stained_glass_pane");
        makeResources("green_terracotta", "green_terracotta");
        makeResources("green_wool", "green_wool");
        makeResources("grindstone_side", "grindstone");
        makeResources("guardian", "guardian_spawn_egg");
        makeResources("gunpowder", "gunpowder");
        makeResources("hanging_roots", "hanging_roots");
        makeResources("hay_block_side", "hay_block");
        makeResources("heart_of_the_sea", "heart_of_the_sea");
        makeResources("iron_block", "heavy_weighted_pressure_plate");
        makeResources("hoglin", "hoglin_spawn_egg");
        makeResources("honey_block_top", "honey_block");
        makeResources("honey_bottle", "honey_bottle");
        makeResources("honeycomb", "honeycomb");
        makeResources("honeycomb_block", "honeycomb_block");
        makeResources("hopper", "hopper");
        makeResources("hopper_minecart", "hopper_minecart");
        makeResources("horn_coral", "horn_coral");
        makeResources("horn_coral_block", "horn_coral_block");
        makeResources("horn_coral_fan", "horn_coral_fan");
        makeResources("horse", "horse_spawn_egg");
        makeResources("husk", "husk_spawn_egg");
        makeResources("ice", "ice");
        makeResources("chiseled_stone_bricks", "infested_chiseled_stone_bricks");
        makeResources("cobblestone", "infested_cobblestone");
        makeResources("cracked_stone_bricks", "infested_cracked_stone_bricks");
        makeResources("deepslate", "infested_deepslate");
        makeResources("mossy_stone_bricks", "infested_mossy_stone_bricks");
        makeResources("stone", "infested_stone");
        makeResources("stone_bricks", "infested_stone_bricks");
        makeResources("ink_sac", "ink_sac");
        makeResources("iron_axe", "iron_axe");
        makeResources("iron_bars", "iron_bars");
        makeResources("iron_boots", "iron_boots");
        makeResources("iron_chestplate", "iron_chestplate");
        makeResources("iron_door", "iron_door");
        makeResources("iron_helmet", "iron_helmet");
        makeResources("iron_hoe", "iron_hoe");
        makeResources("iron_horse_armor", "iron_horse_armor");
        makeResources("iron_ingot", "iron_ingot");
        makeResources("iron_leggings", "iron_leggings");
        makeResources("iron_nugget", "iron_nugget");
        makeResources("iron_ore", "iron_ore");
        makeResources("iron_pickaxe", "iron_pickaxe");
        makeResources("iron_shovel", "iron_shovel");
        makeResources("iron_sword", "iron_sword");
        makeResources("iron_trapdoor", "iron_trapdoor");
        makeResources("item_frame", "item_frame");
        makeResources("jack_o_lantern", "jack_o_lantern");
        makeResources("jigsaw_side", "jigsaw");
        makeResources("jukebox_side", "jukebox");
        makeResources("jungle_boat", "jungle_boat");
        makeResources("jungle_planks", "jungle_button");
        makeResources("jungle_door", "jungle_door");
        makeResources("jungle_planks", "jungle_fence");
        makeResources("jungle_planks", "jungle_fence_gate");
        makeResources("jungle_leaves", "jungle_leaves");
        makeResources("jungle_log", "jungle_log");
        makeResources("jungle_planks", "jungle_planks");
        makeResources("jungle_planks", "jungle_pressure_plate");
        makeResources("jungle_sapling", "jungle_sapling");
        makeResources("jungle_planks", "jungle_sign");
        makeResources("jungle_planks", "jungle_slab");
        makeResources("jungle_planks", "jungle_stairs");
        makeResources("jungle_trapdoor", "jungle_trapdoor");
        makeResources("jungle_log", "jungle_wood");
        makeResources("kelp", "kelp");
        makeResources("knowledge_book", "knowledge_book");
        makeResources("ladder", "ladder");
        makeResources("lantern", "lantern");
        makeResources("lapis_lazuli", "lapis_lazuli");
        makeResources("lapis_ore", "lapis_ore");
        makeResources("large_amethyst_bud", "large_amethyst_bud");
        makeResources("fern", "large_fern");
        makeResources("lava_still", "lava_bucket");
        makeResources("lead", "lead");
        makeResources("leather", "leather");
        makeResources("leather_boots", "leather_boots");
        makeResources("leather_chestplate", "leather_chestplate");
        makeResources("leather_helmet", "leather_helmet");
        makeResources("leather_horse_armor", "leather_horse_armor");
        makeResources("leather_leggings", "leather_leggings");
        makeResources("bookshelf", "lectern");
        makeResources("lever", "lever");
        makeResources("light_15", "light");
        makeResources("light_blue_concrete", "light_blue_banner");
        makeResources("light_blue_wool", "light_blue_bed");
        makeResources("light_blue_candle", "light_blue_candle");
        makeResources("light_blue_wool", "light_blue_carpet");
        makeResources("light_blue_concrete", "light_blue_concrete");
        makeResources("light_blue_concrete_powder", "light_blue_concrete_powder");
        makeResources("light_blue_dye", "light_blue_dye");
        makeResources("light_blue_glazed_terracotta", "light_blue_glazed_terracotta");
        makeResources("light_blue_shulker_box", "light_blue_shulker_box");
        makeResources("light_blue_stained_glass", "light_blue_stained_glass");
        makeResources("light_blue_stained_glass", "light_blue_stained_glass_pane");
        makeResources("light_blue_terracotta", "light_blue_terracotta");
        makeResources("light_blue_wool", "light_blue_wool");
        makeResources("light_gray_concrete", "light_gray_banner");
        makeResources("light_gray_wool", "light_gray_bed");
        makeResources("light_gray_candle", "light_gray_candle");
        makeResources("light_gray_wool", "light_gray_carpet");
        makeResources("light_gray_concrete", "light_gray_concrete");
        makeResources("light_gray_concrete_powder", "light_gray_concrete_powder");
        makeResources("light_gray_dye", "light_gray_dye");
        makeResources("light_gray_glazed_terracotta", "light_gray_glazed_terracotta");
        makeResources("light_gray_shulker_box", "light_gray_shulker_box");
        makeResources("light_gray_stained_glass", "light_gray_stained_glass");
        makeResources("light_gray_stained_glass", "light_gray_stained_glass_pane");
        makeResources("light_gray_terracotta", "light_gray_terracotta");
        makeResources("light_gray_wool", "light_gray_wool");
        makeResources("gold_block", "light_weighted_pressure_plate");
        makeResources("lightning_rod", "lightning_rod");
        makeResources("lilac_top", "lilac");
        makeResources("lily_of_the_valley", "lily_of_the_valley");
        makeResources("lily_pad", "lily_pad");
        makeResources("lime_concrete", "lime_banner");
        makeResources("lime_wool", "lime_bed");
        makeResources("lime_candle", "lime_candle");
        makeResources("lime_wool", "lime_carpet");
        makeResources("lime_concrete", "lime_concrete");
        makeResources("lime_concrete_powder", "lime_concrete_powder");
        makeResources("lime_dye", "lime_dye");
        makeResources("lime_glazed_terracotta", "lime_glazed_terracotta");
        makeResources("lime_shulker_box", "lime_shulker_box");
        makeResources("lime_stained_glass", "lime_stained_glass");
        makeResources("lime_stained_glass", "lime_stained_glass_pane");
        makeResources("lime_terracotta", "lime_terracotta");
        makeResources("lime_wool", "lime_wool");
        makeResources("lingering_potion", "lingering_potion");
        makeResources("llama", "llama_spawn_egg");
        makeResources("lodestone_side", "lodestone");
        makeResources("loom_front", "loom");
        makeResources("magenta_concrete", "magenta_banner");
        makeResources("magenta_wool", "magenta_bed");
        makeResources("magenta_candle", "magenta_candle");
        makeResources("magenta_wool", "magenta_carpet");
        makeResources("magenta_concrete", "magenta_concrete");
        makeResources("magenta_concrete_powder", "magenta_concrete_powder");
        makeResources("magenta_dye", "magenta_dye");
        makeResources("magenta_glazed_terracotta", "magenta_glazed_terracotta");
        makeResources("magenta_shulker_box", "magenta_shulker_box");
        makeResources("magenta_stained_glass", "magenta_stained_glass");
        makeResources("magenta_stained_glass", "magenta_stained_glass_pane");
        makeResources("magenta_terracotta", "magenta_terracotta");
        makeResources("magenta_wool", "magenta_wool");
        makeResources("magma", "magma_block");
        makeResources("magma_cream", "magma_cream");
        makeResources("magmacube", "magma_cube_spawn_egg");
        makeResources("map", "map");
        makeResources("medium_amethyst_bud", "medium_amethyst_bud");
        makeResources("melon_side", "melon");
        makeResources("melon_seeds", "melon_seeds");
        makeResources("melon_slice", "melon_slice");
        makeResources("milk", "milk_bucket");
        makeResources("minecart", "minecart");
        makeResources("mojang_banner_pattern", "mojang_banner_pattern");
        makeResources("mooshroom", "mooshroom_spawn_egg");
        makeResources("moss_block", "moss_block");
        makeResources("moss_block", "moss_carpet");
        makeResources("mossy_cobblestone", "mossy_cobblestone");
        makeResources("mossy_cobblestone", "mossy_cobblestone_slab");
        makeResources("mossy_cobblestone", "mossy_cobblestone_stairs");
        makeResources("mossy_cobblestone", "mossy_cobblestone_wall");
        makeResources("mossy_stone_bricks", "mossy_stone_brick_slab");
        makeResources("mossy_stone_bricks", "mossy_stone_brick_stairs");
        makeResources("mossy_stone_bricks", "mossy_stone_brick_wall");
        makeResources("mossy_stone_bricks", "mossy_stone_bricks");
        makeResources("mule", "mule_spawn_egg");
        makeResources("mushroom_stem", "mushroom_stem");
        makeResources("mushroom_stew", "mushroom_stew");
        makeResources("music_disc_11", "music_disc_11");
        makeResources("music_disc_13", "music_disc_13");
        makeResources("music_disc_blocks", "music_disc_blocks");
        makeResources("music_disc_cat", "music_disc_cat");
        makeResources("music_disc_chirp", "music_disc_chirp");
        makeResources("music_disc_far", "music_disc_far");
        makeResources("music_disc_mall", "music_disc_mall");
        makeResources("music_disc_mellohi", "music_disc_mellohi");
        makeResources("music_disc_otherside", "music_disc_otherside");
        makeResources("music_disc_pigstep", "music_disc_pigstep");
        makeResources("music_disc_stal", "music_disc_stal");
        makeResources("music_disc_strad", "music_disc_strad");
        makeResources("music_disc_wait", "music_disc_wait");
        makeResources("music_disc_ward", "music_disc_ward");
        makeResources("mycelium_side", "mycelium");
        makeResources("name_tag", "name_tag");
        makeResources("nautilus_shell", "nautilus_shell");
        makeResources("nether_bricks", "nether_brick");
        makeResources("nether_bricks", "nether_brick_fence");
        makeResources("nether_bricks", "nether_brick_slab");
        makeResources("nether_bricks", "nether_brick_stairs");
        makeResources("nether_bricks", "nether_brick_wall");
        makeResources("nether_bricks", "nether_bricks");
        makeResources("nether_gold_ore", "nether_gold_ore");
        makeResources("nether_quartz_ore", "nether_quartz_ore");
        makeResources("nether_sprouts", "nether_sprouts");
        makeResources("nether_star", "nether_star");
        makeResources("nether_wart", "nether_wart");
        makeResources("nether_wart_block", "nether_wart_block");
        makeResources("netherite_axe", "netherite_axe");
        makeResources("netherite_boots", "netherite_boots");
        makeResources("netherite_chestplate", "netherite_chestplate");
        makeResources("netherite_helmet", "netherite_helmet");
        makeResources("netherite_hoe", "netherite_hoe");
        makeResources("netherite_ingot", "netherite_ingot");
        makeResources("netherite_leggings", "netherite_leggings");
        makeResources("netherite_pickaxe", "netherite_pickaxe");
        makeResources("netherite_scrap", "netherite_scrap");
        makeResources("netherite_shovel", "netherite_shovel");
        makeResources("netherite_sword", "netherite_sword");
        makeResources("netherrack", "netherrack");
        makeResources("note_block", "note_block");
        makeResources("oak_boat", "oak_boat");
        makeResources("oak_planks", "oak_button");
        makeResources("oak_door", "oak_door");
        makeResources("oak_planks", "oak_fence");
        makeResources("oak_planks", "oak_fence_gate");
        makeResources("oak_leaves", "oak_leaves");
        makeResources("oak_log", "oak_log");
        makeResources("oak_planks", "oak_planks");
        makeResources("oak_planks", "oak_pressure_plate");
        makeResources("oak_sapling", "oak_sapling");
        makeResources("oak_sign", "oak_sign");
        makeResources("oak_planks", "oak_slab");
        makeResources("oak_planks", "oak_stairs");
        makeResources("oak_trapdoor", "oak_trapdoor");
        makeResources("oak_log", "oak_wood");
        makeResources("observer_front", "observer");
        makeResources("obsidian", "obsidian");
        makeResources("ocelot", "ocelot_spawn_egg");
        makeResources("orange_concrete", "orange_banner");
        makeResources("orange_wool", "orange_bed");
        makeResources("orange_candle", "orange_candle");
        makeResources("orange_wool", "orange_carpet");
        makeResources("orange_concrete", "orange_concrete");
        makeResources("orange_concrete_powder", "orange_concrete_powder");
        makeResources("orange_dye", "orange_dye");
        makeResources("orange_glazed_terracotta", "orange_glazed_terracotta");
        makeResources("orange_shulker_box", "orange_shulker_box");
        makeResources("orange_stained_glass", "orange_stained_glass");
        makeResources("orange_stained_glass", "orange_stained_glass_pane");
        makeResources("orange_terracotta", "orange_terracotta");
        makeResources("orange_tulip", "orange_tulip");
        makeResources("orange_wool", "orange_wool");
        makeResources("oxeye_daisy", "oxeye_daisy");
        makeResources("oxidized_copper", "oxidized_copper");
        makeResources("oxidized_cut_copper", "oxidized_cut_copper");
        makeResources("oxidized_cut_copper", "oxidized_cut_copper_slab");
        makeResources("oxidized_cut_copper", "oxidized_cut_copper_stairs");
        makeResources("packed_ice", "packed_ice");
        makeResources("painting", "painting");
        makeResources("panda", "panda_spawn_egg");
        makeResources("paper", "paper");
        makeResources("parrot", "parrot_spawn_egg");
        makeResources("peony_top", "peony");
        makeResources("oak_planks", "petrified_oak_slab");
        makeResources("phantom_membrane", "phantom_membrane");
        makeResources("phantom", "phantom_spawn_egg");
        makeResources("pig", "pig_spawn_egg");
        makeResources("piglin_banner_pattern", "piglin_banner_pattern");
        makeResources("piglin", "piglin_spawn_egg");
        makeResources("pillager", "pillager_spawn_egg");
        makeResources("pink_concrete", "pink_banner");
        makeResources("pink_wool", "pink_bed");
        makeResources("pink_candle", "pink_candle");
        makeResources("pink_wool", "pink_carpet");
        makeResources("pink_concrete", "pink_concrete");
        makeResources("pink_concrete_powder", "pink_concrete_powder");
        makeResources("pink_dye", "pink_dye");
        makeResources("pink_glazed_terracotta", "pink_glazed_terracotta");
        makeResources("pink_shulker_box", "pink_shulker_box");
        makeResources("pink_stained_glass", "pink_stained_glass");
        makeResources("pink_stained_glass", "pink_stained_glass_pane");
        makeResources("pink_terracotta", "pink_terracotta");
        makeResources("pink_tulip", "pink_tulip");
        makeResources("pink_wool", "pink_wool");
        makeResources("piston_top", "piston");
        makeResources("player_head", "player_head");
        makeResources("podzol_side", "podzol");
        makeResources("pointed_dripstone", "pointed_dripstone");
        makeResources("poisonous_potato", "poisonous_potato");
        makeResources("polarbear", "polar_bear_spawn_egg");
        makeResources("polished_andesite", "polished_andesite");
        makeResources("polished_andesite", "polished_andesite_slab");
        makeResources("polished_andesite", "polished_andesite_stairs");
        makeResources("polished_basalt_top", "polished_basalt");
        makeResources("polished_blackstone", "polished_blackstone");
        makeResources("polished_blackstone", "polished_blackstone_brick_slab");
        makeResources("polished_blackstone", "polished_blackstone_brick_stairs");
        makeResources("polished_blackstone", "polished_blackstone_brick_wall");
        makeResources("polished_blackstone", "polished_blackstone_bricks");
        makeResources("polished_blackstone", "polished_blackstone_button");
        makeResources("polished_blackstone", "polished_blackstone_pressure_plate");
        makeResources("polished_blackstone", "polished_blackstone_slab");
        makeResources("polished_blackstone", "polished_blackstone_stairs");
        makeResources("polished_blackstone", "polished_blackstone_wall");
        makeResources("polished_deepslate", "polished_deepslate");
        makeResources("polished_deepslate", "polished_deepslate_slab");
        makeResources("polished_deepslate", "polished_deepslate_stairs");
        makeResources("polished_deepslate", "polished_deepslate_wall");
        makeResources("polished_diorite", "polished_diorite");
        makeResources("polished_diorite", "polished_diorite_slab");
        makeResources("polished_diorite", "polished_diorite_stairs");
        makeResources("polished_granite", "polished_granite");
        makeResources("polished_granite", "polished_granite_slab");
        makeResources("polished_granite", "polished_granite_stairs");
        makeResources("popped_chorus_fruit", "popped_chorus_fruit");
        makeResources("poppy", "poppy");
        makeResources("porkchop", "porkchop");
        makeResources("potato", "potato");
        makeResources("potion", "potion");
        makeResources("powder_snow_bucket", "powder_snow_bucket");
        makeResources("powered_rail", "powered_rail");
        makeResources("prismarine", "prismarine");
        makeResources("prismarine_bricks", "prismarine_brick_slab");
        makeResources("prismarine_bricks", "prismarine_brick_stairs");
        makeResources("prismarine_bricks", "prismarine_bricks");
        makeResources("prismarine_crystals", "prismarine_crystals");
        makeResources("prismarine_shard", "prismarine_shard");
        makeResources("prismarine", "prismarine_slab");
        makeResources("prismarine", "prismarine_stairs");
        makeResources("prismarine", "prismarine_wall");
        makeResources("pufferfish", "pufferfish");
        makeResources("pufferfish_bucket", "pufferfish_bucket");
        makeResources("pufferfishface", "pufferfish_spawn_egg");
        makeResources("pumpkin_side", "pumpkin");
        makeResources("pumpkin_pie", "pumpkin_pie");
        makeResources("pumpkin_seeds", "pumpkin_seeds");
        makeResources("purple_concrete", "purple_banner");
        makeResources("purple_wool", "purple_bed");
        makeResources("purple_candle", "purple_candle");
        makeResources("purple_wool", "purple_carpet");
        makeResources("purple_concrete", "purple_concrete");
        makeResources("purple_concrete_powder", "purple_concrete_powder");
        makeResources("purple_dye", "purple_dye");
        makeResources("purple_glazed_terracotta", "purple_glazed_terracotta");
        makeResources("purple_shulker_box", "purple_shulker_box");
        makeResources("purple_stained_glass", "purple_stained_glass");
        makeResources("purple_stained_glass", "purple_stained_glass_pane");
        makeResources("purple_terracotta", "purple_terracotta");
        makeResources("purple_wool", "purple_wool");
        makeResources("purpur_block", "purpur_block");
        makeResources("purpur_pillar", "purpur_pillar");
        makeResources("purpur_block", "purpur_slab");
        makeResources("purpur_block", "purpur_stairs");
        makeResources("quartz_block_bottom", "quartz");
        makeResources("quartz_bricks", "quartz_bricks");
        makeResources("quartz_pillar", "quartz_pillar");
        makeResources("quartz_block_bottom", "quartz_slab");
        makeResources("quartz_block_bottom", "quartz_stairs");
        makeResources("rabbit_foot", "rabbit_foot");
        makeResources("rabbit_hide", "rabbit_hide");
        makeResources("rabbitface", "rabbit_spawn_egg");
        makeResources("rabbit_stew", "rabbit_stew");
        makeResources("rail", "rail");
        makeResources("ravager", "ravager_spawn_egg");
        makeResources("beef", "beef");
        makeResources("chicken", "chicken");
        makeResources("cod", "cod");
        makeResources("raw_copper", "raw_copper");
        makeResources("raw_gold", "raw_gold");
        makeResources("raw_iron", "raw_iron");
        makeResources("mutton", "mutton");
        makeResources("rabbit", "rabbit");
        makeResources("salmon", "salmon");
        makeResources("red_concrete", "red_banner");
        makeResources("red_wool", "red_bed");
        makeResources("red_candle", "red_candle");
        makeResources("red_wool", "red_carpet");
        makeResources("red_concrete", "red_concrete");
        makeResources("red_concrete_powder", "red_concrete_powder");
        makeResources("red_dye", "red_dye");
        makeResources("red_glazed_terracotta", "red_glazed_terracotta");
        makeResources("red_mushroom", "red_mushroom");
        makeResources("red_mushroom_block", "red_mushroom_block");
        makeResources("red_nether_bricks", "red_nether_brick_slab");
        makeResources("red_nether_bricks", "red_nether_brick_stairs");
        makeResources("red_nether_bricks", "red_nether_brick_wall");
        makeResources("red_nether_bricks", "red_nether_bricks");
        makeResources("red_sand", "red_sand");
        makeResources("red_sandstone", "red_sandstone");
        makeResources("red_sandstone", "red_sandstone_slab");
        makeResources("red_sandstone", "red_sandstone_stairs");
        makeResources("red_sandstone", "red_sandstone_wall");
        makeResources("red_shulker_box", "red_shulker_box");
        makeResources("red_stained_glass", "red_stained_glass");
        makeResources("red_stained_glass", "red_stained_glass_pane");
        makeResources("red_terracotta", "red_terracotta");
        makeResources("red_tulip", "red_tulip");
        makeResources("red_wool", "red_wool");
        makeResources("redstone", "redstone");
        makeResources("redstone_lamp", "redstone_lamp");
        makeResources("redstone_ore", "redstone_ore");
        makeResources("redstone_torch", "redstone_torch");
        makeResources("repeater", "repeater");
        makeResources("repeating_command_block_front", "repeating_command_block");
        makeResources("respawn_anchor_side3", "respawn_anchor");
        makeResources("rooted_dirt", "rooted_dirt");
        makeResources("rose_bush_top", "rose_bush");
        makeResources("rotten_flesh", "rotten_flesh");
        makeResources("saddle", "saddle");
        makeResources("salmon_bucket", "salmon_bucket");
        makeResources("salmonface", "salmon_spawn_egg");
        makeResources("sand", "sand");
        makeResources("sandstone", "sandstone");
        makeResources("sandstone", "sandstone_slab");
        makeResources("sandstone", "sandstone_stairs");
        makeResources("sandstone", "sandstone_wall");
        makeResources("scaffolding_top", "scaffolding");
        makeResources("sculk_sensor_bottom", "sculk_sensor");
        makeResources("scute", "scute");
        makeResources("sea_lantern", "sea_lantern");
        makeResources("sea_pickle", "sea_pickle");
        makeResources("seagrass", "seagrass");
        makeResources("shears", "shears");
        makeResources("sheep", "sheep_spawn_egg");
        makeResources("shield", "shield");
        makeResources("shroomlight", "shroomlight");
        makeResources("shulker_box", "shulker_box");
        makeResources("shulker_shell", "shulker_shell");
        makeResources("shulker", "shulker_spawn_egg");
        makeResources("silverfish", "silverfish_spawn_egg");
        makeResources("skeletonhorse", "skeleton_horse_spawn_egg");
        makeResources("skeleton_skull", "skeleton_skull");
        makeResources("skeleton", "skeleton_spawn_egg");
        makeResources("skull_banner_pattern", "skull_banner_pattern");
        makeResources("slime_ball", "slime_ball");
        makeResources("slime_block", "slime_block");
        makeResources("slime", "slime_spawn_egg");
        makeResources("small_amethyst_bud", "small_amethyst_bud");
        makeResources("small_dripleaf_top", "small_dripleaf");
        makeResources("smithing_table_front", "smithing_table");
        makeResources("smoker_front", "smoker");
        makeResources("smooth_basalt", "smooth_basalt");
        makeResources("quartz_block_bottom", "smooth_quartz");
        makeResources("quartz_block_bottom", "smooth_quartz_slab");
        makeResources("quartz_block_bottom", "smooth_quartz_stairs");
        makeResources("red_sandstone", "smooth_red_sandstone");
        makeResources("red_sandstone", "smooth_red_sandstone_slab");
        makeResources("red_sandstone", "smooth_red_sandstone_stairs");
        makeResources("sandstone", "smooth_sandstone");
        makeResources("sandstone", "smooth_sandstone_slab");
        makeResources("red_sandstone", "smooth_sandstone_stairs");
        makeResources("smooth_stone", "smooth_stone");
        makeResources("smooth_stone_slab_side", "smooth_stone_slab");
        makeResources("snow", "snow");
        makeResources("snow", "snow_block");
        makeResources("snowball", "snowball");
        makeResources("soul_campfire", "soul_campfire");
        makeResources("soul_lantern", "soul_lantern");
        makeResources("soul_sand", "soul_sand");
        makeResources("soul_soil", "soul_soil");
        makeResources("soul_torch", "soul_torch");
        makeResources("spawner", "spawner");
        makeResources("spectral_arrow", "spectral_arrow");
        makeResources("spider_eye", "spider_eye");
        makeResources("spider", "spider_spawn_egg");
        makeResources("splash_potion", "splash_potion");
        makeResources("sponge", "sponge");
        makeResources("spore_blossom", "spore_blossom");
        makeResources("spruce_boat", "spruce_boat");
        makeResources("spruce_planks", "spruce_button");
        makeResources("spruce_door", "spruce_door");
        makeResources("spruce_planks", "spruce_fence");
        makeResources("spruce_planks", "spruce_fence_gate");
        makeResources("spruce_leaves", "spruce_leaves");
        makeResources("spruce_log", "spruce_log");
        makeResources("spruce_planks", "spruce_planks");
        makeResources("spruce_planks", "spruce_pressure_plate");
        makeResources("spruce_sapling", "spruce_sapling");
        makeResources("spruce_planks", "spruce_sign");
        makeResources("spruce_planks", "spruce_slab");
        makeResources("spruce_planks", "spruce_stairs");
        makeResources("spruce_trapdoor", "spruce_trapdoor");
        makeResources("spruce_log", "spruce_wood");
        makeResources("spyglass", "spyglass");
        makeResources("squid", "squid_spawn_egg");
        makeResources("cooked_beef", "cooked_beef");
        makeResources("stick", "stick");
        makeResources("piston_top_sticky", "sticky_piston");
        makeResources("stone", "stone");
        makeResources("stone_axe", "stone_axe");
        makeResources("stone_bricks", "stone_brick_slab");
        makeResources("stone", "stone_brick_stairs");
        makeResources("stone_bricks", "stone_brick_wall");
        makeResources("stone_bricks", "stone_bricks");
        makeResources("stone", "stone_button");
        makeResources("stone_hoe", "stone_hoe");
        makeResources("stone_pickaxe", "stone_pickaxe");
        makeResources("stone", "stone_pressure_plate");
        makeResources("stone_shovel", "stone_shovel");
        makeResources("stone", "stone_slab");
        makeResources("stone", "stone_stairs");
        makeResources("stone_sword", "stone_sword");
        makeResources("stonecutter_top", "stonecutter");
        makeResources("stray", "stray_spawn_egg");
        makeResources("strider", "strider_spawn_egg");
        makeResources("string", "string");
        makeResources("stripped_acacia_log_top", "stripped_acacia_log");
        makeResources("stripped_dark_oak_log_top", "stripped_acacia_wood");
        makeResources("stripped_birch_log_top", "stripped_birch_log");
        makeResources("stripped_jungle_log_top", "stripped_birch_wood");
        makeResources("stripped_crimson_stem", "stripped_crimson_hyphae");
        makeResources("stripped_crimson_stem_top", "stripped_crimson_stem");
        makeResources("stripped_dark_oak_log_top", "stripped_dark_oak_log");
        makeResources("stripped_oak_log_top", "stripped_dark_oak_wood");
        makeResources("stripped_jungle_log_top", "stripped_jungle_log");
        makeResources("stripped_acacia_log_top", "stripped_jungle_wood");
        makeResources("stripped_oak_log_top", "stripped_oak_log");
        makeResources("stripped_spruce_log_top", "stripped_oak_wood");
        makeResources("stripped_spruce_log_top", "stripped_spruce_log");
        makeResources("stripped_birch_log_top", "stripped_spruce_wood");
        makeResources("stripped_warped_stem", "stripped_warped_hyphae");
        makeResources("stripped_warped_stem_top", "stripped_warped_stem");
        makeResources("structure_block", "structure_block");
        makeResources("structure_void", "structure_void");
        makeResources("sugar", "sugar");
        makeResources("sugar_cane", "sugar_cane");
        makeResources("sunflower_front", "sunflower");
        makeResources("suspicious_stew", "suspicious_stew");
        makeResources("sweet_berries", "sweet_berries");
        makeResources("grass", "tall_grass");
        makeResources("target_side", "target");
        makeResources("terracotta", "terracotta");
        makeResources("tinted_glass", "tinted_glass");
        makeResources("arrow", "tipped_arrow");
        makeResources("tnt_side", "tnt");
        makeResources("tnt_minecart", "tnt_minecart");
        makeResources("torch", "torch");
        makeResources("totem_of_undying", "totem_of_undying");
        makeResources("traderllama", "trader_llama_spawn_egg");
        makeResources("trapped_chest", "trapped_chest");
        makeResources("trident", "trident");
        makeResources("tripwire_hook", "tripwire_hook");
        makeResources("tropical_fish", "tropical_fish");
        makeResources("tropical_fish_bucket", "tropical_fish_bucket");
        makeResources("tropicalfish", "tropical_fish_spawn_egg");
        makeResources("tube_coral", "tube_coral");
        makeResources("tube_coral_block", "tube_coral_block");
        makeResources("tube_coral_fan", "tube_coral_fan");
        makeResources("tuff", "tuff");
        makeResources("turtle_egg", "turtle_egg");
        makeResources("turtle_helmet", "turtle_helmet");
        makeResources("turtle", "turtle_spawn_egg");
        makeResources("twisting_vines", "twisting_vines");
        makeResources("vex", "vex_spawn_egg");
        makeResources("villager", "villager_spawn_egg");
        makeResources("vindicator", "vindicator_spawn_egg");
        makeResources("seagrass", "vine");
        makeResources("wanderingtrader", "wandering_trader_spawn_egg");
        makeResources("warped_planks", "warped_button");
        makeResources("warped_door", "warped_door");
        makeResources("warped_planks", "warped_fence");
        makeResources("warped_planks", "warped_fence_gate");
        makeResources("warped_fungus", "warped_fungus");
        makeResources("warped_fungus_on_a_stick", "warped_fungus_on_a_stick");
        makeResources("warped_stem", "warped_hyphae");
        makeResources("warped_nylium", "warped_nylium");
        makeResources("warped_planks", "warped_planks");
        makeResources("warped_planks", "warped_pressure_plate");
        makeResources("warped_roots", "warped_roots");
        makeResources("warped_sign", "warped_sign");
        makeResources("warped_planks", "warped_slab");
        makeResources("warped_planks", "warped_stairs");
        makeResources("warped_stem", "warped_stem");
        makeResources("warped_planks", "warped_trapdoor");
        makeResources("warped_wart_block", "warped_wart_block");
        makeResources("water_still", "water_bucket");
        makeResources("copper_block", "waxed_copper");
        makeResources("cut_copper", "waxed_cut_copper");
        makeResources("cut_copper", "waxed_cut_copper_slab");
        makeResources("cut_copper", "waxed_cut_copper_stairs");
        makeResources("exposed_copper", "waxed_exposed_copper");
        makeResources("exposed_cut_copper", "waxed_exposed_cut_copper");
        makeResources("exposed_cut_copper", "waxed_exposed_cut_copper_slab");
        makeResources("exposed_cut_copper", "waxed_exposed_cut_copper_stairs");
        makeResources("oxidized_copper", "waxed_oxidized_copper");
        makeResources("oxidized_cut_copper", "waxed_oxidized_cut_copper");
        makeResources("oxidized_cut_copper", "waxed_oxidized_cut_copper_slab");
        makeResources("oxidized_cut_copper", "waxed_oxidized_cut_copper_stairs");
        makeResources("weathered_copper", "waxed_weathered_copper");
        makeResources("weathered_cut_copper", "waxed_weathered_cut_copper");
        makeResources("weathered_cut_copper", "waxed_weathered_cut_copper_slab");
        makeResources("weathered_cut_copper", "waxed_weathered_cut_copper_stairs");
        makeResources("weathered_copper", "weathered_copper");
        makeResources("weathered_cut_copper", "weathered_cut_copper");
        makeResources("weathered_cut_copper", "weathered_cut_copper_slab");
        makeResources("weathered_cut_copper", "weathered_cut_copper_stairs");
        makeResources("weeping_vines", "weeping_vines");
        makeResources("wet_sponge", "wet_sponge");
        makeResources("wheat", "wheat");
        makeResources("wheat_seeds", "wheat_seeds");
        makeResources("white_concrete", "white_banner");
        makeResources("white_wool", "white_bed");
        makeResources("white_candle", "white_candle");
        makeResources("white_wool", "white_carpet");
        makeResources("white_concrete", "white_concrete");
        makeResources("white_concrete_powder", "white_concrete_powder");
        makeResources("white_dye", "white_dye");
        makeResources("white_glazed_terracotta", "white_glazed_terracotta");
        makeResources("white_shulker_box", "white_shulker_box");
        makeResources("white_stained_glass", "white_stained_glass");
        makeResources("white_stained_glass", "white_stained_glass_pane");
        makeResources("white_terracotta", "white_terracotta");
        makeResources("white_tulip", "white_tulip");
        makeResources("white_wool", "white_wool");
        makeResources("witch", "witch_spawn_egg");
        makeResources("wither_rose", "wither_rose");
        makeResources("wither_skeleton_skull", "wither_skeleton_skull");
        makeResources("witherskeleton", "wither_skeleton_spawn_egg");
        makeResources("wolf", "wolf_spawn_egg");
        makeResources("wooden_axe", "wooden_axe");
        makeResources("wooden_hoe", "wooden_hoe");
        makeResources("wooden_pickaxe", "wooden_pickaxe");
        makeResources("wooden_shovel", "wooden_shovel");
        makeResources("wooden_sword", "wooden_sword");
        makeResources("writable_book", "writable_book");
        makeResources("written_book", "written_book");
        makeResources("yellow_concrete", "yellow_banner");
        makeResources("yellow_wool", "yellow_bed");
        makeResources("yellow_candle", "yellow_candle");
        makeResources("yellow_wool", "yellow_carpet");
        makeResources("yellow_concrete", "yellow_concrete");
        makeResources("yellow_concrete_powder", "yellow_concrete_powder");
        makeResources("yellow_dye", "yellow_dye");
        makeResources("yellow_glazed_terracotta", "yellow_glazed_terracotta");
        makeResources("yellow_shulker_box", "yellow_shulker_box");
        makeResources("yellow_stained_glass", "yellow_stained_glass");
        makeResources("yellow_stained_glass", "yellow_stained_glass_pane");
        makeResources("yellow_terracotta", "yellow_terracotta");
        makeResources("yellow_wool", "yellow_wool");
        makeResources("zoglin", "zoglin_spawn_egg");
        makeResources("zombie_head", "zombie_head");
        makeResources("zombiehorse", "zombie_horse_spawn_egg");
        makeResources("zombie", "zombie_spawn_egg");
        makeResources("zombievillager", "zombie_villager_spawn_egg");
    }
    public static void makeResources(String texture, String id) {
        JIngredient ingredient = JIngredient.ingredient().item("minecraft:" + id);
        JIngredient stick = JIngredient.ingredient().item("minecraft:stick");
        JIngredient string = JIngredient.ingredient().item("minecraft:string");
        JIngredient iron = JIngredient.ingredient().item("minecraft:iron_ingot");
        JIngredient gold = JIngredient.ingredient().item("minecraft:gold_ingot");
        JIngredient hook = JIngredient.ingredient().item("minecraft:tripwire_hook");
        JIngredient block = JIngredient.ingredient().item("ctft:" + id + "_block");
        JIngredient glass = JIngredient.ingredient().item("ctft:" + id + "_glass");
        JIngredient slab = JIngredient.ingredient().item("ctft:" + id + "_slab");
        JIngredient layer = JIngredient.ingredient().item("ctft:" + id + "_layer");

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/sword").textures((JModel.textures().var("0", "ctft:items/iron_sword").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_sword"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/pickaxe").textures((JModel.textures().var("0", "ctft:items/iron_pickaxe").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_pickaxe"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/axe").textures((JModel.textures().var("0", "ctft:items/iron_axe").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_axe"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shovel").textures((JModel.textures().var("0", "ctft:items/iron_shovel").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_shovel"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/hoe").textures((JModel.textures().var("0", "ctft:items/iron_hoe").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_hoe"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/helmet").textures((JModel.textures().var("0", "ctft:items/iron_helmet").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_helmet"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/chestplate").textures((JModel.textures().var("0", "ctft:items/iron_chestplate").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_chestplate"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/leggings").textures((JModel.textures().var("0", "ctft:items/iron_leggings").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_leggings"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/boots").textures((JModel.textures().var("0", "ctft:items/iron_boots").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_boots"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shears").textures((JModel.textures().var("0", "ctft:items/shears").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_shears"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/fishing_rod").textures((JModel.textures().var("0", "ctft:items/fishing_rod").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))).addOverride(JModel.override(JModel.condition().parameter("cast", 1.0), new Identifier("ctft","item/" + id + "_fishing_rod_cast"))), new Identifier("ctft", "item/" + id + "_fishing_rod"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/fishing_rod_casting").textures((JModel.textures().var("0", "ctft:items/fishing_rod").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_fishing_rod_cast"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shield").textures((JModel.textures().var("0", "ctft:items/shield_base").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))).addOverride(JModel.override(JModel.condition().parameter("blocking", 1.0), new Identifier("ctft","item/" + id + "_shield_blocking"))), new Identifier("ctft", "item/" + id + "_shield"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shield_blocking").textures((JModel.textures().var("0", "ctft:items/shield_base").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_shield_blocking"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow").textures((JModel.textures().var("0", "ctft:items/bow").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block")))
                .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0), new Identifier("ctft","item/" + id + "_bow_pulling_0")))
                .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0).parameter("pull", 0.65), new Identifier("ctft","item/" + id + "_bow_pulling_1")))
                .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0).parameter("pull", 0.9), new Identifier("ctft","item/" + id + "_bow_pulling_2"))), new Identifier("ctft", "item/" + id + "_bow"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_0").textures((JModel.textures().var("0", "ctft:items/bow_pulling_0").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_bow_pulling_0"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_1").textures((JModel.textures().var("0", "ctft:items/bow_pulling_1").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_bow_pulling_1"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_2").textures((JModel.textures().var("0", "ctft:items/bow_pulling_2").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_bow_pulling_2"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_16").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.000000), new Identifier("ctft","item/" + id + "_compass_16")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.015625), new Identifier("ctft","item/" + id + "_compass_17")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.046875), new Identifier("ctft","item/" + id + "_compass_18")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.078125), new Identifier("ctft","item/" + id + "_compass_19")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.109375), new Identifier("ctft","item/" + id + "_compass_20")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.140625), new Identifier("ctft","item/" + id + "_compass_21")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.171875), new Identifier("ctft","item/" + id + "_compass_22")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.203125), new Identifier("ctft","item/" + id + "_compass_23")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.234375), new Identifier("ctft","item/" + id + "_compass_24")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.265625), new Identifier("ctft","item/" + id + "_compass_25")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.296875), new Identifier("ctft","item/" + id + "_compass_26")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.328125), new Identifier("ctft","item/" + id + "_compass_27")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.359375), new Identifier("ctft","item/" + id + "_compass_28")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.390625), new Identifier("ctft","item/" + id + "_compass_29")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.421875), new Identifier("ctft","item/" + id + "_compass_30")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.453125), new Identifier("ctft","item/" + id + "_compass_31")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.484375), new Identifier("ctft","item/" + id + "_compass_00")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.515625), new Identifier("ctft","item/" + id + "_compass_01")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.546875), new Identifier("ctft","item/" + id + "_compass_02")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.578125), new Identifier("ctft","item/" + id + "_compass_03")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.609375), new Identifier("ctft","item/" + id + "_compass_04")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.640625), new Identifier("ctft","item/" + id + "_compass_05")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.671875), new Identifier("ctft","item/" + id + "_compass_06")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.703125), new Identifier("ctft","item/" + id + "_compass_07")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.734375), new Identifier("ctft","item/" + id + "_compass_08")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.765625), new Identifier("ctft","item/" + id + "_compass_09")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.796875), new Identifier("ctft","item/" + id + "_compass_10")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.828125), new Identifier("ctft","item/" + id + "_compass_11")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.859375), new Identifier("ctft","item/" + id + "_compass_12")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.890625), new Identifier("ctft","item/" + id + "_compass_13")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.921875), new Identifier("ctft","item/" + id + "_compass_14")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.953125), new Identifier("ctft","item/" + id + "_compass_15")))
                .addOverride(JModel.override(JModel.condition().parameter("angle", 0.984375), new Identifier("ctft","item/" + id + "_compass_16"))), new Identifier("ctft", "item/" + id + "_compass"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_00").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_00"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_01").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_01"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_02").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_02"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_03").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_03"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_04").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_04"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_05").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_05"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_06").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_06"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_07").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_07"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_08").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_08"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_09").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_09"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_10").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_10"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_11").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_11"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_12").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_12"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_13").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_13"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_14").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_14"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_15").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_15"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_16").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_16"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_17").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_17"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_18").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_18"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_19").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_19"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_20").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_20"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_21").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_21"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_22").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_22"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_23").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_23"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_24").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_24"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_25").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_25"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_26").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_26"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_27").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_27"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_28").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_28"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_29").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_29"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_30").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_30"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_31").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_compass_31"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_00").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.0000000), new Identifier("ctft","item/" + id + "_clock_00")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.0078125), new Identifier("ctft","item/" + id + "_clock_01")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.0234375), new Identifier("ctft","item/" + id + "_clock_02")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.0390625), new Identifier("ctft","item/" + id + "_clock_03")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.0546875), new Identifier("ctft","item/" + id + "_clock_04")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.0703125), new Identifier("ctft","item/" + id + "_clock_05")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.0859375), new Identifier("ctft","item/" + id + "_clock_06")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.1015625), new Identifier("ctft","item/" + id + "_clock_07")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.1171875), new Identifier("ctft","item/" + id + "_clock_08")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.1328125), new Identifier("ctft","item/" + id + "_clock_09")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.1484375), new Identifier("ctft","item/" + id + "_clock_10")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.1640625), new Identifier("ctft","item/" + id + "_clock_11")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.1796875), new Identifier("ctft","item/" + id + "_clock_12")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.1953125), new Identifier("ctft","item/" + id + "_clock_13")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.2109375), new Identifier("ctft","item/" + id + "_clock_14")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.2265625), new Identifier("ctft","item/" + id + "_clock_15")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.2421875), new Identifier("ctft","item/" + id + "_clock_16")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.2578125), new Identifier("ctft","item/" + id + "_clock_17")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.2734375), new Identifier("ctft","item/" + id + "_clock_18")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.2890625), new Identifier("ctft","item/" + id + "_clock_19")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.3046875), new Identifier("ctft","item/" + id + "_clock_20")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.3203125), new Identifier("ctft","item/" + id + "_clock_21")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.3359375), new Identifier("ctft","item/" + id + "_clock_22")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.3515625), new Identifier("ctft","item/" + id + "_clock_23")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.3671875), new Identifier("ctft","item/" + id + "_clock_24")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.3828125), new Identifier("ctft","item/" + id + "_clock_25")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.3984375), new Identifier("ctft","item/" + id + "_clock_26")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.4140625), new Identifier("ctft","item/" + id + "_clock_27")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.4296875), new Identifier("ctft","item/" + id + "_clock_28")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.4453125), new Identifier("ctft","item/" + id + "_clock_29")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.4609375), new Identifier("ctft","item/" + id + "_clock_30")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.4765625), new Identifier("ctft","item/" + id + "_clock_31")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.4921875), new Identifier("ctft","item/" + id + "_clock_32")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.5078125), new Identifier("ctft","item/" + id + "_clock_33")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.5234375), new Identifier("ctft","item/" + id + "_clock_34")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.5390625), new Identifier("ctft","item/" + id + "_clock_35")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.5546875), new Identifier("ctft","item/" + id + "_clock_36")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.5703125), new Identifier("ctft","item/" + id + "_clock_37")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.5859375), new Identifier("ctft","item/" + id + "_clock_38")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.6015625), new Identifier("ctft","item/" + id + "_clock_39")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.6171875), new Identifier("ctft","item/" + id + "_clock_40")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.6328125), new Identifier("ctft","item/" + id + "_clock_41")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.6484375), new Identifier("ctft","item/" + id + "_clock_42")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.6640625), new Identifier("ctft","item/" + id + "_clock_43")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.6796875), new Identifier("ctft","item/" + id + "_clock_44")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.6953125), new Identifier("ctft","item/" + id + "_clock_45")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.7109375), new Identifier("ctft","item/" + id + "_clock_46")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.7265625), new Identifier("ctft","item/" + id + "_clock_47")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.7421875), new Identifier("ctft","item/" + id + "_clock_48")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.7578125), new Identifier("ctft","item/" + id + "_clock_49")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.7734375), new Identifier("ctft","item/" + id + "_clock_50")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.7890625), new Identifier("ctft","item/" + id + "_clock_51")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.8046875), new Identifier("ctft","item/" + id + "_clock_52")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.8203125), new Identifier("ctft","item/" + id + "_clock_53")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.8359375), new Identifier("ctft","item/" + id + "_clock_54")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.8515625), new Identifier("ctft","item/" + id + "_clock_55")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.8671875), new Identifier("ctft","item/" + id + "_clock_56")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.8828125), new Identifier("ctft","item/" + id + "_clock_57")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.8984375), new Identifier("ctft","item/" + id + "_clock_58")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.9140625), new Identifier("ctft","item/" + id + "_clock_59")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.9296875), new Identifier("ctft","item/" + id + "_clock_60")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.9453125), new Identifier("ctft","item/" + id + "_clock_61")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.9609375), new Identifier("ctft","item/" + id + "_clock_62")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.9765625), new Identifier("ctft","item/" + id + "_clock_63")))
                .addOverride(JModel.override(JModel.condition().parameter("time", 0.9921875), new Identifier("ctft","item/" + id + "_clock_00"))), new Identifier("ctft", "item/" + id + "_clock"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_00").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_00"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_01").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_01"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_02").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_02"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_03").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_03"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_04").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_04"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_05").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_05"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_06").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_06"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_07").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_07"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_08").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_08"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_09").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_09"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_10").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_10"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_11").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_11"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_12").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_12"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_13").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_13"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_14").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_14"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_15").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_15"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_16").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_16"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_17").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_17"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_18").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_18"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_19").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_19"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_20").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_20"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_21").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_21"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_22").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_22"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_23").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_23"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_24").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_24"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_25").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_25"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_26").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_26"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_27").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_27"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_28").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_28"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_29").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_29"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_30").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_30"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_31").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_31"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_32").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_32"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_33").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_33"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_34").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_34"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_35").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_35"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_36").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_36"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_37").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_37"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_38").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_38"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_39").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_39"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_40").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_40"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_41").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_41"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_42").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_42"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_43").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_43"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_44").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_44"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_45").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_45"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_46").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_46"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_47").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_47"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_48").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_48"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_49").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_49"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_50").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_50"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_51").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_51"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_52").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_52"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_53").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_53"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_54").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_54"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_55").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_55"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_56").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_56"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_57").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_57"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_58").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_58"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_59").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_59"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_60").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_60"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_61").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_61"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_62").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_62"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_63").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_clock_63"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/horse_armor").textures((JModel.textures().var("0", "ctft:items/horse_armor").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_horse_armor"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_standby").textures((JModel.textures().var("0", "ctft:items/crossbow_standby").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block")))
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
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_0").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_0").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_0"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_1").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_1").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_1"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_2").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_2").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_2"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_arrow").textures((JModel.textures().var("0", "ctft:items/crossbow_arrow").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_arrow"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_firework").textures((JModel.textures().var("0", "ctft:items/crossbow_firework").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_firework"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_ender_pearl").textures((JModel.textures().var("0", "ctft:items/crossbow_ender_pearl").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_ender_pearl"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_potion").textures((JModel.textures().var("0", "ctft:items/crossbow_potion").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_potion"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_experience_bottle").textures((JModel.textures().var("0", "ctft:items/crossbow_experience_bottle").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_experience_bottle"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_trident").textures((JModel.textures().var("0", "ctft:items/crossbow_trident").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_trident"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_egg").textures((JModel.textures().var("0", "ctft:items/crossbow_egg").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_egg"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_snowball").textures((JModel.textures().var("0", "ctft:items/crossbow_snowball").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_snowball"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_fire_charge").textures((JModel.textures().var("0", "ctft:items/crossbow_fire_charge").var("1", "ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_crossbow_fire_charge"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/cube_all").textures((JModel.textures().var("all","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_block"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/stairs").textures((JModel.textures().var("bottom","ctft:blocks/" + texture + "_block").var("top","ctft:blocks/" + texture + "_block").var("side","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_stairs"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/inner_stairs").textures((JModel.textures().var("bottom","ctft:blocks/" + texture + "_block").var("top","ctft:blocks/" + texture + "_block").var("side","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_stairs_inner"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/outer_stairs").textures((JModel.textures().var("bottom","ctft:blocks/" + texture + "_block").var("top","ctft:blocks/" + texture + "_block").var("side","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_stairs_outer"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/slab").textures((JModel.textures().var("bottom","ctft:blocks/" + texture + "_block").var("top","ctft:blocks/" + texture + "_block").var("side","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_slab"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/slab_top").textures((JModel.textures().var("bottom","ctft:blocks/" + texture + "_block").var("top","ctft:blocks/" + texture + "_block").var("side","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_slab_top"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/cube_all").textures((JModel.textures().var("all","ctft:blocks/" + texture + "_glass").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "item/" + id + "_glass"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_glass").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "item/" + id + "_glass_pane_noside"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside_alt").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_glass").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "item/" + id + "_glass_pane_noside_alt"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_post").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_glass").var("edge","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "item/" + id + "_glass_pane_post"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_glass").var("edge","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "item/" + id + "_glass_pane_side"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side_alt").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_glass").var("edge","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "item/" + id + "_glass_pane_side_alt"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_pane_noside"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside_alt").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_pane_noside_alt"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_post").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_block").var("edge","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_pane_post"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_block").var("edge","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_pane_side"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side_alt").textures((JModel.textures().var("pane","ctft:blocks/" + texture + "_block").var("edge","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_pane_side_alt"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_post").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_fence_post"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_side").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_fence_side"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_post").textures((JModel.textures().var("wall","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_wall_post"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_side").textures((JModel.textures().var("wall","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_wall_side"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_side_tall").textures((JModel.textures().var("wall","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_wall_side_tall"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height2").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_layer"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height4").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_layer_height4"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height6").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_layer_height6"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height8").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_layer_height8"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height10").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_layer_height10"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height12").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_layer_height12"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height14").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_layer_height14"));

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:item/generated").textures((JModel.textures().layer0("ctft:blocks/" + texture + "_glass").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "item/" + id + "_glass_pane"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:item/generated").textures((JModel.textures().layer0("ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_pane"));

        Ctft.CTFT_RESOURCES.addBlockState(JState.state(JState.variant(JState.model("ctft:item/" + id + "_block"))), new Identifier("ctft:" + id + "_block"));
        Ctft.CTFT_RESOURCES.addBlockState(JState.state(JState.variant(JState.model("ctft:item/" + id + "_glass"))), new Identifier("ctft:" + id + "_glass"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_inventory").textures((JModel.textures().var("texture","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_fence"));
        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/wall_inventory").textures((JModel.textures().var("wall","ctft:blocks/" + texture + "_block").particle("ctft:blocks/" + texture + "_block"))), new Identifier("ctft", "item/" + id + "_wall"));

        Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                .put("facing=east,half=bottom,shape=inner_left", JState.model("ctft:item/" + id + "_stairs_inner").y(270).uvlock())
                .put("facing=east,half=bottom,shape=inner_right", JState.model("ctft:item/" + id + "_stairs_inner"))
                .put("facing=east,half=bottom,shape=outer_left", JState.model("ctft:item/" + id + "_stairs_outer").y(270).uvlock())
                .put("facing=east,half=bottom,shape=outer_right", JState.model("ctft:item/" + id + "_stairs_outer"))
                .put("facing=east,half=bottom,shape=straight", JState.model("ctft:item/" + id + "_stairs"))
                .put("facing=east,half=top,shape=inner_left", JState.model("ctft:item/" + id + "_stairs_inner").x(180).uvlock())
                .put("facing=east,half=top,shape=inner_right", JState.model("ctft:item/" + id + "_stairs_inner").x(180).y(90).uvlock())
                .put("facing=east,half=top,shape=outer_left", JState.model("ctft:item/" + id + "_stairs_outer").x(180).uvlock())
                .put("facing=east,half=top,shape=outer_right", JState.model("ctft:item/" + id + "_stairs_outer").x(180).y(90).uvlock())
                .put("facing=east,half=top,shape=straight", JState.model("ctft:item/" + id + "_stairs").x(180).uvlock())
                .put("facing=north,half=bottom,shape=inner_left", JState.model("ctft:item/" + id + "_stairs_inner").y(180).uvlock())
                .put("facing=north,half=bottom,shape=inner_right", JState.model("ctft:item/" + id + "_stairs_inner").y(270).uvlock())
                .put("facing=north,half=bottom,shape=outer_left", JState.model("ctft:item/" + id + "_stairs_outer").y(180).uvlock())
                .put("facing=north,half=bottom,shape=outer_right", JState.model("ctft:item/" + id + "_stairs_outer").y(270).uvlock())
                .put("facing=north,half=bottom,shape=straight", JState.model("ctft:item/" + id + "_stairs").y(270).uvlock())
                .put("facing=north,half=top,shape=inner_left", JState.model("ctft:item/" + id + "_stairs_inner").x(180).y(270).uvlock())
                .put("facing=north,half=top,shape=inner_right", JState.model("ctft:item/" + id + "_stairs_inner").x(180).uvlock())
                .put("facing=north,half=top,shape=outer_left", JState.model("ctft:item/" + id + "_stairs_outer").x(180).y(270).uvlock())
                .put("facing=north,half=top,shape=outer_right", JState.model("ctft:item/" + id + "_stairs_outer").x(180).uvlock())
                .put("facing=north,half=top,shape=straight", JState.model("ctft:item/" + id + "_stairs").x(180).y(270).uvlock())
                .put("facing=south,half=bottom,shape=inner_left", JState.model("ctft:item/" + id + "_stairs_inner"))
                .put("facing=south,half=bottom,shape=inner_right", JState.model("ctft:item/" + id + "_stairs_inner").y(90).uvlock())
                .put("facing=south,half=bottom,shape=outer_left", JState.model("ctft:item/" + id + "_stairs_outer"))
                .put("facing=south,half=bottom,shape=outer_right", JState.model("ctft:item/" + id + "_stairs_outer").y(90).uvlock())
                .put("facing=south,half=bottom,shape=straight", JState.model("ctft:item/" + id + "_stairs").y(90).uvlock())
                .put("facing=south,half=top,shape=inner_left", JState.model("ctft:item/" + id + "_stairs_inner").x(180).y(90).uvlock())
                .put("facing=south,half=top,shape=inner_right", JState.model("ctft:item/" + id + "_stairs_inner").x(180).y(180).uvlock())
                .put("facing=south,half=top,shape=outer_left", JState.model("ctft:item/" + id + "_stairs_outer").x(180).y(90).uvlock())
                .put("facing=south,half=top,shape=outer_right", JState.model("ctft:item/" + id + "_stairs_outer").x(180).y(180).uvlock())
                .put("facing=south,half=top,shape=straight", JState.model("ctft:item/" + id + "_stairs").x(180).y(90).uvlock())
                .put("facing=west,half=bottom,shape=inner_left", JState.model("ctft:item/" + id + "_stairs_inner").y(90).uvlock())
                .put("facing=west,half=bottom,shape=inner_right", JState.model("ctft:item/" + id + "_stairs_inner").y(180).uvlock())
                .put("facing=west,half=bottom,shape=outer_left", JState.model("ctft:item/" + id + "_stairs_outer").y(90).uvlock())
                .put("facing=west,half=bottom,shape=outer_right", JState.model("ctft:item/" + id + "_stairs_outer").y(180).uvlock())
                .put("facing=west,half=bottom,shape=straight", JState.model("ctft:item/" + id + "_stairs").y(180).uvlock())
                .put("facing=west,half=top,shape=inner_left", JState.model("ctft:item/" + id + "_stairs_inner").x(180).y(180).uvlock())
                .put("facing=west,half=top,shape=inner_right", JState.model("ctft:item/" + id + "_stairs_inner").x(180).y(270).uvlock())
                .put("facing=west,half=top,shape=outer_left", JState.model("ctft:item/" + id + "_stairs_outer").x(180).y(180).uvlock())
                .put("facing=west,half=top,shape=outer_right", JState.model("ctft:item/" + id + "_stairs_outer").x(180).y(270).uvlock())
                .put("facing=west,half=top,shape=straight", JState.model("ctft:item/" + id + "_stairs").x(180).y(180).uvlock())
        ), new Identifier("ctft:" + id + "_stairs"));
        Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                .put("type=bottom", JState.model("ctft:item/" + id + "_slab"))
                .put("type=double", JState.model("ctft:item/" + id + "_block"))
                .put("type=top", JState.model("ctft:item/" + id + "_slab_top"))
        ), new Identifier("ctft:" + id + "_slab"));
        Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_post")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_side")).when(JState.when().add("north", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_side").y(90)).when(JState.when().add("east", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_side_alt")).when(JState.when().add("south", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_side_alt").y(90)).when(JState.when().add("west", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_noside")).when(JState.when().add("north", "false")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_noside_alt")).when(JState.when().add("east", "false")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_noside_alt").y(90)).when(JState.when().add("south", "false")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_glass_pane_noside").y(270)).when(JState.when().add("west", "false")))
                , new Identifier("ctft:" + id + "_glass_pane"));
        Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_post")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_side")).when(JState.when().add("north", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_side").y(90)).when(JState.when().add("east", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_side_alt")).when(JState.when().add("south", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_side_alt").y(90)).when(JState.when().add("west", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_noside")).when(JState.when().add("north", "false")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_noside_alt")).when(JState.when().add("east", "false")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_noside_alt").y(90)).when(JState.when().add("south", "false")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_pane_noside").y(270)).when(JState.when().add("west", "false")))
                , new Identifier("ctft:" + id + "_pane"));
        Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_fence_post")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_fence_side")).when(JState.when().add("north", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_fence_side").y(90)).when(JState.when().add("east", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_fence_side").y(180)).when(JState.when().add("south", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_fence_side").y(270)).when(JState.when().add("west", "true")))
                , new Identifier("ctft:" + id + "_fence"));
        Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_post")).when(JState.when().add("up", "true")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_side").uvlock()).when(JState.when().add("north", "low")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_side").y(90).uvlock()).when(JState.when().add("east", "low")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_side").y(180).uvlock()).when(JState.when().add("south", "low")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_side").y(270).uvlock()).when(JState.when().add("west", "low")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_side_tall").uvlock()).when(JState.when().add("north", "tall")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_side_tall").y(90).uvlock()).when(JState.when().add("east", "tall")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_side_tall").y(180).uvlock()).when(JState.when().add("south", "tall")))
                        .add(JState.multipart(JState.model("ctft:item/" + id + "_wall_side_tall").y(270).uvlock()).when(JState.when().add("west", "tall")))
                , new Identifier("ctft:" + id + "_wall"));
        Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                .put("layers=1", JState.model("ctft:item/" + id + "_layer"))
                .put("layers=2", JState.model("ctft:item/" + id + "_layer_height4"))
                .put("layers=3", JState.model("ctft:item/" + id + "_layer_height6"))
                .put("layers=4", JState.model("ctft:item/" + id + "_layer_height8"))
                .put("layers=5", JState.model("ctft:item/" + id + "_layer_height10"))
                .put("layers=6", JState.model("ctft:item/" + id + "_layer_height12"))
                .put("layers=7", JState.model("ctft:item/" + id + "_layer_height14"))
                .put("layers=8", JState.model("ctft:item/" + id + "_block"))
        ), new Identifier("ctft:" + id + "_layer"));

        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_sword_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2(" 0 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_sword")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_pickaxe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_pickaxe")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_axe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("00 ").row2("01 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_axe")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shovel_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_shovel")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_hoe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("00 ").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_hoe")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_helmet_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_helmet")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_chestplate_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0 0").row2("000").row3("000"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_chestplate")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_leggings_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2("0 0").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_leggings")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_boots_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("0 0").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_boots")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shears_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("0  "), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_shears")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shield_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("010").row2("000").row3(" 0 "), JKeys.keys().key("0", ingredient).key("1", iron), JResult.result("ctft:" + id + "_shield")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_fishing_rod_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0 1").row2(" 01").row3("  0"), JKeys.keys().key("0", ingredient).key("1", string), JResult.result("ctft:" + id + "_fishing_rod")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_bow_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 01").row2("0 1").row3(" 01"), JKeys.keys().key("0", ingredient).key("1", string), JResult.result("ctft:" + id + "_bow")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_crossbow_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("020").row2("131").row3(" 0 "), JKeys.keys().key("0", ingredient).key("1", string).key("2", iron).key("3", hook), JResult.result("ctft:" + id + "_crossbow")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_clock_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("010").row3(" 0 "), JKeys.keys().key("0", ingredient).key("1", gold), JResult.result("ctft:" + id + "_clock")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_compass_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("010").row3(" 0 "), JKeys.keys().key("0", ingredient).key("1", iron), JResult.result("ctft:" + id + "_compass")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_horse_armor_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0 0").row2("000").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_horse_armor")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_block_from_material"), JRecipe.shaped(JPattern.pattern().row1("000").row2("000").row3("000"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_block")));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_material_from_block"), JRecipe.shapeless(JIngredients.ingredients().add(block), JResult.stackedResult("minecraft:" + id, 9)));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_stairs_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0  ").row2("00 ").row3("000"), JKeys.keys().key("0", ingredient), JResult.stackedResult("ctft:" + id + "_stairs",4)));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_slab_from_crafting"), JRecipe.shaped(JPattern.pattern().row3("000"), JKeys.keys().key("0", ingredient), JResult.stackedResult("ctft:" + id + "_slab",6)));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_pane_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", block), JResult.stackedResult("ctft:" + id + "_pane",16)));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_glass_pane_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", glass), JResult.stackedResult("ctft:" + id + "_glass_pane",16)));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_fence_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("010").row3("010"), JKeys.keys().key("0", ingredient).key("1", stick), JResult.stackedResult("ctft:" + id + "_fence",3)));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_wall_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", ingredient), JResult.stackedResult("ctft:" + id + "_wall",6)));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_layer_from_crafting"), JRecipe.shaped(JPattern.pattern().row3("000"), JKeys.keys().key("0", slab), JResult.stackedResult("ctft:" + id + "_layer",12)));
        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_slab_from_layer"), JRecipe.shaped(JPattern.pattern().row2(" 00").row3(" 00"), JKeys.keys().key("0", layer), JResult.stackedResult("ctft:" + id + "_slab",1)));

        Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_glass_from_smelting"), JRecipe.smelting(block,JResult.result("ctft:" + id + "_glass")).cookingTime(200).experience(0.1f));

        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft","blocks/" + id + "_block"),JLootTable.loot("ctft:" + id + "_block").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_block"))));
        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_stairs"),JLootTable.loot("ctft:" + id + "_stairs").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_stairs"))));
        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft","blocks/" + id + "_slab"),JLootTable.loot("ctft:" + id + "_slab").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_slab"))));
        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft","blocks/" + id + "_glass"),JLootTable.loot("ctft:" + id + "_glass").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_glass"))));
        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft","blocks/" + id + "_glass_pane"),JLootTable.loot("ctft:" + id + "_glass").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_glass_pane"))));
        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft","blocks/" + id + "_pane"),JLootTable.loot("ctft:" + id + "_glass").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_pane"))));
        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft","blocks/" + id + "_fence"),JLootTable.loot("ctft:" + id + "_fence").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_fence"))));
        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft","blocks/" + id + "_wall"),JLootTable.loot("ctft:" + id + "_wall").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_wall"))));
        Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft","blocks/" + id + "_layer"),JLootTable.loot("ctft:" + id + "_layer").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name("ctft:" + id + "_layer"))));
    }
}