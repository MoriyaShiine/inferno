/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModBlockFamilies;
import moriyashiine.inferno.common.init.ModBlocks;
import moriyashiine.inferno.common.init.ModItems;
import moriyashiine.strawberrylib.api.module.SLibDataUtils;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.MultipartModelConditionBuilder;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.Properties;

import static net.minecraft.client.data.BlockStateModelGenerator.*;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator generator) {
		// shining oak
		generator.registerFlowerPotPlantAndItem(ModBlocks.SHINING_OAK_SAPLING, ModBlocks.POTTED_SHINING_OAK_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.createLogTexturePool(ModBlocks.SHINING_OAK_LOG).log(ModBlocks.SHINING_OAK_LOG).wood(ModBlocks.SHINING_OAK_WOOD);
		generator.createLogTexturePool(ModBlocks.STRIPPED_SHINING_OAK_LOG).log(ModBlocks.STRIPPED_SHINING_OAK_LOG).wood(ModBlocks.STRIPPED_SHINING_OAK_WOOD);
		generator.registerSimpleCubeAll(ModBlocks.IRON_SHINING_OAK_LEAVES);
		generator.registerSimpleCubeAll(ModBlocks.GOLDEN_SHINING_OAK_LEAVES);
		generator.registerCubeAllModelTexturePool(ModBlockFamilies.SHINING_OAK.getBaseBlock()).family(ModBlockFamilies.SHINING_OAK);
		generator.registerHangingSign(ModBlocks.STRIPPED_SHINING_OAK_LOG, ModBlocks.SHINING_OAK_HANGING_SIGN, ModBlocks.SHINING_OAK_WALL_HANGING_SIGN);
		// remains
		generator.registerAxisRotated(ModBlocks.CHARRED_LOG, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
		SLibDataUtils.generateSoilBlock(generator, ModBlocks.SCORCHED_EARTH);
		// plants
		generator.registerDoubleBlockAndItem(ModBlocks.BEARGRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.registerFlowerPotPlantAndItem(ModBlocks.GOLDENROD, ModBlocks.POTTED_GOLDENROD, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.registerFlowerPotPlantAndItem(ModBlocks.GOLDEN_POPPY, ModBlocks.POTTED_GOLDEN_POPPY, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.registerFlowerPotPlantAndItem(ModBlocks.FIREWEED, ModBlocks.POTTED_FIREWEED, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.registerFlowerPotPlantAndItem(ModBlocks.PRAIRIE_FIRE, ModBlocks.POTTED_PRAIRIE_FIRE, BlockStateModelGenerator.CrossType.NOT_TINTED);
		// copper fire
		generator.registerCampfire(ModBlocks.COPPER_CAMPFIRE);
		registerCopperFire(generator);
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {
		generator.register(ModItems.SHINING_OAK_RAFT, Models.GENERATED);
		generator.register(ModItems.SHINING_OAK_CHEST_RAFT, Models.GENERATED);
	}

	private void registerCopperFire(BlockStateModelGenerator generator) {
		MultipartModelConditionBuilder builder = createMultipartConditionBuilder()
				.put(Properties.NORTH, false)
				.put(Properties.EAST, false)
				.put(Properties.SOUTH, false)
				.put(Properties.WEST, false)
				.put(Properties.UP, false);
		WeightedVariant variant1 = generator.getFireFloorModels(ModBlocks.COPPER_FIRE);
		WeightedVariant variant2 = generator.getFireSideModels(ModBlocks.COPPER_FIRE);
		WeightedVariant variant3 = generator.getFireUpModels(ModBlocks.COPPER_FIRE);
		generator.blockStateCollector
				.accept(
						MultipartBlockModelDefinitionCreator.create(ModBlocks.COPPER_FIRE)
								.with(builder, variant1)
								.with(or(createMultipartConditionBuilder().put(Properties.NORTH, true), builder), variant2)
								.with(or(createMultipartConditionBuilder().put(Properties.EAST, true), builder), variant2.apply(ROTATE_Y_90))
								.with(or(createMultipartConditionBuilder().put(Properties.SOUTH, true), builder), variant2.apply(ROTATE_Y_180))
								.with(or(createMultipartConditionBuilder().put(Properties.WEST, true), builder), variant2.apply(ROTATE_Y_270))
								.with(createMultipartConditionBuilder().put(Properties.UP, true), variant3)
				);
	}
}
