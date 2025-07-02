package net.project.macrov2.trim;

import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.*;
import net.minecraft.text.Style;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.project.macrov2.Macrov2;
import net.project.macrov2.item.ModItems;

import java.util.Map;

public class ModTrimMaterials
{
    public static final RegistryKey<ArmorTrimMaterial> PINK_GARNET = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(Macrov2.MOD_ID, "pink_garnet"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable)
    {
        register(registerable, PINK_GARNET, Registries.ITEM.getEntry(ModItems.PINK_GARNET), Style.EMPTY.withColor(TextColor.parse("#b03fe0").getOrThrow()), 1.0f);

    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey, RegistryEntry<Item> item, Style style, float itemModelIndex)
    {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(), Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}