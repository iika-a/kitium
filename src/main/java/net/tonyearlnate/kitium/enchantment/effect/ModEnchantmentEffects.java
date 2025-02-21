package net.tonyearlnate.kitium.enchantment.effect;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tonyearlnate.kitium.Kitium;
import net.tonyearlnate.kitium.enchantment.effect.LightningEnchantmentEffect;



public class ModEnchantmentEffects {
    public static final RegistryKey<Enchantment> THUNDERING = of("thundering");
    public static MapCodec<LightningEnchantmentEffect> LIGHTNING_EFFECT = register("lightning_effect", LightningEnchantmentEffect.CODEC);





    private static RegistryKey<Enchantment> of(String path) {
        Identifier id = Identifier.of(Kitium.MOD_ID, path);
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, id);
    }

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Kitium.MOD_ID, id), codec);
    }

    public static void registerModEnchantmentEffects() {
        Kitium.LOGGER.info("Registering EnchantmentEffects for" + Kitium.MOD_ID);
    }
}