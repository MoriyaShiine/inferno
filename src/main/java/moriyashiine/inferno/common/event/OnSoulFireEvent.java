/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.event;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.init.ModEntityComponents;
import moriyashiine.strawberrylib.api.event.ModifyDamageTakenEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class OnSoulFireEvent implements ModifyDamageTakenEvent {
	@Override
	public float modify(Phase phase, LivingEntity victim, ServerLevel level, DamageSource source) {
		if (phase == Phase.BASE && ModConfig.onSoulFire && source == level.damageSources().onFire() && ModEntityComponents.ON_SOUL_FIRE.get(victim).isOnSoulFire()) {
			return 2;
		}
		return 1;
	}
}
