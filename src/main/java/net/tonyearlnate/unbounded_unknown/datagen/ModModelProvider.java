package net.tonyearlnate.unbounded_unknown.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.tonyearlnate.unbounded_unknown.block.ModBlocks;
import net.tonyearlnate.unbounded_unknown.item.ModArmorMaterials;
import net.tonyearlnate.unbounded_unknown.item.ModItems;
import net.tonyearlnate.unbounded_unknown.item.ModThrowables;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_KITIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_KITIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PINK_KITIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_KITIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_KITIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_KITIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BLUE_KITIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENERGIZED_KITIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_KITIUM_PANELING);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_KITIUM_PANELING);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENERGIZED_KITIUM_PANELING);
        blockStateModelGenerator.registerGeneric(ModBlocks.LIGHTNING_COLLECTOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_KITIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_KITIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.THUNDERSTORM_SPAWNER, Models.GENERATED);
        itemModelGenerator.register(ModThrowables.LIGHTNING_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_KITIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BLUE_KITIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_KITIUM_PANEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_KITIUM_PANEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_PANEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_KITIUM_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_KITIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_KITIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_KITIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_KITIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_KITIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BLUE_KITIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLUE_KITIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLUE_KITIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLUE_KITIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BLUE_KITIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_SWORD_FRAME, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_PICKAXE_FRAME, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_AXE_FRAME, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_SHOVEL_FRAME, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_HOE_FRAME, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_HELMET_FRAME, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_CHESTPLATE_FRAME, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_LEGGINGS_FRAME, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGIZED_KITIUM_BOOTS_FRAME, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.PINK_KITIUM_HELMET, ModArmorMaterials.ModEquipmentAssetKeys.PINK_KITIUM, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.PINK_KITIUM_CHESTPLATE, ModArmorMaterials.ModEquipmentAssetKeys.PINK_KITIUM, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.PINK_KITIUM_LEGGINGS, ModArmorMaterials.ModEquipmentAssetKeys.PINK_KITIUM, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.PINK_KITIUM_BOOTS, ModArmorMaterials.ModEquipmentAssetKeys.PINK_KITIUM, "boots", false);

        itemModelGenerator.registerArmor(ModItems.BLUE_KITIUM_HELMET, ModArmorMaterials.ModEquipmentAssetKeys.BLUE_KITIUM, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.BLUE_KITIUM_CHESTPLATE, ModArmorMaterials.ModEquipmentAssetKeys.BLUE_KITIUM, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.BLUE_KITIUM_LEGGINGS, ModArmorMaterials.ModEquipmentAssetKeys.BLUE_KITIUM, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.BLUE_KITIUM_BOOTS, ModArmorMaterials.ModEquipmentAssetKeys.BLUE_KITIUM, "boots", false);

        itemModelGenerator.registerArmor(ModItems.ENERGIZED_KITIUM_HELMET, ModArmorMaterials.ModEquipmentAssetKeys.ENERGIZED_KITIUM, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.ENERGIZED_KITIUM_CHESTPLATE, ModArmorMaterials.ModEquipmentAssetKeys.ENERGIZED_KITIUM, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.ENERGIZED_KITIUM_LEGGINGS, ModArmorMaterials.ModEquipmentAssetKeys.ENERGIZED_KITIUM, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.ENERGIZED_KITIUM_BOOTS, ModArmorMaterials.ModEquipmentAssetKeys.ENERGIZED_KITIUM, "boots", false);
        //meowmeow
    }
}
