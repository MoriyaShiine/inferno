/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.entityfirespread;

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
	private void inferno$entityFireSpread(ServerWorld world, Entity target, CallbackInfoReturnable<Boolean> cir) {
		ModEntityComponents.ENTITY_FIRE_SPREAD.get(target).setAllowFireSpread(true);
	}
}
