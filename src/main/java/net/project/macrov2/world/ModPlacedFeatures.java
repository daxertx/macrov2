package net.project.macrov2.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.project.macrov2.Macrov2;

import java.util.List;

public class ModPlacedFeatures
{

    public static final RegistryKey<PlacedFeature> PINK_GARNET_ORE_PLACED_KEY = registerKey("pink_garnet_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_PINK_GARNET_ORE_PLACED_KEY = registerKey("nether_pink_garnet_ore_placed");
    public static final RegistryKey<PlacedFeature> END_PINK_GARNET_ORE_PLACED_KEY = registerKey("end_pink_garnet_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //uniform 80 TO -80 can spawn
        //trapezoid closer to 80 or -80 have more chance to get more pink garnet than farther away

        //overworld
        register(context,PINK_GARNET_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.PINK_GARNET_ORE_KEY),
                //veins per chunk is count
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80),YOffset.fixed(80))));
        //nether
        register(context,NETHER_PINK_GARNET_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_PINK_GARNET_ORE_KEY),
                //veins per chunk is count
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80),YOffset.fixed(80))));
        //end
        register(context,END_PINK_GARNET_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.END_PINK_GARNET_ORE_KEY),
                //veins per chunk is count
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80),YOffset.fixed(80))));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Macrov2.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    //bush gen only
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers)
    {
        register(context, key, configuration, List.of(modifiers));
    }
}
