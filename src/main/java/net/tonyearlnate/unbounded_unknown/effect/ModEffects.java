package net.tonyearlnate.unbounded_unknown.effect;

import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> LIGHTNING_EFFECT = registerStatusEffect("lightning_effect",
            new LightningEffect(StatusEffectCategory.NEUTRAL, 0xFFFFFF));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(UnboundedUnknown.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        UnboundedUnknown.LOGGER.info("Registering Mod Effects for " + UnboundedUnknown.MOD_ID);
    }
}