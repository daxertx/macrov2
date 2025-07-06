package net.project.macrov2.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.effect.ModEffects;

public class ModPotions
{

    public static final RegistryEntry<Potion> SLIMEY = registerPotion("slimey_potion",new Potion(new StatusEffectInstance(ModEffects.SLIMEY,800,0)));
    public static final RegistryEntry<Potion> GLOW = registerPotion("glow_potion",new Potion(new StatusEffectInstance(ModEffects.GLOW,1600,0)));


    public static void registerPotions()
    {
        Macrov2.LOGGER.info("registering potions for "+ Macrov2.MOD_ID);
    }

    private static RegistryEntry<Potion> registerPotion(String name,Potion potion)
    {
        return Registry.registerReference(Registries.POTION,Identifier.of(Macrov2.MOD_ID,name),potion);
    }
}
