package io.github.bloodbitt.facecraft.world.gen;
import io.github.bloodbitt.facecraft.FaceCraft;
import io.github.bloodbitt.facecraft.biomes.FaceLands;
import io.github.bloodbitt.facecraft.init.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.ArrayList;

/**
 * Ore generation
 * @author TechOFreak
 *
 */

@Mod.EventBusSubscriber
public class ModOreGen {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> faceOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres(){
        //BASE_STONE_OVERWORLD is for generating in stone, granite, diorite, and andesite
        //NETHERRACK is for generating in netherrack
        //BASE_STONE_NETHER is for generating in netherrack, basalt and blackstone

        //Overworld Ore Register
        overworldOres.add(register("face_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.FACE_ORE.get().getDefaultState(), 6)) //Vein Size
                .range(64).square() //Spawn height start
                .func_242731_b(50))); //Chunk spawn frequency

        faceOres.add(register("face_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.FACE_ORE.get().getDefaultState(), 6)) //Vein Size
                .range(0).square() //Spawn height start
                .func_242731_b(100))); //Chunk spawn frequency
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : netherOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if(event.getCategory().equals(Biome.Category.THEEND)){
            for(ConfiguredFeature<?, ?> ore : endOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if(event.getName() == new ResourceLocation("facecraft", "face_lands") || event.getName() == new ResourceLocation("facecraft", "face_flats")) {
            for(ConfiguredFeature<?, ?> ore : faceOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for(ConfiguredFeature<?, ?> ore : overworldOres){
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, FaceCraft.MOD_ID + ":" + name, configuredFeature);
    }

}
