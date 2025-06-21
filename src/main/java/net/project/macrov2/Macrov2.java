package net.project.macrov2;

import net.fabricmc.api.ModInitializer;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.item.ModItemGroups;
import net.project.macrov2.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class Macrov2 implements ModInitializer {
	public static final String MOD_ID ="macrov2";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}