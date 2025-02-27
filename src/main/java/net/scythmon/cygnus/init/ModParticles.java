package net.scythmon.cygnus.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES
            = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ProjectCygnus.MOD_ID);

    public static final RegistryObject<SimpleParticleType> SECOND_DEATH_PARTICLE =
            PARTICLES.register("second_death_particle", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}
