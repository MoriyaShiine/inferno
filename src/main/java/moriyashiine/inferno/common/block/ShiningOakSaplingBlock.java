/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class ShiningOakSaplingBlock extends SaplingBlock {
	public static final MapCodec<ShiningOakSaplingBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			SaplingGenerator.CODEC.fieldOf("iron_tree").forGetter(block -> block.generator),
			SaplingGenerator.CODEC.fieldOf("golden_tree").forGetter(block -> block.alternateGenerator),
			createSettingsCodec()).apply(instance, ShiningOakSaplingBlock::new)
	);

	private final SaplingGenerator alternateGenerator;

	public ShiningOakSaplingBlock(SaplingGenerator generator, SaplingGenerator alternateGenerator, Settings settings) {
		super(generator, settings);
		this.alternateGenerator = alternateGenerator;
	}

	@Override
	public MapCodec<? extends SaplingBlock> getCodec() {
		return CODEC;
	}

	@Override
	public void generate(ServerWorld world, BlockPos pos, BlockState state, Random random) {
		if (state.get(STAGE) == 0) {
			world.setBlockState(pos, state.cycle(STAGE), Block.SKIP_REDRAW_AND_BLOCK_ENTITY_REPLACED_CALLBACK);
		} else {
			SaplingGenerator generator;
			BlockState baseState = world.getBlockState(pos.down(2));
			if (baseState.isIn(ModBlockTags.GENERIC_IRON_BLOCKS)) {
				generator = this.generator;
			} else if (baseState.isIn(ModBlockTags.GENERIC_GOLD_BLOCKS)) {
				generator = alternateGenerator;
			} else {
				generator = random.nextBoolean() ? this.generator : alternateGenerator;
			}
			generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
		}
	}
}
