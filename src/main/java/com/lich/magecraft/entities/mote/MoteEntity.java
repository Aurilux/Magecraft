package com.lich.magecraft.entities.mote;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MoteEntity extends Entity {
    private static DataParameter<Integer> MOTE_POWER = EntityDataManager.createKey(MoteEntity.class, DataSerializers.VARINT); // mote generation rate

    public MoteEntity(EntityType<? extends Entity> type, World worldIn) {
        super(type, worldIn);
        this.dataManager.set(MOTE_POWER, getMotePower());
        // Mote size should correspond to the randomly generated mote power
    }

    @Override
    protected void registerData() {
        this.getDataManager().register(MOTE_POWER, 0);
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        if (compound.contains("MotePower", 3)) {
            this.setMotePower(compound.getInt("MotePower"));
        }
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putInt("MotePower", getMotePower());
    }

    private int generateMotePower() {
        int maxPower = 1000;
        int minPower = 50;
        return (int) (Math.random() * ((maxPower - minPower) + 1)) + minPower;
    }

    public int getMotePower() {
        return this.dataManager.get(MOTE_POWER);
    }

    public void setMotePower(int value) {
        this.dataManager.set(MOTE_POWER, value);
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        return super.isInRangeToRenderDist(distance);
    }

    public IPacket<?> createSpawnPacket() {
        return new SSpawnObjectPacket(this);
    }
}
