package net.scythmon.cygnus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StarForgePillar extends Block {
    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 10, 12);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public StarForgePillar(Properties pProperties) {
        super(pProperties);
    }
}
