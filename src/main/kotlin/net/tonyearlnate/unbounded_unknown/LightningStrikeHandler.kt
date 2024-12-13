package net.tonyearlnate.unbounded_unknown

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents
import net.minecraft.entity.LightningEntity
import net.minecraft.server.world.ServerWorld

object LightningStrikeHandler {
    @JvmStatic
    fun registerEvents() {
        ServerEntityEvents.ENTITY_LOAD.register { entity, world ->
            if (entity is LightningEntity && world is ServerWorld) handleLightningStrike(world, entity)
        }
    }

    fun handleLightningStrike(world: ServerWorld, lightning: LightningEntity) {
        val strikePos = lightning.blockPos
    }
}