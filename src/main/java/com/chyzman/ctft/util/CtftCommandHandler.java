package com.chyzman.ctft.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collection;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class CtftCommandHandler {

    private static final SuggestionProvider<ServerCommandSource> MINECRAFT_ITEMS = (serverCommandSourceCommandContext, suggestionsBuilder) -> {
        Registry.ITEM
                .getIds()
                .stream()
                .filter(id -> id.getNamespace().equals("minecraft"))
                .map(Identifier::getPath)
                .forEach(suggestionsBuilder::suggest);
        return suggestionsBuilder.buildFuture();
    };

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(literal("set")
                .requires(source -> source.hasPermissionLevel(1))
                .then(argument("targets", EntityArgumentType.players())
                        .then(argument("item", StringArgumentType.string())
                                .suggests(MINECRAFT_ITEMS).executes(context -> execute(
                                        EntityArgumentType.getPlayers(context, "targets"),
                                        StringArgumentType.getString(context, "item"))))));
    }

    private static int execute(Collection<ServerPlayerEntity> targets, String item) {
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            serverPlayerEntity.getInventory().setStack(0, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_sword"))));
            serverPlayerEntity.getInventory().setStack(1, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pickaxe"))));
            serverPlayerEntity.getInventory().setStack(2, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_axe"))));
            serverPlayerEntity.getInventory().setStack(3, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shovel"))));
            serverPlayerEntity.getInventory().setStack(4, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_hoe"))));
            serverPlayerEntity.getInventory().armor.set(3, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_helmet"))));
            serverPlayerEntity.getInventory().armor.set(2, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_chestplate"))));
            serverPlayerEntity.getInventory().armor.set(1, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_leggings"))));
            serverPlayerEntity.getInventory().armor.set(0, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_boots"))));
            serverPlayerEntity.getInventory().offHand.set(0, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shield"))));
            serverPlayerEntity.getInventory().setStack(5, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_bow"))));
            serverPlayerEntity.getInventory().setStack(6, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_crossbow"))));
            serverPlayerEntity.getInventory().setStack(7, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shears"))));
            serverPlayerEntity.getInventory().setStack(8, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fishing_rod"))));
            serverPlayerEntity.getInventory().setStack(9, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_clock"))));
            serverPlayerEntity.getInventory().setStack(10, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compass"))));
            serverPlayerEntity.getInventory().setStack(11, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_horse_armor"))));
            serverPlayerEntity.getInventory().setStack(12, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_block")), 64));
            serverPlayerEntity.getInventory().setStack(13, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_stairs")), 64));
            serverPlayerEntity.getInventory().setStack(14, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_slab")), 64));
            serverPlayerEntity.getInventory().setStack(15, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_layer")), 64));
            serverPlayerEntity.getInventory().setStack(16, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_glass")), 64));
            serverPlayerEntity.getInventory().setStack(17, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pane")), 64));
            serverPlayerEntity.getInventory().setStack(18, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_glass_pane")), 64));
            serverPlayerEntity.getInventory().setStack(19, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_wall")), 64));
            serverPlayerEntity.getInventory().setStack(20, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fence")), 64));
            serverPlayerEntity.getInventory().setStack(21, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_lever")), 64));
            serverPlayerEntity.getInventory().setStack(22, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_button")), 64));
            serverPlayerEntity.getInventory().setStack(23, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pressure_plate")), 64));
            serverPlayerEntity.getInventory().setStack(24, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fence_gate")), 64));
            serverPlayerEntity.getInventory().setStack(25, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_end_rod")), 64));
            serverPlayerEntity.getInventory().setStack(26, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_door")), 64));
            serverPlayerEntity.getInventory().setStack(27, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_trapdoor")), 64));
            serverPlayerEntity.getInventory().setStack(28, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_ladder")), 64));
            serverPlayerEntity.getInventory().setStack(29, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_sign")), 64));
            serverPlayerEntity.getInventory().setStack(30, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_torch")), 64));
            serverPlayerEntity.getInventory().setStack(31, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_lantern")), 64));
            serverPlayerEntity.getInventory().setStack(32, new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_chain")), 64));
        }
        return 0;
    }
}
