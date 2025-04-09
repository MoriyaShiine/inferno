/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.charredlogs;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FireBlock.class)
public class FireBlockMixin {
	@WrapOperation(method = "trySpreadingFire", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;removeBlock(Lnet/minecraft/util/math/BlockPos;Z)Z"))
	private boolean inferno$charredLogs(World instance, BlockPos pos, boolean move, Operation<Boolean> original, @Local BlockState state) {
		if (ModConfig.charredLogs && instance.getRandom().nextBoolean() && state.isIn(BlockTags.LOGS)) {
			BlockState charredState = ModBlocks.CHARRED_LOG.getDefaultState();
			if (state.contains(PillarBlock.AXIS)) {
				charredState = charredState.with(PillarBlock.AXIS, state.get(PillarBlock.AXIS));
			}
			return instance.setBlockState(pos, charredState);
		}
		return original.call(instance, pos, move);
	}
}
