package net.scythmon.cygnus.util;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
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

        if (event.getSource().is(DamageTypeTags.IS_LIGHTNING)) {
            if (!helmetStack.isEmpty() && helmetStack.getItem()instanceof ESpeedCrownArmorItem) {
                event.setCanceled(true);
            }
        }

        if (event.getSource().is(DamageTypeTags.IS_FIRE)) {
            if (!helmetStack.isEmpty() && helmetStack.getItem()instanceof EStrengthCrownArmorItem) {
                event.setCanceled(true);
            }
        }
    }
    @SubscribeEvent
    public void naturalHealingDisabled(LivingHealEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(ModEffects.COAGULATION.get()) && !entity.hasEffect(MobEffects.REGENERATION) && !entity.hasEffect(MobEffects.HEAL)){
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPotionEffectApplied(LivingEvent.LivingTickEvent event) {
        if (event.getEntity().hasEffect(ModEffects.COAGULATION.get())) {
            LivingEntity entity = event.getEntity();
            spawnCoagulationParticles(entity);
        }
        if (event.getEntity().hasEffect(ModEffects.SECOND_DEATH.get())) {
            LivingEntity entity = event.getEntity();
            spawnSecondDeathParticles(entity);
        }
        if (event.getEntity().hasEffect(ModEffects.HUNTED.get())) {
            LivingEntity entity = event.getEntity();
            spawnHuntedParticles(entity);
        }
    }
    public void spawnCoagulationParticles(LivingEntity entity) {
        Level world = entity.level();
        if (world.getGameTime() % 20 == 0) {
            double x = entity.getRandomX(1);
            double y = entity.getRandomY();
            double z = entity.getRandomZ(1);
            double motionX = 0.0;
            double motionY = 0.1;
            double motionZ = 0.0;
            world.addParticle(ModParticles.COAGULATION_PARTICLE.get(), x, y, z, motionX, motionY, motionZ);
        }
    }
    public void spawnSecondDeathParticles(LivingEntity entity) {
        Level world = entity.level();
        if (world.getGameTime() % 10 == 0) {
            double x = entity.getRandomX(1);
            double y = entity.getRandomY();
            double z = entity.getRandomZ(1);
            double motionX = 0.0;
            double motionY = 0.1;
            double motionZ = 0.0;
            world.addParticle(ModParticles.SECOND_DEATH_PARTICLE.get(), x, y, z, motionX, motionY, motionZ);
        }
    }
    public void spawnHuntedParticles(LivingEntity entity) {
        Level world = entity.level();
        if (world.getGameTime() % 20 == 0) {
            double x = entity.getRandomX(1);
            double y = entity.getRandomY();
            double z = entity.getRandomZ(1);
            double motionX = 0.0;
            double motionY = 0.1;
            double motionZ = 0.0;
            world.addParticle(ModParticles.HUNTED_PARTICLE.get(), x, y, z, motionX, motionY, motionZ);
        }
    }
}
