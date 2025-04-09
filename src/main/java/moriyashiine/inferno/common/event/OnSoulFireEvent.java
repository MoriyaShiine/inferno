/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.event;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.init.ModEntityComponents;
import moriyashiine.strawberrylib.api.event.ModifyDamageTakenEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;

public class OnSoulFireEvent implements ModifyDamageTakenEvent {
	@Override
	public float modify(float amount, ServerWorld world, DamageSource source, LivingEntity victim) {
		if (ModConfig.onSoulFire && source == world.getDamageSources().onFire() && ModEntityComponents.ON_SOUL_FIRE.get(victim).isOnSoulFire()) {
			return 2;
		}
		return 1;
	}
}
