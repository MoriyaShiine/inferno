/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.client.render.entity.state;

import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;

public class SoulFireRenderState {
	public static final RenderStateDataKey<SoulFireRenderState> KEY = RenderStateDataKey.create(() -> "soul fire");

	public boolean renderSoulFire = false;

	public interface Command {
		boolean inferno$renderSoulFire();

		void inferno$setRenderSoulFire(boolean renderSoulFire);
	}
}
