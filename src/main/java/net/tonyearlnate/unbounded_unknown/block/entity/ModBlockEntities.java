package net.tonyearlnate.unbounded_unknown.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.tonyearlnate.unbounded_unknown.block.LightningCollectorBlockEntity;
import net.tonyearlnate.unbounded_unknown.block.ModBlocks;

public class ModBlockEntities {

    public static final BlockEntityType<LightningCollectorBlockEntity> LIGHTNING_COLLECTOR_BLOCK_ENTITY_TYPE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(UnboundedUnknown.MOD_ID, "lightning_collector"),
            FabricBlockEntityTypeBuilder.create(LightningCollectorBlockEntity::new, ModBlocks.LIGHTNING_COLLECTOR).build()
    );

    public static void registerModBlockEntities() {
        UnboundedUnknown.LOGGER.info("Registering Block Entities for " + UnboundedUnknown.MOD_ID);
    }
}
