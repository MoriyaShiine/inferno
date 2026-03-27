/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.client.event;

import moriyashiine.inferno.common.ModConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;

public class SmokyFogEvent implements ClientTickEvents.EndLevelTick {
	private static final int MAX_FIRE_BLOCKS = 64;
	private static int fireBlocks = 0;

	private static final int UPDATE_TICKS = 10;
	private static int ticks = 0, targetFireBlocks = 0;
	private static float lastProgress = 0, progress = 0;

	public static boolean hasMaxFireBlocks() {
		return fireBlocks == MAX_FIRE_BLOCKS;
	}

	public static float getProgress(float tickProgress) {
		return Mth.lerp(tickProgress, lastProgress, progress);
	}

	private static float calculateProgress() {
		return fireBlocks / (float) MAX_FIRE_BLOCKS;
	}

	@Override
	public void onEndTick(ClientLevel level) {
		lastProgress = progress;
		if (ticks % (fireBlocks < targetFireBlocks ? 1 : 2) == 0) {
			if (fireBlocks > targetFireBlocks) {
				fireBlocks--;
			} else if (fireBlocks < targetFireBlocks) {
				fireBlocks++;
			}
			fireBlocks = Mth.clamp(fireBlocks, 0, MAX_FIRE_BLOCKS);
		}
		Minecraft client = Minecraft.getInstance();
		if (!client.isPaused()) {
			ticks++;
		}
		if (ModConfig.smokyFog && client.getCameraEntity() != null) {
			if (ticks % UPDATE_TICKS == 0) {
				int[] counted = {0};
				if (level.dimension() != Level.NETHER) {
					final int range = 16;
					BlockPos.withinManhattan(client.getCameraEntity().blockPosition(), range, range, range).forEach(pos -> {
						if (counted[0] < MAX_FIRE_BLOCKS && level.getBlockState(pos).is(BlockTags.FIRE)) {
							counted[0]++;
						}
					});
				}
				if (counted[0] % 16 == 0) {
					targetFireBlocks = counted[0];
				}
			}
		} else {
			targetFireBlocks = 0;
		}
		progress = calculateProgress();
	}
}
