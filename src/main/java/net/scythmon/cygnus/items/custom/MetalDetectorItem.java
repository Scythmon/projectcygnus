package net.scythmon.cygnus.items.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.scythmon.cygnus.init.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext Context) {
        if(!Context.getLevel().isClientSide()) {
            BlockPos postionClicked = Context.getClickedPos();
            Player player = Context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= postionClicked.getY() + 64; i++) {
                BlockState state = Context.getLevel().getBlockState(postionClicked.below(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(postionClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("No valuables found!"));
            }
        }

        Context.getItemInHand().hurtAndBreak(1, Context.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.projectcygnus.metal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " +blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {

        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }

}
