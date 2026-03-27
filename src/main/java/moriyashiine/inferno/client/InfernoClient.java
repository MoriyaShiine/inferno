/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.inferno.client;

import moriyashiine.inferno.client.event.SmokyFogEvent;
import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.init.ModEntityTypes;
import moriyashiine.inferno.common.init.ModParticleTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.RaftModel;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.RaftRenderer;

public class InfernoClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		initEntities();
		initParticles();
		initEvents();
	}

	private void initEntities() {
		ModelLayerLocation normal = new ModelLayerLocation(Inferno.id("boat/shining_oak"), "main");
		ModelLayerRegistry.registerModelLayer(normal, RaftModel::createRaftModel);
		EntityRenderers.register(ModEntityTypes.SHINING_OAK_RAFT, context -> new RaftRenderer(context, normal));

		ModelLayerLocation chest = new ModelLayerLocation(Inferno.id("chest_boat/shining_oak"), "main");
		ModelLayerRegistry.registerModelLayer(chest, RaftModel::createChestRaftModel);
		EntityRenderers.register(ModEntityTypes.SHINING_OAK_CHEST_RAFT, context -> new RaftRenderer(context, chest));
	}

	private void initParticles() {
		ParticleProviderRegistry.getInstance().register(ModParticleTypes.IRON_SHINING_OAK_LEAVES, FallingLeavesParticle.CherryProvider::new);
		ParticleProviderRegistry.getInstance().register(ModParticleTypes.GOLDEN_SHINING_OAK_LEAVES, FallingLeavesParticle.CherryProvider::new);
	}

	private void initEvents() {
		ClientTickEvents.END_LEVEL_TICK.register(new SmokyFogEvent());
	}
}
