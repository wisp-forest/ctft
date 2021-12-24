package com.chyzman.ctft.mixin;

import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.RangedWeaponItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PillagerEntity.class)
public class PillagerCrossbowMixin {
    @Inject(method = "canUseRangedWeapon", at = @At(value = "HEAD"))
    private void MakePillagersWork(RangedWeaponItem weapon, CallbackInfoReturnable<Boolean> cir) {
        if (weapon instanceof CrossbowItem) {
            cir.setReturnValue(true);
        }
    }
}