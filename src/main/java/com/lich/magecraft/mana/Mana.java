package com.lich.magecraft.mana;


public class Mana implements IMana {
    private int maxMana = 50000;
    private int mana = maxMana;

    public float manaAcceleration = 100; // 100 centi-mana per second
    public float manaPenaltyDuration;

    public void addMana(int points) {
        this.mana = this.mana + points;
    }

    public void useMana(int points) {
        this.mana = this.mana - points;
    }

    public void setMana(int manaLevel) {
        this.mana = manaLevel;
    }

    public int getMana() {
        return mana;
    }

    public void setMaxMana(int manaLevel) {
        this.maxMana = manaLevel;
    }

    public int getMaxMana() {
        return maxMana;
    }


}