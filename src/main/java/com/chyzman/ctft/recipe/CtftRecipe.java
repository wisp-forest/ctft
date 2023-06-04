package com.chyzman.ctft.recipe;

import com.chyzman.ctft.registries.CtftRecipeSerializers;
import com.chyzman.ctft.registries.CtftRegistry;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Set;

public class CtftRecipe extends SpecialCraftingRecipe {
    final int width;
    final int height;
    final DefaultedList<Ingredient> input;
    final ItemStack output;
    final CraftingRecipeCategory category;

    public CtftRecipe(
            Identifier id,
            CraftingRecipeCategory category,
            int width,
            int height,
            DefaultedList<Ingredient> input,
            ItemStack output
    ) {
        super(id, category);
        this.category = category;
        this.width = width;
        this.height = height;
        this.input = input;
        this.output = output;
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        for (int i = 0; i <= inventory.getWidth() - this.width; ++i) {
            for (int j = 0; j <= inventory.getHeight() - this.height; ++j) {
                if (this.matchesPattern(inventory, i, j, true)) {
                    return true;
                }

                if (this.matchesPattern(inventory, i, j, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matchesPattern(CraftingInventory inv, int offsetX, int offsetY, boolean flipped) {
        for (int i = 0; i < inv.getWidth(); ++i) {
            for (int j = 0; j < inv.getHeight(); ++j) {
                int k = i - offsetX;
                int l = j - offsetY;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    if (flipped) {
                        ingredient = this.input.get(this.width - k - 1 + l * this.width);
                    } else {
                        ingredient = this.input.get(k + l * this.width);
                    }
                }

                if (!ingredient.test(inv.getStack(i + j * inv.getWidth()))) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory, DynamicRegistryManager registryManager) {
        ItemStack out = output.copy();
        var nbt = out.getOrCreateNbt();
        nbt.putString("material", Registries.ITEM.getId(inventory.getStack(1).getItem()).toString());
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
        return CtftRecipeSerializers.CTFT_SHAPED;
    }

    static DefaultedList<Ingredient> createPatternMatrix(String[] pattern, Map<String, Ingredient> symbols, int width, int height) {
        DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(width * height, Ingredient.EMPTY);
        Set<String> set = Sets.newHashSet(symbols.keySet());
        set.remove(" ");

        for (int i = 0; i < pattern.length; ++i) {
            for (int j = 0; j < pattern[i].length(); ++j) {
                String string = pattern[i].substring(j, j + 1);
                Ingredient ingredient = (Ingredient) symbols.get(string);
//                if (ingredient == null) {
//                    throw new JsonSyntaxException("Pattern references symbol '" + string + "' but it's not defined in the key");
//                }

                set.remove(string);
                defaultedList.set(j + width * i, ingredient);
            }
        }

        if (!set.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        } else {
            return defaultedList;
        }
    }

    static Map<String, Ingredient> readSymbols(JsonObject json) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            if (((String) entry.getKey()).length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + (String) entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put((String) entry.getKey(), ((JsonObject) entry.getValue()).get("item").getAsString().equals("anything") ? null : Ingredient.fromJson((JsonElement) entry.getValue()));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    static String[] getPattern(JsonArray json) {
        String[] strings = new String[json.size()];
        if (strings.length > 3) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, 3 is maximum");
        } else if (strings.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        } else {
            for (int i = 0; i < strings.length; ++i) {
                String string = JsonHelper.asString(json.get(i), "pattern[" + i + "]");
                if (string.length() > 3) {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, 3 is maximum");
                }

                if (i > 0 && strings[0].length() != string.length()) {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }

                strings[i] = string;
            }

            return strings;
        }
    }

    static String[] removePadding(String... pattern) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for (int m = 0; m < pattern.length; ++m) {
            String string = pattern[m];
            i = Math.min(i, findFirstSymbol(string));
            int n = findLastSymbol(string);
            j = Math.max(j, n);
            if (n < 0) {
                if (k == m) {
                    ++k;
                }

                ++l;
            } else {
                l = 0;
            }
        }

        if (pattern.length == l) {
            return new String[0];
        } else {
            String[] strings = new String[pattern.length - l - k];

            for (int o = 0; o < strings.length; ++o) {
                strings[o] = pattern[o + k].substring(i, j + 1);
            }

            return strings;
        }
    }

    private static int findFirstSymbol(String line) {
        int i = 0;

        while (i < line.length() && line.charAt(i) == ' ') {
            ++i;
        }

        return i;
    }

    private static int findLastSymbol(String pattern) {
        int i = pattern.length() - 1;

        while (i >= 0 && pattern.charAt(i) == ' ') {
            --i;
        }

        return i;
    }

    public static class Serializer implements RecipeSerializer<CtftRecipe> {
        public CtftRecipe read(Identifier identifier, JsonObject jsonObject) {
            CraftingRecipeCategory craftingRecipeCategory = (CraftingRecipeCategory) CraftingRecipeCategory.CODEC
                    .byId(JsonHelper.getString(jsonObject, "category", null), CraftingRecipeCategory.MISC);
            Map<String, Ingredient> map = readSymbols(JsonHelper.getObject(jsonObject, "key"));
            String[] strings = removePadding(getPattern(JsonHelper.getArray(jsonObject, "pattern")));
            int i = strings[0].length();
            int j = strings.length;
            DefaultedList<Ingredient> defaultedList = createPatternMatrix(strings, map, i, j);
            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "result"));
            return new CtftRecipe(identifier, craftingRecipeCategory, i, j, defaultedList, itemStack);
        }

        public CtftRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
            int i = packetByteBuf.readVarInt();
            int j = packetByteBuf.readVarInt();
            CraftingRecipeCategory craftingRecipeCategory = packetByteBuf.readEnumConstant(CraftingRecipeCategory.class);
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i * j, Ingredient.EMPTY);

            defaultedList.replaceAll(ignored -> Ingredient.fromPacket(packetByteBuf));

            ItemStack itemStack = packetByteBuf.readItemStack();
            return new CtftRecipe(identifier, craftingRecipeCategory, i, j, defaultedList, itemStack);
        }

        public void write(PacketByteBuf packetByteBuf, CtftRecipe ctftRecipe) {
            packetByteBuf.writeVarInt(ctftRecipe.width);
            packetByteBuf.writeVarInt(ctftRecipe.height);
            packetByteBuf.writeEnumConstant(ctftRecipe.category);

            for (Ingredient ingredient : ctftRecipe.input) {
                ingredient.write(packetByteBuf);
            }

            packetByteBuf.writeItemStack(ctftRecipe.output);
        }
    }

}