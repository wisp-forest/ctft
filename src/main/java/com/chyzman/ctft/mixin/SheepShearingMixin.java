package com.chyzman.ctft.mixin;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public class SheepShearingMixin {
    @Unique
    private PlayerEntity ctft_currentPlayer;
    @Unique private Hand ctft_currentHand;

    @Inject(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private void stashArgs(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ctft_currentPlayer = player;
        ctft_currentHand = hand;
    }

    @Inject(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", shift = At.Shift.AFTER))
    private void unstashArgs(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ctft_currentPlayer = null;
        ctft_currentHand = null;
    }

    @ModifyArg(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private Item makeShearsWorkTm(Item item) {
        ItemStack itemStack = ctft_currentPlayer.getStackInHand(ctft_currentHand);
        if (itemStack.getItem() instanceof ShearsItem)
            return itemStack.getItem();
        else
            return item;
    }
}