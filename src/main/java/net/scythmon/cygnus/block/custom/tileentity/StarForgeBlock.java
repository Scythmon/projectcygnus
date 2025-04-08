package net.scythmon.cygnus.block.custom.tileentity;


import com.blakebr0.cucumber.helper.StackHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.scythmon.cygnus.init.ModBlockEntities;
import net.scythmon.cygnus.items.custom.FuelItem;
import net.scythmon.cygnus.tileentity.StarForgeAltarEntity;
import net.scythmon.cygnus.tileentity.StarForgeBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class StarForgeBlock extends BaseEntityBlock {
    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 15, 12);

    public StarForgeBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StarForgeAltarEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult) {
        var tile = level.getBlockEntity(pos);

        if (tile instanceof StarForgeAltarEntity altar) {
            var inventory = altar.getInventory();
            var input = inventory.getStackInSlot(0);
            var output = inventory.getStackInSlot(1);

            if (!output.isEmpty()) {
                var item = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), output);

                item.setNoPickUpDelay();
                level.addFreshEntity(item);
                inventory.setStackInSlot(1, ItemStack.EMPTY);
            } else {
                var held = player.getItemInHand(hand);
                if (input.isEmpty() && !held.isEmpty()) {
                    inventory.setStackInSlot(0, StackHelper.withSize(held, 1, false));
                    player.setItemInHand(hand, StackHelper.shrink(held, 1, false));
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
                } else if (!input.isEmpty()) {
                    if (held.getItem() instanceof FuelItem)
                        return InteractionResult.PASS;

                    var item = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), input);

                    item.setNoPickUpDelay();
                    level.addFreshEntity(item);
                    inventory.setStackInSlot(0, ItemStack.EMPTY);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            var tile = world.getBlockEntity(pos);

            if (tile instanceof StarForgeAltarEntity altar) {
                Containers.dropContents(world, pos, altar.getInventory().getStacks());
            }
        }

        super.onRemove(state, world, pos, newState, isMoving);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos post, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.STAR_FORGE_BE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }


}
