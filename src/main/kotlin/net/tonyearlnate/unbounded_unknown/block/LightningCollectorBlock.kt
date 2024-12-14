package net.tonyearlnate.unbounded_unknown.block

import com.mojang.serialization.MapCodec
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.world.World
import net.minecraft.entity.Entity
import net.minecraft.entity.LightningEntity

class LightningCollectorBlock(settings: Settings) : BlockWithEntity(settings) {
    override fun getCodec(): MapCodec<out BlockWithEntity> {
        TODO("Not yet implemented")
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return LightningCollectorBlockEntity(pos, state)
    }

    private fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: LightningCollectorBlockEntity) {
        if (!world.isClient) {
            if (checkForLightning(world, pos)) blockEntity.onLightningStrike()
        }
    }

    private fun checkForLightning(world: World, blockPos: BlockPos): Boolean {
        val area = Box(blockPos.x.toDouble(), blockPos.y + 1.0, blockPos.z.toDouble(), blockPos.x.toDouble(), blockPos.y + 2.0, blockPos.z.toDouble())
        val entities: List<Entity> = world.getEntitiesByClass(Entity::class.java, area, null)

        for (entity in entities) if (entity is LightningEntity) return true
        return false
    }
}