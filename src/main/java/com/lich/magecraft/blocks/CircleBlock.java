package com.lich.magecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class CircleBlock extends Block {

    private static final Float hardness = 0.5F;
    private static final Float resistance = 6.0F;
    protected static final VoxelShape shape = (Block.makeCuboidShape(0.0D, 0.00D, 0.0D, 16.0D, 1.0D, 16.0D));


    public CircleBlock() {
        super(Properties.create(Material.CAKE).hardnessAndResistance(hardness, resistance).sound(SoundType.CLOTH).notSolid());
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shape;
    }

}
