package net.tonyearlnate.unbounded_unknown.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;

public class ModThrowables{

	public static final Item LIGHTNING_IN_A_BOTTLE = registerThrowables("lightning_in_a_bottle", new Item(new Item.Settings().maxCount(1)
			.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"lightning_in_a_bottle")))));
	
    private static Item registerThrowables(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, name), item);
    }

    public static void registerModThrowables() {
        UnboundedUnknown.LOGGER.info("Registering Mod Items for " + UnboundedUnknown.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(LIGHTNING_IN_A_BOTTLE);
        });
    }
}