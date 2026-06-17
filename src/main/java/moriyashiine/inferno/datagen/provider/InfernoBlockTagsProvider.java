/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.references.InfernoBlockIds;
import moriyashiine.inferno.common.references.InfernoBlockItemIds;
import moriyashiine.inferno.common.tag.InfernoBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.tags.BlockItemTagAppender;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockItemTags;
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

		BlockItemTagAppender<Block> copperFireBaseBlocks = builder(InfernoBlockTags.COPPER_FIRE_BASE_BLOCKS);
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
		builder(InfernoBlockTags.SHINING_OAK_LOGS)
				.add(InfernoBlockItemIds.SHINING_OAK_LOG)
				.add(InfernoBlockItemIds.SHINING_OAK_WOOD)
				.add(InfernoBlockItemIds.STRIPPED_SHINING_OAK_LOG)
				.add(InfernoBlockItemIds.STRIPPED_SHINING_OAK_WOOD);
		builder(InfernoBlockTags.SCORCHED_EARTH_GROWABLES)
				.add(InfernoBlockItemIds.BEARGRASS)
				.add(InfernoBlockItemIds.GOLDENROD)
				.add(InfernoBlockItemIds.GOLDEN_POPPY)
				.add(InfernoBlockItemIds.FIREWEED)
				.add(InfernoBlockItemIds.PRAIRIE_FIRE);
		// CONVENTIONAL
		builder(ConventionalBlockTags.STRIPPED_LOGS)
				.add(InfernoBlockItemIds.STRIPPED_SHINING_OAK_LOG);
		builder(ConventionalBlockTags.STRIPPED_WOODS)
				.add(InfernoBlockItemIds.STRIPPED_SHINING_OAK_WOOD);
		builder(ConventionalBlockTags.WOODEN_FENCES)
				.add(InfernoBlockItemIds.SHINING_OAK_FENCE);
		builder(ConventionalBlockTags.WOODEN_FENCE_GATES)
				.add(InfernoBlockItemIds.SHINING_OAK_FENCE_GATE);
		// VANILLA
		// shining oak
		builder(BlockTags.LOGS)
				.addTag(InfernoBlockTags.SHINING_OAK_LOGS);
		builder(BlockItemTags.SAPLINGS.block())
				.add(InfernoBlockItemIds.SHINING_OAK_SAPLING);
		builder(BlockTags.LEAVES)
				.add(InfernoBlockItemIds.IRON_SHINING_OAK_LEAVES)
				.add(InfernoBlockItemIds.GOLDEN_SHINING_OAK_LEAVES);
		builder(BlockTags.PLANKS)
				.add(InfernoBlockItemIds.SHINING_OAK_PLANKS);
		builder(BlockTags.WOODEN_STAIRS)
				.add(InfernoBlockItemIds.SHINING_OAK_STAIRS);
		builder(BlockTags.WOODEN_SLABS)
				.add(InfernoBlockItemIds.SHINING_OAK_SLAB);
		builder(BlockTags.WOODEN_FENCES)
				.add(InfernoBlockItemIds.SHINING_OAK_FENCE);
		builder(BlockTags.FENCE_GATES)
				.add(InfernoBlockItemIds.SHINING_OAK_FENCE_GATE);
		builder(BlockTags.WOODEN_DOORS)
				.add(InfernoBlockItemIds.SHINING_OAK_DOOR);
		builder(BlockTags.WOODEN_TRAPDOORS)
				.add(InfernoBlockItemIds.SHINING_OAK_TRAPDOOR);
		builder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(InfernoBlockItemIds.SHINING_OAK_PRESSURE_PLATE);
		builder(BlockTags.WOODEN_BUTTONS)
				.add(InfernoBlockItemIds.SHINING_OAK_BUTTON);
		builder(BlockTags.WOODEN_SHELVES)
				.add(InfernoBlockItemIds.SHINING_OAK_SHELF);
		builder(BlockTags.STANDING_SIGNS)
				.add(InfernoBlockItemIds.SHINING_OAK_SIGN);
		builder(BlockTags.WALL_SIGNS)
				.add(InfernoBlockIds.SHINING_OAK_WALL_SIGN);
		builder(BlockTags.CEILING_HANGING_SIGNS)
				.add(InfernoBlockItemIds.SHINING_OAK_HANGING_SIGN);
		builder(BlockTags.WALL_HANGING_SIGNS)
				.add(InfernoBlockIds.SHINING_OAK_WALL_HANGING_SIGN);
		// remains
		builder(BlockTags.MINEABLE_WITH_AXE)
				.add(InfernoBlockItemIds.CHARRED_LOG);
		builder(BlockTags.MINEABLE_WITH_SHOVEL)
				.add(InfernoBlockItemIds.SCORCHED_EARTH);
		builder(BlockTags.GRASS_BLOCKS)
				.add(InfernoBlockItemIds.SCORCHED_EARTH);
		// plants
		builder(BlockTags.BEE_ATTRACTIVE)
				.add(InfernoBlockItemIds.BEARGRASS)
				.add(InfernoBlockItemIds.GOLDENROD)
				.add(InfernoBlockItemIds.GOLDEN_POPPY)
				.add(InfernoBlockItemIds.FIREWEED)
				.add(InfernoBlockItemIds.PRAIRIE_FIRE);
		builder(BlockTags.FLOWERS)
				.add(InfernoBlockItemIds.BEARGRASS);
		builder(BlockTags.SMALL_FLOWERS)
				.add(InfernoBlockItemIds.GOLDENROD)
				.add(InfernoBlockItemIds.GOLDEN_POPPY)
				.add(InfernoBlockItemIds.FIREWEED)
				.add(InfernoBlockItemIds.PRAIRIE_FIRE);
		// flower pots
		builder(BlockTags.FLOWER_POTS)
				.add(InfernoBlockIds.POTTED_SHINING_OAK_SAPLING)
				.add(InfernoBlockIds.POTTED_GOLDENROD)
				.add(InfernoBlockIds.POTTED_GOLDEN_POPPY)
				.add(InfernoBlockIds.POTTED_FIREWEED)
				.add(InfernoBlockIds.POTTED_PRAIRIE_FIRE);
		// copper fire
		builder(BlockTags.MINEABLE_WITH_AXE)
				.add(InfernoBlockItemIds.COPPER_CAMPFIRE);
		builder(BlockTags.CAMPFIRES)
				.add(InfernoBlockItemIds.COPPER_CAMPFIRE);
		builder(BlockTags.FIRE)
				.add(InfernoBlockIds.COPPER_FIRE);
		builder(BlockTags.INFINIBURN_OVERWORLD)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_COPPER);
	}
}
