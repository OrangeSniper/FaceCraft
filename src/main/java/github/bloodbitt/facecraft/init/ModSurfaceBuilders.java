package github.bloodbitt.facecraft.init;

import github.bloodbitt.facecraft.FaceCraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = FaceCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSurfaceBuilders {
    private static final Set<SurfaceBuilder<?>> BUILDERS = new HashSet<>();

    public static final SurfaceBuilder<SurfaceBuilderConfig> FACE_LANDS = add(new ResourceLocation(FaceCraft.MOD_ID, "face_lands"), new DefaultSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));

    public static SurfaceBuilder<SurfaceBuilderConfig> add(ResourceLocation rl, SurfaceBuilder<SurfaceBuilderConfig> builder) {
        builder.setRegistryName(rl);
        BUILDERS.add(builder);
        return builder;
    }

    public static final ConfiguredSurfaceBuilder<?> CONFIGURED_FACE_LANDS = register("face_lands", new ConfiguredSurfaceBuilder<>(FACE_LANDS, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));

    private static ConfiguredSurfaceBuilder<?> register(String id, ConfiguredSurfaceBuilder<?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(FaceCraft.MOD_ID, id), feature);
    }

    @SubscribeEvent
    public static void forgeRegister(RegistryEvent.Register<SurfaceBuilder<?>> event) {
        IForgeRegistry<SurfaceBuilder<?>> registry = event.getRegistry();
        for (SurfaceBuilder<?> entry : BUILDERS) {
            registry.register(entry);
        }
    }
}
