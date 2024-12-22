package net.tonyearlnate.unbounded_unknown.entity

import net.minecraft.entity.*
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import net.tonyearlnate.unbounded_unknown.item.ModThrowables

class LightningBottleEntity(
    world: World,
    entityType: EntityType<out ThrownItemEntity?> = ModEntities.LIGHTNING_BOTTLE_ENTITY_TYPE
) : ThrownItemEntity(entityType, world) {

    private var stack: ItemStack = ItemStack.EMPTY

    fun initialize(owner: LivingEntity, stack: ItemStack) {
        this.owner = owner
        this.stack = stack
    }

    override fun getDefaultItem(): Item {
        return ModThrowables.LIGHTNING_BOTTLE
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!world.isClient) {
            val lightning = EntityType.LIGHTNING_BOLT.create(world, SpawnReason.TRIGGERED)
            lightning!!.refreshPositionAfterTeleport(this.x, this.y, this.z)
            world.spawnEntity(lightning)
            this.discard()
            world.playSound(
                null,
                x,
                y,
                z,
                SoundEvents.ENTITY_SPLASH_POTION_BREAK,
                SoundCategory.NEUTRAL,
                1f,
                0.9f + world.getRandom().nextFloat() * 0.1f
            )
        }
    }

    companion object {
        @JvmStatic
        fun create(type: EntityType<LightningBottleEntity>, world: World): LightningBottleEntity {
            return LightningBottleEntity(world, type)
        }
    }
}

