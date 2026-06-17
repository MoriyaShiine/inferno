/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen;

import moriyashiine.inferno.common.init.InfernoWorldGeneration;
import moriyashiine.inferno.datagen.provider.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class InfernoDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(InfernoBlockLootSubProvider::new);
		InfernoBlockTagsProvider blockTagsProvider = pack.addProvider(InfernoBlockTagsProvider::new);
		pack.addProvider(InfernoDynamicRegistryProvider::new);
		pack.addProvider(InfernoEntityTypeTagsProvider::new);
		pack.addProvider((output, registriesFuture) -> new InfernoItemTagsProvider(output, registriesFuture, blockTagsProvider));
		pack.addProvider(InfernoModelProvider::new);
		pack.addProvider(InfernoRecipeProvider::new);
		pack.addProvider(InfernoSoundsProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, InfernoWorldGeneration::bootstrapConfigured);
		registryBuilder.add(Registries.PLACED_FEATURE, InfernoWorldGeneration::bootstrapPlaced);
	}
}
