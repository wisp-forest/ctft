package com.chyzman.ctft.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collection;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class CtftCommandHandler {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(literal("set")
                .requires(source -> source.hasPermissionLevel(1))
                .then(
                        argument("targets", EntityArgumentType.players())
                                .then(argument("item", StringArgumentType.string())
                                        .suggests((serverCommandSourceCommandContext, suggestionsBuilder) -> {
                                            Registry.ITEM
                                                    .getIds()
                                                    .stream()
                                                    .filter(id -> id
                                                            .getNamespace()
                                                            .equals("minecraft"))
                                                    .map(Identifier::getPath)
                                                    .forEach(suggestionsBuilder::suggest);
                                            return suggestionsBuilder.buildFuture();
                                        }).executes(context -> execute(
                                                EntityArgumentType.getPlayers(context, "targets"),
                                                StringArgumentType.getString(context, "item"))
                                        )
                                )
                )
        );
    }

    private static int execute(Collection<ServerPlayerEntity> targets, String item) {
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_sword"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pickaxe"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_axe"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shovel"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_hoe"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_helmet"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_chestplate"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_leggings"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_boots"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shield"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_bow"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_crossbow"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shears"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fishing_rod"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_clock"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compass"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_horse_armor"))));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_block")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_stairs")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_slab")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_layer")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_glass")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pane")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_glass_pane")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_wall")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fence")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_lever")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_button")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pressure_plate")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fence_gate")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_end_rod")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_door")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_trapdoor")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_ladder")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_sign")), 16));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_torch")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_lantern")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_chain")), 64));

            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed1")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed2")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed3")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed4")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed5")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed6")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed7")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed8")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed9")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed10")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed11")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed12")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed13")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed14")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compressed15")), 64));
            serverPlayerEntity.getInventory().offerOrDrop(new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_kcolb")), 64));

        }
        return 0;
    }
}
