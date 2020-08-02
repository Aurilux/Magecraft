package com.lich.magecraft.mana;

public interface IMana {

    public void setMana(int points);
    public void addMana(int points);
    public void useMana(int points);
    public void setMaxMana(int points);


    public int getMana();
    public int getMaxMana();

}
