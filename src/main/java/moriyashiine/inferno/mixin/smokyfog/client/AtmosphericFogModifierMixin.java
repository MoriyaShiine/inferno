/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.smokyfog.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.inferno.client.event.SmokyFogEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.fog.AtmosphericFogModifier;
import net.minecraft.client.render.fog.FogData;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AtmosphericFogModifier.class)
public class AtmosphericFogModifierMixin {
	@Inject(method = "applyStartEndModifier", at = @At("TAIL"))
	private void inferno$smokyFog(FogData data, Camera camera, ClientWorld clientWorld, float f, RenderTickCounter renderTickCounter, CallbackInfo ci) {
		float progress = SmokyFogEvent.getProgress(renderTickCounter.getTickProgress(false));
		if (progress > 0) {
			data.environmentalStart = MathHelper.lerp(progress, data.environmentalStart, 0);
			data.environmentalEnd = MathHelper.lerp(progress, data.environmentalEnd, 32);
		}
	}

	@ModifyReturnValue(method = "getFogColor", at = @At("RETURN"))
	private int inferno$smokyFog(int original) {
		float progress = SmokyFogEvent.getProgress(MinecraftClient.getInstance().getRenderTickCounter().getTickProgress(false));
		if (progress > 0) {
			Vector3f color = ColorHelper.toRgbVector(original);
			float green = color.y();
			float blue = color.z();
			green = Math.max(Math.min(0.2F, green), green - progress * 0.125F);
			blue = Math.max(Math.min(0.2F, blue), blue - progress * 0.25F);
			return ColorHelper.fromFloats(1, color.x(), green, blue);
		}
		return original;
	}
}
