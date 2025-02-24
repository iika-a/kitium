package net.tonyearlnate.kitium.LootTables;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tonyearlnate.kitium.Kitium;

public class ModLootTables {

    public static RegistryKey<LootTable> TEST_CHEST_LOOT = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(Kitium.MOD_ID, "chests/test_loot"));



}
