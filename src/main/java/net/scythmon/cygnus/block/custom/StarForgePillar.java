package net.scythmon.cygnus.block.custom;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import net.scythmon.cygnus.block.entity.StarForgePillarEntity;

import java.util.List;
import java.util.UUID;

import static net.minecraft.world.InteractionHand.MAIN_HAND;
import static net.minecraft.world.phys.shapes.BooleanOp.OR;

public class StarForgePillar extends Block implements EntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty IS_REVERSE = BooleanProperty.create("is_reverse");
    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 15, 12);

//    public static final TagKey<Item> SWORDS = ItemTags.create(new ResourceLocation("itemdisplay:items"));

    public StarForgePillar(Properties properties) {
        super(properties.strength(10.0f, 1000.0f).noOcclusion());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(IS_REVERSE, Boolean.FALSE));
    }

    public static Item getItem(String name) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(name));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getCollisionShape(BlockState p_60572_, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        return SHAPE;
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof StarForgePillarEntity) {
            blockEntity.setChanged();
            world.setBlockEntity(blockEntity);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity te = world.getBlockEntity(pos);
        if (!world.isClientSide() && te instanceof StarForgePillarEntity displayTile) {
            GameProfile profile = player.getGameProfile();
            UUID playerUUID = profile.getId();
            if (player.isShiftKeyDown()) {
                if (player.getUsedItemHand() == MAIN_HAND && player.getMainHandItem().isEmpty()) {
                    ItemStack toDrop = displayTile.getItem().copy();
                    toDrop .setCount(1);
                    displayTile.setDisplayItem(ItemStack.EMPTY);
                    player.drop(toDrop, false);
                }
            } else {
                ItemStack stack = player.getItemInHand(hand);

//                boolean isInGroup = stack.is(SWORDS); // Checks if the ItemStack is in the specified Tag Group, bypasses SwordItem requirement.

                boolean isItem = stack.getItem() instanceof Item /*|| isInGroup*/;

                if (hand == MAIN_HAND) {
                    boolean isDisplayEmpty = displayTile.getItem().isEmpty();
                    if (isDisplayEmpty && isItem) {
                        ItemStack copy = stack.copy();
                        displayTile.setDisplayItem(copy);
                        stack.shrink(1);
                        return InteractionResult.SUCCESS;
                    }
                    if (!isDisplayEmpty && stack.isEmpty()) {
                        world.setBlock(pos, state.setValue(IS_REVERSE, !state.getValue(IS_REVERSE)), 3);
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    public boolean anyMatch(ItemStack stack, List<Item> items) {
        return items.stream().anyMatch(item -> stack.getItem() == item);
    }

    //    @Override
    //    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
    //        ItemStack itemstack = super.getCloneItemStack(state, target, world, pos, player);
    //        ItemDisplayTile tileTrophy = (ItemDisplayTile) world.getBlockEntity(pos);
    //        CompoundTag nbttagcompound = tileTrophy.saveAdditional(new CompoundTag());
    //        tile.setChanged();
    //        if (!nbttagcompound.isEmpty()) {
    //            itemstack.setTagInfo("BlockEntityTag", nbttagcompound);
    //        }
    //        return itemstack;
    //    }
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return super.getCloneItemStack(state, target, world, pos, player);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof StarForgePillarEntity) {
                ItemStack item = ((StarForgePillarEntity) tileentity).getItem().copy();
                item.setCount(1);
                Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        BlockEntity te = world.getBlockEntity(pos);
        if (!world.isClientSide() && te instanceof StarForgePillarEntity displayTile) {
            ItemStack stack = displayTile.getItem();
            if (!stack.isEmpty()) return calculateOutput(stack);
        }
        return 0;
    }

    private int calculateOutput(ItemStack stack) {
        if (stack.isDamaged()) {
            int x = stack.getMaxDamage() / (stack.getMaxDamage() - stack.getDamageValue());
            x = x > 15 ? 14 : x == 15 ? 13 : x;
            return 15 / x;
        }
        return 15;
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StarForgePillarEntity(pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.getStateDefinition()
                .any()
                .setValue(FACING, context.getHorizontalDirection())
                .setValue(IS_REVERSE, Boolean.FALSE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        return facing.getAxis()
                .isHorizontal() ? stateIn : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return super.mirror(state, mirrorIn);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, IS_REVERSE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return 1;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter world, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }
}
