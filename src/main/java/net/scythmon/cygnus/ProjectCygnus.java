package net.scythmon.cygnus;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.scythmon.cygnus.items.ModItems;
import org.slf4j.Logger;


@Mod(ProjectCygnus.MOD_ID)
public class ProjectCygnus
{

    public static final String MOD_ID = "projectcygnus";

    private static final Logger LOGGER = LogUtils.getLogger();

    public ProjectCygnus(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
     }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.STAR);
            event.accept(ModItems.CONCENTRATED_CRYSTAL_CLUSTER);
            event.accept(ModItems.SINGULARITY_STONE);
            event.accept(ModItems.WITHER_CONCENTRATE);
            event.accept(ModItems.LIFE_CONCENTRATE);
            event.accept(ModItems.UNDEAD_CONCENTRATE);
            event.accept(ModItems.SPEED_CONCENTRATE);
            event.accept(ModItems.STRENGTH_CONCENTRATE);
            event.accept(ModItems.STAR_CONCENTRATE);
            event.accept(ModItems.TRUE_CRYSTAL);
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
        }
    }
}
