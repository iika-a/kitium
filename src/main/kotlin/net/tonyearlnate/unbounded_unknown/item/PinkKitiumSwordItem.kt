package net.tonyearlnate.unbounded_unknown.item

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents

class PinkKitiumSwordItem(settings: Settings) : SwordItem(ModToolMaterials.PINK_KITIUM, 3.0f, -2.4f, settings) {
    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        target?.addStatusEffect(StatusEffectInstance(StatusEffects.SLOW_FALLING, 40, 1))
        if (target != null && target.health <= 0) {
            attacker?.world?.playSound(
                null,
                attacker.blockPos,
                SoundEvents.ENTITY_CAT_AMBIENT, //meow
                SoundCategory.PLAYERS,
                1.0f,
                1.0f
            )
        }
        return super.postHit(stack, target, attacker)
    }
}
