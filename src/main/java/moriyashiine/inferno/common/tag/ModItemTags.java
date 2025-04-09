/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.common.tag;

import moriyashiine.inferno.common.Inferno;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModItemTags {
	public static final TagKey<Item> SHINING_OAK_LOGS = TagKey.of(RegistryKeys.ITEM, Inferno.id("shining_oak_logs"));
}
