/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.init.ModBlockFamilies;
import moriyashiine.inferno.common.init.ModBlocks;
import moriyashiine.inferno.common.init.ModItems;
import moriyashiine.inferno.common.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.SuspiciousStewIngredient;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
		return new RecipeGenerator(registryLookup, exporter) {
			@Override
			public void generate() {
				// shining oak
				offerBarkBlockRecipe(ModItems.SHINING_OAK_WOOD, ModItems.SHINING_OAK_LOG);
				offerBarkBlockRecipe(ModItems.STRIPPED_SHINING_OAK_WOOD, ModItems.STRIPPED_SHINING_OAK_LOG);
				offerPlanksRecipe(ModItems.SHINING_OAK_PLANKS, ModItemTags.SHINING_OAK_LOGS, 4);
				generateFamily(ModBlockFamilies.SHINING_OAK, FeatureFlags.DEFAULT_ENABLED_FEATURES);
				offerHangingSignRecipe(ModItems.SHINING_OAK_HANGING_SIGN, ModItems.STRIPPED_SHINING_OAK_LOG);
				offerBoatRecipe(ModItems.SHINING_OAK_RAFT, ModItems.SHINING_OAK_PLANKS);
				offerChestBoatRecipe(ModItems.SHINING_OAK_CHEST_RAFT, ModItems.SHINING_OAK_RAFT);
				// remains
				createShapeless(RecipeCategory.MISC, Items.CHARCOAL, 4).input(ModItems.CHARRED_LOG).criterion("has_log", conditionsFromItem(ModItems.CHARRED_LOG)).offerTo(exporter);
				// flowers
				offerShapelessRecipe(Items.LIGHT_GRAY_DYE, ModItems.BEARGRASS, "light_gray_dye", 2);
				offerSingleOutputShapelessRecipe(Items.YELLOW_DYE, ModItems.GOLDENROD, "yellow_dye");
				offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, ModItems.GOLDEN_POPPY, "orange_dye");
				offerSingleOutputShapelessRecipe(Items.MAGENTA_DYE, ModItems.FIREWEED, "magenta_dye");
				offerSingleOutputShapelessRecipe(Items.RED_DYE, ModItems.PRAIRIE_FIRE, "red_dye");
				offerSuspiciousStewRecipe(ModItems.GOLDENROD, SuspiciousStewIngredient.of(ModItems.GOLDENROD));
				offerSuspiciousStewRecipe(ModItems.GOLDEN_POPPY, SuspiciousStewIngredient.of(ModItems.GOLDEN_POPPY));
				offerSuspiciousStewRecipe(ModItems.FIREWEED, SuspiciousStewIngredient.of(ModItems.FIREWEED));
				offerSuspiciousStewRecipe(ModItems.PRAIRIE_FIRE, SuspiciousStewIngredient.of(ModItems.PRAIRIE_FIRE));
				// copper fire
				createShaped(RecipeCategory.DECORATIONS, ModBlocks.COPPER_CAMPFIRE).input('L', ItemTags.LOGS).input('S', Items.STICK).input('#', ConventionalItemTags.COPPER_INGOTS).pattern(" S ").pattern("S#S").pattern("LLL").criterion("has_copper_ingot", conditionsFromTag(ConventionalItemTags.COPPER_INGOTS)).offerTo(exporter);
			}
		};
	}

	@Override
	public String getName() {
		return Inferno.MOD_ID + "_recipes";
	}
}
