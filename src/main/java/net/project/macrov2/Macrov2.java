package net.project.macrov2;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.component.ModDataComponentTypes;
import net.project.macrov2.item.ModItemGroups;
import net.project.macrov2.item.ModItems;
import net.project.macrov2.item.custom.HammerItem;
import net.project.macrov2.sounds.ModSounds;
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
		ModSounds.registerSounds();















		//RUNS BOTH IN CLIENT AND SERVER CODE WILL RUN 2TIMES SO WE WILL ONLY RUN THE INSIDE CODE IN THE CLIENT IN IF
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) ->
		{
			if(entity instanceof SheepEntity sheepEntity && !world.isClient)
			{
				if(player.getMainHandStack().getItem()== Items.END_ROD)
				{
					player.sendMessage(Text.literal("the player hit a sheep with a end rod"));
					player.getMainHandStack().decrement(1);
					//give sheep speed effect lvl 3 for 70 game ticks
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,70,3));
				}
				return ActionResult.PASS;
			}
			return ActionResult.PASS;
		});
	}
}