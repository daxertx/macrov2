package net.project.macrov2.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.project.macrov2.Macrov2;
import net.project.macrov2.entity.custom.ChairEntity;
import net.project.macrov2.entity.custom.MantisEntity;
import net.project.macrov2.entity.custom.TomahawkProjectileEntity;

public class ModEntities
{

    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE,Identifier.of(Macrov2.MOD_ID,"mantis"),EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE).dimensions(1.5f,2.5f).build());

    public static final EntityType<TomahawkProjectileEntity> TOMAHAWK = Registry.register(Registries.ENTITY_TYPE,Identifier.of(Macrov2.MOD_ID,"tomahawk"),EntityType.Builder.<TomahawkProjectileEntity>create(TomahawkProjectileEntity::new, SpawnGroup.MISC).dimensions(0.5f,1.15f).build());

    public static final EntityType<ChairEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE,Identifier.of(Macrov2.MOD_ID,"chair"),EntityType.Builder.create(ChairEntity::new, SpawnGroup.MISC).dimensions(0.5f,0.5f).build());

    public static void registerModEntities()
    {
        Macrov2.LOGGER.info("registering mod entities for "+Macrov2.MOD_ID);
    }

}
