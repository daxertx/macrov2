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

public record FreezeStrikerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<FreezeStrikerEnchantmentEffect> CODEC =
            MapCodec.unit(FreezeStrikerEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (target instanceof LivingEntity livingTarget) {
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, level));
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 60, level));
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, level));
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 60, level));
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
