package net.project.macrov2.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.project.macrov2.entity.ModEntities;

public class ModEntitySpawns
{
    public static void addSpawns()
    {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE,BiomeKeys.BAMBOO_JUNGLE,BiomeKeys.SPARSE_JUNGLE), SpawnGroup.CREATURE, ModEntities.MANTIS,30,2,3);

        SpawnRestriction.register(ModEntities.MANTIS, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
