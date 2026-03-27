/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.*;

public class ModItems {
	public static CreativeModeTab TAB;
	// shining oak
	public static final Item SHINING_OAK_SAPLING = registerBlockItem("shining_oak_sapling", ModBlocks.SHINING_OAK_SAPLING, fireproof());
	public static final Item SHINING_OAK_LOG = registerBlockItem("shining_oak_log", ModBlocks.SHINING_OAK_LOG, fireproof());
	public static final Item SHINING_OAK_WOOD = registerBlockItem("shining_oak_wood", ModBlocks.SHINING_OAK_WOOD, fireproof());
	public static final Item STRIPPED_SHINING_OAK_LOG = registerBlockItem("stripped_shining_oak_log", ModBlocks.STRIPPED_SHINING_OAK_LOG, fireproof());
	public static final Item STRIPPED_SHINING_OAK_WOOD = registerBlockItem("stripped_shining_oak_wood", ModBlocks.STRIPPED_SHINING_OAK_WOOD, fireproof());
	public static final Item IRON_SHINING_OAK_LEAVES = registerBlockItem("iron_shining_oak_leaves", ModBlocks.IRON_SHINING_OAK_LEAVES, fireproof());
	public static final Item GOLDEN_SHINING_OAK_LEAVES = registerBlockItem("golden_shining_oak_leaves", ModBlocks.GOLDEN_SHINING_OAK_LEAVES, fireproof());
	public static final Item SHINING_OAK_PLANKS = registerBlockItem("shining_oak_planks", ModBlocks.SHINING_OAK_PLANKS, fireproof());
	public static final Item SHINING_OAK_STAIRS = registerBlockItem("shining_oak_stairs", ModBlocks.SHINING_OAK_STAIRS, fireproof());
	public static final Item SHINING_OAK_SLAB = registerBlockItem("shining_oak_slab", ModBlocks.SHINING_OAK_SLAB, fireproof());
	public static final Item SHINING_OAK_FENCE = registerBlockItem("shining_oak_fence", ModBlocks.SHINING_OAK_FENCE, fireproof());
	public static final Item SHINING_OAK_FENCE_GATE = registerBlockItem("shining_oak_fence_gate", ModBlocks.SHINING_OAK_FENCE_GATE, fireproof());
	public static final Item SHINING_OAK_DOOR = registerBlockItem("shining_oak_door", ModBlocks.SHINING_OAK_DOOR, fireproof());
	public static final Item SHINING_OAK_TRAPDOOR = registerBlockItem("shining_oak_trapdoor", ModBlocks.SHINING_OAK_TRAPDOOR, fireproof());
	public static final Item SHINING_OAK_PRESSURE_PLATE = registerBlockItem("shining_oak_pressure_plate", ModBlocks.SHINING_OAK_PRESSURE_PLATE, fireproof());
	public static final Item SHINING_OAK_BUTTON = registerBlockItem("shining_oak_button", ModBlocks.SHINING_OAK_BUTTON, fireproof());
	public static final Item SHINING_OAK_SHELF = registerBlockItem("shining_oak_shelf", ModBlocks.SHINING_OAK_SHELF, fireproof().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
	public static final Item SHINING_OAK_SIGN = registerItem("shining_oak_sign", settings -> new SignItem(ModBlocks.SHINING_OAK_SIGN, ModBlocks.SHINING_OAK_WALL_SIGN, settings), fireproof().useBlockDescriptionPrefix().stacksTo(16));
	public static final Item SHINING_OAK_HANGING_SIGN = registerItem("shining_oak_hanging_sign", settings -> new HangingSignItem(ModBlocks.SHINING_OAK_HANGING_SIGN, ModBlocks.SHINING_OAK_WALL_HANGING_SIGN, settings), fireproof().useBlockDescriptionPrefix().stacksTo(16));
	public static final Item SHINING_OAK_RAFT = registerItem("shining_oak_raft", settings -> new BoatItem(ModEntityTypes.SHINING_OAK_RAFT, settings), fireproof().stacksTo(1));
	public static final Item SHINING_OAK_CHEST_RAFT = registerItem("shining_oak_chest_raft", settings -> new BoatItem(ModEntityTypes.SHINING_OAK_CHEST_RAFT, settings), fireproof().stacksTo(1));
	// remains
	public static final Item CHARRED_LOG = registerBlockItem("charred_log", ModBlocks.CHARRED_LOG);
	public static final Item SCORCHED_EARTH = registerBlockItem("scorched_earth", ModBlocks.SCORCHED_EARTH);
	// plants
	public static final Item BEARGRASS = registerBlockItem("beargrass", ModBlocks.BEARGRASS);
	public static final Item GOLDENROD = registerBlockItem("goldenrod", ModBlocks.GOLDENROD);
	public static final Item GOLDEN_POPPY = registerBlockItem("golden_poppy", ModBlocks.GOLDEN_POPPY);
	public static final Item FIREWEED = registerBlockItem("fireweed", ModBlocks.FIREWEED);
	public static final Item PRAIRIE_FIRE = registerBlockItem("prairie_fire", ModBlocks.PRAIRIE_FIRE);
	// copper fire
	public static final Item COPPER_CAMPFIRE = registerBlockItem("copper_campfire", ModBlocks.COPPER_CAMPFIRE, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));

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
