/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.lowerhudfire.client;

import moriyashiine.inferno.common.InfernoConfig;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {
	@ModifyArg(method = "lambda$submitFire$0", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;translate(FFF)Lorg/joml/Matrix4f;"), index = 1)
	private static float inferno$lowerHudFire(float y) {
		if (InfernoConfig.lowerHudFire) {
			return y - 0.175F;
		}
		return y;
	}
}
