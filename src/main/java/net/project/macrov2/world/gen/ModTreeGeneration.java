package net.project.macrov2.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.project.macrov2.world.ModPlacedFeatures;

public class ModTreeGeneration
{
    public static void generateTrees()
    {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS,BiomeKeys.CHERRY_GROVE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DRIFTWOOD_PLACED_KEY);
    }
}
