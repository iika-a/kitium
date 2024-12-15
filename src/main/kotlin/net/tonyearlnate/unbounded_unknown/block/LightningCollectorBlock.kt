package net.tonyearlnate.unbounded_unknown.block

import com.mojang.serialization.MapCodec
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class LightningCollectorBlock(settings: Settings) : BlockWithEntity(settings), BlockEntityProvider {
    override fun getCodec(): MapCodec<out BlockWithEntity> {
        TODO("Not yet implemented")
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return LightningCollectorBlockEntity(pos, state)
    }

    override fun <T: BlockEntity> getTicker(world: World, state:BlockState, type: BlockEntityType<T>): BlockEntityTicker<T>? {
        if (!world.isClient) {
            return validateTicker(type, ModBlockEntities.LIGHTNING_COLLECTOR_BLOCK_ENTITY_TYPE, LightningCollectorBlockEntity.Companion::tick)
        }
        return null
    }
}