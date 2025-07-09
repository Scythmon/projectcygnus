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
import net.scythmon.cygnus.init.ModEffects;

public class A2TheHighPreistess extends Item {
    public A2TheHighPreistess(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide()) {
            if (!pPlayer.isDeadOrDying()) {
                pPlayer.addEffect(new MobEffectInstance(ModEffects.DEATH_REFUTED.get(), 200, 0), pPlayer);
                pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 1.0F, 1.0F);
                mainHand.shrink(1);
                if (!pPlayer.isCreative())
                    pPlayer.getCooldowns().addCooldown(mainHand.getItem(), (int) Math.round(600 * 20));
            }
        }
        return InteractionResultHolder.success(mainHand);
    }
}
