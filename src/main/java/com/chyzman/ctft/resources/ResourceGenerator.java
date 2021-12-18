package com.chyzman.ctft.resources;

import com.chyzman.ctft.Ctft;
import com.google.gson.JsonObject;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.recipe.*;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.util.Identifier;

public class ResourceGenerator {
    public static void INIT() {
        makeResources("acacia_boat", "acacia_boat", "ctft");
        makeResources("acacia_planks", "acacia_button", "minecraft");
        makeResources("acacia_door", "acacia_door", "ctft");
        makeResources("acacia_planks", "acacia_fence", "minecraft");
        makeResources("acacia_planks", "acacia_fence_gate", "minecraft");
        makeResources("acacia_leaves", "acacia_leaves", "ctft");
        makeResources("acacia_log", "acacia_log", "minecraft");
        makeResources("acacia_planks", "acacia_planks", "minecraft");
        makeResources("acacia_planks", "acacia_pressure_plate", "minecraft");
        makeResources("acacia_sapling", "acacia_sapling", "ctft");
        makeResources("acacia_planks", "acacia_sign", "minecraft");
        makeResources("acacia_planks", "acacia_slab", "minecraft");
        makeResources("acacia_planks", "acacia_stairs", "minecraft");
        makeResources("acacia_trapdoor", "acacia_trapdoor", "ctft");
        makeResources("acacia_log", "acacia_wood", "minecraft");
        makeResources("activator_rail", "activator_rail", "ctft");
        makeResources("allium", "allium", "ctft");
        makeResources("amethyst_cluster", "amethyst_cluster", "ctft");
        makeResources("amethyst_shard", "amethyst_shard", "ctft");
        makeResources("ancient_debris_top", "ancient_debris", "minecraft");
        makeResources("andesite", "andesite", "minecraft");
        makeResources("andesite", "andesite_slab", "minecraft");
        makeResources("andesite", "andesite_stairs", "minecraft");
        makeResources("andesite", "andesite_wall", "minecraft");
        makeResources("anvil_top", "anvil", "ctft");
        makeResources("apple", "apple", "ctft");
        makeResources("armor_stand", "armor_stand", "ctft");
        makeResources("arrow", "arrow", "ctft");
        makeResources("axolotl", "axolotl_spawn_egg", "ctft");
        makeResources("azalea_top", "azalea", "minecraft");
        makeResources("azalea_leaves", "azalea_leaves", "ctft");
        makeResources("azure_bluet", "azure_bluet", "ctft");
        makeResources("baked_potato", "baked_potato", "ctft");
        makeResources("bamboo", "bamboo", "ctft");
        makeResources("barrel_side", "barrel", "minecraft");
        makeResources("barrier", "barrier", "ctft");
        makeResources("basalt_top", "basalt", "minecraft");
        makeResources("bat", "bat_spawn_egg", "ctft");
        makeResources("beacon", "beacon", "minecraft");
        makeResources("bedrock", "bedrock", "minecraft");
        makeResources("bee_nest_side", "bee_nest", "minecraft");
        makeResources("bee", "bee_spawn_egg", "ctft");
        makeResources("beehive_side", "beehive", "minecraft");
        makeResources("beetroot", "beetroot", "ctft");
        makeResources("beetroot_seeds", "beetroot_seeds", "ctft");
        makeResources("beetroot_soup", "beetroot_soup", "ctft");
        makeResources("bell", "bell", "ctft");
        makeResources("big_dripleaf_top", "big_dripleaf", "ctft");
        makeResources("birch_boat", "birch_boat", "ctft");
        makeResources("birch_planks", "birch_button", "minecraft");
        makeResources("birch_door", "birch_door", "ctft");
        makeResources("birch_planks", "birch_fence", "minecraft");
        makeResources("birch_planks", "birch_fence_gate", "minecraft");
        makeResources("birch_leaves", "birch_leaves", "ctft");
        makeResources("birch_log", "birch_log", "minecraft");
        makeResources("birch_planks", "birch_planks", "minecraft");
        makeResources("birch_planks", "birch_pressure_plate", "minecraft");
        makeResources("birch_sapling", "birch_sapling", "ctft");
        makeResources("birch_planks", "birch_sign", "minecraft");
        makeResources("birch_planks", "birch_slab", "minecraft");
        makeResources("birch_planks", "birch_stairs", "minecraft");
        makeResources("birch_trapdoor", "birch_trapdoor", "ctft");
        makeResources("birch_log", "birch_wood", "minecraft");
        makeResources("black_concrete", "black_banner", "minecraft");
        makeResources("black_wool", "black_bed", "minecraft");
        makeResources("black_candle", "black_candle", "ctft");
        makeResources("black_wool", "black_carpet", "minecraft");
        makeResources("black_concrete", "black_concrete", "minecraft");
        makeResources("black_concrete_powder", "black_concrete_powder", "minecraft");
        makeResources("black_dye", "black_dye", "ctft");
        makeResources("black_glazed_terracotta", "black_glazed_terracotta", "minecraft");
        makeResources("black_shulker_box", "black_shulker_box", "minecraft");
        makeResources("black_stained_glass", "black_stained_glass", "minecraft");
        makeResources("black_stained_glass", "black_stained_glass_pane", "minecraft");
        makeResources("black_terracotta", "black_terracotta", "minecraft");
        makeResources("black_wool", "black_wool", "minecraft");
        makeResources("blackstone", "blackstone", "minecraft");
        makeResources("blackstone", "blackstone_slab", "minecraft");
        makeResources("blackstone", "blackstone_stairs", "minecraft");
        makeResources("blackstone", "blackstone_wall", "minecraft");
        makeResources("blast_furnace_front", "blast_furnace", "minecraft");
        makeResources("blaze_powder", "blaze_powder", "ctft");
        makeResources("blaze_rod", "blaze_rod", "ctft");
        makeResources("blaze", "blaze_spawn_egg", "ctft");
        makeResources("amethyst_block", "amethyst_block", "minecraft");
        makeResources("coal_block", "coal_block", "minecraft");
        makeResources("copper_block", "copper_block", "minecraft");
        makeResources("diamond_block", "diamond_block", "minecraft");
        makeResources("emerald_block", "emerald_block", "minecraft");
        makeResources("gold_block", "gold_block", "minecraft");
        makeResources("iron_block", "iron_block", "minecraft");
        makeResources("lapis_block", "lapis_block", "minecraft");
        makeResources("netherite_block", "netherite_block", "minecraft");
        makeResources("quartz_block_bottom", "quartz_block", "minecraft");
        makeResources("raw_copper_block", "raw_copper_block", "minecraft");
        makeResources("raw_gold_block", "raw_gold_block", "minecraft");
        makeResources("raw_iron_block", "raw_iron_block", "minecraft");
        makeResources("redstone_block", "redstone_block", "minecraft");
        makeResources("blue_concrete", "blue_banner", "minecraft");
        makeResources("blue_wool", "blue_bed", "minecraft");
        makeResources("blue_candle", "blue_candle", "ctft");
        makeResources("blue_wool", "blue_carpet", "minecraft");
        makeResources("blue_concrete", "blue_concrete", "minecraft");
        makeResources("blue_concrete_powder", "blue_concrete_powder", "minecraft");
        makeResources("blue_dye", "blue_dye", "ctft");
        makeResources("blue_glazed_terracotta", "blue_glazed_terracotta", "minecraft");
        makeResources("blue_ice", "blue_ice", "minecraft");
        makeResources("blue_orchid", "blue_orchid", "ctft");
        makeResources("blue_shulker_box", "blue_shulker_box", "minecraft");
        makeResources("blue_stained_glass", "blue_stained_glass", "minecraft");
        makeResources("blue_stained_glass", "blue_stained_glass_pane", "minecraft");
        makeResources("blue_terracotta", "blue_terracotta", "minecraft");
        makeResources("blue_wool", "blue_wool", "minecraft");
        makeResources("bone", "bone", "ctft");
        makeResources("bone_block_top", "bone_block", "minecraft");
        makeResources("bone_meal", "bone_meal", "ctft");
        makeResources("book", "book", "ctft");
        makeResources("bookshelf", "bookshelf", "minecraft");
        makeResources("bow", "bow", "ctft");
        makeResources("bowl", "bowl", "ctft");
        makeResources("brain_coral", "brain_coral", "ctft");
        makeResources("brain_coral_block", "brain_coral_block", "minecraft");
        makeResources("brain_coral_fan", "brain_coral_fan", "ctft");
        makeResources("bread", "bread", "ctft");
        makeResources("brewing_stand", "brewing_stand", "ctft");
        makeResources("brick", "brick", "ctft");
        makeResources("bricks", "brick_slab", "minecraft");
        makeResources("bricks", "brick_stairs", "minecraft");
        makeResources("bricks", "brick_wall", "minecraft");
        makeResources("bricks", "bricks", "minecraft");
        makeResources("brown_concrete", "brown_banner", "minecraft");
        makeResources("brown_wool", "brown_bed", "minecraft");
        makeResources("brown_candle", "brown_candle", "ctft");
        makeResources("brown_wool", "brown_carpet", "minecraft");
        makeResources("brown_concrete", "brown_concrete", "minecraft");
        makeResources("brown_concrete_powder", "brown_concrete_powder", "minecraft");
        makeResources("brown_dye", "brown_dye", "ctft");
        makeResources("brown_glazed_terracotta", "brown_glazed_terracotta", "minecraft");
        makeResources("brown_mushroom", "brown_mushroom", "ctft");
        makeResources("brown_mushroom_block", "brown_mushroom_block", "minecraft");
        makeResources("brown_shulker_box", "brown_shulker_box", "minecraft");
        makeResources("brown_stained_glass", "brown_stained_glass", "minecraft");
        makeResources("brown_stained_glass", "brown_stained_glass_pane", "minecraft");
        makeResources("brown_terracotta", "brown_terracotta", "minecraft");
        makeResources("brown_wool", "brown_wool", "minecraft");
        makeResources("bubble_coral", "bubble_coral", "ctft");
        makeResources("bubble_coral_block", "bubble_coral_block", "minecraft");
        makeResources("bubble_coral_fan", "bubble_coral_fan", "ctft");
        makeResources("bucket", "bucket", "ctft");
        makeResources("axolotl_bucket", "axolotl_bucket", "ctft");
        makeResources("budding_amethyst", "budding_amethyst", "ctft");
        makeResources("bundle", "bundle", "ctft");
        makeResources("cactus_side", "cactus", "ctft");
        makeResources("cake", "cake", "ctft");
        makeResources("calcite", "calcite", "minecraft");
        makeResources("campfire", "campfire", "ctft");
        makeResources("candle", "candle", "ctft");
        makeResources("carrot", "carrot", "ctft");
        makeResources("carrot_on_a_stick", "carrot_on_a_stick", "ctft");
        makeResources("cartography_table_side2", "cartography_table", "minecraft");
        makeResources("carved_pumpkin", "carved_pumpkin", "minecraft");
        makeResources("cat", "cat_spawn_egg", "ctft");
        makeResources("cauldron", "cauldron", "ctft");
        makeResources("cavespider", "cave_spider_spawn_egg", "ctft");
        makeResources("chain", "chain", "ctft");
        makeResources("chain_command_block_front", "chain_command_block", "minecraft");
        makeResources("chainmail_boots", "chainmail_boots", "ctft");
        makeResources("chainmail_chestplate", "chainmail_chestplate", "ctft");
        makeResources("chainmail_helmet", "chainmail_helmet", "ctft");
        makeResources("chainmail_leggings", "chainmail_leggings", "ctft");
        makeResources("charcoal", "charcoal", "ctft");
        makeResources("chest", "chest", "ctft");
        makeResources("chest_minecart", "chest_minecart", "ctft");
        makeResources("chickenface", "chicken_spawn_egg", "ctft");
        makeResources("chipped_anvil_top", "chipped_anvil", "ctft");
        makeResources("chiseled_deepslate", "chiseled_deepslate", "minecraft");
        makeResources("chiseled_nether_bricks", "chiseled_nether_bricks", "minecraft");
        makeResources("chiseled_polished_blackstone", "chiseled_polished_blackstone", "minecraft");
        makeResources("chiseled_quartz_block", "chiseled_quartz_block", "minecraft");
        makeResources("chiseled_red_sandstone", "chiseled_red_sandstone", "minecraft");
        makeResources("chiseled_sandstone", "chiseled_sandstone", "minecraft");
        makeResources("chiseled_stone_bricks", "chiseled_stone_bricks", "minecraft");
        makeResources("chorus_flower", "chorus_flower", "ctft");
        makeResources("chorus_fruit", "chorus_fruit", "ctft");
        makeResources("chorus_plant", "chorus_plant", "ctft");
        makeResources("clay", "clay", "minecraft");
        makeResources("clay_ball", "clay_ball", "ctft");
        makeResources("clock_00", "clock", "ctft");
        makeResources("coal", "coal", "ctft");
        makeResources("coal_ore", "coal_ore", "minecraft");
        makeResources("coarse_dirt", "coarse_dirt", "minecraft");
        makeResources("cobbled_deepslate", "cobbled_deepslate", "minecraft");
        makeResources("cobbled_deepslate", "cobbled_deepslate_slab", "minecraft");
        makeResources("cobbled_deepslate", "cobbled_deepslate_stairs", "minecraft");
        makeResources("cobbled_deepslate", "deepslate_wall", "minecraft");
        makeResources("cobblestone", "cobblestone", "minecraft");
        makeResources("cobblestone", "cobblestone_slab", "minecraft");
        makeResources("cobblestone", "cobblestone_stairs", "minecraft");
        makeResources("cobblestone", "cobblestone_wall", "minecraft");
        makeResources("cobweb", "cobweb", "ctft");
        makeResources("cocoa_beans", "cocoa_beans", "ctft");
        makeResources("cod_bucket", "cod_bucket", "ctft");
        makeResources("codface", "cod_spawn_egg", "ctft");
        makeResources("command_block_front", "command_block", "minecraft");
        makeResources("command_block_minecart", "command_block_minecart", "ctft");
        makeResources("comparator", "comparator", "ctft");
        makeResources("compass_00", "compass", "ctft");
        makeResources("composter_side", "composter", "minecraft");
        makeResources("conduit", "conduit", "ctft");
        makeResources("cooked_chicken", "cooked_chicken", "ctft");
        makeResources("cooked_cod", "cooked_cod", "ctft");
        makeResources("cooked_mutton", "cooked_mutton", "ctft");
        makeResources("cooked_porkchop", "cooked_porkchop", "ctft");
        makeResources("cooked_rabbit", "cooked_rabbit", "ctft");
        makeResources("cooked_salmon", "cooked_salmon", "ctft");
        makeResources("cookie", "cookie", "ctft");
        makeResources("copper_ingot", "copper_ingot", "ctft");
        makeResources("copper_ore", "copper_ore", "minecraft");
        makeResources("cornflower", "cornflower", "ctft");
        makeResources("cow", "cow_spawn_egg", "ctft");
        makeResources("cracked_deepslate_bricks", "cracked_deepslate_bricks", "minecraft");
        makeResources("cracked_deepslate_tiles", "cracked_deepslate_tiles", "minecraft");
        makeResources("cracked_nether_bricks", "cracked_nether_bricks", "minecraft");
        makeResources("cracked_polished_blackstone_bricks", "cracked_polished_blackstone_bricks", "minecraft");
        makeResources("cracked_stone_bricks", "cracked_stone_bricks", "minecraft");
        makeResources("crafting_table_front", "crafting_table", "minecraft");
        makeResources("creeper_banner_pattern", "creeper_banner_pattern", "ctft");
        makeResources("creeper_head", "creeper_head", "ctft");
        makeResources("creeper", "creeper_spawn_egg", "ctft");
        makeResources("crimson_planks", "crimson_button", "minecraft");
        makeResources("crimson_door", "crimson_door", "ctft");
        makeResources("crimson_planks", "crimson_fence", "minecraft");
        makeResources("crimson_planks", "crimson_fence_gate", "minecraft");
        makeResources("crimson_fungus", "crimson_fungus", "ctft");
        makeResources("crimson_stem", "crimson_hyphae", "minecraft");
        makeResources("crimson_nylium", "crimson_nylium", "minecraft");
        makeResources("crimson_planks", "crimson_planks", "minecraft");
        makeResources("crimson_planks", "crimson_pressure_plate", "minecraft");
        makeResources("crimson_roots", "crimson_roots", "ctft");
        makeResources("crimson_sign", "crimson_sign", "ctft");
        makeResources("crimson_planks", "crimson_slab", "minecraft");
        makeResources("crimson_planks", "crimson_stairs", "minecraft");
        makeResources("crimson_stem", "crimson_stem", "minecraft");
        makeResources("crimson_planks", "crimson_trapdoor", "minecraft");
        makeResources("crossbow_standby", "crossbow", "ctft");
        makeResources("crying_obsidian", "crying_obsidian", "minecraft");
        makeResources("cut_copper", "cut_copper", "minecraft");
        makeResources("cut_copper", "cut_copper_slab", "minecraft");
        makeResources("cut_copper", "cut_copper_stairs", "minecraft");
        makeResources("cut_red_sandstone", "cut_red_sandstone", "minecraft");
        makeResources("cut_red_sandstone", "cut_red_sandstone_slab", "minecraft");
        makeResources("cut_sandstone", "cut_sandstone", "minecraft");
        makeResources("cut_sandstone", "cut_sandstone_slab", "minecraft");
        makeResources("cyan_concrete", "cyan_banner", "minecraft");
        makeResources("cyan_wool", "cyan_bed", "minecraft");
        makeResources("cyan_candle", "cyan_candle", "ctft");
        makeResources("cyan_wool", "cyan_carpet", "minecraft");
        makeResources("cyan_concrete", "cyan_concrete", "minecraft");
        makeResources("cyan_concrete_powder", "cyan_concrete_powder", "minecraft");
        makeResources("cyan_dye", "cyan_dye", "ctft");
        makeResources("cyan_glazed_terracotta", "cyan_glazed_terracotta", "minecraft");
        makeResources("cyan_shulker_box", "cyan_shulker_box", "minecraft");
        makeResources("cyan_stained_glass", "cyan_stained_glass", "minecraft");
        makeResources("cyan_stained_glass", "cyan_stained_glass_pane", "minecraft");
        makeResources("cyan_terracotta", "cyan_terracotta", "minecraft");
        makeResources("cyan_wool", "cyan_wool", "minecraft");
        makeResources("damaged_anvil_top", "damaged_anvil", "ctft");
        makeResources("dandelion", "dandelion", "ctft");
        makeResources("dark_oak_boat", "dark_oak_boat", "ctft");
        makeResources("dark_oak_planks", "dark_oak_button", "minecraft");
        makeResources("dark_oak_door", "dark_oak_door", "ctft");
        makeResources("dark_oak_planks", "dark_oak_fence", "minecraft");
        makeResources("dark_oak_planks", "dark_oak_fence_gate", "minecraft");
        makeResources("dark_oak_leaves", "dark_oak_leaves", "ctft");
        makeResources("dark_oak_log", "dark_oak_log", "minecraft");
        makeResources("dark_oak_planks", "dark_oak_planks", "minecraft");
        makeResources("dark_oak_planks", "dark_oak_pressure_plate", "minecraft");
        makeResources("dark_oak_sapling", "dark_oak_sapling", "ctft");
        makeResources("dark_oak_planks", "dark_oak_sign", "minecraft");
        makeResources("dark_oak_planks", "dark_oak_slab", "minecraft");
        makeResources("dark_oak_planks", "dark_oak_stairs", "minecraft");
        makeResources("dark_oak_trapdoor", "dark_oak_trapdoor", "ctft");
        makeResources("dark_oak_log", "dark_oak_wood", "minecraft");
        makeResources("dark_prismarine", "dark_prismarine", "minecraft");
        makeResources("dark_prismarine", "dark_prismarine_slab", "minecraft");
        makeResources("dark_prismarine", "dark_prismarine_stairs", "minecraft");
        makeResources("daylight_detector_top", "daylight_detector", "minecraft");
        makeResources("dead_brain_coral", "dead_brain_coral", "ctft");
        makeResources("dead_brain_coral_block", "dead_brain_coral_block", "minecraft");
        makeResources("dead_brain_coral_fan", "dead_brain_coral_fan", "ctft");
        makeResources("dead_bubble_coral", "dead_bubble_coral", "ctft");
        makeResources("dead_bubble_coral_block", "dead_bubble_coral_block", "minecraft");
        makeResources("dead_bubble_coral_fan", "dead_bubble_coral_fan", "ctft");
        makeResources("dead_bush", "dead_bush", "ctft");
        makeResources("dead_fire_coral", "dead_fire_coral", "ctft");
        makeResources("dead_fire_coral_block", "dead_fire_coral_block", "minecraft");
        makeResources("dead_fire_coral_fan", "dead_fire_coral_fan", "ctft");
        makeResources("dead_horn_coral", "dead_horn_coral", "ctft");
        makeResources("dead_horn_coral_block", "dead_horn_coral_block", "minecraft");
        makeResources("dead_horn_coral_fan", "dead_horn_coral_fan", "ctft");
        makeResources("dead_tube_coral", "dead_tube_coral", "ctft");
        makeResources("dead_tube_coral_block", "dead_tube_coral_block", "minecraft");
        makeResources("dead_tube_coral_fan", "dead_tube_coral_fan", "ctft");
        makeResources("stick", "debug_stick", "ctft");
        makeResources("deepslate", "deepslate", "minecraft");
        makeResources("deepslate_bricks", "deepslate_brick_slab", "minecraft");
        makeResources("deepslate_bricks", "deepslate_brick_stairs", "minecraft");
        makeResources("deepslate_bricks", "deepslate_brick_wall", "minecraft");
        makeResources("deepslate_bricks", "deepslate_bricks", "minecraft");
        makeResources("deepslate_coal_ore", "deepslate_coal_ore", "minecraft");
        makeResources("deepslate_copper_ore", "deepslate_copper_ore", "minecraft");
        makeResources("deepslate_diamond_ore", "deepslate_diamond_ore", "minecraft");
        makeResources("deepslate_emerald_ore", "deepslate_emerald_ore", "minecraft");
        makeResources("deepslate_gold_ore", "deepslate_gold_ore", "minecraft");
        makeResources("deepslate_iron_ore", "deepslate_iron_ore", "minecraft");
        makeResources("deepslate_lapis_ore", "deepslate_lapis_ore", "minecraft");
        makeResources("deepslate_redstone_ore", "deepslate_redstone_ore", "minecraft");
        makeResources("deepslate_tiles", "deepslate_tile_slab", "minecraft");
        makeResources("deepslate_tiles", "deepslate_tile_stairs", "minecraft");
        makeResources("deepslate_tiles", "deepslate_tile_wall", "minecraft");
        makeResources("deepslate_tiles", "deepslate_tiles", "minecraft");
        makeResources("detector_rail", "detector_rail", "ctft");
        makeResources("diamond", "diamond", "ctft");
        makeResources("diamond_axe", "diamond_axe", "ctft");
        makeResources("diamond_boots", "diamond_boots", "ctft");
        makeResources("diamond_chestplate", "diamond_chestplate", "ctft");
        makeResources("diamond_helmet", "diamond_helmet", "ctft");
        makeResources("diamond_hoe", "diamond_hoe", "ctft");
        makeResources("diamond_horse_armor", "diamond_horse_armor", "ctft");
        makeResources("diamond_leggings", "diamond_leggings", "ctft");
        makeResources("diamond_ore", "diamond_ore", "minecraft");
        makeResources("diamond_pickaxe", "diamond_pickaxe", "ctft");
        makeResources("diamond_shovel", "diamond_shovel", "ctft");
        makeResources("diamond_sword", "diamond_sword", "ctft");
        makeResources("diorite", "diorite", "minecraft");
        makeResources("diorite", "diorite_slab", "minecraft");
        makeResources("diorite", "diorite_stairs", "minecraft");
        makeResources("diorite", "diorite_wall", "minecraft");
        makeResources("dirt", "dirt", "minecraft");
        makeResources("dispenser_front", "dispenser", "minecraft");
        makeResources("dolphin", "dolphin_spawn_egg", "ctft");
        makeResources("donkey", "donkey_spawn_egg", "ctft");
        makeResources("dragon_breath", "dragon_breath", "ctft");
        makeResources("dragon_egg", "dragon_egg", "ctft");
        makeResources("dragon_head", "dragon_head", "ctft");
        makeResources("dried_kelp", "dried_kelp", "ctft");
        makeResources("dried_kelp_side", "dried_kelp_block", "minecraft");
        makeResources("dripstone_block", "dripstone_block", "minecraft");
        makeResources("dropper_front", "dropper", "minecraft");
        makeResources("drowned", "drowned_spawn_egg", "ctft");
        makeResources("egg", "egg", "ctft");
        makeResources("elderguardian", "elder_guardian_spawn_egg", "ctft");
        makeResources("elytra", "elytra", "ctft");
        makeResources("emerald", "emerald", "ctft");
        makeResources("emerald_ore", "emerald_ore", "minecraft");
        makeResources("enchanted_book", "enchanted_book", "ctft");
        makeResources("golden_apple", "enchanted_golden_apple", "ctft");
        makeResources("enchanting_table_side", "enchanting_table", "ctft");
        makeResources("end_crystal", "end_crystal", "ctft");
        makeResources("end_portal_frame_top", "end_portal_frame", "minecraft");
        makeResources("end_rod", "end_rod", "ctft");
        makeResources("end_stone", "end_stone", "minecraft");
        makeResources("end_stone_bricks", "end_stone_brick_slab", "minecraft");
        makeResources("end_stone_bricks", "end_stone_brick_stairs", "minecraft");
        makeResources("end_stone_bricks", "end_stone_brick_wall", "minecraft");
        makeResources("end_stone_bricks", "end_stone_bricks", "minecraft");
        makeResources("ender_chest", "ender_chest", "ctft");
        makeResources("ender_eye", "ender_eye", "ctft");
        makeResources("ender_pearl", "ender_pearl", "ctft");
        makeResources("enderman", "enderman_spawn_egg", "ctft");
        makeResources("endermite", "endermite_spawn_egg", "ctft");
        makeResources("evoker", "evoker_spawn_egg", "ctft");
        makeResources("experience_bottle", "experience_bottle", "ctft");
        makeResources("exposed_copper", "exposed_copper", "minecraft");
        makeResources("exposed_cut_copper", "exposed_cut_copper", "minecraft");
        makeResources("exposed_cut_copper", "exposed_cut_copper_slab", "minecraft");
        makeResources("exposed_cut_copper", "exposed_cut_copper_stairs", "minecraft");
        makeResources("farmland", "farmland", "minecraft");
        makeResources("feather", "feather", "ctft");
        makeResources("fermented_spider_eye", "fermented_spider_eye", "ctft");
        makeResources("fern", "fern", "ctft");
        makeResources("filled_map", "filled_map", "ctft");
        makeResources("fire_charge", "fire_charge", "ctft");
        makeResources("fire_coral", "fire_coral", "ctft");
        makeResources("fire_coral_block", "fire_coral_block", "minecraft");
        makeResources("fire_coral_fan", "fire_coral_fan", "ctft");
        makeResources("firework_rocket", "firework_rocket", "ctft");
        makeResources("firework_star", "firework_star", "ctft");
        makeResources("fishing_rod", "fishing_rod", "ctft");
        makeResources("fletching_table_front", "fletching_table", "minecraft");
        makeResources("flint", "flint", "ctft");
        makeResources("flint_and_steel", "flint_and_steel", "ctft");
        makeResources("flower_banner_pattern", "flower_banner_pattern", "ctft");
        makeResources("flower_pot", "flower_pot", "ctft");
        makeResources("flowering_azalea_top", "flowering_azalea", "minecraft");
        makeResources("flowering_azalea_leaves", "azalea_leaves_flowers", "ctft");
        makeResources("fox", "fox_spawn_egg", "ctft");
        makeResources("furnace_front", "furnace", "minecraft");
        makeResources("furnace_minecart", "furnace_minecart", "ctft");
        makeResources("ghast", "ghast_spawn_egg", "ctft");
        makeResources("ghast_tear", "ghast_tear", "ctft");
        makeResources("gilded_blackstone", "gilded_blackstone", "minecraft");
        makeResources("glass", "glass", "minecraft");
        makeResources("glass_bottle", "glass_bottle", "ctft");
        makeResources("glass", "glass_pane", "minecraft");
        makeResources("glistering_melon_slice", "glistering_melon_slice", "ctft");
        makeResources("globe_banner_pattern", "globe_banner_pattern", "ctft");
        makeResources("glow_berries", "glow_berries", "ctft");
        makeResources("glow_ink_sac", "glow_ink_sac", "ctft");
        makeResources("glow_item_frame", "glow_item_frame", "ctft");
        makeResources("glow_lichen", "glow_lichen", "ctft");
        makeResources("glowsquid", "glow_squid_spawn_egg", "ctft");
        makeResources("glowstone", "glowstone", "minecraft");
        makeResources("glowstone_dust", "glowstone_dust", "ctft");
        makeResources("goat", "goat_spawn_egg", "ctft");
        makeResources("gold_ingot", "gold_ingot", "ctft");
        makeResources("gold_nugget", "gold_nugget", "ctft");
        makeResources("gold_ore", "gold_ore", "minecraft");
        makeResources("golden_apple", "golden_apple", "ctft");
        makeResources("golden_axe", "golden_axe", "ctft");
        makeResources("golden_boots", "golden_boots", "ctft");
        makeResources("golden_carrot", "golden_carrot", "ctft");
        makeResources("golden_chestplate", "golden_chestplate", "ctft");
        makeResources("golden_helmet", "golden_helmet", "ctft");
        makeResources("golden_hoe", "golden_hoe", "ctft");
        makeResources("golden_horse_armor", "golden_horse_armor", "ctft");
        makeResources("golden_leggings", "golden_leggings", "ctft");
        makeResources("golden_pickaxe", "golden_pickaxe", "ctft");
        makeResources("golden_shovel", "golden_shovel", "ctft");
        makeResources("golden_sword", "golden_sword", "ctft");
        makeResources("granite", "granite", "minecraft");
        makeResources("granite", "granite_slab", "minecraft");
        makeResources("granite", "granite_stairs", "minecraft");
        makeResources("granite", "granite_wall", "minecraft");
        makeResources("grass", "grass", "ctft");
        makeResources("grass_block_side", "grass_block", "minecraft");
        makeResources("grass_path_side", "dirt_path", "ctft");
        makeResources("gravel", "gravel", "minecraft");
        makeResources("gray_concrete", "gray_banner", "minecraft");
        makeResources("gray_wool", "gray_bed", "minecraft");
        makeResources("gray_candle", "gray_candle", "ctft");
        makeResources("gray_wool", "gray_carpet", "minecraft");
        makeResources("gray_concrete", "gray_concrete", "minecraft");
        makeResources("gray_concrete_powder", "gray_concrete_powder", "minecraft");
        makeResources("gray_dye", "gray_dye", "ctft");
        makeResources("gray_glazed_terracotta", "gray_glazed_terracotta", "minecraft");
        makeResources("gray_shulker_box", "gray_shulker_box", "minecraft");
        makeResources("gray_stained_glass", "gray_stained_glass", "minecraft");
        makeResources("gray_stained_glass", "gray_stained_glass_pane", "minecraft");
        makeResources("gray_terracotta", "gray_terracotta", "minecraft");
        makeResources("gray_wool", "gray_wool", "minecraft");
        makeResources("green_concrete", "green_banner", "minecraft");
        makeResources("green_wool", "green_bed", "minecraft");
        makeResources("green_candle", "green_candle", "ctft");
        makeResources("green_wool", "green_carpet", "minecraft");
        makeResources("green_concrete", "green_concrete", "minecraft");
        makeResources("green_concrete_powder", "green_concrete_powder", "minecraft");
        makeResources("green_dye", "green_dye", "ctft");
        makeResources("green_glazed_terracotta", "green_glazed_terracotta", "minecraft");
        makeResources("green_shulker_box", "green_shulker_box", "minecraft");
        makeResources("green_stained_glass", "green_stained_glass", "minecraft");
        makeResources("green_stained_glass", "green_stained_glass_pane", "minecraft");
        makeResources("green_terracotta", "green_terracotta", "minecraft");
        makeResources("green_wool", "green_wool", "minecraft");
        makeResources("grindstone_side", "grindstone", "ctft");
        makeResources("guardian", "guardian_spawn_egg", "ctft");
        makeResources("gunpowder", "gunpowder", "ctft");
        makeResources("hanging_roots", "hanging_roots", "ctft");
        makeResources("hay_block_side", "hay_block", "minecraft");
        makeResources("heart_of_the_sea", "heart_of_the_sea", "ctft");
        makeResources("iron_block", "heavy_weighted_pressure_plate", "minecraft");
        makeResources("hoglin", "hoglin_spawn_egg", "ctft");
        makeResources("honey_block_top", "honey_block", "minecraft");
        makeResources("honey_bottle", "honey_bottle", "ctft");
        makeResources("honeycomb", "honeycomb", "ctft");
        makeResources("honeycomb_block", "honeycomb_block", "minecraft");
        makeResources("hopper", "hopper", "ctft");
        makeResources("hopper_minecart", "hopper_minecart", "ctft");
        makeResources("horn_coral", "horn_coral", "ctft");
        makeResources("horn_coral_block", "horn_coral_block", "minecraft");
        makeResources("horn_coral_fan", "horn_coral_fan", "ctft");
        makeResources("horse", "horse_spawn_egg", "ctft");
        makeResources("husk", "husk_spawn_egg", "ctft");
        makeResources("ice", "ice", "minecraft");
        makeResources("chiseled_stone_bricks", "infested_chiseled_stone_bricks", "minecraft");
        makeResources("cobblestone", "infested_cobblestone", "minecraft");
        makeResources("cracked_stone_bricks", "infested_cracked_stone_bricks", "minecraft");
        makeResources("deepslate", "infested_deepslate", "minecraft");
        makeResources("mossy_stone_bricks", "infested_mossy_stone_bricks", "minecraft");
        makeResources("stone", "infested_stone", "minecraft");
        makeResources("stone_bricks", "infested_stone_bricks", "minecraft");
        makeResources("ink_sac", "ink_sac", "ctft");
        makeResources("iron_axe", "iron_axe", "ctft");
        makeResources("iron_bars", "iron_bars", "ctft");
        makeResources("iron_boots", "iron_boots", "ctft");
        makeResources("iron_chestplate", "iron_chestplate", "ctft");
        makeResources("iron_door", "iron_door", "ctft");
        makeResources("iron_helmet", "iron_helmet", "ctft");
        makeResources("iron_hoe", "iron_hoe", "ctft");
        makeResources("iron_horse_armor", "iron_horse_armor", "ctft");
        makeResources("iron_ingot", "iron_ingot", "ctft");
        makeResources("iron_leggings", "iron_leggings", "ctft");
        makeResources("iron_nugget", "iron_nugget", "ctft");
        makeResources("iron_ore", "iron_ore", "minecraft");
        makeResources("iron_pickaxe", "iron_pickaxe", "ctft");
        makeResources("iron_shovel", "iron_shovel", "ctft");
        makeResources("iron_sword", "iron_sword", "ctft");
        makeResources("iron_trapdoor", "iron_trapdoor", "ctft");
        makeResources("item_frame", "item_frame", "ctft");
        makeResources("jack_o_lantern", "jack_o_lantern", "minecraft");
        makeResources("jigsaw_side", "jigsaw", "minecraft");
        makeResources("jukebox_side", "jukebox", "minecraft");
        makeResources("jungle_boat", "jungle_boat", "ctft");
        makeResources("jungle_planks", "jungle_button", "minecraft");
        makeResources("jungle_door", "jungle_door", "ctft");
        makeResources("jungle_planks", "jungle_fence", "minecraft");
        makeResources("jungle_planks", "jungle_fence_gate", "minecraft");
        makeResources("jungle_leaves", "jungle_leaves", "ctft");
        makeResources("jungle_log", "jungle_log", "minecraft");
        makeResources("jungle_planks", "jungle_planks", "minecraft");
        makeResources("jungle_planks", "jungle_pressure_plate", "minecraft");
        makeResources("jungle_sapling", "jungle_sapling", "ctft");
        makeResources("jungle_planks", "jungle_sign", "minecraft");
        makeResources("jungle_planks", "jungle_slab", "minecraft");
        makeResources("jungle_planks", "jungle_stairs", "minecraft");
        makeResources("jungle_trapdoor", "jungle_trapdoor", "ctft");
        makeResources("jungle_log", "jungle_wood", "minecraft");
        makeResources("kelp", "kelp", "ctft");
        makeResources("knowledge_book", "knowledge_book", "ctft");
        makeResources("ladder", "ladder", "ctft");
        makeResources("lantern", "lantern", "ctft");
        makeResources("lapis_lazuli", "lapis_lazuli", "ctft");
        makeResources("lapis_ore", "lapis_ore", "minecraft");
        makeResources("large_amethyst_bud", "large_amethyst_bud", "ctft");
        makeResources("fern", "large_fern", "ctft");
        makeResources("lava_still", "lava_bucket", "minecraft");
        makeResources("lead", "lead", "ctft");
        makeResources("leather", "leather", "ctft");
        makeResources("leather_boots", "leather_boots", "ctft");
        makeResources("leather_chestplate", "leather_chestplate", "ctft");
        makeResources("leather_helmet", "leather_helmet", "ctft");
        makeResources("leather_horse_armor", "leather_horse_armor", "ctft");
        makeResources("leather_leggings", "leather_leggings", "ctft");
        makeResources("bookshelf", "lectern", "minecraft");
        makeResources("lever", "lever", "ctft");
        makeResources("light_15", "light", "ctft");
        makeResources("light_blue_concrete", "light_blue_banner", "minecraft");
        makeResources("light_blue_wool", "light_blue_bed", "minecraft");
        makeResources("light_blue_candle", "light_blue_candle", "ctft");
        makeResources("light_blue_wool", "light_blue_carpet", "minecraft");
        makeResources("light_blue_concrete", "light_blue_concrete", "minecraft");
        makeResources("light_blue_concrete_powder", "light_blue_concrete_powder", "minecraft");
        makeResources("light_blue_dye", "light_blue_dye", "ctft");
        makeResources("light_blue_glazed_terracotta", "light_blue_glazed_terracotta", "minecraft");
        makeResources("light_blue_shulker_box", "light_blue_shulker_box", "minecraft");
        makeResources("light_blue_stained_glass", "light_blue_stained_glass", "minecraft");
        makeResources("light_blue_stained_glass", "light_blue_stained_glass_pane", "minecraft");
        makeResources("light_blue_terracotta", "light_blue_terracotta", "minecraft");
        makeResources("light_blue_wool", "light_blue_wool", "minecraft");
        makeResources("light_gray_concrete", "light_gray_banner", "minecraft");
        makeResources("light_gray_wool", "light_gray_bed", "minecraft");
        makeResources("light_gray_candle", "light_gray_candle", "ctft");
        makeResources("light_gray_wool", "light_gray_carpet", "minecraft");
        makeResources("light_gray_concrete", "light_gray_concrete", "minecraft");
        makeResources("light_gray_concrete_powder", "light_gray_concrete_powder", "minecraft");
        makeResources("light_gray_dye", "light_gray_dye", "ctft");
        makeResources("light_gray_glazed_terracotta", "light_gray_glazed_terracotta", "minecraft");
        makeResources("light_gray_shulker_box", "light_gray_shulker_box", "minecraft");
        makeResources("light_gray_stained_glass", "light_gray_stained_glass", "minecraft");
        makeResources("light_gray_stained_glass", "light_gray_stained_glass_pane", "minecraft");
        makeResources("light_gray_terracotta", "light_gray_terracotta", "minecraft");
        makeResources("light_gray_wool", "light_gray_wool", "minecraft");
        makeResources("gold_block", "light_weighted_pressure_plate", "minecraft");
        makeResources("lightning_rod", "lightning_rod", "ctft");
        makeResources("lilac_top", "lilac", "ctft");
        makeResources("lily_of_the_valley", "lily_of_the_valley", "ctft");
        makeResources("lily_pad", "lily_pad", "ctft");
        makeResources("lime_concrete", "lime_banner", "minecraft");
        makeResources("lime_wool", "lime_bed", "minecraft");
        makeResources("lime_candle", "lime_candle", "ctft");
        makeResources("lime_wool", "lime_carpet", "minecraft");
        makeResources("lime_concrete", "lime_concrete", "minecraft");
        makeResources("lime_concrete_powder", "lime_concrete_powder", "minecraft");
        makeResources("lime_dye", "lime_dye", "ctft");
        makeResources("lime_glazed_terracotta", "lime_glazed_terracotta", "minecraft");
        makeResources("lime_shulker_box", "lime_shulker_box", "minecraft");
        makeResources("lime_stained_glass", "lime_stained_glass", "minecraft");
        makeResources("lime_stained_glass", "lime_stained_glass_pane", "minecraft");
        makeResources("lime_terracotta", "lime_terracotta", "minecraft");
        makeResources("lime_wool", "lime_wool", "minecraft");
        makeResources("lingering_potion", "lingering_potion", "ctft");
        makeResources("llama", "llama_spawn_egg", "ctft");
        makeResources("lodestone_side", "lodestone", "minecraft");
        makeResources("loom_front", "loom", "minecraft");
        makeResources("magenta_concrete", "magenta_banner", "minecraft");
        makeResources("magenta_wool", "magenta_bed", "minecraft");
        makeResources("magenta_candle", "magenta_candle", "ctft");
        makeResources("magenta_wool", "magenta_carpet", "minecraft");
        makeResources("magenta_concrete", "magenta_concrete", "minecraft");
        makeResources("magenta_concrete_powder", "magenta_concrete_powder", "minecraft");
        makeResources("magenta_dye", "magenta_dye", "ctft");
        makeResources("magenta_glazed_terracotta", "magenta_glazed_terracotta", "minecraft");
        makeResources("magenta_shulker_box", "magenta_shulker_box", "minecraft");
        makeResources("magenta_stained_glass", "magenta_stained_glass", "minecraft");
        makeResources("magenta_stained_glass", "magenta_stained_glass_pane", "minecraft");
        makeResources("magenta_terracotta", "magenta_terracotta", "minecraft");
        makeResources("magenta_wool", "magenta_wool", "minecraft");
        makeResources("magma", "magma_block", "minecraft");
        makeResources("magma_cream", "magma_cream", "ctft");
        makeResources("magmacube", "magma_cube_spawn_egg", "ctft");
        makeResources("map", "map", "ctft");
        makeResources("medium_amethyst_bud", "medium_amethyst_bud", "ctft");
        makeResources("melon_side", "melon", "minecraft");
        makeResources("melon_seeds", "melon_seeds", "ctft");
        makeResources("melon_slice", "melon_slice", "ctft");
        makeResources("milk", "milk_bucket", "ctft");
        makeResources("minecart", "minecart", "ctft");
        makeResources("mojang_banner_pattern", "mojang_banner_pattern", "ctft");
        makeResources("mooshroom", "mooshroom_spawn_egg", "ctft");
        makeResources("moss_block", "moss_block", "minecraft");
        makeResources("moss_block", "moss_carpet", "minecraft");
        makeResources("mossy_cobblestone", "mossy_cobblestone", "minecraft");
        makeResources("mossy_cobblestone", "mossy_cobblestone_slab", "minecraft");
        makeResources("mossy_cobblestone", "mossy_cobblestone_stairs", "minecraft");
        makeResources("mossy_cobblestone", "mossy_cobblestone_wall", "minecraft");
        makeResources("mossy_stone_bricks", "mossy_stone_brick_slab", "minecraft");
        makeResources("mossy_stone_bricks", "mossy_stone_brick_stairs", "minecraft");
        makeResources("mossy_stone_bricks", "mossy_stone_brick_wall", "minecraft");
        makeResources("mossy_stone_bricks", "mossy_stone_bricks", "minecraft");
        makeResources("mule", "mule_spawn_egg", "ctft");
        makeResources("mushroom_stem", "mushroom_stem", "minecraft");
        makeResources("mushroom_stew", "mushroom_stew", "ctft");
        makeResources("music_disc_11", "music_disc_11", "ctft");
        makeResources("music_disc_13", "music_disc_13", "ctft");
        makeResources("music_disc_blocks", "music_disc_blocks", "ctft");
        makeResources("music_disc_cat", "music_disc_cat", "ctft");
        makeResources("music_disc_chirp", "music_disc_chirp", "ctft");
        makeResources("music_disc_far", "music_disc_far", "ctft");
        makeResources("music_disc_mall", "music_disc_mall", "ctft");
        makeResources("music_disc_mellohi", "music_disc_mellohi", "ctft");
        makeResources("music_disc_otherside", "music_disc_otherside", "ctft");
        makeResources("music_disc_pigstep", "music_disc_pigstep", "ctft");
        makeResources("music_disc_stal", "music_disc_stal", "ctft");
        makeResources("music_disc_strad", "music_disc_strad", "ctft");
        makeResources("music_disc_wait", "music_disc_wait", "ctft");
        makeResources("music_disc_ward", "music_disc_ward", "ctft");
        makeResources("mycelium_side", "mycelium", "minecraft");
        makeResources("name_tag", "name_tag", "ctft");
        makeResources("nautilus_shell", "nautilus_shell", "ctft");
        makeResources("nether_bricks", "nether_brick", "minecraft");
        makeResources("nether_bricks", "nether_brick_fence", "minecraft");
        makeResources("nether_bricks", "nether_brick_slab", "minecraft");
        makeResources("nether_bricks", "nether_brick_stairs", "minecraft");
        makeResources("nether_bricks", "nether_brick_wall", "minecraft");
        makeResources("nether_bricks", "nether_bricks", "minecraft");
        makeResources("nether_gold_ore", "nether_gold_ore", "minecraft");
        makeResources("nether_quartz_ore", "nether_quartz_ore", "minecraft");
        makeResources("nether_sprouts", "nether_sprouts", "ctft");
        makeResources("nether_star", "nether_star", "ctft");
        makeResources("nether_wart", "nether_wart", "ctft");
        makeResources("nether_wart_block", "nether_wart_block", "minecraft");
        makeResources("netherite_axe", "netherite_axe", "ctft");
        makeResources("netherite_boots", "netherite_boots", "ctft");
        makeResources("netherite_chestplate", "netherite_chestplate", "ctft");
        makeResources("netherite_helmet", "netherite_helmet", "ctft");
        makeResources("netherite_hoe", "netherite_hoe", "ctft");
        makeResources("netherite_ingot", "netherite_ingot", "ctft");
        makeResources("netherite_leggings", "netherite_leggings", "ctft");
        makeResources("netherite_pickaxe", "netherite_pickaxe", "ctft");
        makeResources("netherite_scrap", "netherite_scrap", "ctft");
        makeResources("netherite_shovel", "netherite_shovel", "ctft");
        makeResources("netherite_sword", "netherite_sword", "ctft");
        makeResources("netherrack", "netherrack", "minecraft");
        makeResources("note_block", "note_block", "minecraft");
        makeResources("oak_boat", "oak_boat", "ctft");
        makeResources("oak_planks", "oak_button", "minecraft");
        makeResources("oak_door", "oak_door", "ctft");
        makeResources("oak_planks", "oak_fence", "minecraft");
        makeResources("oak_planks", "oak_fence_gate", "minecraft");
        makeResources("oak_leaves", "oak_leaves", "ctft");
        makeResources("oak_log", "oak_log", "minecraft");
        makeResources("oak_planks", "oak_planks", "minecraft");
        makeResources("oak_planks", "oak_pressure_plate", "minecraft");
        makeResources("oak_sapling", "oak_sapling", "ctft");
        makeResources("oak_sign", "oak_sign", "ctft");
        makeResources("oak_planks", "oak_slab", "minecraft");
        makeResources("oak_planks", "oak_stairs", "minecraft");
        makeResources("oak_trapdoor", "oak_trapdoor", "ctft");
        makeResources("oak_log", "oak_wood", "minecraft");
        makeResources("observer_front", "observer", "minecraft");
        makeResources("obsidian", "obsidian", "minecraft");
        makeResources("ocelot", "ocelot_spawn_egg", "ctft");
        makeResources("orange_concrete", "orange_banner", "minecraft");
        makeResources("orange_wool", "orange_bed", "minecraft");
        makeResources("orange_candle", "orange_candle", "ctft");
        makeResources("orange_wool", "orange_carpet", "minecraft");
        makeResources("orange_concrete", "orange_concrete", "minecraft");
        makeResources("orange_concrete_powder", "orange_concrete_powder", "minecraft");
        makeResources("orange_dye", "orange_dye", "ctft");
        makeResources("orange_glazed_terracotta", "orange_glazed_terracotta", "minecraft");
        makeResources("orange_shulker_box", "orange_shulker_box", "minecraft");
        makeResources("orange_stained_glass", "orange_stained_glass", "minecraft");
        makeResources("orange_stained_glass", "orange_stained_glass_pane", "minecraft");
        makeResources("orange_terracotta", "orange_terracotta", "minecraft");
        makeResources("orange_tulip", "orange_tulip", "ctft");
        makeResources("orange_wool", "orange_wool", "minecraft");
        makeResources("oxeye_daisy", "oxeye_daisy", "ctft");
        makeResources("oxidized_copper", "oxidized_copper", "minecraft");
        makeResources("oxidized_cut_copper", "oxidized_cut_copper", "minecraft");
        makeResources("oxidized_cut_copper", "oxidized_cut_copper_slab", "minecraft");
        makeResources("oxidized_cut_copper", "oxidized_cut_copper_stairs", "minecraft");
        makeResources("packed_ice", "packed_ice", "minecraft");
        makeResources("painting", "painting", "ctft");
        makeResources("panda", "panda_spawn_egg", "ctft");
        makeResources("paper", "paper", "ctft");
        makeResources("parrot", "parrot_spawn_egg", "ctft");
        makeResources("peony_top", "peony", "ctft");
        makeResources("oak_planks", "petrified_oak_slab", "minecraft");
        makeResources("phantom_membrane", "phantom_membrane", "ctft");
        makeResources("phantom", "phantom_spawn_egg", "ctft");
        makeResources("pig", "pig_spawn_egg", "ctft");
        makeResources("piglin_banner_pattern", "piglin_banner_pattern", "ctft");
        makeResources("piglin", "piglin_spawn_egg", "ctft");
        makeResources("pillager", "pillager_spawn_egg", "ctft");
        makeResources("pink_concrete", "pink_banner", "minecraft");
        makeResources("pink_wool", "pink_bed", "minecraft");
        makeResources("pink_candle", "pink_candle", "ctft");
        makeResources("pink_wool", "pink_carpet", "minecraft");
        makeResources("pink_concrete", "pink_concrete", "minecraft");
        makeResources("pink_concrete_powder", "pink_concrete_powder", "minecraft");
        makeResources("pink_dye", "pink_dye", "ctft");
        makeResources("pink_glazed_terracotta", "pink_glazed_terracotta", "minecraft");
        makeResources("pink_shulker_box", "pink_shulker_box", "minecraft");
        makeResources("pink_stained_glass", "pink_stained_glass", "minecraft");
        makeResources("pink_stained_glass", "pink_stained_glass_pane", "minecraft");
        makeResources("pink_terracotta", "pink_terracotta", "minecraft");
        makeResources("pink_tulip", "pink_tulip", "ctft");
        makeResources("pink_wool", "pink_wool", "minecraft");
        makeResources("piston_top", "piston", "minecraft");
        makeResources("player_head", "player_head", "ctft");
        makeResources("podzol_side", "podzol", "minecraft");
        makeResources("pointed_dripstone", "pointed_dripstone", "ctft");
        makeResources("poisonous_potato", "poisonous_potato", "ctft");
        makeResources("polarbear", "polar_bear_spawn_egg", "ctft");
        makeResources("polished_andesite", "polished_andesite", "minecraft");
        makeResources("polished_andesite", "polished_andesite_slab", "minecraft");
        makeResources("polished_andesite", "polished_andesite_stairs", "minecraft");
        makeResources("polished_basalt_top", "polished_basalt", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_brick_slab", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_brick_stairs", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_brick_wall", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_bricks", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_button", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_pressure_plate", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_slab", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_stairs", "minecraft");
        makeResources("polished_blackstone", "polished_blackstone_wall", "minecraft");
        makeResources("polished_deepslate", "polished_deepslate", "minecraft");
        makeResources("polished_deepslate", "polished_deepslate_slab", "minecraft");
        makeResources("polished_deepslate", "polished_deepslate_stairs", "minecraft");
        makeResources("polished_deepslate", "polished_deepslate_wall", "minecraft");
        makeResources("polished_diorite", "polished_diorite", "minecraft");
        makeResources("polished_diorite", "polished_diorite_slab", "minecraft");
        makeResources("polished_diorite", "polished_diorite_stairs", "minecraft");
        makeResources("polished_granite", "polished_granite", "minecraft");
        makeResources("polished_granite", "polished_granite_slab", "minecraft");
        makeResources("polished_granite", "polished_granite_stairs", "minecraft");
        makeResources("popped_chorus_fruit", "popped_chorus_fruit", "ctft");
        makeResources("poppy", "poppy", "ctft");
        makeResources("porkchop", "porkchop", "ctft");
        makeResources("potato", "potato", "ctft");
        makeResources("potion", "potion", "ctft");
        makeResources("powder_snow_bucket", "powder_snow_bucket", "ctft");
        makeResources("powered_rail", "powered_rail", "ctft");
        makeResources("prismarine", "prismarine", "minecraft");
        makeResources("prismarine_bricks", "prismarine_brick_slab", "minecraft");
        makeResources("prismarine_bricks", "prismarine_brick_stairs", "minecraft");
        makeResources("prismarine_bricks", "prismarine_bricks", "minecraft");
        makeResources("prismarine_crystals", "prismarine_crystals", "ctft");
        makeResources("prismarine_shard", "prismarine_shard", "ctft");
        makeResources("prismarine", "prismarine_slab", "minecraft");
        makeResources("prismarine", "prismarine_stairs", "minecraft");
        makeResources("prismarine", "prismarine_wall", "minecraft");
        makeResources("pufferfish", "pufferfish", "ctft");
        makeResources("pufferfish_bucket", "pufferfish_bucket", "ctft");
        makeResources("pufferfishface", "pufferfish_spawn_egg", "ctft");
        makeResources("pumpkin_side", "pumpkin", "minecraft");
        makeResources("pumpkin_pie", "pumpkin_pie", "ctft");
        makeResources("pumpkin_seeds", "pumpkin_seeds", "ctft");
        makeResources("purple_concrete", "purple_banner", "minecraft");
        makeResources("purple_wool", "purple_bed", "minecraft");
        makeResources("purple_candle", "purple_candle", "ctft");
        makeResources("purple_wool", "purple_carpet", "minecraft");
        makeResources("purple_concrete", "purple_concrete", "minecraft");
        makeResources("purple_concrete_powder", "purple_concrete_powder", "minecraft");
        makeResources("purple_dye", "purple_dye", "ctft");
        makeResources("purple_glazed_terracotta", "purple_glazed_terracotta", "minecraft");
        makeResources("purple_shulker_box", "purple_shulker_box", "minecraft");
        makeResources("purple_stained_glass", "purple_stained_glass", "minecraft");
        makeResources("purple_stained_glass", "purple_stained_glass_pane", "minecraft");
        makeResources("purple_terracotta", "purple_terracotta", "minecraft");
        makeResources("purple_wool", "purple_wool", "minecraft");
        makeResources("purpur_block", "purpur_block", "minecraft");
        makeResources("purpur_pillar", "purpur_pillar", "minecraft");
        makeResources("purpur_block", "purpur_slab", "minecraft");
        makeResources("purpur_block", "purpur_stairs", "minecraft");
        makeResources("quartz_block_bottom", "quartz", "minecraft");
        makeResources("quartz_bricks", "quartz_bricks", "minecraft");
        makeResources("quartz_pillar", "quartz_pillar", "minecraft");
        makeResources("quartz_block_bottom", "quartz_slab", "minecraft");
        makeResources("quartz_block_bottom", "quartz_stairs", "minecraft");
        makeResources("rabbit_foot", "rabbit_foot", "ctft");
        makeResources("rabbit_hide", "rabbit_hide", "ctft");
        makeResources("rabbitface", "rabbit_spawn_egg", "ctft");
        makeResources("rabbit_stew", "rabbit_stew", "ctft");
        makeResources("rail", "rail", "ctft");
        makeResources("ravager", "ravager_spawn_egg", "ctft");
        makeResources("beef", "beef", "ctft");
        makeResources("chicken", "chicken", "ctft");
        makeResources("cod", "cod", "ctft");
        makeResources("raw_copper", "raw_copper", "ctft");
        makeResources("raw_gold", "raw_gold", "ctft");
        makeResources("raw_iron", "raw_iron", "ctft");
        makeResources("mutton", "mutton", "ctft");
        makeResources("rabbit", "rabbit", "ctft");
        makeResources("salmon", "salmon", "ctft");
        makeResources("red_concrete", "red_banner", "minecraft");
        makeResources("red_wool", "red_bed", "minecraft");
        makeResources("red_candle", "red_candle", "ctft");
        makeResources("red_wool", "red_carpet", "minecraft");
        makeResources("red_concrete", "red_concrete", "minecraft");
        makeResources("red_concrete_powder", "red_concrete_powder", "minecraft");
        makeResources("red_dye", "red_dye", "ctft");
        makeResources("red_glazed_terracotta", "red_glazed_terracotta", "minecraft");
        makeResources("red_mushroom", "red_mushroom", "ctft");
        makeResources("red_mushroom_block", "red_mushroom_block", "minecraft");
        makeResources("red_nether_bricks", "red_nether_brick_slab", "minecraft");
        makeResources("red_nether_bricks", "red_nether_brick_stairs", "minecraft");
        makeResources("red_nether_bricks", "red_nether_brick_wall", "minecraft");
        makeResources("red_nether_bricks", "red_nether_bricks", "minecraft");
        makeResources("red_sand", "red_sand", "minecraft");
        makeResources("red_sandstone", "red_sandstone", "minecraft");
        makeResources("red_sandstone", "red_sandstone_slab", "minecraft");
        makeResources("red_sandstone", "red_sandstone_stairs", "minecraft");
        makeResources("red_sandstone", "red_sandstone_wall", "minecraft");
        makeResources("red_shulker_box", "red_shulker_box", "minecraft");
        makeResources("red_stained_glass", "red_stained_glass", "minecraft");
        makeResources("red_stained_glass", "red_stained_glass_pane", "minecraft");
        makeResources("red_terracotta", "red_terracotta", "minecraft");
        makeResources("red_tulip", "red_tulip", "ctft");
        makeResources("red_wool", "red_wool", "minecraft");
        makeResources("redstone", "redstone", "ctft");
        makeResources("redstone_lamp", "redstone_lamp", "minecraft");
        makeResources("redstone_ore", "redstone_ore", "minecraft");
        makeResources("redstone_torch", "redstone_torch", "ctft");
        makeResources("repeater", "repeater", "ctft");
        makeResources("repeating_command_block_front", "repeating_command_block", "minecraft");
        makeResources("respawn_anchor_side3", "respawn_anchor", "minecraft");
        makeResources("rooted_dirt", "rooted_dirt", "minecraft");
        makeResources("rose_bush_top", "rose_bush", "ctft");
        makeResources("rotten_flesh", "rotten_flesh", "ctft");
        makeResources("saddle", "saddle", "ctft");
        makeResources("salmon_bucket", "salmon_bucket", "ctft");
        makeResources("salmonface", "salmon_spawn_egg", "ctft");
        makeResources("sand", "sand", "minecraft");
        makeResources("sandstone", "sandstone", "minecraft");
        makeResources("sandstone", "sandstone_slab", "minecraft");
        makeResources("sandstone", "sandstone_stairs", "minecraft");
        makeResources("sandstone", "sandstone_wall", "minecraft");
        makeResources("scaffolding_top", "scaffolding", "ctft");
        makeResources("sculk_sensor_bottom", "sculk_sensor", "minecraft");
        makeResources("scute", "scute", "ctft");
        makeResources("sea_lantern", "sea_lantern", "minecraft");
        makeResources("sea_pickle", "sea_pickle", "ctft");
        makeResources("seagrass", "seagrass", "ctft");
        makeResources("shears", "shears", "ctft");
        makeResources("sheep", "sheep_spawn_egg", "ctft");
        makeResources("shield", "shield", "ctft");
        makeResources("shroomlight", "shroomlight", "minecraft");
        makeResources("shulker_box", "shulker_box", "minecraft");
        makeResources("shulker_shell", "shulker_shell", "ctft");
        makeResources("shulker", "shulker_spawn_egg", "ctft");
        makeResources("silverfish", "silverfish_spawn_egg", "ctft");
        makeResources("skeletonhorse", "skeleton_horse_spawn_egg", "ctft");
        makeResources("skeleton_skull", "skeleton_skull", "ctft");
        makeResources("skeleton", "skeleton_spawn_egg", "ctft");
        makeResources("skull_banner_pattern", "skull_banner_pattern", "ctft");
        makeResources("slime_ball", "slime_ball", "ctft");
        makeResources("slime_block", "slime_block", "minecraft");
        makeResources("slime", "slime_spawn_egg", "ctft");
        makeResources("small_amethyst_bud", "small_amethyst_bud", "ctft");
        makeResources("small_dripleaf_top", "small_dripleaf", "ctft");
        makeResources("smithing_table_front", "smithing_table", "minecraft");
        makeResources("smoker_front", "smoker", "minecraft");
        makeResources("smooth_basalt", "smooth_basalt", "minecraft");
        makeResources("quartz_block_bottom", "smooth_quartz", "minecraft");
        makeResources("quartz_block_bottom", "smooth_quartz_slab", "minecraft");
        makeResources("quartz_block_bottom", "smooth_quartz_stairs", "minecraft");
        makeResources("red_sandstone", "smooth_red_sandstone", "minecraft");
        makeResources("red_sandstone", "smooth_red_sandstone_slab", "minecraft");
        makeResources("red_sandstone", "smooth_red_sandstone_stairs", "minecraft");
        makeResources("sandstone", "smooth_sandstone", "minecraft");
        makeResources("sandstone", "smooth_sandstone_slab", "minecraft");
        makeResources("red_sandstone", "smooth_sandstone_stairs", "minecraft");
        makeResources("smooth_stone", "smooth_stone", "minecraft");
        makeResources("smooth_stone_slab_side", "smooth_stone_slab", "minecraft");
        makeResources("snow", "snow", "minecraft");
        makeResources("snow", "snow_block", "minecraft");
        makeResources("snowball", "snowball", "ctft");
        makeResources("soul_campfire", "soul_campfire", "ctft");
        makeResources("soul_lantern", "soul_lantern", "ctft");
        makeResources("soul_sand", "soul_sand", "minecraft");
        makeResources("soul_soil", "soul_soil", "minecraft");
        makeResources("soul_torch", "soul_torch", "ctft");
        makeResources("spawner", "spawner", "ctft");
        makeResources("spectral_arrow", "spectral_arrow", "ctft");
        makeResources("spider_eye", "spider_eye", "ctft");
        makeResources("spider", "spider_spawn_egg", "ctft");
        makeResources("splash_potion", "splash_potion", "ctft");
        makeResources("sponge", "sponge", "minecraft");
        makeResources("spore_blossom", "spore_blossom", "ctft");
        makeResources("spruce_boat", "spruce_boat", "ctft");
        makeResources("spruce_planks", "spruce_button", "minecraft");
        makeResources("spruce_door", "spruce_door", "ctft");
        makeResources("spruce_planks", "spruce_fence", "minecraft");
        makeResources("spruce_planks", "spruce_fence_gate", "minecraft");
        makeResources("spruce_leaves", "spruce_leaves", "ctft");
        makeResources("spruce_log", "spruce_log", "minecraft");
        makeResources("spruce_planks", "spruce_planks", "minecraft");
        makeResources("spruce_planks", "spruce_pressure_plate", "minecraft");
        makeResources("spruce_sapling", "spruce_sapling", "ctft");
        makeResources("spruce_planks", "spruce_sign", "minecraft");
        makeResources("spruce_planks", "spruce_slab", "minecraft");
        makeResources("spruce_planks", "spruce_stairs", "minecraft");
        makeResources("spruce_trapdoor", "spruce_trapdoor", "ctft");
        makeResources("spruce_log", "spruce_wood", "ctft");
        makeResources("spyglass", "spyglass", "ctft");
        makeResources("squid", "squid_spawn_egg", "ctft");
        makeResources("cooked_beef", "cooked_beef", "ctft");
        makeResources("stick", "stick", "ctft");
        makeResources("piston_top_sticky", "sticky_piston", "minecraft");
        makeResources("stone", "stone", "minecraft");
        makeResources("stone_axe", "stone_axe", "ctft");
        makeResources("stone_bricks", "stone_brick_slab", "minecraft");
        makeResources("stone", "stone_brick_stairs", "minecraft");
        makeResources("stone_bricks", "stone_brick_wall", "minecraft");
        makeResources("stone_bricks", "stone_bricks", "minecraft");
        makeResources("stone", "stone_button", "minecraft");
        makeResources("stone_hoe", "stone_hoe", "ctft");
        makeResources("stone_pickaxe", "stone_pickaxe", "ctft");
        makeResources("stone", "stone_pressure_plate", "minecraft");
        makeResources("stone_shovel", "stone_shovel", "ctft");
        makeResources("stone", "stone_slab", "minecraft");
        makeResources("stone", "stone_stairs", "minecraft");
        makeResources("stone_sword", "stone_sword", "ctft");
        makeResources("stonecutter_top", "stonecutter", "minecraft");
        makeResources("stray", "stray_spawn_egg", "ctft");
        makeResources("strider", "strider_spawn_egg", "ctft");
        makeResources("string", "string", "ctft");
        makeResources("stripped_acacia_log_top", "stripped_acacia_log", "minecraft");
        makeResources("stripped_dark_oak_log_top", "stripped_acacia_wood", "minecraft");
        makeResources("stripped_birch_log_top", "stripped_birch_log", "minecraft");
        makeResources("stripped_jungle_log_top", "stripped_birch_wood", "minecraft");
        makeResources("stripped_crimson_stem", "stripped_crimson_hyphae", "minecraft");
        makeResources("stripped_crimson_stem_top", "stripped_crimson_stem", "minecraft");
        makeResources("stripped_dark_oak_log_top", "stripped_dark_oak_log", "minecraft");
        makeResources("stripped_oak_log_top", "stripped_dark_oak_wood", "minecraft");
        makeResources("stripped_jungle_log_top", "stripped_jungle_log", "minecraft");
        makeResources("stripped_acacia_log_top", "stripped_jungle_wood", "minecraft");
        makeResources("stripped_oak_log_top", "stripped_oak_log", "minecraft");
        makeResources("stripped_spruce_log_top", "stripped_oak_wood", "minecraft");
        makeResources("stripped_spruce_log_top", "stripped_spruce_log", "minecraft");
        makeResources("stripped_birch_log_top", "stripped_spruce_wood", "minecraft");
        makeResources("stripped_warped_stem", "stripped_warped_hyphae", "minecraft");
        makeResources("stripped_warped_stem_top", "stripped_warped_stem", "minecraft");
        makeResources("structure_block", "structure_block", "minecraft");
        makeResources("structure_void", "structure_void", "ctft");
        makeResources("sugar", "sugar", "ctft");
        makeResources("sugar_cane", "sugar_cane", "ctft");
        makeResources("sunflower_front", "sunflower", "ctft");
        makeResources("suspicious_stew", "suspicious_stew", "ctft");
        makeResources("sweet_berries", "sweet_berries", "ctft");
        makeResources("grass", "tall_grass", "ctft");
        makeResources("target_side", "target", "minecraft");
        makeResources("terracotta", "terracotta", "minecraft");
        makeResources("tinted_glass", "tinted_glass", "minecraft");
        makeResources("arrow", "tipped_arrow", "ctft");
        makeResources("tnt_side", "tnt", "minecraft");
        makeResources("tnt_minecart", "tnt_minecart", "ctft");
        makeResources("torch", "torch", "ctft");
        makeResources("totem_of_undying", "totem_of_undying", "ctft");
        makeResources("traderllama", "trader_llama_spawn_egg", "ctft");
        makeResources("trapped_chest", "trapped_chest", "ctft");
        makeResources("trident", "trident", "ctft");
        makeResources("tripwire_hook", "tripwire_hook", "ctft");
        makeResources("tropical_fish", "tropical_fish", "ctft");
        makeResources("tropical_fish_bucket", "tropical_fish_bucket", "ctft");
        makeResources("tropicalfish", "tropical_fish_spawn_egg", "ctft");
        makeResources("tube_coral", "tube_coral", "ctft");
        makeResources("tube_coral_block", "tube_coral_block", "minecraft");
        makeResources("tube_coral_fan", "tube_coral_fan", "ctft");
        makeResources("tuff", "tuff", "minecraft");
        makeResources("turtle_egg", "turtle_egg", "ctft");
        makeResources("turtle_helmet", "turtle_helmet", "ctft");
        makeResources("turtle", "turtle_spawn_egg", "ctft");
        makeResources("twisting_vines", "twisting_vines", "ctft");
        makeResources("vex", "vex_spawn_egg", "ctft");
        makeResources("villager", "villager_spawn_egg", "ctft");
        makeResources("vindicator", "vindicator_spawn_egg", "ctft");
        makeResources("seagrass", "vine", "ctft");
        makeResources("wanderingtrader", "wandering_trader_spawn_egg", "ctft");
        makeResources("warped_planks", "warped_button", "minecraft");
        makeResources("warped_door", "warped_door", "ctft");
        makeResources("warped_planks", "warped_fence", "minecraft");
        makeResources("warped_planks", "warped_fence_gate", "minecraft");
        makeResources("warped_fungus", "warped_fungus", "ctft");
        makeResources("warped_fungus_on_a_stick", "warped_fungus_on_a_stick", "ctft");
        makeResources("warped_stem", "warped_hyphae", "minecraft");
        makeResources("warped_nylium", "warped_nylium", "minecraft");
        makeResources("warped_planks", "warped_planks", "minecraft");
        makeResources("warped_planks", "warped_pressure_plate", "minecraft");
        makeResources("warped_roots", "warped_roots", "ctft");
        makeResources("warped_sign", "warped_sign", "ctft");
        makeResources("warped_planks", "warped_slab", "minecraft");
        makeResources("warped_planks", "warped_stairs", "minecraft");
        makeResources("warped_stem", "warped_stem", "minecraft");
        makeResources("warped_planks", "warped_trapdoor", "minecraft");
        makeResources("warped_wart_block", "warped_wart_block", "minecraft");
        makeResources("water_still", "water_bucket", "minecraft");
        makeResources("copper_block", "waxed_copper", "minecraft");
        makeResources("cut_copper", "waxed_cut_copper", "minecraft");
        makeResources("cut_copper", "waxed_cut_copper_slab", "minecraft");
        makeResources("cut_copper", "waxed_cut_copper_stairs", "minecraft");
        makeResources("exposed_copper", "waxed_exposed_copper", "minecraft");
        makeResources("exposed_cut_copper", "waxed_exposed_cut_copper", "minecraft");
        makeResources("exposed_cut_copper", "waxed_exposed_cut_copper_slab", "minecraft");
        makeResources("exposed_cut_copper", "waxed_exposed_cut_copper_stairs", "minecraft");
        makeResources("oxidized_copper", "waxed_oxidized_copper", "minecraft");
        makeResources("oxidized_cut_copper", "waxed_oxidized_cut_copper", "minecraft");
        makeResources("oxidized_cut_copper", "waxed_oxidized_cut_copper_slab", "minecraft");
        makeResources("oxidized_cut_copper", "waxed_oxidized_cut_copper_stairs", "minecraft");
        makeResources("weathered_copper", "waxed_weathered_copper", "minecraft");
        makeResources("weathered_cut_copper", "waxed_weathered_cut_copper", "minecraft");
        makeResources("weathered_cut_copper", "waxed_weathered_cut_copper_slab", "minecraft");
        makeResources("weathered_cut_copper", "waxed_weathered_cut_copper_stairs", "minecraft");
        makeResources("weathered_copper", "weathered_copper", "minecraft");
        makeResources("weathered_cut_copper", "weathered_cut_copper", "minecraft");
        makeResources("weathered_cut_copper", "weathered_cut_copper_slab", "minecraft");
        makeResources("weathered_cut_copper", "weathered_cut_copper_stairs", "minecraft");
        makeResources("weeping_vines", "weeping_vines", "ctft");
        makeResources("wet_sponge", "wet_sponge", "minecraft");
        makeResources("wheat", "wheat", "ctft");
        makeResources("wheat_seeds", "wheat_seeds", "ctft");
        makeResources("white_concrete", "white_banner", "minecraft");
        makeResources("white_wool", "white_bed", "minecraft");
        makeResources("white_candle", "white_candle", "ctft");
        makeResources("white_wool", "white_carpet", "minecraft");
        makeResources("white_concrete", "white_concrete", "minecraft");
        makeResources("white_concrete_powder", "white_concrete_powder", "minecraft");
        makeResources("white_dye", "white_dye", "ctft");
        makeResources("white_glazed_terracotta", "white_glazed_terracotta", "minecraft");
        makeResources("white_shulker_box", "white_shulker_box", "minecraft");
        makeResources("white_stained_glass", "white_stained_glass", "minecraft");
        makeResources("white_stained_glass", "white_stained_glass_pane", "minecraft");
        makeResources("white_terracotta", "white_terracotta", "minecraft");
        makeResources("white_tulip", "white_tulip", "ctft");
        makeResources("white_wool", "white_wool", "minecraft");
        makeResources("witch", "witch_spawn_egg", "ctft");
        makeResources("wither_rose", "wither_rose", "ctft");
        makeResources("wither_skeleton_skull", "wither_skeleton_skull", "ctft");
        makeResources("witherskeleton", "wither_skeleton_spawn_egg", "ctft");
        makeResources("wolf", "wolf_spawn_egg", "ctft");
        makeResources("wooden_axe", "wooden_axe", "ctft");
        makeResources("wooden_hoe", "wooden_hoe", "ctft");
        makeResources("wooden_pickaxe", "wooden_pickaxe", "ctft");
        makeResources("wooden_shovel", "wooden_shovel", "ctft");
        makeResources("wooden_sword", "wooden_sword", "ctft");
        makeResources("writable_book", "writable_book", "ctft");
        makeResources("written_book", "written_book", "ctft");
        makeResources("yellow_concrete", "yellow_banner", "minecraft");
        makeResources("yellow_wool", "yellow_bed", "minecraft");
        makeResources("yellow_candle", "yellow_candle", "ctft");
        makeResources("yellow_wool", "yellow_carpet", "minecraft");
        makeResources("yellow_concrete", "yellow_concrete", "minecraft");
        makeResources("yellow_concrete_powder", "yellow_concrete_powder", "minecraft");
        makeResources("yellow_dye", "yellow_dye", "ctft");
        makeResources("yellow_glazed_terracotta", "yellow_glazed_terracotta", "minecraft");
        makeResources("yellow_shulker_box", "yellow_shulker_box", "minecraft");
        makeResources("yellow_stained_glass", "yellow_stained_glass", "minecraft");
        makeResources("yellow_stained_glass", "yellow_stained_glass_pane", "minecraft");
        makeResources("yellow_terracotta", "yellow_terracotta", "minecraft");
        makeResources("yellow_wool", "yellow_wool", "minecraft");
        makeResources("zoglin", "zoglin_spawn_egg", "ctft");
        makeResources("zombie_head", "zombie_head", "ctft");
        makeResources("zombiehorse", "zombie_horse_spawn_egg", "ctft");
        makeResources("zombie", "zombie_spawn_egg", "ctft");
        makeResources("zombievillager", "zombie_villager_spawn_egg", "ctft");
    }

