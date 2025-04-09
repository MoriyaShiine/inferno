/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerParticleType;

public class ModParticleTypes {
	public static final SimpleParticleType IRON_SHINING_OAK_LEAVES = registerParticleType("iron_shining_oak_leaves", FabricParticleTypes.simple());
	public static final SimpleParticleType GOLDEN_SHINING_OAK_LEAVES = registerParticleType("golden_shining_oak_leaves", FabricParticleTypes.simple());

	public static void init() {
	}
}
