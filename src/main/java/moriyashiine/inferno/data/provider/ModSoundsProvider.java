/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.data.provider;

import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.init.ModSoundEvents;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

import static moriyashiine.inferno.common.Inferno.id;
import static net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder.RegistrationBuilder.ofFile;
import static net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder.of;

public class ModSoundsProvider extends FabricSoundsProvider {
	public ModSoundsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, SoundExporter exporter) {
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_BREAK, of().subtitle("subtitles.block.generic.break")
				.sound(ofFile(id("block/shining_oak_wood/break1")))
				.sound(ofFile(id("block/shining_oak_wood/break2")))
				.sound(ofFile(id("block/shining_oak_wood/break3")))
				.sound(ofFile(id("block/shining_oak_wood/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_FALL, of().subtitle("subtitles.block.generic.fall")
				.sound(ofFile(id("block/shining_oak_wood/step1")))
				.sound(ofFile(id("block/shining_oak_wood/step2")))
				.sound(ofFile(id("block/shining_oak_wood/step3")))
				.sound(ofFile(id("block/shining_oak_wood/step4")))
				.sound(ofFile(id("block/shining_oak_wood/step5")))
				.sound(ofFile(id("block/shining_oak_wood/step6"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_HIT, of().subtitle("subtitles.block.generic.hit")
				.sound(ofFile(id("block/shining_oak_wood/step1")))
				.sound(ofFile(id("block/shining_oak_wood/step2")))
				.sound(ofFile(id("block/shining_oak_wood/step3")))
				.sound(ofFile(id("block/shining_oak_wood/step4")))
				.sound(ofFile(id("block/shining_oak_wood/step5")))
				.sound(ofFile(id("block/shining_oak_wood/step6"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_PLACE, of().subtitle("subtitles.block.generic.place")
				.sound(ofFile(id("block/shining_oak_wood/break1")))
				.sound(ofFile(id("block/shining_oak_wood/break2")))
				.sound(ofFile(id("block/shining_oak_wood/break3")))
				.sound(ofFile(id("block/shining_oak_wood/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_STEP, of().subtitle("subtitles.block.generic.footsteps")
				.sound(ofFile(id("block/shining_oak_wood/step1")))
				.sound(ofFile(id("block/shining_oak_wood/step2")))
				.sound(ofFile(id("block/shining_oak_wood/step3")))
				.sound(ofFile(id("block/shining_oak_wood/step4")))
				.sound(ofFile(id("block/shining_oak_wood/step5")))
				.sound(ofFile(id("block/shining_oak_wood/step6"))));

		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_BUTTON_CLICK_OFF, of().subtitle("subtitles.block.button.click")
				.sound(ofFile(id("block/shining_oak_wood_button/click")).volume(0.4F).pitch(0.5F)));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_BUTTON_CLICK_ON, of().subtitle("subtitles.block.button.click")
				.sound(ofFile(id("block/shining_oak_wood_button/click")).volume(0.4F).pitch(0.6F)));

		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_DOOR_CLOSE, of().subtitle("subtitles.block.door.toggle")
				.sound(ofFile(id("block/shining_oak_wood_door/toggle1")))
				.sound(ofFile(id("block/shining_oak_wood_door/toggle2")))
				.sound(ofFile(id("block/shining_oak_wood_door/toggle3")))
				.sound(ofFile(id("block/shining_oak_wood_door/toggle4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_DOOR_OPEN, of().subtitle("subtitles.block.door.toggle")
				.sound(ofFile(id("block/shining_oak_wood_door/toggle1")))
				.sound(ofFile(id("block/shining_oak_wood_door/toggle2")))
				.sound(ofFile(id("block/shining_oak_wood_door/toggle3")))
				.sound(ofFile(id("block/shining_oak_wood_door/toggle4"))));

		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_FENCE_GATE_CLOSE, of().subtitle("subtitles.block.fence_gate.toggle")
				.sound(ofFile(id("block/shining_oak_wood_fence_gate/toggle1")))
				.sound(ofFile(id("block/shining_oak_wood_fence_gate/toggle2")))
				.sound(ofFile(id("block/shining_oak_wood_fence_gate/toggle3")))
				.sound(ofFile(id("block/shining_oak_wood_fence_gate/toggle4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_FENCE_GATE_OPEN, of().subtitle("subtitles.block.fence_gate.toggle")
				.sound(ofFile(id("block/shining_oak_wood_fence_gate/toggle1")))
				.sound(ofFile(id("block/shining_oak_wood_fence_gate/toggle2")))
				.sound(ofFile(id("block/shining_oak_wood_fence_gate/toggle3")))
				.sound(ofFile(id("block/shining_oak_wood_fence_gate/toggle4"))));

		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_BREAK, of().subtitle("subtitles.block.generic.break")
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/break1")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/break2")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/break3")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_FALL, of().subtitle("subtitles.block.generic.fall")
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step1")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step2")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step3")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_HIT, of().subtitle("subtitles.block.generic.hit")
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step1")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step2")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step3")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_PLACE, of().subtitle("subtitles.block.generic.place")
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/break1")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/break2")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/break3")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_STEP, of().subtitle("subtitles.block.generic.footsteps")
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step1")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step2")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step3")))
				.sound(ofFile(id("block/shining_oak_wood_hanging_sign/step4"))));

		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_LEAVES_BREAK, of().subtitle("subtitles.block.generic.break")
				.sound(ofFile(id("block/shining_oak_leaves/break1")))
				.sound(ofFile(id("block/shining_oak_leaves/break2")))
				.sound(ofFile(id("block/shining_oak_leaves/break3")))
				.sound(ofFile(id("block/shining_oak_leaves/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_LEAVES_FALL, of().subtitle("subtitles.block.generic.fall")
				.sound(ofFile(id("block/shining_oak_leaves/step1")))
				.sound(ofFile(id("block/shining_oak_leaves/step2")))
				.sound(ofFile(id("block/shining_oak_leaves/step3")))
				.sound(ofFile(id("block/shining_oak_leaves/step4")))
				.sound(ofFile(id("block/shining_oak_leaves/step5"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_LEAVES_HIT, of().subtitle("subtitles.block.generic.hit")
				.sound(ofFile(id("block/shining_oak_leaves/step1")).volume(0.8F))
				.sound(ofFile(id("block/shining_oak_leaves/step2")).volume(0.8F))
				.sound(ofFile(id("block/shining_oak_leaves/step3")).volume(0.8F))
				.sound(ofFile(id("block/shining_oak_leaves/step4")).volume(0.8F))
				.sound(ofFile(id("block/shining_oak_leaves/step5")).volume(0.8F)));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_LEAVES_PLACE, of().subtitle("subtitles.block.generic.place")
				.sound(ofFile(id("block/shining_oak_leaves/break1")))
				.sound(ofFile(id("block/shining_oak_leaves/break2")))
				.sound(ofFile(id("block/shining_oak_leaves/break3")))
				.sound(ofFile(id("block/shining_oak_leaves/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_LEAVES_STEP, of().subtitle("subtitles.block.generic.footsteps")
				.sound(ofFile(id("block/shining_oak_leaves/step1")))
				.sound(ofFile(id("block/shining_oak_leaves/step2")))
				.sound(ofFile(id("block/shining_oak_leaves/step3")))
				.sound(ofFile(id("block/shining_oak_leaves/step4")))
				.sound(ofFile(id("block/shining_oak_leaves/step5"))));

		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_SAPLING_BREAK, of().subtitle("subtitles.block.generic.break")
				.sound(ofFile(id("block/shining_oak_sapling/break1")))
				.sound(ofFile(id("block/shining_oak_sapling/break2")))
				.sound(ofFile(id("block/shining_oak_sapling/break3")))
				.sound(ofFile(id("block/shining_oak_sapling/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_SAPLING_PLACE, of().subtitle("subtitles.block.generic.place")
				.sound(ofFile(id("block/shining_oak_sapling/break1")))
				.sound(ofFile(id("block/shining_oak_sapling/break2")))
				.sound(ofFile(id("block/shining_oak_sapling/break3")))
				.sound(ofFile(id("block/shining_oak_sapling/break4"))));

		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_PRESSURE_PLATE_CLICK_OFF, of().subtitle("subtitles.block.pressure_plate.click")
				.sound(ofFile(id("block/shining_oak_wood_button/click")).volume(0.3F).pitch(0.7F)));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_PRESSURE_PLATE_CLICK_ON, of().subtitle("subtitles.block.pressure_plate.click")
				.sound(ofFile(id("block/shining_oak_wood_button/click")).volume(0.3F).pitch(0.8F)));

		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_TRAPDOOR_CLOSE, of().subtitle("subtitles.block.trapdoor.toggle")
				.sound(ofFile(id("block/shining_oak_wood_trapdoor/toggle1")))
				.sound(ofFile(id("block/shining_oak_wood_trapdoor/toggle2")))
				.sound(ofFile(id("block/shining_oak_wood_trapdoor/toggle3")))
				.sound(ofFile(id("block/shining_oak_wood_trapdoor/toggle4"))));
		exporter.add(ModSoundEvents.BLOCK_SHINING_OAK_WOOD_TRAPDOOR_OPEN, of().subtitle("subtitles.block.trapdoor.toggle")
				.sound(ofFile(id("block/shining_oak_wood_trapdoor/toggle1")))
				.sound(ofFile(id("block/shining_oak_wood_trapdoor/toggle2")))
				.sound(ofFile(id("block/shining_oak_wood_trapdoor/toggle3")))
				.sound(ofFile(id("block/shining_oak_wood_trapdoor/toggle4"))));

		exporter.add(ModSoundEvents.BLOCK_CHARRED_LOG_BREAK, of().subtitle("subtitles.block.generic.break")
				.sound(ofFile(id("block/charred_log/break1")))
				.sound(ofFile(id("block/charred_log/break2")))
				.sound(ofFile(id("block/charred_log/break3")))
				.sound(ofFile(id("block/charred_log/break4"))));
		exporter.add(ModSoundEvents.BLOCK_CHARRED_LOG_FALL, of().subtitle("subtitles.block.generic.fall")
				.sound(ofFile(id("block/charred_log/step1")))
				.sound(ofFile(id("block/charred_log/step2")))
				.sound(ofFile(id("block/charred_log/step3")))
				.sound(ofFile(id("block/charred_log/step4")))
				.sound(ofFile(id("block/charred_log/step5")))
				.sound(ofFile(id("block/charred_log/step6"))));
		exporter.add(ModSoundEvents.BLOCK_CHARRED_LOG_HIT, of().subtitle("subtitles.block.generic.hit")
				.sound(ofFile(id("block/charred_log/step1")))
				.sound(ofFile(id("block/charred_log/step2")))
				.sound(ofFile(id("block/charred_log/step3")))
				.sound(ofFile(id("block/charred_log/step4")))
				.sound(ofFile(id("block/charred_log/step5")))
				.sound(ofFile(id("block/charred_log/step6"))));
		exporter.add(ModSoundEvents.BLOCK_CHARRED_LOG_PLACE, of().subtitle("subtitles.block.generic.place")
				.sound(ofFile(id("block/charred_log/break1")))
				.sound(ofFile(id("block/charred_log/break2")))
				.sound(ofFile(id("block/charred_log/break3")))
				.sound(ofFile(id("block/charred_log/break4"))));
		exporter.add(ModSoundEvents.BLOCK_CHARRED_LOG_STEP, of().subtitle("subtitles.block.generic.footsteps")
				.sound(ofFile(id("block/charred_log/step1")))
				.sound(ofFile(id("block/charred_log/step2")))
				.sound(ofFile(id("block/charred_log/step3")))
				.sound(ofFile(id("block/charred_log/step4")))
				.sound(ofFile(id("block/charred_log/step5")))
				.sound(ofFile(id("block/charred_log/step6"))));

		exporter.add(ModSoundEvents.BLOCK_SCORCHED_EARTH_BREAK, of().subtitle("subtitles.block.generic.break")
				.sound(ofFile(id("block/scorched_earth/break1")))
				.sound(ofFile(id("block/scorched_earth/break2")))
				.sound(ofFile(id("block/scorched_earth/break3")))
				.sound(ofFile(id("block/scorched_earth/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SCORCHED_EARTH_FALL, of().subtitle("subtitles.block.generic.fall")
				.sound(ofFile(id("block/scorched_earth/step1")))
				.sound(ofFile(id("block/scorched_earth/step2")))
				.sound(ofFile(id("block/scorched_earth/step3")))
				.sound(ofFile(id("block/scorched_earth/step4"))));
		exporter.add(ModSoundEvents.BLOCK_SCORCHED_EARTH_HIT, of().subtitle("subtitles.block.generic.hit")
				.sound(ofFile(id("block/scorched_earth/step1")))
				.sound(ofFile(id("block/scorched_earth/step2")))
				.sound(ofFile(id("block/scorched_earth/step3")))
				.sound(ofFile(id("block/scorched_earth/step4"))));
		exporter.add(ModSoundEvents.BLOCK_SCORCHED_EARTH_PLACE, of().subtitle("subtitles.block.generic.place")
				.sound(ofFile(id("block/scorched_earth/break1")))
				.sound(ofFile(id("block/scorched_earth/break2")))
				.sound(ofFile(id("block/scorched_earth/break3")))
				.sound(ofFile(id("block/scorched_earth/break4"))));
		exporter.add(ModSoundEvents.BLOCK_SCORCHED_EARTH_STEP, of().subtitle("subtitles.block.generic.footsteps")
				.sound(ofFile(id("block/scorched_earth/step1")))
				.sound(ofFile(id("block/scorched_earth/step2")))
				.sound(ofFile(id("block/scorched_earth/step3")))
				.sound(ofFile(id("block/scorched_earth/step4"))));
	}

	@Override
	public String getName() {
		return Inferno.MOD_ID + "_sounds";
	}
}
