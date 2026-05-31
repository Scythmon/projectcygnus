package net.scythmon.cygnus.effects;

import com.google.common.collect.Lists;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class ForbiddenBargainEffect extends MobEffect {
    private static final String HP_MODIFIER_UUID = "7e3b1234-bcde-4f1a-8523-9a8b7c6d5e4f";
    private static final String STRENGTH_MODIFIER_UUID = "1a2b3c4d-5e6f-7a8b-9c0d-1e2f3a4b5c6d";

    public ForbiddenBargainEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x980000);

        this.addAttributeModifier(Attributes.MAX_HEALTH, HP_MODIFIER_UUID, -0.5D, AttributeModifier.Operation.MULTIPLY_TOTAL);

        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, STRENGTH_MODIFIER_UUID, 3.0D, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {

            int currentDuration = player.getEffect(this).getDuration();
            if (currentDuration > 5100) {
                player.getFoodData().eat(1, 2.0F);
            }

            var activeEffects = Lists.newArrayList(player.getActiveEffects());
            for (MobEffectInstance effectInstance : activeEffects) {
                MobEffect effect = effectInstance.getEffect();

                if (effect != this && (effect.getCategory() == MobEffectCategory.HARMFUL)) {
                    player.removeEffect(effect);
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
