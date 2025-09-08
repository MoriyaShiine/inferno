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
import moriyashiine.strawberrylib.api.event.ModifyDamageTakenEvent;
import moriyashiine.strawberrylib.api.event.TickEntityEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.util.Identifier;

public class Inferno implements ModInitializer {
	public static final String MOD_ID = "inferno";

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, ModConfig.class);
		SLib.init(MOD_ID);
		initRegistries();
		initEvents();
	}

	public static Identifier id(String value) {
		return Identifier.of(MOD_ID, value);
	}

	private void initRegistries() {
		ModBlocks.init();
		ModItems.init();
		ModEntityTypes.init();
		ModParticleTypes.init();
		ModSoundEvents.init();
	}

	private void initEvents() {
		TickEntityEvent.EVENT.register(new FireSpreadEvent());
		ModifyDamageTakenEvent.MULTIPLY_BASE.register(new OnSoulFireEvent());
		ServerLivingEntityEvents.AFTER_DAMAGE.register(new TorchIgnitionEvent());
	}
}