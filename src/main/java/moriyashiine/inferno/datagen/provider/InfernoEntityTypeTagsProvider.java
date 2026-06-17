/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.references.InfernoEntityTypeIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class InfernoEntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {
	public InfernoEntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		// CONVENTIONAL
		builder(ConventionalEntityTypeTags.BOATS)
				.add(InfernoEntityTypeIds.SHINING_OAK_CHEST_RAFT);
		// VANILLA
		builder(EntityTypeTags.BOAT)
				.add(InfernoEntityTypeIds.SHINING_OAK_RAFT);
	}
}
