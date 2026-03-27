/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.Inferno;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

import java.util.concurrent.CompletableFuture;

public class ModDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	public ModDynamicRegistryProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		add(entries, Registries.CONFIGURED_FEATURE);
		add(entries, Registries.PLACED_FEATURE);
	}

	@Override
	public String getName() {
		return Inferno.MOD_ID + "_dynamic";
	}

	private <T> void add(Entries entries, ResourceKey<Registry<T>> key) {
		entries.addAll((HolderLookup.RegistryLookup<T>) entries.getLookup(key));
	}
}
