/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire.client;

import moriyashiine.inferno.client.render.entity.state.SoulFireRenderState;
import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin<T extends Entity, S extends EntityRenderState> {
	@Inject(method = "updateRenderState", at = @At("TAIL"))
	private void inferno$onSoulFire(T entity, S state, float tickProgress, CallbackInfo ci) {
		SoulFireRenderState soulFireRenderState = new SoulFireRenderState();
		soulFireRenderState.renderSoulFire = ModEntityComponents.ON_SOUL_FIRE.get(entity).isOnSoulFire();
		state.setData(SoulFireRenderState.KEY, soulFireRenderState);
	}
}
