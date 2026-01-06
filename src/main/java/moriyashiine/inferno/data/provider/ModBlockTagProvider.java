/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModBlocks;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.data.tag.ProvidedTagBuilder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		// INFERNO
		valueLookupBuilder(ModBlockTags.GENERIC_IRON_BLOCKS)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_IRON)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_IRON)
				.forceAddTag(BlockTags.IRON_ORES);
		valueLookupBuilder(ModBlockTags.GENERIC_GOLD_BLOCKS)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_GOLD)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_GOLD)
				.forceAddTag(BlockTags.GOLD_ORES);

		ProvidedTagBuilder<Block, Block> copperFireBaseBlocks = valueLookupBuilder(ModBlockTags.COPPER_FIRE_BASE_BLOCKS);
		copperFireBaseBlocks.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_COPPER)
				.forceAddTag(BlockTags.COPPER)
				.forceAddTag(BlockTags.COPPER_ORES)
				.forceAddTag(BlockTags.COPPER_CHESTS)
				.forceAddTag(BlockTags.COPPER_GOLEM_STATUES);
		Registries.BLOCK.forEach(block -> {
			Identifier id = Registries.BLOCK.getId(block);
			if (id.getNamespace().equals("minecraft") && id.getPath().contains("copper")) {
				copperFireBaseBlocks.add(block);
			}
		});
		valueLookupBuilder(ModBlockTags.SHINING_OAK_LOGS)
				.add(ModBlocks.SHINING_OAK_LOG)
				.add(ModBlocks.SHINING_OAK_WOOD)
				.add(ModBlocks.STRIPPED_SHINING_OAK_LOG)
				.add(ModBlocks.STRIPPED_SHINING_OAK_WOOD);
		valueLookupBuilder(ModBlockTags.SCORCHED_EARTH_GROWABLES)
				.add(ModBlocks.BEARGRASS)
				.add(ModBlocks.GOLDENROD)
				.add(ModBlocks.GOLDEN_POPPY)
				.add(ModBlocks.FIREWEED)
				.add(ModBlocks.PRAIRIE_FIRE);
		// CONVENTIONAL
		valueLookupBuilder(ConventionalBlockTags.STRIPPED_LOGS)
				.add(ModBlocks.STRIPPED_SHINING_OAK_LOG);
		valueLookupBuilder(ConventionalBlockTags.STRIPPED_WOODS)
				.add(ModBlocks.STRIPPED_SHINING_OAK_WOOD);
		valueLookupBuilder(ConventionalBlockTags.WOODEN_FENCES)
				.add(ModBlocks.SHINING_OAK_FENCE);
		valueLookupBuilder(ConventionalBlockTags.WOODEN_FENCE_GATES)
				.add(ModBlocks.SHINING_OAK_FENCE_GATE);
		// VANILLA
		// shining oak
		valueLookupBuilder(BlockTags.LOGS)
				.addTag(ModBlockTags.SHINING_OAK_LOGS);
		valueLookupBuilder(BlockTags.SAPLINGS)
				.add(ModBlocks.SHINING_OAK_SAPLING);
		valueLookupBuilder(BlockTags.LEAVES)
				.add(ModBlocks.IRON_SHINING_OAK_LEAVES)
				.add(ModBlocks.GOLDEN_SHINING_OAK_LEAVES);
		valueLookupBuilder(BlockTags.PLANKS)
				.add(ModBlocks.SHINING_OAK_PLANKS);
		valueLookupBuilder(BlockTags.WOODEN_STAIRS)
				.add(ModBlocks.SHINING_OAK_STAIRS);
		valueLookupBuilder(BlockTags.WOODEN_SLABS)
				.add(ModBlocks.SHINING_OAK_SLAB);
		valueLookupBuilder(BlockTags.WOODEN_FENCES)
				.add(ModBlocks.SHINING_OAK_FENCE);
		valueLookupBuilder(BlockTags.FENCE_GATES)
				.add(ModBlocks.SHINING_OAK_FENCE_GATE);
		valueLookupBuilder(BlockTags.WOODEN_DOORS)
				.add(ModBlocks.SHINING_OAK_DOOR);
		valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
				.add(ModBlocks.SHINING_OAK_TRAPDOOR);
		valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(ModBlocks.SHINING_OAK_PRESSURE_PLATE);
		valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
				.add(ModBlocks.SHINING_OAK_BUTTON);
		valueLookupBuilder(BlockTags.WOODEN_SHELVES)
				.add(ModBlocks.SHINING_OAK_SHELF);
		valueLookupBuilder(BlockTags.STANDING_SIGNS)
				.add(ModBlocks.SHINING_OAK_SIGN);
		valueLookupBuilder(BlockTags.WALL_SIGNS)
				.add(ModBlocks.SHINING_OAK_WALL_SIGN);
		valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
				.add(ModBlocks.SHINING_OAK_HANGING_SIGN);
		valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
				.add(ModBlocks.SHINING_OAK_WALL_HANGING_SIGN);
		// remains
		valueLookupBuilder(BlockTags.AXE_MINEABLE)
				.add(ModBlocks.CHARRED_LOG);
		valueLookupBuilder(BlockTags.SHOVEL_MINEABLE)
				.add(ModBlocks.SCORCHED_EARTH);
		valueLookupBuilder(BlockTags.DIRT)
				.add(ModBlocks.SCORCHED_EARTH);
		valueLookupBuilder(BlockTags.MUSHROOM_GROW_BLOCK)
				.add(ModBlocks.SCORCHED_EARTH);
		// plants
		valueLookupBuilder(BlockTags.BEE_ATTRACTIVE)
				.add(ModBlocks.BEARGRASS)
				.add(ModBlocks.GOLDENROD)
				.add(ModBlocks.GOLDEN_POPPY)
				.add(ModBlocks.FIREWEED)
				.add(ModBlocks.PRAIRIE_FIRE);
		valueLookupBuilder(BlockTags.FLOWERS)
				.add(ModBlocks.BEARGRASS);
		valueLookupBuilder(BlockTags.SMALL_FLOWERS)
				.add(ModBlocks.GOLDENROD)
				.add(ModBlocks.GOLDEN_POPPY)
				.add(ModBlocks.FIREWEED)
				.add(ModBlocks.PRAIRIE_FIRE);
		// flower pots
		valueLookupBuilder(BlockTags.FLOWER_POTS)
				.add(ModBlocks.POTTED_SHINING_OAK_SAPLING)
				.add(ModBlocks.POTTED_GOLDENROD)
				.add(ModBlocks.POTTED_GOLDEN_POPPY)
				.add(ModBlocks.POTTED_FIREWEED)
				.add(ModBlocks.POTTED_PRAIRIE_FIRE);
		// copper fire
		valueLookupBuilder(BlockTags.AXE_MINEABLE)
				.add(ModBlocks.COPPER_CAMPFIRE);
		valueLookupBuilder(BlockTags.CAMPFIRES)
				.add(ModBlocks.COPPER_CAMPFIRE);
		valueLookupBuilder(BlockTags.FIRE)
				.add(ModBlocks.COPPER_FIRE);
		valueLookupBuilder(BlockTags.INFINIBURN_OVERWORLD)
				.forceAddTag(ConventionalBlockTags.STORAGE_BLOCKS_RAW_COPPER);
	}
}
