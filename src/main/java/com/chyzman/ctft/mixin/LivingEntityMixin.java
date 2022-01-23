package com.chyzman.ctft.mixin;

import com.chyzman.ctft.Registries.AbilityTags;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    /*@Shadow public abstract Iterable<ItemStack> getArmorItems();

    @Shadow public abstract void endCombat();

    @Shadow private @Nullable DamageSource lastDamageSource;

    @Shadow public abstract void enterCombat();

    @Shadow protected abstract void drop(DamageSource source);

    @Inject(method = "tryUseTotem", at = @At(value = "HEAD", target = "Lnet/minecraft/entity/LivingEntity;tryUseTotem(Lnet/minecraft/entity/damage/DamageSource;)Z", ordinal = 0), cancellable = true)
    private void TotemArmor(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        if (AbilityTags.TOTEMARMOR.contains(((LivingEntity) (Object) this).getEquippedStack(EquipmentSlot.HEAD).getItem())) {
            for (ItemStack armorItem : ((LivingEntity) (Object) this).getArmorItems()) {
                if (AbilityTags.TOTEMARMOR.contains(armorItem.getItem())) {
                    if (((LivingEntity) (Object) this) instanceof ServerPlayerEntity serverPlayerEntity) {
                        serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(armorItem.getItem()));
                        Criteria.USED_TOTEM.trigger(serverPlayerEntity, armorItem);
                    }
                    ((LivingEntity) (Object) this).setHealth(1.0F);
                    ((LivingEntity) (Object) this).clearStatusEffects();
                    ((LivingEntity) (Object) this).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
                    ((LivingEntity) (Object) this).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));
                    ((LivingEntity) (Object) this).addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
                    ((LivingEntity) (Object) this).world.sendEntityStatus(((LivingEntity) (Object) this), (byte)35);
                    armorItem.damage(armorItem.getMaxDamage()/4, ((LivingEntity) (Object) this), p -> p.sendEquipmentBreakStatus(EquipmentSlot.HEAD));
                    break;
                }
            }
        }
    }

    @Inject(method = "onDeath", at = @At(value = "HEAD"), cancellable = true)
    private void TotemWeapon(DamageSource source, CallbackInfo ci) {
        Entity entity = source.getAttacker();
        assert this.lastDamageSource != null;
        assert entity != null;
        for (ItemStack itemStack : entity.getItemsHand()){
            if (AbilityTags.TOTEMWEAPON.contains(itemStack.getItem())) {
                if (((LivingEntity) (Object) this) instanceof ServerPlayerEntity serverPlayerEntity) {
                    serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
                    Criteria.USED_TOTEM.trigger(serverPlayerEntity, itemStack);
                }
                ((LivingEntity) (Object) this).setHealth(1.0F);
                ((LivingEntity) (Object) this).clearStatusEffects();
                ((LivingEntity) (Object) this).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
                ((LivingEntity) (Object) this).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));
                ((LivingEntity) (Object) this).addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
                ((LivingEntity) (Object) this).world.sendEntityStatus(((LivingEntity) (Object) this), (byte)35);
                if (((LivingEntity) (Object) this).world instanceof ServerWorld) {
                    this.drop(source);
                }
                ci.cancel();
            }
        }
    }

    @ModifyArg(method = "tryUseTotem", at = @At(value = "HEAD", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private Item totemitem(Item item) {
        if (AbilityTags.TOTEMITEM.contains(item))
            return Items.TOTEM_OF_UNDYING;
        else
            return item;
    }*/
}