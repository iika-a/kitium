package net.tonyearlnate.kitium.item.ConsumeEffects;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodEffects {
    public static final ConsumableComponent INSTANT_HEALTH_I_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), 1.0f))
            .build();

    public static final ConsumableComponent INSTANT_DEATH_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 100), 1.0f))
            .build();

    public static final ConsumableComponent SPEED_HUNGER_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 10), .5f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 50, 5), 1.0f))
            .build();

    public static final ConsumableComponent ENERGIZED_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 800, 1), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1600, 1), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 1), 1.0f))
            .build();
}
