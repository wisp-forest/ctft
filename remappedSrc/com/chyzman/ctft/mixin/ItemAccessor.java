package com.chyzman.ctft.mixin;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.UUID;

@Mixin(Item.class)
public interface ItemAccessor {
    @Accessor("ATTACK_DAMAGE_MODIFIER_ID")
    static UUID ctft$ATTACK_DAMAGE_MODIFIER_ID() {
        throw new UnsupportedOperationException();
    }

    @Accessor("ATTACK_SPEED_MODIFIER_ID")
    static UUID ctft$ATTACK_SPEED_MODIFIER_ID() {
        throw new UnsupportedOperationException();
    }

    @Accessor("DEFAULT_MAX_USE_TIME")
    static int ctft$DEFAULT_MAX_USE_TIME() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    Rarity getRarity();

    @Accessor
    int getMaxCount();

    @Accessor
    int getMaxDamage();

    @Accessor
    boolean isFireproof();

    @Accessor
    Item getRecipeRemainder();

    @Accessor
    FoodComponent getFoodComponent();
}