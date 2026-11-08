package net.project.macrov2.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAttachments;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;

public class ModEffects
{

    public static final RegistryEntry<StatusEffect> SLIMEY = registerStatusEffect("slimey",new SlimeyEffect(StatusEffectCategory.NEUTRAL,0x00FF00)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,Identifier.of(Macrov2.MOD_ID,"slimey")
            ,-0.25f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    //25% slower in

    public static final RegistryEntry<StatusEffect> GLOW = registerStatusEffect("glow",new GlowEffect(StatusEffectCategory.NEUTRAL,0xFFCC66));


    private static RegistryEntry<StatusEffect> registerStatusEffect (String name,StatusEffect statusEffect)
    {
        return Registry.registerReference(Registries.STATUS_EFFECT,Identifier.of(Macrov2.MOD_ID,name),statusEffect);
    }

    public static void registerEffects()
    {
        Macrov2.LOGGER.info("registering effects for "+Macrov2.MOD_ID);
    }
}
