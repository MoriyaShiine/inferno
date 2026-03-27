/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({AbstractArrow.class, SmallFireball.class})
public abstract class ProjectileFireMixin extends Entity {
	public ProjectileFireMixin(EntityType<?> type, Level level) {
		super(type, level);
	}

	@Inject(method = "onHitEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;igniteForSeconds(F)V"))
	private void inferno$onSoulFire(EntityHitResult hitResult, CallbackInfo ci) {
		if (ModConfig.onSoulFire && !level().isClientSide()) {
			boolean onSoulFire = ModEntityComponents.ON_SOUL_FIRE.get(this).isOnSoulFire();
			OnSoulFireComponent onSoulFireComponent = ModEntityComponents.ON_SOUL_FIRE.get(hitResult.getEntity());
			if (onSoulFireComponent.isOnSoulFire() != onSoulFire) {
				onSoulFireComponent.setOnSoulFire(onSoulFire);
				onSoulFireComponent.sync();
			}
		}
	}
}
