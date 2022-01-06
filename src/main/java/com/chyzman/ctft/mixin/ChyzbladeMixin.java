package com.chyzman.ctft.mixin;

import com.chyzman.ctft.Items.MiscInit;
import com.chyzman.ctft.util.ChyzbladeDamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(PlayerEntity.class)
public abstract class ChyzbladeMixin extends LivingEntity {
    @Shadow
    public abstract boolean damage(DamageSource source, float amount);

    @Shadow
    public abstract Text getName();

    protected ChyzbladeMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "attack", at = @At(value = "HEAD"), cancellable = true)
    private void MakeChyzbladeGoBrrr(Entity target, CallbackInfo ci) {
        if (this.getMainHandStack().isOf(MiscInit.CHYZBLADE)) {
            if (!target.getUuid().equals(UUID.fromString("09de8a6d-86bf-4c15-bb93-ce3384ce4e96"))) {
                if (this.getUuid().equals(UUID.fromString("09de8a6d-86bf-4c15-bb93-ce3384ce4e96"))) {
                    if (target instanceof LivingEntity living) living.setAttacker(this);
                    target.damage(new ChyzbladeDamageSource(), Float.MAX_VALUE);
                } else if (this.getName().asString().contains("cheese") || this.getName().asString().contains("chyz") || this.getUuid().equals(UUID.fromString("b6c2d403-bf7c-4e19-b7a2-f64c9e44e56a")) || this.getUuid().equals(UUID.fromString("f70810d5-e698-4780-84a0-1da0541f1fc0\n"))) {
                    this.damage(new ChyzbladeDamageSource().setUnworthy(), this.getHealth() > 1 ? this.getHealth() - 1 : 1);
                    target.damage(new ChyzbladeDamageSource(), 100);
                } else {
                    this.damage(new ChyzbladeDamageSource().setUnworthy(), Float.MAX_VALUE);
                }
            }
            ci.cancel();
        }
    }
}