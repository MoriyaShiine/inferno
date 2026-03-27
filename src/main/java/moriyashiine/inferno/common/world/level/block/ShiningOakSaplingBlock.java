/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.world.level.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class ShiningOakSaplingBlock extends SaplingBlock {
	public static final MapCodec<ShiningOakSaplingBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			TreeGrower.CODEC.fieldOf("iron_tree").forGetter(block -> block.treeGrower),
			TreeGrower.CODEC.fieldOf("golden_tree").forGetter(block -> block.alternateTreeGrower),
			propertiesCodec()).apply(instance, ShiningOakSaplingBlock::new)
	);

	private final TreeGrower alternateTreeGrower;

	public ShiningOakSaplingBlock(TreeGrower treeGrower, TreeGrower alternateTreeGrower, Properties settings) {
		super(treeGrower, settings);
		this.alternateTreeGrower = alternateTreeGrower;
	}

	@Override
	public MapCodec<ShiningOakSaplingBlock> codec() {
		return CODEC;
	}

	@Override
	public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
		if (state.getValue(STAGE) == 0) {
			level.setBlock(pos, state.cycle(STAGE), Block.UPDATE_NONE);
		} else {
			TreeGrower grower;
			BlockState baseState = level.getBlockState(pos.below(2));
			if (baseState.is(ModBlockTags.GENERIC_IRON_BLOCKS)) {
				grower = treeGrower;
			} else if (baseState.is(ModBlockTags.GENERIC_GOLD_BLOCKS)) {
				grower = alternateTreeGrower;
			} else {
				grower = random.nextBoolean() ? treeGrower : alternateTreeGrower;
			}
			grower.growTree(level, level.getChunkSource().getGenerator(), pos, state, random);
		}
	}
}
