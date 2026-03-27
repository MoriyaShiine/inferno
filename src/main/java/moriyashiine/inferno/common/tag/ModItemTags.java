/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.common.tag;

import moriyashiine.inferno.common.Inferno;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
	public static final TagKey<Item> SHINING_OAK_LOGS = TagKey.create(Registries.ITEM, Inferno.id("shining_oak_logs"));
}
