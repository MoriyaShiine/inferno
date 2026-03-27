/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire.client;

import moriyashiine.inferno.client.renderer.entity.state.SoulFireRenderState;
import net.minecraft.client.renderer.SubmitNodeStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SubmitNodeStorage.FlameSubmit.class)
public class FlameSubmitMixin implements SoulFireRenderState.Submit {
	@Unique
	private boolean renderSoulFire = false;

	@Override
	public boolean inferno$renderSoulFire() {
		return renderSoulFire;
	}

	@Override
	public void inferno$setRenderSoulFire(boolean renderSoulFire) {
		this.renderSoulFire = renderSoulFire;
	}
}
