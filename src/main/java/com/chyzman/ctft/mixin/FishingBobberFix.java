package com.chyzman.ctft.mixin;

import com.chyzman.ctft.classes.CustomFishingRodItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(FishingBobberEntity.class)
public class FishingBobberFix{

    private ItemStack ctft$leftStack = null;
    private ItemStack ctft$rightStack = null;

    @Inject(method = "removeIfInvalid", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
    private void captureRods(PlayerEntity player, CallbackInfoReturnable<Boolean> cir, ItemStack leftStack, ItemStack rightStack) {
        this.ctft$leftStack = leftStack;
        this.ctft$rightStack = rightStack;
    }

    @ModifyVariable(method = "removeIfInvalid", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isRemoved()Z"), ordinal = 0)
    private boolean handleLeftRod(boolean isRod) {
        return isRod || ctft$leftStack.getItem() instanceof FishingRodItem;
    }

    @ModifyVariable(method = "removeIfInvalid", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isRemoved()Z"), ordinal = 1)
    private boolean handleRightRod(boolean isRod) {
        return isRod || ctft$rightStack.getItem() instanceof FishingRodItem;
    }

    @Inject(method = "removeIfInvalid", at = @At("RETURN"))
    private void releaseRods(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        this.ctft$leftStack = null;
        this.ctft$rightStack = null;
    }

}