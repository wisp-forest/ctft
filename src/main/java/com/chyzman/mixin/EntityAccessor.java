package com.chyzman.mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityAccessor {
    @Invoker
    double callDistanceToSqr(Entity pEntity);

    @Invoker
    void callDiscard();
}