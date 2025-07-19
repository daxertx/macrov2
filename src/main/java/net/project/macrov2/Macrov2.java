package net.project.macrov2;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.component.ModDataComponentTypes;
import net.project.macrov2.effect.ModEffects;
import net.project.macrov2.enchantment.ModEnchantmentEffect;
import net.project.macrov2.entity.ModEntities;
import net.project.macrov2.entity.custom.MantisEntity;
import net.project.macrov2.item.ModItemGroups;
import net.project.macrov2.item.ModItems;
import net.project.macrov2.particle.ModParticles;
import net.project.macrov2.potion.ModPotions;
import net.project.macrov2.sounds.ModSounds;
import net.project.macrov2.util.HammerUsageEvent;
import net.project.macrov2.util.ModLootTableModifiers;
import net.project.macrov2.villager.ModVillagers;
import net.project.macrov2.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class Macrov2 implements ModInitializer
{
	public static final String MOD_ID ="macrov2";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		//registering
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentType();

		ModSounds.registerSounds();

		ModEffects.registerEffects();

		ModPotions.registerPotions();

		ModEnchantmentEffect.registerEnchantmentEffect();

		ModEntities.registerModEntities();

		ModWorldGeneration.generateModWorldGen();


		ModVillagers.registerVillagers();

		ModParticles.registerParticles();

		ModLootTableModifiers.modifyLootTables();
		//fuels
		FuelRegistry.INSTANCE.add(ModItems.COMPRESSED_STICK,900);
		FuelRegistry.INSTANCE.add(ModItems.SUPER_COMPRESSED_STICK,8100);
		//
 		//hammer used
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		//



		//brewing
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
		{
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY);
			builder.registerPotionRecipe(Potions.AWKWARD, Items.GLOWSTONE, ModPotions.GLOW);
		});
		//compost
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER,0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS,0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.HONEY_BERRIES,0.25f);

		//can be right-clicked with axe
		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG,ModBlocks.STRIPPED_DRIFTWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD,ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
		//CAN SET ON FIRE
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD,5,5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES,30,60);






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


		//

		FabricDefaultAttributeRegistry.register(ModEntities.MANTIS, MantisEntity.createAttributes());
		//villager trades
		//lvl 1
		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER,1, factories ->
		{
			factories.add(((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,7),
					new ItemStack(ModItems.DAN_MUSIC_1_MUSIC_DISC,1),2,7,0.1f)));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER,1, factories ->
		{
			factories.add(((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,11),
					new ItemStack(ModItems.DAN_MUSIC_2_MUSIC_DISC,1),2,7,0.1f)));
		});
		//lvl 2
		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER,2, factories ->
		{
			factories.add(((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,6),
					new ItemStack(ModItems.PINK_GARNET_SMITHING_TEMPLATE,1),1,7,0.2f)));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER,2, factories ->
		{
			factories.add(((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,3),
					new ItemStack(ModItems.HONEY_BERRIES,1),99,7,0.01f)));
		});
		//lvl 3
		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER,3, factories ->
		{
			factories.add(((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,20),
					new ItemStack(ModItems.CHISEL,1),1,7,0.1f)));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER,3, factories ->
		{
			factories.add(((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,3),
					new ItemStack(ModItems.TOAST,2),99,7,0.01f)));
		});
		//
	}
}