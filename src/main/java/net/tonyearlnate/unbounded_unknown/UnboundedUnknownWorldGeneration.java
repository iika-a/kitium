/*package net.tonyearlnate.unbounded_unknown;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryEntry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class UnboundedUnkownWorldGeneration {
    private static ConfiguredFeature<OreFeatureConfig, ?> PINK_KITIUM_ORE_CONFIGURED_FEATURE;
    private static PlacedFeature PINK_KITIUM_ORE_PLACED_FEATURE;

    public static void registerWorldGeneration() {
        // Configure the ore generation
        PINK_KITIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
                Feature.ORE,
                new OreFeatureConfig(
                        OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                        ModBlocks.PINK_KITIUM_ORE.getDefaultState(),
                        8 // Vein size
                )
        );

        // Register the configured feature
        Registry.register(Registries.CONFIGURED_FEATURE,
                new Identifier(AwesomeMod.MOD_ID, "pink_kitium_ore"),
                PINK_KITIUM_ORE_CONFIGURED_FEATURE);

        // Define placement modifiers
        List<PlacementModifier> placementModifiers = List.of(
                CountPlacementModifier.of(10), // Number of veins per chunk
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
        );

        // Create and register the placed feature
        PINK_KITIUM_ORE_PLACED_FEATURE = new PlacedFeature(
                RegistryEntry.of(PINK_KITIUM_ORE_CONFIGURED_FEATURE),
                placementModifiers
        );

        Registry.register(Registries.PLACED_FEATURE,
                new Identifier(AwesomeMod.MOD_ID, "pink_kitium_ore"),
                PINK_KITIUM_ORE_PLACED_FEATURE);

        // Add the placed feature to specific biomes
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE,
                        new Identifier(AwesomeMod.MOD_ID, "pink_kitium_ore"))
        );
    }
}*/
