/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.shiningoak;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.inferno.common.init.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@Shadow
	public abstract Level level();

	@Shadow
	public abstract @Nullable Entity getVehicle();

	@Shadow
	public abstract BlockPos blockPosition();

	@Shadow
	public abstract float getBbHeight();

	@ModifyReturnValue(method = "isInLava", at = @At("RETURN"))
	private boolean inferno$shiningOak(boolean original) {
		return original && !pretendNotInLava();
	}

	@ModifyExpressionValue(method = {"lavaIgnite", "lavaHurt"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;fireImmune()Z"))
	private boolean inferno$shiningOakIgnite(boolean original) {
		return original || pretendNotInLava();
	}

	@Unique
	private boolean pretendNotInLava() {
		@Nullable Entity vehicle = getVehicle();
		if (vehicle != null) {
			if (vehicle.getType() == ModEntityTypes.SHINING_OAK_RAFT || vehicle.getType() == ModEntityTypes.SHINING_OAK_CHEST_RAFT) {
				for (int i = 1; i < Mth.ceil(getBbHeight()); i++) {
					if (level().getFluidState(blockPosition().above(i)).is(FluidTags.LAVA)) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
