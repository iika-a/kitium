package net.tonyearlnate.unbounded_unknown.item

import net.minecraft.entity.SpawnReason
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ThrowablePotionItem
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.stat.Stats
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.world.World
import net.tonyearlnate.unbounded_unknown.entity.LightningBottleEntity
import net.tonyearlnate.unbounded_unknown.entity.ModEntities


class LightningBottleItem(settings: Settings) : ThrowablePotionItem(settings) {
    override fun use(world: World?, user: PlayerEntity, hand: Hand?): ActionResult {
        val itemStack = user.getStackInHand(hand)
        if (world is ServerWorld) {
            val entity = ModEntities.LIGHTNING_BOTTLE_ENTITY_TYPE.create(world, SpawnReason.SPAWN_ITEM_USE)
            if (entity is LightningBottleEntity) {
                entity.initialize(user, itemStack)
                entity.setPosition(user.x, user.eyeY, user.z)
                entity.setVelocity(user, user.pitch, user.yaw, 0.0f, POWER, 1.0f)
                world.spawnEntity(entity)
            }
            world.playSound(
                null,
                user.x,
                user.y,
                user.z,
                SoundEvents.ENTITY_SPLASH_POTION_THROW,
                SoundCategory.PLAYERS,
                0.5f,
                0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f)
            )
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this))
        itemStack.decrementUnlessCreative(1, user)
        return ActionResult.SUCCESS
    }
}
