package github.bloodbitt.facecraft.biomes;

import github.bloodbitt.facecraft.init.ModBlocks;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.function.Supplier;

public class FaceLands {

    public static SurfaceBuilderConfig facelandsConfig = new SurfaceBuilderConfig(ModBlocks.FACE_BLOCK.get().getDefaultState(), ModBlocks.FACE_BLOCK.get().getDefaultState(), ModBlocks.FACE_BLOCK.get().getDefaultState());
    public static Supplier<SurfaceBuilderConfig> e = () -> facelandsConfig;

    public static Biome makeFaceLands() {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder((ConfiguredSurfaceBuilder<?>) e);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Features.VOID_START_PLATFORM);
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.1F).scale(1).temperature(0.5F).downfall(0.5F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(1).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(MobSpawnInfo.EMPTY).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }
}
