package net.project.macrov2.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.project.macrov2.Macrov2;
import net.project.macrov2.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators
{
    public static final SaplingGenerator DRIFTWOOD = new SaplingGenerator(Macrov2.MOD_ID+":driftwood", Optional.empty(),Optional.of(ModConfiguredFeatures.DRIFTWOOD_KEY),Optional.empty());
}
