package io.github.bloodbitt.facecraft.world.gen;

import io.github.bloodbitt.facecraft.FaceCraft;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = FaceCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void SpawnEntity(FMLLoadCompleteEvent event) {
        for(Biome biome : ForgeRegistries.BIOMES) {
            if(biome.getCategory() != Biome.Category.NETHER || biome.getCategory() != Biome.Category.THEEND || biome.getCategory() != Biome.Category.OCEAN) {
                //biome.getMobSpawnInfo().getEntityTypes().add(ModEntityTypes.FACE_DEMON.get());
            }
        }
    }
}
