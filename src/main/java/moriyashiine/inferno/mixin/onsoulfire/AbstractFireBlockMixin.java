/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
	@Inject(method = "onEntityCollision", at = @At("HEAD"))
	private void inferno$onSoulFire(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, CallbackInfo ci) {
		if (ModConfig.onSoulFire && !world.isClient && !entity.isFireImmune()) {
			boolean onSoulFire = state.getBlock() instanceof SoulFireBlock;
			OnSoulFireComponent onSoulFireComponent = ModEntityComponents.ON_SOUL_FIRE.get(entity);
			if (onSoulFireComponent.isOnSoulFire() != onSoulFire) {
				onSoulFireComponent.setOnSoulFire(onSoulFire);
				onSoulFireComponent.sync();
			}
		}
	}
}
