package net.project.macrov2.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents
{
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200,3), 1).build();

    public static final FoodComponent TOAST = new FoodComponent.Builder().nutrition(4).saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 250), 0.25f).build();
}
