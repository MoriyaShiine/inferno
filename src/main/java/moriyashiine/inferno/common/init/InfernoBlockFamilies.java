/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;

public class InfernoBlockFamilies {
	public static final BlockFamily SHINING_OAK_PLANKS = BlockFamilies.familyBuilder(InfernoBlocks.SHINING_OAK_PLANKS)
			.button(InfernoBlocks.SHINING_OAK_BUTTON)
			.fence(InfernoBlocks.SHINING_OAK_FENCE)
			.fenceGate(InfernoBlocks.SHINING_OAK_FENCE_GATE)
			.pressurePlate(InfernoBlocks.SHINING_OAK_PRESSURE_PLATE)
			.sign(InfernoBlocks.SHINING_OAK_SIGN, InfernoBlocks.SHINING_OAK_WALL_SIGN)
			.slab(InfernoBlocks.SHINING_OAK_SLAB)
			.stairs(InfernoBlocks.SHINING_OAK_STAIRS)
			.door(InfernoBlocks.SHINING_OAK_DOOR)
			.trapdoor(InfernoBlocks.SHINING_OAK_TRAPDOOR)
			.recipeGroupPrefix("wooden")
			.recipeUnlockedBy("has_planks")
			.getFamily();
}
