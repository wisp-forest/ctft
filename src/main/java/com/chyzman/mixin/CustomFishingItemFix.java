package com.chyzman.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingHook.class)
public class CustomFishingItemFix {
    @Inject(at = @At("INVOKE"), method = "Lnet/minecraft/world/entity/projectile/FishingHook;shouldStopFishing(Lnet/minecraft/world/entity/player/Player;)Z")
    private boolean shouldStopFishing(Player p_37137_, CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemstack = p_37137_.getMainHandItem();
        ItemStack itemstack1 = p_37137_.getOffhandItem();
        boolean flag = itemstack.getItem() instanceof FishingRodItem;
        boolean flag1 = itemstack1.getItem() instanceof FishingRodItem;
        if (!p_37137_.isRemoved() && p_37137_.isAlive() && (flag || flag1) && !(this.distanceToSqr(p_37137_) > 1024.0D)) {
            return false;
        } else {
            this.discard();
            return true;
        }
    }
}