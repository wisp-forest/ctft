package com.chyzman.ctft.client;

import com.chyzman.ctft.registries.CtftRegistry;
import com.chyzman.ctft.renderer.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.Tessellator;

import static com.chyzman.ctft.util.CtftRegistryHelper.id;

public class CtftClient implements ClientModInitializer {
    public static final Tessellator CTFTESSELLATOR = new Tessellator();
    public static int recursions = 0;
    @Override
    public void onInitializeClient() {
        BuiltinItemRendererRegistry.INSTANCE.register(CtftRegistry.CTFT_SWORD, new CtftSwordItemRenderer(id("item/base/sword_base")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(id("item/base/sword_base")));
        BuiltinItemRendererRegistry.INSTANCE.register(CtftRegistry.CTFT_PICKAXE, new CtftPickaxeItemRenderer(id("item/base/pickaxe_base")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(id("item/base/pickaxe_base")));
        BuiltinItemRendererRegistry.INSTANCE.register(CtftRegistry.CTFT_AXE, new CtftAxeItemRenderer(id("item/base/axe_base")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(id("item/base/axe_base")));
        BuiltinItemRendererRegistry.INSTANCE.register(CtftRegistry.CTFT_SHOVEL, new CtftShovelItemRenderer(id("item/base/shovel_base")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(id("item/base/shovel_base")));
        BuiltinItemRendererRegistry.INSTANCE.register(CtftRegistry.CTFT_HOE, new CtftHoeItemRenderer(id("item/base/hoe_base")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(id("item/base/hoe_base")));
        BuiltinItemRendererRegistry.INSTANCE.register(CtftRegistry.CTFT_SHEARS, new CtftShearsItemRenderer(id("item/base/shears_base")));
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(id("item/base/shears_base")));
    }
}