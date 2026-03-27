/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.ChestRaft;
import net.minecraft.world.entity.vehicle.boat.Raft;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerEntityType;

public class ModEntityTypes {
	public static final EntityType<Raft> SHINING_OAK_RAFT = registerEntityType("shining_oak_raft",
			EntityType.Builder.of(getRaftFactory(() -> ModItems.SHINING_OAK_RAFT), MobCategory.MISC)
					.fireImmune()
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));
	public static final EntityType<ChestRaft> SHINING_OAK_CHEST_RAFT = registerEntityType("shining_oak_chest_raft",
			EntityType.Builder.of(getChestRaftFactory(() -> ModItems.SHINING_OAK_CHEST_RAFT), MobCategory.MISC)
					.fireImmune()
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));

	public static void init() {
	}

	private static EntityType.EntityFactory<Raft> getRaftFactory(Supplier<Item> itemSupplier) {
		return (type, level) -> new Raft(type, level, itemSupplier);
	}

	private static EntityType.EntityFactory<ChestRaft> getChestRaftFactory(Supplier<Item> itemSupplier) {
		return (type, level) -> new ChestRaft(type, level, itemSupplier);
	}
}
