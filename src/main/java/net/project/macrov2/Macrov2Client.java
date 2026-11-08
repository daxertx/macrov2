package net.project.macrov2;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.block.entity.ModBlockEntities;
import net.project.macrov2.block.entity.renderer.PedestalBlockEntityRenderer;
import net.project.macrov2.entity.ModEntities;
import net.project.macrov2.entity.client.*;
import net.project.macrov2.particle.AmmoParticle;
import net.project.macrov2.particle.ModParticles;
import net.project.macrov2.util.ModModelPredicates;


public class Macrov2Client implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        //can see through the trapdoor and door
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HONEY_BERRY_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR, RenderLayer.getCutout());


        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS,MantisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK,TomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.AMMO_PARTICLE, AmmoParticle.Factory::new);
    }
}
