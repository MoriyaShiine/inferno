/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import static net.minecraft.block.PillarBlock.AXIS;

public class CharredLogBlock extends FallingBlock {
	public static final MapCodec<CharredLogBlock> CODEC = createCodec(CharredLogBlock::new);

	public CharredLogBlock(Settings settings) {
		super(settings);
		setDefaultState(getDefaultState().with(AXIS, Direction.Axis.Y));
	}

	@Override
	protected MapCodec<? extends FallingBlock> getCodec() {
		return CODEC;
	}

	@Override
	public int getColor(BlockState state, BlockView world, BlockPos pos) {
		return state.getMapColor(world, pos).color;
	}

	@Override
	protected BlockState rotate(BlockState state, BlockRotation rotation) {
		return PillarBlock.changeRotation(state, rotation);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return getDefaultState().with(AXIS, ctx.getSide().getAxis());
	}

	@Override
	public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
		if (!world.isClient()) {
			((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 8, 0.25, 0.25, 0.25, 0);
		}
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}
}
