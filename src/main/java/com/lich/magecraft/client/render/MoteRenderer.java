package com.lich.magecraft.client.render;

import com.lich.magecraft.Magecraft;
import com.lich.magecraft.client.model.MoteModel;
import com.lich.magecraft.entities.mote.MoteEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;

public class MoteRenderer extends EntityRenderer<MoteEntity> {

    protected static final ResourceLocation TEXTURES = new ResourceLocation(Magecraft.MOD_ID, "textures/entities/mote_vortex.png");
    private static final RenderType renderEntityCutoutType = RenderType.getEntityCutout(TEXTURES);

    private MoteModel<MoteEntity> model = new MoteModel<>();

    public MoteRenderer(EntityRendererManager renderManager) {
        super(renderManager);
        this.shadowSize = 0.5f;
    }

    @Override
    public void render(MoteEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(renderEntityCutoutType);
        int i = OverlayTexture.NO_OVERLAY;
        model.render(matrixStackIn, ivertexbuilder, packedLightIn, i,0,0,0,0);
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(MoteEntity entity) {
        return TEXTURES;
    }
}