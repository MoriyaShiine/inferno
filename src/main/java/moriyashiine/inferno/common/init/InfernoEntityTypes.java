/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.references.InfernoEntityTypeIds;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.ChestRaft;
import net.minecraft.world.entity.vehicle.boat.Raft;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerEntityType;

public class InfernoEntityTypes {
	public static final EntityType<Raft> SHINING_OAK_RAFT = registerEntityType(InfernoEntityTypeIds.SHINING_OAK_RAFT,
			EntityType.Builder.of(getRaftFactory(() -> InfernoItems.SHINING_OAK_RAFT), MobCategory.MISC)
					.fireImmune()
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));
	public static final EntityType<ChestRaft> SHINING_OAK_CHEST_RAFT = registerEntityType(InfernoEntityTypeIds.SHINING_OAK_CHEST_RAFT,
			EntityType.Builder.of(getChestRaftFactory(() -> InfernoItems.SHINING_OAK_CHEST_RAFT), MobCategory.MISC)
					.fireImmune()
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));

	private static EntityType.EntityFactory<Raft> getRaftFactory(Supplier<Item> itemSupplier) {
		return (type, level) -> new Raft(type, level, itemSupplier);
	}

	private static EntityType.EntityFactory<ChestRaft> getChestRaftFactory(Supplier<Item> itemSupplier) {
		return (type, level) -> new ChestRaft(type, level, itemSupplier);
	}

	public static void init() {
	}
}
