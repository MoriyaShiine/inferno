/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.copperfire;

import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.block.CopperFireBlock;
import moriyashiine.inferno.common.init.ModBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
	@Inject(method = "getState", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/SoulFireBlock;isSoulBase(Lnet/minecraft/block/BlockState;)Z"), cancellable = true)
	private static void inferno$copperFire(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> cir, @Local BlockState state) {
		if (ModConfig.copperFire && CopperFireBlock.isCopperBase(state)) {
			cir.setReturnValue(ModBlocks.COPPER_FIRE.getDefaultState());
		}
	}
}
