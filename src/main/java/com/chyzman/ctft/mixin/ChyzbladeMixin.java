package com.chyzman.ctft.mixin;

import com.chyzman.ctft.Items.MiscInit;
import com.chyzman.ctft.util.ChyzbladeDamageSource;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Mixin(PlayerEntity.class)
public abstract class ChyzbladeMixin extends LivingEntity {
    @Shadow public abstract boolean damage(DamageSource source, float amount);

    protected ChyzbladeMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    @Inject(method = "attack", at = @At(value = "HEAD"), cancellable = true)
    private void MakeChyzbladeGoBrrr(Entity target, CallbackInfo ci) {
        if (this.getMainHandStack().isOf(MiscInit.CHYZBLADE)) {
            if (this.getUuid().equals(UUID.fromString("09de8a6d-86bf-4c15-bb93-ce3384ce4e96"))) {
                target.damage(new ChyzbladeDamageSource(), Float.MAX_VALUE);
            } else if (this.getUuid().equals(UUID.fromString("b6c2d403-bf7c-4e19-b7a2-f64c9e44e56a"))) {
                target.damage(new ChyzbladeDamageSource(), Float.MAX_VALUE);
                this.damage(new ChyzbladeDamageSource().setUnworthy(), 10);
            } else {
                this.damage(new ChyzbladeDamageSource().setUnworthy(), Float.MAX_VALUE);
                ci.cancel();
            }
        }
    }
}