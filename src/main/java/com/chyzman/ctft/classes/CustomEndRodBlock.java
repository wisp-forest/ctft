package com.chyzman.ctft.classes;

import net.minecraft.block.BlockState;
import net.minecraft.block.EndRodBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class CustomEndRodBlock extends EndRodBlock implements com.chyzman.ctft.classes.EndRodBlock {
    public CustomEndRodBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    }
}
