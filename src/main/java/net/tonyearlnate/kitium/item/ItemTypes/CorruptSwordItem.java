package net.tonyearlnate.kitium.item.ItemTypes;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.tonyearlnate.kitium.entity.ModEntities;

public class CorruptSwordItem extends Item {
    public CorruptSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {

        super(material.applySwordSettings(settings, attackDamage, attackSpeed));
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getStackInHand(attacker.getActiveHand()).damage(1, (PlayerEntity)(attacker));
        return super.postHit(stack, target, attacker);
    }

    public static void moveEntityRelative(Entity user, Entity moved, double leftOffset, double upOffset, double forwardOffset) {
        // Get the user's yaw (horizontal rotation)
        float yaw = (float) Math.toRadians(user.getYaw()); // Convert degrees to radians

        // Calculate relative movement
        double offsetX = Math.sin(yaw) * forwardOffset + Math.cos(yaw) * leftOffset;
        double offsetY = upOffset; // Move up or down directly
        double offsetZ = Math.cos(yaw) * forwardOffset - Math.sin(yaw) * leftOffset;


        // Apply the new position
        Vec3d newPos = user.getPos().add(offsetX, offsetY, offsetZ);
        moved.setPosition(newPos);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        // Ensure we don't spawn the lightning only on the client.
        // This is to prevent desync.
        if (world.isClient) {
            return ActionResult.PASS;
        }

        WitherSkullEntity mainSkull = new WitherSkullEntity(EntityType.WITHER_SKULL, world);
        mainSkull.setPos(user.getX(), user.getY(), user.getZ());
        mainSkull.setCharged(true);
        mainSkull.setVelocity(user.getRotationVec(1.0f).multiply(4.0));
        mainSkull.velocityModified = true;

        moveEntityRelative(user, mainSkull, 0, 1.5 ,0);

        user.getWorld().spawnEntity(mainSkull);


        user.getStackInHand(hand).damage(5, user);
        return ActionResult.SUCCESS;
    }




}
