package net.tonyearlnate.kitium.item

import net.minecraft.item.SmithingTemplateItem
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier
import net.minecraft.util.Util
import net.tonyearlnate.kitium.Kitium

class EnergizedKitiumUpgradeSmithingTemplateItem(settings: Settings) : SmithingTemplateItem(
    UPGRADE_APPLIES_TO_TEXT,
    UPGRADE_INGREDIENTS_TEXT,
    UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
    UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
    UPGRADE_EMPTY_BASE_SLOT_TEXTURES,
    listOf(EMPTY_SLOT_INGOT_TEXTURE),
    settings
) {
    companion object {
        private val EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.ofVanilla("container/slot/helmet")
        private val EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.ofVanilla("container/slot/chestplate")
        private val EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.ofVanilla("container/slot/leggings")
        private val EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.ofVanilla("container/slot/boots")
        private val EMPTY_SLOT_HOE_TEXTURE = Identifier.ofVanilla("container/slot/hoe")
        private val EMPTY_SLOT_AXE_TEXTURE = Identifier.ofVanilla("container/slot/axe")
        private val EMPTY_SLOT_SWORD_TEXTURE = Identifier.ofVanilla("container/slot/sword")
        private val EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.ofVanilla("container/slot/shovel")
        private val EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.ofVanilla("container/slot/pickaxe")
        private val EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("container/slot/ingot")

        private val DESCRIPTION_FORMATTING = Formatting.BLUE

        private val UPGRADE_APPLIES_TO_TEXT: Text = Text.translatable(
            Util.createTranslationKey("item", Identifier.of(Kitium.MOD_ID, "smithing_template.energized_kitium_upgrade.applies_to"))
        ).formatted(DESCRIPTION_FORMATTING)

        private val UPGRADE_INGREDIENTS_TEXT: Text = Text.translatable(
            Util.createTranslationKey("item", Identifier.of(Kitium.MOD_ID, "smithing_template.energized_kitium_upgrade.ingredients"))
        ).formatted(DESCRIPTION_FORMATTING)

        private val UPGRADE_BASE_SLOT_DESCRIPTION_TEXT: Text = Text.translatable(
            Util.createTranslationKey("item", Identifier.of(Kitium.MOD_ID, "smithing_template.energized_kitium_upgrade.base_slot_description"))
        )

        private val UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT: Text = Text.translatable(
            Util.createTranslationKey("item", Identifier.of(Kitium.MOD_ID, "smithing_template.energized_kitium_upgrade.additions_slot_description"))
        )

        private val UPGRADE_EMPTY_BASE_SLOT_TEXTURES: List<Identifier> = listOf(
            EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
            EMPTY_SLOT_SWORD_TEXTURE,
            EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
            EMPTY_SLOT_PICKAXE_TEXTURE,
            EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
            EMPTY_SLOT_AXE_TEXTURE,
            EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
            EMPTY_SLOT_HOE_TEXTURE,
            EMPTY_SLOT_SHOVEL_TEXTURE
        )
    }
}
