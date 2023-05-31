package com.chyzman.ctft;

import com.chyzman.ctft.command.CtftItemCommand;
import com.chyzman.ctft.registries.CtftRecipeSerializers;
import com.chyzman.ctft.registries.CtftRegistry;
import com.chyzman.ctft.registries.CtftStats;
import com.chyzman.ctft.registries.ServerEventListeners;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;

import static com.chyzman.ctft.util.CtftRegistryHelper.id;

public class Ctft implements ModInitializer {
    public static final String MODID = "ctft";

    public static final OwoItemGroup CTFT_GROUP = OwoItemGroup.builder(id("ctft_group"), () -> Icon.of(CtftRegistry.CTFT_SWORD))
            .initializer(group -> {
                group.addCustomTab(Icon.of(CtftRegistry.CTFT_SWORD), "ctft_swords", (context, entries) -> {
                    Registries.ITEM.forEach(item -> {
                        ItemStack stack = new ItemStack(CtftRegistry.CTFT_SWORD);
                        stack.getOrCreateNbt().putString("material", Registries.ITEM.getId(item).toString());
                        entries.add(stack);
                    });
                }, false);
                group.addCustomTab(Icon.of(CtftRegistry.CTFT_PICKAXE), "ctft_pickaxes", (context, entries) -> {
                    Registries.ITEM.forEach(item -> {
                        ItemStack stack = new ItemStack(CtftRegistry.CTFT_PICKAXE);
                        stack.getOrCreateNbt().putString("material", Registries.ITEM.getId(item).toString());
                        entries.add(stack);
                    });
                }, false);
                group.addCustomTab(Icon.of(CtftRegistry.CTFT_AXE), "ctft_axes", (context, entries) -> {
                    Registries.ITEM.forEach(item -> {
                        ItemStack stack = new ItemStack(CtftRegistry.CTFT_AXE);
                        stack.getOrCreateNbt().putString("material", Registries.ITEM.getId(item).toString());
                        entries.add(stack);
                    });
                }, false);
                group.addCustomTab(Icon.of(CtftRegistry.CTFT_SHOVEL), "ctft_shovels", (context, entries) -> {
                    Registries.ITEM.forEach(item -> {
                        ItemStack stack = new ItemStack(CtftRegistry.CTFT_SHOVEL);
                        stack.getOrCreateNbt().putString("material", Registries.ITEM.getId(item).toString());
                        entries.add(stack);
                    });
                }, false);
                group.addCustomTab(Icon.of(CtftRegistry.CTFT_HOE), "ctft_hoes", (context, entries) -> {
                    Registries.ITEM.forEach(item -> {
                        ItemStack stack = new ItemStack(CtftRegistry.CTFT_HOE);
                        stack.getOrCreateNbt().putString("material", Registries.ITEM.getId(item).toString());
                        entries.add(stack);
                    });
                }, false);
                group.hasScrollbar();
                group.addButton(ItemGroupButton.github(group,"https://github.com/chyzman"));
                group.addButton(ItemGroupButton.curseforge(group,"https://www.curseforge.com/members/chyzman5253/projects"));
                group.addButton(ItemGroupButton.modrinth(group,"https://modrinth.com/user/chyzman"));
            })
            .tabStackHeight(5)
            .build();

    @Override
    public void onInitialize() {
        CtftRegistry.Init();
        CtftRecipeSerializers.Init();
        CtftStats.Init();
        ServerEventListeners.init();
        CTFT_GROUP.initialize();
        CtftItemCommand.register();
    }
}