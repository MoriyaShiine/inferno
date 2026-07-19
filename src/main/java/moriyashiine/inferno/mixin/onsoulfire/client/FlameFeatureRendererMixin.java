/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.mixin.onsoulfire.client;

import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.inferno.client.renderer.entity.state.SoulFireRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.feature.FlameFeatureRenderer;
import net.minecraft.client.resources.model.sprite.AtlasManager;
import net.minecraft.client.resources.model.sprite.SpriteId;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(FlameFeatureRenderer.class)
public class FlameFeatureRendererMixin {
	@Unique
	private static final SpriteId SOUL_FIRE_0 = Sheets.BLOCKS_MAPPER.defaultNamespaceApply("soul_fire_0");
	@Unique
	private static final SpriteId SOUL_FIRE_1 = Sheets.BLOCKS_MAPPER.defaultNamespaceApply("soul_fire_1");

	@Unique
	private static boolean shouldRenderSoulFire = false;

	@Inject(method = "renderSolid", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/feature/FlameFeatureRenderer;renderFlame(Lcom/mojang/blaze3d/vertex/PoseStack$Pose;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/renderer/entity/state/EntityRenderState;Lorg/joml/Quaternionf;Lnet/minecraft/client/resources/model/sprite/AtlasManager;)V"))
	private void inferno$onSoulFire(SubmitNodeCollection nodeCollection, MultiBufferSource.BufferSource bufferSource, AtlasManager atlasManager, CallbackInfo ci, @Local(name = "flameSubmit") SubmitNodeStorage.FlameSubmit flameSubmit) {
		shouldRenderSoulFire = ((SoulFireRenderState.Submit) (Object) flameSubmit).inferno$renderSoulFire();
	}

	@ModifyArg(method = "renderFlame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/sprite/AtlasManager;get(Lnet/minecraft/client/resources/model/sprite/SpriteId;)Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;", ordinal = 0))
	private SpriteId inferno$onSoulFire0(SpriteId sprite) {
		return shouldRenderSoulFire ? SOUL_FIRE_0 : sprite;
	}

	@ModifyArg(method = "renderFlame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/sprite/AtlasManager;get(Lnet/minecraft/client/resources/model/sprite/SpriteId;)Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;", ordinal = 1))
	private SpriteId inferno$onSoulFire1(SpriteId sprite) {
		return shouldRenderSoulFire ? SOUL_FIRE_1 : sprite;
	}
}
