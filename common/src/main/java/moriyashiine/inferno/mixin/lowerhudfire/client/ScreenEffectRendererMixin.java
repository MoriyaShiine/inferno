package moriyashiine.inferno.mixin.lowerhudfire.client;

import moriyashiine.inferno.common.InfernoConfig;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {
	@ModifyArg(method = "renderFire", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V"), index = 1)
	private static float inferno$lowerHudFire(float xo) {
		if (InfernoConfig.lowerHudFire) {
			return xo - 0.175F;
		}
		return xo;
	}
}
