/*package net.tonyearlnate.unbounded_unknown.screen

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.tonyearlnate.unbounded_unknown.block.LightningCollectorBlockEntity

class LightningCollectorBlockScreenHandler(syncId: Int, playerInventory: PlayerInventory?) : ScreenHandler(ModScreenHandlers.LIGHTNING_COLLECTOR_BLOCK_SCREEN_HANDLER_TYPE, syncId) {
    override fun quickMove(player: PlayerEntity, slot: Int): ItemStack? {
        return null
    }

    override fun canUse(player: PlayerEntity): Boolean {
        return false
    }
}*/