package net.tonyearlnate.unbounded_unknown.block

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryWrapper
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown
import net.tonyearlnate.unbounded_unknown.item.ModItems


class LightningCollectorBlockEntity(pos: BlockPos, state: BlockState) : BlockEntity(ModBlockEntities.LIGHTNING_COLLECTOR_BLOCK_ENTITY_TYPE, pos, state) {
    private val ALLOWED_ITEM_1 = Identifier.of("minecraft", "glass_bottle")
    private val ALLOWED_ITEM_2 = Identifier.of(UnboundedUnknown.MOD_ID, "lightning_in_a_bottle")
    private var inventory: Inventory = SimpleInventory(1)

    fun tryAddItem(itemStack: ItemStack): Boolean {
        if (isAllowedItem(itemStack)) {
            inventory.setStack(0, itemStack.copy())
            markDirty()
            return true
        }
        return false
    }

    private fun isAllowedItem(itemStack: ItemStack): Boolean {
        val itemId = Registries.ITEM.getId(itemStack.item)
        return itemId == ALLOWED_ITEM_1 || itemId == ALLOWED_ITEM_2
    }

    fun onLightningStrike() {
        if (Registries.ITEM.getId(inventory.getStack(0).item) == ALLOWED_ITEM_1) {
            inventory.setStack(0, ItemStack(ModItems.LIGHTNING_IN_A_BOTTLE))
        }
    }

    override fun writeNbt(nbt: NbtCompound, registries: RegistryWrapper.WrapperLookup) {
        super.writeNbt(nbt, registries)
        nbt.put("inventory", inventory.getStack(0).toNbt(registries))
    }

    override fun readNbt(nbt: NbtCompound, registries: RegistryWrapper.WrapperLookup) {
        super.readNbt(nbt, registries)
        if (nbt.contains("inventory")) {
            val itemStack = ItemStack.fromNbt(registries, nbt.get("Inventory"))
            inventory.setStack(0, itemStack.orElse(ItemStack(Items.AIR)))
        }
    }
}