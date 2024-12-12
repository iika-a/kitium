package net.tonyearlnate.awesomemod.block;

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
import net.tonyearlnate.awesomemod.AwesomeMod;

public class ModBlocks {
    public static final Block RED_KITIUM_BLOCK = registerBlock("red_kitium_block",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AwesomeMod.MOD_ID ,"red_kitium_block")))
            .strength(4f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block BLUE_KITIUM_BLOCK = registerBlock("blue_kitium_block",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AwesomeMod.MOD_ID ,"blue_kitium_block")))
            .strength(4f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ENERGIZED_KITIUM_BLOCK = registerBlock("energized_kitium_block",new Block(AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AwesomeMod.MOD_ID ,"energized_kitium_block")))
            .strength(8f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AwesomeMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AwesomeMod.MOD_ID, name), new BlockItem(block, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AwesomeMod.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        AwesomeMod.LOGGER.info("Registering Mod Blocks for " + AwesomeMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(RED_KITIUM_BLOCK);
            entries.add(BLUE_KITIUM_BLOCK);
            entries.add(ENERGIZED_KITIUM_BLOCK);
        });
    }
}
