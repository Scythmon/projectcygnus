package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class A19TheSun extends Item {
    public A19TheSun(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide() && pLevel instanceof ServerLevel) {

            for (int i = 0; i < pPlayer.getInventory().getContainerSize(); i++) {
                ItemStack stack = pPlayer.getInventory().getItem(i);

                if (!stack.isEmpty()) {
                    pPlayer.getCooldowns().removeCooldown(stack.getItem());
                }
            }

            pLevel.playSound(null, pPlayer.blockPosition(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 1.0f, 1.0f);

            if (!pPlayer.isCreative()) {
                pPlayer.getCooldowns().addCooldown(this, 72000);
            }
            return InteractionResultHolder.success(mainHand);
        }

        return InteractionResultHolder.sidedSuccess(mainHand, pLevel.isClientSide());
    }
}
