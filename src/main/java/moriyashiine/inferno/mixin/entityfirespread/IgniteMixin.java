/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.entityfirespread;

import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.Ignite;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Ignite.class)
public class IgniteMixin {
	@Inject(method = "apply", at = @At("TAIL"))
	private void inferno$entityFireSpread(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 position, CallbackInfo ci) {
		ModEntityComponents.ENTITY_FIRE_SPREAD.get(entity).setAllowFireSpread(true);
	}
}
