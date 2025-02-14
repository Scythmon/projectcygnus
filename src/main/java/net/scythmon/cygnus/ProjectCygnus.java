package net.scythmon.cygnus;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.scythmon.cygnus.block.ModBlocks;
import net.scythmon.cygnus.block.entity.ModBlockEntities;
import net.scythmon.cygnus.entity.ModEntities;
import net.scythmon.cygnus.entity.client.renderers.PillarRenderer;
import net.scythmon.cygnus.entity.client.renderers.TigerRenderer;
import net.scythmon.cygnus.items.ModCreativeModeTabs;
import net.scythmon.cygnus.items.ModItems;
import net.scythmon.cygnus.items.potions.ModPotion;
import net.scythmon.cygnus.screen.ModMenuTypes;
import net.scythmon.cygnus.screen.StarForgeScreen;
import org.slf4j.Logger;



@Mod(ProjectCygnus.MOD_ID)
public class ProjectCygnus  {
    public static final String MOD_ID = "projectcygnus";
    private static final Logger LOGGER = LogUtils.getLogger();
    @SuppressWarnings("removal")
    public ProjectCygnus()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModPotion.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);


        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);



    }

    private void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CRYSTAL_LILY.getId(), ModBlocks.POTTED_CRYSTAL_LILY);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BLOOD_CARDINAL.getId(), ModBlocks.POTTED_BLOOD_CARDINAL);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.JUDGES_LILIES.getId(), ModBlocks.POTTED_JUDGES_LILIES);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FESTERED_PIMPERNEL.getId(), ModBlocks.POTTED_FESTERED_PIMPERNEL);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CHOIRS_GEM.getId(), ModBlocks.POTTED_CHOIRS_GEM);
            });
     }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        }
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.TIGER.get(), TigerRenderer::new);
            BlockEntityRenderers.register(ModBlockEntities.STAR_FORGE_PILLAR_BE.get(), PillarRenderer::new);
            MenuScreens.register(ModMenuTypes.STAR_FORGE_MENU.get(), StarForgeScreen::new);
        }
    }

}
