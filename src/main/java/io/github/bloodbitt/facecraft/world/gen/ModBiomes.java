package io.github.bloodbitt.facecraft.world.gen;

import io.github.bloodbitt.facecraft.FaceCraft;
import io.github.bloodbitt.facecraft.biomes.FaceLands;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, FaceCraft.MOD_ID);


    public static final RegistryObject<Biome> FACE_LANDS = BIOMES.register("face_lands", FaceLands::makeFaceLands);
    public static final RegistryKey<Biome> FACE_LANDS_KEY = RegistryKey.getOrCreateKey(
            Registry.BIOME_KEY, new ResourceLocation("facecraft", "face_lands"));

    public static void biomeLoading(BiomeLoadingEvent event) {
        if (event.getName() == FACE_LANDS.getId()) {
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
                    new BiomeManager.BiomeEntry(FACE_LANDS_KEY ,500));
        }
    }

}
