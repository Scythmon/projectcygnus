package net.scythmon.cygnus.effects;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.init.ModEffects;
import net.scythmon.cygnus.init.ModItems;

public class DeathRefuted extends MobEffect {
    public DeathRefuted(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Mod.EventBusSubscriber(modid = ProjectCygnus.MOD_ID)
    public static class Events {
        @SubscribeEvent
        public static void onLivingHurt(LivingHurtEvent event) {
            LivingEntity entity = event.getEntity();

            if (!entity.hasEffect(ModEffects.DEATH_REFUTED.get()) || !event.isCancelable())
                return;
            if (entity.getHealth() <= event.getAmount()) {
                event.setCanceled(true);
                entity.setHealth(2);
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*180, 0), event.getEntity());
                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0), event.getEntity());
                entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 1), event.getEntity());
                entity.playSound(SoundEvents.TOTEM_USE, 1.0F, 1.0F);
                entity.removeEffect(ModEffects.DEATH_REFUTED.get());
            }
        }
    }
}
