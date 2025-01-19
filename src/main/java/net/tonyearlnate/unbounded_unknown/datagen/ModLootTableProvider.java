package net.tonyearlnate.unbounded_unknown.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.tonyearlnate.unbounded_unknown.block.ModBlocks;
import net.tonyearlnate.unbounded_unknown.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLUE_KITIUM_BLOCK);
        addDrop(ModBlocks.PINK_KITIUM_BLOCK);
        addDrop(ModBlocks.ENERGIZED_KITIUM_BLOCK);
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
