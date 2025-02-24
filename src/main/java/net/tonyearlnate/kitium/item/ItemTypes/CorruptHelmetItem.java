package net.tonyearlnate.kitium.item.ItemTypes;
import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.tonyearlnate.kitium.item.ModItems;
import java.util.List;

public class CorruptHelmetItem extends ArmorItem {
    public CorruptHelmetItem(ArmorMaterial material, EquipmentType type, Item.Settings settings) {

        super(material, type, settings);
    }

    public static boolean hasTag(PlayerEntity p) {

        for (String s : p.getCommandTags()) {
            if (s.equals("corrupted")) return true;
        }

        return false;
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        PlayerEntity p = (PlayerEntity) entity;

        Iterable<ItemStack> armorItems = p.getArmorItems();
        List<ItemStack> armorList = Lists.newArrayList(armorItems); // Convert to a list

        if (!hasTag(p) && armorList.get(3).getItem() == ModItems.CORRUPT_HELMET && armorList.get(2).getItem() == ModItems.CORRUPT_CHESTPLATE && armorList.get(1).getItem() == ModItems.CORRUPT_LEGGINGS && armorList.get(0).getItem() == ModItems.CORRUPT_BOOTS) {
            p.addCommandTag("corrupted");
            p.getWorld().playSound(null, p.getBlockPos(),
                    SoundEvents.ENTITY_ZOMBIE_VILLAGER_CONVERTED, SoundCategory.PLAYERS,
                    1f, 1.5f);
        }
        else if (hasTag(p) && !(armorList.get(3).getItem() == ModItems.CORRUPT_HELMET && armorList.get(2).getItem() == ModItems.CORRUPT_CHESTPLATE && armorList.get(1).getItem() == ModItems.CORRUPT_LEGGINGS && armorList.get(0).getItem() == ModItems.CORRUPT_BOOTS)) {
            p.removeCommandTag("corrupted");
        }

        if (hasTag(p)) {
            p.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 60, 1, false, false));
            p.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60, 0, false, false));
            if (p.getAttacker() != null)
                p.getAttacker().addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0, false, true));
            for (int i = 0; i < 3; i++) { // Adjust for more/less sparks
                double offsetX = (world.random.nextDouble() - 0.5)*2.0; // Random X (-0.5 to 0.5)
                double offsetY = (world.random.nextDouble()) * 1.5; // Random Y (0 to 1.5)
                double offsetZ = (world.random.nextDouble() - 0.5)*2.0; // Random Z (-0.5 to 0.5)

                world.addParticle(ParticleTypes.PORTAL, // Particle type
                        p.getX() + offsetX, p.getY() + offsetY, p.getZ() + offsetZ, // Position (X, Y, Z)
                        0, 0, 0 // Velocity (motionX, motionY, motionZ)
                );
            }

        }

    }
}
