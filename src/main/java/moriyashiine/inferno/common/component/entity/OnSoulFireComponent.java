/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.component.entity;

import moriyashiine.inferno.common.init.ModEntityComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.ServerTickingComponent;

public class OnSoulFireComponent implements AutoSyncedComponent, ServerTickingComponent {
	private final Entity obj;
	private boolean onSoulFire = false;
	private int syncTicks = 0;

	public OnSoulFireComponent(Entity obj) {
		this.obj = obj;
	}

	@Override
	public void readData(ValueInput input) {
		onSoulFire = input.getBooleanOr("OnSoulFire", false);
		syncTicks = input.getIntOr("SyncTicks", 0);
	}

	@Override
	public void writeData(ValueOutput output) {
		output.putBoolean("OnSoulFire", onSoulFire);
		output.putInt("SyncTicks", syncTicks);
	}

	@Override
	public void serverTick() {
		if (isOnSoulFire() && obj.getRemainingFireTicks() <= 0) {
			setOnSoulFire(false);
			syncTicks = 3;
		}
		if (syncTicks > 0 && --syncTicks == 0) {
			sync();
		}
	}

	public void sync() {
		ModEntityComponents.ON_SOUL_FIRE.sync(obj);
	}

	public boolean isOnSoulFire() {
		return onSoulFire;
	}

	public void setOnSoulFire(boolean onSoulFire) {
		this.onSoulFire = onSoulFire;
	}
}
