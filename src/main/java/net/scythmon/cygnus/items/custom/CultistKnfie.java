package net.scythmon.cygnus.items.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


import net.scythmon.cygnus.init.ModItems;

public class CultistKnfie extends Item {
    public CultistKnfie(Properties pProperties) {super(pProperties);}

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getMainHandItem();
        ItemStack offhand = pPlayer.getOffhandItem();
        if(!pLevel.isClientSide()) {
            if (!mainHand.isEmpty() && mainHand.is(ModItems.CULTIST_KNIFE.get()) && !offhand.isEmpty() && offhand.is(Items.GLASS_BOTTLE)) {
                if (!pPlayer.isCreative()) {
                    pPlayer.hurt(pPlayer.damageSources().fellOutOfWorld(), 2);
                }
                pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                offhand.shrink(1);
                pPlayer.addItem(new ItemStack(ModItems.BOTTLED_BLOOD.get()));
            }
        }
        pPlayer.getMainHandItem().hurtAndBreak(1, pPlayer, player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResultHolder.success(mainHand);
    }
}
