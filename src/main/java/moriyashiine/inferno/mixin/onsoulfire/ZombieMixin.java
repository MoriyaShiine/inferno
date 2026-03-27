/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.zombie.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Zombie.class)
public class ZombieMixin {
	@Inject(method = "doHurtTarget", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;igniteForSeconds(F)V"))
	private void inferno$onSoulFire(ServerLevel level, Entity target, CallbackInfoReturnable<Boolean> cir) {
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
