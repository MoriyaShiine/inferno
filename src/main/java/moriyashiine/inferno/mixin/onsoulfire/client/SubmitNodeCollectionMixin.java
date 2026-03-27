/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire.client;

import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.client.renderer.entity.state.SoulFireRenderState;
import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SubmitNodeCollection.class)
public class SubmitNodeCollectionMixin {
	@ModifyArg(method = "submitFlame", at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z"))
	private <E> E inferno$onSoulFire(E e, @Local(argsOnly = true) EntityRenderState renderState) {
		if (e instanceof SoulFireRenderState.Submit submit) {
			@Nullable SoulFireRenderState soulFireRenderState = renderState.getData(SoulFireRenderState.KEY);
			if (soulFireRenderState != null) {
				submit.inferno$setRenderSoulFire(soulFireRenderState.renderSoulFire);
			}
		}
		return e;
	}
}
