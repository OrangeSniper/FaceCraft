package io.github.bloodbitt.facecraft.init;

import io.github.bloodbitt.facecraft.FaceCraft;
import io.github.bloodbitt.facecraft.surfacebuilders.FaceSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class surfaceBuilders {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, FaceCraft.MOD_ID);

    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> FACESURFACEBUILDER = createSurfaceBuilder("face_surface_builder", () -> new FaceSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));

    public static <S extends SurfaceBuilder<?>> RegistryObject<S> createSurfaceBuilder(String name, Supplier<? extends S> surfaceBuilder) {
        return SURFACE_BUILDERS.register(name, surfaceBuilder);
    }
}
