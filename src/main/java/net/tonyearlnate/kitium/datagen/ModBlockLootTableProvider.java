package net.tonyearlnate.kitium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import net.tonyearlnate.kitium.LootTables.ModLootTables;
import net.tonyearlnate.kitium.block.ModBlocks;
import net.tonyearlnate.kitium.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLUE_KITIUM_BLOCK);
        addDrop(ModBlocks.PINK_KITIUM_BLOCK);
        addDrop(ModBlocks.ENERGIZED_KITIUM_BLOCK);
        addDrop(ModBlocks.WHITE_KITIUM_BLOCK);
        addDrop(ModBlocks.RAW_BLUE_KITIUM_BLOCK);
        addDrop(ModBlocks.RAW_PINK_KITIUM_BLOCK);
        addDrop(ModBlocks.LIGHTNING_COLLECTOR);
        addDrop(ModBlocks.BLUE_KITIUM_PANELING);
        addDrop(ModBlocks.PINK_KITIUM_PANELING);
        addDrop(ModBlocks.ENERGIZED_KITIUM_PANELING);

        addDrop(ModBlocks.PINK_KITIUM_ORE, oreDrops(ModBlocks.PINK_KITIUM_ORE, ModItems.RAW_PINK_KITIUM));
        addDrop(ModBlocks.DEEPSLATE_PINK_KITIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_PINK_KITIUM_ORE, ModItems.RAW_PINK_KITIUM));
        addDrop(ModBlocks.BLUE_KITIUM_ORE, oreDrops(ModBlocks.BLUE_KITIUM_ORE, ModItems.RAW_BLUE_KITIUM));

    }
}
