package net.scythmon.cygnus.util;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.LightningBolt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber
public class StrikeDelay {
    private static class PendingStrike {
        final ServerLevel level;
        final Vec3 position;
        int ticksRemaining;

        PendingStrike(ServerLevel level, Vec3 position, int ticksRemaining) {
            this.level = level;
            this.position = position;
            this.ticksRemaining = ticksRemaining;
        }
    }

    private static final List<PendingStrike> PENDING_STRIKES = new ArrayList<>();

    public static void scheduleSecondStrike(ServerLevel level, Vec3 position, int tickDelay) {
        PENDING_STRIKES.add(new PendingStrike(level, position, tickDelay));
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.LevelTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.level.isClientSide() && event.level instanceof ServerLevel) {

            Iterator<PendingStrike> iterator = PENDING_STRIKES.iterator();
            while (iterator.hasNext()) {
                PendingStrike strike = iterator.next();

                strike.ticksRemaining--;

                if (strike.ticksRemaining <= 0) {
                    LightningBolt secondBolt = EntityType.LIGHTNING_BOLT.create(strike.level);
                    if (secondBolt != null) {
                        secondBolt.moveTo(strike.position);
                        strike.level.addFreshEntity(secondBolt);
                    }
                    iterator.remove();
                }
            }
        }
    }
}
