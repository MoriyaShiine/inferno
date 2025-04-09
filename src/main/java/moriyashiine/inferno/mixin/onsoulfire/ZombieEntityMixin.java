/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZombieEntity.class)
public class ZombieEntityMixin {
	@Inject(method = "tryAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setOnFireFor(F)V"))
	private void inferno$onSoulFire(ServerWorld world, Entity target, CallbackInfoReturnable<Boolean> cir) {
		if (ModConfig.onSoulFire) {
			boolean onSoulFire = ModEntityComponents.ON_SOUL_FIRE.get(this).isOnSoulFire();
			OnSoulFireComponent onSoulFireComponent = ModEntityComponents.ON_SOUL_FIRE.get(target);
			if (onSoulFireComponent.isOnSoulFire() != onSoulFire) {
				onSoulFireComponent.setOnSoulFire(onSoulFire);
				onSoulFireComponent.sync();
			}
		}
	}
}
