package net.tonyearlnate.unbounded_unknown.entity;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.Cracks;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class KitiumGolemCrackFeatureRenderer extends FeatureRenderer<KitiumGolemEntityRenderState, KitiumGolemEntityModel> {
    private static final Map<Cracks.CrackLevel, Identifier> CRACK_TEXTURES = ImmutableMap.of(
            Cracks.CrackLevel.LOW,
            Identifier.ofVanilla("textures/entity/iron_golem/iron_golem_crackiness_low.png"),
            Cracks.CrackLevel.MEDIUM,
            Identifier.ofVanilla("textures/entity/iron_golem/iron_golem_crackiness_medium.png"),
            Cracks.CrackLevel.HIGH,
            Identifier.ofVanilla("textures/entity/iron_golem/iron_golem_crackiness_high.png")
    );

    public KitiumGolemCrackFeatureRenderer(FeatureRendererContext<KitiumGolemEntityRenderState, KitiumGolemEntityModel> featureRendererContext) {
        super(featureRendererContext);
    }

    public void render(
            MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, KitiumGolemEntityRenderState kitiumGolemEntityRenderState, float f, float g
    ) {
        if (!kitiumGolemEntityRenderState.invisible) {
            Cracks.CrackLevel crackLevel = kitiumGolemEntityRenderState.crackLevel;
            if (crackLevel != Cracks.CrackLevel.NONE) {
                Identifier identifier = (Identifier)CRACK_TEXTURES.get(crackLevel);
                renderModel(this.getContextModel(), identifier, matrixStack, vertexConsumerProvider, i, kitiumGolemEntityRenderState, -1);
            }
        }
    }
}
