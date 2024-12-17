package net.tonyearlnate.unbounded_unknown.potion;

import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.tonyearlnate.unbounded_unknown.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> LIGHTNING_POTION = registerPotion("lightning_potion", new Potion(null, null));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(UnboundedUnknown.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        UnboundedUnknown.LOGGER.info("Registering Mod Potions for " + UnboundedUnknown.MOD_ID);
    }
}