package com.lich.magecraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class ManaAccumulator extends Block {

    // tweak this
    private static final Float hardness = 3.0F;
    private static final Float resistance = 3.0F;

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(0, 8, 0, 16, 14, 16),
            Block.makeCuboidShape(1, 4, 1, 15, 8, 15),
            Block.makeCuboidShape(3, 14, 3, 13, 16, 5),
            Block.makeCuboidShape(3, 14, 11, 13, 16, 13),
            Block.makeCuboidShape(3, 14, 5, 5, 16, 11),
            Block.makeCuboidShape(11, 14, 5, 13, 16, 11),
            Block.makeCuboidShape(5, 14, 5, 11, 15, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public ManaAccumulator() {
        super(AbstractBlock.Properties.create(Material.WOOD)
                .hardnessAndResistance(hardness, resistance)
                .sound(SoundType.WOOD));
    }
}
