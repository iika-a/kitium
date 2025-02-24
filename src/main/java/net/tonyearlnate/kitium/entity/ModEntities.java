package net.tonyearlnate.kitium.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tonyearlnate.kitium.Kitium;

public class ModEntities {
    public static final EntityType<LightningBottleEntity> LIGHTNING_BOTTLE_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Kitium.MOD_ID, "lightning_bottle"),
            EntityType.Builder.create(LightningBottleEntity::create, SpawnGroup.MISC).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Kitium.MOD_ID, "lightning_bottle")))
    );
    
	public static final EntityType<KitiumGolemEntity> KITIUM_GOLEM_ENTITY_TYPE = Registry.register(
			Registries.ENTITY_TYPE, Identifier.of(Kitium.MOD_ID, "kitium_golem"),
			EntityType.Builder.create(KitiumGolemEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4F, 2.7F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,
							Identifier.of(Kitium.MOD_ID, "kitium_golem"))));


    public static void registerModEntities() {
        Kitium.LOGGER.info("Registering Entities for " + Kitium.MOD_ID);
        FabricDefaultAttributeRegistry.register(ModEntities.KITIUM_GOLEM_ENTITY_TYPE, KitiumGolemEntity.createKitiumGolemAttributes());
    }
}
