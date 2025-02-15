package net.tonyearlnate.kitium.block.dispenser

import net.minecraft.block.DispenserBlock
import net.minecraft.block.dispenser.ItemDispenserBehavior
import net.minecraft.entity.SpawnReason
import net.minecraft.item.ItemStack
import net.minecraft.item.ThrowablePotionItem.POWER
import net.minecraft.util.math.BlockPointer
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Position
import net.minecraft.world.World
import net.tonyearlnate.kitium.entity.ModEntities

class LightningBottleDispenserBehavior : ItemDispenserBehavior() {
    override fun dispenseSilently(pointer: BlockPointer, stack: ItemStack): ItemStack {
        val world: World = pointer.world
        val position: Position = DispenserBlock.getOutputLocation(pointer)
        val direction: Direction = pointer.state.get(DispenserBlock.FACING)

        if (!world.isClient) {
            val lightningBottleEntity = ModEntities.LIGHTNING_BOTTLE_ENTITY_TYPE.create(world, SpawnReason.SPAWN_ITEM_USE)
           lightningBottleEntity!!.setPosition(position.x, position.y, position.z)

            lightningBottleEntity.setVelocity(direction.offsetX.toDouble(), direction.offsetY.toDouble(), direction.offsetZ.toDouble(), POWER, 1.0f)
            lightningBottleEntity.setItem(stack.copy())
            world.spawnEntity(lightningBottleEntity)
        }

        stack.decrement(1)
        return stack
    }
}