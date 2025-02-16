package net.scythmon.cygnus.client.handler;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.client.renderer.PillarRenderer;
import net.scythmon.cygnus.client.screens.StarForgeScreen;
import net.scythmon.cygnus.init.ModBlockEntities;
import net.scythmon.cygnus.init.ModMenuTypes;

@Mod.EventBusSubscriber(modid = ProjectCygnus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModHandler {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenuTypes.STAR_FORGE_MENU.get(), StarForgeScreen::new);
        });
    }

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entities

        // Block Entities
        event.registerBlockEntityRenderer(ModBlockEntities.STAR_FORGE_PILLAR_BE.get(), PillarRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

    }
}