/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.scorchedearth;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FireBlock.class)
public class FireBlockMixin {
	@ModifyReturnValue(method = "getIgniteOdds(Lnet/minecraft/world/level/block/state/BlockState;)I", at = @At("RETURN"))
	private int inferno$scorchedEarthBurn(int original, BlockState state) {
		if (!ModConfig.scorchedEarth) {
			if (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.PODZOL)) {
				return 0;
			}
		}
		return original;
	}

	@ModifyReturnValue(method = "getBurnOdds", at = @At("RETURN"))
	private int inferno$scorchedEarthSpread(int original, BlockState state) {
		if (!ModConfig.scorchedEarth) {
			if (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.PODZOL)) {
				return 0;
			}
		}
		return original;
	}

	@ModifyExpressionValue(method = "checkBurnOut", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/RandomSource;nextInt(I)I", ordinal = 1))
	private int inferno$scorchedEarth(int original, @Local(name = "oldState") BlockState oldState) {
		if (ModConfig.scorchedEarth) {
			if (oldState.is(Blocks.GRASS_BLOCK) || oldState.is(Blocks.PODZOL)) {
				return Integer.MAX_VALUE;
			}
		}
		return original;
	}

	@WrapOperation(method = "checkBurnOut", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;removeBlock(Lnet/minecraft/core/BlockPos;Z)Z"))
	private boolean inferno$scorchedEarth(Level instance, BlockPos pos, boolean movedByPiston, Operation<Boolean> original, @Local(name = "oldState") BlockState oldState) {
		if (ModConfig.scorchedEarth) {
			if (oldState.is(Blocks.GRASS_BLOCK) || oldState.is(Blocks.PODZOL)) {
				return instance.setBlockAndUpdate(pos, ModBlocks.SCORCHED_EARTH.defaultBlockState());
			}
		}
		return original.call(instance, pos, movedByPiston);
	}
}
