package net.tonyearlnate.kitium.block

import com.mojang.serialization.MapCodec
import net.minecraft.advancement.criterion.Criteria
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.pattern.BlockPattern
import net.minecraft.block.pattern.BlockPatternBuilder
import net.minecraft.block.pattern.CachedBlockPosition
import net.minecraft.entity.Entity
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.predicate.block.BlockStatePredicate
import net.minecraft.screen.ScreenHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.ActionResult
import net.minecraft.util.ItemScatterer
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.WorldEvents
import net.minecraft.world.WorldView
import net.tonyearlnate.kitium.block.entity.ModBlockEntities
import net.tonyearlnate.kitium.entity.ModEntities
import java.util.function.Predicate


class LightningCollectorBlock(settings: Settings) : BlockWithEntity(settings), BlockEntityProvider {
    override fun getCodec(): MapCodec<out BlockWithEntity>? {
        return createCodec(::LightningCollectorBlock)
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return LightningCollectorBlockEntity(pos, state)
    }

    override fun <T : BlockEntity> getTicker(
        world: World,
        state: BlockState,
        type: BlockEntityType<T>
    ): BlockEntityTicker<T>? {
        if (!world.isClient) {
            return validateTicker(
                type,
                ModBlockEntities.LIGHTNING_COLLECTOR_BLOCK_ENTITY_TYPE,
                LightningCollectorBlockEntity.Companion::tick
            )
        }
        return null
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos?,
        player: PlayerEntity,
        hit: BlockHitResult?
    ): ActionResult {
        if (!world.isClient) {
            val screenHandlerFactory = state.createScreenHandlerFactory(world, pos)

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory)
            }
        }
        return ActionResult.SUCCESS
    }

    override fun onStateReplaced(
        state: BlockState,
        world: World,
        pos: BlockPos?,
        newState: BlockState,
        moved: Boolean
    ) {
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


    override fun onBlockAdded(state: BlockState, world: World, pos: BlockPos?, oldState: BlockState, notify: Boolean) {
        if (!oldState.isOf(state.block)) {
            this.trySpawnEntity(world, pos!!)
        }
    }

    private var kitiumGolemDispenserPattern: BlockPattern? = null
    private var kitiumGolemPattern: BlockPattern? = null

    val IS_GOLEM_HEAD_PREDICATE = Predicate<BlockState> { state ->
        state.isOf(ModBlocks.LIGHTNING_COLLECTOR)
    }

    fun canDispense(world: WorldView?, pos: BlockPos?): Boolean {
        return this.getKitiumGolemDispenserPattern()?.searchAround(world, pos) != null
    }

    private fun trySpawnEntity(world: World, pos: BlockPos) {
        val result2 = this.getKitiumGolemPattern()?.searchAround(world, pos)
        if (result2 == null) {
            println("Pattern did not match!")
            return
        }

        val kitiumGolemEntity = ModEntities.KITIUM_GOLEM_ENTITY_TYPE.create(world, SpawnReason.TRIGGERED)
        if (kitiumGolemEntity != null) {
            kitiumGolemEntity.isPlayerCreated = true
            spawnEntity(world, result2, kitiumGolemEntity, result2.translate(1, 2, 0).blockPos)
        }
    }

    private fun spawnEntity(world: World, patternResult: BlockPattern.Result, entity: Entity, pos: BlockPos) {
        breakPatternBlocks(world, patternResult)
        entity.refreshPositionAndAngles(
            pos.x.toDouble() + 0.5,
            pos.y.toDouble() + 0.05,
            pos.z.toDouble() + 0.5,
            0.0f,
            0.0f
        )
        world.spawnEntity(entity)

        for (serverPlayerEntity in world.getNonSpectatingEntities(
            ServerPlayerEntity::class.java,
            entity.boundingBox.expand(5.0)
        )) {
            Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, entity)
        }

        updatePatternBlocks(world, patternResult)
    }

    fun breakPatternBlocks(world: World, patternResult: BlockPattern.Result) {
        for (i in 0..<patternResult.width) {
            for (j in 0..<patternResult.height) {
                val cachedBlockPosition = patternResult.translate(i, j, 0)
                world.setBlockState(cachedBlockPosition.blockPos, Blocks.AIR.defaultState, NOTIFY_LISTENERS)
                world.syncWorldEvent(
                    WorldEvents.BLOCK_BROKEN,
                    cachedBlockPosition.blockPos,
                    getRawIdFromState(cachedBlockPosition.blockState)
                )
            }
        }
    }

    fun updatePatternBlocks(world: World, patternResult: BlockPattern.Result) {
        for (i in 0..<patternResult.width) {
            for (j in 0..<patternResult.height) {
                val cachedBlockPosition = patternResult.translate(i, j, 0)
                world.updateNeighbors(cachedBlockPosition.blockPos, Blocks.AIR)
            }
        }
    }

    private fun getKitiumGolemDispenserPattern(): BlockPattern {
        if (this.kitiumGolemDispenserPattern == null) {
            this.kitiumGolemDispenserPattern = BlockPatternBuilder.start()
                .aisle("~ ~", "###", "~#~")
                .where(
                    '#',
                    CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.PINK_KITIUM_BLOCK))
                )
                .where('~') { pos: CachedBlockPosition -> pos.blockState.isAir }
                .build()
        }
        return this.kitiumGolemDispenserPattern!!
    }

    private fun getKitiumGolemPattern(): BlockPattern {
        if (this.kitiumGolemPattern == null) {
            this.kitiumGolemPattern = BlockPatternBuilder.start()
                .aisle("~^~", "###", "~#~")
                .where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE))
                .where(
                    '#',
                    CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.PINK_KITIUM_BLOCK))
                )
                .where('~') { pos: CachedBlockPosition -> pos.blockState.isAir }
                .build()
        }
        return this.kitiumGolemPattern!!
    }
}
