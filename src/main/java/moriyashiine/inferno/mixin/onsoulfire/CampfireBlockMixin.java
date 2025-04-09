/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.ModConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CampfireBlock.class)
public class CampfireBlockMixin {
	@SuppressWarnings("ConstantValue")
	@ModifyArg(method = "onEntityCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;serverDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"))
	private float inferno$onSoulFire(float value) {
		if (ModConfig.onSoulFire && (Object) this == Blocks.SOUL_CAMPFIRE) {
			return value * 2;
		}
		return value;
	}
}
