package moriyashiine.inferno.mixin.scorchedearth;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.init.InfernoBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.SpreadingSnowyBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SpreadingSnowyBlock.class)
public class SpreadingSnowyBlockMixin {
	@ModifyExpressionValue(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getMaxLocalRawBrightness(Lnet/minecraft/core/BlockPos;)I"))
	private int inferno$scorchedEarth(int original, BlockState state) {
		return state.is(InfernoBlocks.SCORCHED_EARTH) ? 0 : original;
	}

	@ModifyExpressionValue(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Ljava/lang/Object;)Z"))
	private boolean inferno$scorchedEarth(boolean original, BlockState state, ServerLevel level, @Local(name = "testPos") BlockPos testPos) {
		if (level.getBlockState(testPos).is(InfernoBlocks.SCORCHED_EARTH)) {
			for (BlockPos otherPos : BlockPos.withinManhattan(testPos, 2, 2, 2)) {
				if (level.isRainingAt(otherPos.above())) {
					return true;
				}
			}
		}
		return original;
	}
}
