/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModWorldGeneration {
	public static final ResourceKey<ConfiguredFeature<?, ?>> IRON_SHINING_OAK_TREE_CONFIGURED = ResourceKey.create(Registries.CONFIGURED_FEATURE, Inferno.id("iron_shining_oak_tree"));
	public static final ResourceKey<PlacedFeature> IRON_SHINING_OAK_TREE = ResourceKey.create(Registries.PLACED_FEATURE, Inferno.id("iron_shining_oak_tree"));

	public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_SHINING_OAK_TREE_CONFIGURED = ResourceKey.create(Registries.CONFIGURED_FEATURE, Inferno.id("golden_shining_oak_tree"));
	public static final ResourceKey<PlacedFeature> GOLDEN_SHINING_OAK_TREE = ResourceKey.create(Registries.PLACED_FEATURE, Inferno.id("golden_shining_oak_tree"));

	public static void bootstrapConfigured(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		FeatureUtils.register(context, IRON_SHINING_OAK_TREE_CONFIGURED, Feature.TREE, ModTreeGrowers.ironShiningOak().build());
		FeatureUtils.register(context, GOLDEN_SHINING_OAK_TREE_CONFIGURED, Feature.TREE, ModTreeGrowers.goldenShiningOak().build());
	}

	public static void bootstrapPlaced(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> featureLookup = context.lookup(Registries.CONFIGURED_FEATURE);
		PlacementUtils.register(context, IRON_SHINING_OAK_TREE, featureLookup.getOrThrow(IRON_SHINING_OAK_TREE_CONFIGURED), PlacementUtils.filteredByBlockSurvival(ModBlocks.SHINING_OAK_SAPLING));
		PlacementUtils.register(context, GOLDEN_SHINING_OAK_TREE, featureLookup.getOrThrow(GOLDEN_SHINING_OAK_TREE_CONFIGURED), PlacementUtils.filteredByBlockSurvival(ModBlocks.SHINING_OAK_SAPLING));
	}
}
