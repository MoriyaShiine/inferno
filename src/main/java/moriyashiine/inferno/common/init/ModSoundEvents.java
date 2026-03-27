/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerSoundEvent;

public class ModSoundEvents {
	// shining oak
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_BREAK = registerSoundEvent("block.shining_oak_wood.break");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_FALL = registerSoundEvent("block.shining_oak_wood.fall");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_HIT = registerSoundEvent("block.shining_oak_wood.hit");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_PLACE = registerSoundEvent("block.shining_oak_wood.place");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_STEP = registerSoundEvent("block.shining_oak_wood.step");

	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_BUTTON_CLICK_OFF = registerSoundEvent("block.shining_oak_wood_button.click_off");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_BUTTON_CLICK_ON = registerSoundEvent("block.shining_oak_wood_button.click_on");

	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_DOOR_CLOSE = registerSoundEvent("block.shining_oak_wood_door.close");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_DOOR_OPEN = registerSoundEvent("block.shining_oak_wood_door.open");

	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_FENCE_GATE_CLOSE = registerSoundEvent("block.shining_oak_wood_fence_gate.close");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_FENCE_GATE_OPEN = registerSoundEvent("block.shining_oak_wood_fence_gate.open");

	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_BREAK = registerSoundEvent("block.shining_oak_wood_hanging_sign.break");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_FALL = registerSoundEvent("block.shining_oak_wood_hanging_sign.fall");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_HIT = registerSoundEvent("block.shining_oak_wood_hanging_sign.hit");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_PLACE = registerSoundEvent("block.shining_oak_wood_hanging_sign.place");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_STEP = registerSoundEvent("block.shining_oak_wood_hanging_sign.step");

	public static final SoundEvent BLOCK_SHINING_OAK_LEAVES_BREAK = registerSoundEvent("block.shining_oak_leaves.break");
	public static final SoundEvent BLOCK_SHINING_OAK_LEAVES_FALL = registerSoundEvent("block.shining_oak_leaves.fall");
	public static final SoundEvent BLOCK_SHINING_OAK_LEAVES_HIT = registerSoundEvent("block.shining_oak_leaves.hit");
	public static final SoundEvent BLOCK_SHINING_OAK_LEAVES_PLACE = registerSoundEvent("block.shining_oak_leaves.place");
	public static final SoundEvent BLOCK_SHINING_OAK_LEAVES_STEP = registerSoundEvent("block.shining_oak_leaves.step");

	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_PRESSURE_PLATE_CLICK_OFF = registerSoundEvent("block.shining_oak_wood_pressure_plate.click_off");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_PRESSURE_PLATE_CLICK_ON = registerSoundEvent("block.shining_oak_wood_pressure_plate.click_on");

	public static final SoundEvent BLOCK_SHINING_OAK_SAPLING_BREAK = registerSoundEvent("block.shining_oak_sapling.break");
	public static final SoundEvent BLOCK_SHINING_OAK_SAPLING_PLACE = registerSoundEvent("block.shining_oak_sapling.place");

	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_TRAPDOOR_CLOSE = registerSoundEvent("block.shining_oak_wood_trapdoor.close");
	public static final SoundEvent BLOCK_SHINING_OAK_WOOD_TRAPDOOR_OPEN = registerSoundEvent("block.shining_oak_wood_trapdoor.open");

	// remains
	public static final SoundEvent BLOCK_CHARRED_LOG_BREAK = registerSoundEvent("block.charred_log.break");
	public static final SoundEvent BLOCK_CHARRED_LOG_FALL = registerSoundEvent("block.charred_log.fall");
	public static final SoundEvent BLOCK_CHARRED_LOG_HIT = registerSoundEvent("block.charred_log.hit");
	public static final SoundEvent BLOCK_CHARRED_LOG_PLACE = registerSoundEvent("block.charred_log.place");
	public static final SoundEvent BLOCK_CHARRED_LOG_STEP = registerSoundEvent("block.charred_log.step");

	public static final SoundEvent BLOCK_SCORCHED_EARTH_BREAK = registerSoundEvent("block.scorched_earth.break");
	public static final SoundEvent BLOCK_SCORCHED_EARTH_FALL = registerSoundEvent("block.scorched_earth.fall");
	public static final SoundEvent BLOCK_SCORCHED_EARTH_HIT = registerSoundEvent("block.scorched_earth.hit");
	public static final SoundEvent BLOCK_SCORCHED_EARTH_PLACE = registerSoundEvent("block.scorched_earth.place");
	public static final SoundEvent BLOCK_SCORCHED_EARTH_STEP = registerSoundEvent("block.scorched_earth.step");

	public static final SoundType SHINING_OAK_WOOD = new SoundType(1, 1, BLOCK_SHINING_OAK_WOOD_BREAK, BLOCK_SHINING_OAK_WOOD_STEP, BLOCK_SHINING_OAK_WOOD_PLACE, BLOCK_SHINING_OAK_WOOD_HIT, BLOCK_SHINING_OAK_WOOD_FALL);
	public static final SoundType SHINING_OAK_WOOD_HANGING_SIGN = new SoundType(1, 1, BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_BREAK, BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_STEP, BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_PLACE, BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_HIT, BLOCK_SHINING_OAK_WOOD_HANGING_SIGN_FALL);
	public static final SoundType SHINING_OAK_LEAVES = new SoundType(1, 1, BLOCK_SHINING_OAK_LEAVES_BREAK, BLOCK_SHINING_OAK_LEAVES_STEP, BLOCK_SHINING_OAK_LEAVES_PLACE, BLOCK_SHINING_OAK_LEAVES_HIT, BLOCK_SHINING_OAK_LEAVES_FALL);
	public static final SoundType SHINING_OAK_SAPLING = new SoundType(1, 1, BLOCK_SHINING_OAK_SAPLING_BREAK, SoundEvents.EMPTY, BLOCK_SHINING_OAK_SAPLING_PLACE, SoundEvents.EMPTY, SoundEvents.EMPTY);
	public static final SoundType CHARRED_LOG = new SoundType(1, 1, BLOCK_CHARRED_LOG_BREAK, BLOCK_CHARRED_LOG_STEP, BLOCK_CHARRED_LOG_PLACE, BLOCK_CHARRED_LOG_HIT, BLOCK_CHARRED_LOG_FALL);
	public static final SoundType SCORCHED_EARTH = new SoundType(1, 1, BLOCK_SCORCHED_EARTH_BREAK, BLOCK_SCORCHED_EARTH_STEP, BLOCK_SCORCHED_EARTH_PLACE, BLOCK_SCORCHED_EARTH_HIT, BLOCK_SCORCHED_EARTH_FALL);

	public static void init() {
	}
}
