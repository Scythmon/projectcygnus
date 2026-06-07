package net.scythmon.cygnus.util;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.util.recipies.AltarRecipe;

import java.util.function.Supplier;

public class ModRecipiesSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ProjectCygnus.MOD_ID);

    public static final RegistryObject<RecipeSerializer<AltarRecipe>> ALTAR_SERIALIZER =
            RECIPE_SERIALIZERS.register("altar_crafting", () -> AltarRecipe.Serializer.INSTANCE);



    private static RegistryObject<RecipeSerializer<?>> register(String name, Supplier<RecipeSerializer<?>> serializer) {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }

    public static void register(IEventBus modEventBus) {
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
