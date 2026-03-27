/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;

import java.util.Optional;

public class ModTreeGrowers {
	public static final TreeGrower IRON_SHINING_OAK = new TreeGrower(
			Inferno.id("iron_shining_oak").toString(),
			Optional.empty(),
			Optional.of(ModWorldGeneration.IRON_SHINING_OAK_TREE_CONFIGURED),
			Optional.empty()
	);
	public static final TreeGrower GOLDEN_SHINING_OAK = new TreeGrower(
			Inferno.id("golden_shining_oak").toString(),
			Optional.empty(),
			Optional.of(ModWorldGeneration.GOLDEN_SHINING_OAK_TREE_CONFIGURED),
			Optional.empty()
	);

	public static TreeConfiguration.TreeConfigurationBuilder ironShiningOak() {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ModBlocks.SHINING_OAK_LOG),
				new CherryTrunkPlacer(
						7,
						1,
						0,
						UniformInt.of(2, 3),
						UniformInt.of(2, 4),
						UniformInt.of(-4, -3),
						UniformInt.of(-1, 0)
				),
				BlockStateProvider.simple(ModBlocks.IRON_SHINING_OAK_LEAVES),
				new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
				new TwoLayersFeatureSize(1, 0, 2)
		).ignoreVines();
	}

	public static TreeConfiguration.TreeConfigurationBuilder goldenShiningOak() {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ModBlocks.SHINING_OAK_LOG),
				new CherryTrunkPlacer(
						7,
						1,
						0,
						UniformInt.of(2, 3),
						UniformInt.of(2, 4),
						UniformInt.of(-4, -3),
						UniformInt.of(-1, 0)
				),
				BlockStateProvider.simple(ModBlocks.GOLDEN_SHINING_OAK_LEAVES),
				new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
				new TwoLayersFeatureSize(1, 0, 2)
		).ignoreVines();
	}
}
