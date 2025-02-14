package net.tonyearlnate.unbounded_unknown.item

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem

class BlueKitiumSwordItem(settings: Settings) : SwordItem(ModToolMaterials.ENERGIZED_KITIUM, 3.0f, -2.4f, settings) {
    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        target?.addStatusEffect(StatusEffectInstance(StatusEffects.HUNGER, 40, 1))
        return super.postHit(stack, target, attacker)
    }
}
