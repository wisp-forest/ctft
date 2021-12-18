package com.chyzman.ctft.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class CtftCommandHandler {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(literal("set")
                .then(argument("item", StringArgumentType
                        .string())
                        .suggests((serverCommandSourceCommandContext, suggestionsBuilder) -> { Registry.ITEM
                                .getIds()
                                .stream()
                                .filter(id -> id
                                        .getNamespace()
                                        .equals("minecraft"))
                                .map(Identifier::getPath)
                                .forEach(suggestionsBuilder::suggest);
                            return suggestionsBuilder.buildFuture();
                        }).executes(context -> execute(context, StringArgumentType
                                .getString(context,"item"))
                        )
                )
        );
    }

    private static int execute(CommandContext<ServerCommandSource> context, String item) throws CommandSyntaxException {
        var sword = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_sword")));
        var pickaxe = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pickaxe")));
        var axe = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_axe")));
        var shovel = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shovel")));
        var hoe = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_hoe")));
        var helmet = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_helmet")));
        var chestplate = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_chestplate")));
        var leggings = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_leggings")));
        var boots = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_boots")));
        var shield = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shield")));
        var bow = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_bow")));
        var crossbow = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_crossbow")));
        var shears = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_shears")));
        var fishing_rod = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fishing_rod")));
        var clock = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_clock")));
        var compass = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_compass")));
        var horse_armor = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_horse_armor")));
        var block = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_block")),64);
        var stairs = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_stairs")),64);
        var slab = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_slab")),64);
        var layer = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_layer")),64);
        var glass = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_glass")),64);
        var pane = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pane")),64);
        var glass_pane = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_glass_pane")),64);
        var wall = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_wall")),64);
        var fence = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fence")),64);
        var lever = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_lever")),64);
        var button = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_button")),64);
        var pressure_plate = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_pressure_plate")),64);
        var fence_gate = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_fence_gate")),64);
        var end_rod = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_end_rod")),64);
        var door = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_door")),64);
        var trapdoor = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_trapdoor")),64);
        var ladder = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_ladder")),64);
        var sign = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_sign")),64);
        var torch = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_torch")),64);
        var lantern = new ItemStack(Registry.ITEM.get(new Identifier("ctft", item + "_lantern")),64);

        context.getSource().getPlayer().getInventory().setStack(0, sword);
        context.getSource().getPlayer().getInventory().setStack(1, pickaxe);
        context.getSource().getPlayer().getInventory().setStack(2, axe);
        context.getSource().getPlayer().getInventory().setStack(3, shovel);
        context.getSource().getPlayer().getInventory().setStack(4, hoe);
        context.getSource().getPlayer().getInventory().armor.set(3, helmet);
        context.getSource().getPlayer().getInventory().armor.set(2, chestplate);
        context.getSource().getPlayer().getInventory().armor.set(1, leggings);
        context.getSource().getPlayer().getInventory().armor.set(0, boots);
        context.getSource().getPlayer().getInventory().offHand.set(0, shield);
        context.getSource().getPlayer().getInventory().setStack(5, bow);
        context.getSource().getPlayer().getInventory().setStack(6, crossbow);
        context.getSource().getPlayer().getInventory().setStack(7, shears);
        context.getSource().getPlayer().getInventory().setStack(8, fishing_rod);
        context.getSource().getPlayer().getInventory().setStack(9, clock);
        context.getSource().getPlayer().getInventory().setStack(10, compass);
        context.getSource().getPlayer().getInventory().setStack(11, horse_armor);
        context.getSource().getPlayer().getInventory().setStack(12, block);
        context.getSource().getPlayer().getInventory().setStack(13, stairs);
        context.getSource().getPlayer().getInventory().setStack(14, slab);
        context.getSource().getPlayer().getInventory().setStack(15, layer);
        context.getSource().getPlayer().getInventory().setStack(16, glass);
        context.getSource().getPlayer().getInventory().setStack(17, pane);
        context.getSource().getPlayer().getInventory().setStack(18, glass_pane);
        context.getSource().getPlayer().getInventory().setStack(19, wall);
        context.getSource().getPlayer().getInventory().setStack(20, fence);
        context.getSource().getPlayer().getInventory().setStack(21, lever);
        context.getSource().getPlayer().getInventory().setStack(22, button);
        context.getSource().getPlayer().getInventory().setStack(23, pressure_plate);
        context.getSource().getPlayer().getInventory().setStack(24, fence_gate);
        context.getSource().getPlayer().getInventory().setStack(25, end_rod);
        context.getSource().getPlayer().getInventory().setStack(26, door);
        context.getSource().getPlayer().getInventory().setStack(27, trapdoor);
        context.getSource().getPlayer().getInventory().setStack(28, ladder);
        context.getSource().getPlayer().getInventory().setStack(29, sign);
        context.getSource().getPlayer().getInventory().setStack(30, torch);
        context.getSource().getPlayer().getInventory().setStack(31, lantern);
        return 0;
    }
}
