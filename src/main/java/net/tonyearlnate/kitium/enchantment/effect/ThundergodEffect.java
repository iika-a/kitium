package net.tonyearlnate.kitium.enchantment.effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public record ThundergodEffect(EnchantmentLevelBasedValue amount) implements EnchantmentEntityEffect {
    public static final MapCodec<ThundergodEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(ThundergodEffect::amount)
            ).apply(instance, ThundergodEffect::new)
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
                float radius = this.amount.getValue(level) * 2;

                LivingEntity attacker = ((LivingEntity) target).getAttacker();

                float distanceFallen = 0;
                if (attacker != null) distanceFallen = attacker.fallDistance - 3;

               if (distanceFallen >= 0){
                   radius = (float) (radius * Math.sqrt(distanceFallen));
               }
               else {
                   radius = 0;
               }

                assert attacker != null;
                List<LivingEntity> list = getNearbyEntities(attacker, radius);

                for (LivingEntity e : list) {

                    BlockPos position = e.getBlockPos();

                    EntityType.LIGHTNING_BOLT.spawn(world, position, SpawnReason.TRIGGERED);
                }
                attacker.fallDistance = 0;
                attacker.heal(2);
                attacker.getStackInHand(attacker.getActiveHand()).damage(5, (PlayerEntity) attacker);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}