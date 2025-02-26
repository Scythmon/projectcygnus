package net.scythmon.cygnus.entity;

import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.scythmon.cygnus.util.ModDamageTypes;

public class ModDamageSources extends DamageSources implements ModDamageTypes {


    private final ResourceKey<DamageType> vitMaskBoss;


    public ModDamageSources(RegistryAccess pRegistry, DamageSource witherMaskBoss) {
        super(pRegistry);
        this.vitMaskBoss = ModDamageTypes.VITMASKBOSS;
    }

}