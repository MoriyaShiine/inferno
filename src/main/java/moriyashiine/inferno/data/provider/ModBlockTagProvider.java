/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModBlocks;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		// INFERNO
		getOrCreateTagBuilder(ModBlockTags.GENERIC_IRON_BLOCKS)
				.addOptionalTag(ConventionalBlockTags.IRON_ORES)
				.addOptionalTag(ConventionalBlockTags.STORAGE_BLOCKS_IRON)
				.addOptionalTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_IRON);
		getOrCreateTagBuilder(ModBlockTags.GENERIC_GOLD_BLOCKS)
				.addOptionalTag(ConventionalBlockTags.GOLD_ORES)
				.addOptionalTag(ConventionalBlockTags.STORAGE_BLOCKS_GOLD)
				.addOptionalTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_GOLD);

		getOrCreateTagBuilder(ModBlockTags.SHINING_OAK_LOGS)
				.add(ModBlocks.SHINING_OAK_LOG)
				.add(ModBlocks.SHINING_OAK_WOOD)
				.add(ModBlocks.STRIPPED_SHINING_OAK_LOG)
				.add(ModBlocks.STRIPPED_SHINING_OAK_WOOD);
		getOrCreateTagBuilder(ModBlockTags.SCORCHED_EARTH_GROWABLES)
				.add(ModBlocks.BEARGRASS)
				.add(ModBlocks.GOLDENROD)
				.add(ModBlocks.GOLDEN_POPPY)
				.add(ModBlocks.FIREWEED)
				.add(ModBlocks.PRAIRIE_FIRE);
		// CONVENTIONAL
		getOrCreateTagBuilder(ConventionalBlockTags.STRIPPED_LOGS)
				.add(ModBlocks.STRIPPED_SHINING_OAK_LOG);
		getOrCreateTagBuilder(ConventionalBlockTags.STRIPPED_WOODS)
				.add(ModBlocks.STRIPPED_SHINING_OAK_WOOD);
		getOrCreateTagBuilder(ConventionalBlockTags.WOODEN_FENCES)
				.add(ModBlocks.SHINING_OAK_FENCE);
		getOrCreateTagBuilder(ConventionalBlockTags.WOODEN_FENCE_GATES)
				.add(ModBlocks.SHINING_OAK_FENCE_GATE);
		// VANILLA
		// shining oak
		getOrCreateTagBuilder(BlockTags.LOGS)
				.addTag(ModBlockTags.SHINING_OAK_LOGS);
		getOrCreateTagBuilder(BlockTags.SAPLINGS)
				.add(ModBlocks.SHINING_OAK_SAPLING);
		getOrCreateTagBuilder(BlockTags.LEAVES)
				.add(ModBlocks.IRON_SHINING_OAK_LEAVES)
				.add(ModBlocks.GOLDEN_SHINING_OAK_LEAVES);
		getOrCreateTagBuilder(BlockTags.PLANKS)
				.add(ModBlocks.SHINING_OAK_PLANKS);
		getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
				.add(ModBlocks.SHINING_OAK_STAIRS);
		getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
				.add(ModBlocks.SHINING_OAK_SLAB);
		getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
				.add(ModBlocks.SHINING_OAK_FENCE);
		getOrCreateTagBuilder(BlockTags.FENCE_GATES)
				.add(ModBlocks.SHINING_OAK_FENCE_GATE);
		getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
				.add(ModBlocks.SHINING_OAK_DOOR);
		getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
				.add(ModBlocks.SHINING_OAK_TRAPDOOR);
		getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(ModBlocks.SHINING_OAK_PRESSURE_PLATE);
		getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
				.add(ModBlocks.SHINING_OAK_BUTTON);
		getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
				.add(ModBlocks.SHINING_OAK_SIGN);
		getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
				.add(ModBlocks.SHINING_OAK_WALL_SIGN);
		getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
				.add(ModBlocks.SHINING_OAK_HANGING_SIGN);
		getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
				.add(ModBlocks.SHINING_OAK_WALL_HANGING_SIGN);
		// remains
		getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
				.add(ModBlocks.CHARRED_LOG);
		getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
				.add(ModBlocks.SCORCHED_EARTH);
		getOrCreateTagBuilder(BlockTags.DIRT)
				.add(ModBlocks.SCORCHED_EARTH);
		getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK)
				.add(ModBlocks.SCORCHED_EARTH);
		// plants
		getOrCreateTagBuilder(BlockTags.BEE_ATTRACTIVE)
				.add(ModBlocks.BEARGRASS)
				.add(ModBlocks.GOLDENROD)
				.add(ModBlocks.GOLDEN_POPPY)
				.add(ModBlocks.FIREWEED)
				.add(ModBlocks.PRAIRIE_FIRE);
		getOrCreateTagBuilder(BlockTags.FLOWERS)
				.add(ModBlocks.BEARGRASS);
		getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
				.add(ModBlocks.GOLDENROD)
				.add(ModBlocks.GOLDEN_POPPY)
				.add(ModBlocks.FIREWEED)
				.add(ModBlocks.PRAIRIE_FIRE);
		// flower pots
		getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
				.add(ModBlocks.POTTED_SHINING_OAK_SAPLING)
				.add(ModBlocks.POTTED_GOLDENROD)
				.add(ModBlocks.POTTED_GOLDEN_POPPY)
				.add(ModBlocks.POTTED_FIREWEED)
				.add(ModBlocks.POTTED_PRAIRIE_FIRE);
	}
}
