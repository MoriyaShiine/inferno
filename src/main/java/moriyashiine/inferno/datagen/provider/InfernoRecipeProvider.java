/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.init.InfernoBlockFamilies;
import moriyashiine.inferno.common.init.InfernoItems;
import moriyashiine.inferno.common.tag.InfernoItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.SuspiciousEffectHolder;

import java.util.concurrent.CompletableFuture;

public class InfernoRecipeProvider extends FabricRecipeProvider {
	public InfernoRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
		return new RecipeProvider(registries, output) {
			@Override
			public void buildRecipes() {
				// shining oak
				woodFromLogs(InfernoItems.SHINING_OAK_WOOD, InfernoItems.SHINING_OAK_LOG);
				woodFromLogs(InfernoItems.STRIPPED_SHINING_OAK_WOOD, InfernoItems.STRIPPED_SHINING_OAK_LOG);
				planksFromLogs(InfernoItems.SHINING_OAK_PLANKS, InfernoItemTags.SHINING_OAK_LOGS, 4);
				generateRecipes(InfernoBlockFamilies.SHINING_OAK_PLANKS, FeatureFlags.DEFAULT_FLAGS);
				shelf(InfernoItems.SHINING_OAK_SHELF, InfernoItems.STRIPPED_SHINING_OAK_LOG);
				hangingSign(InfernoItems.SHINING_OAK_HANGING_SIGN, InfernoItems.STRIPPED_SHINING_OAK_LOG);
				woodenBoat(InfernoItems.SHINING_OAK_RAFT, InfernoItems.SHINING_OAK_PLANKS);
				chestBoat(InfernoItems.SHINING_OAK_CHEST_RAFT, InfernoItems.SHINING_OAK_RAFT);
				// remains
				shapeless(RecipeCategory.MISC, Items.CHARCOAL, 4).requires(InfernoItems.CHARRED_LOG).unlockedBy("has_log", has(InfernoItems.CHARRED_LOG)).save(output);
				// flowers
				oneToOneConversionRecipe(Items.LIGHT_GRAY_DYE, InfernoItems.BEARGRASS, "light_gray_dye", 2);
				oneToOneConversionRecipe(Items.YELLOW_DYE, InfernoItems.GOLDENROD, "yellow_dye");
				oneToOneConversionRecipe(Items.ORANGE_DYE, InfernoItems.GOLDEN_POPPY, "orange_dye");
				oneToOneConversionRecipe(Items.MAGENTA_DYE, InfernoItems.FIREWEED, "magenta_dye");
				oneToOneConversionRecipe(Items.RED_DYE, InfernoItems.PRAIRIE_FIRE, "red_dye");
				suspiciousStew(InfernoItems.GOLDENROD, SuspiciousEffectHolder.tryGet(InfernoItems.GOLDENROD));
				suspiciousStew(InfernoItems.GOLDEN_POPPY, SuspiciousEffectHolder.tryGet(InfernoItems.GOLDEN_POPPY));
				suspiciousStew(InfernoItems.FIREWEED, SuspiciousEffectHolder.tryGet(InfernoItems.FIREWEED));
				suspiciousStew(InfernoItems.PRAIRIE_FIRE, SuspiciousEffectHolder.tryGet(InfernoItems.PRAIRIE_FIRE));
				// copper fire
				shaped(RecipeCategory.DECORATIONS, InfernoItems.COPPER_CAMPFIRE).define('L', ItemTags.LOGS).define('S', Items.STICK).define('#', ConventionalItemTags.COPPER_INGOTS).pattern(" S ").pattern("S#S").pattern("LLL").unlockedBy("has_copper_ingot", has(ConventionalItemTags.COPPER_INGOTS)).save(output);
			}
		};
	}

	@Override
	public String getName() {
		return Inferno.MOD_ID + "_recipes";
	}
}
