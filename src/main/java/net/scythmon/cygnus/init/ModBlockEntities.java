package net.scythmon.cygnus.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.tileentity.StarForgeAltarEntity;
import net.scythmon.cygnus.tileentity.StarForgeBlockEntity;
import net.scythmon.cygnus.tileentity.StarForgePillarEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ProjectCygnus.MOD_ID);

    public static final RegistryObject<BlockEntityType<StarForgeAltarEntity>> STAR_FORGE_BE =
            BLOCK_ENTITIES.register("star_forge_be",
                    () -> BlockEntityType.Builder.of(StarForgeAltarEntity::new,
                            ModBlocks.STAR_FORGE.get()).build(null));

    public static final RegistryObject<BlockEntityType<StarForgePillarEntity>> STAR_FORGE_PILLAR_BE = BLOCK_ENTITIES
            .register("star_forge_pillar_be",
                    () -> BlockEntityType.Builder.of(StarForgePillarEntity::new, ModBlocks.STAR_FORGE_PILLAR.get())
                            .build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
