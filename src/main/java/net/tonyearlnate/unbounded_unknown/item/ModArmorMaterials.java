package net.tonyearlnate.unbounded_unknown.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.tonyearlnate.unbounded_unknown.util.ModTags;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static final ArmorMaterial PINK_KITIUM = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 11);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, ModTags.Items.PINK_KITIUM_REPAIR, ModEquipmentAssetKeys.PINK_KITIUM);

    public static final ArmorMaterial BLUE_KITIUM = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 11);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, ModTags.Items.BLUE_KITIUM_REPAIR, ModEquipmentAssetKeys.BLUE_KITIUM);

    public static final ArmorMaterial ENERGIZED_KITIUM = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 4);
        map.put(EquipmentType.LEGGINGS, 7);
        map.put(EquipmentType.CHESTPLATE, 9);
        map.put(EquipmentType.HELMET, 4);
        map.put(EquipmentType.BODY, 12);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.2f, ModTags.Items.ENERGIZED_KITIUM_REPAIR, ModEquipmentAssetKeys.ENERGIZED_KITIUM);

    public static class ModEquipmentAssetKeys {
       public static RegistryKey<EquipmentAsset> PINK_KITIUM = register("pink_kitium");
       public static RegistryKey<EquipmentAsset> BLUE_KITIUM = register("blue_kitium");
       public static RegistryKey<EquipmentAsset> ENERGIZED_KITIUM = register("energized_kitium");

       private static RegistryKey<EquipmentAsset> register(String name) {
            return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(UnboundedUnknown.MOD_ID, name));
       }
    }
}
