/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.block.CharredLogBlock;
import moriyashiine.inferno.common.block.CopperFireBlock;
import moriyashiine.inferno.common.block.ScorchedEarthBlock;
import moriyashiine.inferno.common.block.ShiningOakSaplingBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerBlock;
import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerBlockType;
import static net.minecraft.block.AbstractBlock.Settings.copy;
import static net.minecraft.block.AbstractBlock.Settings.create;

public class ModBlocks {
	// wood type
	private static final BlockSetType SHINING_OAK_BLOCK_SET_TYPE = new BlockSetTypeBuilder()
			.openableByHand(true)
			.openableByWindCharge(true)
			.buttonActivatedByArrows(true)
			.pressurePlateActivationRule(BlockSetType.ActivationRule.EVERYTHING)
			.soundGroup(ModSoundEvents.SHINING_OAK_WOOD)
			.buttonClickOffSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_BUTTON_CLICK_OFF)
			.buttonClickOnSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_BUTTON_CLICK_ON)
			.doorCloseSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_DOOR_CLOSE)
			.doorOpenSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_DOOR_OPEN)
			.pressurePlateClickOffSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_PRESSURE_PLATE_CLICK_OFF)
			.pressurePlateClickOnSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_PRESSURE_PLATE_CLICK_ON)
			.trapdoorCloseSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_TRAPDOOR_CLOSE)
			.trapdoorOpenSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_TRAPDOOR_OPEN)
			.register(Inferno.id("shining_oak"));
	private static final WoodType SHINING_OAK_WOOD_TYPE = new WoodTypeBuilder()
			.soundGroup(ModSoundEvents.SHINING_OAK_WOOD)
			.hangingSignSoundGroup(ModSoundEvents.SHINING_OAK_WOOD_HANGING_SIGN)
			.fenceGateCloseSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_FENCE_GATE_CLOSE)
			.fenceGateOpenSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_FENCE_GATE_OPEN)
			.register(Inferno.id("shining_oak"), SHINING_OAK_BLOCK_SET_TYPE);

	// shining oak
	public static final Block SHINING_OAK_SAPLING = registerBlock("shining_oak_sapling", settings -> new ShiningOakSaplingBlock(ModSaplingGenerators.IRON_SHINING_OAK, ModSaplingGenerators.GOLDEN_SHINING_OAK, settings), AbstractBlock.Settings.create()
			.mapColor(MapColor.GOLD)
			.noCollision()
			.ticksRandomly()
			.breakInstantly()
			.sounds(ModSoundEvents.SHINING_OAK_SAPLING)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static final Block POTTED_SHINING_OAK_SAPLING = registerBlock("potted_shining_oak_sapling", settings -> new FlowerPotBlock(SHINING_OAK_SAPLING, settings), Blocks.createFlowerPotSettings());
	public static final Block SHINING_OAK_LOG = registerBlock("shining_oak_log", PillarBlock::new, create()
			.mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? DyeColor.YELLOW.getMapColor() : MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sounds(ModSoundEvents.SHINING_OAK_WOOD));
	public static final Block SHINING_OAK_WOOD = registerBlock("shining_oak_wood", PillarBlock::new, create()
			.mapColor(MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sounds(ModSoundEvents.SHINING_OAK_WOOD));
	public static final Block STRIPPED_SHINING_OAK_LOG = registerBlock("stripped_shining_oak_log", PillarBlock::new, copy(SHINING_OAK_LOG));
	public static final Block STRIPPED_SHINING_OAK_WOOD = registerBlock("stripped_shining_oak_wood", PillarBlock::new, copy(SHINING_OAK_WOOD));
	public static final Block IRON_SHINING_OAK_LEAVES = registerBlock("iron_shining_oak_leaves", settings -> new UntintedParticleLeavesBlock(0.1F, ModParticleTypes.IRON_SHINING_OAK_LEAVES, settings), create()
			.mapColor(MapColor.YELLOW)
			.strength(0.2F)
			.ticksRandomly()
			.sounds(ModSoundEvents.SHINING_OAK_LEAVES)
			.nonOpaque()
			.allowsSpawning(Blocks::canSpawnOnLeaves)
			.suffocates(Blocks::never)
			.blockVision(Blocks::never)
			.pistonBehavior(PistonBehavior.DESTROY)
			.solidBlock(Blocks::never));
	public static final Block GOLDEN_SHINING_OAK_LEAVES = registerBlock("golden_shining_oak_leaves", settings -> new UntintedParticleLeavesBlock(0.1F, ModParticleTypes.GOLDEN_SHINING_OAK_LEAVES, settings), copy(IRON_SHINING_OAK_LEAVES));
	public static final Block SHINING_OAK_PLANKS = registerBlock("shining_oak_planks", Block::new, create()
			.mapColor(MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sounds(ModSoundEvents.SHINING_OAK_WOOD));
	public static final Block SHINING_OAK_STAIRS = registerBlock("shining_oak_stairs", settings -> new StairsBlock(SHINING_OAK_PLANKS.getDefaultState(), settings), copy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_SLAB = registerBlock("shining_oak_slab", SlabBlock::new, copy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_FENCE = registerBlock("shining_oak_fence", FenceBlock::new, copy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_FENCE_GATE = registerBlock("shining_oak_fence_gate", settings -> new FenceGateBlock(SHINING_OAK_WOOD_TYPE, settings), copy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_DOOR = registerBlock("shining_oak_door", settings -> new DoorBlock(SHINING_OAK_BLOCK_SET_TYPE, settings), create()
			.mapColor(SHINING_OAK_PLANKS.getDefaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.nonOpaque()
			.pistonBehavior(PistonBehavior.DESTROY));
	public static final Block SHINING_OAK_TRAPDOOR = registerBlock("shining_oak_trapdoor", settings -> new TrapdoorBlock(SHINING_OAK_BLOCK_SET_TYPE, settings), create()
			.mapColor(SHINING_OAK_PLANKS.getDefaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.nonOpaque()
			.allowsSpawning(Blocks::never));
	public static final Block SHINING_OAK_PRESSURE_PLATE = registerBlock("shining_oak_pressure_plate", settings -> new PressurePlateBlock(SHINING_OAK_BLOCK_SET_TYPE, settings), create()
			.mapColor(SHINING_OAK_PLANKS.getDefaultMapColor())
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(0.5F)
			.pistonBehavior(PistonBehavior.DESTROY));
	public static final Block SHINING_OAK_BUTTON = registerBlock("shining_oak_button", settings -> new ButtonBlock(SHINING_OAK_BLOCK_SET_TYPE, 30, settings), Blocks.createButtonSettings());
	public static final Block SHINING_OAK_SIGN = registerBlock("shining_oak_sign", settings -> new SignBlock(SHINING_OAK_WOOD_TYPE, settings), create()
			.mapColor(SHINING_OAK_PLANKS.getDefaultMapColor())
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_WALL_SIGN = registerBlock("shining_oak_wall_sign", settings -> new WallSignBlock(SHINING_OAK_WOOD_TYPE, settings), create()
			.lootTable(SHINING_OAK_SIGN.getLootTableKey())
			.overrideTranslationKey(SHINING_OAK_SIGN.getTranslationKey())
			.mapColor(MapColor.OAK_TAN)
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_HANGING_SIGN = registerBlock("shining_oak_hanging_sign", settings -> new HangingSignBlock(SHINING_OAK_WOOD_TYPE, settings), create()
			.mapColor(SHINING_OAK_PLANKS.getDefaultMapColor())
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_WALL_HANGING_SIGN = registerBlock("shining_oak_wall_hanging_sign", settings -> new WallHangingSignBlock(SHINING_OAK_WOOD_TYPE, settings), create()
			.lootTable(SHINING_OAK_HANGING_SIGN.getLootTableKey())
			.overrideTranslationKey(SHINING_OAK_HANGING_SIGN.getTranslationKey())
			.mapColor(MapColor.OAK_TAN)
			.solid()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	// remains
	public static final Block CHARRED_LOG = registerBlock("charred_log", CharredLogBlock::new, create()
			.mapColor(MapColor.BLACK)
			.sounds(ModSoundEvents.CHARRED_LOG).strength(1).pistonBehavior(PistonBehavior.DESTROY));
	public static final Block SCORCHED_EARTH = registerBlock("scorched_earth", ScorchedEarthBlock::new, create()
			.mapColor(DyeColor.BLACK)
			.ticksRandomly()
			.sounds(ModSoundEvents.SCORCHED_EARTH).strength(0.6F));
	// plants
	public static final Block BEARGRASS = registerBlock("beargrass", TallFlowerBlock::new, copy(Blocks.SUNFLOWER));
	public static final Block GOLDENROD = registerBlock("goldenrod", settings -> new FlowerBlock(StatusEffects.HASTE, 7, settings), copy(Blocks.DANDELION));
	public static final Block POTTED_GOLDENROD = registerBlock("potted_goldenrod", settings -> new FlowerPotBlock(GOLDENROD, settings), Blocks.createFlowerPotSettings());
	public static final Block GOLDEN_POPPY = registerBlock("golden_poppy", settings -> new FlowerBlock(StatusEffects.NIGHT_VISION, 5, settings), copy(Blocks.DANDELION));
	public static final Block POTTED_GOLDEN_POPPY = registerBlock("potted_golden_poppy", settings -> new FlowerPotBlock(GOLDEN_POPPY, settings), Blocks.createFlowerPotSettings());
	public static final Block FIREWEED = registerBlock("fireweed", settings -> new FlowerBlock(StatusEffects.REGENERATION, 7, settings), copy(Blocks.DANDELION));
	public static final Block POTTED_FIREWEED = registerBlock("potted_fireweed", settings -> new FlowerPotBlock(FIREWEED, settings), Blocks.createFlowerPotSettings());
	public static final Block PRAIRIE_FIRE = registerBlock("prairie_fire", settings -> new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3, settings), copy(Blocks.DANDELION));
	public static final Block POTTED_PRAIRIE_FIRE = registerBlock("potted_prairie_fire", settings -> new FlowerPotBlock(PRAIRIE_FIRE, settings), Blocks.createFlowerPotSettings());
	// copper fire
	public static final Block COPPER_CAMPFIRE = registerBlock("copper_campfire", settings -> new CampfireBlock(false, 1, settings), copy(Blocks.CAMPFIRE));
	public static final Block COPPER_FIRE = registerBlock("copper_fire", CopperFireBlock::new, AbstractBlock.Settings.create()
			.mapColor(MapColor.EMERALD_GREEN)
			.replaceable()
			.noCollision()
			.breakInstantly()
			.luminance(state -> 15)
			.sounds(BlockSoundGroup.WOOL)
			.pistonBehavior(PistonBehavior.DESTROY));

	public static void init() {
		registerBlockType("copper_fire", CopperFireBlock.CODEC);
		registerBlockType("falling_pillar", CharredLogBlock.CODEC);
		StrippableBlockRegistry.register(SHINING_OAK_LOG, STRIPPED_SHINING_OAK_LOG);
		StrippableBlockRegistry.register(SHINING_OAK_WOOD, STRIPPED_SHINING_OAK_WOOD);
		BlockEntityType.SIGN.addSupportedBlock(SHINING_OAK_SIGN);
		BlockEntityType.SIGN.addSupportedBlock(SHINING_OAK_WALL_SIGN);
		BlockEntityType.HANGING_SIGN.addSupportedBlock(SHINING_OAK_HANGING_SIGN);
		BlockEntityType.HANGING_SIGN.addSupportedBlock(SHINING_OAK_WALL_HANGING_SIGN);
		BlockEntityType.CAMPFIRE.addSupportedBlock(COPPER_CAMPFIRE);
		FireBlock fire = (FireBlock) Blocks.FIRE;
		// vanilla
		fire.registerFlammableBlock(Blocks.GRASS_BLOCK, 60, 100);
		fire.registerFlammableBlock(Blocks.PODZOL, 60, 100);
		// plants
		fire.registerFlammableBlock(BEARGRASS, 60, 100);
		fire.registerFlammableBlock(GOLDENROD, 60, 100);
		fire.registerFlammableBlock(GOLDEN_POPPY, 60, 100);
		fire.registerFlammableBlock(FIREWEED, 60, 100);
		fire.registerFlammableBlock(PRAIRIE_FIRE, 60, 100);
	}
}
