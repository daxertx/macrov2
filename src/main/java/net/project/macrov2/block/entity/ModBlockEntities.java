package net.project.macrov2.block.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.block.ModBlocks;
import net.project.macrov2.block.entity.custom.PedestalBlockEntity;

public class ModBlockEntities
{
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Macrov2.MOD_ID,"pedestal_be"),BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build());

    public static void registerBlockEntities()
    {
        Macrov2.LOGGER.info("registering block entities for "+Macrov2.MOD_ID);
    }
}

