package net.project.macrov2.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;

public class ModParticles
{

    public static final SimpleParticleType AMMO_PARTICLE = registerParticle("ammo_particle", FabricParticleTypes.simple(true));

    private static SimpleParticleType registerParticle(String name,SimpleParticleType simpleParticleType)
    {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Macrov2.MOD_ID,name),simpleParticleType);
    }

    public static void registerParticles()
    {
        Macrov2.LOGGER.info("registering particles for "+Macrov2.MOD_ID);
    }
}
