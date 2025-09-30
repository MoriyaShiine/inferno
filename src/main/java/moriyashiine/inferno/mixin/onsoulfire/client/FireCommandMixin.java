/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire.client;

import moriyashiine.inferno.client.render.entity.state.SoulFireRenderState;
import net.minecraft.client.render.command.OrderedRenderCommandQueueImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(OrderedRenderCommandQueueImpl.FireCommand.class)
public class FireCommandMixin implements SoulFireRenderState.Command {
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
