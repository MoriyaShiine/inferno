/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.InfernoConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.InfernoEntityComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.SoulFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BaseFireBlock.class)
public class BaseFireBlockMixin {
	@Inject(method = "entityInside", at = @At("HEAD"))
	private void inferno$onSoulFire(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise, CallbackInfo ci) {
		if (InfernoConfig.onSoulFire && !level.isClientSide() && !entity.fireImmune()) {
			boolean soulFire = state.getBlock() instanceof SoulFireBlock;
			OnSoulFireComponent onSoulFire = InfernoEntityComponents.ON_SOUL_FIRE.get(entity);
			if (onSoulFire.isOnSoulFire() != soulFire) {
				onSoulFire.setOnSoulFire(soulFire);
				onSoulFire.sync();
			}
		}
	}
}
