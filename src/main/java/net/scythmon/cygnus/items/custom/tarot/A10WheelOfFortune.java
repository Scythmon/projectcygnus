package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.scythmon.cygnus.util.PotionCloudManager;

import java.util.Map;
import java.util.Random;

public class A10WheelOfFortune extends Item {
    public A10WheelOfFortune(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getMainHandItem();
        if (!pLevel.isClientSide()) {
            spawnRandomLingeringPotion(pLevel, pPlayer);
        }
        return InteractionResultHolder.success(mainHand);
    }
    private void spawnRandomLingeringPotion(Level world, Player player) {
        Map<AreaEffectCloud, Integer> potionCloudMap = PotionCloudManager.getAllPotionClouds();

        if (!potionCloudMap.isEmpty()) {
            Random rand = new Random();
            AreaEffectCloud randomCloud = (AreaEffectCloud) potionCloudMap.keySet().toArray()[rand.nextInt(potionCloudMap.size())];

            if (randomCloud != null) {
                spawnLingeringPotion(world, player, randomCloud);
            }
        }
    }

    private void spawnLingeringPotion(Level world, Player player, AreaEffectCloud cloud) {
        Potion potion = cloud.getPotion();
        ItemStack potionStack = new ItemStack(Items.POTION); // Default potion
        PotionUtils.setPotion(potionStack, potion);
        ThrownPotion thrownPotion = new ThrownPotion(world, player);
        thrownPotion.setItem(potionStack);
        world.addFreshEntity(thrownPotion);
    }
}
