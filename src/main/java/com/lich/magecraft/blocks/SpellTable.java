package com.lich.magecraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class SpellTable extends Block {

    // tweak this
    private static final Float hardness = 3.0F;
    private static final Float resistance = 3.0F;

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(1, 16, 3, 3, 18, 13),
            Block.makeCuboidShape(13, 16, 3, 15, 18, 13),
            Block.makeCuboidShape(3, 16, 3, 13, 16.5, 13),
            Block.makeCuboidShape(1.5, 16.5, 2.5, 2.5, 17.5, 13.5),
            Block.makeCuboidShape(13.5, 16.5, 2.5, 14.5, 17.5, 13.5),
            Block.makeCuboidShape(0, 0, 0, 4, 10, 4),
            Block.makeCuboidShape(12, 0, 12, 16, 10, 16),
            Block.makeCuboidShape(12, 0, 0, 16, 10, 4),
            Block.makeCuboidShape(0, 0, 12, 4, 10, 16),
            Block.makeCuboidShape(0, 10, 0, 16, 16, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public SpellTable() {
        super(AbstractBlock.Properties.create(Material.WOOD)
                .hardnessAndResistance(hardness, resistance)
                .sound(SoundType.WOOD)
                .harvestLevel(0));
    }
}
