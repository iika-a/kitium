package net.tonyearlnate.unbounded_unknown.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;

public class ModEntities {
    public static final EntityType<LightningBottleEntity> LIGHTNING_BOTTLE_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(UnboundedUnknown.MOD_ID, "lightning_bottle"),
            EntityType.Builder.create(LightningBottleEntity::create, SpawnGroup.MISC).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(UnboundedUnknown.MOD_ID, "lightning_bottle")))
    );
    
	public static final EntityType<KitiumGolemEntity> KITIUM_GOLEM_ENTITY_TYPE = Registry.register(
			Registries.ENTITY_TYPE, Identifier.of(UnboundedUnknown.MOD_ID, "kitium_golem"),
			EntityType.Builder.create(KitiumGolemEntity::new, SpawnGroup.CREATURE)
					.dimensions(EntityType.ZOMBIE.getDimensions()).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,
							Identifier.of(UnboundedUnknown.MOD_ID, "kitium_golem"))));
// eclipse is awesome
    public static void registerModEntities() {
        UnboundedUnknown.LOGGER.info("Registering Entities for " + UnboundedUnknown.MOD_ID);
    }
}
