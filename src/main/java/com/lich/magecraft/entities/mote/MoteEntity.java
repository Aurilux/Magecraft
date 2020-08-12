package com.lich.magecraft.entities.mote;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MoteEntity extends MobEntity
{
    private static DataParameter<Integer> MOTE_POWER = EntityDataManager.createKey(MoteEntity.class, DataSerializers.VARINT); // mote generation rate
    private int maxPower;
    private int minPower;

    public MoteEntity(EntityType<MoteEntity> type, World worldIn) {
        super(type, worldIn);
        this.dataManager.set(MOTE_POWER, generateMotePower());
        // Mote size should correspond to the randomly generated mote power
    }

    public static AttributeModifierMap.MutableAttribute healthAttribute() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 4.0D).func_233815_a_(Attributes.field_233821_d_, 0.25D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    @Override
    protected void registerData() {
        super.registerData();

        this.getDataManager().register(MOTE_POWER, 0);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        if (compound.contains("MotePower", 3)) {
            this.setMotePower(compound.getInt("MotePower"));
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);

        compound.putInt("MotePower", getMotePower());
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    private int generateMotePower() {
        maxPower = 1000;
        minPower = 50;
        return (int) (Math.random() * ((maxPower - minPower) + 1)) + minPower;
    }

    public int getMotePower() {
        return this.dataManager.get(MOTE_POWER);
    }

    public void setMotePower(int value) {
        this.dataManager.set(MOTE_POWER, value);
    }

    public float getMoteSize() {
        int mote_power = getMotePower();
        return (mote_power-minPower)/((float) maxPower-minPower)*5+1;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        return super.isInRangeToRenderDist(distance);
    }
}
