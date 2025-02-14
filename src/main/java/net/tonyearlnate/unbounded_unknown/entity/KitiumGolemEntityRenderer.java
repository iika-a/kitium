package net.tonyearlnate.unbounded_unknown.entity;

	import net.fabricmc.api.EnvType;
	import net.fabricmc.api.Environment;
	import net.minecraft.client.render.entity.EntityRendererFactory;
	import net.minecraft.client.render.entity.MobEntityRenderer;
	import net.minecraft.client.render.entity.model.EntityModelLayers;
	import net.minecraft.client.util.math.MatrixStack;
	import net.minecraft.util.Identifier;
	import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class KitiumGolemEntityRenderer extends MobEntityRenderer<KitiumGolemEntity, KitiumGolemEntityRenderState, KitiumGolemEntityModel> {
	private static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/iron_golem/iron_golem.png");

	public KitiumGolemEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new KitiumGolemEntityModel(context.getPart(EntityModelLayers.IRON_GOLEM)), 0.7F);
		this.addFeature(new KitiumGolemCrackFeatureRenderer(this));
		this.addFeature(new KitiumGolemFlowerFeatureRenderer(this, context.getBlockRenderManager()));
	}

	public Identifier getTexture(KitiumGolemEntityRenderState KitiumGolemEntityRenderState) {
		return TEXTURE;
	}

	public KitiumGolemEntityRenderState createRenderState() {
		return new KitiumGolemEntityRenderState();
	}

	public void updateRenderState(KitiumGolemEntity KitiumGolemEntity, KitiumGolemEntityRenderState KitiumGolemEntityRenderState, float f) {
		super.updateRenderState(KitiumGolemEntity, KitiumGolemEntityRenderState, f);
		KitiumGolemEntityRenderState.attackTicksLeft = (float)KitiumGolemEntity.getAttackTicksLeft() > 0.0F ? (float)KitiumGolemEntity.getAttackTicksLeft() - f : 0.0F;
		//KitiumGolemEntityRenderState.crackLevel = KitiumGolemEntity.getCrackLevel();
	}

	protected void setupTransforms(KitiumGolemEntityRenderState KitiumGolemEntityRenderState, MatrixStack matrixStack, float f, float g) {
		super.setupTransforms(KitiumGolemEntityRenderState, matrixStack, f, g);
		if (!((double)KitiumGolemEntityRenderState.limbAmplitudeMultiplier < 0.01)) {
			float h = 13.0F;
			float i = KitiumGolemEntityRenderState.limbFrequency + 6.0F;
			float j = (Math.abs(i % 13.0F - 6.5F) - 3.25F) / 3.25F;
			matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(6.5F * j));
		}
	}
}