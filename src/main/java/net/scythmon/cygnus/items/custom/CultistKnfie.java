package net.scythmon.cygnus.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockState;
import net.scythmon.cygnus.init.ModItems;

public class CultistKnfie extends Item {
    public CultistKnfie(Properties pProperties) {super(pProperties);}

    public InteractionResult useOn(UseOnContext Context) {
        if(!Context.getLevel().isClientSide()) {
            BlockPos postionClicked = Context.getClickedPos();
            Player player = Context.getPlayer();

        }

        Context.getItemInHand().hurtAndBreak(1, Context.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }
}
