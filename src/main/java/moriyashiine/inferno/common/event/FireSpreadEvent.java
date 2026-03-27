/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.event;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.init.ModEntityComponents;
import moriyashiine.strawberrylib.api.event.TickEntityEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.gamerules.GameRules;

public class FireSpreadEvent implements TickEntityEvent {
	private static final FireBlock FIRE = (FireBlock) Blocks.FIRE;
	private static final BlockPos.MutableBlockPos POS = new BlockPos.MutableBlockPos();
	private static final int RADIUS = 1;

	@Override
	public void tick(Level level, Entity entity) {
		if (level instanceof ServerLevel serverLevel) {
			float chance = ModConfig.entityFireSpreadChance;
			if (entity instanceof Projectile) {
				chance /= 16;
			}
			if ((entity.tickCount + entity.getId()) % 20 == 0 && level.getRandom().nextFloat() < chance && serverLevel.getGameRules().get(GameRules.FIRE_SPREAD_RADIUS_AROUND_PLAYER) > 0) {
				if (shouldSpreadFire(entity)) {
					POS.set(
							entity.getBlockX() + entity.getRandom().nextIntBetweenInclusive(-RADIUS, RADIUS),
							entity.getBlockY() + entity.getRandom().nextIntBetweenInclusive(-RADIUS, RADIUS),
							entity.getBlockZ() + entity.getRandom().nextIntBetweenInclusive(-RADIUS, RADIUS));
					if (!level.isRainingAt(POS) && level.getBlockState(POS).isAir() && FIRE.isValidFireLocation(level, POS)) {
						level.setBlockAndUpdate(POS, FireBlock.getState(level, POS));
					}
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
