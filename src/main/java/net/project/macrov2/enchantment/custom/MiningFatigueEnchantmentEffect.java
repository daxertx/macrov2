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

public record MiningFatigueEnchantmentEffect() implements EnchantmentEntityEffect
{
    public static final MapCodec<MiningFatigueEnchantmentEffect> CODEC =
            MapCodec.unit(MiningFatigueEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos)
    {
        if (target instanceof LivingEntity livingEntity)
        {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 400, level - 1));
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec()
    {
        return CODEC;
    }
}
