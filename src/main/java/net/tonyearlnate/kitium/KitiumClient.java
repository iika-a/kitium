package net.tonyearlnate.kitium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.tonyearlnate.kitium.entity.KitiumGolemEntity;
import net.tonyearlnate.kitium.entity.KitiumGolemEntityRenderer;
import net.tonyearlnate.kitium.entity.ModEntities;
import net.tonyearlnate.kitium.screen.LightningCollectorBlockScreen;
import net.tonyearlnate.kitium.screen.ModScreenHandlers;

@Environment(EnvType.CLIENT)
public class KitiumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.LIGHTNING_COLLECTOR_BLOCK_SCREEN_HANDLER_TYPE, LightningCollectorBlockScreen::new);
        EntityRendererRegistry.register(ModEntities.LIGHTNING_BOTTLE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.KITIUM_GOLEM_ENTITY_TYPE, KitiumGolemEntityRenderer::new);
        FabricDefaultAttributeRegistry.register(ModEntities.KITIUM_GOLEM_ENTITY_TYPE, KitiumGolemEntity.createKitiumGolemAttributes());
    }
}	
