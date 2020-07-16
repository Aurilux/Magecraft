package com.lich.magecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class CrystalCapacitorBlock extends Block {

    public CrystalCapacitorBlock() {
        super(Properties.create(Material.GLASS, MaterialColor.PURPLE).hardnessAndResistance(0.8F).sound(SoundType.GLASS));
    }

}
