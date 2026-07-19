/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.init.InfernoBlocks;
import moriyashiine.inferno.common.tag.InfernoBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class InfernoBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
	public InfernoBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		// INFERNO
		builder(InfernoBlockTags.GENERIC_IRON_BLOCKS)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_IRON)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_IRON)
				.forceAddTag(BlockTags.IRON_ORES);
		builder(InfernoBlockTags.GENERIC_GOLD_BLOCKS)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_GOLD)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_GOLD)
				.forceAddTag(BlockTags.GOLD_ORES);

		TagAppender<ResourceKey<Block>, Block> copperFireBaseBlocks = builder(InfernoBlockTags.COPPER_FIRE_BASE_BLOCKS);
		copperFireBaseBlocks.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_COPPER)
				.forceAddTag(BlockTags.COPPER)
				.forceAddTag(BlockTags.COPPER_ORES)
				.forceAddTag(BlockTags.COPPER_CHESTS)
				.forceAddTag(BlockTags.COPPER_GOLEM_STATUES);
		List<Block> blocks = new ArrayList<>();
		BuiltInRegistries.BLOCK.forEach(blocks::add);
		blocks.sort(Comparator.comparing(b -> b.builtInRegistryHolder().key().identifier().toString()));
		blocks.forEach(block -> {
			Identifier id = BuiltInRegistries.BLOCK.getKey(block);
			if (id.getNamespace().equals("minecraft") && id.getPath().contains("copper")) {
				copperFireBaseBlocks.add(block.builtInRegistryHolder().key());
			}
		});
		valueLookupBuilder(InfernoBlockTags.SHINING_OAK_LOGS)
				.add(InfernoBlocks.SHINING_OAK_LOG)
				.add(InfernoBlocks.SHINING_OAK_WOOD)
				.add(InfernoBlocks.STRIPPED_SHINING_OAK_LOG)
				.add(InfernoBlocks.STRIPPED_SHINING_OAK_WOOD);
		valueLookupBuilder(InfernoBlockTags.SCORCHED_EARTH_GROWABLES)
				.add(InfernoBlocks.BEARGRASS)
				.add(InfernoBlocks.GOLDENROD)
				.add(InfernoBlocks.GOLDEN_POPPY)
				.add(InfernoBlocks.FIREWEED)
				.add(InfernoBlocks.PRAIRIE_FIRE);
		// CONVENTIONAL
		valueLookupBuilder(ConventionalBlockTags.STRIPPED_LOGS)
				.add(InfernoBlocks.STRIPPED_SHINING_OAK_LOG);
		valueLookupBuilder(ConventionalBlockTags.STRIPPED_WOODS)
				.add(InfernoBlocks.STRIPPED_SHINING_OAK_WOOD);
		valueLookupBuilder(ConventionalBlockTags.WOODEN_FENCES)
				.add(InfernoBlocks.SHINING_OAK_FENCE);
		valueLookupBuilder(ConventionalBlockTags.WOODEN_FENCE_GATES)
				.add(InfernoBlocks.SHINING_OAK_FENCE_GATE);
		// VANILLA
		// shining oak
		valueLookupBuilder(BlockTags.LOGS)
				.addTag(InfernoBlockTags.SHINING_OAK_LOGS);
		valueLookupBuilder(BlockTags.SAPLINGS)
				.add(InfernoBlocks.SHINING_OAK_SAPLING);
		valueLookupBuilder(BlockTags.LEAVES)
				.add(InfernoBlocks.IRON_SHINING_OAK_LEAVES)
				.add(InfernoBlocks.GOLDEN_SHINING_OAK_LEAVES);
		valueLookupBuilder(BlockTags.PLANKS)
				.add(InfernoBlocks.SHINING_OAK_PLANKS);
		valueLookupBuilder(BlockTags.WOODEN_STAIRS)
				.add(InfernoBlocks.SHINING_OAK_STAIRS);
		valueLookupBuilder(BlockTags.WOODEN_SLABS)
				.add(InfernoBlocks.SHINING_OAK_SLAB);
		valueLookupBuilder(BlockTags.WOODEN_FENCES)
				.add(InfernoBlocks.SHINING_OAK_FENCE);
		valueLookupBuilder(BlockTags.FENCE_GATES)
				.add(InfernoBlocks.SHINING_OAK_FENCE_GATE);
		valueLookupBuilder(BlockTags.WOODEN_DOORS)
				.add(InfernoBlocks.SHINING_OAK_DOOR);
		valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
				.add(InfernoBlocks.SHINING_OAK_TRAPDOOR);
		valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(InfernoBlocks.SHINING_OAK_PRESSURE_PLATE);
		valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
				.add(InfernoBlocks.SHINING_OAK_BUTTON);
		valueLookupBuilder(BlockTags.WOODEN_SHELVES)
				.add(InfernoBlocks.SHINING_OAK_SHELF);
		valueLookupBuilder(BlockTags.STANDING_SIGNS)
				.add(InfernoBlocks.SHINING_OAK_SIGN);
		valueLookupBuilder(BlockTags.WALL_SIGNS)
				.add(InfernoBlocks.SHINING_OAK_WALL_SIGN);
		valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
				.add(InfernoBlocks.SHINING_OAK_HANGING_SIGN);
		valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
				.add(InfernoBlocks.SHINING_OAK_WALL_HANGING_SIGN);
		// remains
		valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
				.add(InfernoBlocks.CHARRED_LOG);
		valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
				.add(InfernoBlocks.SCORCHED_EARTH);
		valueLookupBuilder(BlockTags.GRASS_BLOCKS)
				.add(InfernoBlocks.SCORCHED_EARTH);
		// plants
		valueLookupBuilder(BlockTags.BEE_ATTRACTIVE)
				.add(InfernoBlocks.BEARGRASS)
				.add(InfernoBlocks.GOLDENROD)
				.add(InfernoBlocks.GOLDEN_POPPY)
				.add(InfernoBlocks.FIREWEED)
				.add(InfernoBlocks.PRAIRIE_FIRE);
		valueLookupBuilder(BlockTags.FLOWERS)
				.add(InfernoBlocks.BEARGRASS);
		valueLookupBuilder(BlockTags.SMALL_FLOWERS)
				.add(InfernoBlocks.GOLDENROD)
				.add(InfernoBlocks.GOLDEN_POPPY)
				.add(InfernoBlocks.FIREWEED)
				.add(InfernoBlocks.PRAIRIE_FIRE);
		// flower pots
		valueLookupBuilder(BlockTags.FLOWER_POTS)
				.add(InfernoBlocks.POTTED_SHINING_OAK_SAPLING)
				.add(InfernoBlocks.POTTED_GOLDENROD)
				.add(InfernoBlocks.POTTED_GOLDEN_POPPY)
				.add(InfernoBlocks.POTTED_FIREWEED)
				.add(InfernoBlocks.POTTED_PRAIRIE_FIRE);
		// copper fire
		valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
				.add(InfernoBlocks.COPPER_CAMPFIRE);
		valueLookupBuilder(BlockTags.CAMPFIRES)
				.add(InfernoBlocks.COPPER_CAMPFIRE);
		valueLookupBuilder(BlockTags.FIRE)
				.add(InfernoBlocks.COPPER_FIRE);
		valueLookupBuilder(BlockTags.INFINIBURN_OVERWORLD)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_COPPER);
	}
}
