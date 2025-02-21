package net.tonyearlnate.kitium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tonyearlnate.kitium.Kitium;
import net.tonyearlnate.kitium.block.ModBlocks;

public class ModItemGroups {
    public static ItemGroup KITIUM_ITEMS_GROUP;

    public static ItemGroup KITIUM_BLOCKS_GROUP;

    public static void registerModItemGroups() {
        Kitium.LOGGER.info("Registering Item Groups for " + Kitium.MOD_ID);

        KITIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(Kitium.MOD_ID, "kitium_items"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_KITIUM))
                        .displayName(Text.translatable("itemgroup.kitium.kitium_items"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.PINK_KITIUM);
                            entries.add(ModItems.BLUE_KITIUM);
                            entries.add(ModItems.ENERGIZED_KITIUM);
                            entries.add(ModItems.PINK_KITIUM_PANEL);
                            entries.add(ModItems.BLUE_KITIUM_PANEL);
                            entries.add(ModItems.ENERGIZED_KITIUM_PANEL);
                            entries.add(ModItems.RAW_PINK_KITIUM);
                            entries.add(ModItems.RAW_BLUE_KITIUM);
                            entries.add(ModItems.PINK_KITIUM_APPLE);
                            entries.add(ModItems.BLUE_KITIUM_APPLE);
                            entries.add(ModItems.THUNDERSTORM_SPAWNER);
                            entries.add(ModItems.PINK_KITIUM_SWORD);
                            entries.add(ModItems.PINK_KITIUM_PICKAXE);
                            entries.add(ModItems.PINK_KITIUM_AXE);
                            entries.add(ModItems.PINK_KITIUM_SHOVEL);
                            entries.add(ModItems.PINK_KITIUM_HOE);
                            entries.add(ModItems.PINK_KITIUM_HELMET);
                            entries.add(ModItems.PINK_KITIUM_CHESTPLATE);
                            entries.add(ModItems.PINK_KITIUM_LEGGINGS);
                            entries.add(ModItems.PINK_KITIUM_BOOTS);
                            entries.add(ModItems.BLUE_KITIUM_SWORD);
                            entries.add(ModItems.BLUE_KITIUM_PICKAXE);
                            entries.add(ModItems.BLUE_KITIUM_AXE);
                            entries.add(ModItems.BLUE_KITIUM_SHOVEL);
                            entries.add(ModItems.BLUE_KITIUM_HOE);
                            entries.add(ModItems.BLUE_KITIUM_HELMET);
                            entries.add(ModItems.BLUE_KITIUM_CHESTPLATE);
                            entries.add(ModItems.BLUE_KITIUM_LEGGINGS);
                            entries.add(ModItems.BLUE_KITIUM_BOOTS);
                            entries.add(ModItems.ENERGIZED_KITIUM_SWORD);
                            entries.add(ModItems.ENERGIZED_KITIUM_PICKAXE);
                            entries.add(ModItems.ENERGIZED_KITIUM_AXE);
                            entries.add(ModItems.ENERGIZED_KITIUM_SHOVEL);
                            entries.add(ModItems.ENERGIZED_KITIUM_HOE);
                            entries.add(ModItems.ENERGIZED_KITIUM_HELMET);
                            entries.add(ModItems.ENERGIZED_KITIUM_CHESTPLATE);
                            entries.add(ModItems.ENERGIZED_KITIUM_LEGGINGS);
                            entries.add(ModItems.ENERGIZED_KITIUM_BOOTS);
                            entries.add(ModItems.ENERGIZED_KITIUM_SWORD_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_PICKAXE_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_AXE_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_SHOVEL_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_HOE_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_HELMET_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_CHESTPLATE_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_LEGGINGS_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_BOOTS_FRAME);
                            entries.add(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE);
                            entries.add(ModThrowables.LIGHTNING_BOTTLE);
                            entries.add(ModItems.ENERGIZED_MACE);
                            entries.add(ModItems.ENERGIZED_MACE_HUSK);
                        }).build());

        KITIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(Kitium.MOD_ID, "kitium_blocks"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_KITIUM_BLOCK))
                        .displayName(Text.translatable("itemgroup.kitium.kitium_blocks"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.PINK_KITIUM_BLOCK);
                            entries.add(ModBlocks.BLUE_KITIUM_BLOCK);
                            entries.add(ModBlocks.ENERGIZED_KITIUM_BLOCK);
                            entries.add(ModBlocks.WHITE_KITIUM_BLOCK);
                            entries.add(ModBlocks.PINK_KITIUM_PANELING);
                            entries.add(ModBlocks.BLUE_KITIUM_PANELING);
                            entries.add(ModBlocks.ENERGIZED_KITIUM_PANELING);
                            entries.add(ModBlocks.PINK_KITIUM_ORE);
                            entries.add(ModBlocks.BLUE_KITIUM_ORE);
                            entries.add(ModBlocks.DEEPSLATE_PINK_KITIUM_ORE);
                            entries.add(ModBlocks.RAW_PINK_KITIUM_BLOCK);
                            entries.add(ModBlocks.RAW_BLUE_KITIUM_BLOCK);
                            entries.add(ModBlocks.LIGHTNING_COLLECTOR);
                        }).build());
    }
}