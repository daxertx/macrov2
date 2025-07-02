package net.project.macrov2.trim;

import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.project.macrov2.Macrov2;
import net.project.macrov2.item.ModItems;

public class ModTrimPatterns
{
    public static final RegistryKey<ArmorTrimPattern> PINK_GARNET_TEMPLATE = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(Macrov2.MOD_ID, "pink_garnet_smithing_template"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.PINK_GARNET_SMITHING_TEMPLATE, PINK_GARNET_TEMPLATE);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(item),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }
}
