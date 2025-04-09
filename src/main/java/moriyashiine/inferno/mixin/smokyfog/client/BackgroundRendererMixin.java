/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.smokyfog.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.inferno.client.event.SmokyFogEvent;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Fog;
import net.minecraft.util.math.MathHelper;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {
	@Unique
	private static final int CLAMPED_MAX = 32;

	@ModifyReturnValue(method = "applyFog", at = @At("RETURN"))
	private static Fog inferno$smokyFog(Fog original, Camera camera, BackgroundRenderer.FogType fogType, Vector4f color, float viewDistance, boolean thickenFog, float tickProgress) {
		if (SmokyFogEvent.fireBlocks > 0) {
			float max = original.end();
			if (max > CLAMPED_MAX) {
				float progress = SmokyFogEvent.fireBlocks / (float) SmokyFogEvent.MAX_FIRE_BLOCKS;
				float newStart = MathHelper.lerp(progress, original.start(), 0);
				float newEnd = MathHelper.lerp(progress, max, CLAMPED_MAX);
				float green = original.green();
				float blue = original.blue();
				if (fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
					green = Math.max(Math.min(0.2F, green), green - progress * 0.125F);
					blue = Math.max(Math.min(0.2F, blue), blue - progress * 0.25F);
				}
				return new Fog(newStart, newEnd, original.shape(), original.red(), green, blue, original.alpha());
			}
		}
		return original;
	}
}
