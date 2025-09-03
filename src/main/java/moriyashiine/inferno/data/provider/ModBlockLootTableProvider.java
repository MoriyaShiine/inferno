/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
	public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		// shining oak
		addDrop(ModBlocks.SHINING_OAK_LOG);
		addDrop(ModBlocks.SHINING_OAK_WOOD);
		addDrop(ModBlocks.STRIPPED_SHINING_OAK_LOG);
		addDrop(ModBlocks.STRIPPED_SHINING_OAK_WOOD);
		addDrop(ModBlocks.SHINING_OAK_SAPLING);
		addPottedPlantDrops(ModBlocks.POTTED_SHINING_OAK_SAPLING);
		addDrop(ModBlocks.IRON_SHINING_OAK_LEAVES, block -> leavesDrops(block, ModBlocks.SHINING_OAK_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F));
		addDrop(ModBlocks.GOLDEN_SHINING_OAK_LEAVES, block -> leavesDrops(block, ModBlocks.SHINING_OAK_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F));
		addDrop(ModBlocks.SHINING_OAK_PLANKS);
		addDrop(ModBlocks.SHINING_OAK_STAIRS);
		addDrop(ModBlocks.SHINING_OAK_SLAB, this::slabDrops);
		addDrop(ModBlocks.SHINING_OAK_FENCE);
		addDrop(ModBlocks.SHINING_OAK_FENCE_GATE);
		addDrop(ModBlocks.SHINING_OAK_DOOR, this::doorDrops);
		addDrop(ModBlocks.SHINING_OAK_TRAPDOOR);
		addDrop(ModBlocks.SHINING_OAK_PRESSURE_PLATE);
		addDrop(ModBlocks.SHINING_OAK_BUTTON);
		addDrop(ModBlocks.SHINING_OAK_SIGN);
		addDrop(ModBlocks.SHINING_OAK_HANGING_SIGN);
		// remains
		addDrop(ModBlocks.CHARRED_LOG, block -> drops(block, Items.CHARCOAL, UniformLootNumberProvider.create(1, 4)));
		addDrop(ModBlocks.SCORCHED_EARTH, block -> drops(block, Items.DIRT));
		// plants
		addDrop(ModBlocks.BEARGRASS, block -> dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
		addDrop(ModBlocks.GOLDENROD);
		addPottedPlantDrops(ModBlocks.POTTED_GOLDENROD);
		addDrop(ModBlocks.GOLDEN_POPPY);
		addPottedPlantDrops(ModBlocks.POTTED_GOLDEN_POPPY);
		addDrop(ModBlocks.FIREWEED);
		addPottedPlantDrops(ModBlocks.POTTED_FIREWEED);
		addDrop(ModBlocks.PRAIRIE_FIRE);
		addPottedPlantDrops(ModBlocks.POTTED_PRAIRIE_FIRE);
		// copper fire
		addDrop(ModBlocks.COPPER_CAMPFIRE, block -> dropsWithSilkTouch(block, addSurvivesExplosionCondition(block, ItemEntry.builder(Items.COPPER_INGOT).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))))));
		addDrop(ModBlocks.COPPER_FIRE, dropsNothing());
	}
}
