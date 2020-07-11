package com.lich.magecraft.blocks;

import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class StrippedElderLogBlock extends LogBlock {

    private static Float hardness   = 3.0F;
    private static Float resistance = 6.0F;

    public StrippedElderLogBlock()
    {
        super(MaterialColor.WOOD, Properties.create(Material.WOOD).hardnessAndResistance(hardness, resistance).sound(SoundType.WOOD));
        this.setDefaultState(this.stateContainer.getBaseState());
    }
}
