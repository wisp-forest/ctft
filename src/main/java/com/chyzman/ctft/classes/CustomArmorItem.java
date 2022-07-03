package com.chyzman.ctft.classes;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CustomArmorItem extends ArmorItem {
    public boolean isfoil;
    public String texturetype;
    public CustomArmorItem(ArmorMaterial material, EquipmentSlot slot, boolean isFoil, String textureType, Settings settings) {
        super(material, slot, settings);
        isfoil = isFoil;
        texturetype = textureType;
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return isfoil || super.hasGlint(stack);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking() && this.isFood()) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (user.canConsume(this.getFoodComponent().isAlwaysEdible())) {
                user.setCurrentHand(hand);
                return TypedActionResult.consume(itemStack);
            } else {
                return TypedActionResult.fail(itemStack);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public Text getName(){
        var baseitemname = (Registry.ITEM.getId(this.asItem())).getPath();
        String baseitem = this.texturetype + ".minecraft." + baseitemname
                .substring(0, baseitemname
                        .lastIndexOf('_'));
        if(this.slot.equals(EquipmentSlot.HEAD)){
            return (Text.translatable("ctft.item.helmet_prefix")
                    .append(Text.translatable(baseitem))
                    .append(Text.translatable("ctft.item.helmet_suffix")));
        }
        else if(this.slot.equals(EquipmentSlot.CHEST)){
            return (Text.translatable("ctft.item.chestplate_prefix")
                    .append(Text.translatable(baseitem))
                    .append(Text.translatable("ctft.item.chestplate_suffix")));
        }
        else if(this.slot.equals(EquipmentSlot.LEGS)){
            return (Text.translatable("ctft.item.leggings_prefix")
                    .append(Text.translatable(baseitem))
                    .append(Text.translatable("ctft.item.leggings_suffix")));
        }
        else if(this.slot.equals(EquipmentSlot.FEET)){
            return (Text.translatable("ctft.item.boots_prefix")
                    .append(Text.translatable(baseitem))
                    .append(Text.translatable("ctft.item.boots_suffix")));
        }
        else {
            return Text.literal("how tf did u make an armor piece thats not a helmet, chestplate, leggings or boots?");
        }
    }
    @Override
    public Text getName(ItemStack stack) {
        return this.getName();
    }
}
