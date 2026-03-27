/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.world.level.block;

import com.mojang.serialization.MapCodec;
import moriyashiine.inferno.common.init.ModBlocks;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockIds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.behavior.ShufflingList;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScorchedEarthBlock extends SpreadingSnowyBlock implements BonemealableBlock {
	public static final ShufflingList<Block> RANDOM_ROLLS = new ShufflingList<>();

	private static final Block PLACEHOLDER = Blocks.AIR;

	static {
		RANDOM_ROLLS.add(Blocks.WITHER_ROSE, 1);
		RANDOM_ROLLS.add(ModBlocks.SHINING_OAK_SAPLING, 5);
		RANDOM_ROLLS.add(PLACEHOLDER, 15);
	}

	public static final MapCodec<ScorchedEarthBlock> CODEC = simpleCodec(ScorchedEarthBlock::new);

	public ScorchedEarthBlock(Properties properties) {
		super(properties, BlockIds.DIRT);
	}

	@Override
	protected MapCodec<ScorchedEarthBlock> codec() {
		return CODEC;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
		return level.getBlockState(pos.above()).isAir() && level.isInsideBuildHeight(pos.above());
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		int toHeal = random.nextIntBetweenInclusive(20, 36);
		int toCompare = toHeal;
		List<BlockPos> connected = new ArrayList<>();
		connected.add(pos);
		BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
		for (BlockPos otherPos : BlockPos.withinManhattan(pos, 8, 8, 8)) {
			if (!pos.equals(otherPos) && level.getBlockState(otherPos).is(this) && level.getBlockState(otherPos.above()).isAir() && isConnected(otherPos, connected, mutable)) {
				connected.add(otherPos.immutable());
				if (--toHeal == 0) {
					break;
				}
			}
		}
		for (BlockPos connectedPos : connected) {
			level.setBlockAndUpdate(connectedPos, Blocks.GRASS_BLOCK.defaultBlockState());
		}
		if (toCompare - toHeal > 3) {
			for (int i = 0; i < 2; i++) {
				BlockPos randomPos = connected.remove(random.nextInt(connected.size())).above();
				Block randomRoll = getRandomRoll(random);
				placeRandomRoll(level, randomPos, randomRoll);
			}
			((GrassBlock) Blocks.GRASS_BLOCK).performBonemeal(level, random, pos, level.getBlockState(pos));
			level.levelEvent(LevelEvent.PARTICLES_AND_SOUND_PLANT_GROWTH, pos, 15);
		}
	}

	@Override
	public Type getType() {
		return Type.NEIGHBOR_SPREADER;
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
		if (level instanceof ServerLevel serverLevel && level.getRandom().nextInt(4) == 0 && entity.getKnownMovement().length() > 0.08) {
			serverLevel.sendParticles(ParticleTypes.SMOKE, entity.getX(), entity.getY(), entity.getZ(), 1, entity.getBbWidth() / 2, 0, entity.getBbWidth() / 2, 0);
		}
	}

	private static boolean isConnected(BlockPos center, List<BlockPos> connected, BlockPos.MutableBlockPos mutable) {
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

	private static Block getRandomRoll(RandomSource random) {
		Block randomRoll = RANDOM_ROLLS.shuffle().stream().findFirst().orElse(PLACEHOLDER);
		while (randomRoll == PLACEHOLDER) {
			Optional<Holder<Block>> holder = BuiltInRegistries.BLOCK.getRandomElementOf(ModBlockTags.SCORCHED_EARTH_GROWABLES, random);
			if (holder.isPresent()) {
				randomRoll = holder.get().value();
			} else {
				break;
			}
		}
		return randomRoll;
	}

	private static void placeRandomRoll(Level level, BlockPos pos, Block randomRoll) {
		if (randomRoll instanceof DoublePlantBlock) {
			if (level.getBlockState(pos.above()).canBeReplaced()) {
				DoublePlantBlock.placeAt(level, randomRoll.defaultBlockState(), pos, Block.UPDATE_CLIENTS);
				return;
			} else while (randomRoll instanceof DoublePlantBlock) {
				randomRoll = getRandomRoll(level.getRandom());
			}
		}
		level.setBlockAndUpdate(pos, randomRoll.defaultBlockState());
	}
}
