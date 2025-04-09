/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.*;

public class ModWorldGeneration {
	public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_SHINING_OAK_TREE_CONFIGURED = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Inferno.id("iron_shining_oak_tree"));
	public static final RegistryKey<PlacedFeature> IRON_SHINING_OAK_TREE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Inferno.id("iron_shining_oak_tree"));

	public static final RegistryKey<ConfiguredFeature<?, ?>> GOLDEN_SHINING_OAK_TREE_CONFIGURED = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Inferno.id("golden_shining_oak_tree"));
	public static final RegistryKey<PlacedFeature> GOLDEN_SHINING_OAK_TREE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Inferno.id("golden_shining_oak_tree"));

	public static void bootstrapConfigured(Registerable<ConfiguredFeature<?, ?>> registerable) {
		ConfiguredFeatures.register(registerable, IRON_SHINING_OAK_TREE_CONFIGURED, Feature.TREE, ModSaplingGenerators.ironShiningOak().build());
		ConfiguredFeatures.register(registerable, GOLDEN_SHINING_OAK_TREE_CONFIGURED, Feature.TREE, ModSaplingGenerators.goldenShiningOak().build());
	}

	public static void bootstrapPlaced(Registerable<PlacedFeature> registerable) {
		RegistryEntryLookup<ConfiguredFeature<?, ?>> featureLookup = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
		PlacedFeatures.register(registerable, IRON_SHINING_OAK_TREE, featureLookup.getOrThrow(IRON_SHINING_OAK_TREE_CONFIGURED), PlacedFeatures.wouldSurvive(ModBlocks.SHINING_OAK_SAPLING));
		PlacedFeatures.register(registerable, GOLDEN_SHINING_OAK_TREE, featureLookup.getOrThrow(GOLDEN_SHINING_OAK_TREE_CONFIGURED), PlacedFeatures.wouldSurvive(ModBlocks.SHINING_OAK_SAPLING));
	}
}
