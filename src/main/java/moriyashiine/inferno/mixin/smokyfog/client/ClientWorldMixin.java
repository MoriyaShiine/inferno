/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.smokyfog.client;

import moriyashiine.inferno.client.event.SmokyFogEvent;
import net.minecraft.block.Block;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {
	@Shadow
	public abstract void addParticleClient(ParticleEffect parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ);

	@Inject(method = "randomBlockDisplayTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;getBiome(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/registry/entry/RegistryEntry;"))
	private void inferno$smokyFog(int centerX, int centerY, int centerZ, int radius, Random random, Block block, BlockPos.Mutable pos, CallbackInfo ci) {
		if (SmokyFogEvent.hasMaxFireBlocks() && random.nextFloat() < 0.1F) {
			addParticleClient(ParticleTypes.ASH, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 0, 0, 0);
		}
	}
}
