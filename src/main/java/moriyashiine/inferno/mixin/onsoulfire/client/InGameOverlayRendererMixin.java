/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire.client;

import moriyashiine.inferno.common.init.ModEntityComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Environment(EnvType.CLIENT)
@Mixin(InGameOverlayRenderer.class)
public class InGameOverlayRendererMixin {
	@Unique
	private static final SpriteIdentifier SOUL_FIRE_1 = TexturedRenderLayers.BLOCK_SPRITE_MAPPER.mapVanilla("soul_fire_1");

	@ModifyArg(method = "renderOverlays", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/SpriteHolder;getSprite(Lnet/minecraft/client/util/SpriteIdentifier;)Lnet/minecraft/client/texture/Sprite;"))
	private static SpriteIdentifier inferno$onSoulFire(SpriteIdentifier id) {
		PlayerEntity player = MinecraftClient.getInstance().player;
		if (player != null && ModEntityComponents.ON_SOUL_FIRE.get(player).isOnSoulFire()) {
			return SOUL_FIRE_1;
		}
		return id;
	}
}
