package moriyashiine.inferno.mixin.copperfire;

import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.InfernoConfig;
import moriyashiine.inferno.common.init.InfernoBlocks;
import moriyashiine.inferno.common.world.level.block.CopperFireBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BaseFireBlock.class)
public class BaseFireBlockMixin {
	@Inject(method = "getState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoulFireBlock;canSurviveOnBlock(Lnet/minecraft/world/level/block/state/BlockState;)Z"), cancellable = true)
	private static void inferno$copperFire(BlockGetter level, BlockPos pos, CallbackInfoReturnable<BlockState> cir, @Local(name = "belowState") BlockState belowState) {
		if (InfernoConfig.copperFire && CopperFireBlock.canSurviveOnBlock(belowState)) {
			cir.setReturnValue(InfernoBlocks.COPPER_FIRE.defaultBlockState());
		}
	}
}
