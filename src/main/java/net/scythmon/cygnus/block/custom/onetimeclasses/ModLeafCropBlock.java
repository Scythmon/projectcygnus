package net.scythmon.cygnus.block.custom.onetimeclasses;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.scythmon.cygnus.block.custom.ModCropBlock;
import net.scythmon.cygnus.init.ModParticles;
import org.jetbrains.annotations.NotNull;

public class ModLeafCropBlock extends ModCropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;

    public ModLeafCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.block();
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return false;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.block();
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(this);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return true;
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (getAge(state) == getMaxAge()) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.0005f);
            world.setBlock(pos, this.getStateForAge(0),2);
            world.gameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Context.of(player, state));
            if(world instanceof ServerLevel) {
                for (ItemStack droppedStack : getDrops(state, (ServerLevel) world, pos, null)) {
                    popResourceFromFace(world, pos, hit.getDirection(), droppedStack);
                }
                return InteractionResult.CONSUME;
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE, DISTANCE);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getRawBrightness(pPos, 0) >+ 9 ) {
            int i = this.getAge(pState);
            if (i < this.getMaxAge()) {
                if (pRandom.nextInt(100) % 20 == 0) {
                    pLevel.setBlock(pPos, this.getStateForAge(i + 1), Block.UPDATE_CLIENTS);
                }
            }
        }
        if (pState.getValue(DISTANCE) == 7) {
            dropResources(pState, pLevel, pPos);
            pLevel.removeBlock(pPos, false);
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        pLevel.setBlock(pPos, updateDistanceFromLog(pState, pLevel, pPos), Block.UPDATE_ALL);
    }

    @Override
    public int getLightBlock(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return 1;
    }

    private static BlockState updateDistanceFromLog(BlockState pState, LevelAccessor world, BlockPos pos) {
        int distance =7;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        Direction[] directions = Direction.values();

        for (Direction direction : directions) {
            mutablePos.setWithOffset(pos, direction);
            distance = Math.min(distance, getDistanceFromLog(world.getBlockState(mutablePos)) + 1);
            if (distance == 1) {
                break;
            }
        }
        return pState.setValue(DISTANCE, distance);
    }

    public static int getDistanceFromLog(BlockState state) {
        if (state.is(BlockTags.LOGS)) {
            return 0;
        } else {
            return state.getBlock() instanceof ModLeafCropBlock || state.getBlock() instanceof LeavesBlock ? state.getValue(DISTANCE) : 7;
        }
    }
}
