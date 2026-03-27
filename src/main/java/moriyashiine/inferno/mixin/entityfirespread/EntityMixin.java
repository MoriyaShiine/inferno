/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.entityfirespread;

import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@Shadow
	public abstract Level level();

	@Inject(method = "thunderHit", at = @At("TAIL"))
	private void inferno$entityFireSpread(ServerLevel level, LightningBolt lightningBolt, CallbackInfo ci) {
		ModEntityComponents.ENTITY_FIRE_SPREAD.get(this).setAllowFireSpread(true);
	}

	@Inject(method = "lavaIgnite", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;igniteForSeconds(F)V"))
	private void inferno$entityFireSpread(CallbackInfo ci) {
		if (!level().isClientSide()) {
			ModEntityComponents.ENTITY_FIRE_SPREAD.get(this).setAllowFireSpread(true);
		}
	}
}
