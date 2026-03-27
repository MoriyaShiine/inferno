/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.copperfire;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.init.ModBlocks;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FireBlock.class)
public abstract class FireBlockMixin extends BaseFireBlock {
	public FireBlockMixin(Properties properties, float fireDamage) {
		super(properties, fireDamage);
	}

	@ModifyExpressionValue(method = "getStateWithAge", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Ljava/lang/Object;)Z"))
	private boolean inferno$copperFire(boolean original, @Local(name = "stateForPlacement") BlockState stateForPlacement) {
		return original || stateForPlacement.is(ModBlocks.COPPER_FIRE);
	}
}
