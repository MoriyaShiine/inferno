/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.mixin.onsoulfire.client;

import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.client.render.entity.state.SoulFireRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.command.BatchingRenderCommandQueue;
import net.minecraft.client.render.command.FireCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueueImpl;
import net.minecraft.client.texture.AtlasManager;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(FireCommandRenderer.class)
public class FireCommandRendererMixin {
	@Unique
	private static final SpriteIdentifier SOUL_FIRE_0 = TexturedRenderLayers.BLOCK_SPRITE_MAPPER.mapVanilla("soul_fire_0");
	@Unique
	private static final SpriteIdentifier SOUL_FIRE_1 = TexturedRenderLayers.BLOCK_SPRITE_MAPPER.mapVanilla("soul_fire_1");

	@Unique
	private static boolean shouldRenderSoulFire = false;

	@Inject(method = "render(Lnet/minecraft/client/render/command/BatchingRenderCommandQueue;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/texture/AtlasManager;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/command/FireCommandRenderer;render(Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/render/entity/state/EntityRenderState;Lorg/joml/Quaternionf;Lnet/minecraft/client/texture/AtlasManager;)V"))
	private void inferno$onSoulFire(BatchingRenderCommandQueue queue, VertexConsumerProvider.Immediate vertexConsumers, AtlasManager atlasManager, CallbackInfo ci, @Local OrderedRenderCommandQueueImpl.FireCommand command) {
		shouldRenderSoulFire = ((SoulFireRenderState.Command) (Object) command).inferno$renderSoulFire();
	}

	@ModifyArg(method = "render(Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/render/entity/state/EntityRenderState;Lorg/joml/Quaternionf;Lnet/minecraft/client/texture/AtlasManager;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/AtlasManager;getSprite(Lnet/minecraft/client/util/SpriteIdentifier;)Lnet/minecraft/client/texture/Sprite;", ordinal = 0))
	private SpriteIdentifier inferno$onSoulFire0(SpriteIdentifier id) {
		return shouldRenderSoulFire ? SOUL_FIRE_0 : id;
	}

	@ModifyArg(method = "render(Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/render/entity/state/EntityRenderState;Lorg/joml/Quaternionf;Lnet/minecraft/client/texture/AtlasManager;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/AtlasManager;getSprite(Lnet/minecraft/client/util/SpriteIdentifier;)Lnet/minecraft/client/texture/Sprite;", ordinal = 1))
	private SpriteIdentifier inferno$onSoulFire1(SpriteIdentifier id) {
		return shouldRenderSoulFire ? SOUL_FIRE_1 : id;
	}
}