    public static void makeResources(String texture, String id, String namespace) {
        if (namespace == "ctft") {
            namespace = "ctft:blocks/" + texture + "_block";
        }
        if (namespace == "minecraft") {
            namespace = "minecraft:block/" + texture;
        }
        JIngredient ingredient = JIngredient.ingredient().item("minecraft:" + id);
        JIngredient stick = JIngredient.ingredient().item("minecraft:stick");
        JIngredient string = JIngredient.ingredient().item("minecraft:string");
        JIngredient iron = JIngredient.ingredient().item("minecraft:iron_ingot");
        JIngredient gold = JIngredient.ingredient().item("minecraft:gold_ingot");
        JIngredient hook = JIngredient.ingredient().item("minecraft:tripwire_hook");
        JIngredient coal = JIngredient.ingredient().item("minecraft:coal");
        JIngredient block = JIngredient.ingredient().item("ctft:" + id + "_block");
        JIngredient glass = JIngredient.ingredient().item("ctft:" + id + "_glass");
        JIngredient slab = JIngredient.ingredient().item("ctft:" + id + "_slab");
        JIngredient layer = JIngredient.ingredient().item("ctft:" + id + "_layer");
        JIngredient stairs = JIngredient.ingredient().item("ctft:" + id + "_stairs");
        JIngredient torch = JIngredient.ingredient().item("ctft:" + id + "_torch");

        Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/cube_all").textures((JModel.textures().var("all", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_block"));

        if (Ctft.CONFIG.tools_config.swordsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/sword").textures((JModel.textures().var("0", "ctft:items/iron_sword").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_sword"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_sword_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2(" 0 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_sword")));
        }
        if (Ctft.CONFIG.tools_config.pickaxesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/pickaxe").textures((JModel.textures().var("0", "ctft:items/iron_pickaxe").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_pickaxe"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_pickaxe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_pickaxe")));

        }
        if (Ctft.CONFIG.tools_config.axesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/axe").textures((JModel.textures().var("0", "ctft:items/iron_axe").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_axe"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_axe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("00 ").row2("01 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_axe")));

        }
        if (Ctft.CONFIG.tools_config.shovelsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shovel").textures((JModel.textures().var("0", "ctft:items/iron_shovel").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_shovel"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shovel_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_shovel")));

        }
        if (Ctft.CONFIG.tools_config.hoesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/hoe").textures((JModel.textures().var("0", "ctft:items/iron_hoe").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_hoe"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_hoe_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("00 ").row2(" 1 ").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_hoe")));

        }
        if (Ctft.CONFIG.tools_config.helmetsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/helmet").textures((JModel.textures().var("0", "ctft:items/iron_helmet").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_helmet"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_helmet_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_helmet")));

        }
        if (Ctft.CONFIG.tools_config.chestplatesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/chestplate").textures((JModel.textures().var("0", "ctft:items/iron_chestplate").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_chestplate"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_chestplate_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0 0").row2("000").row3("000"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_chestplate")));

        }
        if (Ctft.CONFIG.tools_config.leggingsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/leggings").textures((JModel.textures().var("0", "ctft:items/iron_leggings").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_leggings"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_leggings_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2("0 0").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_leggings")));

        }
        if (Ctft.CONFIG.tools_config.bootsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/boots").textures((JModel.textures().var("0", "ctft:items/iron_boots").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_boots"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_boots_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("0 0").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_boots")));

        }
        if (Ctft.CONFIG.tools_config.bowsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow").textures((JModel.textures().var("0", "ctft:items/bow").var("1", namespace).particle(namespace)))
                    .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0), new Identifier("ctft", "item/" + id + "_bow_pulling_0")))
                    .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0).parameter("pull", 0.65), new Identifier("ctft", "item/" + id + "_bow_pulling_1")))
                    .addOverride(JModel.override(JModel.condition().parameter("pulling", 1.0).parameter("pull", 0.9), new Identifier("ctft", "item/" + id + "_bow_pulling_2"))), new Identifier("ctft", "item/" + id + "_bow"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_0").textures((JModel.textures().var("0", "ctft:items/bow_pulling_0").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_bow_pulling_0"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_1").textures((JModel.textures().var("0", "ctft:items/bow_pulling_1").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_bow_pulling_1"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/bow_pulling_2").textures((JModel.textures().var("0", "ctft:items/bow_pulling_2").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_bow_pulling_2"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_bow_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 01").row2("0 1").row3(" 01"), JKeys.keys().key("0", ingredient).key("1", string), JResult.result("ctft:" + id + "_bow")));

        }
        if (Ctft.CONFIG.tools_config.crossbowsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_standby").textures((JModel.textures().var("0", "ctft:items/crossbow_standby").var("1", namespace).particle(namespace)))
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
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_0").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_0").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_0"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_1").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_1").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_1"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_pulling_2").textures((JModel.textures().var("0", "ctft:items/crossbow_pulling_2").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_pulling_2"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_arrow").textures((JModel.textures().var("0", "ctft:items/crossbow_arrow").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_arrow"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_firework").textures((JModel.textures().var("0", "ctft:items/crossbow_firework").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_firework"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_ender_pearl").textures((JModel.textures().var("0", "ctft:items/crossbow_ender_pearl").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_ender_pearl"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_potion").textures((JModel.textures().var("0", "ctft:items/crossbow_potion").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_potion"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_experience_bottle").textures((JModel.textures().var("0", "ctft:items/crossbow_experience_bottle").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_experience_bottle"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_trident").textures((JModel.textures().var("0", "ctft:items/crossbow_trident").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_trident"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_egg").textures((JModel.textures().var("0", "ctft:items/crossbow_egg").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_egg"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_snowball").textures((JModel.textures().var("0", "ctft:items/crossbow_snowball").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_snowball"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/crossbow_fire_charge").textures((JModel.textures().var("0", "ctft:items/crossbow_fire_charge").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_crossbow_fire_charge"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_crossbow_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("020").row2("131").row3(" 0 "), JKeys.keys().key("0", ingredient).key("1", string).key("2", iron).key("3", hook), JResult.result("ctft:" + id + "_crossbow")));

        }
        if (Ctft.CONFIG.tools_config.shieldsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shield").textures((JModel.textures().var("0", "ctft:items/shield_base").var("1", namespace).particle(namespace))).addOverride(JModel.override(JModel.condition().parameter("blocking", 1.0), new Identifier("ctft", "item/" + id + "_shield_blocking"))), new Identifier("ctft", "item/" + id + "_shield"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shield_blocking").textures((JModel.textures().var("0", "ctft:items/shield_base").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_shield_blocking"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shield_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("010").row2("000").row3(" 0 "), JKeys.keys().key("0", ingredient).key("1", iron), JResult.result("ctft:" + id + "_shield")));

        }
        if (Ctft.CONFIG.tools_config.shearsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/shears").textures((JModel.textures().var("0", "ctft:items/shears").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_shears"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_shears_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("0  "), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_shears")));

        }
        if (Ctft.CONFIG.tools_config.fishingRodsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/fishing_rod").textures((JModel.textures().var("0", "ctft:items/fishing_rod").var("1", namespace).particle(namespace))).addOverride(JModel.override(JModel.condition().parameter("cast", 1.0), new Identifier("ctft", "item/" + id + "_fishing_rod_cast"))), new Identifier("ctft", "item/" + id + "_fishing_rod"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/fishing_rod_casting").textures((JModel.textures().var("0", "ctft:items/fishing_rod").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_fishing_rod_cast"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_fishing_rod_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("  0").row2(" 01").row3("0 1"), JKeys.keys().key("0", ingredient).key("1", string), JResult.result("ctft:" + id + "_fishing_rod")));

        }
        if (Ctft.CONFIG.tools_config.clocksEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_00").var("1", namespace).particle(namespace)))
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
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_00").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_00"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_01").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_01"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_02").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_02"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_03").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_03"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_04").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_04"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_05").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_05"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_06").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_06"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_07").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_07"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_08").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_08"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_09").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_09"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_10").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_10"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_11").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_11"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_12").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_12"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_13").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_13"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_14").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_14"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_15").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_15"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_16").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_16"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_17").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_17"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_18").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_18"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_19").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_19"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_20").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_20"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_21").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_21"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_22").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_22"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_23").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_23"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_24").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_24"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_25").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_25"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_26").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_26"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_27").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_27"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_28").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_28"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_29").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_29"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_30").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_30"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_31").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_31"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_32").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_32"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_33").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_33"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_34").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_34"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_35").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_35"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_36").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_36"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_37").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_37"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_38").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_38"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_39").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_39"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_40").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_40"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_41").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_41"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_42").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_42"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_43").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_43"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_44").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_44"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_45").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_45"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_46").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_46"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_47").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_47"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_48").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_48"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_49").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_49"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_50").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_50"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_51").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_51"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_52").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_52"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_53").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_53"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_54").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_54"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_55").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_55"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_56").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_56"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_57").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_57"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_58").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_58"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_59").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_59"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_60").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_60"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_61").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_61"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_62").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_62"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/clock").textures((JModel.textures().var("0", "ctft:items/clock_63").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_clock_63"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_clock_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("010").row3(" 0 "), JKeys.keys().key("0", ingredient).key("1", gold), JResult.result("ctft:" + id + "_clock")));

        }
        if (Ctft.CONFIG.tools_config.compassesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_16").var("1", namespace).particle(namespace)))
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
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_00").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_00"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_01").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_01"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_02").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_02"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_03").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_03"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_04").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_04"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_05").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_05"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_06").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_06"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_07").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_07"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_08").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_08"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_09").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_09"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_10").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_10"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_11").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_11"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_12").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_12"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_13").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_13"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_14").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_14"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_15").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_15"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_16").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_16"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_17").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_17"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_18").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_18"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_19").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_19"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_20").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_20"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_21").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_21"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_22").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_22"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_23").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_23"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_24").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_24"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_25").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_25"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_26").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_26"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_27").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_27"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_28").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_28"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_29").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_29"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_30").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_30"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/compass").textures((JModel.textures().var("0", "ctft:items/compass_31").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_compass_31"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_compass_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 0 ").row2("010").row3(" 0 "), JKeys.keys().key("0", ingredient).key("1", iron), JResult.result("ctft:" + id + "_compass")));

        }
        if (Ctft.CONFIG.tools_config.horseArmorEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/horse_armor").textures((JModel.textures().var("0", "ctft:items/horse_armor").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_horse_armor"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_horse_armor_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("  0").row2("000").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_horse_armor")));

        }
        if (Ctft.CONFIG.tools_config.blocksEnabled) {
            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("", JState.model("ctft:item/" + id + "_block"))
            ), new Identifier("ctft:" + id + "_block"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_block_from_material"), JRecipe.shaped(JPattern.pattern().row1("000").row2("000").row3("000"), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_block")));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_material_from_block"), JRecipe.shapeless(JIngredients.ingredients().add(block), JResult.stackedResult("minecraft:" + id, 9)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_block"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_block"))));
        }
        if (Ctft.CONFIG.tools_config.stairsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/stairs").textures((JModel.textures().var("bottom", namespace).var("top", namespace).var("side", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_stairs"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/inner_stairs").textures((JModel.textures().var("bottom", namespace).var("top", namespace).var("side", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_stairs_inner"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/outer_stairs").textures((JModel.textures().var("bottom", namespace).var("top", namespace).var("side", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_stairs_outer"));

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
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_stairs_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0  ").row2("00 ").row3("000"), JKeys.keys().key("0", ingredient), JResult.stackedResult("ctft:" + id + "_stairs", 4)));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_stairs_from_stonecutter"), JRecipe.stonecutting(block, JResult.stackedResult("ctft:" + id + "_stairs", 1)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_stairs"), JLootTable
                    .loot("block")
                    .pool(JLootTable
                            .pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_stairs"))));
        }
        if (Ctft.CONFIG.tools_config.slabsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/slab").textures((JModel.textures().var("bottom", namespace).var("top", namespace).var("side", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_slab"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/slab_top").textures((JModel.textures().var("bottom", namespace).var("top", namespace).var("side", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_slab_top"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("type=bottom", JState.model("ctft:item/" + id + "_slab"))
                    .put("type=double", JState.model("ctft:item/" + id + "_block"))
                    .put("type=top", JState.model("ctft:block/" + id + "_slab_top"))
            ), new Identifier("ctft:" + id + "_slab"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_slab_from_crafting"), JRecipe.shaped(JPattern.pattern().row3("000"), JKeys.keys().key("0", block), JResult.stackedResult("ctft:" + id + "_slab", 6)));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_slab_from_stonecutter"), JRecipe.stonecutting(block, JResult.stackedResult("ctft:" + id + "_slab", 2)));
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
        }
        if (Ctft.CONFIG.tools_config.glassEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/cube_all").textures((JModel.textures().var("all", "ctft:blocks/" + texture + "_glass").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "item/" + id + "_glass"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("", JState.model("ctft:item/" + id + "_glass"))
            ), new Identifier("ctft:" + id + "_glass"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_glass_from_smelting"), JRecipe.smelting(block, JResult.result("ctft:" + id + "_glass")).cookingTime(200).experience(0.1f));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_glass"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_glass"))));
        }
        if (Ctft.CONFIG.tools_config.glassPanesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:item/generated").textures(JModel.textures().layer0("ctft:blocks/" + texture + "_glass").particle("ctft:blocks/" + texture + "_glass")), new Identifier("ctft", "item/" + id + "_glass_pane"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside").textures((JModel.textures().var("pane", "ctft:blocks/" + texture + "_glass").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_noside"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside_alt").textures((JModel.textures().var("pane", "ctft:blocks/" + texture + "_glass").particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_noside_alt"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_post").textures((JModel.textures().var("pane", "ctft:blocks/" + texture + "_glass").var("edge", namespace).particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_post"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side").textures((JModel.textures().var("pane", "ctft:blocks/" + texture + "_glass").var("edge", namespace).particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_side"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side_alt").textures((JModel.textures().var("pane", "ctft:blocks/" + texture + "_glass").var("edge", namespace).particle("ctft:blocks/" + texture + "_glass"))), new Identifier("ctft", "block/" + id + "_glass_pane_side_alt"));

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
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_glass_pane_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", glass), JResult.stackedResult("ctft:" + id + "_glass_pane", 16)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_glass_pane"), JLootTable
                    .loot("block")
                    .pool(JLootTable
                            .pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_glass_pane"))));
        }
        if (Ctft.CONFIG.tools_config.panesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:item/generated").textures(JModel.textures().layer0(namespace).particle(namespace)), new Identifier("ctft", "item/" + id + "_pane"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside").textures((JModel.textures().var("pane", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_pane_noside"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_noside_alt").textures((JModel.textures().var("pane", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_pane_noside_alt"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_post").textures((JModel.textures().var("pane", namespace).var("edge", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_pane_post"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side").textures((JModel.textures().var("pane", namespace).var("edge", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_pane_side"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_glass_pane_side_alt").textures((JModel.textures().var("pane", namespace).var("edge", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_pane_side_alt"));

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
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_pane_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", block), JResult.stackedResult("ctft:" + id + "_pane", 16)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_pane"), JLootTable
                    .loot("block")
                    .pool(JLootTable
                            .pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_pane"))));
        }
        if (Ctft.CONFIG.tools_config.layersEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height2").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_layer"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height4").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_layer_height4"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height6").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_layer_height6"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height8").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_layer_height8"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height10").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_layer_height10"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height12").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_layer_height12"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/snow_height14").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_layer_height14"));

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
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_layer_from_crafting"), JRecipe.shaped(JPattern.pattern().row3("000"), JKeys.keys().key("0", slab), JResult.stackedResult("ctft:" + id + "_layer", 12)));
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
            if (Ctft.CONFIG.tools_config.slabsEnabled) {
                Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_slab_from_layer"), JRecipe.shaped(JPattern.pattern().row2(" 00").row3(" 00"), JKeys.keys().key("0", layer), JResult.stackedResult("ctft:" + id + "_slab", 1)));
            }
        }
        if (Ctft.CONFIG.tools_config.fencesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_inventory").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_fence"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_post").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_fence_post"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/fence_side").textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_fence_side"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state()
                            .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_post")))
                            .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_side")).when(JState.when().add("north", "true")))
                            .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_side").y(90)).when(JState.when().add("east", "true")))
                            .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_side").y(180)).when(JState.when().add("south", "true")))
                            .add(JState.multipart(JState.model("ctft:block/" + id + "_fence_side").y(270)).when(JState.when().add("west", "true")))
                    , new Identifier("ctft:" + id + "_fence"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_fence_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("010").row3("010"), JKeys.keys().key("0", ingredient).key("1", stick), JResult.stackedResult("ctft:" + id + "_fence", 3)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_fence"), JLootTable
                    .loot("block")
                    .pool(JLootTable
                            .pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_fence"))));
        }
        if (Ctft.CONFIG.tools_config.fenceGatesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_fence_gate").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "item/" + id + "_fence_gate"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_fence_gate_open").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "block/" + id + "_fence_gate_open"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_fence_gate_wall").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "block/" + id + "_fence_gate_wall_close"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_fence_gate_wall_open").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "block/" + id + "_fence_gate_wall_open"));

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
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_fence_gate_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("101").row3("101"), JKeys.keys().key("0", ingredient).key("1", stick), JResult.result("ctft:" + id + "_fence_gate")));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_fence_gate"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_fence_gate"))));
        }
        if (Ctft.CONFIG.tools_config.wallsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/wall_inventory").textures((JModel.textures().var("wall", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_wall"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_post").textures((JModel.textures().var("wall", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_wall_post"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_side").textures((JModel.textures().var("wall", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_wall_side"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_wall_side_tall").textures((JModel.textures().var("wall", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_wall_side_tall"));

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
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_wall_from_stonecutter"), JRecipe.stonecutting(ingredient, JResult.stackedResult("ctft:" + id + "_wall", 1)));
            Ctft.CTFT_RESOURCES.addTag(new Identifier("ctft", id + "_wall"), JTag.tag().add(new Identifier("blocks/walls")));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_wall"), JLootTable
                    .loot("block")
                    .pool(JLootTable
                            .pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_wall"))));
        }
        if (Ctft.CONFIG.tools_config.doorsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/door").textures((JModel.textures().var("0", "minecraft:item/oak_door").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_door"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_bottom").textures((JModel.textures().var("top", "ctft:blocks/" + texture + "_door_top").var("bottom", "ctft:blocks/" + texture + "_door_bottom").particle(namespace))), new Identifier("ctft", "block/" + id + "_door_bottom"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_bottom_rh").textures((JModel.textures().var("top", "ctft:blocks/" + texture + "_door_top").var("bottom", "ctft:blocks/" + texture + "_door_bottom").particle(namespace))), new Identifier("ctft", "block/" + id + "_door_bottom_hinge"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_top").textures((JModel.textures().var("top", "ctft:blocks/" + texture + "_door_top").var("bottom", "ctft:blocks/" + texture + "_door_bottom").particle(namespace))), new Identifier("ctft", "block/" + id + "_door_top"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/door_top_rh").textures((JModel.textures().var("top", "ctft:blocks/" + texture + "_door_top").var("bottom", "ctft:blocks/" + texture + "_door_bottom").particle(namespace))), new Identifier("ctft", "block/" + id + "_door_top_hinge"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("facing=east,half=lower,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_bottom"))
                    .put("facing=east,half=lower,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_bottom_hinge").y(90))
                    .put("facing=east,half=lower,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_bottom_hinge"))
                    .put("facing=east,half=lower,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_bottom").y(270))
                    .put("facing=east,half=upper,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_top"))
                    .put("facing=east,half=upper,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_top_hinge").y(90))
                    .put("facing=east,half=upper,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_top_hinge"))
                    .put("facing=east,half=upper,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_top").y(270))
                    .put("facing=north,half=lower,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_bottom").y(270))
                    .put("facing=north,half=lower,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_bottom_hinge"))
                    .put("facing=north,half=lower,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_bottom_hinge").y(270))
                    .put("facing=north,half=lower,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_bottom").y(180))
                    .put("facing=north,half=upper,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_top").y(270))
                    .put("facing=north,half=upper,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_top_hinge"))
                    .put("facing=north,half=upper,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_top_hinge").y(270))
                    .put("facing=north,half=upper,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_top").y(180))
                    .put("facing=south,half=lower,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_bottom").y(90))
                    .put("facing=south,half=lower,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_bottom_hinge").y(180))
                    .put("facing=south,half=lower,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_bottom_hinge").y(90))
                    .put("facing=south,half=lower,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_bottom"))
                    .put("facing=south,half=upper,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_top").y(90))
                    .put("facing=south,half=upper,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_top_hinge").y(180))
                    .put("facing=south,half=upper,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_top_hinge").y(90))
                    .put("facing=south,half=upper,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_top"))
                    .put("facing=west,half=lower,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_bottom").y(180))
                    .put("facing=west,half=lower,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_bottom_hinge").y(270))
                    .put("facing=west,half=lower,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_bottom_hinge").y(180))
                    .put("facing=west,half=lower,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_bottom").y(90))
                    .put("facing=west,half=upper,hinge=left,open=false", JState.model("ctft:block/" + id + "_door_top").y(180))
                    .put("facing=west,half=upper,hinge=left,open=true", JState.model("ctft:block/" + id + "_door_top_hinge").y(270))
                    .put("facing=west,half=upper,hinge=right,open=false", JState.model("ctft:block/" + id + "_door_top_hinge").y(180))
                    .put("facing=west,half=upper,hinge=right,open=true", JState.model("ctft:block/" + id + "_door_top").y(90))
            ), new Identifier("ctft:" + id + "_door"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_door_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("00 ").row2("00 ").row3("00 "), JKeys.keys().key("0", ingredient), JResult.stackedResult("ctft:" + id + "_door", 3)));
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
        }
        if (Ctft.CONFIG.tools_config.trapDoorsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_trapdoor_bottom").textures((JModel.textures().var("texture", "ctft:blocks/" + texture + "_trapdoor").particle(namespace))), new Identifier("ctft", "item/" + id + "_trapdoor"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_trapdoor_open").textures((JModel.textures().var("texture", "ctft:blocks/" + texture + "_trapdoor").particle(namespace))), new Identifier("ctft", "block/" + id + "_trapdoor_open"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/template_trapdoor_top").textures((JModel.textures().var("texture", "ctft:blocks/" + texture + "_trapdoor").particle(namespace))), new Identifier("ctft", "block/" + id + "_trapdoor_top"));

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
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_trapdoor_from_crafting"), JRecipe.shaped(JPattern.pattern().row2("000").row3("000"), JKeys.keys().key("0", ingredient), JResult.stackedResult("ctft:" + id + "_trapdoor", 2)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_trapdoor"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_trapdoor"))));
        }
        if (Ctft.CONFIG.tools_config.leversEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/lever").textures(JModel.textures().var("0", "minecraft:block/lever").var("1", namespace).particle(namespace)), new Identifier("ctft", "item/" + id + "_lever"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/lever").textures((JModel.textures().var("lever", "minecraft:block/lever").var("base", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_lever_off"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/lever_on").textures((JModel.textures().var("lever", "minecraft:block/lever").var("base", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_lever_on"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("face=ceiling,facing=east,powered=false", JState.model("ctft:block/" + id + "_lever_off").x(180).y(270))
                    .put("face=ceiling,facing=east,powered=true", JState.model("ctft:block/" + id + "_lever_on").x(180).y(270))
                    .put("face=ceiling,facing=north,powered=false", JState.model("ctft:block/" + id + "_lever_off").x(180).y(180))
                    .put("face=ceiling,facing=north,powered=true", JState.model("ctft:block/" + id + "_lever_on").x(180).y(180))
                    .put("face=ceiling,facing=south,powered=false", JState.model("ctft:block/" + id + "_lever_off").x(180))
                    .put("face=ceiling,facing=south,powered=true", JState.model("ctft:block/" + id + "_lever_on").x(180))
                    .put("face=ceiling,facing=west,powered=false", JState.model("ctft:block/" + id + "_lever_off").x(180).y(90))
                    .put("face=ceiling,facing=west,powered=true", JState.model("ctft:block/" + id + "_lever_on").x(180).y(90))
                    .put("face=floor,facing=east,powered=false", JState.model("ctft:block/" + id + "_lever_off").y(90))
                    .put("face=floor,facing=east,powered=true", JState.model("ctft:block/" + id + "_lever_on").y(90))
                    .put("face=floor,facing=north,powered=false", JState.model("ctft:block/" + id + "_lever_off"))
                    .put("face=floor,facing=north,powered=true", JState.model("ctft:block/" + id + "_lever_on"))
                    .put("face=floor,facing=south,powered=false", JState.model("ctft:block/" + id + "_lever_off").y(180))
                    .put("face=floor,facing=south,powered=true", JState.model("ctft:block/" + id + "_lever_on").y(180))
                    .put("face=floor,facing=west,powered=false", JState.model("ctft:block/" + id + "_lever_off").y(270))
                    .put("face=floor,facing=west,powered=true", JState.model("ctft:block/" + id + "_lever_on").y(270))
                    .put("face=wall,facing=east,powered=false", JState.model("ctft:block/" + id + "_lever_off").x(90).y(90))
                    .put("face=wall,facing=east,powered=true", JState.model("ctft:block/" + id + "_lever_on").x(90).y(90))
                    .put("face=wall,facing=north,powered=false", JState.model("ctft:block/" + id + "_lever_off").x(90))
                    .put("face=wall,facing=north,powered=true", JState.model("ctft:block/" + id + "_lever_on").x(90))
                    .put("face=wall,facing=south,powered=false", JState.model("ctft:block/" + id + "_lever_off").x(90).y(180))
                    .put("face=wall,facing=south,powered=true", JState.model("ctft:block/" + id + "_lever_on").x(90).y(180))
                    .put("face=wall,facing=west,powered=false", JState.model("ctft:block/" + id + "_lever_off").x(90).y(270))
                    .put("face=wall,facing=west,powered=true", JState.model("ctft:block/" + id + "_lever_on").x(90).y(270))
            ), new Identifier("ctft:" + id + "_lever"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_lever_from_crafting"), JRecipe.shaped(JPattern.pattern().row2(" 0 ").row3(" 1 "), JKeys.keys().key("0", stick).key("1", ingredient), JResult.result("ctft:" + id + "_lever")));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_lever"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_lever"))));
        }
        if (Ctft.CONFIG.tools_config.buttonsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/button_inventory").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "item/" + id + "_button"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/button").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "block/" + id + "_button_off"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/button_pressed").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "block/" + id + "_button_on"));

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
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_button_from_stonecutter"), JRecipe.stonecutting(ingredient, JResult.stackedResult("ctft:" + id + "_button", 1)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_button"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_button"))));
        }
        if (Ctft.CONFIG.tools_config.pressurePlatesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/pressure_plate_up").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "item/" + id + "_pressure_plate"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/pressure_plate_down").textures((JModel.textures().var("texture", namespace))), new Identifier("ctft", "block/" + id + "_pressure_plate_on"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("powered=false", JState.model("ctft:item/" + id + "_pressure_plate"))
                    .put("powered=true", JState.model("ctft:block/" + id + "_pressure_plate_on"))
            ), new Identifier("ctft:" + id + "_pressure_plate"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_pressure_plate_from_crafting"), JRecipe.shaped(JPattern.pattern().row3("00 "), JKeys.keys().key("0", ingredient), JResult.result("ctft:" + id + "_pressure_plate")));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_pressure_plate"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_pressure_plate"))));
        }
        if (Ctft.CONFIG.tools_config.torchesEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/torch").textures((JModel.textures().var("0", "minecraft:block/torch").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_torch"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/template_torch").textures((JModel.textures().var("0", "minecraft:block/torch").var("1", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_torch"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/template_torch_wall").textures((JModel.textures().var("1", "minecraft:block/torch").var("2", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_torch_wall"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("", JState.model("ctft:block/" + id + "_torch"))
            ), new Identifier("ctft:" + id + "_torch"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("facing=east", JState.model("ctft:block/" + id + "_torch_wall"))
                    .put("facing=north", JState.model("ctft:block/" + id + "_torch_wall").y(270))
                    .put("facing=south", JState.model("ctft:block/" + id + "_torch_wall").y(90))
                    .put("facing=west", JState.model("ctft:block/" + id + "_torch_wall").y(180))
            ), new Identifier("ctft:" + id + "_walltorch"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_torch_from_crafting"), JRecipe.shaped(JPattern.pattern().row1(" 1 ").row2(" 0 "), JKeys.keys().key("0", ingredient).key("1", coal), JResult.stackedResult("ctft:" + id + "_torch", 4)));
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
        }
        if (Ctft.CONFIG.tools_config.lanternsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/lantern").textures((JModel.textures().var("0", "minecraft:item/lantern").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_lantern"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/template_lantern").textures((JModel.textures().var("2", "minecraft:block/lantern").var("1", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_lantern"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:block/template_hanging_lantern").textures((JModel.textures().var("1", "minecraft:block/lantern").var("2", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_lantern_hanging"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("hanging=false", JState.model("ctft:block/" + id + "_lantern"))
                    .put("hanging=true", JState.model("ctft:block/" + id + "_lantern_hanging"))
            ), new Identifier("ctft:" + id + "_lantern"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_lantern_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2("010").row3("000"), JKeys.keys().key("1", torch).key("0", ingredient), JResult.result("ctft:" + id + "_lantern")));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_lantern"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_lantern"))));
        }
        if (Ctft.CONFIG.tools_config.endRodsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/end_rod").textures((JModel.textures().var("end_rod", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_end_rod"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("facing=down", JState.model("ctft:item/" + id + "_end_rod").x(180))
                    .put("facing=east", JState.model("ctft:item/" + id + "_end_rod").x(90).y(90))
                    .put("facing=north", JState.model("ctft:item/" + id + "_end_rod").x(90))
                    .put("facing=south", JState.model("ctft:item/" + id + "_end_rod").x(90).y(180))
                    .put("facing=up", JState.model("ctft:item/" + id + "_end_rod"))
                    .put("facing=west", JState.model("ctft:item/" + id + "_end_rod").x(90).y(270))
            ), new Identifier("ctft:" + id + "_end_rod"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_end_rod_from_stonecutter"), JRecipe.stonecutting(ingredient, JResult.stackedResult("ctft:" + id + "_end_rod", 1)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_end_rod"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_end_rod"))));
        }
        if (Ctft.CONFIG.tools_config.signsEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("ctft:item/sign").textures((JModel.textures().var("0", "minecraft:item/oak_sign").var("1", namespace).particle(namespace))), new Identifier("ctft", "item/" + id + "_sign"));

            Ctft.CTFT_RESOURCES.addModel(JModel.model().textures((JModel.textures().var("texture", namespace).particle(namespace))), new Identifier("ctft", "block/" + id + "_sign"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("", JState.model("ctft:block/" + id + "_sign"))
            ), new Identifier("ctft:" + id + "_sign"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_sign_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("000").row2("000").row3(" 1 "), JKeys.keys().key("0", ingredient).key("1", stick), JResult.stackedResult("ctft:" + id + "_sign", 3)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_sign"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_sign"))));
        }
        if (Ctft.CONFIG.tools_config.laddersEnabled) {
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:item/generated").textures(JModel.textures().layer0("ctft:blocks/" + texture + "_ladder").particle("ctft:blocks/" + texture + "_ladder")), new Identifier("ctft", "item/" + id + "_ladder"));
            Ctft.CTFT_RESOURCES.addModel(JModel.model().parent("minecraft:block/ladder").textures(JModel.textures().var("texture", "ctft:blocks/" + texture + "_ladder").particle("ctft:blocks/" + texture + "_ladder")), new Identifier("ctft", "block/" + id + "_ladder"));

            Ctft.CTFT_RESOURCES.addBlockState(JState.state().add(JState.variant()
                    .put("facing=east", JState.model("ctft:block/" + id + "_ladder").y(90))
                    .put("facing=north", JState.model("ctft:block/" + id + "_ladder"))
                    .put("facing=south", JState.model("ctft:block/" + id + "_ladder").y(180))
                    .put("facing=west", JState.model("ctft:block/" + id + "_ladder").y(270))
            ), new Identifier("ctft:" + id + "_ladder"));
            Ctft.CTFT_RESOURCES.addRecipe(new Identifier("ctft:" + id + "_ladder_from_crafting"), JRecipe.shaped(JPattern.pattern().row1("0 0").row2("000").row3("0 0"), JKeys.keys().key("0", ingredient), JResult.stackedResult("ctft:" + id + "_ladder", 3)));
            Ctft.CTFT_RESOURCES.addLootTable(new Identifier("ctft", "blocks/" + id + "_ladder"), JLootTable
                    .loot("block")
                    .pool(JLootTable.pool()
                            .rolls(1)
                            .entry(JLootTable
                                    .entry()
                                    .type("minecraft:item")
                                    .name("ctft:" + id + "_ladder"))));
        }
    }
}