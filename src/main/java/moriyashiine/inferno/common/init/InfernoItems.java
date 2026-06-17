/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.references.InfernoBlockItemIds;
import moriyashiine.inferno.common.references.InfernoItemIds;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.*;

public class InfernoItems {
	public static CreativeModeTab TAB;
	// shining oak
	public static final Item SHINING_OAK_SAPLING = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_SAPLING, InfernoBlocks.SHINING_OAK_SAPLING, fireproof());
	public static final Item SHINING_OAK_LOG = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_LOG, InfernoBlocks.SHINING_OAK_LOG, fireproof());
	public static final Item SHINING_OAK_WOOD = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_WOOD, InfernoBlocks.SHINING_OAK_WOOD, fireproof());
	public static final Item STRIPPED_SHINING_OAK_LOG = registerBlockItem(InfernoBlockItemIds.STRIPPED_SHINING_OAK_LOG, InfernoBlocks.STRIPPED_SHINING_OAK_LOG, fireproof());
	public static final Item STRIPPED_SHINING_OAK_WOOD = registerBlockItem(InfernoBlockItemIds.STRIPPED_SHINING_OAK_WOOD, InfernoBlocks.STRIPPED_SHINING_OAK_WOOD, fireproof());
	public static final Item IRON_SHINING_OAK_LEAVES = registerBlockItem(InfernoBlockItemIds.IRON_SHINING_OAK_LEAVES, InfernoBlocks.IRON_SHINING_OAK_LEAVES, fireproof());
	public static final Item GOLDEN_SHINING_OAK_LEAVES = registerBlockItem(InfernoBlockItemIds.GOLDEN_SHINING_OAK_LEAVES, InfernoBlocks.GOLDEN_SHINING_OAK_LEAVES, fireproof());
	public static final Item SHINING_OAK_PLANKS = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_PLANKS, InfernoBlocks.SHINING_OAK_PLANKS, fireproof());
	public static final Item SHINING_OAK_STAIRS = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_STAIRS, InfernoBlocks.SHINING_OAK_STAIRS, fireproof());
	public static final Item SHINING_OAK_SLAB = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_SLAB, InfernoBlocks.SHINING_OAK_SLAB, fireproof());
	public static final Item SHINING_OAK_FENCE = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_FENCE, InfernoBlocks.SHINING_OAK_FENCE, fireproof());
	public static final Item SHINING_OAK_FENCE_GATE = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_FENCE_GATE, InfernoBlocks.SHINING_OAK_FENCE_GATE, fireproof());
	public static final Item SHINING_OAK_DOOR = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_DOOR, InfernoBlocks.SHINING_OAK_DOOR, fireproof());
	public static final Item SHINING_OAK_TRAPDOOR = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_TRAPDOOR, InfernoBlocks.SHINING_OAK_TRAPDOOR, fireproof());
	public static final Item SHINING_OAK_PRESSURE_PLATE = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_PRESSURE_PLATE, InfernoBlocks.SHINING_OAK_PRESSURE_PLATE, fireproof());
	public static final Item SHINING_OAK_BUTTON = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_BUTTON, InfernoBlocks.SHINING_OAK_BUTTON, fireproof());
	public static final Item SHINING_OAK_SHELF = registerBlockItem(InfernoBlockItemIds.SHINING_OAK_SHELF, InfernoBlocks.SHINING_OAK_SHELF, fireproof().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
	public static final Item SHINING_OAK_SIGN = registerItem(InfernoBlockItemIds.SHINING_OAK_SIGN.item(), properties -> new SignItem(InfernoBlocks.SHINING_OAK_SIGN, InfernoBlocks.SHINING_OAK_WALL_SIGN, properties), fireproof().useBlockDescriptionPrefix().stacksTo(16));
	public static final Item SHINING_OAK_HANGING_SIGN = registerItem(InfernoBlockItemIds.SHINING_OAK_HANGING_SIGN.item(), properties -> new HangingSignItem(InfernoBlocks.SHINING_OAK_HANGING_SIGN, InfernoBlocks.SHINING_OAK_WALL_HANGING_SIGN, properties), fireproof().useBlockDescriptionPrefix().stacksTo(16));
	public static final Item SHINING_OAK_RAFT = registerItem(InfernoItemIds.SHINING_OAK_RAFT, properties -> new BoatItem(InfernoEntityTypes.SHINING_OAK_RAFT, properties), fireproof().stacksTo(1));
	public static final Item SHINING_OAK_CHEST_RAFT = registerItem(InfernoItemIds.SHINING_OAK_CHEST_RAFT, properties -> new BoatItem(InfernoEntityTypes.SHINING_OAK_CHEST_RAFT, properties), fireproof().stacksTo(1));
	// remains
	public static final Item CHARRED_LOG = registerBlockItem(InfernoBlockItemIds.CHARRED_LOG, InfernoBlocks.CHARRED_LOG);
	public static final Item SCORCHED_EARTH = registerBlockItem(InfernoBlockItemIds.SCORCHED_EARTH, InfernoBlocks.SCORCHED_EARTH);
	// plants
	public static final Item BEARGRASS = registerBlockItem(InfernoBlockItemIds.BEARGRASS, InfernoBlocks.BEARGRASS);
	public static final Item GOLDENROD = registerBlockItem(InfernoBlockItemIds.GOLDENROD, InfernoBlocks.GOLDENROD);
	public static final Item GOLDEN_POPPY = registerBlockItem(InfernoBlockItemIds.GOLDEN_POPPY, InfernoBlocks.GOLDEN_POPPY);
	public static final Item FIREWEED = registerBlockItem(InfernoBlockItemIds.FIREWEED, InfernoBlocks.FIREWEED);
	public static final Item PRAIRIE_FIRE = registerBlockItem(InfernoBlockItemIds.PRAIRIE_FIRE, InfernoBlocks.PRAIRIE_FIRE);
	// copper fire
	public static final Item COPPER_CAMPFIRE = registerBlockItem(InfernoBlockItemIds.COPPER_CAMPFIRE, InfernoBlocks.COPPER_CAMPFIRE, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));

	private static Item.Properties fireproof() {
		return new Item.Properties().fireResistant();
	}

	public static void init() {
		TAB = registerCreativeModeTab(FabricCreativeModeTab.builder().title(Component.translatable("itemGroup." + Inferno.MOD_ID)).icon(SHINING_OAK_SAPLING::getDefaultInstance).displayItems((_, output) -> {
			// shining oak
			output.accept(SHINING_OAK_SAPLING);
			output.accept(SHINING_OAK_LOG);
			output.accept(SHINING_OAK_WOOD);
			output.accept(STRIPPED_SHINING_OAK_LOG);
			output.accept(STRIPPED_SHINING_OAK_WOOD);
			output.accept(IRON_SHINING_OAK_LEAVES);
			output.accept(GOLDEN_SHINING_OAK_LEAVES);
			output.accept(SHINING_OAK_PLANKS);
			output.accept(SHINING_OAK_STAIRS);
			output.accept(SHINING_OAK_SLAB);
			output.accept(SHINING_OAK_FENCE);
			output.accept(SHINING_OAK_FENCE_GATE);
			output.accept(SHINING_OAK_DOOR);
			output.accept(SHINING_OAK_TRAPDOOR);
			output.accept(SHINING_OAK_PRESSURE_PLATE);
			output.accept(SHINING_OAK_BUTTON);
			output.accept(SHINING_OAK_SHELF);
			output.accept(SHINING_OAK_SIGN);
			output.accept(SHINING_OAK_HANGING_SIGN);
			output.accept(SHINING_OAK_RAFT);
			output.accept(SHINING_OAK_CHEST_RAFT);
			// remains
			output.accept(CHARRED_LOG);
			output.accept(SCORCHED_EARTH);
			// plants
			output.accept(BEARGRASS);
			output.accept(GOLDENROD);
			output.accept(GOLDEN_POPPY);
			output.accept(FIREWEED);
			output.accept(PRAIRIE_FIRE);
			// copper fire
			output.accept(COPPER_CAMPFIRE);
		}).build());

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> output.insertAfter(Items.PALE_OAK_BUTTON,
				SHINING_OAK_LOG, SHINING_OAK_WOOD, STRIPPED_SHINING_OAK_LOG, STRIPPED_SHINING_OAK_WOOD, SHINING_OAK_PLANKS, SHINING_OAK_STAIRS, SHINING_OAK_SLAB, SHINING_OAK_FENCE, SHINING_OAK_FENCE_GATE, SHINING_OAK_DOOR, SHINING_OAK_TRAPDOOR, SHINING_OAK_PRESSURE_PLATE, SHINING_OAK_BUTTON,
				CHARRED_LOG));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output -> {
			output.insertAfter(Items.ROOTED_DIRT, SCORCHED_EARTH);
			output.insertAfter(Items.PALE_OAK_LOG, SHINING_OAK_LOG, CHARRED_LOG);
			output.insertAfter(Items.PALE_OAK_LEAVES, IRON_SHINING_OAK_LEAVES, GOLDEN_SHINING_OAK_LEAVES);
			output.insertAfter(Items.PALE_OAK_SAPLING, SHINING_OAK_SAPLING);
			output.insertAfter(Items.PITCHER_PLANT, BEARGRASS);
			output.insertAfter(Items.WITHER_ROSE, GOLDENROD, GOLDEN_POPPY, FIREWEED, PRAIRIE_FIRE);
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> output.insertAfter(Items.PALE_OAK_CHEST_BOAT,
				SHINING_OAK_RAFT, SHINING_OAK_CHEST_RAFT));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(output -> {
			output.insertAfter(Items.PALE_OAK_SHELF, SHINING_OAK_SHELF);
			output.insertAfter(Items.PALE_OAK_HANGING_SIGN, SHINING_OAK_SIGN, SHINING_OAK_HANGING_SIGN);
			output.insertAfter(Items.SOUL_CAMPFIRE, COPPER_CAMPFIRE);
		});

		FuelValueEvents.BUILD.register((builder, context) -> builder.add(CHARRED_LOG, context.baseSmeltTime() * 40));

		CompostableRegistry.INSTANCE.add(CHARRED_LOG, 1F);
		CompostableRegistry.INSTANCE.add(BEARGRASS, 0.65F);
		CompostableRegistry.INSTANCE.add(GOLDENROD, 0.65F);
		CompostableRegistry.INSTANCE.add(GOLDEN_POPPY, 0.65F);
		CompostableRegistry.INSTANCE.add(FIREWEED, 0.65F);
		CompostableRegistry.INSTANCE.add(PRAIRIE_FIRE, 0.65F);
	}
}
