package com.chyzman.ctft.classes;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CompassItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;

public class ClockRender implements ClampedItemPropertyFunction {
    private double rotation;
    private double rota;
    private long lastUpdateTick;

    public float unclampedCall(ItemStack p_174665_, @Nullable ClientLevel p_174666_, @Nullable LivingEntity p_174667_, int p_174668_) {
        Entity entity = (Entity)(p_174667_ != null ? p_174667_ : p_174665_.getEntityRepresentation());
        if (entity == null) {
            return 0.0F;
        } else {
            if (p_174666_ == null && entity.level instanceof ClientLevel) {
                p_174666_ = (ClientLevel)entity.level;
            }

            if (p_174666_ == null) {
                return 0.0F;
            } else {
                double d0;
                if (p_174666_.dimensionType().natural()) {
                    d0 = (double)p_174666_.getTimeOfDay(1.0F);
                } else {
                    d0 = Math.random();
                }

                d0 = this.wobble(p_174666_, d0);
                return (float)d0;
            }
        }
    }

    private double wobble(Level p_117904_, double p_117905_) {
        if (p_117904_.getGameTime() != this.lastUpdateTick) {
            this.lastUpdateTick = p_117904_.getGameTime();
            double d0 = p_117905_ - this.rotation;
            d0 = Mth.positiveModulo(d0 + 0.5D, 1.0D) - 0.5D;
            this.rota += d0 * 0.1D;
            this.rota *= 0.9D;
            this.rotation = Mth.positiveModulo(this.rotation + this.rota, 1.0D);
        }

        return this.rotation;
    }
}
