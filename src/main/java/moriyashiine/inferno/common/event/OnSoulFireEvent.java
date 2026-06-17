/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.event;

import moriyashiine.inferno.common.InfernoConfig;
import moriyashiine.inferno.common.init.InfernoEntityComponents;
import moriyashiine.strawberrylib.api.event.ModifyDamageTakenEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class OnSoulFireEvent implements ModifyDamageTakenEvent {
	public static void init() {
		ModifyDamageTakenEvent.MULTIPLY_BASE.register(new OnSoulFireEvent());
	}

	@Override
	public float modify(Phase phase, LivingEntity victim, ServerLevel level, DamageSource source) {
		if (phase == Phase.BASE && InfernoConfig.onSoulFire && source == level.damageSources().onFire() && InfernoEntityComponents.ON_SOUL_FIRE.get(victim).isOnSoulFire()) {
			return 2;
		}
		return 1;
	}
}
