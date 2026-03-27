/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.ModConfig;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CampfireBlock.class)
public class CampfireBlockMixin {
	@SuppressWarnings("ConstantValue")
	@ModifyArg(method = "entityInside", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)V"))
	private float inferno$onSoulFire(float damage) {
		if (ModConfig.onSoulFire && (Object) this == Blocks.SOUL_CAMPFIRE) {
			return damage * 2;
		}
		return damage;
	}
}
