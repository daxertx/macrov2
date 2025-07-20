package net.project.macrov2.util;


import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.project.macrov2.item.ModItems;

public class ModLootTableModifiers
{
    private static final Identifier GRASS_BLOCK_ID = Identifier.of("minecraft", "blocks/short_grass");
    private static final Identifier CREEPER_ID = Identifier.of("minecraft", "entities/creeper");

    public static void modifyLootTables()
    {
        //.MODIFY ADD .REPLACE REPLACES THE ORIGINAL LOOT TABLE
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) ->
        {
            //from short glass block broken
            if(GRASS_BLOCK_ID.equals(key.getValue()))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f)) //25%
                        .with(ItemEntry.builder(ModItems.CAULIFLOWER_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            //from igloo chest
            if(LootTables.IGLOO_CHEST_CHEST.equals(key))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) //100%
                        .with(ItemEntry.builder(ModItems.CHISEL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            //from killing creeper
            if(CREEPER_ID.equals(key.getValue()))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f)) //75%
                        .with(ItemEntry.builder(ModItems.CAULIFLOWER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}