package com.chyzman.ctft.mixin.accessor;

import net.minecraft.item.CompassItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Optional;

@Mixin(CompassItem.class)
public interface LodestonePosAccessor {

    @Invoker("getLodestoneDimension")
    static Optional<RegistryKey<World>> getLodestoneDimension(NbtCompound nbt) {
        throw new IllegalStateException("this will never be thrown");
    }
}
