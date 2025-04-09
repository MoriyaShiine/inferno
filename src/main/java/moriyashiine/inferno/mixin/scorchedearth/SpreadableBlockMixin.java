/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.scorchedearth;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SpreadableBlock.class)
public class SpreadableBlockMixin {
	@ModifyExpressionValue(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;getLightLevel(Lnet/minecraft/util/math/BlockPos;)I"))
	private int inferno$scorchedEarth(int original, BlockState state) {
		return state.isOf(ModBlocks.SCORCHED_EARTH) ? 0 : original;
	}

	@ModifyExpressionValue(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
	private boolean inferno$scorchedEarth(boolean original, BlockState state, ServerWorld world, @Local(ordinal = 1) BlockPos targetPos) {
		if (world.getBlockState(targetPos).isOf(ModBlocks.SCORCHED_EARTH)) {
			for (BlockPos otherPos : BlockPos.iterateOutwards(targetPos, 2, 2, 2)) {
				if (world.hasRain(otherPos.up())) {
					return true;
				}
			}
		}
		return original;
	}
}
