/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.lowerhudfire.client;

import moriyashiine.inferno.common.ModConfig;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(InGameOverlayRenderer.class)
public class InGameOverlayRendererMixin {
	@ModifyArg(method = "renderFireOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"), index = 1)
	private static float inferno$lowerHudFire(float y) {
		if (ModConfig.lowerHudFire) {
			return y - 0.175F;
		}
		return y;
	}
}
