package net.scythmon.cygnus.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;

public class EmperorTimer extends MobEffect {
    public EmperorTimer() {

        super(MobEffectCategory.NEUTRAL, 0xFFD700);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getCommandSenderWorld().isClientSide() && pLivingEntity instanceof Player player) {
            MobEffectInstance currentInstance = player.getEffect(this);

            if (currentInstance != null && currentInstance.getDuration() <= 1) {

                player.getFoodData().setFoodLevel(Math.max(0, player.getFoodData().getFoodLevel() - 6));

                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 3));

                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 2));
            }
        }
    }
    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
