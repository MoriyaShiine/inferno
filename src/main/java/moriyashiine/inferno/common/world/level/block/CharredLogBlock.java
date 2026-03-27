/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.world.level.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.jspecify.annotations.Nullable;

import static net.minecraft.world.level.block.RotatedPillarBlock.AXIS;

public class CharredLogBlock extends FallingBlock {
	public static final MapCodec<CharredLogBlock> CODEC = simpleCodec(CharredLogBlock::new);

	public CharredLogBlock(Properties properties) {
		super(properties);
		registerDefaultState(defaultBlockState().setValue(AXIS, Direction.Axis.Y));
	}

	@Override
	protected MapCodec<CharredLogBlock> codec() {
		return CODEC;
	}

	@Override
	public int getDustColor(BlockState blockState, BlockGetter level, BlockPos pos) {
		return blockState.getMapColor(level, pos).col;
	}

	@Override
	protected BlockState rotate(BlockState state, Rotation rotation) {
		return RotatedPillarBlock.rotatePillar(state, rotation);
	}

	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
	}

	@Override
	public void destroy(LevelAccessor level, BlockPos pos, BlockState state) {
		if (level instanceof ServerLevel serverLevel) {
			serverLevel.sendParticles(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 8, 0.25, 0.25, 0.25, 0);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}
}
