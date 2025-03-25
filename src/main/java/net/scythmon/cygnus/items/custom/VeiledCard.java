package net.scythmon.cygnus.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.scythmon.cygnus.init.ModItems;

import java.util.concurrent.ThreadLocalRandom;

public class VeiledCard extends Item {
    public VeiledCard(Properties pProperties) {super(pProperties);}

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        int tarotNumber = ThreadLocalRandom.current().nextInt(1, 110);
        ItemStack mainHand = pPlayer.getMainHandItem();
        if (!pLevel.isClientSide()) {
            if (tarotNumber >= 1 && tarotNumber <= 5) {
                pPlayer.addItem(new ItemStack(ModItems.THE_FOOL.get()));
            }
            if (tarotNumber >= 6 && tarotNumber <= 10) {
                pPlayer.addItem(new ItemStack(ModItems.THE_MAGICIAN.get()));
            }
            if (tarotNumber >= 11 && tarotNumber <= 15) {
                pPlayer.addItem(new ItemStack(ModItems.THE_HIGH_PRIESTESS.get()));
            }
            if (tarotNumber >= 16 && tarotNumber <= 20) {
                pPlayer.addItem(new ItemStack(ModItems.THE_EMPRESS.get()));
            }
            if (tarotNumber >= 21 && tarotNumber <= 25) {
                pPlayer.addItem(new ItemStack(ModItems.THE_EMPEROR.get()));
            }
            if (tarotNumber >= 26 && tarotNumber <= 30) {
                pPlayer.addItem(new ItemStack(ModItems.THE_HIEROPHANT.get()));
            }
            if (tarotNumber >= 31 && tarotNumber <= 35) {
                pPlayer.addItem(new ItemStack(ModItems.THE_LOVERS.get()));
            }
            if (tarotNumber >= 36 && tarotNumber <= 40) {
                pPlayer.addItem(new ItemStack(ModItems.THE_CHARIOT.get()));
            }
            if (tarotNumber >= 41 && tarotNumber <= 45) {
                pPlayer.addItem(new ItemStack(ModItems.STRENGTH.get()));
            }
            if (tarotNumber >= 46 && tarotNumber <= 50) {
                pPlayer.addItem(new ItemStack(ModItems.THE_HERMIT.get()));
            }
            if (tarotNumber >= 51 && tarotNumber <= 55) {
                pPlayer.addItem(new ItemStack(ModItems.WHEEL_OF_FORTUNE.get()));
            }
            if (tarotNumber >= 56 && tarotNumber <= 60) {
                pPlayer.addItem(new ItemStack(ModItems.JUSTICE.get()));
            }
            if (tarotNumber >= 61 && tarotNumber <= 65) {
                pPlayer.addItem(new ItemStack(ModItems.THE_HANGED_MAN.get()));
            }
            if (tarotNumber >= 66 && tarotNumber <= 70) {
                pPlayer.addItem(new ItemStack(ModItems.DEATH.get()));
            }
            if (tarotNumber >= 71 && tarotNumber <= 75) {
                pPlayer.addItem(new ItemStack(ModItems.TEMPERANCE.get()));
            }
            if (tarotNumber >= 76 && tarotNumber <= 80) {
                pPlayer.addItem(new ItemStack(ModItems.THE_DEVIL.get()));
            }
            if (tarotNumber >= 81 && tarotNumber <= 85) {
                pPlayer.addItem(new ItemStack(ModItems.THE_TOWER.get()));
            }
            if (tarotNumber >= 86 && tarotNumber <= 90) {
                pPlayer.addItem(new ItemStack(ModItems.THE_STARS.get()));
            }
            if (tarotNumber >= 91 && tarotNumber <= 95) {
                pPlayer.addItem(new ItemStack(ModItems.THE_MOON.get()));
            }
            if (tarotNumber >= 96 && tarotNumber <= 100) {
                pPlayer.addItem(new ItemStack(ModItems.THE_SUN.get()));
            }
            if (tarotNumber >= 101 && tarotNumber <= 105) {
                pPlayer.addItem(new ItemStack(ModItems.JUDGEMENT.get()));
            }
            if (tarotNumber >= 106 && tarotNumber <= 110) {
                pPlayer.addItem(new ItemStack(ModItems.THE_WORLD.get()));
            }
            mainHand.shrink(1);
        }
        return InteractionResultHolder.success(mainHand);
    }
}
