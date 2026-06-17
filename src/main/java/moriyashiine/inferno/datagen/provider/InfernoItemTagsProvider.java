/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.references.InfernoBlockItemIds;
import moriyashiine.inferno.common.references.InfernoItemIds;
import moriyashiine.inferno.common.tag.InfernoBlockTags;
import moriyashiine.inferno.common.tag.InfernoItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class InfernoItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
	public InfernoItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, @Nullable BlockTagsProvider blockTagsProvider) {
		super(output, registriesFuture, blockTagsProvider);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		// copies
		copy(InfernoBlockTags.SHINING_OAK_LOGS, InfernoItemTags.SHINING_OAK_LOGS);
		// CONVENTIONAL
		// shining oak
		copy(ConventionalBlockTags.STRIPPED_LOGS, ConventionalItemTags.STRIPPED_LOGS);
		copy(ConventionalBlockTags.STRIPPED_WOODS, ConventionalItemTags.STRIPPED_WOODS);
		copy(ConventionalBlockTags.WOODEN_FENCES, ConventionalItemTags.WOODEN_FENCES);
		copy(ConventionalBlockTags.WOODEN_FENCE_GATES, ConventionalItemTags.WOODEN_FENCE_GATES);
		// VANILLA
		// shining oak
		builder(ItemTags.NON_FLAMMABLE_WOOD)
				.add(InfernoBlockItemIds.SHINING_OAK_SAPLING)
				.add(InfernoBlockItemIds.SHINING_OAK_LOG)
				.add(InfernoBlockItemIds.SHINING_OAK_WOOD)
				.add(InfernoBlockItemIds.STRIPPED_SHINING_OAK_LOG)
				.add(InfernoBlockItemIds.STRIPPED_SHINING_OAK_WOOD)
				.add(InfernoBlockItemIds.SHINING_OAK_PLANKS)
				.add(InfernoBlockItemIds.SHINING_OAK_STAIRS)
				.add(InfernoBlockItemIds.SHINING_OAK_SLAB)
				.add(InfernoBlockItemIds.SHINING_OAK_FENCE)
				.add(InfernoBlockItemIds.SHINING_OAK_FENCE_GATE)
				.add(InfernoBlockItemIds.SHINING_OAK_DOOR)
				.add(InfernoBlockItemIds.SHINING_OAK_TRAPDOOR)
				.add(InfernoBlockItemIds.SHINING_OAK_PRESSURE_PLATE)
				.add(InfernoBlockItemIds.SHINING_OAK_BUTTON)
				.add(InfernoBlockItemIds.SHINING_OAK_SIGN)
				.add(InfernoBlockItemIds.SHINING_OAK_HANGING_SIGN)
				.add(InfernoItemIds.SHINING_OAK_RAFT)
				.add(InfernoItemIds.SHINING_OAK_CHEST_RAFT);
		copy(BlockTags.LOGS, ItemTags.LOGS);
		copy(BlockItemTags.SAPLINGS.block(), ItemTags.SAPLINGS);
		copy(BlockTags.LEAVES, ItemTags.LEAVES);
		copy(BlockTags.PLANKS, ItemTags.PLANKS);
		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
		copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
		copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
		copy(BlockTags.WOODEN_SHELVES, ItemTags.WOODEN_SHELVES);
		builder(ItemTags.SIGNS)
				.add(InfernoBlockItemIds.SHINING_OAK_SIGN);
		builder(ItemTags.HANGING_SIGNS)
				.add(InfernoBlockItemIds.SHINING_OAK_HANGING_SIGN);
		builder(ItemTags.BOATS)
				.add(InfernoItemIds.SHINING_OAK_RAFT);
		builder(ItemTags.CHEST_BOATS)
				.add(InfernoItemIds.SHINING_OAK_CHEST_RAFT);
		// remains
		copy(BlockTags.GRASS_BLOCKS, BlockItemTags.GRASS_BLOCKS.item());
		builder(ItemTags.FURNACE_MINECART_FUEL)
				.add(InfernoBlockItemIds.CHARRED_LOG);
		// plants
		builder(ItemTags.BEE_FOOD)
				.add(InfernoBlockItemIds.BEARGRASS)
				.add(InfernoBlockItemIds.GOLDENROD)
				.add(InfernoBlockItemIds.GOLDEN_POPPY)
				.add(InfernoBlockItemIds.FIREWEED)
				.add(InfernoBlockItemIds.PRAIRIE_FIRE);
		copy(BlockTags.SMALL_FLOWERS, BlockItemTags.SMALL_FLOWERS.item());
	}
}
