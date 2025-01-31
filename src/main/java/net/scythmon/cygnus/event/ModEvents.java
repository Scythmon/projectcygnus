package net.scythmon.cygnus.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.entity.ModEntities;
import net.scythmon.cygnus.entity.custom.TigerEntity;

@Mod.EventBusSubscriber(modid = ProjectCygnus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TIGER.get(), TigerEntity.setAttributes());
    }
}
