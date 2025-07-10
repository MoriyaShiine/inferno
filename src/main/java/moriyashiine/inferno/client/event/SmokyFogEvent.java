/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.client.event;

import moriyashiine.inferno.common.ModConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SmokyFogEvent implements ClientTickEvents.EndWorldTick {
	private static final int MAX_FIRE_BLOCKS = 64;
	private static int fireBlocks = 0;

	private static final int UPDATE_TICKS = 10;
	private static int ticks = 0, targetFireBlocks = 0;

	@Override
	public void onEndTick(ClientWorld world) {
		if (ticks % (fireBlocks < targetFireBlocks ? 1 : 2) == 0) {
			if (fireBlocks > targetFireBlocks) {
				fireBlocks--;
			} else if (fireBlocks < targetFireBlocks) {
				fireBlocks++;
			}
			fireBlocks = MathHelper.clamp(fireBlocks, 0, MAX_FIRE_BLOCKS);
		}
		MinecraftClient client = MinecraftClient.getInstance();
		if (!client.isPaused()) {
			ticks++;
		}
		if (ModConfig.smokyFog) {
			if (ticks % UPDATE_TICKS == 0) {
				int[] counted = {0};
				if (world.getRegistryKey() != World.NETHER) {
					final int range = 16;
					BlockPos.iterateOutwards(client.getCameraEntity().getBlockPos(), range, range, range).forEach(pos -> {
						if (counted[0] < MAX_FIRE_BLOCKS && world.getBlockState(pos).isIn(BlockTags.FIRE)) {
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
	}

	public static boolean hasMaxFireBlocks() {
		return fireBlocks == MAX_FIRE_BLOCKS;
	}

	public static float getProgress() {
		return fireBlocks / (float) MAX_FIRE_BLOCKS;
	}
}
