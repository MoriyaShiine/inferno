/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.entityfirespread;

import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.entity.IgniteEnchantmentEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IgniteEnchantmentEffect.class)
public class IgniteEnchantmentEffectMixin {
	@Inject(method = "apply", at = @At("TAIL"))
	private void inferno$entityFireSpread(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos, CallbackInfo ci) {
		ModEntityComponents.ENTITY_FIRE_SPREAD.get(user).setAllowFireSpread(true);
	}
}
