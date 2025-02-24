package net.tonyearlnate.kitium.enchantment.effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.tonyearlnate.kitium.entity.LightningBottleEntity;

import java.util.List;
import java.util.Random;

public record ParalyzeEnchantmentEffect(EnchantmentLevelBasedValue amount) implements EnchantmentEntityEffect {
    public static final MapCodec<ParalyzeEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(      instance ->
            instance.group(
                    EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(ParalyzeEnchantmentEffect::amount)
            ).apply(instance, ParalyzeEnchantmentEffect::new)
    );


    public static List<LivingEntity> getNearbyEntities(LivingEntity attacker, float radius) {
        World world = attacker.getWorld();
        if (world instanceof ServerWorld serverWorld) {
            // Define a bounding box around the attacker
            Box box = new Box(
                    attacker.getX() - radius, attacker.getY() - radius, attacker.getZ() - radius,
                    attacker.getX() + radius, attacker.getY() + radius, attacker.getZ() + radius
            );

            // Get all entities in the box, filter out the attacker
            return serverWorld.getEntitiesByClass(LivingEntity.class, box, entity -> entity != attacker);
        }
        return List.of(); // Return empty list if not on server world
    }


    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (target instanceof LivingEntity victim) {
            if (context.owner() != null && context.owner() instanceof PlayerEntity player) {
                Random r = new Random();
                if (((LivingEntity) target).getAttacker() != null && ((LivingEntity) (target)).hurtTime == 10 && r.nextInt(4)+1 == 4) {
                    float radius = this.amount.getValue(level) * 5;
                    float shock_power = this.amount.getValue(level) * 2;

                    List<LivingEntity> l = getNearbyEntities((LivingEntity)target, radius);
                    target.getWorld().addParticle(ParticleTypes.ELECTRIC_SPARK,
                            target.getX(), target.getY() + 1, target.getZ(), 0, 0, 0);
                    for (int i = 0; i < 30; i++) { // Adjust for more/less sparks
                        double offsetX = (world.random.nextDouble() - 0.5)*5.0; // Random X (-0.5 to 0.5)
                        double offsetY = (world.random.nextDouble()) * 2.0; // Random Y (0 to 1.5)
                        double offsetZ = (world.random.nextDouble() - 0.5)*5.0; // Random Z (-0.5 to 0.5)

                        world.spawnParticles(
                                ParticleTypes.ELECTRIC_SPARK, // The particle type
                                target.getX() + offsetX, // X position
                                target.getY() + offsetY, // Y position
                                target.getZ() + offsetZ, // Z position
                                1, // Number of particles (per spawn call)
                                0, 0, 0, 0.1 // Motion (X, Y, Z, speed)
                        );
                    }

                    for (LivingEntity e : l) {
                        e.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, (int)shock_power*20, (int)shock_power/2, false, false));
                        e.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, (int)shock_power*20, (int)shock_power/2, false, false));
                        //gives affected entities slowness and weakness, akin to getting shocked/disoriented
                        e.damage(world, target.getDamageSources().lightningBolt(), shock_power);
                        //damages the entities affected
                    }
                    target.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 0.6f, 2.0f);

                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}