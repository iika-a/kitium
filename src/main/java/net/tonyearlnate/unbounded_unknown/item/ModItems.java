package net.tonyearlnate.unbounded_unknown.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;

public class ModItems {
    public static final Item PINK_KITIUM = registerItem("pink_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"pink_kitium")))));
    public static final Item BLUE_KITIUM = registerItem("blue_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"blue_kitium")))));
    public static final Item ENERGIZED_KITIUM = registerItem("energized_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"energized_kitium")))));
    public static final Item RAW_PINK_KITIUM = registerItem("raw_pink_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"raw_pink_kitium")))));
    public static final Item RAW_BLUE_KITIUM = registerItem("raw_blue_kitium", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"raw_blue_kitium")))));
    public static final Item PINK_KITIUM_PANEL = registerItem("pink_kitium_panel", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"pink_kitium_panel")))));
    public static final Item BLUE_KITIUM_PANEL = registerItem("blue_kitium_panel", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"blue_kitium_panel")))));
    public static final Item ENERGIZED_KITIUM_PANEL = registerItem("energized_kitium_panel", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"energized_kitium_panel")))));
    public static final Item PINK_KITIUM_APPLE = registerItem("pink_kitium_apple", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"pink_kitium_apple")))));
    public static final Item THUNDERSTORM_SPAWNER = registerItem("thunderstorm_spawner", new ThunderstormSpawnerItem(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"thunderstorm_spawner")))));

    public static final Item PINK_KITIUM_SWORD = registerItem("pink_kitium_sword",
            new SwordItem(ModToolMaterials.PINK_KITIUM, 3, -2.4f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, "pink_kitium_sword")))));
    public static final Item PINK_KITIUM_PICKAXE = registerItem("pink_kitium_pickaxe",
            new PickaxeItem(ModToolMaterials.PINK_KITIUM, 1, -2.8f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, "pink_kitium_pickaxe")))));
    public static final Item PINK_KITIUM_AXE = registerItem("pink_kitium_axe",
            new AxeItem(ModToolMaterials.PINK_KITIUM, 6, -3.2f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, "pink_kitium_axe")))));
    public static final Item PINK_KITIUM_SHOVEL = registerItem("pink_kitium_shovel",
            new ShovelItem(ModToolMaterials.PINK_KITIUM, 1.5f, -3.2f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, "pink_kitium_shovel")))));
    public static final Item PINK_KITIUM_HOE = registerItem("pink_kitium_hoe",
            new HoeItem(ModToolMaterials.PINK_KITIUM, 0, -3f, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, "pink_kitium_hoe")))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, name), item);
    }

    @SuppressWarnings("CodeBlock2Expr")
    public static void registerModItems() {
        UnboundedUnknown.LOGGER.info("Registering Mod Items for " + UnboundedUnknown.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(THUNDERSTORM_SPAWNER);
        });
    }
}
