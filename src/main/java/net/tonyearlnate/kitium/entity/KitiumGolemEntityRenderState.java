package net.tonyearlnate.kitium.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.passive.Cracks;

@Environment(EnvType.CLIENT)
public class KitiumGolemEntityRenderState extends LivingEntityRenderState {
	public float attackTicksLeft;
	public int lookingAtVillagerTicks;
	public Cracks.CrackLevel crackLevel = Cracks.CrackLevel.NONE;
}
