package com.chyzman.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingHook.class)
public abstract class CustomFishingItemFix {
    @Inject(at = @At("HEAD"), method = "shouldStopFishing(Lnet/minecraft/world/entity/player/Player;)Z")
    private void shouldStopFishing(Player player, CallbackInfoReturnable<Boolean> callback) {
        ItemStack itemstack = player.getMainHandItem();
        ItemStack itemstackOffhand = player.getOffhandItem();
        boolean flag = itemstack.getItem() instanceof FishingRodItem;
        boolean flagOffhand = itemstackOffhand.getItem() instanceof FishingRodItem;
        if (!player.isRemoved() && player.isAlive() && (flag || flagOffhand) && !(this.distanceToSqr(player) > 1024.0D)) {
            callback.setReturnValue(false);
        } else {
            this.discard();
            callback.setReturnValue(true);
        }
    }
    @Shadow
    public void discard() {
        throw new IllegalStateException("Mixin failed to shadow discard()");
    }
    @Shadow
    public double distanceToSqr(Player p_37137_) {
        throw new IllegalStateException("Mixin failed to shadow distanceToSqr()");
    }
}
