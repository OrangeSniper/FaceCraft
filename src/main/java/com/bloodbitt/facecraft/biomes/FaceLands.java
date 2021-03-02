package com.bloodbitt.facecraft.biomes;

import com.bloodbitt.facecraft.biomeBuilder.TerraformBiomeBuilder;
import com.bloodbitt.facecraft.init.ModSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class FaceLands {
    static final BiomeTemplate FACE_LANDS = new BiomeTemplate(TerraformBiomeBuilder.create()
    .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_FACE_LANDS)
    .precipitation(Biome.RainType.RAIN)
    .category(Biome.Category.PLAINS)
    .temperature(5f)
    .scale(1f));
}
