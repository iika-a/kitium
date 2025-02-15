package net.tonyearlnate.kitium.screen

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gl.ShaderProgramKeys
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.render.RenderLayer
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.tonyearlnate.kitium.Kitium


class LightningCollectorBlockScreen(handler: LightningCollectorBlockScreenHandler?, inventory: PlayerInventory?, title: Text?) : HandledScreen<LightningCollectorBlockScreenHandler?>(handler, inventory, title) {
    override fun drawBackground(context: DrawContext, delta: Float, mouseX: Int, mouseY: Int) {
        RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX)
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f)
        RenderSystem.setShaderTexture(0, TEXTURE)
        val x = (width - backgroundWidth) / 2
        val y = (height - backgroundHeight) / 2
        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x, y, 0f, 0f, backgroundWidth, backgroundHeight, 256, 256)
    }

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        renderBackground(context, mouseX, mouseY, delta)
        super.render(context, mouseX, mouseY, delta)
        drawMouseoverTooltip(context, mouseX, mouseY)
    }

    override fun init() {
        super.init()
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2
    }

    companion object {
        private val TEXTURE: Identifier = Identifier.of(Kitium.MOD_ID, "textures/gui/container/lightning_collector.png")
    }
}