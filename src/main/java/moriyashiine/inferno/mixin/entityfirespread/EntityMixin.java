/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.entityfirespread;

import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@Shadow
	public abstract World getWorld();

	@Inject(method = "onStruckByLightning", at = @At("TAIL"))
	private void inferno$entityFireSpread(ServerWorld world, LightningEntity lightning, CallbackInfo ci) {
		ModEntityComponents.ENTITY_FIRE_SPREAD.get(this).setAllowFireSpread(true);
	}

	@Inject(method = "igniteByLava", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setOnFireFor(F)V"))
	private void inferno$entityFireSpread(CallbackInfo ci) {
		if (!getWorld().isClient) {
			ModEntityComponents.ENTITY_FIRE_SPREAD.get(this).setAllowFireSpread(true);
		}
	}
}
