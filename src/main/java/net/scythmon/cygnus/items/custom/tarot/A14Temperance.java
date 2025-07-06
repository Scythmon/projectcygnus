package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class A14Temperance extends Item {
    public A14Temperance(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide()) {
            giveEffect(pPlayer);
            mainHand.shrink(1);
        }
        return InteractionResultHolder.success(mainHand);
    }

    private void giveEffect(Player pPlayer) {
        pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 1, true, true, true));

        pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0, true, true, true));

        pPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 500, 2, true, true, true));
    }
}
