/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(method = "igniteByLava", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setOnFireFor(F)V"))
	private void inferno$onSoulFire(CallbackInfo ci) {
		if (ModConfig.onSoulFire) {
			OnSoulFireComponent onSoulFireComponent = ModEntityComponents.ON_SOUL_FIRE.get(this);
			if (onSoulFireComponent.isOnSoulFire()) {
				onSoulFireComponent.setOnSoulFire(false);
			}
		}
	}
}
