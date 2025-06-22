package net.project.macrov2.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
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
        //smelting 1 of items in list gives raw pink garnet
        offerSmelting(exporter,PINK_GARNET_SMELTABLES, RecipeCategory.MISC,ModItems.RAW_PINK_GARNET,1f,200,"pink_garnet");
        offerBlasting(exporter,PINK_GARNET_SMELTABLES, RecipeCategory.MISC,ModItems.RAW_PINK_GARNET,1f,100,"pink_garnet");
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.MAGIC_BLOCK)
                .pattern("LRL")
                .pattern("RPR")
                .pattern("LRL")
                .input('L', Blocks.LAPIS_BLOCK)
                .input('R', Blocks.REDSTONE_BLOCK)
                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                //UNLOCK RECIPE CONDITIONS
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(Items.LAPIS_BLOCK),conditionsFromItem(Items.LAPIS_BLOCK))
                .criterion(hasItem(Items.REDSTONE_BLOCK),conditionsFromItem(Items.REDSTONE_BLOCK))
                .offerTo(exporter);

    }
}
