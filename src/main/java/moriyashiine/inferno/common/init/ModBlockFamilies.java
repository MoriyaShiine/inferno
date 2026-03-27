/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;

public class ModBlockFamilies {
	public static final BlockFamily SHINING_OAK = BlockFamilies.familyBuilder(ModBlocks.SHINING_OAK_PLANKS)
			.button(ModBlocks.SHINING_OAK_BUTTON)
			.fence(ModBlocks.SHINING_OAK_FENCE)
			.fenceGate(ModBlocks.SHINING_OAK_FENCE_GATE)
			.pressurePlate(ModBlocks.SHINING_OAK_PRESSURE_PLATE)
			.sign(ModBlocks.SHINING_OAK_SIGN, ModBlocks.SHINING_OAK_WALL_SIGN)
			.slab(ModBlocks.SHINING_OAK_SLAB)
			.stairs(ModBlocks.SHINING_OAK_STAIRS)
			.door(ModBlocks.SHINING_OAK_DOOR)
			.trapdoor(ModBlocks.SHINING_OAK_TRAPDOOR)
			.recipeGroupPrefix("wooden")
			.recipeUnlockedBy("has_planks")
			.getFamily();
}
