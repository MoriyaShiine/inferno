/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.event;

import moriyashiine.inferno.common.InfernoConfig;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import moriyashiine.inferno.common.init.InfernoEntityComponents;
import moriyashiine.strawberrylib.api.event.AfterDamageIncludingDeathEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TorchIgnitionEvent implements AfterDamageIncludingDeathEvent {
	public static void init() {
		AfterDamageIncludingDeathEvent.EVENT.register(new TorchIgnitionEvent());
	}

	@Override
	public void afterDamage(LivingEntity victim, DamageSource source, float originalDamage, float modifiedDamage, boolean blocked) {
		if (InfernoConfig.torchIgnition && source.getEntity() instanceof LivingEntity attacker) {
			ItemStack stack = attacker.getMainHandItem();
			boolean soul = stack.is(Items.SOUL_TORCH);
			if (stack.is(Items.TORCH) || soul) {
				victim.igniteForSeconds(4);
				stack.consume(1, attacker);
				attacker.onEquippedItemBroken(stack.getItem(), EquipmentSlot.MAINHAND);
				InfernoEntityComponents.ENTITY_FIRE_SPREAD.get(victim).setAllowFireSpread(true);
				if (InfernoConfig.onSoulFire) {
					OnSoulFireComponent onSoulFire = InfernoEntityComponents.ON_SOUL_FIRE.get(victim);
					if (onSoulFire.isOnSoulFire() != soul) {
						onSoulFire.setOnSoulFire(soul);
						onSoulFire.sync();
					}
				}
			}
		}
	}
}
