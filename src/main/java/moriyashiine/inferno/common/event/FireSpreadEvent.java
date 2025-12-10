/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.event;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.init.ModEntityComponents;
import moriyashiine.strawberrylib.api.event.TickEntityEvent;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.rule.GameRules;

public class FireSpreadEvent implements TickEntityEvent {
	private static final FireBlock FIRE = (FireBlock) Blocks.FIRE;
	private static final BlockPos.Mutable POS = new BlockPos.Mutable();
	private static final int RADIUS = 1;

	@Override
	public void tick(ServerWorld world, Entity entity) {
		float chance = ModConfig.entityFireSpreadChance;
		if (entity instanceof ProjectileEntity) {
			chance /= 16;
		}
		if ((entity.age + entity.getId()) % 20 == 0 && world.getRandom().nextFloat() < chance && world.getGameRules().getValue(GameRules.FIRE_SPREAD_RADIUS_AROUND_PLAYER) > 0) {
			if (shouldSpreadFire(entity)) {
				POS.set(
						entity.getBlockX() + entity.getRandom().nextBetween(-RADIUS, RADIUS),
						entity.getBlockY() + entity.getRandom().nextBetween(-RADIUS, RADIUS),
						entity.getBlockZ() + entity.getRandom().nextBetween(-RADIUS, RADIUS));
				if (!world.hasRain(POS) && world.getBlockState(POS).isAir() && FIRE.areBlocksAroundFlammable(world, POS)) {
					world.setBlockState(POS, FireBlock.getState(world, POS));
				}
			}
		}
	}

	private boolean shouldSpreadFire(Entity entity) {
		if (entity.isOnFire()) {
			if (ModEntityComponents.ENTITY_FIRE_SPREAD.get(entity).allowsFireSpread()) {
				return true;
			}
			return !(entity instanceof LivingEntity);
		}
		return false;
	}
}
