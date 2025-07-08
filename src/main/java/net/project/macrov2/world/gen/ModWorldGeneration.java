package net.project.macrov2.world.gen;

public class ModWorldGeneration
{
    public static void generateModWorldGen()
    {
        //DOWN y lvl
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        //UP y lvl
    }
}
