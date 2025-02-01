package net.scythmon.cygnus.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CRYSTAL_FLOWER = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.3f).build();

    public static final FoodProperties CRYSTAL_BERRIES = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.2f).fast().build();

    public static final FoodProperties BROWNIE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.3f).build();

    public static final FoodProperties COFFEE = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.3f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1f).build();

    public static final FoodProperties ONEH_MOTER = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.1f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.WITHER, 100, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1f).build();
}
