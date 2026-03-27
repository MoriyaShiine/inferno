/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.world.level.block;

import com.mojang.serialization.MapCodec;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CopperFireBlock extends FireBlock {
	public static final MapCodec<FireBlock> CODEC = simpleCodec(CopperFireBlock::new);

	public CopperFireBlock(Properties properties) {
		super(properties);
	}

	@Override
	public MapCodec<FireBlock> codec() {
		return CODEC;
	}

	public static boolean canSurviveOnBlock(BlockState state) {
		return state.is(ModBlockTags.COPPER_FIRE_BASE_BLOCKS);
	}
}
