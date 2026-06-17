/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.InfernoConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.InfernoEntityComponents;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(method = "lavaIgnite", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;igniteForSeconds(F)V"))
	private void inferno$onSoulFire(CallbackInfo ci) {
		if (InfernoConfig.onSoulFire) {
			OnSoulFireComponent onSoulFire = InfernoEntityComponents.ON_SOUL_FIRE.get(this);
			if (onSoulFire.isOnSoulFire()) {
				onSoulFire.setOnSoulFire(false);
			}
		}
	}
}
