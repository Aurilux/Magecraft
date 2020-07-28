package com.lich.magecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ElderBookshelfBlock extends Block {

    public ElderBookshelfBlock() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(0.5F)
                .sound(SoundType.WOOD));
    }



}
