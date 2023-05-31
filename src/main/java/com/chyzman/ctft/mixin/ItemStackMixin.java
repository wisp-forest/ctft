package com.chyzman.ctft.mixin;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.chyzman.ctft.Ctft.MODID;
import static com.chyzman.ctft.registries.CtftStats.MATERIALS;
import static net.minecraft.util.JsonHelper.getItem;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    @Nullable
    public abstract NbtCompound getNbt();

    @Shadow
    public abstract Item getItem();

    @Inject(method = "getMaxDamage", at = @At("HEAD"), cancellable = true)
    public void noBurny(CallbackInfoReturnable<Integer> cir) {
        if (!Registries.ITEM.getId(getItem()).getNamespace().equals(MODID)) return;
        if (getNbt() != null && getNbt().getString("material") != null) {
            var id = Identifier.tryParse(getNbt().getString("material"));
            if (id == null) return;
            var material = MATERIALS.get(id);
            if (material == null) return;
            cir.setReturnValue(material.durability);
        }
    }

    @Inject(method = "hasGlint", at = @At("TAIL"), cancellable = true)
    public void shiny(CallbackInfoReturnable<Boolean> cir) {
        if (!Registries.ITEM.getId(getItem()).getNamespace().equals(MODID)) return;
        if (getNbt() != null && getNbt().getString("material") != null) {
            var id = Identifier.tryParse(getNbt().getString("material"));
            if (id == null) return;
            var material = MATERIALS.get(id);
            if (material == null) return;
            cir.setReturnValue(cir.getReturnValue() || material.foil || Registries.ITEM.get(id).hasGlint(new ItemStack(Registries.ITEM.get(id))));
        }
    }

    @Inject(method = "isSuitableFor", at = @At("HEAD"), cancellable = true)
    public void makeToolsMineStuffTheyShouldBeAbleToMine(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (!Registries.ITEM.getId(getItem()).getNamespace().equals(MODID)) return;
        if (!(getItem() instanceof MiningToolItem miningToolItem)) return;
        if (getNbt() != null && getNbt().getString("material") != null) {
            var id = Identifier.tryParse(getNbt().getString("material"));
            if (id == null) return;
            var material = MATERIALS.get(id);
            if (material == null) return;
            if (material.mining_tier < MiningLevels.DIAMOND && state.isIn(BlockTags.NEEDS_DIAMOND_TOOL)) {
                cir.setReturnValue(false);
            } else if (material.mining_tier < MiningLevels.IRON && state.isIn(BlockTags.NEEDS_IRON_TOOL)) {
                cir.setReturnValue(false);
            } else {
               cir.setReturnValue((material.mining_tier >= MiningLevels.STONE || !state.isIn(BlockTags.NEEDS_STONE_TOOL)) && state.isIn(miningToolItem.effectiveBlocks));
            }
        }
    }
}