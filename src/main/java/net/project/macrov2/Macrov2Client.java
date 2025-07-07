package net.project.macrov2;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.util.ModModelPredicates;

import javax.swing.*;

public class Macrov2Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //can see through the trapdoor and door
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();

    }
}
