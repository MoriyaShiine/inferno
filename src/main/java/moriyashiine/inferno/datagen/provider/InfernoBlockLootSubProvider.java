/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.init.InfernoBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class InfernoBlockLootSubProvider extends FabricBlockLootSubProvider {
	public InfernoBlockLootSubProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(packOutput, registriesFuture);
	}

	@Override
	public void generate() {
		// shining oak
		dropSelf(InfernoBlocks.SHINING_OAK_LOG);
		dropSelf(InfernoBlocks.SHINING_OAK_WOOD);
		dropSelf(InfernoBlocks.STRIPPED_SHINING_OAK_LOG);
		dropSelf(InfernoBlocks.STRIPPED_SHINING_OAK_WOOD);
		dropSelf(InfernoBlocks.SHINING_OAK_SAPLING);
		dropPottedContents(InfernoBlocks.POTTED_SHINING_OAK_SAPLING);
		add(InfernoBlocks.IRON_SHINING_OAK_LEAVES, block -> createLeavesDrops(block, InfernoBlocks.SHINING_OAK_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F));
		add(InfernoBlocks.GOLDEN_SHINING_OAK_LEAVES, block -> createLeavesDrops(block, InfernoBlocks.SHINING_OAK_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F));
		dropSelf(InfernoBlocks.SHINING_OAK_PLANKS);
		dropSelf(InfernoBlocks.SHINING_OAK_STAIRS);
		add(InfernoBlocks.SHINING_OAK_SLAB, this::createSlabItemTable);
		dropSelf(InfernoBlocks.SHINING_OAK_FENCE);
		dropSelf(InfernoBlocks.SHINING_OAK_FENCE_GATE);
		add(InfernoBlocks.SHINING_OAK_DOOR, this::createDoorTable);
		dropSelf(InfernoBlocks.SHINING_OAK_TRAPDOOR);
		dropSelf(InfernoBlocks.SHINING_OAK_PRESSURE_PLATE);
		dropSelf(InfernoBlocks.SHINING_OAK_BUTTON);
		dropSelf(InfernoBlocks.SHINING_OAK_SHELF);
		dropSelf(InfernoBlocks.SHINING_OAK_SIGN);
		dropSelf(InfernoBlocks.SHINING_OAK_HANGING_SIGN);
		// remains
		add(InfernoBlocks.CHARRED_LOG, block -> createSingleItemTableWithSilkTouch(block, Items.CHARCOAL, UniformGenerator.between(1, 4)));
		add(InfernoBlocks.SCORCHED_EARTH, block -> createSingleItemTableWithSilkTouch(block, Items.DIRT));
		// plants
		add(InfernoBlocks.BEARGRASS, block -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
		dropSelf(InfernoBlocks.GOLDENROD);
		dropPottedContents(InfernoBlocks.POTTED_GOLDENROD);
		dropSelf(InfernoBlocks.GOLDEN_POPPY);
		dropPottedContents(InfernoBlocks.POTTED_GOLDEN_POPPY);
		dropSelf(InfernoBlocks.FIREWEED);
		dropPottedContents(InfernoBlocks.POTTED_FIREWEED);
		dropSelf(InfernoBlocks.PRAIRIE_FIRE);
		dropPottedContents(InfernoBlocks.POTTED_PRAIRIE_FIRE);
		// copper fire
		add(InfernoBlocks.COPPER_CAMPFIRE, block -> createSilkTouchDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.COPPER_INGOT).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))));
		add(InfernoBlocks.COPPER_FIRE, noDrop());
	}
}
