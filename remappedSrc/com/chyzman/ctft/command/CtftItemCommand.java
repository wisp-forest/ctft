package com.chyzman.ctft.command;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.*;
import net.minecraft.command.suggestion.SuggestionProviders;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.nbt.visitor.StringNbtWriter;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.State;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
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
                                                    .then(CommandManager.literal("item")
                                                            .then(
                                                                    CommandManager.argument(
                                                                                    "material",
                                                                                    ItemStackArgumentType.itemStack(registryAccess)
                                                                            )
                                                                            .executes(
                                                                                    context -> executeItem(
                                                                                            context.getSource(),
                                                                                            EntityArgumentType.getPlayers(context, "targets"),
                                                                                            ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                            ItemStackArgumentType.getItemStackArgument(context, "material")
                                                                                    )
                                                                            )

                                                            )
                                                            .then(CommandManager.literal("random")
                                                                    .executes(
                                                                            context -> executeSpecial(
                                                                                    context.getSource(),
                                                                                    EntityArgumentType.getPlayers(context, "targets"),
                                                                                    ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                    "item",
                                                                                    "random"
                                                                            )
                                                                    )
                                                            )
                                                    )
                                                    .then(CommandManager.literal("block")
                                                            .then(
                                                                    CommandManager.argument(
                                                                                    "material",
                                                                                    BlockStateArgumentType.blockState(registryAccess)
                                                                            )
                                                                            .executes(
                                                                                    context -> executeBlock(
                                                                                            context.getSource(),
                                                                                            EntityArgumentType.getPlayers(context, "targets"),
                                                                                            ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                            BlockStateArgumentType.getBlockState(context, "material")
                                                                                    )
                                                                            )

                                                            )
                                                            .then(CommandManager.literal("random")
                                                                    .executes(
                                                                            context -> executeSpecial(
                                                                                    context.getSource(),
                                                                                    EntityArgumentType.getPlayers(context, "targets"),
                                                                                    ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                    "block",
                                                                                    "random"
                                                                            )
                                                                    )
                                                            )
                                                    )
                                                    .then(CommandManager.literal("entity")
                                                            .then(
                                                                    CommandManager.argument(
                                                                                    "material",
                                                                                    RegistryEntryArgumentType.registryEntry(registryAccess, RegistryKeys.ENTITY_TYPE)
                                                                            )
                                                                            .suggests(SuggestionProviders.SUMMONABLE_ENTITIES)
                                                                            .executes(
                                                                                    context -> executeEntity(
                                                                                            context.getSource(),
                                                                                            EntityArgumentType.getPlayers(context, "targets"),
                                                                                            ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                            RegistryEntryArgumentType.getSummonableEntityType(context, "material"),
                                                                                            new NbtCompound()
                                                                                    )
                                                                            )
                                                                            .then(
                                                                                    CommandManager.argument("nbt", NbtCompoundArgumentType.nbtCompound())
                                                                                            .executes(
                                                                                                    context -> executeEntity(
                                                                                                            context.getSource(),
                                                                                                            EntityArgumentType.getPlayers(context, "targets"),
                                                                                                            ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                                            RegistryEntryArgumentType.getSummonableEntityType(context, "material"),
                                                                                                            NbtCompoundArgumentType.getNbtCompound(context, "nbt")
                                                                                                    )
                                                                                            )
                                                                            )
                                                            )
                                                            .then(CommandManager.literal("random")
                                                                    .executes(
                                                                            context -> executeSpecial(
                                                                                    context.getSource(),
                                                                                    EntityArgumentType.getPlayers(context, "targets"),
                                                                                    ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                    "entity",
                                                                                    "random"
                                                                            )
                                                                    )
                                                            )
                                                    )
                                                    .then(CommandManager.literal("particle")
                                                            .then(
                                                                    CommandManager.argument(
                                                                                    "material",
                                                                                    ParticleEffectArgumentType.particleEffect(registryAccess)
                                                                            )
                                                                            .executes(
                                                                                    context -> executeParticle(
                                                                                            context.getSource(),
                                                                                            EntityArgumentType.getPlayers(context, "targets"),
                                                                                            ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                                            ParticleEffectArgumentType.getParticle(context,"material")
                                                                                    )
                                                                            )
                                                            )
                                                    )
                                                    .then(CommandManager.literal("hand")
                                                            .executes(
                                                                    context -> executeHand(
                                                                            context.getSource(),
                                                                            EntityArgumentType.getPlayers(context, "targets"),
                                                                            ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                            context.getSource().getPlayerOrThrow().getStackInHand(Hand.MAIN_HAND).isEmpty() ? context.getSource().getPlayerOrThrow().getStackInHand(Hand.OFF_HAND) : context.getSource().getPlayerOrThrow().getStackInHand(Hand.MAIN_HAND)
                                                                    )
                                                            )

                                                    )
                                                    .then(CommandManager.literal("mainhand")
                                                            .executes(
                                                                    context -> executeHand(
                                                                            context.getSource(),
                                                                            EntityArgumentType.getPlayers(context, "targets"),
                                                                            ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                            context.getSource().getPlayerOrThrow().getStackInHand(Hand.MAIN_HAND)
                                                                    )
                                                            )

                                                    )
                                                    .then(CommandManager.literal("offhand")
                                                            .executes(
                                                                    context -> executeHand(
                                                                            context.getSource(),
                                                                            EntityArgumentType.getPlayers(context, "targets"),
                                                                            ItemStackArgumentType.getItemStackArgument(context, "item").getItem(),
                                                                            context.getSource().getPlayerOrThrow().getStackInHand(Hand.OFF_HAND)
                                                                    )
                                                            )

                                                    )
                                    )
                    )
                    .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2)));
        });
    }

    private static int executeItem(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Item item, ItemStackArgument material) throws CommandSyntaxException {
        var stack = new ItemStack(item);
        if (!Registries.ITEM.getId(item).getNamespace().equals(MODID)) {
            source.sendError(Text.translatable("commands.ctftitem.fail.wrong", stack.toHoverableText()));
            return 0;
        }
        var nbt = stack.getOrCreateNbt();
        nbt.putString("material", material.asString());
        nbt.putString("material_type", "item");
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            ItemEntity itemEntity = serverPlayerEntity.dropItem(stack, false);
            if (itemEntity != null) {
                itemEntity.resetPickupDelay();
                itemEntity.setOwner(serverPlayerEntity.getUuid());
            }
        }
        if (targets.size() == 1) {
            source.sendFeedback(() ->
                            Text.translatable(
                                    "commands.ctftitem.success.single",
                                    stack.toHoverableText(),
                                    targets.iterator().next().getDisplayName()
                            ),
                    true
            );
        } else {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.size()
                    ),
                    true
            );
        }
        return targets.size();
    }

    private static int executeBlock(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Item item, BlockStateArgument material) throws CommandSyntaxException {
        var stack = new ItemStack(item);
        if (!Registries.ITEM.getId(item).getNamespace().equals(MODID)) {
            source.sendError(Text.translatable("commands.ctftitem.fail.wrong", stack.toHoverableText()));
            return 0;
        }
        var nbt = stack.getOrCreateNbt();
        StringBuilder stringBuilder = new StringBuilder(Registries.BLOCK.getId(material.getBlockState().getBlock()).toString());
        if (!material.getBlockState().getEntries().isEmpty()) {
            stringBuilder.append('[');
            stringBuilder.append(material.getBlockState().getEntries().entrySet().stream().map(PROPERTY_MAP_PRINTER).collect(Collectors.joining(",")));
            stringBuilder.append(']');
        }
        nbt.putString("material", stringBuilder.toString());
        nbt.putString("material_type", "block");
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            ItemEntity itemEntity = serverPlayerEntity.dropItem(stack, false);
            if (itemEntity != null) {
                itemEntity.resetPickupDelay();
                itemEntity.setOwner(serverPlayerEntity.getUuid());
            }
        }
        if (targets.size() == 1) {
            source.sendFeedback(() ->
                            Text.translatable(
                                    "commands.ctftitem.success.single",
                                    stack.toHoverableText(),
                                    targets.iterator().next().getDisplayName()
                            ),
                    true
            );
        } else {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.size()
                    ),
                    true
            );
        }
        return targets.size();
    }

    private static int executeEntity(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Item item, RegistryEntry.Reference<EntityType<?>> material, NbtCompound entity_nbt) throws CommandSyntaxException {
        var stack = new ItemStack(item);
        if (!Registries.ITEM.getId(item).getNamespace().equals(MODID)) {
            source.sendError(Text.translatable("commands.ctftitem.fail.wrong", stack.toHoverableText()));
            return 0;
        }
        var nbt = stack.getOrCreateNbt();
        StringBuilder stringBuilder = new StringBuilder(Registries.ENTITY_TYPE.getId(material.value()).toString());
        if (!entity_nbt.isEmpty()) {
            stringBuilder.append(' ');
            stringBuilder.append(entity_nbt);
        }
        nbt.putString("material", stringBuilder.toString());
        nbt.putString("material_type", "entity");
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            ItemEntity itemEntity = serverPlayerEntity.dropItem(stack, false);
            if (itemEntity != null) {
                itemEntity.resetPickupDelay();
                itemEntity.setOwner(serverPlayerEntity.getUuid());
            }
        }
        if (targets.size() == 1) {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.iterator().next().getDisplayName()
                    ),
                    true
            );
        } else {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.size()
                    ),
                    true
            );
        }
        return targets.size();
    }

    private static int executeParticle(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Item item, ParticleEffect material) throws CommandSyntaxException {
        var stack = new ItemStack(item);
        if (!Registries.ITEM.getId(item).getNamespace().equals(MODID)) {
            source.sendError(Text.translatable("commands.ctftitem.fail.wrong", stack.toHoverableText()));
            return 0;
        }
        var nbt = stack.getOrCreateNbt();
        nbt.putString("material", material.asString());
        nbt.putString("material_type", "particle");
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            ItemEntity itemEntity = serverPlayerEntity.dropItem(stack, false);
            if (itemEntity != null) {
                itemEntity.resetPickupDelay();
                itemEntity.setOwner(serverPlayerEntity.getUuid());
            }
        }
        if (targets.size() == 1) {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.iterator().next().getDisplayName()
                    ),
                    true
            );
        } else {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.size()
                    ),
                    true
            );
        }
        return targets.size();
    }

    private static int executeHand(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Item item, ItemStack itemstack) throws CommandSyntaxException {
        var stack = new ItemStack(item);
        if (!Registries.ITEM.getId(item).getNamespace().equals(MODID)) {
            source.sendError(Text.translatable("commands.ctftitem.fail.wrong", stack.toHoverableText()));
            return 0;
        }
        var nbt = stack.getOrCreateNbt();
        StringBuilder builder = new StringBuilder(Registries.ITEM.getId(itemstack.getItem()).toString());
        if (itemstack.hasNbt()) {
            builder.append(itemstack.getNbt());
        }
        nbt.putString("material", builder.toString());
        nbt.putString("material_type", "item");
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            ItemEntity itemEntity = serverPlayerEntity.dropItem(stack, false);
            if (itemEntity != null) {
                itemEntity.resetPickupDelay();
                itemEntity.setOwner(serverPlayerEntity.getUuid());
            }
        }
        if (targets.size() == 1) {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.iterator().next().getDisplayName()
                    ),
                    true
            );
        } else {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.size()
                    ),
                    true
            );
        }
        return targets.size();
    }

    private static int executeSpecial(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Item item, String type, String material) throws CommandSyntaxException {
        var stack = new ItemStack(item);
        if (!Registries.ITEM.getId(item).getNamespace().equals(MODID)) {
            source.sendError(Text.translatable("commands.ctftitem.fail.wrong", stack.toHoverableText()));
            return 0;
        }
        var nbt = stack.getOrCreateNbt();
        nbt.putString("material", material);
        nbt.putString("material_type", type);
        for (ServerPlayerEntity serverPlayerEntity : targets) {
            ItemEntity itemEntity = serverPlayerEntity.dropItem(stack, false);
            if (itemEntity != null) {
                itemEntity.resetPickupDelay();
                itemEntity.setOwner(serverPlayerEntity.getUuid());
            }
        }
        if (targets.size() == 1) {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.iterator().next().getDisplayName()
                    ),
                    true
            );
        } else {
            source.sendFeedback(
                    () -> Text.translatable(
                            "commands.ctftitem.success.single",
                            stack.toHoverableText(),
                            targets.size()
                    ),
                    true
            );
        }
        return targets.size();
    }

    private static final Function<Map.Entry<Property<?>, Comparable<?>>, String> PROPERTY_MAP_PRINTER = new Function<Map.Entry<Property<?>, Comparable<?>>, String>() {
        public String apply(@Nullable Map.Entry<Property<?>, Comparable<?>> entry) {
            if (entry == null) {
                return "<NULL>";
            } else {
                Property<?> property = (Property) entry.getKey();
                return property.getName() + "=" + this.nameValue(property, (Comparable<?>) entry.getValue());
            }
        }

        private <T extends Comparable<T>> String nameValue(Property<T> property, Comparable<?> value) {
            return property.name((T) value);
        }
    };
}