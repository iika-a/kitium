package net.tonyearlnate.kitium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.tonyearlnate.kitium.enchantment.effect.ParalyzeEnchantmentEffect;
import net.tonyearlnate.kitium.enchantment.effect.SoulSiphonEffect;
import net.tonyearlnate.kitium.enchantment.effect.ThundergodEffect;
import net.tonyearlnate.kitium.enchantment.effect.ModEnchantmentEffects;
import net.tonyearlnate.kitium.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentGenerator extends FabricDynamicRegistryProvider {
    public ModEnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
        System.out.println("REGISTERING ENCHANTS");
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {






        register(entries, ModEnchantmentEffects.THUNDERGOD, Enchantment.builder(
                                Enchantment.definition(
                                        //supported items (can have the enchantment applied via books or commands)
                                        registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ModTags.Items.ENERGIZED_MACE_ENCHANTABLE),
                                        //primary items (enchantment will appear in enchanting table for item or item group)
                                        registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ModTags.Items.ENERGIZED_MACE_ENCHANTABLE),
                                        // this is the "weight" or probability of our enchantment showing up in the table
                                        8,
                                        // the maximum level of the enchantment
                                        3,
                                        // base cost for level 1 of the enchantment, and min levels required for something higher
                                        Enchantment.leveledCost(9, 10),
                                        // same fields as above but for max cost
                                        Enchantment.leveledCost(10, 10),
                                        // anvil cost
                                        1,
                                        // valid slots
                                        AttributeModifierSlot.HAND
                                )
                        )
                        .addEffect(
                                // enchantment occurs POST_ATTACK
                                EnchantmentEffectComponentTypes.POST_ATTACK,
                                EnchantmentEffectTarget.ATTACKER,
                                EnchantmentEffectTarget.VICTIM,
                                new ThundergodEffect(EnchantmentLevelBasedValue.linear(0.5f, 1f)) // scale the enchantment linearly.
                        )
        );

        register(entries, ModEnchantmentEffects.SOUL_SIPHON, Enchantment.builder(
                                Enchantment.definition(
                                        registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ModTags.Items.CORRUPT_MACE_ENCHANTABLE),
                                        registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ModTags.Items.CORRUPT_MACE_ENCHANTABLE),
                                        // this is the "weight" or probability of our enchantment showing up in the table
                                        8,
                                        // the maximum level of the enchantment
                                        3,
                                        // base cost for level 1 of the enchantment, and min levels required for something higher
                                        Enchantment.leveledCost(9, 10),
                                        // same fields as above but for max cost
                                        Enchantment.leveledCost(10, 10),
                                        // anvil cost
                                        1,
                                        // valid slots
                                        AttributeModifierSlot.HAND
                                )

                        )
                        .addEffect(
                                // enchantment occurs POST_ATTACK
                                EnchantmentEffectComponentTypes.POST_ATTACK,
                                EnchantmentEffectTarget.ATTACKER,
                                EnchantmentEffectTarget.VICTIM,
                                new SoulSiphonEffect(EnchantmentLevelBasedValue.linear(0.5f, 1f)) // scale the enchantment linearly.
                        )
        );

        register(entries, ModEnchantmentEffects.PARALYZE, Enchantment.builder(
                                Enchantment.definition(
                                        registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ModTags.Items.ENERGIZED_ARMOR),
                                        registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ModTags.Items.ENERGIZED_ARMOR),
                                        // this is the "weight" or probability of our enchantment showing up in the table
                                        12,
                                        // the maximum level of the enchantment
                                        4,
                                        // base cost for level 1 of the enchantment, and min levels required for something higher
                                        Enchantment.leveledCost(10, 6),
                                        // same fields as above but for max cost
                                        Enchantment.leveledCost(12, 6),
                                        // anvil cost
                                        1,
                                        // valid slots
                                        AttributeModifierSlot.ARMOR
                                )

                        )
                        .addEffect(
                                // enchantment occurs POST_ATTACK
                                EnchantmentEffectComponentTypes.TICK,
                                new ParalyzeEnchantmentEffect(EnchantmentLevelBasedValue.linear(0.5f, 1f))
                        )
        );


    }


    private void register(FabricDynamicRegistryProvider.Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "Enchantment Generator";
    }
}
