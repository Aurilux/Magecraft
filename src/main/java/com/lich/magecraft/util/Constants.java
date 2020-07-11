package com.lich.magecraft.util;

import com.lich.magecraft.Magecraft;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

//constants
public class Constants {

    public static final Item.Properties ITEM_PROPS = new Item.Properties().group(Magecraft.TAB);
    public static final Item.Properties ITEM_PROPS_NONSTACK = new Item.Properties().group(Magecraft.TAB).maxStackSize(1);
}