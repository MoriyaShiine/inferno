/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.datagen.provider;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.init.ModBlockFamilies;
import moriyashiine.inferno.common.init.ModItems;
import moriyashiine.inferno.common.tag.ModItemTags;
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

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
		return new RecipeProvider(registries, output) {
			@Override
			public void buildRecipes() {
				// shining oak
				woodFromLogs(ModItems.SHINING_OAK_WOOD, ModItems.SHINING_OAK_LOG);
				woodFromLogs(ModItems.STRIPPED_SHINING_OAK_WOOD, ModItems.STRIPPED_SHINING_OAK_LOG);
				planksFromLogs(ModItems.SHINING_OAK_PLANKS, ModItemTags.SHINING_OAK_LOGS, 4);
				generateRecipes(ModBlockFamilies.SHINING_OAK, FeatureFlags.DEFAULT_FLAGS);
				shelf(ModItems.SHINING_OAK_SHELF, ModItems.STRIPPED_SHINING_OAK_LOG);
				hangingSign(ModItems.SHINING_OAK_HANGING_SIGN, ModItems.STRIPPED_SHINING_OAK_LOG);
				woodenBoat(ModItems.SHINING_OAK_RAFT, ModItems.SHINING_OAK_PLANKS);
				chestBoat(ModItems.SHINING_OAK_CHEST_RAFT, ModItems.SHINING_OAK_RAFT);
				// remains
				shapeless(RecipeCategory.MISC, Items.CHARCOAL, 4).requires(ModItems.CHARRED_LOG).unlockedBy("has_log", has(ModItems.CHARRED_LOG)).save(output);
				// flowers
				oneToOneConversionRecipe(Items.LIGHT_GRAY_DYE, ModItems.BEARGRASS, "light_gray_dye", 2);
				oneToOneConversionRecipe(Items.YELLOW_DYE, ModItems.GOLDENROD, "yellow_dye");
				oneToOneConversionRecipe(Items.ORANGE_DYE, ModItems.GOLDEN_POPPY, "orange_dye");
				oneToOneConversionRecipe(Items.MAGENTA_DYE, ModItems.FIREWEED, "magenta_dye");
				oneToOneConversionRecipe(Items.RED_DYE, ModItems.PRAIRIE_FIRE, "red_dye");
				suspiciousStew(ModItems.GOLDENROD, SuspiciousEffectHolder.tryGet(ModItems.GOLDENROD));
				suspiciousStew(ModItems.GOLDEN_POPPY, SuspiciousEffectHolder.tryGet(ModItems.GOLDEN_POPPY));
				suspiciousStew(ModItems.FIREWEED, SuspiciousEffectHolder.tryGet(ModItems.FIREWEED));
				suspiciousStew(ModItems.PRAIRIE_FIRE, SuspiciousEffectHolder.tryGet(ModItems.PRAIRIE_FIRE));
				// copper fire
				shaped(RecipeCategory.DECORATIONS, ModItems.COPPER_CAMPFIRE).define('L', ItemTags.LOGS).define('S', Items.STICK).define('#', ConventionalItemTags.COPPER_INGOTS).pattern(" S ").pattern("S#S").pattern("LLL").unlockedBy("has_copper_ingot", has(ConventionalItemTags.COPPER_INGOTS)).save(output);
			}
		};
	}

	@Override
	public String getName() {
		return Inferno.MOD_ID + "_recipes";
	}
}
