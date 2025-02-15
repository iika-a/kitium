package net.tonyearlnate.kitium.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.tonyearlnate.kitium.Kitium;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.tonyearlnate.kitium.block.LightningCollectorBlockEntity;
import net.tonyearlnate.kitium.block.ModBlocks;

public class ModBlockEntities {

    public static final BlockEntityType<LightningCollectorBlockEntity> LIGHTNING_COLLECTOR_BLOCK_ENTITY_TYPE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(Kitium.MOD_ID, "lightning_collector"),
            FabricBlockEntityTypeBuilder.create(LightningCollectorBlockEntity::new, ModBlocks.LIGHTNING_COLLECTOR).build()
    );

    public static void registerModBlockEntities() {
        Kitium.LOGGER.info("Registering Block Entities for " + Kitium.MOD_ID);
    }
}
