package net.project.macrov2.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.project.macrov2.world.ModPlacedFeatures;

public class ModOreGeneration
{
    public static void generateOres()
    {

        //in specific biome need to BiomeSelectors.includeByKey(BiomeKeys.FOREST,BIOME2,3,4,5)

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.PINK_GARNET_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NETHER_PINK_GARNET_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.END_PINK_GARNET_ORE_PLACED_KEY);

    }
}
