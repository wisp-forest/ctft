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

    public static class CtftClocks extends CreativeModeTab {
        public CtftClocks() {
            super("ctft_clocks");
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.CLOCK);
        }
    }

    public static class CtftHelmets extends CreativeModeTab {
        public CtftHelmets() { super("ctft_helmets");  }

        @Override
        public ItemStack makeIcon() {return new ItemStack(Items.LEATHER_HELMET);}
    }

    public static class CtftChestplates extends CreativeModeTab {
        public CtftChestplates() { super("ctft_chestplates");  }

        @Override
        public ItemStack makeIcon() {return new ItemStack(Items.LEATHER_CHESTPLATE);}
    }

    public static class CtftLeggings extends CreativeModeTab {
        public CtftLeggings() { super("ctft_leggings");  }

        @Override
        public ItemStack makeIcon() {return new ItemStack(Items.LEATHER_LEGGINGS);}
    }

    public static class CtftBoots extends CreativeModeTab {
        public CtftBoots() { super("ctft_boots");  }

        @Override
        public ItemStack makeIcon() {return new ItemStack(Items.LEATHER_BOOTS);}
    }

    public static class CtftCompasses extends CreativeModeTab {
        public CtftCompasses() { super("ctft_compasses");  }

        @Override
        public ItemStack makeIcon() {return new ItemStack(Items.COMPASS);}
    }

    public static class CtftHorseArmor extends CreativeModeTab {
        public CtftHorseArmor() { super("ctft_horse_armor");  }

        @Override
        public ItemStack makeIcon() {return new ItemStack(Items.LEATHER_HORSE_ARMOR);}
    }

    public static class CtftBows extends CreativeModeTab {
        public CtftBows() { super("ctft_bows");  }

        @Override
        public ItemStack makeIcon() {return new ItemStack(Items.BOW);}
    }
}
