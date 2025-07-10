package net.project.macrov2.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.project.macrov2.Macrov2;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.entity.ModEntities;
import net.project.macrov2.item.custom.ChiselItem;
import net.project.macrov2.item.custom.HammerItem;
import net.project.macrov2.item.custom.ModArmorItem;
import net.project.macrov2.item.custom.TomahawkItem;
import net.project.macrov2.sounds.ModSounds;


import java.util.List;

public class ModItems {
    //items
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item GAUNTLET = registerItem("gauntlet", new Item(new Item.Settings()));
    //
    //
    //foods
    public static final Item TOAST = registerItem("toast", new Item(new Item.Settings().food(ModFoodComponents.TOAST)));
    //
    // fuels
    public static final Item COMPRESSED_STICK = registerItem("compressed_stick",new Item(new Item.Settings()));
    public static final Item SUPER_COMPRESSED_STICK = registerItem("super_compressed_stick",new Item(new Item.Settings()));
    //
    //tools
    public static final Item KAUPEN_BOW = registerItem("kaupen_bow",new BowItem(new Item.Settings().maxDamage(500)));
    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",new SwordItem(ModToolMaterials.PINK_GARNET,new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,3,-2.4f))));
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",new PickaxeItem(ModToolMaterials.PINK_GARNET,new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,1,-2.8f))));
    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",new AxeItem(ModToolMaterials.PINK_GARNET,new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,6,-3.2f))));
    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",new ShovelItem(ModToolMaterials.PINK_GARNET,new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,1.5f,-3.0f))));
    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",new HoeItem(ModToolMaterials.PINK_GARNET,new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,0,-3.0f))));
    //
    //advanced item
    public static final Item CHISEL = registerItem("chisel",new ChiselItem(new Item.Settings().maxDamage(50)));
    //
    //second advanced item
    public static final Item PINK_GARNET_HAMMER = registerItem("pink_garnet_hammer",new HammerItem(ModToolMaterials.PINK_GARNET,new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET,7,-3.5f))));
    //armor
    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",new ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,ArmorItem.Type.HELMET,new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,ArmorItem.Type.CHESTPLATE,new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings",new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,ArmorItem.Type.LEGGINGS,new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,ArmorItem.Type.BOOTS,new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    //horse armor
    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor",new AnimalArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,AnimalArmorItem.Type.EQUESTRIAN,false,new Item.Settings().maxCount(1).rarity(Rarity.RARE)));
    //trims
    public static final Item PINK_GARNET_SMITHING_TEMPLATE = registerItem("pink_garnet_smithing_template", SmithingTemplateItem.of(Identifier.of(Macrov2.MOD_ID,"pink_garnet_smithing_template"), FeatureFlags.VANILLA));
    //music disk
    public static final Item DAN_MUSIC_1_MUSIC_DISC = registerItem("dan_music_1_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.DAN_MUSIC_1_KEY).maxCount(1)));
    public static final Item DAN_MUSIC_2_MUSIC_DISC = registerItem("dan_music_2_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.DAN_MUSIC_2_KEY).maxCount(1)));
    //seed
    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP,new Item.Settings()));
    //berry
    public static final Item HONEY_BERRIES = registerItem("honey_berries", new AliasedBlockItem(ModBlocks.HONEY_BERRY_BUSH,new Item.Settings().food(ModFoodComponents.HONEY_BERRY)));
    //spawn egg
    public static final Item MANTIS_SPAWN_EGG = registerItem("mantis_spawn_egg", new SpawnEggItem(ModEntities.MANTIS,0x3fc35,0x04f10,new Item.Settings()));
    //advanced rightable item
    public static final Item TOMAHAWK = registerItem("tomahawk",new TomahawkItem(new Item.Settings().maxCount(16)));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.macrov2.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(Macrov2.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Macrov2.LOGGER.info("Registering Mod Items for " + Macrov2.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            //adds it to creative mod tab
            //items:

            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.add(GAUNTLET);
            entries.add(TOMAHAWK);
            //foods:
            entries.add(TOAST);
            //fuels:
            entries.add(COMPRESSED_STICK);
            entries.add(SUPER_COMPRESSED_STICK);
            //tools:
            entries.add(PINK_GARNET_SWORD);
            entries.add(PINK_GARNET_PICKAXE);
            entries.add(PINK_GARNET_AXE);
            entries.add(PINK_GARNET_SHOVEL);
            entries.add(PINK_GARNET_HOE);
            entries.add(PINK_GARNET_SMITHING_TEMPLATE);
            //crop
            entries.add(CAULIFLOWER_SEEDS);
            //spawm egg
            entries.add(MANTIS_SPAWN_EGG);
        });
    }
}