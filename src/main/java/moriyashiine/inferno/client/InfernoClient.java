/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.inferno.client;

import moriyashiine.inferno.client.event.SmokyFogEvent;
import moriyashiine.inferno.common.Inferno;
import moriyashiine.inferno.common.init.ModBlocks;
import moriyashiine.inferno.common.init.ModEntityTypes;
import moriyashiine.inferno.common.init.ModParticleTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.entity.RaftEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.RaftEntityModel;

public class InfernoClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		initBlockRenderers();
		initEntityRenderers();
		initParticleRenderers();
		initEvents();
	}

	private void initBlockRenderers() {
		// shining oak
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.SHINING_OAK_SAPLING, ModBlocks.POTTED_SHINING_OAK_SAPLING);
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.IRON_SHINING_OAK_LEAVES, ModBlocks.GOLDEN_SHINING_OAK_LEAVES);
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.SHINING_OAK_DOOR, ModBlocks.SHINING_OAK_TRAPDOOR);
		// plants
		BlockRenderLayerMap.putBlock(ModBlocks.BEARGRASS, BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.GOLDENROD, ModBlocks.POTTED_GOLDENROD);
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.GOLDEN_POPPY, ModBlocks.POTTED_GOLDEN_POPPY);
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.FIREWEED, ModBlocks.POTTED_FIREWEED);
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.PRAIRIE_FIRE, ModBlocks.POTTED_PRAIRIE_FIRE);
		// copper fire
		BlockRenderLayerMap.putBlock(ModBlocks.COPPER_FIRE, BlockRenderLayer.CUTOUT);
	}

	private void initEntityRenderers() {
		EntityModelLayer normal = new EntityModelLayer(Inferno.id("boat/shining_oak"), "main");
		EntityModelLayerRegistry.registerModelLayer(normal, RaftEntityModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntityTypes.SHINING_OAK_RAFT, context -> new RaftEntityRenderer(context, normal));

		EntityModelLayer chest = new EntityModelLayer(Inferno.id("chest_boat/shining_oak"), "main");
		EntityModelLayerRegistry.registerModelLayer(chest, RaftEntityModel::getChestTexturedModelData);
		EntityRendererRegistry.register(ModEntityTypes.SHINING_OAK_CHEST_RAFT, context -> new RaftEntityRenderer(context, chest));
	}

	private void initParticleRenderers() {
		ParticleFactoryRegistry.getInstance().register(ModParticleTypes.IRON_SHINING_OAK_LEAVES, LeavesParticle.CherryLeavesFactory::new);
		ParticleFactoryRegistry.getInstance().register(ModParticleTypes.GOLDEN_SHINING_OAK_LEAVES, LeavesParticle.CherryLeavesFactory::new);
	}

	private void initEvents() {
		ClientTickEvents.END_WORLD_TICK.register(new SmokyFogEvent());
	}
}
