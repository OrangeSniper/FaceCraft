package io.github.bloodbitt.facecraft.init;

import io.github.bloodbitt.facecraft.FaceCraft;
import io.github.bloodbitt.facecraft.entities.Face_Demon_entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, FaceCraft.MOD_ID);

    //entities types
    public static final RegistryObject<EntityType<Face_Demon_entity>> FACE_DEMON = ENTITY_TYPES.register("face_demon",
            () -> EntityType.Builder.create(Face_Demon_entity::new, EntityClassification.CREATURE)
                    .size(1.0f, 2.0f)
                    .build(new ResourceLocation(FaceCraft.MOD_ID, "face_demon").toString()));
}
