package net.tonyearlnate.awesomemod;

import net.fabricmc.api.ModInitializer;

import net.tonyearlnate.awesomemod.block.ModBlocks;
import net.tonyearlnate.awesomemod.item.ModItemGroups;
import net.tonyearlnate.awesomemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AwesomeMod implements ModInitializer {
	
	public static final String MOD_ID = "awesome-mod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
	}
}