package com.chyzman.ctft.mixin;

import com.chyzman.ctft.Items.MiscInit;
import com.chyzman.ctft.util.ChyzbladeDamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(PlayerEntity.class)
public abstract class ChyzbladeMixin extends LivingEntity {
    protected ChyzbladeMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "attack", at = @At(value = "HEAD"), cancellable = true)
    private void MakeChyzbladeGoBrrr(Entity target, CallbackInfo ci) {
        if (this.getMainHandStack().isOf(MiscInit.CHYZBLADE)) {
            if (this.getUuid().equals(UUID.fromString("09de8a6d-86bf-4c15-bb93-ce3384ce4e96"))) {
                if (target instanceof LivingEntity living) living.setAttacker(this);
                target.damage(new ChyzbladeDamageSource(), Float.MAX_VALUE);
            } else {
                this.damage(new ChyzbladeDamageSource().setUnworthy(), Float.MAX_VALUE);
            }
            ci.cancel();
        }
    }
}