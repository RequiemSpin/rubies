package rs.rubies;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs.rubies.block.ModBlocks;
import rs.rubies.item.ModInvTabs;
import rs.rubies.item.ModItems;

public class Rubies implements ModInitializer {
	public static final String MOD_ID = "rubies";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Mod - " + MOD_ID);

		ModInvTabs.registerModInvTabs();

		ModItems.registerModItems();
		ModBlocks.registerMobBlocks();
	}
}