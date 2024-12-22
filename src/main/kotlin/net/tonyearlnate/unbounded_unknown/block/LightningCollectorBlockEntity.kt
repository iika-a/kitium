package net.tonyearlnate.unbounded_unknown.block

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.LightningEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SidedInventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryWrapper
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import net.tonyearlnate.unbounded_unknown.block.entity.ModBlockEntities
import net.tonyearlnate.unbounded_unknown.item.ModThrowables
import net.tonyearlnate.unbounded_unknown.screen.LightningCollectorBlockScreenHandler


class LightningCollectorBlockEntity(pos: BlockPos, state: BlockState): BlockEntity(ModBlockEntities.LIGHTNING_COLLECTOR_BLOCK_ENTITY_TYPE, pos, state), NamedScreenHandlerFactory, SidedInventory {
    private var inventory: Inventory = SimpleInventory(2)

    fun onLightningStrike() {
        if (Registries.ITEM.getId(inventory.getStack(0).item) == Identifier.of("minecraft", "splash_potion")) {
            inventory.setStack(0, ItemStack.EMPTY)
            inventory.setStack(1, ItemStack(ModThrowables.LIGHTNING_BOTTLE))
        }
    }

    override fun clear() {
        for (i in 0 until size()) {
            inventory.setStack(i, ItemStack.EMPTY)
        }
    }

    override fun size(): Int = 2

    override fun isEmpty(): Boolean {
        return (0 until size()).all { inventory.getStack(it).isEmpty }
    }

    override fun getStack(slot: Int): ItemStack = inventory.getStack(slot)

    override fun removeStack(slot: Int, amount: Int): ItemStack {
        return inventory.removeStack(slot, amount)
    }

    override fun removeStack(slot: Int): ItemStack {
        return inventory.removeStack(slot)
    }

    override fun setStack(slot: Int, stack: ItemStack?) {
        inventory.setStack(slot, stack)
    }

    override fun canPlayerUse(player: PlayerEntity): Boolean {
        return pos.isWithinDistance(player.blockPos, 6.0)
    }

    override fun getAvailableSlots(side: Direction?): IntArray {
        return when (side) {
            Direction.UP -> intArrayOf()
            Direction.DOWN -> intArrayOf(1)
            else -> intArrayOf(0)
        }
    }

    override fun canInsert(slot: Int, stack: ItemStack?, dir: Direction?): Boolean {
        return dir != Direction.UP && dir != Direction.DOWN &&
                Registries.ITEM.getId(stack?.item) == Identifier.of("minecraft", "splash_potion") && slot == 0 && stack?.count == 1
    }

    override fun canExtract(slot: Int, stack: ItemStack?, dir: Direction?): Boolean {
        return dir == Direction.DOWN && slot == 1
    }

    override fun isValid(slot: Int, stack: ItemStack): Boolean {
        return when (slot) {
            0 -> stack.item == Items.SPLASH_POTION
            1 -> stack.item == Items.AIR
            else -> false
        }
    }

    override fun writeNbt(nbt: NbtCompound, registries: RegistryWrapper.WrapperLookup) {
        super.writeNbt(nbt, registries)
        for (i in 0..<inventory.size()) {
            if (inventory.getStack(i).isEmpty) return
            else nbt.put("inventory$i", inventory.getStack(i).toNbt(registries))
        }
    }

    override fun readNbt(nbt: NbtCompound, registries: RegistryWrapper.WrapperLookup) {
        super.readNbt(nbt, registries)
        for (i in 0..<inventory.size()) {
            if (nbt.contains("inventory$i")) {
                val itemStack = ItemStack.fromNbt(registries, nbt.get("inventory$i"))
                inventory.setStack(i, itemStack.orElse(ItemStack(Items.AIR)))
            }
        }
    }

    override fun createMenu(syncId: Int, playerInventory: PlayerInventory, player: PlayerEntity?): ScreenHandler {
        return LightningCollectorBlockScreenHandler(syncId, playerInventory, this)
    }

    override fun getDisplayName(): Text {
        return Text.translatable(cachedState.block.translationKey)
    }

    companion object {
        @Suppress("UNUSED_PARAMETER")
        @JvmStatic
        fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: LightningCollectorBlockEntity) {
            if (!world.isClient) {
                if (checkForLightning(world, pos)) blockEntity.onLightningStrike()
            }
        }

        private fun checkForLightning(world: World, blockPos: BlockPos): Boolean {
            val area = Box(blockPos.x.toDouble(), blockPos.y.toDouble(), blockPos.z.toDouble(), blockPos.x + 1.0, blockPos.y + 3.0, blockPos.z + 1.0)
            val entities = world.getEntitiesByClass(LightningEntity::class.java, area) { _ -> true }

            return entities.isNotEmpty()
        }
    }
}