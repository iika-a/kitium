package net.tonyearlnate.kitium.block

import com.mojang.serialization.MapCodec
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.screen.ScreenHandler
import net.minecraft.util.ActionResult
import net.minecraft.util.ItemScatterer
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.tonyearlnate.kitium.block.entity.ModBlockEntities


class LightningCollectorBlock(settings: Settings) : BlockWithEntity(settings), BlockEntityProvider {
    override fun getCodec(): MapCodec<out BlockWithEntity>? {
        return createCodec(::LightningCollectorBlock)
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

    override fun onUse(state: BlockState, world: World, pos: BlockPos?, player: PlayerEntity, hit: BlockHitResult?): ActionResult {
        if (!world.isClient) {
            val screenHandlerFactory = state.createScreenHandlerFactory(world, pos)

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory)
            }
        }
        return ActionResult.SUCCESS
    }

    override fun onStateReplaced(state: BlockState, world: World, pos: BlockPos?, newState: BlockState, moved: Boolean) {
        if (state.block !== newState.block) {
            val blockEntity = world.getBlockEntity(pos)
            if (blockEntity is LightningCollectorBlockEntity) {
                ItemScatterer.spawn(world, pos, blockEntity)
                world.updateComparators(pos, this)
            }
            super.onStateReplaced(state, world, pos, newState, moved)
        }
    }

    override fun hasComparatorOutput(state: BlockState?): Boolean {
        return true
    }

    override fun getComparatorOutput(state: BlockState?, world: World, pos: BlockPos?): Int {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos))
    }
}