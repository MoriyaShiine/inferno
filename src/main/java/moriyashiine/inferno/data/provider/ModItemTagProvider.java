/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModItems;
import moriyashiine.inferno.common.tag.ModBlockTags;
import moriyashiine.inferno.common.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, BlockTagProvider blockTagProvider) {
		super(output, registriesFuture, blockTagProvider);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		// copies
		copy(ModBlockTags.SHINING_OAK_LOGS, ModItemTags.SHINING_OAK_LOGS);
		// CONVENTIONAL
		// shining oak
		copy(ConventionalBlockTags.STRIPPED_LOGS, ConventionalItemTags.STRIPPED_LOGS);
		copy(ConventionalBlockTags.STRIPPED_WOODS, ConventionalItemTags.STRIPPED_WOODS);
		copy(ConventionalBlockTags.WOODEN_FENCES, ConventionalItemTags.WOODEN_FENCES);
		copy(ConventionalBlockTags.WOODEN_FENCE_GATES, ConventionalItemTags.WOODEN_FENCE_GATES);
		// VANILLA
		// shining oak
		valueLookupBuilder(ItemTags.NON_FLAMMABLE_WOOD)
				.add(ModItems.SHINING_OAK_SAPLING)
				.add(ModItems.SHINING_OAK_LOG)
				.add(ModItems.SHINING_OAK_WOOD)
				.add(ModItems.STRIPPED_SHINING_OAK_LOG)
				.add(ModItems.STRIPPED_SHINING_OAK_WOOD)
				.add(ModItems.SHINING_OAK_PLANKS)
				.add(ModItems.SHINING_OAK_STAIRS)
				.add(ModItems.SHINING_OAK_SLAB)
				.add(ModItems.SHINING_OAK_FENCE)
				.add(ModItems.SHINING_OAK_FENCE_GATE)
				.add(ModItems.SHINING_OAK_DOOR)
				.add(ModItems.SHINING_OAK_TRAPDOOR)
				.add(ModItems.SHINING_OAK_PRESSURE_PLATE)
				.add(ModItems.SHINING_OAK_BUTTON)
				.add(ModItems.SHINING_OAK_SIGN)
				.add(ModItems.SHINING_OAK_HANGING_SIGN)
				.add(ModItems.SHINING_OAK_RAFT)
				.add(ModItems.SHINING_OAK_CHEST_RAFT);
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
		valueLookupBuilder(ItemTags.SIGNS)
				.add(ModItems.SHINING_OAK_SIGN);
		valueLookupBuilder(ItemTags.HANGING_SIGNS)
				.add(ModItems.SHINING_OAK_HANGING_SIGN);
		valueLookupBuilder(ItemTags.BOATS)
				.add(ModItems.SHINING_OAK_RAFT);
		valueLookupBuilder(ItemTags.CHEST_BOATS)
				.add(ModItems.SHINING_OAK_CHEST_RAFT);
		// remains
		copy(BlockTags.DIRT, ItemTags.DIRT);
		valueLookupBuilder(ItemTags.FURNACE_MINECART_FUEL)
				.add(ModItems.CHARRED_LOG);
		// plants
		valueLookupBuilder(ItemTags.BEE_FOOD)
				.add(ModItems.BEARGRASS)
				.add(ModItems.GOLDENROD)
				.add(ModItems.GOLDEN_POPPY)
				.add(ModItems.FIREWEED)
				.add(ModItems.PRAIRIE_FIRE);
		copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
	}
}
