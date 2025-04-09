/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.ChestRaftEntity;
import net.minecraft.entity.vehicle.RaftEntity;
import net.minecraft.item.Item;

import java.util.function.Supplier;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerEntityType;

public class ModEntityTypes {
	public static final EntityType<RaftEntity> SHINING_OAK_RAFT = registerEntityType("shining_oak_raft",
			EntityType.Builder.create(getRaftFactory(() -> ModItems.SHINING_OAK_RAFT), SpawnGroup.MISC)
					.makeFireImmune()
					.dropsNothing()
					.dimensions(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.maxTrackingRange(10));
	public static final EntityType<ChestRaftEntity> SHINING_OAK_CHEST_RAFT = registerEntityType("shining_oak_chest_raft",
			EntityType.Builder.create(getChestRaftFactory(() -> ModItems.SHINING_OAK_CHEST_RAFT), SpawnGroup.MISC)
					.makeFireImmune()
					.dropsNothing()
					.dimensions(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.maxTrackingRange(10));

	public static void init() {
	}

	private static EntityType.EntityFactory<RaftEntity> getRaftFactory(Supplier<Item> itemSupplier) {
		return (type, world) -> new RaftEntity(type, world, itemSupplier);
	}

	private static EntityType.EntityFactory<ChestRaftEntity> getChestRaftFactory(Supplier<Item> itemSupplier) {
		return (type, world) -> new ChestRaftEntity(type, world, itemSupplier);
	}
}
