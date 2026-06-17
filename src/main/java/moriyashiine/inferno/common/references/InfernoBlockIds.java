/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.references;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.key;

public class InfernoBlockIds {
	// shining oak
	public static final ResourceKey<Block> POTTED_SHINING_OAK_SAPLING = key(Registries.BLOCK, "potted_shining_oak_sapling");
	public static final ResourceKey<Block> SHINING_OAK_WALL_SIGN = key(Registries.BLOCK, "shining_oak_wall_sign");
	public static final ResourceKey<Block> SHINING_OAK_WALL_HANGING_SIGN = key(Registries.BLOCK, "shining_oak_wall_hanging_sign");
	// plants
	public static final ResourceKey<Block> POTTED_GOLDENROD = key(Registries.BLOCK, "potted_goldenrod");
	public static final ResourceKey<Block> POTTED_GOLDEN_POPPY = key(Registries.BLOCK, "potted_golden_poppy");
	public static final ResourceKey<Block> POTTED_FIREWEED = key(Registries.BLOCK, "potted_fireweed");
	public static final ResourceKey<Block> POTTED_PRAIRIE_FIRE = key(Registries.BLOCK, "potted_prairie_fire");
	// copper fire
	public static final ResourceKey<Block> COPPER_FIRE = key(Registries.BLOCK, "copper_fire");

}
