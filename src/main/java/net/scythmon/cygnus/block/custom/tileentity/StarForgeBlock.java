package net.scythmon.cygnus.block.custom.tileentity;


import com.blakebr0.cucumber.block.BaseTileEntityBlock;
import com.blakebr0.cucumber.helper.StackHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.scythmon.cygnus.init.ModBlockEntities;
import net.scythmon.cygnus.init.ModItems;
import net.scythmon.cygnus.tileentity.StarForgeAltarEntity;

import java.awt.*;

public class StarForgeBlock extends BaseTileEntityBlock {
    public static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16, 14);
    public static final BooleanProperty CRAFTING = BooleanProperty.create("crafting");
    public StarForgeBlock() {
        super(SoundType.STONE, 10.0F, 12.0F, true);
        this.registerDefaultState(this.stateDefinition.any().setValue(CRAFTING, false));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StarForgeAltarEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        var tile = level.getBlockEntity(pos);

        if (tile instanceof StarForgeAltarEntity altar) {
            var inventory = altar.getInventory();
            var catalyst = inventory.getStackInSlot(0); // Slot 0
            var held = player.getItemInHand(hand);

            if (held.is(ModItems.STARFLAME.get())) {
                if (catalyst.isEmpty()) {
                    return InteractionResult.PASS;
                }
                altar.attemptCraft();
                return InteractionResult.SUCCESS;
            }

            if (catalyst.isEmpty() && !held.isEmpty()) {
                inventory.setStackInSlot(0, StackHelper.withSize(held, 1, false));
                player.setItemInHand(hand, StackHelper.shrink(held, 1, false));
                level.playSound(null, player.blockPosition(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 1.0f, 1.0f);
                return InteractionResult.SUCCESS;
            }

            else if (!catalyst.isEmpty()) {
                var item = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), catalyst.copy());
                item.setNoPickUpDelay();
                level.addFreshEntity(item);
                inventory.setStackInSlot(0, ItemStack.EMPTY);
                level.playSound(player, pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            var tile = world.getBlockEntity(pos);

            if (tile instanceof StarForgeAltarEntity altar) {
                var inventory = altar.getInventory();
                var stack = inventory.getStackInSlot(0);

                if (!stack.isEmpty()) {
                    net.minecraft.world.SimpleContainer tempContainer = new net.minecraft.world.SimpleContainer(stack);
                    Containers.dropContents(world, pos, tempContainer);
                }
            }
        }

        super.onRemove(state, world, pos, newState, isMoving);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CRAFTING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos post, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTicker(type, ModBlockEntities.STAR_FORGE_BE.get(), StarForgeAltarEntity::tick);
    }
}
