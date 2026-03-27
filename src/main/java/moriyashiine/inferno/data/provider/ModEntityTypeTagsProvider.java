/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModEntityTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {
	public ModEntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		// CONVENTIONAL
		valueLookupBuilder(ConventionalEntityTypeTags.BOATS)
				.add(ModEntityTypes.SHINING_OAK_CHEST_RAFT);
		// VANILLA
		valueLookupBuilder(EntityTypeTags.BOAT)
				.add(ModEntityTypes.SHINING_OAK_RAFT);
	}
}
