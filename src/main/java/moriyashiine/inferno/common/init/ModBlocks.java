/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.world.level.block.CharredLogBlock;
import moriyashiine.inferno.common.world.level.block.CopperFireBlock;
import moriyashiine.inferno.common.world.level.block.ScorchedEarthBlock;
import moriyashiine.inferno.common.world.level.block.ShiningOakSaplingBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerBlock;
import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerBlockType;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;

public class ModBlocks {
	// wood type
	private static final BlockSetType SHINING_OAK_BLOCK_SET_TYPE = new BlockSetTypeBuilder()
			.openableByHand(true)
			.openableByWindCharge(true)
			.buttonActivatedByArrows(true)
			.pressurePlateActivationRule(BlockSetType.PressurePlateSensitivity.EVERYTHING)
			.soundType(ModSoundEvents.SHINING_OAK_WOOD)
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
			.soundType(ModSoundEvents.SHINING_OAK_WOOD)
			.hangingSignSoundType(ModSoundEvents.SHINING_OAK_WOOD_HANGING_SIGN)
			.fenceGateCloseSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_FENCE_GATE_CLOSE)
			.fenceGateOpenSound(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_FENCE_GATE_OPEN)
			.register(Inferno.id("shining_oak"), SHINING_OAK_BLOCK_SET_TYPE);

	// shining oak
	public static final Block SHINING_OAK_SAPLING = registerBlock("shining_oak_sapling", settings -> new ShiningOakSaplingBlock(ModTreeGrowers.IRON_SHINING_OAK, ModTreeGrowers.GOLDEN_SHINING_OAK, settings), BlockBehaviour.Properties.of()
			.mapColor(MapColor.GOLD)
			.noCollision()
			.randomTicks()
			.instabreak()
			.sound(ModSoundEvents.SHINING_OAK_SAPLING)
			.pushReaction(PushReaction.DESTROY));
	public static final Block POTTED_SHINING_OAK_SAPLING = registerBlock("potted_shining_oak_sapling", settings -> new FlowerPotBlock(SHINING_OAK_SAPLING, settings), Blocks.flowerPotProperties());
	public static final Block SHINING_OAK_LOG = registerBlock("shining_oak_log", RotatedPillarBlock::new, of()
			.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? DyeColor.YELLOW.getMapColor() : MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sound(ModSoundEvents.SHINING_OAK_WOOD));
	public static final Block SHINING_OAK_WOOD = registerBlock("shining_oak_wood", RotatedPillarBlock::new, of()
			.mapColor(MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sound(ModSoundEvents.SHINING_OAK_WOOD));
	public static final Block STRIPPED_SHINING_OAK_LOG = registerBlock("stripped_shining_oak_log", RotatedPillarBlock::new, ofFullCopy(SHINING_OAK_LOG));
	public static final Block STRIPPED_SHINING_OAK_WOOD = registerBlock("stripped_shining_oak_wood", RotatedPillarBlock::new, ofFullCopy(SHINING_OAK_WOOD));
	public static final Block IRON_SHINING_OAK_LEAVES = registerBlock("iron_shining_oak_leaves", settings -> new UntintedParticleLeavesBlock(0.1F, ModParticleTypes.IRON_SHINING_OAK_LEAVES, settings), of()
			.mapColor(MapColor.COLOR_YELLOW)
			.strength(0.2F)
			.randomTicks()
			.sound(ModSoundEvents.SHINING_OAK_LEAVES)
			.noOcclusion()
			.isValidSpawn(Blocks::ocelotOrParrot)
			.isSuffocating(Blocks::never)
			.isViewBlocking(Blocks::never)
			.pushReaction(PushReaction.DESTROY)
			.isRedstoneConductor(Blocks::never));
	public static final Block GOLDEN_SHINING_OAK_LEAVES = registerBlock("golden_shining_oak_leaves", settings -> new UntintedParticleLeavesBlock(0.1F, ModParticleTypes.GOLDEN_SHINING_OAK_LEAVES, settings), ofFullCopy(IRON_SHINING_OAK_LEAVES));
	public static final Block SHINING_OAK_PLANKS = registerBlock("shining_oak_planks", Block::new, of()
			.mapColor(MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sound(ModSoundEvents.SHINING_OAK_WOOD));
	public static final Block SHINING_OAK_STAIRS = registerBlock("shining_oak_stairs", settings -> new StairBlock(SHINING_OAK_PLANKS.defaultBlockState(), settings), ofFullCopy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_SLAB = registerBlock("shining_oak_slab", SlabBlock::new, ofFullCopy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_FENCE = registerBlock("shining_oak_fence", FenceBlock::new, ofFullCopy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_FENCE_GATE = registerBlock("shining_oak_fence_gate", settings -> new FenceGateBlock(SHINING_OAK_WOOD_TYPE, settings), ofFullCopy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_DOOR = registerBlock("shining_oak_door", settings -> new DoorBlock(SHINING_OAK_BLOCK_SET_TYPE, settings), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.noOcclusion()
			.pushReaction(PushReaction.DESTROY));
	public static final Block SHINING_OAK_TRAPDOOR = registerBlock("shining_oak_trapdoor", settings -> new TrapDoorBlock(SHINING_OAK_BLOCK_SET_TYPE, settings), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.noOcclusion()
			.isValidSpawn(Blocks::never));
	public static final Block SHINING_OAK_PRESSURE_PLATE = registerBlock("shining_oak_pressure_plate", settings -> new PressurePlateBlock(SHINING_OAK_BLOCK_SET_TYPE, settings), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(0.5F)
			.pushReaction(PushReaction.DESTROY));
	public static final Block SHINING_OAK_BUTTON = registerBlock("shining_oak_button", settings -> new ButtonBlock(SHINING_OAK_BLOCK_SET_TYPE, 30, settings), Blocks.buttonProperties());
	public static final Block SHINING_OAK_SHELF = registerBlock("shining_oak_shelf", ShelfBlock::new, of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.sound(SoundType.SHELF)
			.strength(2, 3));
	public static final Block SHINING_OAK_SIGN = registerBlock("shining_oak_sign", settings -> new StandingSignBlock(SHINING_OAK_WOOD_TYPE, settings), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_WALL_SIGN = registerBlock("shining_oak_wall_sign", settings -> new WallSignBlock(SHINING_OAK_WOOD_TYPE, settings), of()
			.overrideLootTable(SHINING_OAK_SIGN.getLootTable())
			.overrideDescription(SHINING_OAK_SIGN.getDescriptionId())
			.mapColor(MapColor.WOOD)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_HANGING_SIGN = registerBlock("shining_oak_hanging_sign", settings -> new CeilingHangingSignBlock(SHINING_OAK_WOOD_TYPE, settings), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_WALL_HANGING_SIGN = registerBlock("shining_oak_wall_hanging_sign", settings -> new WallHangingSignBlock(SHINING_OAK_WOOD_TYPE, settings), of()
			.overrideLootTable(SHINING_OAK_HANGING_SIGN.getLootTable())
			.overrideDescription(SHINING_OAK_HANGING_SIGN.getDescriptionId())
			.mapColor(MapColor.WOOD)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	// remains
	public static final Block CHARRED_LOG = registerBlock("charred_log", CharredLogBlock::new, of()
			.mapColor(MapColor.COLOR_BLACK)
			.sound(ModSoundEvents.CHARRED_LOG).strength(1).pushReaction(PushReaction.DESTROY));
	public static final Block SCORCHED_EARTH = registerBlock("scorched_earth", ScorchedEarthBlock::new, of()
			.mapColor(DyeColor.BLACK)
			.randomTicks()
			.sound(ModSoundEvents.SCORCHED_EARTH).strength(0.6F));
	// plants
	public static final Block BEARGRASS = registerBlock("beargrass", TallFlowerBlock::new, ofFullCopy(Blocks.SUNFLOWER));
	public static final Block GOLDENROD = registerBlock("goldenrod", settings -> new FlowerBlock(MobEffects.HASTE, 7, settings), ofFullCopy(Blocks.DANDELION));
	public static final Block POTTED_GOLDENROD = registerBlock("potted_goldenrod", settings -> new FlowerPotBlock(GOLDENROD, settings), Blocks.flowerPotProperties());
	public static final Block GOLDEN_POPPY = registerBlock("golden_poppy", settings -> new FlowerBlock(MobEffects.NIGHT_VISION, 5, settings), ofFullCopy(Blocks.DANDELION));
	public static final Block POTTED_GOLDEN_POPPY = registerBlock("potted_golden_poppy", settings -> new FlowerPotBlock(GOLDEN_POPPY, settings), Blocks.flowerPotProperties());
	public static final Block FIREWEED = registerBlock("fireweed", settings -> new FlowerBlock(MobEffects.REGENERATION, 7, settings), ofFullCopy(Blocks.DANDELION));
	public static final Block POTTED_FIREWEED = registerBlock("potted_fireweed", settings -> new FlowerPotBlock(FIREWEED, settings), Blocks.flowerPotProperties());
	public static final Block PRAIRIE_FIRE = registerBlock("prairie_fire", settings -> new FlowerBlock(MobEffects.FIRE_RESISTANCE, 3, settings), ofFullCopy(Blocks.DANDELION));
	public static final Block POTTED_PRAIRIE_FIRE = registerBlock("potted_prairie_fire", settings -> new FlowerPotBlock(PRAIRIE_FIRE, settings), Blocks.flowerPotProperties());
	// copper fire
	public static final Block COPPER_CAMPFIRE = registerBlock("copper_campfire", settings -> new CampfireBlock(false, 1, settings), ofFullCopy(Blocks.CAMPFIRE));
	public static final Block COPPER_FIRE = registerBlock("copper_fire", CopperFireBlock::new, BlockBehaviour.Properties.of()
			.mapColor(MapColor.EMERALD)
			.replaceable()
			.noCollision()
			.instabreak()
			.lightLevel(_ -> 15)
			.sound(SoundType.WOOL)
			.pushReaction(PushReaction.DESTROY));

	public static void init() {
		registerBlockType("copper_fire", CopperFireBlock.CODEC);
		registerBlockType("falling_pillar", CharredLogBlock.CODEC);
		StrippableBlockRegistry.register(SHINING_OAK_LOG, STRIPPED_SHINING_OAK_LOG);
		StrippableBlockRegistry.register(SHINING_OAK_WOOD, STRIPPED_SHINING_OAK_WOOD);
		BlockEntityType.SHELF.addValidBlock(SHINING_OAK_SHELF);
		BlockEntityType.SIGN.addValidBlock(SHINING_OAK_SIGN);
		BlockEntityType.SIGN.addValidBlock(SHINING_OAK_WALL_SIGN);
		BlockEntityType.HANGING_SIGN.addValidBlock(SHINING_OAK_HANGING_SIGN);
		BlockEntityType.HANGING_SIGN.addValidBlock(SHINING_OAK_WALL_HANGING_SIGN);
		BlockEntityType.CAMPFIRE.addValidBlock(COPPER_CAMPFIRE);
		// vanilla
		FlammableBlockRegistry.getDefaultInstance().add(Blocks.GRASS_BLOCK, 60, 100);
		FlammableBlockRegistry.getDefaultInstance().add(Blocks.PODZOL, 60, 100);
		// plants
		FlammableBlockRegistry.getDefaultInstance().add(BEARGRASS, 60, 100);
		FlammableBlockRegistry.getDefaultInstance().add(GOLDENROD, 60, 100);
		FlammableBlockRegistry.getDefaultInstance().add(GOLDEN_POPPY, 60, 100);
		FlammableBlockRegistry.getDefaultInstance().add(FIREWEED, 60, 100);
		FlammableBlockRegistry.getDefaultInstance().add(PRAIRIE_FIRE, 60, 100);
	}
}
