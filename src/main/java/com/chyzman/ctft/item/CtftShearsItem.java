package com.chyzman.ctft.item;

import com.chyzman.ctft.classes.CtftMaterial;
import com.chyzman.ctft.mixin.ItemAccessor;
import com.chyzman.ctft.util.CtftOverrideHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Random;

import static com.chyzman.ctft.registries.CtftStats.MATERIALS;

public class CtftShearsItem extends ShearsItem {
    public CtftShearsItem(Settings settings) {
        super(settings.maxCount(1).maxDamage(1));
    }

    @Override
    public Text getName(ItemStack stack) {
        return CtftOverrideHelper.getName(stack, "item.ctft.shears", stack1 -> super.getName(stack));
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        return CtftOverrideHelper.getItemBarStep(stack);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return CtftOverrideHelper.getItemBarColor(stack);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB) || state.isIn(BlockTags.LEAVES)) {
            return 15.0F;
        } else if (state.isIn(BlockTags.WOOL)) {
            return 5.0F;
        } else {
            return !state.isOf(Blocks.VINE) && !state.isOf(Blocks.GLOW_LICHEN) ? CtftOverrideHelper.getMiningSpeedMultiplier(stack, state) : 2.0F;
        }
    }
}