package net.scythmon.cygnus.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.init.ModEffects;

public class CoagulationEffect extends MobEffect {
    public CoagulationEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Mod.EventBusSubscriber(modid = ProjectCygnus.MOD_ID)
    public static class Events {
        @SubscribeEvent
        public static void onLivingHeal(LivingHealEvent event) {

            if (!event.getEntity().hasEffect(ModEffects.COAGULATION.get()) || !event.isCancelable())
                return;
            if (event.getAmount() >= 0 && !event.getEntity().hasEffect(MobEffects.REGENERATION)) {
                event.setCanceled(true);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
