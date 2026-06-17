/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common;

import eu.midnightdust.lib.config.MidnightConfig;
import moriyashiine.inferno.common.event.FireSpreadEvent;
import moriyashiine.inferno.common.event.OnSoulFireEvent;
import moriyashiine.inferno.common.event.TorchIgnitionEvent;
import moriyashiine.inferno.common.init.*;
import moriyashiine.strawberrylib.api.SLib;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class Inferno implements ModInitializer {
	public static final String MOD_ID = "inferno";

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, InfernoConfig.class);
		SLib.init(MOD_ID);
		initRegistries();
		initEvents();
	}

	public static Identifier id(String value) {
		return Identifier.fromNamespaceAndPath(MOD_ID, value);
	}

	private void initRegistries() {
		InfernoBlocks.init();
		InfernoItems.init();
		InfernoEntityTypes.init();
		InfernoParticleTypes.init();
		InfernoSoundEvents.init();
	}

	private void initEvents() {
		FireSpreadEvent.init();
		OnSoulFireEvent.init();
		TorchIgnitionEvent.init();
	}
}