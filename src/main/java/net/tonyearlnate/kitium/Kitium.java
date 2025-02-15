package net.tonyearlnate.kitium;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.DispenserBlock;
import net.tonyearlnate.kitium.block.dispenser.LightningBottleDispenserBehavior;
import net.tonyearlnate.kitium.block.entity.ModBlockEntities;
import net.tonyearlnate.kitium.block.ModBlocks;
import net.tonyearlnate.kitium.entity.ModEntities;
import net.tonyearlnate.kitium.item.ModItemGroups;
import net.tonyearlnate.kitium.item.ModItems;
import net.tonyearlnate.kitium.item.ModThrowables;
import net.tonyearlnate.kitium.screen.ModScreenHandlers;
import net.tonyearlnate.kitium.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kitium implements ModInitializer {

	
	public static final String MOD_ID = "kitium";
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
		DispenserBlock.registerBehavior(ModThrowables.LIGHTNING_BOTTLE, new LightningBottleDispenserBehavior());
	}
}
