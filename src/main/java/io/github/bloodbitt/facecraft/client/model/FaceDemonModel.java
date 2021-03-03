package io.github.bloodbitt.facecraft.client.model;

import io.github.bloodbitt.facecraft.entities.Face_Demon_entity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class FaceDemonModel <T extends Face_Demon_entity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer legs;

    public FaceDemonModel() {
        textureWidth = 128;
        textureHeight = 128;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.setTextureOffset(44, 44).addBox(-6.0F, -9.0F, -6.0F, 12.0F, 9.0F, 12.0F, 0.0F, false);
        head.setTextureOffset(63, 4).addBox(-6.0F, -4.0F, -7.0F, 12.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(63, 0).addBox(-6.0F, -9.0F, -7.0F, 12.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 3).addBox(3.0F, -6.0F, -7.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, -7.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 6).addBox(-1.0F, -6.0F, -7.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(20, 54).addBox(6.0F, -6.0F, -7.0F, 1.0F, 2.0F, 13.0F, 0.0F, false);
        head.setTextureOffset(48, 0).addBox(-7.0F, -6.0F, -7.0F, 1.0F, 2.0F, 13.0F, 0.0F, false);
        head.setTextureOffset(42, 36).addBox(-7.0F, -6.0F, 6.0F, 14.0F, 2.0F, 1.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 7.0F, 0.0F);
        body.setTextureOffset(0, 33).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 7.0F, 14.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setRotationPoint(0.0F, 7.0F, 0.0F);
        legs.setTextureOffset(42, 34).addBox(-8.0F, 16.0F, -9.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);
        legs.setTextureOffset(42, 42).addBox(-8.0F, 16.0F, 8.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);
        legs.setTextureOffset(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 17.0F, 16.0F, 0.0F, false);
        legs.setTextureOffset(0, 54).addBox(8.0F, 16.0F, -9.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);
        legs.setTextureOffset(46, 15).addBox(-9.0F, 16.0F, -9.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.legs.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legs.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
