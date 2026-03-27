/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.charredlogs;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FireBlock.class)
public class FireBlockMixin {
	@WrapOperation(method = "checkBurnOut", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;removeBlock(Lnet/minecraft/core/BlockPos;Z)Z"))
	private boolean inferno$charredLogs(Level instance, BlockPos pos, boolean movedByPiston, Operation<Boolean> original, @Local(name = "oldState") BlockState oldState) {
		if (ModConfig.charredLogs && instance.getRandom().nextBoolean() && oldState.is(BlockTags.LOGS)) {
			BlockState charredState = ModBlocks.CHARRED_LOG.defaultBlockState();
			if (oldState.hasProperty(RotatedPillarBlock.AXIS)) {
				charredState = charredState.setValue(RotatedPillarBlock.AXIS, oldState.getValue(RotatedPillarBlock.AXIS));
			}
			return instance.setBlockAndUpdate(pos, charredState);
		}
		return original.call(instance, pos, movedByPiston);
	}
}
