package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.scythmon.cygnus.init.ModEffects;

public class A3TheEmpress extends Item {
    public A3TheEmpress(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide()) {
            boolean appleshrink = false;
            for (int i = 0; i < pPlayer.getInventory().getContainerSize(); i++) {
                ItemStack itemStack = pPlayer.getInventory().getItem(i);
                if (!itemStack.isEmpty() && itemStack.is(Items.APPLE)) {
                    itemStack.shrink(1);
                    appleshrink = true;
                    break;
                }
            }

                if (appleshrink) {
                    ItemStack gap = new ItemStack(Items.GOLDEN_APPLE);
                    if (pPlayer.getInventory().add(gap)) {
                        pPlayer.drop(gap, false);
                    }
                    pLevel.playSound(null, pPlayer.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);

                    mainHand.shrink(1);
                    return InteractionResultHolder.success(mainHand);
                } else {
                    return InteractionResultHolder.fail(mainHand);
                }
        }
        return InteractionResultHolder.sidedSuccess(mainHand, pLevel.isClientSide());
    }
}
