package net.tonyearlnate.unbounded_unknown;

import net.fabricmc.api.ModInitializer;

import net.tonyearlnate.unbounded_unknown.block.entity.ModBlockEntities;
import net.tonyearlnate.unbounded_unknown.block.ModBlocks;
import net.tonyearlnate.unbounded_unknown.entity.ModEntities;
import net.tonyearlnate.unbounded_unknown.item.ModItemGroups;
import net.tonyearlnate.unbounded_unknown.item.ModItems;
import net.tonyearlnate.unbounded_unknown.item.ModThrowables;
import net.tonyearlnate.unbounded_unknown.screen.ModScreenHandlers;
import net.tonyearlnate.unbounded_unknown.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnboundedUnknown implements ModInitializer {
	
	public static final String MOD_ID = "unbounded_unknown";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
		ModItemGroups.registerModItemGroups();
		ModWorldGeneration.generateModWorldGen();
		ModScreenHandlers.registerModScreenHandlers();
		ModThrowables.registerModThrowables();
		ModEntities.registerModEntities();
	}
}