package com.chyzman.ctft.classes;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public enum CtftMaterial implements ToolMaterial {
    CTFT("ctft",
            1,
            1,
            1,
            new int[]{0, 0, 0, 0},
            1f,
            1f,
            1,
            1f,
            1,
            null,
            () -> null);

    private final String name;
    private final float attackDamage;
    private final int itemDurability;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final float toughness;
    private final float knockbackResistance;
    private final int miningLevel;
    private final float miningSpeedMultiplier;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairIngredient;

    CtftMaterial(
            String name,
            float attackDamage,
            int itemDurability,
            int durabilityMultiplier,
            int[] protectionAmounts,
            float toughness,
            float knockbackResistance,
            int miningLevel,
            float miningSpeedMultiplier,
            int enchantability,
            SoundEvent equipSound,
            Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.itemDurability = itemDurability;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.miningLevel = miningLevel;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return 1;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}