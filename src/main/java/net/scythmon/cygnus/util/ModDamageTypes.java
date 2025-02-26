package net.scythmon.cygnus.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.scythmon.cygnus.ProjectCygnus;

public interface ModDamageTypes {
    ResourceKey<DamageType> VITMASKBOSS = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(ProjectCygnus.MOD_ID, "withermask")
    );

}
