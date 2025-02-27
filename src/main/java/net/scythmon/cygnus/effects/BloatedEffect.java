package net.scythmon.cygnus.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class BloatedEffect extends MobEffect {
    public BloatedEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.horizontalCollision) {
            Vec3 initalVec = pLivingEntity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initalVec.x,0.2D, initalVec.z);
            pLivingEntity.setDeltaMovement(climbVec.scale(0.97D));
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
