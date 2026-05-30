package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class A7TheChariot extends Item {
    public A7TheChariot(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide()) {
            if (!pPlayer.isDeadOrDying()) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 4), pPlayer);
                pPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2400, 4), pPlayer);
                pLevel.playSound(null, pPlayer.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
                mainHand.shrink(1);
            }
        }
        return InteractionResultHolder.success(mainHand);
    }
}
