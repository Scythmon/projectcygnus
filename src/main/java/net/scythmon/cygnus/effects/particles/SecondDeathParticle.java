package net.scythmon.cygnus.effects.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SecondDeathParticle extends TextureSheetParticle {
    private final SpriteSet spriteSet;
    public SecondDeathParticle(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);
        this.spriteSet = spriteSet;

        this.friction = 0F;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize *= 1;
        this.lifetime = 30;

        // Set the initial sprite
        this.setSpriteFromAge(spriteSet);

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }

    @Override
    public float getQuadSize(float scaleFactor) {
        return this.quadSize * 2;
    }


    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.spriteSet);
        this.fadeOut();
    }


    private void fadeOut() {
        if (this.age > 7) {
            float fadeProgress = (float)(this.age - 7) / (this.lifetime - 7);
            this.alpha = 1.0F - fadeProgress;
        } else {
            this.alpha = 1.0F;
        }
    }

    @NotNull
    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements net.minecraft.client.particle.ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public SecondDeathParticle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
            SecondDeathParticle particle = new SecondDeathParticle(level, x, y, z, this.spriteSet, dx, dy, dz);
            particle.setColor(1F, 1F, 1F);
            return particle;
        }
    }
}

