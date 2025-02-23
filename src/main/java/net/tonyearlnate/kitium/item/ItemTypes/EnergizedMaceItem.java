package net.tonyearlnate.kitium.item.ItemTypes;


import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.Random;

public class EnergizedMaceItem extends Item {
    public EnergizedMaceItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {

        super(material.applySwordSettings(settings, attackDamage, attackSpeed));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        LightningEntity l = new LightningEntity(EntityType.LIGHTNING_BOLT, target.getWorld());
        l.setPos(target.getX(), target.getY(), target.getZ());
        Random r = new Random();

        if (r.nextInt(4)+1 == 4) {
            target.getWorld().spawnEntity(l);
            attacker.heal(2);
        }
        else {
            l.discard();
        }
        attacker.getStackInHand(attacker.getActiveHand()).damage(1, (PlayerEntity)(attacker));
        return super.postHit(stack, target, attacker);
    }
}
