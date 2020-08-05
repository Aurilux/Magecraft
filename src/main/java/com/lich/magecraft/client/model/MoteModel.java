package com.lich.magecraft.client.model;

import com.lich.magecraft.entities.mote.MoteEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MoteModel<T extends MoteEntity> extends EntityModel<T> {
    private final ModelRenderer vortex;
    private final ModelRenderer stars;

    public MoteModel() {
        super(RenderType::getEntityTranslucent);
        textureWidth = 16;
        textureHeight = 8;

        vortex = new ModelRenderer(this);
        vortex.setRotationPoint(0.0F, 20.0F, 0.0F);
        vortex.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, 0.0F, false);

        stars = new ModelRenderer(this);
        stars.setRotationPoint(0.0F, 24.0F, 0.0F);
        stars.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, 0.25F, 8.0F, 8.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        vortex.render(matrixStack, buffer, packedLight, packedOverlay);
        stars.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
