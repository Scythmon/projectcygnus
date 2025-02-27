package net.scythmon.cygnus;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.scythmon.cygnus.init.*;
import net.scythmon.cygnus.util.ModRecipies;
import net.scythmon.cygnus.util.PlayerTickHandler;
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
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipies.register(modEventBus);



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
            MinecraftForge.EVENT_BUS.register(new PlayerTickHandler());
     }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        }
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
