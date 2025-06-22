package net.project.macrov2.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;

public class ModTags
{
    public static class Blocks
    {

        public static final TagKey<Block> TRANSFORMABLE_ITEMS = createTag("tramsformable_block");

        private static TagKey<Block> createTag(String name)
        {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Macrov2.MOD_ID, name));
        }
    }
    public static class Items
    {

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("tramsformable_item");

        private static TagKey<Item> createTag(String name)
        {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Macrov2.MOD_ID, name));
        }
    }
}
