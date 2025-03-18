package net.scythmon.cygnus.items.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


import net.scythmon.cygnus.init.ModItems;

public class CultistKnfie extends Item {
    public CultistKnfie(Properties pProperties) {super(pProperties);}

    public InteractionResult useOn(UseOnContext Context) {
        if(!Context.getLevel().isClientSide()) {
            Player player = Context.getPlayer();
            ItemStack mainHand = Context.getItemInHand();
            ItemStack offhand = player.getOffhandItem();
            Level pLevel = Context.getLevel();
            if (!mainHand.isEmpty() && mainHand.is(ModItems.CULTIST_KNIFE.get()) && !offhand.isEmpty() && offhand.is(Items.GLASS_BOTTLE)) {
                player.hurt(player.damageSources().fellOutOfWorld(), 2);
                pLevel.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                offhand.shrink(1);
                player.addItem(new ItemStack(ModItems.BOTTLED_BLOOD.get()));
            }
        }

        Context.getItemInHand().hurtAndBreak(1, Context.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }
}
