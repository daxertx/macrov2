package net.project.macrov2.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class GlowEffect extends StatusEffect
{
    protected GlowEffect(StatusEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier)
    {

        entity.setGlowing(true);

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }

    public void onRemoved(LivingEntity entity, int amplifier)
    {
        //when effect is gone glowing effect also
        entity.setGlowing(false);
    }
}
