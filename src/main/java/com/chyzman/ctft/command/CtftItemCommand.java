package com.chyzman.ctft.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.stream.Stream;

import static com.chyzman.ctft.Ctft.MODID;

public class CtftItemCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("ctftitem")
                    .then(CommandManager.argument(
                                            "targets",
                                            EntityArgumentType.players()
                                    )
                                    .then(
                                            CommandManager.argument(
                                                            "item",
                                                            ItemStackArgumentType.itemStack(registryAccess)
                                                    )
                                                    .suggests((context, builder) -> CommandSource.suggestIdentifiers(
                                                            Registries.ITEM.stream().filter(item -> Registries.ITEM.getId(item).getNamespace().equals(MODID)).map(Registries.ITEM::getId),
                                                            builder
                                                    ))
                                                    .then(
                                                            CommandManager.argument(
                                                                            "material",
                                                                            StringArgumentType.greedyString()
                                                                    )
                                                                    .suggests((context, builder) -> CommandSource.suggestIdentifiers(
                                                                            Stream.concat(Stream.concat(Registries.ITEM.stream().map(Registries.ITEM::getId), Registries.ENTITY_TYPE.stream().map(Registries.ENTITY_TYPE::getId)), Stream.concat(Registries.BLOCK.stream().map(Registries.BLOCK::getId), Registries.PARTICLE_TYPE.stream().map(Registries.PARTICLE_TYPE::getId))),
                                                                                    builder
                                                                            )
                                                                    )
                                                                    .executes(
                                                                            context -> execute(
                                                                                    context.getSource(),
                                                                                    EntityArgumentType.getPlayers(context, "targets"),
                                                                                    ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                    StringArgumentType.getString(context, "material")
                                                                            )
                                                                    )

                                                    )
                                    )
                    )
                    .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2)));
        });
    }

    private static int execute(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Item item, String material) throws CommandSyntaxException {
        var stack = new ItemStack(item);
        if (!Registries.ITEM.getId(item).getNamespace().equals(MODID)) {
            source.sendError(Text.translatable("commands.ctftitem.fail.wrong",stack.toHoverableText()));
            return 1;
        }
        var nbt = stack.getOrCreateNbt();
        nbt.putString("material", material);
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            ItemEntity itemEntity = serverPlayerEntity.dropItem(stack, false);
            if (itemEntity != null) {
                itemEntity.resetPickupDelay();
                itemEntity.setOwner(serverPlayerEntity.getUuid());
            }
        }
        if (targets.size() == 1) {
            source.sendFeedback(
                    Text.translatable(
                            "commands.ctftitem.success.single",
                            Text.empty(),
                            stack.toHoverableText(),
                            targets.iterator().next().getDisplayName()
                    ),
                    true
            );
        } else {
            source.sendFeedback(
                    Text.translatable(
                            "commands.ctftitem.success.single",
                            Text.empty(),
                            stack.toHoverableText(),
                            targets.size()
                    ),
                    true
            );
        }
        return 0;
    }
}