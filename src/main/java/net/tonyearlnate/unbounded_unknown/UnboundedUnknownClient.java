package net.tonyearlnate.unbounded_unknown;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.tonyearlnate.unbounded_unknown.screen.LightningCollectorBlockScreen;
import net.tonyearlnate.unbounded_unknown.screen.ModScreenHandlers;

@Environment(EnvType.CLIENT)
public class UnboundedUnknownClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.LIGHTNING_COLLECTOR_BLOCK_SCREEN_HANDLER_TYPE, LightningCollectorBlockScreen::new);
    }
}	
