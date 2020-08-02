package com.lich.magecraft.mana;

import net.minecraft.nbt.*;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class ManaStorage implements Capability.IStorage<IMana> {

    @Override
    public INBT writeNBT(Capability<IMana> capability, IMana instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("mana", instance.getMana());
        tag.putInt("maxMana", instance.getMaxMana());
        return tag;
    }

    @Override
    public void readNBT(Capability<IMana> capability, IMana instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setMana(tag.getInt("mana"));
        instance.setMaxMana(tag.getInt("maxMana"));
    }
}
