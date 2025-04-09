/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.block;

import com.mojang.serialization.MapCodec;
import moriyashiine.inferno.common.init.ModBlocks;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.WorldView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScorchedEarthBlock extends SpreadableBlock implements Fertilizable {
	public static final WeightedList<Block> RANDOM_ROLLS = new WeightedList<>();

	private static final Block PLACEHOLDER = Blocks.AIR;

	static {
		RANDOM_ROLLS.add(Blocks.WITHER_ROSE, 1);
		RANDOM_ROLLS.add(ModBlocks.SHINING_OAK_SAPLING, 5);
		RANDOM_ROLLS.add(PLACEHOLDER, 15);
	}

	public static final MapCodec<ScorchedEarthBlock> CODEC = createCodec(ScorchedEarthBlock::new);

	public ScorchedEarthBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected MapCodec<? extends SpreadableBlock> getCodec() {
		return CODEC;
	}

	@Override
	public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
		return world.getBlockState(pos.up()).isAir();
	}

	@Override
	public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public FertilizableType getFertilizableType() {
		return FertilizableType.NEIGHBOR_SPREADER;
	}

	@Override
	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		int toHeal = random.nextBetween(20, 36);
		int toCompare = toHeal;
		List<BlockPos> connected = new ArrayList<>();
		connected.add(pos);
		BlockPos.Mutable mutable = new BlockPos.Mutable();
		for (BlockPos otherPos : BlockPos.iterateOutwards(pos, 8, 8, 8)) {
			if (!pos.equals(otherPos) && world.getBlockState(otherPos).isOf(this) && world.getBlockState(otherPos.up()).isAir() && isConnected(otherPos, connected, mutable)) {
				connected.add(otherPos.toImmutable());
				if (--toHeal == 0) {
					break;
				}
			}
		}
		for (BlockPos connectedPos : connected) {
			world.setBlockState(connectedPos, Blocks.GRASS_BLOCK.getDefaultState());
		}
		if (toCompare - toHeal > 3) {
			for (int i = 0; i < 2; i++) {
				BlockPos randomPos = connected.remove(random.nextInt(connected.size())).up();
				Block randomRoll = getRandomRoll(random);
				placeRandomRoll(world, randomPos, randomRoll);
			}
			((GrassBlock) Blocks.GRASS_BLOCK).grow(world, random, pos, world.getBlockState(pos));
			world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, pos, 15);
		}
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		if (!world.isClient && world.getRandom().nextInt(4) == 0 && entity.getMovement().length() > 0.08) {
			((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE, entity.getX(), entity.getY(), entity.getZ(), 1, entity.getWidth() / 2, 0, entity.getWidth() / 2, 0);
		}
	}

	private static boolean isConnected(BlockPos center, List<BlockPos> connected, BlockPos.Mutable mutable) {
		final int range = 1;
		for (int x = -range; x <= range; x++) {
			for (int y = -range; y <= range; y++) {
				for (int z = -range; z <= range; z++) {
					if (x != 0 || y != 0 || z != 0) {
						mutable.set(center.getX() + x, center.getY() + y, center.getZ() + z);
						for (BlockPos pos : connected) {
							if (pos.equals(mutable)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static Block getRandomRoll(Random random) {
		Block randomRoll = RANDOM_ROLLS.shuffle().stream().findFirst().orElse(PLACEHOLDER);
		while (randomRoll == PLACEHOLDER) {
			Optional<RegistryEntry<Block>> entry = Registries.BLOCK.getRandomEntry(ModBlockTags.SCORCHED_EARTH_GROWABLES, random);
			if (entry.isPresent()) {
				randomRoll = entry.get().value();
			} else {
				break;
			}
		}
		return randomRoll;
	}

	private static void placeRandomRoll(World world, BlockPos pos, Block randomRoll) {
		if (randomRoll instanceof TallPlantBlock) {
			if (world.getBlockState(pos.up()).isReplaceable()) {
				TallPlantBlock.placeAt(world, randomRoll.getDefaultState(), pos, Block.NOTIFY_LISTENERS);
				return;
			} else while (randomRoll instanceof TallPlantBlock) {
				randomRoll = getRandomRoll(world.getRandom());
			}
		}
		world.setBlockState(pos, randomRoll.getDefaultState());
	}
}
