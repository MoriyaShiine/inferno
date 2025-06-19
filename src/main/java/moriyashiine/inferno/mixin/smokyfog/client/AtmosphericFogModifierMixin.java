/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.smokyfog.client;

import moriyashiine.inferno.client.event.SmokyFogEvent;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.fog.AtmosphericFogModifier;
import net.minecraft.client.render.fog.FogData;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AtmosphericFogModifier.class)
public class AtmosphericFogModifierMixin {
	@Inject(method = "applyStartEndModifier", at = @At("TAIL"))
	private void inferno$smokyFog(FogData data, Entity cameraEntity, BlockPos cameraPos, ClientWorld world, float viewDistance, RenderTickCounter tickCounter, CallbackInfo ci) {
		if (SmokyFogEvent.fireBlocks > 0) {
			float progress = SmokyFogEvent.fireBlocks / (float) SmokyFogEvent.MAX_FIRE_BLOCKS;
			data.environmentalStart = MathHelper.lerp(progress, data.environmentalStart, 0);
			data.environmentalEnd = MathHelper.lerp(progress, data.environmentalEnd, 32);
		}
	}
}
