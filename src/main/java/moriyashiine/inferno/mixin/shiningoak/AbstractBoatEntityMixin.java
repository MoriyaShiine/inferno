/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.shiningoak;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.common.init.ModEntityTypes;
import moriyashiine.strawberrylib.api.module.SLibUtils;
import moriyashiine.strawberrylib.api.objects.enums.SubmersionGate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.entity.vehicle.VehicleEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AbstractBoatEntity.class)
public abstract class AbstractBoatEntityMixin extends VehicleEntity {
	public AbstractBoatEntityMixin(EntityType<?> entityType, World world) {
		super(entityType, world);
	}

	@ModifyExpressionValue(method = {"getWaterHeightBelow", "checkBoatInWater", "getUnderWaterLocation"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
	private boolean inferno$shiningOak(boolean original, @Local FluidState state) {
		return original || pretendWater(state);
	}

	@ModifyExpressionValue(method = "fall", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
	private boolean inferno$shiningOak(boolean original) {
		return original || pretendWater(getEntityWorld().getFluidState(getBlockPos().down()));
	}

	@ModifyReturnValue(method = "getPaddleSound", at = @At("RETURN"))
	private SoundEvent inferno$shiningOak(SoundEvent original) {
		if (isShiningOak() && SLibUtils.isSubmerged(this, SubmersionGate.LAVA_ONLY)) {
			return SoundEvents.ENTITY_BOAT_PADDLE_LAND;
		}
		return original;
	}

	@ModifyArg(method = "updatePaddles", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/AbstractBoatEntity;setVelocity(Lnet/minecraft/util/math/Vec3d;)V"))
	private Vec3d inferno$shiningOak(Vec3d velocity) {
		if (isShiningOak() && SLibUtils.isSubmerged(this, SubmersionGate.LAVA_ONLY)) {
			return velocity.multiply(0.75);
		}
		return velocity;
	}

	@Unique
	private boolean isShiningOak() {
		return getType() == ModEntityTypes.SHINING_OAK_RAFT || getType() == ModEntityTypes.SHINING_OAK_CHEST_RAFT;
	}

	@Unique
	private boolean pretendWater(FluidState fluidState) {
		return isShiningOak() && fluidState.isIn(FluidTags.LAVA);
	}
}
