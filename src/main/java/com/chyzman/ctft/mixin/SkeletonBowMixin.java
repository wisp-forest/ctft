package com.chyzman.ctft.mixin;

import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(AbstractSkeletonEntity.class)
public class SkeletonBowMixin {
    @ModifyVariable(method = "updateAttackType", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private ItemStack MakeSkeletonsWork(ItemStack stack) {
        if (stack.getItem() instanceof BowItem)
            return new ItemStack(Items.BOW);
        else
            return stack;
    }
}