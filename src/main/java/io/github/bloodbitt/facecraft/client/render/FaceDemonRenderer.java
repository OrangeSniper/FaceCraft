package io.github.bloodbitt.facecraft.client.render;

import io.github.bloodbitt.facecraft.FaceCraft;
import io.github.bloodbitt.facecraft.client.model.FaceDemonModel;
import io.github.bloodbitt.facecraft.entities.Face_Demon_entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FaceDemonRenderer extends MobRenderer<Face_Demon_entity, FaceDemonModel<Face_Demon_entity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(FaceCraft.MOD_ID, "textures/entity/face_demon.png");

    public FaceDemonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FaceDemonModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(Face_Demon_entity entity) {
        return TEXTURE;
    }
}
