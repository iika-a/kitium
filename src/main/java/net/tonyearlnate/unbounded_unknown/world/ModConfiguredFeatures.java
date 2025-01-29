package net.tonyearlnate.unbounded_unknown.world;

import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.tonyearlnate.unbounded_unknown.block.ModBlocks;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_KITIUM_ORE_KEY = registerKey("pink_kitium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_KITIUM_ORE_KEY = registerKey("blue_kitium_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        

        List<OreFeatureConfig.Target> overworldOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.PINK_KITIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_PINK_KITIUM_ORE.getDefaultState()));
		List<OreFeatureConfig.Target> netherOres = 
				List.of(OreFeatureConfig.createTarget(null, ModBlocks.BLUE_KITIUM_ORE.getDefaultState()));
		

        register(context, PINK_KITIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldOres, 10));
        register(context, BLUE_KITIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherOres, 10));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(UnboundedUnknown.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}