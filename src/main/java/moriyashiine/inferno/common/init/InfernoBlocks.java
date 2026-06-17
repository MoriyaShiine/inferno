/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.references.InfernoBlockIds;
import moriyashiine.inferno.common.references.InfernoBlockItemIds;
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
import net.minecraft.world.level.block.entity.BlockEntityTypes;
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

public class InfernoBlocks {
	// wood type
	private static final BlockSetType SHINING_OAK_BLOCK_SET_TYPE = new BlockSetTypeBuilder()
			.openableByHand(true)
			.openableByWindCharge(true)
			.buttonActivatedByArrows(true)
			.pressurePlateActivationRule(BlockSetType.PressurePlateSensitivity.EVERYTHING)
			.soundType(InfernoSoundEvents.SHINING_OAK_WOOD)
			.buttonClickOffSound(InfernoSoundEvents.SHINING_OAK_WOOD_BUTTON_CLICK_OFF)
			.buttonClickOnSound(InfernoSoundEvents.SHINING_OAK_WOOD_BUTTON_CLICK_ON)
			.doorCloseSound(InfernoSoundEvents.SHINING_OAK_WOOD_DOOR_CLOSE)
			.doorOpenSound(InfernoSoundEvents.SHINING_OAK_WOOD_DOOR_OPEN)
			.pressurePlateClickOffSound(InfernoSoundEvents.SHINING_OAK_WOOD_PRESSURE_PLATE_CLICK_OFF)
			.pressurePlateClickOnSound(InfernoSoundEvents.SHINING_OAK_WOOD_PRESSURE_PLATE_CLICK_ON)
			.trapdoorCloseSound(InfernoSoundEvents.SHINING_OAK_WOOD_TRAPDOOR_CLOSE)
			.trapdoorOpenSound(InfernoSoundEvents.SHINING_OAK_WOOD_TRAPDOOR_OPEN)
			.register(Inferno.id("shining_oak"));
	private static final WoodType SHINING_OAK_WOOD_TYPE = new WoodTypeBuilder()
			.soundType(InfernoSoundEvents.SHINING_OAK_WOOD)
			.hangingSignSoundType(InfernoSoundEvents.SHINING_OAK_WOOD_HANGING_SIGN)
			.fenceGateCloseSound(InfernoSoundEvents.SHINING_OAK_WOOD_FENCE_GATE_CLOSE)
			.fenceGateOpenSound(InfernoSoundEvents.SHINING_OAK_WOOD_FENCE_GATE_OPEN)
			.register(Inferno.id("shining_oak"), SHINING_OAK_BLOCK_SET_TYPE);

