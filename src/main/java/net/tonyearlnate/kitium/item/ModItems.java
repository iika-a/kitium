package net.tonyearlnate.kitium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.tonyearlnate.kitium.Kitium;
import net.tonyearlnate.kitium.item.ConsumeEffects.ModFoodEffects;
import net.tonyearlnate.kitium.item.ItemTypes.*;

public class ModItems {
    public static final Item PINK_KITIUM = registerItem("pink_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"pink_kitium")))));
    public static final Item BLUE_KITIUM = registerItem("blue_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"blue_kitium")))));
    public static final Item ENERGIZED_KITIUM = registerItem("energized_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium")))));
    public static final Item RAW_PINK_KITIUM = registerItem("raw_pink_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"raw_pink_kitium")))));
    public static final Item RAW_BLUE_KITIUM = registerItem("raw_blue_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"raw_blue_kitium")))));
    public static final Item PINK_KITIUM_PANEL = registerItem("pink_kitium_panel", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"pink_kitium_panel")))));
    public static final Item BLUE_KITIUM_PANEL = registerItem("blue_kitium_panel", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"blue_kitium_panel")))));
    public static final Item ENERGIZED_KITIUM_PANEL = registerItem("energized_kitium_panel", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_panel")))));
    public static final Item CORRUPT_PANEL = registerItem("corrupt_panel", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"corrupt_panel")))));
    public static final Item PINK_KITIUM_APPLE = registerItem("pink_kitium_apple", new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().saturationModifier(1.0f).nutrition(1).alwaysEdible().build(), ModFoodEffects.INSTANT_DEATH_FOOD_CONSUMABLE_COMPONENT).rarity(Rarity.UNCOMMON)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"pink_kitium_apple")))));
    public static final Item BLUE_KITIUM_APPLE =  registerItem("blue_kitium_apple", new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().saturationModifier(2.0f).nutrition(2).alwaysEdible().build(), ModFoodEffects.SPEED_HUNGER_FOOD_CONSUMABLE_COMPONENT).rarity(Rarity.UNCOMMON)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"blue_kitium_apple")))));
    public static final Item ENERGIZED_KITIUM_APPLE =  registerItem("energized_kitium_apple", new Item(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().saturationModifier(3.0f).nutrition(4).alwaysEdible().build(), ModFoodEffects.ENERGIZED_FOOD_CONSUMABLE_COMPONENT).rarity(Rarity.EPIC)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_apple")))));
    public static final Item THUNDERSTORM_SPAWNER = registerItem("thunderstorm_spawner", new ThunderstormSpawnerItem(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"thunderstorm_spawner")))));
    public static final Item ENERGIZED_KITIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("energized_kitium_upgrade_smithing_template", new EnergizedKitiumUpgradeSmithingTemplateItem(new Item.Settings().rarity(Rarity.UNCOMMON)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_upgrade_smithing_template")))));

    public static final Item ENERGIZED_KITIUM_SWORD_FRAME = registerItem("energized_kitium_sword_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_sword_frame")))));
    public static final Item ENERGIZED_KITIUM_PICKAXE_FRAME = registerItem("energized_kitium_pickaxe_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_pickaxe_frame")))));
    public static final Item ENERGIZED_KITIUM_AXE_FRAME = registerItem("energized_kitium_axe_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_axe_frame")))));
    public static final Item ENERGIZED_KITIUM_SHOVEL_FRAME = registerItem("energized_kitium_shovel_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_shovel_frame")))));
    public static final Item ENERGIZED_KITIUM_HOE_FRAME = registerItem("energized_kitium_hoe_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_hoe_frame")))));

    public static final Item ENERGIZED_KITIUM_HELMET_FRAME = registerItem("energized_kitium_helmet_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_helmet_frame")))));
    public static final Item ENERGIZED_KITIUM_CHESTPLATE_FRAME = registerItem("energized_kitium_chestplate_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_chestplate_frame")))));
    public static final Item ENERGIZED_KITIUM_LEGGINGS_FRAME = registerItem("energized_kitium_leggings_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_leggings_frame")))));
    public static final Item ENERGIZED_KITIUM_BOOTS_FRAME = registerItem("energized_kitium_boots_frame", new Item(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"energized_kitium_boots_frame")))));

    public static final Item PINK_KITIUM_SWORD = registerItem("pink_kitium_sword",
            new PinkKitiumSwordItem(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_sword")))));
    public static final Item PINK_KITIUM_PICKAXE = registerItem("pink_kitium_pickaxe",
            new PickaxeItem(ModToolMaterials.PINK_KITIUM, 1, -2.8f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_pickaxe")))));
    public static final Item PINK_KITIUM_AXE = registerItem("pink_kitium_axe",
            new AxeItem(ModToolMaterials.PINK_KITIUM, 6, -3.2f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_axe")))));
    public static final Item PINK_KITIUM_SHOVEL = registerItem("pink_kitium_shovel",
            new ShovelItem(ModToolMaterials.PINK_KITIUM, 1.5f, -3.2f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_shovel")))));
    public static final Item PINK_KITIUM_HOE = registerItem("pink_kitium_hoe",
            new HoeItem(ModToolMaterials.PINK_KITIUM, 0, -3f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_hoe")))));

    public static final Item BLUE_KITIUM_SWORD = registerItem("blue_kitium_sword",
            new BlueKitiumSwordItem(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_sword")))));
    public static final Item BLUE_KITIUM_PICKAXE = registerItem("blue_kitium_pickaxe",
            new PickaxeItem(ModToolMaterials.BLUE_KITIUM, 1, -2.8f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_pickaxe")))));
    public static final Item BLUE_KITIUM_AXE = registerItem("blue_kitium_axe",
            new AxeItem(ModToolMaterials.BLUE_KITIUM, 6, -3.2f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_axe")))));
    public static final Item BLUE_KITIUM_SHOVEL = registerItem("blue_kitium_shovel",
            new ShovelItem(ModToolMaterials.BLUE_KITIUM, 1.5f, -3.2f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_shovel")))));
    public static final Item BLUE_KITIUM_HOE = registerItem("blue_kitium_hoe",
            new HoeItem(ModToolMaterials.BLUE_KITIUM, 0, -3f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_hoe")))));

    public static final Item ENERGIZED_KITIUM_SWORD = registerItem("energized_kitium_sword",
            new EnergizedKitiumSwordItem(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_sword")))));
    public static final Item ENERGIZED_KITIUM_PICKAXE = registerItem("energized_kitium_pickaxe",
            new PickaxeItem(ModToolMaterials.ENERGIZED_KITIUM, 1, -2.8f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_pickaxe")))));
    public static final Item ENERGIZED_KITIUM_AXE = registerItem("energized_kitium_axe",
            new AxeItem(ModToolMaterials.ENERGIZED_KITIUM, 6, -3.2f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_axe")))));
    public static final Item ENERGIZED_KITIUM_SHOVEL = registerItem("energized_kitium_shovel",
            new ShovelItem(ModToolMaterials.ENERGIZED_KITIUM, 1.5f, -3.2f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_shovel")))));
    public static final Item ENERGIZED_KITIUM_HOE = registerItem("energized_kitium_hoe",
            new HoeItem(ModToolMaterials.ENERGIZED_KITIUM, 0, -3f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_hoe")))));

    public static final Item PINK_KITIUM_HELMET = registerItem("pink_kitium_helmet",
            new ArmorItem(ModArmorMaterials.PINK_KITIUM, EquipmentType.HELMET, new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(35))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_helmet")))));
    public static final Item PINK_KITIUM_CHESTPLATE = registerItem("pink_kitium_chestplate",
            new ArmorItem(ModArmorMaterials.PINK_KITIUM, EquipmentType.CHESTPLATE, new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(35))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_chestplate")))));
    public static final Item PINK_KITIUM_LEGGINGS = registerItem("pink_kitium_leggings",
            new ArmorItem(ModArmorMaterials.PINK_KITIUM, EquipmentType.LEGGINGS, new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(35))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_leggings")))));
    public static final Item PINK_KITIUM_BOOTS = registerItem("pink_kitium_boots",
            new ArmorItem(ModArmorMaterials.PINK_KITIUM, EquipmentType.BOOTS, new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(35))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "pink_kitium_boots")))));

    public static final Item BLUE_KITIUM_HELMET = registerItem("blue_kitium_helmet",
            new ArmorItem(ModArmorMaterials.BLUE_KITIUM, EquipmentType.HELMET, new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(35))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_helmet")))));
    public static final Item BLUE_KITIUM_CHESTPLATE = registerItem("blue_kitium_chestplate",
            new ArmorItem(ModArmorMaterials.BLUE_KITIUM, EquipmentType.CHESTPLATE, new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(35))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_chestplate")))));
    public static final Item BLUE_KITIUM_LEGGINGS = registerItem("blue_kitium_leggings",
            new ArmorItem(ModArmorMaterials.BLUE_KITIUM, EquipmentType.LEGGINGS, new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(35))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_leggings")))));
    public static final Item BLUE_KITIUM_BOOTS = registerItem("blue_kitium_boots",
            new ArmorItem(ModArmorMaterials.BLUE_KITIUM, EquipmentType.BOOTS, new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(35))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "blue_kitium_boots")))));

    public static final Item ENERGIZED_KITIUM_HELMET = registerItem("energized_kitium_helmet",
            new ArmorItem(ModArmorMaterials.ENERGIZED_KITIUM, EquipmentType.HELMET, new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(40))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_helmet")))));
    public static final Item ENERGIZED_KITIUM_CHESTPLATE = registerItem("energized_kitium_chestplate",
            new ArmorItem(ModArmorMaterials.ENERGIZED_KITIUM, EquipmentType.CHESTPLATE, new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(40))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_chestplate")))));
    public static final Item ENERGIZED_KITIUM_LEGGINGS = registerItem("energized_kitium_leggings",
            new ArmorItem(ModArmorMaterials.ENERGIZED_KITIUM, EquipmentType.LEGGINGS, new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(40))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_leggings")))));
    public static final Item ENERGIZED_KITIUM_BOOTS = registerItem("energized_kitium_boots",
            new ArmorItem(ModArmorMaterials.ENERGIZED_KITIUM, EquipmentType.BOOTS, new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(40))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_kitium_boots")))));

    public static final Item ENERGIZED_MACE = registerItem("energized_mace",
            new EnergizedMaceItem(ModToolMaterials.ENERGIZED_KITIUM, 4f, -3.2f, new Item.Settings().maxCount(1).rarity(Rarity.EPIC)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "energized_mace")))));
    public static final Item MACE_HUSK = registerItem("mace_husk", new Item(new Item.Settings().rarity(Rarity.RARE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID,"mace_husk")))));
    public static final Item CORRUPT_MACE = registerItem("corrupt_mace",
            new CorruptMaceItem(ModToolMaterials.ENERGIZED_KITIUM, 2f, -3.3f, new Item.Settings().maxCount(1).rarity(Rarity.EPIC)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "corrupt_mace")))));

    public static final Item CORRUPT_TOTEM = registerItem("corrupt_totem", new CorruptTotemItem(new Item.Settings().maxCount(1).rarity(Rarity.RARE)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "corrupt_totem")))));
    public static final Item CORRUPT_SWORD = registerItem("corrupt_sword",
            new CorruptSwordItem(ModToolMaterials.ENERGIZED_KITIUM, 1.5f, -1.9f, new Item.Settings().maxCount(1).rarity(Rarity.EPIC).useCooldown(3.0f)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "corrupt_sword")))));

    public static final Item CORRUPT_HELMET = registerItem("corrupt_helmet",
            new CorruptHelmetItem(ModArmorMaterials.CORRUPT, EquipmentType.HELMET, new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(38))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "corrupt_helmet")))));
    public static final Item CORRUPT_CHESTPLATE = registerItem("corrupt_chestplate",
            new ArmorItem(ModArmorMaterials.CORRUPT, EquipmentType.CHESTPLATE, new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(38))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "corrupt_chestplate")))));
    public static final Item CORRUPT_LEGGINGS = registerItem("corrupt_leggings",
            new ArmorItem(ModArmorMaterials.CORRUPT, EquipmentType.LEGGINGS, new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(38))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "corrupt_leggings")))));
    public static final Item CORRUPT_BOOTS = registerItem("corrupt_boots",
            new ArmorItem(ModArmorMaterials.CORRUPT, EquipmentType.BOOTS, new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(38))
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Kitium.MOD_ID, "corrupt_boots")))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Kitium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Kitium.LOGGER.info("Registering Mod Items for " + Kitium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(THUNDERSTORM_SPAWNER);
            entries.add(PINK_KITIUM_SWORD);
            entries.add(PINK_KITIUM_PICKAXE);
            entries.add(PINK_KITIUM_AXE);
            entries.add(PINK_KITIUM_SHOVEL);
            entries.add(PINK_KITIUM_HOE);
            entries.add(BLUE_KITIUM_SWORD);
            entries.add(BLUE_KITIUM_PICKAXE);
            entries.add(BLUE_KITIUM_AXE);
            entries.add(BLUE_KITIUM_SHOVEL);
            entries.add(BLUE_KITIUM_HOE);
            entries.add(ENERGIZED_KITIUM_SWORD);
            entries.add(ENERGIZED_KITIUM_PICKAXE);
            entries.add(ENERGIZED_KITIUM_AXE);
            entries.add(ENERGIZED_KITIUM_SHOVEL);
            entries.add(ENERGIZED_KITIUM_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(PINK_KITIUM_SWORD);
            entries.add(PINK_KITIUM_AXE);
            entries.add(BLUE_KITIUM_SWORD);
            entries.add(BLUE_KITIUM_AXE);
            entries.add(ENERGIZED_KITIUM_SWORD);
            entries.add(ENERGIZED_KITIUM_AXE);
        });
    }
}
