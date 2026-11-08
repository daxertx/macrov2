package net.project.macrov2.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider
{

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        // Ores/Blocks → RAW_PINK_GARNET
        offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 1f, 200, "pink_garnet");
        offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 1f, 100, "pink_garnet");

        // 9 item = 1 item + it can be reversed
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.PINK_GARNET,RecipeCategory.DECORATIONS,ModBlocks.PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,ModItems.RAW_PINK_GARNET,RecipeCategory.DECORATIONS,ModBlocks.RAW_PINK_GARNET_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COMPRESSED_STICK)
                .input(Items.STICK, 9)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, "compress_sticks_from_sticks");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 9)
                .input(ModItems.COMPRESSED_STICK)
                .criterion(hasItem(ModItems.COMPRESSED_STICK), conditionsFromItem(ModItems.COMPRESSED_STICK))
                .offerTo(exporter, "sticks_from_compress_stick");  // Unique ID

// Super compression/decompression
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUPER_COMPRESSED_STICK)
                .input(ModItems.COMPRESSED_STICK, 9)
                .criterion(hasItem(ModItems.COMPRESSED_STICK), conditionsFromItem(ModItems.COMPRESSED_STICK))
                .offerTo(exporter, "super_compress_stick_from_compress_sticks");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COMPRESSED_STICK, 9)
                .input(ModItems.SUPER_COMPRESSED_STICK)
                .criterion(hasItem(ModItems.SUPER_COMPRESSED_STICK), conditionsFromItem(ModItems.SUPER_COMPRESSED_STICK))
                .offerTo(exporter, "compress_sticks_from_super_compress_stick");
        //Shaped recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("LRL")
                .pattern("RPR")
                .pattern("LRL")
                .input('L', Blocks.LAPIS_BLOCK)
                .input('R', Blocks.REDSTONE_BLOCK)
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                // UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(Blocks.LAPIS_BLOCK), conditionsFromItem(Blocks.LAPIS_BLOCK))
                .criterion(hasItem(Blocks.REDSTONE_BLOCK), conditionsFromItem(Blocks.REDSTONE_BLOCK))
                .offerTo(exporter);
        //LAMP
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.PINK_GARNET_LAMP)
                .pattern("PPP")
                .pattern("PTP")
                .pattern("PPP")
                .input('P', ModItems.PINK_GARNET)
                .input('T', Blocks.REDSTONE_LAMP)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Blocks.REDSTONE_LAMP),conditionsFromItem(Blocks.REDSTONE_LAMP))
                .offerTo(exporter);
        //DOOR
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_DOOR, 3)
                .pattern("PP")
                .pattern("PP")
                .pattern("PP")
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))

                .offerTo(exporter);
                //button
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.PINK_GARNET_BUTTON)
                .pattern("P")
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))

                .offerTo(exporter);
        //stairs
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_STAIRS, 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))

                .offerTo(exporter);
        //SLAB
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLAB, 6)
                .pattern("PPP")
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))

                .offerTo(exporter);
        //PRESSURE PLATE
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_PRESSURE_PLATE, 1)
                .pattern("PP")
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))

                .offerTo(exporter);
        //FENCE
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_FENCE, 3)
                .pattern("PSP")
                .pattern("PSP")
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                .input('S', Items.STICK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        //FENCE GATE
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_FENCE_GATE)
                .pattern("SPS")
                .pattern("SPS")
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                .input('S', Items.STICK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        //TRAPDOOR
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_TRAPDOOR, 2)
                .pattern("PPP")
                .pattern("PPP")
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(exporter);
        //TOOLS
        //sword
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SWORD)
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" S ")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        //pickaxe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE)
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        //axe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE)
                .pattern("PS")
                .pattern("PS")
                .pattern(" S")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        //shovel
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL)
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        //hoe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE)
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HAMMER)
                .pattern("PPP")
                .pattern("PSP")
                .pattern(" S ")
                .input('P', ModItems.PINK_GARNET)
                .input('S', Items.STICK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        //ARMOR
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HELMET)
                .pattern("PPP")
                .pattern("P P")
                .input('P', ModItems.PINK_GARNET)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_CHESTPLATE)
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .input('P', ModItems.PINK_GARNET)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_LEGGINGS)
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .input('P', ModItems.PINK_GARNET)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_BOOTS)
                .pattern("P P")
                .pattern("P P")
                .input('P', ModItems.PINK_GARNET)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);
        //tree
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.DRIFTWOOD_PLANKS, 4)
                .input(ModBlocks.DRIFTWOOD_LOG)
                .criterion(hasItem(ModBlocks.DRIFTWOOD_LOG), conditionsFromItem(ModBlocks.DRIFTWOOD_LOG))
                .offerTo(exporter, "driftwood_planks_from_driftwood_log");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIFTWOOD_WOOD,3)
                .pattern("PP")
                .pattern("PP")
                .input('P', ModBlocks.DRIFTWOOD_LOG)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.DRIFTWOOD_LOG),conditionsFromItem(ModBlocks.DRIFTWOOD_LOG))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_DRIFTWOOD_WOOD,3)
                .pattern("PP")
                .pattern("PP")
                .input('P', ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.STRIPPED_DRIFTWOOD_LOG),conditionsFromItem(ModBlocks.STRIPPED_DRIFTWOOD_LOG))

                .offerTo(exporter);
        //
        offerSmithingTrimRecipe(exporter,ModItems.PINK_GARNET_SMITHING_TEMPLATE, Identifier.of(Macrov2.MOD_ID,"pink_garnet_smithing_template"));
    }
}
