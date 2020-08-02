package com.lich.magecraft.mana;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ManaProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(IMana.class)
    public static final Capability<IMana> MANA_CAPABILITY = null;

    private LazyOptional<IMana> instance = LazyOptional.of(MANA_CAPABILITY::getDefaultInstance);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == MANA_CAPABILITY ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        // @formatter:off
        return MANA_CAPABILITY.getStorage().writeNBT(MANA_CAPABILITY, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null);
        // @formatter:on
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        // @formatter:off
        MANA_CAPABILITY.getStorage().readNBT(MANA_CAPABILITY, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null, nbt);
        // @formatter:on
    }

}