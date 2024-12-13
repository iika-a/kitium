package net.tonyearlnate.unbounded_unknown.block;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModBlockEntities {

    public static final BlockEntityType<LightningCollectorBlockEntity> MY_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, Identifier.of("modid", "my_block"),
                    BlockEntityType.Builer.create(MyBlockEntity::new, MY_BLOCK).build(null));


    public static void registerModBlockEntities() {
        UnboundedUnknown.LOGGER.info("Registering Block Entities for" + UnboundedUnknown.MOD_ID);
    }
}
