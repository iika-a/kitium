package net.tonyearlnate.unbounded_unknown.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.tonyearlnate.unbounded_unknown.item.ModItems;
import net.tonyearlnate.unbounded_unknown.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.PINK_KITIUM_REPAIR)
                .add(ModItems.PINK_KITIUM);

        getOrCreateTagBuilder(ModTags.Items.BLUE_KITIUM_REPAIR)
                .add(ModItems.BLUE_KITIUM);

        getOrCreateTagBuilder(ModTags.Items.ENERGIZED_KITIUM_REPAIR)
                .add(ModItems.ENERGIZED_KITIUM);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.PINK_KITIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.PINK_KITIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.PINK_KITIUM_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.PINK_KITIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.PINK_KITIUM_HOE);
    }
}
