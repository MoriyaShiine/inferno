/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.block;

import com.mojang.serialization.MapCodec;
import moriyashiine.inferno.common.tag.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;

public class CopperFireBlock extends FireBlock {
	public static final MapCodec<FireBlock> CODEC = createCodec(CopperFireBlock::new);

	public CopperFireBlock(Settings settings) {
		super(settings);
	}

	@Override
	public MapCodec<FireBlock> getCodec() {
		return CODEC;
	}

	public static boolean isCopperBase(BlockState state) {
		return state.isIn(ModBlockTags.COPPER_FIRE_BASE_BLOCKS);
	}
}
