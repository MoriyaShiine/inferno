/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.tag;

import moriyashiine.inferno.common.Inferno;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
	public static final TagKey<Block> GENERIC_IRON_BLOCKS = TagKey.create(Registries.BLOCK, Inferno.id("generic_iron_blocks"));
	public static final TagKey<Block> GENERIC_GOLD_BLOCKS = TagKey.create(Registries.BLOCK, Inferno.id("generic_gold_blocks"));

	public static final TagKey<Block> COPPER_FIRE_BASE_BLOCKS = TagKey.create(Registries.BLOCK, Inferno.id("copper_fire_base_blocks"));
	public static final TagKey<Block> SHINING_OAK_LOGS = TagKey.create(Registries.BLOCK, Inferno.id("shining_oak_logs"));
	public static final TagKey<Block> SCORCHED_EARTH_GROWABLES = TagKey.create(Registries.BLOCK, Inferno.id("scorched_earth_growables"));
}
