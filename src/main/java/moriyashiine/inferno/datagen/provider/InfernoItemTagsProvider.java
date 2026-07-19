/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.init.InfernoItems;
import moriyashiine.inferno.common.tag.InfernoBlockTags;
import moriyashiine.inferno.common.tag.InfernoItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
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
		valueLookupBuilder(ItemTags.NON_FLAMMABLE_WOOD)
				.add(InfernoItems.SHINING_OAK_SAPLING)
				.add(InfernoItems.SHINING_OAK_LOG)
				.add(InfernoItems.SHINING_OAK_WOOD)
				.add(InfernoItems.STRIPPED_SHINING_OAK_LOG)
				.add(InfernoItems.STRIPPED_SHINING_OAK_WOOD)
				.add(InfernoItems.SHINING_OAK_PLANKS)
				.add(InfernoItems.SHINING_OAK_STAIRS)
				.add(InfernoItems.SHINING_OAK_SLAB)
				.add(InfernoItems.SHINING_OAK_FENCE)
				.add(InfernoItems.SHINING_OAK_FENCE_GATE)
				.add(InfernoItems.SHINING_OAK_DOOR)
				.add(InfernoItems.SHINING_OAK_TRAPDOOR)
				.add(InfernoItems.SHINING_OAK_PRESSURE_PLATE)
				.add(InfernoItems.SHINING_OAK_BUTTON)
				.add(InfernoItems.SHINING_OAK_SIGN)
				.add(InfernoItems.SHINING_OAK_HANGING_SIGN)
				.add(InfernoItems.SHINING_OAK_RAFT)
				.add(InfernoItems.SHINING_OAK_CHEST_RAFT);
		copy(BlockTags.LOGS, ItemTags.LOGS);
		copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
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
		valueLookupBuilder(ItemTags.SIGNS)
				.add(InfernoItems.SHINING_OAK_SIGN);
		valueLookupBuilder(ItemTags.HANGING_SIGNS)
				.add(InfernoItems.SHINING_OAK_HANGING_SIGN);
		valueLookupBuilder(ItemTags.BOATS)
				.add(InfernoItems.SHINING_OAK_RAFT);
		valueLookupBuilder(ItemTags.CHEST_BOATS)
				.add(InfernoItems.SHINING_OAK_CHEST_RAFT);
		// remains
		copy(BlockTags.GRASS_BLOCKS, ItemTags.GRASS_BLOCKS);
		valueLookupBuilder(ItemTags.FURNACE_MINECART_FUEL)
				.add(InfernoItems.CHARRED_LOG);
		// plants
		valueLookupBuilder(ItemTags.BEE_FOOD)
				.add(InfernoItems.BEARGRASS)
				.add(InfernoItems.GOLDENROD)
				.add(InfernoItems.GOLDEN_POPPY)
				.add(InfernoItems.FIREWEED)
				.add(InfernoItems.PRAIRIE_FIRE);
		copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
	}
}
