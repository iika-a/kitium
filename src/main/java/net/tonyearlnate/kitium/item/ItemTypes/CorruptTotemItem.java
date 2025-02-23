package net.tonyearlnate.kitium.item.ItemTypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class CorruptTotemItem extends Item {
    public CorruptTotemItem(Settings settings) {

        super(settings);
    }

    public static int negativeToZero(int test) {
        return (test >= 0) ? test : 0;
    }



    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        PlayerEntity p = (PlayerEntity) entity;
        LivingEntity e = ((PlayerEntity) entity).getAttacker();
        if (slot == 0 && e != null) {
            int urgency = (int)(20 - ((PlayerEntity) entity).getHealth())/5;

            e.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, negativeToZero(urgency)));
            if (urgency-2 >= 0) e.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10,urgency-2));
            if (!e.hasStatusEffect(StatusEffects.WITHER) && urgency-2 >= 0) e.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 600, urgency-2));

        }
    }
}
