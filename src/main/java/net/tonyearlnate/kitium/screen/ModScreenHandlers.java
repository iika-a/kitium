package net.tonyearlnate.kitium.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.tonyearlnate.kitium.Kitium;

public class ModScreenHandlers {
    public static final ScreenHandlerType<LightningCollectorBlockScreenHandler> LIGHTNING_COLLECTOR_BLOCK_SCREEN_HANDLER_TYPE = Registry
            .register(Registries.SCREEN_HANDLER, Identifier.of(Kitium.MOD_ID, "lightning_collector_screen_handler"), new ScreenHandlerType<>(LightningCollectorBlockScreenHandler::new, FeatureSet.empty()));


    public static void registerModScreenHandlers() {
        Kitium.LOGGER.info("Registering Screen Handlers for " + Kitium.MOD_ID);
    }
}
