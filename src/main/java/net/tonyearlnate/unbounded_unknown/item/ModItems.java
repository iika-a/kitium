package net.tonyearlnate.unbounded_unknown.item;



import com.nimbusds.openid.connect.sdk.assurance.Status;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;

import static net.tonyearlnate.unbounded_unknown.item.ConsumeEffects.foodEffects.*;

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
    public static final Item THUNDERSTORM_SPAWNER = registerItem("thunderstorm_spawner", new ThunderstormSpawnerItem(new Item.Settings().maxCount(1)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"thunderstorm_spawner")))));
    public static final Item PINK_KITIUM_APPLE =  registerItem("pink_kitium_apple", new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().saturationModifier(1.0f).nutrition(1).build(), INSTANT_DEATH_FOOD_CONSUMABLE_COMPONENT)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"pink_kitium_apple")))));
    public static final Item BLUE_KITIUM_APPLE =  registerItem("blue_kitium_apple", new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().saturationModifier(1.0f).nutrition(1).build(), SPEED_HUNGER_FOOD_CONSUMABLE_COMPONENT)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnboundedUnknown.MOD_ID,"blue_kitium_apple")))));


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
