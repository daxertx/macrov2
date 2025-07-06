package net.project.macrov2.enchantment;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.enchantment.custom.FreezeStrikerEnchantmentEffect;
import net.project.macrov2.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.project.macrov2.enchantment.custom.MiningFatigueEnchantmentEffect;
import net.project.macrov2.enchantment.custom.PoisenStrikerEnchantmentEffect;
import net.project.macrov2.item.ModItems;

public class ModEnchantments
{

    public static final RegistryKey<Enchantment> LIGHTNING_STRIKER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Macrov2.MOD_ID,"lightning_striker"));
    public static final RegistryKey<Enchantment> FREEZE_STRIKER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Macrov2.MOD_ID,"freeze_striker"));
    public static final RegistryKey<Enchantment> POISEN_STRIKER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Macrov2.MOD_ID,"poisen_striker"));
    public static final RegistryKey<Enchantment> MINING_FATIGUE = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Macrov2.MOD_ID,"mining_fatigue"));


    public static void bootstrap(Registerable<Enchantment> registerable)
    {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, LIGHTNING_STRIKER, Enchantment.builder(Enchantment.definition(
            //for what kind of weapon is enchantment weapons(Sword)
            items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
            items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
            //
            5,1,
            //
            Enchantment.leveledCost(5,7),
            Enchantment.leveledCost(25,9),
            //anvil cost
            2,
            AttributeModifierSlot.MAINHAND
        )).exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
          .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                  EnchantmentEffectTarget.VICTIM,new LightningStrikerEnchantmentEffect())
        );
        //
        register(registerable, FREEZE_STRIKER, Enchantment.builder(Enchantment.definition(
                                //for what kind of weapon is enchantment weapons(Sword)
                                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                                //
                                5,1,
                                //
                                Enchantment.leveledCost(5,7),
                                Enchantment.leveledCost(25,9),
                                //anvil cost
                                2,
                                AttributeModifierSlot.MAINHAND
                        )).exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                        .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                                EnchantmentEffectTarget.VICTIM,new FreezeStrikerEnchantmentEffect())
        );
        //
        register(registerable, POISEN_STRIKER, Enchantment.builder(Enchantment.definition(
                                //for what kind of weapon is enchantment weapons(Sword)
                                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                                //
                                5,4,
                                //
                                Enchantment.leveledCost(5,7),
                                Enchantment.leveledCost(25,9),
                                //anvil cost
                                2,
                                AttributeModifierSlot.MAINHAND
                        )).exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                        .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                                EnchantmentEffectTarget.VICTIM,new PoisenStrikerEnchantmentEffect())
        );
        //
        register(registerable, MINING_FATIGUE, Enchantment.builder(Enchantment.definition(
                                //for what kind of weapon is enchantment weapons(Sword)
                                items.getOrThrow(ItemTags.PICKAXES),
                                //
                                5,1,
                                //
                                Enchantment.leveledCost(5,7),
                                Enchantment.leveledCost(25,9),
                                //anvil cost
                                2,
                                AttributeModifierSlot.MAINHAND
                        )).exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                        .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER,
                                EnchantmentEffectTarget.VICTIM,new MiningFatigueEnchantmentEffect())
        );
    }

    public static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key,Enchantment.Builder builder)
    {
        registry.register(key,builder.build(key.getValue()));
    }
}
