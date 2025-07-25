package net.project.macrov2.item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.project.macrov2.Macrov2;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;


import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials
{

    public static final RegistryEntry<ArmorMaterial> PINK_GARNET_ARMOR_MATERIAL = registerArmorMaterial("pink_garnet",()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS,2);
        map.put(ArmorItem.Type.LEGGINGS,4);
        map.put(ArmorItem.Type.CHESTPLATE,6);
        map.put(ArmorItem.Type.HELMET,2);
        map.put(ArmorItem.Type.BODY,2);
    }),20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,() -> Ingredient.ofItems(ModItems.PINK_GARNET), List.of(new ArmorMaterial.Layer(Identifier.of(Macrov2.MOD_ID,"pink_garnet"))),0,0));

    public static final RegistryEntry<ArmorMaterial> SHADOW_ARMOR_MATERIAL = registerArmorMaterial("shadow",()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS,4);
        map.put(ArmorItem.Type.LEGGINGS,6);
        map.put(ArmorItem.Type.CHESTPLATE,8);
        map.put(ArmorItem.Type.HELMET,4);
        map.put(ArmorItem.Type.BODY,4);
    }),20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,() -> Ingredient.ofItems(Items.NETHERITE_INGOT), List.of(new ArmorMaterial.Layer(Identifier.of(Macrov2.MOD_ID,"shadow"))),0,0));

    public static final RegistryEntry<ArmorMaterial> IRON_MEN_ARMOR_MATERIAL = registerArmorMaterial("iron_men",()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS,6);
        map.put(ArmorItem.Type.LEGGINGS,8);
        map.put(ArmorItem.Type.CHESTPLATE,10);
        map.put(ArmorItem.Type.HELMET,6);
        map.put(ArmorItem.Type.BODY,6);
    }),20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,() -> Ingredient.ofItems(Items.NETHERITE_INGOT), List.of(new ArmorMaterial.Layer(Identifier.of(Macrov2.MOD_ID,"iron_men"))),0,0));

    //numbers are toughness and knokbackbily

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material)
    {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Macrov2.MOD_ID,name), material.get());
    }

}
