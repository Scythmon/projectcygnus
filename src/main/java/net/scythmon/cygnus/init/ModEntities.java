package net.scythmon.cygnus.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.entity.WitherMaskBoss;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ProjectCygnus.MOD_ID);

    public static final RegistryObject<EntityType<WitherMaskBoss>> WITHERMASK =
            ENTITY_TYPES.register("withermask",
                    () -> EntityType.Builder.of(WitherMaskBoss::new, MobCategory.CREATURE)
                            .sized(3.0f, 8.0f)
                            .build(new ResourceLocation(ProjectCygnus.MOD_ID, "withermask").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
