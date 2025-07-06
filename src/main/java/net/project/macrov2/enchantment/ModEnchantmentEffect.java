package net.project.macrov2.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.enchantment.custom.FreezeStrikerEnchantmentEffect;
import net.project.macrov2.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.project.macrov2.enchantment.custom.PoisenStrikerEnchantmentEffect;

public class ModEnchantmentEffect
{

    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER = registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> FREEZE_STRIKER = registerEntityEffect("freeze_striker", FreezeStrikerEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> POISEN_STRIKER = registerEntityEffect("poisen_striker", PoisenStrikerEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,MapCodec<? extends EnchantmentEntityEffect> codec)
    {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Macrov2.MOD_ID,name),codec);
    }

    public static void registerEnchantmentEffect()
    {
        Macrov2.LOGGER.info("registering mod enchantments for "+Macrov2.MOD_ID);
    }

}
