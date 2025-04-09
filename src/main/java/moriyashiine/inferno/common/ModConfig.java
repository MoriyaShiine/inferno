/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common;

import eu.midnightdust.lib.config.MidnightConfig;

public class ModConfig extends MidnightConfig {
	@Entry
	public static boolean charredLogs = true;
	@Entry
	public static boolean onSoulFire = true;
	@Entry
	public static boolean scorchedEarth = true;
	@Entry
	public static boolean torchIgnition = true;
	@Entry(min = 0, max = 1)
	public static float entityFireSpreadChance = 0.5F;

	@Entry(category = "client")
	public static boolean lowerHudFire = true;
	@Entry(category = "client")
	public static boolean smokyFog = true;
}
