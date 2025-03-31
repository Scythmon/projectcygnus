package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.scythmon.cygnus.init.ModEffects;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class A10WheelOfFortune extends Item {
    public A10WheelOfFortune(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getMainHandItem();
        if (!pLevel.isClientSide()) {
            spawnEffectCloud(pLevel, pPlayer);
            mainHand.shrink(1);
        }
        return InteractionResultHolder.success(mainHand);
    }

    private void spawnEffectCloud(Level level, Player player) {
        Random random = new Random();
        MobEffect randomEffect = MobEffect.byId(random.nextInt(ForgeRegistries.MOB_EFFECTS.getValues().size()));
        AreaEffectCloud cloud = new AreaEffectCloud(level, player.getX(), player.getY(), player.getZ());
        cloud.setRadius(2.5F);
        cloud.setRadiusOnUse(-0.5F);
        cloud.setWaitTime(10);
        cloud.setDuration(600);
        cloud.addEffect(new MobEffectInstance(randomEffect, 300, 2));
        level.addFreshEntity(cloud);
    }
}
