package com.lich.magecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class StrippedElderLogBlock extends Block {

    private static Float hardness   = 3.0F;
    private static Float resistance = 6.0F;

    public StrippedElderLogBlock()
    {
        super(Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(hardness, resistance).sound(SoundType.WOOD));
        this.setDefaultState(this.stateContainer.getBaseState());
    }
}
