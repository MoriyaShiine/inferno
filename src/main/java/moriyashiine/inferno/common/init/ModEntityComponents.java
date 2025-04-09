/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.component.entity.EntityFireSpreadComponent;
import moriyashiine.inferno.common.component.entity.OnSoulFireComponent;
import net.minecraft.entity.Entity;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;

public class ModEntityComponents implements EntityComponentInitializer {
	public static final ComponentKey<EntityFireSpreadComponent> ENTITY_FIRE_SPREAD = ComponentRegistry.getOrCreate(Inferno.id("entity_fire_spread"), EntityFireSpreadComponent.class);
	public static final ComponentKey<OnSoulFireComponent> ON_SOUL_FIRE = ComponentRegistry.getOrCreate(Inferno.id("on_soul_fire"), OnSoulFireComponent.class);

	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerFor(Entity.class, ENTITY_FIRE_SPREAD, EntityFireSpreadComponent::new);
		registry.registerFor(Entity.class, ON_SOUL_FIRE, OnSoulFireComponent::new);
	}
}
