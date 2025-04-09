/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.event;

import moriyashiine.inferno.common.ModConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.ModEntityComponents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class TorchIgnitionEvent implements ServerLivingEntityEvents.AfterDamage {
	@Override
	public void afterDamage(LivingEntity entity, DamageSource source, float baseDamageTaken, float damageTaken, boolean blocked) {
		if (ModConfig.torchIgnition && source.getAttacker() instanceof LivingEntity attacker) {
			ItemStack stack = attacker.getMainHandStack();
			boolean soul = stack.isOf(Items.SOUL_TORCH);
			if (stack.isOf(Items.TORCH) || soul) {
				entity.setOnFireFor(4);
				stack.decrementUnlessCreative(1, attacker);
				attacker.sendEquipmentBreakStatus(stack.getItem(), EquipmentSlot.MAINHAND);
				ModEntityComponents.ENTITY_FIRE_SPREAD.get(entity).setAllowFireSpread(true);
				if (ModConfig.onSoulFire) {
					OnSoulFireComponent onSoulFireComponent = ModEntityComponents.ON_SOUL_FIRE.get(entity);
					if (onSoulFireComponent.isOnSoulFire() != soul) {
						onSoulFireComponent.setOnSoulFire(soul);
						onSoulFireComponent.sync();
					}
				}
			}
		}
	}
}
