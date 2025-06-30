package net.project.macrov2;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.component.ModDataComponentTypes;
import net.project.macrov2.item.ModItemGroups;
import net.project.macrov2.item.ModItems;
import net.project.macrov2.item.custom.HammerItem;
import net.project.macrov2.util.HammerUsageEvent;
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
		ModDataComponentTypes.registerDataComponentType();
		//fuels
		FuelRegistry.INSTANCE.add(ModItems.COMPRESSED_STICK,900);
		FuelRegistry.INSTANCE.add(ModItems.SUPER_COMPRESSED_STICK,8100);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}