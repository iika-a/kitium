package net.tonyearlnate.kitium.item.ItemTypes;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.Random;

public class CorruptMaceItem extends Item {
    public CorruptMaceItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {

        super(material.applySwordSettings(settings, attackDamage, attackSpeed));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        Random r = new Random();

        if (r.nextInt(4)+1 == 4) {
            /*DamageSources sources = attacker.getDamageSources();

            DamageSource magicDamage = sources.create(DamageTypes.MAGIC, attacker);

            target.damage((ServerWorld) (target.getWorld()), magicDamage, 4.0F);*/
            var instance = new StatusEffectInstance(StatusEffects.WITHER, 6 * 20, 1, false, true, true);
            target.addStatusEffect(instance);

            attacker.heal(3);

            attacker.getWorld().playSound(null, attacker.getBlockPos(),
                    SoundEvents.ENTITY_ZOMBIE_VILLAGER_CONVERTED, SoundCategory.PLAYERS,
                    1f, 1.2f);
            attacker.getStackInHand(attacker.getActiveHand()).damage(1, (PlayerEntity)(attacker));
        }

        return super.postHit(stack, target, attacker);
    }
}
