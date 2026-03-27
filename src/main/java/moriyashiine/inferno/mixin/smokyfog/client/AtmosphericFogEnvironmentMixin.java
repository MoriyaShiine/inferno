/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.smokyfog.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.inferno.client.event.SmokyFogEvent;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.AtmosphericFogEnvironment;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AtmosphericFogEnvironment.class)
public class AtmosphericFogEnvironmentMixin {
	@Inject(method = "setupFog", at = @At("TAIL"))
	private void inferno$smokyFog(FogData fog, Camera camera, ClientLevel level, float renderDistance, DeltaTracker deltaTracker, CallbackInfo ci) {
		float progress = SmokyFogEvent.getProgress(deltaTracker.getGameTimeDeltaPartialTick(false));
		if (progress > 0) {
			fog.environmentalStart = Mth.lerp(progress, fog.environmentalStart, 0);
			fog.environmentalEnd = Mth.lerp(progress, fog.environmentalEnd, 32);
		}
	}

	@ModifyReturnValue(method = "getBaseColor", at = @At("RETURN"))
	private int inferno$smokyFog(int original) {
		float progress = SmokyFogEvent.getProgress(Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false));
		if (progress > 0) {
			Vector3f color = ARGB.vector3fFromRGB24(original);
			float green = color.y();
			float blue = color.z();
			green = Math.max(Math.min(0.2F, green), green - progress * 0.125F);
			blue = Math.max(Math.min(0.2F, blue), blue - progress * 0.25F);
			return ARGB.colorFromFloat(1, color.x(), green, blue);
		}
		return original;
	}
}
