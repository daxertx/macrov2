package net.project.macrov2.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Macrov2.MOD_ID,"pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.macrov2.pink_garnet_items"))
                    .entries((displayContext, entries) ->
                    {
                        //adds items to item group
                        //items as ores
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        //
                        //nothing special
                        entries.add(ModItems.GAUNTLET);
                        //
                        //advanced items
                        entries.add(ModItems.CHISEL);
                        //
                        //foods
                        entries.add(ModItems.TOAST);
                        //
                        //fuels
                        entries.add(ModItems.COMPRESSED_STICK);
                        entries.add(ModItems.SUPER_COMPRESSED_STICK);
                        //tree
                        entries.add(ModBlocks.DRIFTWOOD_SAPLING.asItem());
                    })
                    .build());
    //
    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Macrov2.MOD_ID,"pink_garnet_block"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.macrov2.pink_garnet_blocks"))
                    .entries((displayContext, entries) ->
                    {
                        //adds items to item group
                        entries.add(ModBlocks.CHAIR);
                        entries.add(ModBlocks.PEDESTAL);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.PINK_GARNET_NETHER_ORE);
                        entries.add(ModBlocks.PINK_GARNET_END_ORE);

                        entries.add(ModBlocks.PINK_GARNET_STAIRS);
                        entries.add(ModBlocks.PINK_GARNET_SLAB);

                        entries.add(ModBlocks.PINK_GARNET_BUTTON);
                        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_WALL);

                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);
                        entries.add(ModBlocks.PINK_GARNET_LAMP);
                        //tree
                        entries.add(ModBlocks.DRIFTWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
                        entries.add(ModBlocks.DRIFTWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

                        entries.add(ModBlocks.DRIFTWOOD_LEAVES);
                        entries.add(ModBlocks.DRIFTWOOD_PLANKS);
                    })
                    .build());
    //tools item group
    public static final ItemGroup TOOLS = Registry.register(Registries.ITEM_GROUP, Identifier.of(Macrov2.MOD_ID,"tools"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET_SWORD))
                    .displayName(Text.translatable("itemgroup.macrov2.gears"))
                    .entries((displayContext, entries) ->
                    {
                        //tools:
                        entries.add(ModItems.GUN);
                        entries.add(ModItems.SHOTGUN);
                        entries.add(ModItems.AMMO);
                        entries.add(ModItems.SPECTRE_STAFF);
                        entries.add(ModItems.TOMAHAWK);
                        entries.add(ModItems.PINK_GARNET_SWORD);
                        entries.add(ModItems.PINK_GARNET_PICKAXE);
                        entries.add(ModItems.PINK_GARNET_AXE);
                        entries.add(ModItems.PINK_GARNET_SHOVEL);
                        entries.add(ModItems.PINK_GARNET_HOE);
                        entries.add(ModItems.PINK_GARNET_HAMMER);
                        entries.add(ModItems.KAUPEN_BOW);

                        entries.add(ModItems.PINK_GARNET_HELMET);
                        entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItems.PINK_GARNET_LEGGINGS);
                        entries.add(ModItems.PINK_GARNET_BOOTS);

                        entries.add(ModItems.SHADOW_HELMET);
                        entries.add(ModItems.SHADOW_CHESTPLATE);
                        entries.add(ModItems.SHADOW_LEGGINGS);
                        entries.add(ModItems.SHADOW_BOOTS);

                        entries.add(ModItems.IRON_MEN_HELMET);
                        entries.add(ModItems.IRON_MEN_CHESTPLATE);
                        entries.add(ModItems.IRON_MEN_LEGGINGS);
                        entries.add(ModItems.IRON_MEN_BOOTS);

                        entries.add(ModItems.PINK_GARNET_HORSE_ARMOR);
                    })
                    .build());
    public static final ItemGroup MISC = Registry.register(Registries.ITEM_GROUP, Identifier.of(Macrov2.MOD_ID,"misc"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DAN_MUSIC_2_MUSIC_DISC))
                    .displayName(Text.translatable("itemgroup.macrov2.misc"))
                    .entries((displayContext, entries) ->
                    {
                        //MUSIC DISK
                        entries.add(ModItems.DAN_MUSIC_1_MUSIC_DISC);
                        entries.add(ModItems.DAN_MUSIC_2_MUSIC_DISC);
                        entries.add(ModItems.CAULIFLOWER_SEEDS);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.HONEY_BERRIES);
                        entries.add(ModItems.COMPRESSED_STICK);
                        entries.add(ModItems.SUPER_COMPRESSED_STICK);
                        entries.add(ModItems.MANTIS_SPAWN_EGG);
                    })
                    .build());




    public static void registerItemGroups()
    {
        Macrov2.LOGGER.info("Registering Item Groups for" + Macrov2.MOD_ID);
    }
}
