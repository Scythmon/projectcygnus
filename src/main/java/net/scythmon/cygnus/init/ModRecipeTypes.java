package net.scythmon.cygnus.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.util.IAltarRecipe;

import java.util.function.Supplier;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> REGISTRY = DeferredRegister.create(Registries.RECIPE_TYPE, ProjectCygnus.MOD_ID);

    public static final RegistryObject<RecipeType<IAltarRecipe>> STAR_FORGING = register("altar_craft", () ->
            RecipeType.simple(new ResourceLocation(ProjectCygnus.MOD_ID, "altar_craft")));

    private static <T extends Recipe<Container>> RegistryObject<RecipeType<T>> register(String name, Supplier<RecipeType<T>> type) {
        return REGISTRY.register(name, type);
    }

    public static void register(IEventBus modEventBus) {
        REGISTRY.register(modEventBus);
    }
}
