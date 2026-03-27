/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModBlocks;
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

public class ModBlockLootSubProvider extends FabricBlockLootSubProvider {
	public ModBlockLootSubProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(packOutput, registriesFuture);
	}

	@Override
	public void generate() {
		// shining oak
		dropSelf(ModBlocks.SHINING_OAK_LOG);
		dropSelf(ModBlocks.SHINING_OAK_WOOD);
		dropSelf(ModBlocks.STRIPPED_SHINING_OAK_LOG);
		dropSelf(ModBlocks.STRIPPED_SHINING_OAK_WOOD);
		dropSelf(ModBlocks.SHINING_OAK_SAPLING);
		dropPottedContents(ModBlocks.POTTED_SHINING_OAK_SAPLING);
		add(ModBlocks.IRON_SHINING_OAK_LEAVES, block -> createLeavesDrops(block, ModBlocks.SHINING_OAK_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F));
		add(ModBlocks.GOLDEN_SHINING_OAK_LEAVES, block -> createLeavesDrops(block, ModBlocks.SHINING_OAK_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F));
		dropSelf(ModBlocks.SHINING_OAK_PLANKS);
		dropSelf(ModBlocks.SHINING_OAK_STAIRS);
		add(ModBlocks.SHINING_OAK_SLAB, this::createSlabItemTable);
		dropSelf(ModBlocks.SHINING_OAK_FENCE);
		dropSelf(ModBlocks.SHINING_OAK_FENCE_GATE);
		add(ModBlocks.SHINING_OAK_DOOR, this::createDoorTable);
		dropSelf(ModBlocks.SHINING_OAK_TRAPDOOR);
		dropSelf(ModBlocks.SHINING_OAK_PRESSURE_PLATE);
		dropSelf(ModBlocks.SHINING_OAK_BUTTON);
		dropSelf(ModBlocks.SHINING_OAK_SHELF);
		dropSelf(ModBlocks.SHINING_OAK_SIGN);
		dropSelf(ModBlocks.SHINING_OAK_HANGING_SIGN);
		// remains
		add(ModBlocks.CHARRED_LOG, block -> createSingleItemTableWithSilkTouch(block, Items.CHARCOAL, UniformGenerator.between(1, 4)));
		add(ModBlocks.SCORCHED_EARTH, block -> createSingleItemTableWithSilkTouch(block, Items.DIRT));
		// plants
		add(ModBlocks.BEARGRASS, block -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
		dropSelf(ModBlocks.GOLDENROD);
		dropPottedContents(ModBlocks.POTTED_GOLDENROD);
		dropSelf(ModBlocks.GOLDEN_POPPY);
		dropPottedContents(ModBlocks.POTTED_GOLDEN_POPPY);
		dropSelf(ModBlocks.FIREWEED);
		dropPottedContents(ModBlocks.POTTED_FIREWEED);
		dropSelf(ModBlocks.PRAIRIE_FIRE);
		dropPottedContents(ModBlocks.POTTED_PRAIRIE_FIRE);
		// copper fire
		add(ModBlocks.COPPER_CAMPFIRE, block -> createSilkTouchDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.COPPER_INGOT).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))));
		add(ModBlocks.COPPER_FIRE, noDrop());
	}
}
