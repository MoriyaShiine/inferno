package moriyashiine.inferno.common.init;

import moriyashiine.inferno.common.references.InfernoEntityTypeIds;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.ChestRaft;
import net.minecraft.world.entity.vehicle.boat.Raft;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerEntityType;

public class InfernoEntityTypes {
	public static final EntityType<Raft> SHINING_OAK_RAFT = registerEntityType(InfernoEntityTypeIds.SHINING_OAK_RAFT,
			EntityType.Builder.of(EntityTypes.raftFactory(() -> InfernoItems.SHINING_OAK_RAFT), MobCategory.MISC)
					.fireImmune()
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));
	public static final EntityType<ChestRaft> SHINING_OAK_CHEST_RAFT = registerEntityType(InfernoEntityTypeIds.SHINING_OAK_CHEST_RAFT,
			EntityType.Builder.of(EntityTypes.chestRaftFactory(() -> InfernoItems.SHINING_OAK_CHEST_RAFT), MobCategory.MISC)
					.fireImmune()
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));

	public static void init() {
	}
}
