package com.chyzman.ctft.Items;

import com.chyzman.ctft.classes.ChyzbladeItem;
import com.chyzman.ctft.classes.CtftIconItem;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static com.chyzman.ctft.Ctft.id;

public class MiscInit {
    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, id(name), item);
    }
    public static final Tag<Block> ALL = TagFactory.BLOCK.create(new Identifier("ctft", "all"));
    public static final ToolMaterial chyzbladematerial = new ToolMaterial() {@Override public int getDurability() {return 0;}@Override public float getMiningSpeedMultiplier() {return Float.POSITIVE_INFINITY;}@Override public float getAttackDamage() {return Float.POSITIVE_INFINITY;}@Override public int getMiningLevel() {return (int)(Float.POSITIVE_INFINITY);}@Override public int getEnchantability() {return Integer.MAX_VALUE;}@Override public Ingredient getRepairIngredient() {return null;}};
    public static final Item CHYZBLADE = register("chyzblade", new ChyzbladeItem(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, chyzbladematerial, ALL, new Item.Settings().fireproof().rarity(Rarity.EPIC)));
    public static final Item CTFTICON = register("ctft", new CtftIconItem(new Item.Settings()));
    public static void INIT() {}
}
