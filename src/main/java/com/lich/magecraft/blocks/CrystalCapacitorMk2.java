package com.lich.magecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class CrystalCapacitorMk2 extends Block {

    public CrystalCapacitorMk2() {
        super(Properties.create(Material.GLASS)
                .hardnessAndResistance(0.8F)
                .sound(SoundType.GLASS));
    }

}
