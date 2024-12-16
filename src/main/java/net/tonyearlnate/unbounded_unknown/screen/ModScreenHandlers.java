package net.tonyearlnate.unbounded_unknown.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.tonyearlnate.unbounded_unknown.UnboundedUnknown;

public class ModScreenHandlers {
    public static final ScreenHandlerType<LightningCollectorBlockScreenHandler> LIGHTNING_COLLECTOR_BLOCK_SCREEN_HANDLER_TYPE = Registry
            .register(Registries.SCREEN_HANDLER, Identifier.of(UnboundedUnknown.MOD_ID, "lightning_collector_screen_handler"), new ScreenHandlerType<>(LightningCollectorBlockScreenHandler::new, FeatureSet.empty()));


    public static void registerModScreenHandlers() {
        UnboundedUnknown.LOGGER.info("Registering Screen Handlers for " + UnboundedUnknown.MOD_ID);
    }
}
