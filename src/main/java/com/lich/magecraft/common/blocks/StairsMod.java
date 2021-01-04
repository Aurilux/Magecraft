package com.lich.magecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;

public class StairsMod extends StairsBlock {

    public StairsMod(Block block) {
        super(block.getDefaultState(), Block.Properties.from(block));

    }
}
