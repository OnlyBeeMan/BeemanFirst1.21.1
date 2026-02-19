package net.beeman.beemanfirst.world.gen;

import net.beeman.beemanfirst.BeemanFirst;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {

    // 1. A chave para a Dimensão (O Mundo em si)
    public static final RegistryKey<World> WEIRD_WORLD_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(BeemanFirst.MOD_ID, "weird_world"));

    // 2. A chave para o Tipo de Dimensão (As regras físicas)
    public static final RegistryKey<DimensionType> WEIRD_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(BeemanFirst.MOD_ID, "weird_type"));

    public static void registerModDimensions() {
        BeemanFirst.LOGGER.info("Registering Dimensions for " + BeemanFirst.MOD_ID);
    }
}
