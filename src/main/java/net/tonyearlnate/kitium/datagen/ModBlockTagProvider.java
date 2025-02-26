package net.tonyearlnate.kitium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.tonyearlnate.kitium.block.ModBlocks;
import net.tonyearlnate.kitium.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLUE_KITIUM_BLOCK)
                .add(ModBlocks.PINK_KITIUM_BLOCK)
                .add(ModBlocks.ENERGIZED_KITIUM_BLOCK)
                .add(ModBlocks.RAW_PINK_KITIUM_BLOCK)
                .add(ModBlocks.RAW_BLUE_KITIUM_BLOCK)
                .add(ModBlocks.BLUE_KITIUM_PANELING)
                .add(ModBlocks.PINK_KITIUM_PANELING)
                .add(ModBlocks.ENERGIZED_KITIUM_PANELING)
                .add(ModBlocks.BLUE_KITIUM_ORE)
                .add(ModBlocks.PINK_KITIUM_ORE)
                .add(ModBlocks.DEEPSLATE_PINK_KITIUM_ORE)
                .add(ModBlocks.LIGHTNING_COLLECTOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLUE_KITIUM_BLOCK)
                .add(ModBlocks.PINK_KITIUM_BLOCK)
                .add(ModBlocks.ENERGIZED_KITIUM_BLOCK)
                .add(ModBlocks.RAW_PINK_KITIUM_BLOCK)
                .add(ModBlocks.RAW_BLUE_KITIUM_BLOCK)
                .add(ModBlocks.BLUE_KITIUM_PANELING)
                .add(ModBlocks.PINK_KITIUM_PANELING)
                .add(ModBlocks.ENERGIZED_KITIUM_PANELING)
                .add(ModBlocks.BLUE_KITIUM_ORE)
                .add(ModBlocks.PINK_KITIUM_ORE)
                .add(ModBlocks.DEEPSLATE_PINK_KITIUM_ORE)
                .add(ModBlocks.LIGHTNING_COLLECTOR);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PINK_KITIUM_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_BLUE_KITIUM_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ENERGIZED_KITIUM_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.PINK_KITIUM_BLOCK)
                .add(ModBlocks.BLUE_KITIUM_BLOCK)
                .add(ModBlocks.ENERGIZED_KITIUM_BLOCK)
                .add(ModBlocks.WHITE_KITIUM_BLOCK);
    }
}
