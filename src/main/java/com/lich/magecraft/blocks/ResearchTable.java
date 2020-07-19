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

public class ResearchTable extends Block {

    // tweak this
    private static final Float hardness = 3.0F;
    private static final Float resistance = 3.0F;

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(12, 0, 0, 16, 10, 4),
            Block.makeCuboidShape(12, 0, 12, 16, 10, 16),
            Block.makeCuboidShape(0, 0, 0, 4, 10, 4),
            Block.makeCuboidShape(0, 0, 12, 4, 10, 16),
            Block.makeCuboidShape(0, 10, 0, 16, 16, 16),
            Block.makeCuboidShape(7, 16, 4, 13, 18, 12),
            Block.makeCuboidShape(0, 16, 2, 8, 16, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public ResearchTable() {
        super(AbstractBlock.Properties.create(Material.WOOD)
                .hardnessAndResistance(hardness, resistance)
                .sound(SoundType.WOOD)
                .harvestLevel(0));
    }
}
