package com.lich.magecraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class AzureQuartzOre extends Block {

    public AzureQuartzOre() {
        super(AbstractBlock.Properties.create(Material.ROCK)
                .func_235861_h_()
                .hardnessAndResistance(3.0F, 3.0F));
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return 1;
    }
}

