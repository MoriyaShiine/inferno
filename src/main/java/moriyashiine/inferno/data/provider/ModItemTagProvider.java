/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModItems;
import moriyashiine.inferno.common.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		getOrCreateTagBuilder(ModItemTags.SHINING_OAK_LOGS)
				.add(ModItems.SHINING_OAK_LOG)
				.add(ModItems.SHINING_OAK_WOOD)
				.add(ModItems.STRIPPED_SHINING_OAK_LOG)
				.add(ModItems.STRIPPED_SHINING_OAK_WOOD);

		// shining oak
		getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
				.add(ModItems.SHINING_OAK_SAPLING)
				.add(ModItems.SHINING_OAK_LOG)
				.add(ModItems.SHINING_OAK_WOOD)
				.add(ModItems.STRIPPED_SHINING_OAK_LOG)
				.add(ModItems.STRIPPED_SHINING_OAK_WOOD)
				.add(ModItems.SHINING_OAK_PLANKS)
				.add(ModItems.SHINING_OAK_STAIRS)
				.add(ModItems.SHINING_OAK_SLAB)
				.add(ModItems.SHINING_OAK_FENCE)
				.add(ModItems.SHINING_OAK_FENCE_GATE)
				.add(ModItems.SHINING_OAK_DOOR)
				.add(ModItems.SHINING_OAK_TRAPDOOR)
				.add(ModItems.SHINING_OAK_PRESSURE_PLATE)
				.add(ModItems.SHINING_OAK_BUTTON)
				.add(ModItems.SHINING_OAK_SIGN)
				.add(ModItems.SHINING_OAK_HANGING_SIGN);
		getOrCreateTagBuilder(ItemTags.SAPLINGS)
				.add(ModItems.SHINING_OAK_SAPLING);
		getOrCreateTagBuilder(ItemTags.LEAVES)
				.add(ModItems.IRON_SHINING_OAK_LEAVES)
				.add(ModItems.GOLDEN_SHINING_OAK_LEAVES);
		getOrCreateTagBuilder(ItemTags.PLANKS)
				.add(ModItems.SHINING_OAK_PLANKS);
		getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
				.add(ModItems.SHINING_OAK_STAIRS);
		getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
				.add(ModItems.SHINING_OAK_SLAB);
		getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
				.add(ModItems.SHINING_OAK_FENCE);
		getOrCreateTagBuilder(ItemTags.FENCE_GATES)
				.add(ModItems.SHINING_OAK_FENCE_GATE);
		getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
				.add(ModItems.SHINING_OAK_DOOR);
		getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
				.add(ModItems.SHINING_OAK_TRAPDOOR);
		getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
				.add(ModItems.SHINING_OAK_PRESSURE_PLATE);
		getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
				.add(ModItems.SHINING_OAK_BUTTON);
		getOrCreateTagBuilder(ItemTags.SIGNS)
				.add(ModItems.SHINING_OAK_SIGN);
		getOrCreateTagBuilder(ItemTags.HANGING_SIGNS)
				.add(ModItems.SHINING_OAK_HANGING_SIGN);
		getOrCreateTagBuilder(ItemTags.BOATS)
				.add(ModItems.SHINING_OAK_RAFT);
		getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
				.add(ModItems.SHINING_OAK_CHEST_RAFT);
		// remains
		getOrCreateTagBuilder(ItemTags.FURNACE_MINECART_FUEL)
				.add(ModItems.CHARRED_LOG);
		// plants
		getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
				.add(ModItems.GOLDENROD)
				.add(ModItems.GOLDEN_POPPY)
				.add(ModItems.FIREWEED)
				.add(ModItems.PRAIRIE_FIRE);
	}
}
