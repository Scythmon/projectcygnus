package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class A11Justice extends Item {
    public A11Justice(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        Integer armor = pPlayer.getArmorValue();
        if (!pLevel.isClientSide()){
            if (armor <= 4) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 4), pPlayer);
            }
            if (armor <= 8 && armor > 4) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 3), pPlayer);
            }
            if (armor <= 12 && armor > 8) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2), pPlayer);
            }
            if (armor <= 16 && armor > 12) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1), pPlayer);
            }
            if (armor > 16) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), pPlayer);
            }
            stack.shrink(1);
            if (!pPlayer.isCreative())
                pPlayer.getCooldowns().addCooldown(stack.getItem(), Math.round(60 * 20));
        }
        return InteractionResultHolder.success(stack);
        }
    }
