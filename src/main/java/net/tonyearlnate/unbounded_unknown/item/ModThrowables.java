package net.tonyearlnate.unbounded_unknown.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;

public class ModThrowables{

	public static final Item LIGHTNING_BOTTLE = registerThrowables("lightning_bottle", new LightningBottleItem(new Item.Settings().maxCount(1)
			.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"lightning_bottle")))));

    @SuppressWarnings("SameParameterValue")
    private static Item registerThrowables(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UnboundedUnknown.MOD_ID, name), item);
    }

    @SuppressWarnings("CodeBlock2Expr")
    public static void registerModThrowables() {
        UnboundedUnknown.LOGGER.info("Registering Mod Throwables for " + UnboundedUnknown.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(LIGHTNING_BOTTLE);
        });
    }
}