package com.chyzman.ctft.client;

import net.minecraft.client.item.UnclampedModelPredicateProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ClockPredicate implements UnclampedModelPredicateProvider {
    private double time;
    private double step;
    private long lastTick;

    @Override
    public float unclampedCall(ItemStack itemStack, @Nullable ClientWorld clientWorld, @Nullable LivingEntity livingEntity, int i) {
        Entity entity;
        Entity entity2 = entity = livingEntity != null ? livingEntity : itemStack.getHolder();
        if (entity == null) {
            return 0.0f;
        }
        if (clientWorld == null && entity.world instanceof ClientWorld) {
            clientWorld = (ClientWorld) entity.world;
        }
        if (clientWorld == null) {
            return 0.0f;
        }
        double d = clientWorld.getDimension().isNatural() ? (double) clientWorld.getSkyAngle(1.0f) : Math.random();
        d = this.getTime(clientWorld, d);
        return (float) d;
    }

    private double getTime(World world, double skyAngle) {
        if (world.getTime() != this.lastTick) {
            this.lastTick = world.getTime();
            double d = skyAngle - this.time;
            d = MathHelper.floorMod(d + 0.5, 1.0) - 0.5;
            this.step += d * 0.1;
            this.step *= 0.9;
            this.time = MathHelper.floorMod(this.time + this.step, 1.0);
        }
        return this.time;
    }
}
