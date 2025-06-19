/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.component.entity;

import net.minecraft.entity.Entity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import org.ladysnake.cca.api.v3.component.tick.ServerTickingComponent;

public class EntityFireSpreadComponent implements ServerTickingComponent {
	private final Entity obj;
	private boolean allowFireSpread = false;

	public EntityFireSpreadComponent(Entity obj) {
		this.obj = obj;
	}

	@Override
	public void readData(ReadView readView) {
		allowFireSpread = readView.getBoolean("AllowFireSpread", false);
	}

	@Override
	public void writeData(WriteView writeView) {
		writeView.putBoolean("AllowFireSpread", allowFireSpread);
	}

	@Override
	public void serverTick() {
		if (allowFireSpread && obj.getFireTicks() <= 0) {
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
