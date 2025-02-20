package net.tonyearlnate.kitium.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class KitiumGolemFlowerFeatureRenderer extends FeatureRenderer<KitiumGolemEntityRenderState, KitiumGolemEntityModel> {
    private final BlockRenderManager blockRenderManager;

    public KitiumGolemFlowerFeatureRenderer(FeatureRendererContext<KitiumGolemEntityRenderState, KitiumGolemEntityModel> context, BlockRenderManager blockRenderManager) {
        super(context);
        this.blockRenderManager = blockRenderManager;
    }

    public void render(
            MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, KitiumGolemEntityRenderState kitiumGolemEntityRenderState, float f, float g
    ) {
        if (kitiumGolemEntityRenderState.lookingAtVillagerTicks != 0) {
            matrixStack.push();
            ModelPart modelPart = this.getContextModel().getRightArm();
            modelPart.rotate(matrixStack);
            matrixStack.translate(-1.1875F, 1.0625F, -0.9375F);
            matrixStack.translate(0.5F, 0.5F, 0.5F);
            float h = 0.5F;
            matrixStack.scale(0.5F, 0.5F, 0.5F);
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F));
            matrixStack.translate(-0.5F, -0.5F, -0.5F);
            this.blockRenderManager.renderBlockAsEntity(Blocks.POPPY.getDefaultState(), matrixStack, vertexConsumerProvider, i, OverlayTexture.DEFAULT_UV);
            matrixStack.pop();
        }
    }
}
