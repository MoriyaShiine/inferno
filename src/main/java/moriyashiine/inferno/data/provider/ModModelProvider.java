/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModBlockFamilies;
import moriyashiine.inferno.common.init.ModBlocks;
import moriyashiine.inferno.common.init.ModItems;
import moriyashiine.strawberrylib.api.module.SLibDataUtils;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.ConditionBuilder;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators generators) {
		// shining oak
		generators.createPlantWithDefaultItem(ModBlocks.SHINING_OAK_SAPLING, ModBlocks.POTTED_SHINING_OAK_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.woodProvider(ModBlocks.SHINING_OAK_LOG).logWithHorizontal(ModBlocks.SHINING_OAK_LOG).wood(ModBlocks.SHINING_OAK_WOOD);
		generators.woodProvider(ModBlocks.STRIPPED_SHINING_OAK_LOG).logWithHorizontal(ModBlocks.STRIPPED_SHINING_OAK_LOG).wood(ModBlocks.STRIPPED_SHINING_OAK_WOOD);
		generators.createTrivialCube(ModBlocks.IRON_SHINING_OAK_LEAVES);
		generators.createTrivialCube(ModBlocks.GOLDEN_SHINING_OAK_LEAVES);
		generators.family(ModBlockFamilies.SHINING_OAK.getBaseBlock()).generateFor(ModBlockFamilies.SHINING_OAK);
		generators.createShelf(ModBlocks.SHINING_OAK_SHELF, ModBlocks.STRIPPED_SHINING_OAK_LOG);
		generators.createHangingSign(ModBlocks.STRIPPED_SHINING_OAK_LOG, ModBlocks.SHINING_OAK_HANGING_SIGN, ModBlocks.SHINING_OAK_WALL_HANGING_SIGN);
		// remains
		generators.createRotatedPillarWithHorizontalVariant(ModBlocks.CHARRED_LOG, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
		SLibDataUtils.createGrassLikeBlock(generators, ModBlocks.SCORCHED_EARTH);
		// plants
		generators.createDoublePlantWithDefaultItem(ModBlocks.BEARGRASS, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.createPlantWithDefaultItem(ModBlocks.GOLDENROD, ModBlocks.POTTED_GOLDENROD, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.createPlantWithDefaultItem(ModBlocks.GOLDEN_POPPY, ModBlocks.POTTED_GOLDEN_POPPY, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.createPlantWithDefaultItem(ModBlocks.FIREWEED, ModBlocks.POTTED_FIREWEED, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.createPlantWithDefaultItem(ModBlocks.PRAIRIE_FIRE, ModBlocks.POTTED_PRAIRIE_FIRE, BlockModelGenerators.PlantType.NOT_TINTED);
		// copper fire
		generators.createCampfires(ModBlocks.COPPER_CAMPFIRE);
		registerCopperFire(generators);
	}

	@Override
	public void generateItemModels(ItemModelGenerators generators) {
		generators.generateFlatItem(ModItems.SHINING_OAK_RAFT, ModelTemplates.FLAT_ITEM);
		generators.generateFlatItem(ModItems.SHINING_OAK_CHEST_RAFT, ModelTemplates.FLAT_ITEM);
	}

	private void registerCopperFire(BlockModelGenerators generators) {
		ConditionBuilder builder = condition()
				.term(BlockStateProperties.NORTH, false)
				.term(BlockStateProperties.EAST, false)
				.term(BlockStateProperties.SOUTH, false)
				.term(BlockStateProperties.WEST, false)
				.term(BlockStateProperties.UP, false);
		MultiVariant variant1 = generators.createFloorFireModels(ModBlocks.COPPER_FIRE);
		MultiVariant variant2 = generators.createSideFireModels(ModBlocks.COPPER_FIRE);
		MultiVariant variant3 = generators.createTopFireModels(ModBlocks.COPPER_FIRE);
		generators.blockStateOutput
				.accept(
						MultiPartGenerator.multiPart(ModBlocks.COPPER_FIRE)
								.with(builder, variant1)
								.with(or(condition().term(BlockStateProperties.NORTH, true), builder), variant2)
								.with(or(condition().term(BlockStateProperties.EAST, true), builder), variant2.with(Y_ROT_90))
								.with(or(condition().term(BlockStateProperties.SOUTH, true), builder), variant2.with(Y_ROT_180))
								.with(or(condition().term(BlockStateProperties.WEST, true), builder), variant2.with(Y_ROT_270))
								.with(condition().term(BlockStateProperties.UP, true), variant3)
				);
	}
}
