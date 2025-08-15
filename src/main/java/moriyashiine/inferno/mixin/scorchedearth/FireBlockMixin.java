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
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FireBlock.class)
public class FireBlockMixin {
	@ModifyReturnValue(method = "getBurnChance(Lnet/minecraft/block/BlockState;)I", at = @At("RETURN"))
	private int inferno$scorchedEarthBurn(int original, BlockState state) {
		if (!ModConfig.scorchedEarth) {
			if (state.isOf(Blocks.GRASS_BLOCK) || state.isOf(Blocks.PODZOL)) {
				return 0;
			}
		}
		return original;
	}

	@ModifyReturnValue(method = "getSpreadChance", at = @At("RETURN"))
	private int inferno$scorchedEarthSpread(int original, BlockState state) {
		if (!ModConfig.scorchedEarth) {
			if (state.isOf(Blocks.GRASS_BLOCK) || state.isOf(Blocks.PODZOL)) {
				return 0;
			}
		}
		return original;
	}

	@ModifyExpressionValue(method = "trySpreadingFire", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;nextInt(I)I", ordinal = 1))
	private int inferno$scorchedEarth(int original, @Local BlockState state) {
		if (ModConfig.scorchedEarth) {
			if (state.isOf(Blocks.GRASS_BLOCK) || state.isOf(Blocks.PODZOL)) {
				return Integer.MAX_VALUE;
			}
		}
		return original;
	}

	@WrapOperation(method = "trySpreadingFire", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;removeBlock(Lnet/minecraft/util/math/BlockPos;Z)Z"))
	private boolean inferno$scorchedEarth(World instance, BlockPos pos, boolean move, Operation<Boolean> original, @Local BlockState state) {
		if (ModConfig.scorchedEarth) {
			if (state.isOf(Blocks.GRASS_BLOCK) || state.isOf(Blocks.PODZOL)) {
				return instance.setBlockState(pos, ModBlocks.SCORCHED_EARTH.getDefaultState());
			}
		}
		return original.call(instance, pos, move);
	}
}
