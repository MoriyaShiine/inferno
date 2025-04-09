/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;

import java.util.Optional;

public class ModSaplingGenerators {
	public static final SaplingGenerator IRON_SHINING_OAK = new SaplingGenerator(
			Inferno.id("iron_shining_oak").toString(),
			Optional.empty(),
			Optional.of(ModWorldGeneration.IRON_SHINING_OAK_TREE_CONFIGURED),
			Optional.empty()
	);
	public static final SaplingGenerator GOLDEN_SHINING_OAK = new SaplingGenerator(
			Inferno.id("golden_shining_oak").toString(),
			Optional.empty(),
			Optional.of(ModWorldGeneration.GOLDEN_SHINING_OAK_TREE_CONFIGURED),
			Optional.empty()
	);

	public static TreeFeatureConfig.Builder ironShiningOak() {
		return new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ModBlocks.SHINING_OAK_LOG),
				new CherryTrunkPlacer(
						7,
						1,
						0,
						UniformIntProvider.create(2, 3),
						UniformIntProvider.create(2, 4),
						UniformIntProvider.create(-4, -3),
						UniformIntProvider.create(-1, 0)
				),
				BlockStateProvider.of(ModBlocks.IRON_SHINING_OAK_LEAVES),
				new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
				new TwoLayersFeatureSize(1, 0, 2)
		).ignoreVines();
	}

	public static TreeFeatureConfig.Builder goldenShiningOak() {
		return new TreeFeatureConfig.Builder(
				BlockStateProvider.of(ModBlocks.SHINING_OAK_LOG),
				new CherryTrunkPlacer(
						7,
						1,
						0,
						UniformIntProvider.create(2, 3),
						UniformIntProvider.create(2, 4),
						UniformIntProvider.create(-4, -3),
						UniformIntProvider.create(-1, 0)
				),
				BlockStateProvider.of(ModBlocks.GOLDEN_SHINING_OAK_LEAVES),
				new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
				new TwoLayersFeatureSize(1, 0, 2)
		).ignoreVines();
	}
}
