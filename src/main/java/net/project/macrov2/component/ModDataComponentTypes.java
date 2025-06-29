package net.project.macrov2.component;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.project.macrov2.Macrov2;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", builder ->builder.codec(BlockPos.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator)
    {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Macrov2.MOD_ID,name),builderOperator.apply(ComponentType.builder()).build());
    }


    public static void registerDataComponentType()
    {
        Macrov2.LOGGER.info("Registering a data component types for "+Macrov2.MOD_ID);
    }
}
