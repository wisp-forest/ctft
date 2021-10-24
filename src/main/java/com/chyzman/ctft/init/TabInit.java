package com.chyzman.ctft.init;

import com.chyzman.ctft.Ctft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TabInit {
    public static class CtftSwords extends CreativeModeTab
    {
        public CtftSwords()
        {
            super("ctft_swords");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.WOODEN_SWORD);
        }
    }
    public static class CtftPickaxes extends CreativeModeTab
    {
        public CtftPickaxes()
        {
            super("ctft_pickaxes");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.WOODEN_PICKAXE);
        }
    }
    public static class CtftAxes extends CreativeModeTab
    {
        public CtftAxes()
        {
            super("ctft_axes");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.WOODEN_AXE);
        }
    }
    public static class CtftShovels extends CreativeModeTab
    {
        public CtftShovels()
        {
            super("ctft_shovels");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.WOODEN_SHOVEL);
        }
    }
    public static class CtftHoes extends CreativeModeTab
    {
        public CtftHoes()
        {
            super("ctft_hoes");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.WOODEN_HOE);
        }
    }
    public static class CtftShears extends CreativeModeTab
    {
        public CtftShears()
        {
            super("ctft_shears");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.SHEARS);
        }
    }
    public static class CtftShields extends CreativeModeTab
    {
        public CtftShields()
        {
            super("ctft_shields");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.SHIELD);
        }
    }
    public static class CtftFishingRods extends CreativeModeTab
    {
        public CtftFishingRods()
        {
            super("ctft_fishing_rods");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.FISHING_ROD);
        }
    }

    public static class CtftClocks extends CreativeModeTab
    {
        public CtftClocks()
        {
            super("ctft_clocks");
        }

        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.CLOCK);
        }
    }
}
