package net.project.macrov2.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class AmmoParticle extends SpriteBillboardParticle
{

    public AmmoParticle(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider, double xspeed, double yspeed, double zspeed)
    {
        super(clientWorld, x, y, z,xspeed,yspeed,zspeed);

        this.velocityMultiplier = 0.8f;
        this.maxAge = 40;
        this.setSpriteForAge(spriteProvider);

    }

    @Override
    public ParticleTextureSheet getType()
    {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType>
    {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new AmmoParticle(world,x,y,z,this.spriteProvider,velocityX,velocityY,velocityZ);
        }
    }
}
