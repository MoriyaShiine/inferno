/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.block;

import com.mojang.serialization.MapCodec;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class CopperFireBlock extends AbstractFireBlock {
	public static final MapCodec<CopperFireBlock> CODEC = createCodec(CopperFireBlock::new);

	public CopperFireBlock(Settings settings) {
		super(settings, 1);
	}

	@Override
	protected MapCodec<? extends AbstractFireBlock> getCodec() {
		return CODEC;
	}

	@Override
	protected boolean isFlammable(BlockState state) {
		return true;
	}

	@Override
	protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
		return canPlaceAt(state, world, pos) ? getDefaultState() : Blocks.AIR.getDefaultState();
	}

	@Override
	protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return isCopperBase(world.getBlockState(pos.down()));
	}

	public static boolean isCopperBase(BlockState state) {
		return state.isIn(ModBlockTags.COPPER_FIRE_BASE_BLOCKS);
	}
}
