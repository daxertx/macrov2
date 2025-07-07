package net.project.macrov2.block;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.project.macrov2.Macrov2;
import net.project.macrov2.block.custom.CauliflowerCropBlock;
import net.project.macrov2.block.custom.HoneyBerryBushBlock;
import net.project.macrov2.block.custom.MagicBlock;
import net.project.macrov2.block.custom.PinkGarnetLampBlock;
import net.project.macrov2.item.ModItems;
import net.project.macrov2.sounds.ModSounds;

public class ModBlocks {
    //blocks code start
    //create block and give it settings
    public static final Block DIDDY_BLOCK = registerBlock("diddy_block", new Block(AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(BlockSoundGroup.HONEY)));
    //
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3,6), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block PINK_GARNET_END_ORE = registerBlock("pink_garnet_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(7f).requiresTool()));
    public static final Block PINK_GARNET_NETHER_ORE = registerBlock("pink_garnet_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    //
    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
        new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));





    //blocks code ends

    public static final Block MAGIC_BLOCK = registerBlock("magic_block", new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",new PinkGarnetLampBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().luminance
            (State -> State.get(PinkGarnetLampBlock.LAMP_ON) ?
                    15
                    //TRUE
                    :
                    //FALSE
                    0
                    )));
    //crop
    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem("cauliflower_crop",new CauliflowerCropBlock(AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));
    //bush
    //same settings as a sweet berry bush
    public static final Block HONEY_BERRY_BUSH = registerBlockWithoutBlockItem("honey_berry_bush",new HoneyBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    private static Block registerBlockWithoutBlockItem(String name, Block block)
    {
        return Registry.register(Registries.BLOCK, Identifier.of(Macrov2.MOD_ID,name), block);
    }
    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(Macrov2.MOD_ID,name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(Macrov2.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        Macrov2.LOGGER.info("Register Mod Blocks for "+Macrov2.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            //adds the block to the creative menu as a building block

            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);

            entries.add(PINK_GARNET_ORE);
            entries.add(PINK_GARNET_DEEPSLATE_ORE);
            //entries.add(ModBlocks.PINK_GARNET_NETHER_ORE);
            //entries.add(ModBlocks.PINK_GARNET_END_ORE);

            entries.add(ModBlocks.MAGIC_BLOCK);

            entries.add(ModBlocks.DIDDY_BLOCK);


        });

    }

}
