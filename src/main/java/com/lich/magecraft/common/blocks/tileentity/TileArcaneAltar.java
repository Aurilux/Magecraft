package com.lich.magecraft.common.blocks.tileentity;

import com.lich.magecraft.common.init.ModTiles;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileArcaneAltar extends TileEntity implements ITickableTileEntity {
    private final String MANA = "mana";
    private int mana;

    public TileArcaneAltar() {
        super(ModTiles.ARCANE_ALTAR_TILE.get());
        mana = 0;
    }

    @Override
    public void tick() {
        if (!world.isRemote && mana < 1000) {
            mana++;
        }
    }

    public int getMana() {
        return mana;
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        CompoundNBT comp = super.write(tag);
        comp.putInt(MANA, mana);
        return comp;
    }

    @Override
    public void read(BlockState state, CompoundNBT tag) {
        super.read(state, tag);
        mana = tag.getInt(MANA);
    }
}