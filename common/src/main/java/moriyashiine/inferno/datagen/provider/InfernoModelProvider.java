package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.init.InfernoBlockFamilies;
import moriyashiine.inferno.common.init.InfernoBlocks;
import moriyashiine.inferno.common.init.InfernoItems;
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

public class InfernoModelProvider extends FabricModelProvider {
	public InfernoModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators generators) {
		// shining oak
		generators.createPlantWithDefaultItem(InfernoBlocks.SHINING_OAK_SAPLING, InfernoBlocks.POTTED_SHINING_OAK_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.woodProvider(InfernoBlocks.SHINING_OAK_LOG).logWithHorizontal(InfernoBlocks.SHINING_OAK_LOG).wood(InfernoBlocks.SHINING_OAK_WOOD);
		generators.woodProvider(InfernoBlocks.STRIPPED_SHINING_OAK_LOG).logWithHorizontal(InfernoBlocks.STRIPPED_SHINING_OAK_LOG).wood(InfernoBlocks.STRIPPED_SHINING_OAK_WOOD);
		generators.createTrivialCube(InfernoBlocks.IRON_SHINING_OAK_LEAVES);
		generators.createTrivialCube(InfernoBlocks.GOLDEN_SHINING_OAK_LEAVES);
		generators.family(InfernoBlockFamilies.SHINING_OAK_PLANKS.getBaseBlock()).generateFor(InfernoBlockFamilies.SHINING_OAK_PLANKS);
		generators.createShelf(InfernoBlocks.SHINING_OAK_SHELF, InfernoBlocks.STRIPPED_SHINING_OAK_LOG);
		generators.createHangingSign(InfernoBlocks.STRIPPED_SHINING_OAK_LOG, InfernoBlocks.SHINING_OAK_HANGING_SIGN, InfernoBlocks.SHINING_OAK_WALL_HANGING_SIGN);
		// remains
		generators.createRotatedPillarWithHorizontalVariant(InfernoBlocks.CHARRED_LOG, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
		SLibDataUtils.createGrassLikeBlock(generators, InfernoBlocks.SCORCHED_EARTH);
		// plants
		generators.createDoublePlantWithDefaultItem(InfernoBlocks.BEARGRASS, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.createPlantWithDefaultItem(InfernoBlocks.GOLDENROD, InfernoBlocks.POTTED_GOLDENROD, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.createPlantWithDefaultItem(InfernoBlocks.GOLDEN_POPPY, InfernoBlocks.POTTED_GOLDEN_POPPY, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.createPlantWithDefaultItem(InfernoBlocks.FIREWEED, InfernoBlocks.POTTED_FIREWEED, BlockModelGenerators.PlantType.NOT_TINTED);
		generators.createPlantWithDefaultItem(InfernoBlocks.PRAIRIE_FIRE, InfernoBlocks.POTTED_PRAIRIE_FIRE, BlockModelGenerators.PlantType.NOT_TINTED);
		// copper fire
		generators.createCampfires(InfernoBlocks.COPPER_CAMPFIRE);
		createCopperFire(generators);
	}

	@Override
	public void generateItemModels(ItemModelGenerators generators) {
		generators.generateFlatItem(InfernoItems.SHINING_OAK_RAFT, ModelTemplates.FLAT_ITEM);
		generators.generateFlatItem(InfernoItems.SHINING_OAK_CHEST_RAFT, ModelTemplates.FLAT_ITEM);
	}

	private void createCopperFire(BlockModelGenerators generators) {
		ConditionBuilder builder = condition()
				.term(BlockStateProperties.NORTH, false)
				.term(BlockStateProperties.EAST, false)
				.term(BlockStateProperties.SOUTH, false)
				.term(BlockStateProperties.WEST, false)
				.term(BlockStateProperties.UP, false);
		MultiVariant variant1 = generators.createFloorFireModels(InfernoBlocks.COPPER_FIRE);
		MultiVariant variant2 = generators.createSideFireModels(InfernoBlocks.COPPER_FIRE);
		MultiVariant variant3 = generators.createTopFireModels(InfernoBlocks.COPPER_FIRE);
		generators.blockStateOutput
				.accept(
						MultiPartGenerator.multiPart(InfernoBlocks.COPPER_FIRE)
								.with(builder, variant1)
								.with(or(condition().term(BlockStateProperties.NORTH, true), builder), variant2)
								.with(or(condition().term(BlockStateProperties.EAST, true), builder), variant2.with(Y_ROT_90))
								.with(or(condition().term(BlockStateProperties.SOUTH, true), builder), variant2.with(Y_ROT_180))
								.with(or(condition().term(BlockStateProperties.WEST, true), builder), variant2.with(Y_ROT_270))
								.with(condition().term(BlockStateProperties.UP, true), variant3)
				);
	}
}
