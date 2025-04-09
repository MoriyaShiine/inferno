/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.entityfirespread;

import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
	@Inject(method = "igniteEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setFireTicks(I)V"))
	private static void inferno$entityFireSpread(Entity entity, CallbackInfo ci) {
		if (!entity.getWorld().isClient) {
			ModEntityComponents.ENTITY_FIRE_SPREAD.get(entity).setAllowFireSpread(true);
		}
	}
}
