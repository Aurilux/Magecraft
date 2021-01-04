package com.lich.magecraft.common.util;

import com.lich.magecraft.common.Magecraft;
import net.minecraft.item.Item;

//constants
public class Constants {

    public static final Item.Properties ITEM_PROPS = new Item.Properties().group(Magecraft.TAB);
    public static final Item.Properties ITEM_PROPS_NONSTACK = new Item.Properties().group(Magecraft.TAB).maxStackSize(1);

}