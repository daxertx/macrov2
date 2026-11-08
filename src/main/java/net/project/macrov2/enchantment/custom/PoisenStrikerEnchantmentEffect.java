package net.project.macrov2.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record PoisenStrikerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<PoisenStrikerEnchantmentEffect> CODEC =
            MapCodec.unit(PoisenStrikerEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (target instanceof LivingEntity livingTarget)
        {
            switch (level)
            {
                case 1:
                    livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1));
                    break;
                case 2:
                    livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1));
                    break;
                case 3:
                    livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 2));
                    break;
                case 4:
                    livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 2));
                    break;
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
