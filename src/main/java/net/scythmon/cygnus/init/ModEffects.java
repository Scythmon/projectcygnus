package net.scythmon.cygnus.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.effects.CoagulationEffect;
import net.scythmon.cygnus.effects.SecondDeathEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ProjectCygnus.MOD_ID);

    public static final RegistryObject<MobEffect> SECOND_DEATH = MOB_EFFECTS.register("second_death",
            () -> new SecondDeathEffect(MobEffectCategory.HARMFUL, 0));

    public static final RegistryObject<MobEffect> BLOATED = MOB_EFFECTS.register("bloated",
            () -> new SecondDeathEffect(MobEffectCategory.HARMFUL, 0));

    public static final RegistryObject<MobEffect> COAGULATION = MOB_EFFECTS.register("coagulation",
            () -> new CoagulationEffect(MobEffectCategory.HARMFUL, 0));

    public static final RegistryObject<MobEffect> DIVINATION = MOB_EFFECTS.register("divination",
            () -> new SecondDeathEffect(MobEffectCategory.HARMFUL, 0));

    public static final RegistryObject<MobEffect> HUNTED = MOB_EFFECTS.register("hunted",
            () -> new SecondDeathEffect(MobEffectCategory.HARMFUL, 0));

    public static void register (IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
