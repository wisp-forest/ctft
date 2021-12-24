package com.chyzman.ctft.classes;

import io.wispforest.owo.ops.WorldOps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.WorkStationCompetitionTask;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.Tag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class ChyzbladeItem extends MiningToolItem {
    public ChyzbladeItem(float attackDamage, float attackSpeed, ToolMaterial material, Tag<Block> effectiveBlocks, Settings settings) {
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
        return super.useOnBlock(context);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker.getUuid().equals(UUID.fromString("09de8a6d-86bf-4c15-bb93-ce3384ce4e96"))) {
            target.kill();
        }
        else {
            attacker.kill();
        }
        return super.postHit(stack, target, attacker);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new LiteralText("Only The Worthy May Wield the Power Of True Chyz"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
