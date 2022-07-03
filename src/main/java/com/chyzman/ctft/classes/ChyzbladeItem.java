package com.chyzman.ctft.classes;

import io.wispforest.owo.ops.WorldOps;
import blue.endless.jankson.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.List;

public class ChyzbladeItem extends MiningToolItem {
    public ChyzbladeItem(float attackDamage, float attackSpeed, ToolMaterial material, TagKey effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
    }
    @Override
    public boolean isDamageable() {
        return false;
    }
    @Override
    public boolean isSuitableFor(BlockState state) {
        return true;
    }
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return Float.POSITIVE_INFINITY;
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        WorldOps.breakBlockWithItem(context.getWorld(), context.getBlockPos(), context.getStack());
        return ActionResult.SUCCESS;
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.postHit(stack, target, attacker);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Only The Worthy May Wield the Power Of True Chyz"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return true;
    }

    @Override
    public boolean isFireproof() {
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        entity.remove(Entity.RemovalReason.KILLED);
        return ActionResult.SUCCESS;
    }
}
