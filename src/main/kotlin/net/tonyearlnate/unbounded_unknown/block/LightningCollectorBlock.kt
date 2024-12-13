package net.tonyearlnate.unbounded_unknown.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class LightningCollectorBlock(settings: Settings): Block(settings) {
    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {

    }

    override fun afterBreak(
        world: World?,
        player: PlayerEntity?,
        pos: BlockPos?,
        state: BlockState?,
        blockEntity: BlockEntity?,
        tool: ItemStack?
    ) {
        super.afterBreak(world, player, pos, state, blockEntity, tool)
    }
}