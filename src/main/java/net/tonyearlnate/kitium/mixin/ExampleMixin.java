package net.tonyearlnate.kitium.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
	}
//jkiojniojioj89oihb9p7uvb789 uh780ugh 7890 ugh h8y ng07 tgh8o7iug 8io 7yiug 678i yfg 7i6ghb6789 g678i  g7o g7i6 g 678ig i786g67i fg i76fg khj gbiug hv 7tu fc5 e rs 4yertrd f tuygb 8oyhv i tyhj

}