/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.*;
import net.minecraft.text.Text;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.*;

public class ModItems {
	public static ItemGroup GROUP;
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
	public static final Item SHINING_OAK_SIGN = registerItem("shining_oak_sign", settings -> new SignItem(ModBlocks.SHINING_OAK_SIGN, ModBlocks.SHINING_OAK_WALL_SIGN, settings), fireproof().useBlockPrefixedTranslationKey().maxCount(16));
	public static final Item SHINING_OAK_HANGING_SIGN = registerItem("shining_oak_hanging_sign", settings -> new HangingSignItem(ModBlocks.SHINING_OAK_HANGING_SIGN, ModBlocks.SHINING_OAK_WALL_HANGING_SIGN, settings), fireproof().useBlockPrefixedTranslationKey().maxCount(16));
	public static final Item SHINING_OAK_RAFT = registerItem("shining_oak_raft", settings -> new BoatItem(ModEntityTypes.SHINING_OAK_RAFT, settings), fireproof().maxCount(1));
	public static final Item SHINING_OAK_CHEST_RAFT = registerItem("shining_oak_chest_raft", settings -> new BoatItem(ModEntityTypes.SHINING_OAK_CHEST_RAFT, settings), fireproof().maxCount(1));
	// remains
	public static final Item CHARRED_LOG = registerBlockItem("charred_log", ModBlocks.CHARRED_LOG);
	public static final Item SCORCHED_EARTH = registerBlockItem("scorched_earth", ModBlocks.SCORCHED_EARTH);
	// plants
	public static final Item BEARGRASS = registerBlockItem("beargrass", ModBlocks.BEARGRASS);
	public static final Item GOLDENROD = registerBlockItem("goldenrod", ModBlocks.GOLDENROD);
	public static final Item GOLDEN_POPPY = registerBlockItem("golden_poppy", ModBlocks.GOLDEN_POPPY);
	public static final Item FIREWEED = registerBlockItem("fireweed", ModBlocks.FIREWEED);
	public static final Item PRAIRIE_FIRE = registerBlockItem("prairie_fire", ModBlocks.PRAIRIE_FIRE);

	private static Item.Settings fireproof() {
		return new Item.Settings().fireproof();
	}

	public static void init() {
		GROUP = registerItemGroup(FabricItemGroup.builder().displayName(Text.translatable("itemGroup." + Inferno.MOD_ID)).icon(SHINING_OAK_SAPLING::getDefaultStack).entries((displayContext, entries) -> {
			// shining oak
			entries.add(SHINING_OAK_SAPLING);
			entries.add(SHINING_OAK_LOG);
			entries.add(SHINING_OAK_WOOD);
			entries.add(STRIPPED_SHINING_OAK_LOG);
			entries.add(STRIPPED_SHINING_OAK_WOOD);
			entries.add(IRON_SHINING_OAK_LEAVES);
			entries.add(GOLDEN_SHINING_OAK_LEAVES);
			entries.add(SHINING_OAK_PLANKS);
			entries.add(SHINING_OAK_STAIRS);
			entries.add(SHINING_OAK_SLAB);
			entries.add(SHINING_OAK_FENCE);
			entries.add(SHINING_OAK_FENCE_GATE);
			entries.add(SHINING_OAK_DOOR);
			entries.add(SHINING_OAK_TRAPDOOR);
			entries.add(SHINING_OAK_PRESSURE_PLATE);
			entries.add(SHINING_OAK_BUTTON);
			entries.add(SHINING_OAK_SIGN);
			entries.add(SHINING_OAK_HANGING_SIGN);
			entries.add(SHINING_OAK_RAFT);
			entries.add(SHINING_OAK_CHEST_RAFT);
			// remains
			entries.add(CHARRED_LOG);
			entries.add(SCORCHED_EARTH);
			// plants
			entries.add(BEARGRASS);
			entries.add(GOLDENROD);
			entries.add(GOLDEN_POPPY);
			entries.add(FIREWEED);
			entries.add(PRAIRIE_FIRE);
		}).build());

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.addAfter(Items.PALE_OAK_BUTTON,
				SHINING_OAK_LOG, SHINING_OAK_WOOD, STRIPPED_SHINING_OAK_LOG, STRIPPED_SHINING_OAK_WOOD, SHINING_OAK_PLANKS, SHINING_OAK_STAIRS, SHINING_OAK_SLAB, SHINING_OAK_FENCE, SHINING_OAK_FENCE_GATE, SHINING_OAK_DOOR, SHINING_OAK_TRAPDOOR, SHINING_OAK_PRESSURE_PLATE, SHINING_OAK_BUTTON,
				CHARRED_LOG));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
			entries.addAfter(Items.ROOTED_DIRT, SCORCHED_EARTH);
			entries.addAfter(Items.PALE_OAK_LOG, SHINING_OAK_LOG, CHARRED_LOG);
			entries.addAfter(Items.PALE_OAK_LEAVES, IRON_SHINING_OAK_LEAVES, GOLDEN_SHINING_OAK_LEAVES);
			entries.addAfter(Items.PALE_OAK_SAPLING, SHINING_OAK_SAPLING);
			entries.addAfter(Items.PITCHER_PLANT, BEARGRASS);
			entries.addAfter(Items.WITHER_ROSE, GOLDENROD, GOLDEN_POPPY, FIREWEED, PRAIRIE_FIRE);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.PALE_OAK_CHEST_BOAT,
				SHINING_OAK_RAFT, SHINING_OAK_CHEST_RAFT));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addAfter(Items.PALE_OAK_HANGING_SIGN, SHINING_OAK_SIGN, SHINING_OAK_HANGING_SIGN));

		FuelRegistryEvents.BUILD.register((builder, context) -> builder.add(CHARRED_LOG, context.baseSmeltTime() * 40));

		CompostingChanceRegistry.INSTANCE.add(CHARRED_LOG, 1F);
		CompostingChanceRegistry.INSTANCE.add(BEARGRASS, 0.65F);
		CompostingChanceRegistry.INSTANCE.add(GOLDENROD, 0.65F);
		CompostingChanceRegistry.INSTANCE.add(GOLDEN_POPPY, 0.65F);
		CompostingChanceRegistry.INSTANCE.add(FIREWEED, 0.65F);
		CompostingChanceRegistry.INSTANCE.add(PRAIRIE_FIRE, 0.65F);
	}
}
