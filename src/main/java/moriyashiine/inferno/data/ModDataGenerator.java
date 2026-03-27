/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.data;

import moriyashiine.inferno.common.init.ModWorldGeneration;
import moriyashiine.inferno.data.provider.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class ModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockLootSubProvider::new);
		ModBlockTagsProvider blockTagProvider = pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModDynamicRegistryProvider::new);
		pack.addProvider(ModEntityTypeTagsProvider::new);
		pack.addProvider((fabricDataOutput, completableFuture) -> new ModItemTagsProvider(fabricDataOutput, completableFuture, blockTagProvider));
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModWorldGeneration::bootstrapConfigured);
		registryBuilder.add(Registries.PLACED_FEATURE, ModWorldGeneration::bootstrapPlaced);
	}
}
