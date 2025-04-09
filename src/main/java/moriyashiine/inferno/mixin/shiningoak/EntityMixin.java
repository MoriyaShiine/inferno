/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.shiningoak;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.inferno.common.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@Shadow
	public abstract @Nullable Entity getVehicle();

	@Shadow
	public abstract World getWorld();

	@Shadow
	public abstract float getHeight();

	@Shadow
	public abstract BlockPos getBlockPos();

	@ModifyReturnValue(method = "isInLava", at = @At("RETURN"))
	private boolean inferno$shiningOak(boolean original) {
		return original && !pretendNotInLava();
	}

	@ModifyExpressionValue(method = {"igniteByLava", "setOnFireFromLava"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isFireImmune()Z"))
	private boolean inferno$shiningOakIgnite(boolean original) {
		return original || pretendNotInLava();
	}

	@Unique
	private boolean pretendNotInLava() {
		@Nullable Entity vehicle = getVehicle();
		if (vehicle != null) {
			if (vehicle.getType() == ModEntityTypes.SHINING_OAK_RAFT || vehicle.getType() == ModEntityTypes.SHINING_OAK_CHEST_RAFT) {
				for (int i = 1; i < MathHelper.ceil(getHeight()); i++) {
					if (getWorld().getFluidState(getBlockPos().up(i)).isIn(FluidTags.LAVA)) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
