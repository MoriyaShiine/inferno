/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.smokyfog.client;

import moriyashiine.inferno.client.event.SmokyFogEvent;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientLevel.class)
public abstract class ClientLevelMixin {
	@Shadow
	public abstract void addParticle(ParticleOptions particle, double x, double y, double z, double xd, double yd, double zd);

	@Inject(method = "doAnimateTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientLevel;environmentAttributes()Lnet/minecraft/world/attribute/EnvironmentAttributeSystem;"))
	private void inferno$smokyFog(int xt, int yt, int zt, int r, RandomSource animateRandom, Block markerParticleTarget, BlockPos.MutableBlockPos pos, CallbackInfo ci) {
		if (SmokyFogEvent.hasMaxFireBlocks() && animateRandom.nextFloat() < 0.1F) {
			addParticle(ParticleTypes.ASH, pos.getX() + animateRandom.nextDouble(), pos.getY() + animateRandom.nextDouble(), pos.getZ() + animateRandom.nextDouble(), 0, 0, 0);
		}
	}
}
