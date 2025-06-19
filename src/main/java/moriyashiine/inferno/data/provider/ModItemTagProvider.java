/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.init.ModItems;
import moriyashiine.inferno.common.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		// INFERNO
		valueLookupBuilder(ModItemTags.SHINING_OAK_LOGS)
				.add(ModItems.SHINING_OAK_LOG)
				.add(ModItems.SHINING_OAK_WOOD)
				.add(ModItems.STRIPPED_SHINING_OAK_LOG)
				.add(ModItems.STRIPPED_SHINING_OAK_WOOD);
		// CONVENTIONAL
		// shining oak
		valueLookupBuilder(ConventionalItemTags.STRIPPED_LOGS)
				.add(ModItems.STRIPPED_SHINING_OAK_LOG);
		valueLookupBuilder(ConventionalItemTags.STRIPPED_WOODS)
				.add(ModItems.STRIPPED_SHINING_OAK_WOOD);
		valueLookupBuilder(ConventionalItemTags.WOODEN_FENCES)
				.add(ModItems.SHINING_OAK_FENCE);
		valueLookupBuilder(ConventionalItemTags.WOODEN_FENCE_GATES)
				.add(ModItems.SHINING_OAK_FENCE_GATE);
		// VANILLA
		// shining oak
		valueLookupBuilder(ItemTags.NON_FLAMMABLE_WOOD)
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
				.add(ModItems.SHINING_OAK_HANGING_SIGN)
				.add(ModItems.SHINING_OAK_RAFT)
				.add(ModItems.SHINING_OAK_CHEST_RAFT);
		valueLookupBuilder(ItemTags.SAPLINGS)
				.add(ModItems.SHINING_OAK_SAPLING);
		valueLookupBuilder(ItemTags.LEAVES)
				.add(ModItems.IRON_SHINING_OAK_LEAVES)
				.add(ModItems.GOLDEN_SHINING_OAK_LEAVES);
		valueLookupBuilder(ItemTags.PLANKS)
				.add(ModItems.SHINING_OAK_PLANKS);
		valueLookupBuilder(ItemTags.WOODEN_STAIRS)
				.add(ModItems.SHINING_OAK_STAIRS);
		valueLookupBuilder(ItemTags.WOODEN_SLABS)
				.add(ModItems.SHINING_OAK_SLAB);
		valueLookupBuilder(ItemTags.WOODEN_FENCES)
				.add(ModItems.SHINING_OAK_FENCE);
		valueLookupBuilder(ItemTags.FENCE_GATES)
				.add(ModItems.SHINING_OAK_FENCE_GATE);
		valueLookupBuilder(ItemTags.WOODEN_DOORS)
				.add(ModItems.SHINING_OAK_DOOR);
		valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
				.add(ModItems.SHINING_OAK_TRAPDOOR);
		valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
				.add(ModItems.SHINING_OAK_PRESSURE_PLATE);
		valueLookupBuilder(ItemTags.WOODEN_BUTTONS)
				.add(ModItems.SHINING_OAK_BUTTON);
		valueLookupBuilder(ItemTags.SIGNS)
				.add(ModItems.SHINING_OAK_SIGN);
		valueLookupBuilder(ItemTags.HANGING_SIGNS)
				.add(ModItems.SHINING_OAK_HANGING_SIGN);
		valueLookupBuilder(ItemTags.BOATS)
				.add(ModItems.SHINING_OAK_RAFT);
		valueLookupBuilder(ItemTags.CHEST_BOATS)
				.add(ModItems.SHINING_OAK_CHEST_RAFT);
		// remains
		valueLookupBuilder(ItemTags.DIRT)
				.add(ModItems.SCORCHED_EARTH);
		valueLookupBuilder(ItemTags.FURNACE_MINECART_FUEL)
				.add(ModItems.CHARRED_LOG);
		// plants
		valueLookupBuilder(ItemTags.BEE_FOOD)
				.add(ModItems.BEARGRASS)
				.add(ModItems.GOLDENROD)
				.add(ModItems.GOLDEN_POPPY)
				.add(ModItems.FIREWEED)
				.add(ModItems.PRAIRIE_FIRE);
		valueLookupBuilder(ItemTags.SMALL_FLOWERS)
				.add(ModItems.GOLDENROD)
				.add(ModItems.GOLDEN_POPPY)
				.add(ModItems.FIREWEED)
				.add(ModItems.PRAIRIE_FIRE);
	}
}
