package com.chyzman.ctft;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.world.level.Level;
import com.chyzman.ctft.init.ClockInit;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = Ctft.modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CtftClient
{
    @SubscribeEvent
    public static void setModelProperties(FMLClientSetupEvent event) {}
}