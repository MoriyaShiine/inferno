package moriyashiine.inferno.mixin.shiningoak;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.inferno.common.init.InfernoEntityTypes;
import moriyashiine.strawberrylib.api.module.SLibUtils;
import moriyashiine.strawberrylib.api.objects.enums.SubmersionGate;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AbstractBoat.class)
public abstract class AbstractBoatMixin extends VehicleEntity {
	public AbstractBoatMixin(EntityType<?> type, Level level) {
		super(type, level);
	}

	@ModifyExpressionValue(method = {"getWaterLevelAbove", "checkInWater", "isUnderwater", "checkFallDamage"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getFluidState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/material/FluidState;"))
	private FluidState inferno$shiningOak(FluidState original) {
		if (isShiningOak() && original.is(FluidTags.LAVA)) {
			FluidState pretend = Fluids.WATER.defaultFluidState();
			if (original.isSource()) {
				pretend.setValue(FlowingFluid.FALLING, original.getValue(FlowingFluid.FALLING));
			} else {
				pretend = Fluids.FLOWING_WATER.defaultFluidState()
						.setValue(FlowingFluid.FALLING, original.getValue(FlowingFluid.FALLING))
						.setValue(FlowingFluid.LEVEL, original.getValue(FlowingFluid.LEVEL));
			}
			return pretend;
		}
		return original;
	}

	@ModifyReturnValue(method = "getPaddleSound", at = @At("RETURN"))
	private SoundEvent inferno$shiningOak(SoundEvent original) {
		if (isShiningOak() && SLibUtils.isSubmerged(this, SubmersionGate.LAVA_ONLY)) {
			return SoundEvents.BOAT_PADDLE_LAND;
		}
		return original;
	}

	@ModifyArg(method = "controlBoat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/boat/AbstractBoat;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"))
	private Vec3 inferno$shiningOak(Vec3 deltaMovement) {
		if (isShiningOak() && SLibUtils.isSubmerged(this, SubmersionGate.LAVA_ONLY)) {
			return deltaMovement.scale(0.75);
		}
		return deltaMovement;
	}

	@Unique
	private boolean isShiningOak() {
		return getType() == InfernoEntityTypes.SHINING_OAK_RAFT || getType() == InfernoEntityTypes.SHINING_OAK_CHEST_RAFT;
	}
}
