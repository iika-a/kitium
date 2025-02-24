package net.tonyearlnate.kitium.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tonyearlnate.kitium.Kitium;

public class ModTags {


    public static class Blocks {
        public static final TagKey<Block> NEEDS_ENERGIZED_KITIUM_TOOL = createTag("needs_energized_kitium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ENERGIZED_KITIUM_TOOL = createTag("incorrect_for_energized_kitium_tool");

        public static final TagKey<Block> NEEDS_PINK_KITIUM_TOOL = createTag("needs_pink_kitium_tool");
        public static final TagKey<Block> INCORRECT_FOR_PINK_KITIUM_TOOL = createTag("incorrect_for_pink_kitium_tool");

        public static final TagKey<Block> NEEDS_BLUE_KITIUM_TOOL = createTag("needs_blue_kitium_tool");
        public static final TagKey<Block> INCORRECT_FOR_BLUE_KITIUM_TOOL = createTag("incorrect_for_blue_kitium_tool");




        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Kitium.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PINK_KITIUM_REPAIR = createTag("pink_kitium_repair");
        public static final TagKey<Item> BLUE_KITIUM_REPAIR = createTag("blue_kitium_repair");
        public static final TagKey<Item> ENERGIZED_KITIUM_REPAIR = createTag("energized_kitium_repair");
        public static final TagKey<Item> ENERGIZED_MACE_ENCHANTABLE = createTag("energized_mace_enchantable");
        public static final TagKey<Item> CORRUPT_MACE_ENCHANTABLE = createTag("corrupt_mace_enchantable");
        public static final TagKey<Item> ENERGIZED_ARMOR = createTag("corrupt_mace_enchantable");


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, name));
        }
    }
}
