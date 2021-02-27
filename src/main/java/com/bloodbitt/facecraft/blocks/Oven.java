package com.bloodbitt.facecraft.blocks;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Oven extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 1, 15, 15, 15, 16),
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 15, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 1, 0, 16, 5, 1),
            Block.makeCuboidShape(0, 12, 0, 16, 15, 1),
            Block.makeCuboidShape(0, 5, 0, 1, 12, 1),
            Block.makeCuboidShape(15, 5, 0, 16, 12, 1),
            Block.makeCuboidShape(0, 1, 1, 1, 15, 16),
            Block.makeCuboidShape(15, 1, 1, 16, 15, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 1, 1, 1, 15, 15),
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 15, 0, 16, 16, 16),
            Block.makeCuboidShape(15, 1, 0, 16, 5, 16),
            Block.makeCuboidShape(15, 12, 0, 16, 15, 16),
            Block.makeCuboidShape(15, 5, 0, 16, 12, 1),
            Block.makeCuboidShape(15, 5, 15, 16, 12, 16),
            Block.makeCuboidShape(0, 1, 0, 15, 15, 1),
            Block.makeCuboidShape(0, 1, 15, 15, 15, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1, 1, 0, 15, 15, 1),
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 15, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 1, 15, 16, 5, 16),
            Block.makeCuboidShape(0, 12, 15, 16, 15, 16),
            Block.makeCuboidShape(15, 5, 15, 16, 12, 16),
            Block.makeCuboidShape(0, 5, 15, 1, 12, 16),
            Block.makeCuboidShape(15, 1, 0, 16, 15, 15),
            Block.makeCuboidShape(0, 1, 0, 1, 15, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(15, 1, 1, 16, 15, 15),
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 15, 0, 16, 16, 16),
            Block.makeCuboidShape(0, 1, 0, 1, 5, 16),
            Block.makeCuboidShape(0, 12, 0, 1, 15, 16),
            Block.makeCuboidShape(0, 5, 15, 1, 12, 16),
            Block.makeCuboidShape(0, 5, 0, 1, 12, 1),
            Block.makeCuboidShape(1, 1, 15, 16, 15, 16),
            Block.makeCuboidShape(1, 1, 0, 16, 15, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Oven() {
        super(AbstractBlock.Properties.create(Material.ANVIL)
        .hardnessAndResistance(5.0f, 6.0f)
        .harvestLevel(0)
        .harvestTool(ToolType.PICKAXE)
        .sound(SoundType.ANVIL));
    }

    @Override
    @Nonnull
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    @Nonnull
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    @Nonnull
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
