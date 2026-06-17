/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.references;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.key;

public class InfernoEntityTypeIds {
	public static final ResourceKey<EntityType<?>> SHINING_OAK_RAFT = key(Registries.ENTITY_TYPE, "shining_oak_raft");
	public static final ResourceKey<EntityType<?>> SHINING_OAK_CHEST_RAFT = key(Registries.ENTITY_TYPE, "shining_oak_chest_raft");
}
