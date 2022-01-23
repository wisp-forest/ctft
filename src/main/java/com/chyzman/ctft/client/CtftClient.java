package com.chyzman.ctft.client;

import com.chyzman.ctft.classes.*;
import com.chyzman.ctft.mixin.WorldRendererInvoker;
import com.chyzman.ctft.util.CtftAoeDig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class CtftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WorldRenderEvents.BLOCK_OUTLINE.register((worldRenderContext, blockOutlineContext) -> {
            final MinecraftClient client = MinecraftClient.getInstance();
            if (!CtftAoeDig.canAoeDig(client.player)) {
                return true;
            }

            BlockState blockState;
            for (BlockPos pos : CtftAoeDig.getBlocksToDig(client.player)) {
                blockState = client.world.getBlockState(pos);
                if (!blockState.isAir()) {
                    WorldRendererInvoker.ctft_drawShapeOutline(worldRenderContext.matrixStack(), worldRenderContext.consumers().getBuffer(RenderLayer.getLines()), blockState.getOutlineShape(client.world, pos, ShapeContext.of(blockOutlineContext.entity())), (double) pos.getX() - blockOutlineContext.cameraX(), (double) pos.getY() - blockOutlineContext.cameraY(), (double) pos.getZ() - blockOutlineContext.cameraZ(), 0.0F, 0.0F, 0.0F, 0.4F);
                }
            }
            return true;
        });
        Registry.ITEM.forEach(item -> {
            if(item instanceof CustomBowItem customBowItem) {
                FabricModelPredicateProviderRegistry.register(customBowItem, new Identifier("pull"), (stack, world, entity, seed) -> {if (entity == null) {return 0.0f;}if (entity.getActiveItem() != stack) {return 0.0f;}return (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;});
                FabricModelPredicateProviderRegistry.register(customBowItem, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);
            }
            if(item instanceof CustomClockItem customClockItem) {
                FabricModelPredicateProviderRegistry.register(customClockItem, new Identifier("time"), new ClockPredicate());
            }
            if(item instanceof CustomCompassItem customCompassItem) {
                FabricModelPredicateProviderRegistry.register(customCompassItem, new Identifier("angle"), new CompassPredicate());
            }
            if(item instanceof CustomCrossbowItem customCrossbowItem) {
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("pull"), (stack, world, entity, seed) -> {if (entity == null) {return 0.0f;} if (CustomCrossbowItem.isCharged(stack)) {return 0.0f;} return (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float) CustomCrossbowItem.getPullTime(stack);});
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !CustomCrossbowItem.isCharged(stack) ? 1.0f : 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("charged"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) ? 1.0f: 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("firework"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) && CustomCrossbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0f: 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("trident"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) && CustomCrossbowItem.hasProjectile(stack, Items.TRIDENT) ? 1.0f: 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("snowball"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) && CustomCrossbowItem.hasProjectile(stack, Items.SNOWBALL) ? 1.0f: 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("egg"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) && CustomCrossbowItem.hasProjectile(stack, Items.EGG) ? 1.0f: 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("ender_pearl"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) && CustomCrossbowItem.hasProjectile(stack, Items.ENDER_PEARL) ? 1.0f: 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("fire_charge"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) && CustomCrossbowItem.hasProjectile(stack, Items.FIRE_CHARGE) ? 1.0f: 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("experience_bottle"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) && CustomCrossbowItem.hasProjectile(stack, Items.EXPERIENCE_BOTTLE) ? 1.0f: 0.0f);
                FabricModelPredicateProviderRegistry.register(customCrossbowItem, new Identifier("potion"), (stack, world, entity, seed) -> entity != null && CustomCrossbowItem.isCharged(stack) && (CustomCrossbowItem.hasProjectile(stack, Items.LINGERING_POTION) || CustomCrossbowItem.hasProjectile(stack, Items.SPLASH_POTION)) ? 1.0f: 0.0f);
            }
            if(item instanceof CustomShieldItem customShieldItem) {
                FabricModelPredicateProviderRegistry.register(customShieldItem, new Identifier("blocking"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);
            }
            if(item instanceof CustomFishingRodItem customFishingRodItem) {
                FabricModelPredicateProviderRegistry.register(customFishingRodItem, new Identifier("cast"), (stack, world, entity, seed) -> { boolean bl2; if (entity == null) { return 0.0f; } boolean bl = entity.getMainHandStack() == stack; boolean bl3 = bl2 = entity.getOffHandStack() == stack; if (entity.getMainHandStack().getItem() instanceof FishingRodItem) { bl2 = false; } return (bl || bl2) && entity instanceof PlayerEntity && ((PlayerEntity)entity).fishHook != null ? 1.0f : 0.0f; });
            }
        });
        Registry.BLOCK.forEach(block -> {
            if (Registry.BLOCK.getId(block).getNamespace().equals("ctft")) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
            }
        });
    }
}