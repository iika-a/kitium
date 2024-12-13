package net.tonyearlnate.unbounded_unknown.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.world.World

class ThunderstormSpawnerItem(settings: Settings): Item(settings) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): ActionResult {
        if (world is ServerWorld) {
            world.setWeather(0, 6000, true, true)
        }

        user.getStackInHand(hand).decrement(1)
        return ActionResult.SUCCESS
    }
}