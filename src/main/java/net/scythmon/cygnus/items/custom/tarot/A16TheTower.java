package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class A16TheTower extends Item {
    public A16TheTower(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide() && pLevel instanceof ServerLevel serverLevel) {

            boolean originallyInvulnerable = pPlayer.isInvulnerable();
            pPlayer.setInvulnerable(true);

            serverLevel.explode(
                    pPlayer,
                    pPlayer.getX(),
                    pPlayer.getY(),
                    pPlayer.getZ(),
                    5.0F,
                    false, // Setting to true will trigger fire to be placed
                    Level.ExplosionInteraction.NONE // Prevents terrain damage
            );

            pPlayer.setInvulnerable(originallyInvulnerable);


            return InteractionResultHolder.success(mainHand);
        }

        return InteractionResultHolder.sidedSuccess(mainHand, pLevel.isClientSide());
    }
}
