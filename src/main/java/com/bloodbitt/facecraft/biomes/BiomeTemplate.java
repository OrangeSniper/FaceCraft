package com.bloodbitt.facecraft.biomes;

import com.bloodbitt.facecraft.biomeBuilder.TerraformBiomeBuilder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;

import java.util.function.BiFunction;

public class BiomeTemplate {
    private final TerraformBiomeBuilder builder;

    public BiomeTemplate(TerraformBiomeBuilder builder) {
        this.builder = builder;
        builder.markTemplate();
    }

    public TerraformBiomeBuilder builder() {
        return new TerraformBiomeBuilder(this.builder);
    }
}
