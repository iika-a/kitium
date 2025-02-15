package net.tonyearlnate.kitium.screen

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot

class LightningCollectorBlockScreenHandler @JvmOverloads constructor(
    syncId: Int,
    playerInventory: PlayerInventory,
    inventory: Inventory = SimpleInventory(2)
):
    ScreenHandler(ModScreenHandlers.LIGHTNING_COLLECTOR_BLOCK_SCREEN_HANDLER_TYPE, syncId) {
    private val inventory: Inventory

    init {
        checkSize(inventory, 2)
        this.inventory = inventory

        inventory.onOpen(playerInventory.player)

        this.addSlot(object : Slot(inventory, 0, 80, 17) {
            override fun canInsert(stack: ItemStack): Boolean {
                return inventory.isValid(0, stack)
            }
        })
        this.addSlot(object : Slot(inventory, 1, 80, 53) {
            override fun canInsert(stack: ItemStack): Boolean {
                return inventory.isValid(1, stack)
            }
        })

        var l: Int
        var m = 0
        while (m < 3) {
            l = 0
            while (l < 9) {
                this.addSlot(Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18))
                ++l
            }
            ++m
        }

        m = 0
        while (m < 9) {
            this.addSlot(Slot(playerInventory, m, 8 + m * 18, 142))
            ++m
        }
    }

    override fun canUse(player: PlayerEntity): Boolean {
        return inventory.canPlayerUse(player)
    }

    override fun quickMove(player: PlayerEntity, invSlot: Int): ItemStack {
        var newStack = ItemStack.EMPTY
        val slot = slots[invSlot]
        if (slot.hasStack()) {
            val originalStack = slot.stack
            newStack = originalStack.copy()
            if (invSlot < inventory.size()) {
                if (!this.insertItem(
                        originalStack,
                        inventory.size(), slots.size, true
                    )
                ) {
                    return ItemStack.EMPTY
                }
            } else if (!this.insertItem(originalStack, 0, inventory.size(), false)) {
                return ItemStack.EMPTY
            }

            if (originalStack.isEmpty) {
                slot.stack = ItemStack.EMPTY
            } else {
                slot.markDirty()
            }
        }

        return newStack
    }
}