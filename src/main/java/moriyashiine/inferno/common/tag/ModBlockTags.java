/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.tag;

import moriyashiine.inferno.common.Inferno;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModBlockTags {
	public static final TagKey<Block> GENERIC_COPPER_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Inferno.id("generic_copper_blocks"));
	public static final TagKey<Block> GENERIC_IRON_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Inferno.id("generic_iron_blocks"));
	public static final TagKey<Block> GENERIC_GOLD_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Inferno.id("generic_gold_blocks"));

	public static final TagKey<Block> COPPER_FIRE_BASE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Inferno.id("copper_fire_base_blocks"));
	public static final TagKey<Block> SHINING_OAK_LOGS = TagKey.of(RegistryKeys.BLOCK, Inferno.id("shining_oak_logs"));
	public static final TagKey<Block> SCORCHED_EARTH_GROWABLES = TagKey.of(RegistryKeys.BLOCK, Inferno.id("scorched_earth_growables"));
}
