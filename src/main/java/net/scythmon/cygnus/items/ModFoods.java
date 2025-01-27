package net.scythmon.cygnus.items;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CRYSTAL_FLOWER = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.3f).build();

    public static final FoodProperties CRYSTAL_BERRIES = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.2f).fast().build();

    public static final FoodProperties BROWNIE = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.3f).build();
}
