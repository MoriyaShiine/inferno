/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire.client;

import moriyashiine.inferno.common.init.ModEntityComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Environment(EnvType.CLIENT)
@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {
	@Unique
	private static final SpriteId SOUL_FIRE_1 = Sheets.BLOCKS_MAPPER.defaultNamespaceApply("soul_fire_1");

	@ModifyArg(method = "renderScreenEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/sprite/SpriteGetter;get(Lnet/minecraft/client/resources/model/sprite/SpriteId;)Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;"))
	private static SpriteId inferno$onSoulFire(SpriteId id) {
		Player player = Minecraft.getInstance().player;
		if (player != null && ModEntityComponents.ON_SOUL_FIRE.get(player).isOnSoulFire()) {
			return SOUL_FIRE_1;
		}
		return id;
	}
}
