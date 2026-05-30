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

public class A4TheEmperor extends Item {
    public A4TheEmperor(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainhand = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide()){


            pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 900, 2));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 2));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1));


            pPlayer.addEffect(new MobEffectInstance(ModEffects.EXHAUSTION.get(), 900, 0, false, false, false));

            pLevel.playSound(null, pPlayer.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
            mainhand.shrink(1);

            pPlayer.getCooldowns().addCooldown(this, 900);
            return InteractionResultHolder.success(mainhand);
        }else{
            return  InteractionResultHolder.fail(mainhand);
        }
    }
}
