package net.tonyearlnate.unbounded_unknown.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import net.minecraft.world.WorldEvents
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
            world.syncWorldEvent(WorldEvents.INSTANT_SPLASH_POTION_SPLASHED, this.blockPos, 0xFFFFFF)
            this.discard()
        }
    }

    companion object {
        @JvmStatic
        fun create(type: EntityType<LightningBottleEntity>, world: World): LightningBottleEntity {
            return LightningBottleEntity(world, type)
        }
    }
}

