package net.scythmon.cygnus.util.tickhandlers;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.init.ModEffects;
import net.scythmon.cygnus.init.ModParticles;

@Mod.EventBusSubscriber(modid = ProjectCygnus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PotionParticleHandler {
    @SubscribeEvent
    public static void onPotionEffectApplied(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();

        if (!(entity instanceof Player) || !entity.level().isClientSide() || entity.tickCount % 10 != 0) {
            return;
        }

        if (entity.hasEffect(ModEffects.COAGULATION.get())) {
            spawnEffectParticles(entity, ModParticles.COAGULATION_PARTICLE.get());
        }
        if (entity.hasEffect(ModEffects.SECOND_DEATH.get())) {
            spawnEffectParticles(entity, ModParticles.SECOND_DEATH_PARTICLE.get());
        }
        if (entity.hasEffect(ModEffects.HUNTED.get())) {
            spawnEffectParticles(entity, ModParticles.HUNTED_PARTICLE.get());
        }
    }

    private static void spawnEffectParticles(LivingEntity entity, ParticleOptions particle) {
        Level world = entity.level();
        double x = entity.getRandomX(1.0);
        double y = entity.getRandomY();
        double z = entity.getRandomZ(1.0);

        world.addParticle(particle, x, y, z, 0.0, 0.1, 0.0);
    }
}
