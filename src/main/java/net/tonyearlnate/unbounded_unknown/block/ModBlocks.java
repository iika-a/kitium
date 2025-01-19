package net.tonyearlnate.unbounded_unknown.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;

public class ModBlocks {
    public static final Block PINK_KITIUM_BLOCK = registerBlock("pink_kitium_block",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID ,"pink_kitium_block")))
            .strength(4f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block BLUE_KITIUM_BLOCK = registerBlock("blue_kitium_block",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID ,"blue_kitium_block")))
            .strength(4f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ENERGIZED_KITIUM_BLOCK = registerBlock("energized_kitium_block",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID ,"energized_kitium_block")))
            .strength(8f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block RAW_PINK_KITIUM_BLOCK = registerBlock("raw_pink_kitium_block",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID ,"raw_pink_kitium_block")))
            .strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block RAW_BLUE_KITIUM_BLOCK = registerBlock("raw_blue_kitium_block",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID ,"raw_blue_kitium_block")))
            .strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block PINK_KITIUM_PANELING = registerBlock("pink_kitium_paneling",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID ,"pink_kitium_paneling")))
            .strength(4f).requiresTool().sounds(BlockSoundGroup.COPPER)));
    public static final Block BLUE_KITIUM_PANELING = registerBlock("blue_kitium_paneling",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID ,"blue_kitium_paneling")))
            .strength(4f).requiresTool().sounds(BlockSoundGroup.COPPER)));
    public static final Block ENERGIZED_KITIUM_PANELING = registerBlock("energized_kitium_paneling",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID ,"energized_kitium_paneling")))
            .strength(8f).requiresTool().sounds(BlockSoundGroup.COPPER)));
    
	public static final Block PINK_KITIUM_ORE = registerBlock("pink_kitium_ore", new Block(AbstractBlock.Settings.create()
			.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID, "pink_kitium_ore")))
			.strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
	public static final Block BLUE_KITIUM_ORE = registerBlock("blue_kitium_ore", new Block(AbstractBlock.Settings.create()
			.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID, "blue_kitium_ore")))
			.strength(3f).requiresTool().sounds(BlockSoundGroup.NETHER_GOLD_ORE)));
    public static final Block DEEPSLATE_PINK_KITIUM_ORE = registerBlock("deepslate_pink_kitium_ore", new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID, "deepslate_pink_kitium_ore")))
            .strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    
    public static final Block LIGHTNING_COLLECTOR = registerBlock("lightning_collector", new LightningCollectorBlock(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID, "lightning_collector")))
            .strength(4f).requiresTool().sounds(BlockSoundGroup.METAL)));
    
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(UnboundedUnknown.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, name), new BlockItem(block, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        UnboundedUnknown.LOGGER.info("Registering Mod Blocks for " + UnboundedUnknown.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_KITIUM_BLOCK);
            entries.add(BLUE_KITIUM_BLOCK);
            entries.add(ENERGIZED_KITIUM_BLOCK);
            entries.add(RAW_PINK_KITIUM_BLOCK);
            entries.add(RAW_BLUE_KITIUM_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(PINK_KITIUM_ORE);
            entries.add(BLUE_KITIUM_ORE);
            entries.add(DEEPSLATE_PINK_KITIUM_ORE);
        });
    }
}
