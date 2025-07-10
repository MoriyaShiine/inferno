/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.smokyfog.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.inferno.client.event.SmokyFogEvent;
import net.minecraft.client.render.fog.StandardFogModifier;
import net.minecraft.util.math.ColorHelper;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(StandardFogModifier.class)
public class StandardFogModifierMixin {
	@ModifyReturnValue(method = "getFogColor", at = @At("RETURN"))
	private int inferno$smokyFog(int original) {
		float progress = SmokyFogEvent.getProgress();
		if (progress > 0) {
			Vector3f color = ColorHelper.toVector(original);
			float green = color.y();
			float blue = color.z();
			green = Math.max(Math.min(0.2F, green), green - progress * 0.125F);
			blue = Math.max(Math.min(0.2F, blue), blue - progress * 0.25F);
			return ColorHelper.fromFloats(1, color.x(), green, blue);
		}
		return original;
	}
}
