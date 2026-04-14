package net.scythmon.cygnus.util;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.scythmon.cygnus.init.ModEffects;
import net.scythmon.cygnus.init.ModParticles;
import net.scythmon.cygnus.items.custom.crowns.ESpeedCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.EStrengthCrownArmorItem;

public class PlayerTickHandler {
    @SubscribeEvent
    public void onEntityAttacked(LivingAttackEvent event) {
        LivingEntity entity = event.getEntity();
        ItemStack helmetStack = entity.getItemBySlot(EquipmentSlot.HEAD);
        if (event.getAmount() <= 0
                || !entity.isAlive()) {
            return;
        }

        if (event.getSource().is(DamageTypeTags.IS_LIGHTNING) && event.isCancelable()) {
            if (!helmetStack.isEmpty() && helmetStack.getItem()instanceof ESpeedCrownArmorItem) {
                event.setCanceled(true);
            }
        }

        if (event.getSource().is(DamageTypeTags.IS_FIRE) && event.isCancelable()) {
            if (!helmetStack.isEmpty() && helmetStack.getItem()instanceof EStrengthCrownArmorItem) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onPotionEffectApplied(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();

        if (!(event.getEntity() instanceof Player) || !entity.level().isClientSide || entity.tickCount % 10 != 0) {
            return;
        }
        if (event.getEntity().hasEffect(ModEffects.COAGULATION.get())) {
            spawnEffectParticles(entity, ModParticles.COAGULATION_PARTICLE.get());
        }
        if (event.getEntity().hasEffect(ModEffects.SECOND_DEATH.get())) {
            spawnEffectParticles(entity, ModParticles.SECOND_DEATH_PARTICLE.get());
        }
        if (event.getEntity().hasEffect(ModEffects.HUNTED.get())) {
            spawnEffectParticles(entity, ModParticles.HUNTED_PARTICLE.get());
        }
    }

    private void spawnEffectParticles(LivingEntity entity, ParticleOptions particle) {
        Level world = entity.level();
        double x = entity.getRandomX(1);
        double y = entity.getRandomY();
        double z = entity.getRandomZ(1);

        world.addParticle(particle, x, y, z, 0.0, 0.1, 0.0);
    }
}
