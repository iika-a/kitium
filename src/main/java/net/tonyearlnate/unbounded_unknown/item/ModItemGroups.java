package net.tonyearlnate.unbounded_unknown.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.tonyearlnate.unbounded_unknown.block.ModBlocks;

public class ModItemGroups {
    public static ItemGroup KITIUM_ITEMS_GROUP;

    public static ItemGroup KITIUM_BLOCKS_GROUP;

    public static void registerModItemGroups() {
        UnboundedUnknown.LOGGER.info("Registering Item Groups for " + UnboundedUnknown.MOD_ID);

        KITIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(UnboundedUnknown.MOD_ID, "kitium_items"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_KITIUM))
                        .displayName(Text.translatable("itemgroup.unbounded_unknown.kitium_items"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.PINK_KITIUM);
                            entries.add(ModItems.BLUE_KITIUM);
                            entries.add(ModItems.ENERGIZED_KITIUM);
                            entries.add(ModItems.RAW_PINK_KITIUM);
                            entries.add(ModItems.RAW_BLUE_KITIUM);
                            entries.add(ModItems.THUNDERSTORM_SPAWNER);
                        }).build());

        KITIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(UnboundedUnknown.MOD_ID, "kitium_blocks"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_KITIUM_BLOCK))
                        .displayName(Text.translatable("itemgroup.unbounded_unknown.kitium_blocks"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.PINK_KITIUM_BLOCK);
                            entries.add(ModBlocks.BLUE_KITIUM_BLOCK);
                            entries.add(ModBlocks.ENERGIZED_KITIUM_BLOCK);
                            entries.add(ModBlocks.PINK_KITIUM_ORE);
                            entries.add(ModBlocks.BLUE_KITIUM_ORE);
                            entries.add(ModBlocks.DEEPSLATE_PINK_KITIUM_ORE);
                            entries.add(ModBlocks.RAW_PINK_KITIUM_BLOCK);
                            entries.add(ModBlocks.RAW_BLUE_KITIUM_BLOCK);
                            entries.add(ModBlocks.LIGHTNING_COLLECTOR);
                        }).build());
    }
}