	// shining oak
	public static final Block SHINING_OAK_SAPLING = registerBlock(InfernoBlockItemIds.SHINING_OAK_SAPLING, properties -> new ShiningOakSaplingBlock(InfernoTreeGrowers.IRON_SHINING_OAK, InfernoTreeGrowers.GOLDEN_SHINING_OAK, properties), BlockBehaviour.Properties.of()
			.mapColor(MapColor.GOLD)
			.noCollision()
			.randomTicks()
			.instabreak()
			.sound(InfernoSoundEvents.SHINING_OAK_SAPLING)
			.pushReaction(PushReaction.DESTROY));
	public static final Block POTTED_SHINING_OAK_SAPLING = registerBlock(InfernoBlockIds.POTTED_SHINING_OAK_SAPLING, properties -> new FlowerPotBlock(SHINING_OAK_SAPLING, properties), Blocks.flowerPotProperties());
	public static final Block SHINING_OAK_LOG = registerBlock(InfernoBlockItemIds.SHINING_OAK_LOG, RotatedPillarBlock::new, of()
			.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? DyeColor.YELLOW.getMapColor() : MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sound(InfernoSoundEvents.SHINING_OAK_WOOD));
	public static final Block SHINING_OAK_WOOD = registerBlock(InfernoBlockItemIds.SHINING_OAK_WOOD, RotatedPillarBlock::new, of()
			.mapColor(MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2)
			.sound(InfernoSoundEvents.SHINING_OAK_WOOD));
	public static final Block STRIPPED_SHINING_OAK_LOG = registerBlock(InfernoBlockItemIds.STRIPPED_SHINING_OAK_LOG, RotatedPillarBlock::new, ofFullCopy(SHINING_OAK_LOG));
	public static final Block STRIPPED_SHINING_OAK_WOOD = registerBlock(InfernoBlockItemIds.STRIPPED_SHINING_OAK_WOOD, RotatedPillarBlock::new, ofFullCopy(SHINING_OAK_WOOD));
	public static final Block IRON_SHINING_OAK_LEAVES = registerBlock(InfernoBlockItemIds.IRON_SHINING_OAK_LEAVES, properties -> new UntintedParticleLeavesBlock(0.1F, InfernoParticleTypes.IRON_SHINING_OAK_LEAVES, properties), of()
			.mapColor(MapColor.COLOR_YELLOW)
			.strength(0.2F)
			.randomTicks()
			.sound(InfernoSoundEvents.SHINING_OAK_LEAVES)
			.noOcclusion()
			.isValidSpawn(Blocks::ocelotOrParrot)
			.isSuffocating(Blocks::never)
			.isViewBlocking(Blocks::never)
			.pushReaction(PushReaction.DESTROY)
			.isRedstoneConductor(Blocks::never));
	public static final Block GOLDEN_SHINING_OAK_LEAVES = registerBlock(InfernoBlockItemIds.GOLDEN_SHINING_OAK_LEAVES, properties -> new UntintedParticleLeavesBlock(0.1F, InfernoParticleTypes.GOLDEN_SHINING_OAK_LEAVES, properties), ofFullCopy(IRON_SHINING_OAK_LEAVES));
	public static final Block SHINING_OAK_PLANKS = registerBlock(InfernoBlockItemIds.SHINING_OAK_PLANKS, Block::new, of()
			.mapColor(MapColor.GOLD)
			.instrument(NoteBlockInstrument.BASS)
			.strength(2, 3)
			.sound(InfernoSoundEvents.SHINING_OAK_WOOD));
	public static final Block SHINING_OAK_STAIRS = registerBlock(InfernoBlockItemIds.SHINING_OAK_STAIRS, properties -> new StairBlock(SHINING_OAK_PLANKS.defaultBlockState(), properties), ofFullCopy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_SLAB = registerBlock(InfernoBlockItemIds.SHINING_OAK_SLAB, SlabBlock::new, ofFullCopy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_FENCE = registerBlock(InfernoBlockItemIds.SHINING_OAK_FENCE, FenceBlock::new, ofFullCopy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_FENCE_GATE = registerBlock(InfernoBlockItemIds.SHINING_OAK_FENCE_GATE, settings -> new FenceGateBlock(SHINING_OAK_WOOD_TYPE, settings), ofFullCopy(SHINING_OAK_PLANKS));
	public static final Block SHINING_OAK_DOOR = registerBlock(InfernoBlockItemIds.SHINING_OAK_DOOR, properties -> new DoorBlock(SHINING_OAK_BLOCK_SET_TYPE, properties), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.noOcclusion()
			.pushReaction(PushReaction.DESTROY));
	public static final Block SHINING_OAK_TRAPDOOR = registerBlock(InfernoBlockItemIds.SHINING_OAK_TRAPDOOR, properties -> new TrapDoorBlock(SHINING_OAK_BLOCK_SET_TYPE, properties), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.strength(3)
			.noOcclusion()
			.isValidSpawn(Blocks::never));
	public static final Block SHINING_OAK_PRESSURE_PLATE = registerBlock(InfernoBlockItemIds.SHINING_OAK_PRESSURE_PLATE, properties -> new PressurePlateBlock(SHINING_OAK_BLOCK_SET_TYPE, properties), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(0.5F)
			.pushReaction(PushReaction.DESTROY));
	public static final Block SHINING_OAK_BUTTON = registerBlock(InfernoBlockItemIds.SHINING_OAK_BUTTON, properties -> new ButtonBlock(SHINING_OAK_BLOCK_SET_TYPE, 30, properties), Blocks.buttonProperties());
	public static final Block SHINING_OAK_SHELF = registerBlock(InfernoBlockItemIds.SHINING_OAK_SHELF, ShelfBlock::new, of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.instrument(NoteBlockInstrument.BASS)
			.sound(SoundType.SHELF)
			.strength(2, 3));
	public static final Block SHINING_OAK_SIGN = registerBlock(InfernoBlockItemIds.SHINING_OAK_SIGN, properties -> new StandingSignBlock(SHINING_OAK_WOOD_TYPE, properties), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_WALL_SIGN = registerBlock(InfernoBlockIds.SHINING_OAK_WALL_SIGN, properties -> new WallSignBlock(SHINING_OAK_WOOD_TYPE, properties), of()
			.overrideLootTable(SHINING_OAK_SIGN.getLootTable())
			.overrideDescription(SHINING_OAK_SIGN.getDescriptionId())
			.mapColor(MapColor.WOOD)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_HANGING_SIGN = registerBlock(InfernoBlockItemIds.SHINING_OAK_HANGING_SIGN, properties -> new CeilingHangingSignBlock(SHINING_OAK_WOOD_TYPE, properties), of()
			.mapColor(SHINING_OAK_PLANKS.defaultMapColor())
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	public static final Block SHINING_OAK_WALL_HANGING_SIGN = registerBlock(InfernoBlockIds.SHINING_OAK_WALL_HANGING_SIGN, properties -> new WallHangingSignBlock(SHINING_OAK_WOOD_TYPE, properties), of()
			.overrideLootTable(SHINING_OAK_HANGING_SIGN.getLootTable())
			.overrideDescription(SHINING_OAK_HANGING_SIGN.getDescriptionId())
			.mapColor(MapColor.WOOD)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASS)
			.noCollision()
			.strength(1));
	// remains
	public static final Block CHARRED_LOG = registerBlock(InfernoBlockItemIds.CHARRED_LOG, CharredLogBlock::new, of()
			.mapColor(MapColor.COLOR_BLACK)
			.sound(InfernoSoundEvents.CHARRED_LOG).strength(1).pushReaction(PushReaction.DESTROY));
	public static final Block SCORCHED_EARTH = registerBlock(InfernoBlockItemIds.SCORCHED_EARTH, ScorchedEarthBlock::new, of()
			.mapColor(DyeColor.BLACK)
			.randomTicks()
			.sound(InfernoSoundEvents.SCORCHED_EARTH).strength(0.6F));
	// plants
	public static final Block BEARGRASS = registerBlock(InfernoBlockItemIds.BEARGRASS, TallFlowerBlock::new, ofFullCopy(Blocks.SUNFLOWER));
	public static final Block GOLDENROD = registerBlock(InfernoBlockItemIds.GOLDENROD, properties -> new FlowerBlock(MobEffects.HASTE, 7, properties), ofFullCopy(Blocks.DANDELION));
	public static final Block POTTED_GOLDENROD = registerBlock(InfernoBlockIds.POTTED_GOLDENROD, properties -> new FlowerPotBlock(GOLDENROD, properties), Blocks.flowerPotProperties());
	public static final Block GOLDEN_POPPY = registerBlock(InfernoBlockItemIds.GOLDEN_POPPY, properties -> new FlowerBlock(MobEffects.NIGHT_VISION, 5, properties), ofFullCopy(Blocks.DANDELION));
	public static final Block POTTED_GOLDEN_POPPY = registerBlock(InfernoBlockIds.POTTED_GOLDEN_POPPY, properties -> new FlowerPotBlock(GOLDEN_POPPY, properties), Blocks.flowerPotProperties());
	public static final Block FIREWEED = registerBlock(InfernoBlockItemIds.FIREWEED, properties -> new FlowerBlock(MobEffects.REGENERATION, 7, properties), ofFullCopy(Blocks.DANDELION));
	public static final Block POTTED_FIREWEED = registerBlock(InfernoBlockIds.POTTED_FIREWEED, properties -> new FlowerPotBlock(FIREWEED, properties), Blocks.flowerPotProperties());
	public static final Block PRAIRIE_FIRE = registerBlock(InfernoBlockItemIds.PRAIRIE_FIRE, properties -> new FlowerBlock(MobEffects.FIRE_RESISTANCE, 3, properties), ofFullCopy(Blocks.DANDELION));
	public static final Block POTTED_PRAIRIE_FIRE = registerBlock(InfernoBlockIds.POTTED_PRAIRIE_FIRE, properties -> new FlowerPotBlock(PRAIRIE_FIRE, properties), Blocks.flowerPotProperties());
	// copper fire
	public static final Block COPPER_CAMPFIRE = registerBlock(InfernoBlockItemIds.COPPER_CAMPFIRE, properties -> new CampfireBlock(false, 1, properties), ofFullCopy(Blocks.CAMPFIRE));
	public static final Block COPPER_FIRE = registerBlock(InfernoBlockIds.COPPER_FIRE, CopperFireBlock::new, BlockBehaviour.Properties.of()
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
		BlockEntityTypes.SHELF.addValidBlock(SHINING_OAK_SHELF);
		BlockEntityTypes.SIGN.addValidBlock(SHINING_OAK_SIGN);
		BlockEntityTypes.SIGN.addValidBlock(SHINING_OAK_WALL_SIGN);
		BlockEntityTypes.HANGING_SIGN.addValidBlock(SHINING_OAK_HANGING_SIGN);
		BlockEntityTypes.HANGING_SIGN.addValidBlock(SHINING_OAK_WALL_HANGING_SIGN);
		BlockEntityTypes.CAMPFIRE.addValidBlock(COPPER_CAMPFIRE);
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
