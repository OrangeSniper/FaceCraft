package io.github.bloodbitt.facecraft.biomes;

import io.github.bloodbitt.facecraft.init.ModBlocks;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class FaceFlats {


    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> func_244192_a(String p_244192_0_, ConfiguredSurfaceBuilder<SC> p_244192_1_) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, p_244192_0_, p_244192_1_);
    }

    public static SurfaceBuilderConfig faceflatsconfig = new SurfaceBuilderConfig(ModBlocks.FACE_BLOCK.get().getDefaultState(), ModBlocks.BALD_FACE_BLOCK.get().getDefaultState(), ModBlocks.FACE_BLOCK.get().getDefaultState());
    public static ConfiguredSurfaceBuilder e = new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT, faceflatsconfig);
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> face_flats = func_244192_a("faceflats",  e);


    public static Biome makeFaceFlats() {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(face_flats);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_REDSTONE);
        biomegenerationsettings$builder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.field_243767_a);
        biomegenerationsettings$builder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.field_243768_b);
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(1).scale(0.1f).temperature(0.5F).downfall(0.5F).setEffects((new BiomeAmbience.Builder()).setWaterColor(61131304).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(1).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(MobSpawnInfo.EMPTY).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }
}
