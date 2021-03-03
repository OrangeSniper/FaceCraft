package github.bloodbitt.facecraft;

import github.bloodbitt.facecraft.entities.Face_Demon_entity;
import github.bloodbitt.facecraft.init.ModBlocks;
import github.bloodbitt.facecraft.init.ModEntityTypes;
import github.bloodbitt.facecraft.init.ModItems;
import github.bloodbitt.facecraft.world.gen.ModBiomes;
import github.bloodbitt.facecraft.world.gen.ModOreGen;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("facecraft")
public class FaceCraft
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "facecraft";

    public FaceCraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBiomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ModBiomes.FACE_LANDS_KEY, 100));
        ModOreGen.registerOres();
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.FACE_DEMON.get(), Face_Demon_entity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

    }

    public static final ItemGroup TAB = new ItemGroup("FaceTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.FACE.get());
        }
    };
}
