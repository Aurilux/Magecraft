package com.lich.magecraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ManaAccumulator extends Block {

    // tweak this
    private static final Float hardness = 3.0F;
    private static final Float resistance = 3.0F;

    public ManaAccumulator() {
        super(AbstractBlock.Properties.create(Material.WOOD)
                .hardnessAndResistance(hardness, resistance)
                .sound(SoundType.WOOD));
    }
}
