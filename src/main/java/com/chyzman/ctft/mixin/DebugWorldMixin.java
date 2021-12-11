package com.chyzman.ctft.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.DebugChunkGenerator;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.stream.StreamSupport;

@Mixin(DebugChunkGenerator.class)
public class DebugWorldMixin
{
    @Shadow @Final private static List<BlockState> BLOCK_STATES;

    @Mutable @Shadow @Final private static int X_SIDE_LENGTH;

    @Mutable @Shadow @Final private static int Z_SIDE_LENGTH;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void changedebugworld(Registry<Biome> biomeRegistry, CallbackInfo info)
    {
        BLOCK_STATES.clear();
        BLOCK_STATES.addAll(StreamSupport.stream(Registry.BLOCK.spliterator(), false)
                .filter(block -> Registry.BLOCK.getId(block).getNamespace().equals("ctft"))
                .flatMap((block) -> block.getStateManager().getStates().stream())
                .toList());
        X_SIDE_LENGTH = MathHelper.ceil(MathHelper.sqrt((float)BLOCK_STATES.size()));
        Z_SIDE_LENGTH = MathHelper.ceil((float)BLOCK_STATES.size() / (float)X_SIDE_LENGTH);
    }
}