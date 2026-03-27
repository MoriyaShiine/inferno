/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.component.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.ladysnake.cca.api.v3.component.tick.ServerTickingComponent;

public class EntityFireSpreadComponent implements ServerTickingComponent {
	private final Entity obj;
	private boolean allowFireSpread = false;

	public EntityFireSpreadComponent(Entity obj) {
		this.obj = obj;
	}

	@Override
	public void readData(ValueInput input) {
		allowFireSpread = input.getBooleanOr("AllowFireSpread", false);
	}

	@Override
	public void writeData(ValueOutput output) {
		output.putBoolean("AllowFireSpread", allowFireSpread);
	}

	@Override
	public void serverTick() {
		if (allowFireSpread && obj.getRemainingFireTicks() <= 0) {
			allowFireSpread = false;
		}
	}

	public boolean allowsFireSpread() {
		return allowFireSpread;
	}

	public void setAllowFireSpread(boolean allowFireSpread) {
		this.allowFireSpread = allowFireSpread;
	}
}
