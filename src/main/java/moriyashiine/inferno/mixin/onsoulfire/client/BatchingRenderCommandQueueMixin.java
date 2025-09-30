/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire.client;

import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.client.render.entity.state.SoulFireRenderState;
import net.minecraft.client.render.command.BatchingRenderCommandQueue;
import net.minecraft.client.render.entity.state.EntityRenderState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BatchingRenderCommandQueue.class)
public class BatchingRenderCommandQueueMixin {
	@ModifyArg(method = "submitFire", at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z"))
	private <E> E inferno$onSoulFire(E e, @Local(argsOnly = true) EntityRenderState state) {
		if (e instanceof SoulFireRenderState.Command command) {
			@Nullable SoulFireRenderState soulFireRenderState = state.getData(SoulFireRenderState.KEY);
			if (soulFireRenderState != null) {
				command.inferno$setRenderSoulFire(soulFireRenderState.renderSoulFire);
			}
		}
		return e;
	}
}
