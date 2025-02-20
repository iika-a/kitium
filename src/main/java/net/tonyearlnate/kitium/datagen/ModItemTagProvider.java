package net.tonyearlnate.kitium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.tonyearlnate.kitium.item.ModItems;
import net.tonyearlnate.kitium.util.ModTags;

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

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BLUE_KITIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BLUE_KITIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BLUE_KITIUM_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BLUE_KITIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BLUE_KITIUM_HOE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ENERGIZED_KITIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ENERGIZED_KITIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ENERGIZED_KITIUM_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ENERGIZED_KITIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ENERGIZED_KITIUM_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PINK_KITIUM_HELMET)
                .add(ModItems.PINK_KITIUM_CHESTPLATE)
                .add(ModItems.PINK_KITIUM_LEGGINGS)
                .add(ModItems.PINK_KITIUM_BOOTS)
                .add(ModItems.BLUE_KITIUM_HELMET)
                .add(ModItems.BLUE_KITIUM_CHESTPLATE)
                .add(ModItems.BLUE_KITIUM_LEGGINGS)
                .add(ModItems.BLUE_KITIUM_BOOTS)
                .add(ModItems.ENERGIZED_KITIUM_HELMET)
                .add(ModItems.ENERGIZED_KITIUM_CHESTPLATE)
                .add(ModItems.ENERGIZED_KITIUM_LEGGINGS)
                .add(ModItems.ENERGIZED_KITIUM_BOOTS);
    }
}
