package com.chyzman.ctft.client;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import com.chyzman.ctft.classes.ClockPredicate;
import com.chyzman.ctft.classes.CompassPredicate;
import com.chyzman.ctft.init.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CtftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

    }
}