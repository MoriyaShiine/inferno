/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.copperfire;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.init.ModBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FireBlock.class)
public abstract class FireBlockMixin extends AbstractFireBlock {
	public FireBlockMixin(Settings settings, float damage) {
		super(settings, damage);
	}

	@ModifyExpressionValue(method = "getStateWithAge", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
	private boolean inferno$copperFire(boolean original, @Local BlockState state) {
		return original || state.isOf(ModBlocks.COPPER_FIRE);
	}
}
