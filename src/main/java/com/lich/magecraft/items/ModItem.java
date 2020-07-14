package com.lich.magecraft.items;

import com.lich.magecraft.Magecraft;
import com.lich.magecraft.blocks.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import com.lich.magecraft.util.Constants;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("magecraft")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItem {

    // For icon purposes
    @ObjectHolder("crystal_ash")
    public static Item CRYSTAL_ASH;


    //register items here
    @SubscribeEvent
    public static void init(RegistryEvent.Register<Item> event)
    {
        simpleItemFactory("crystal_ash", event);

        //block items
        blockItemFactory (ModBlock.ELDER_LOG,Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.STRIPPED_ELDER_LOG,Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.ELDER_PLANKS,Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.ELDER_SLAB,Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.ELDER_STAIRS, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.ELDER_FENCE, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.ELDER_DOOR, Constants.ITEM_PROPS,event);
    }

    //define item factories here

    //for simple items like materials
    public static void simpleItemFactory(String registryName, RegistryEvent.Register<Item> event)
    {
        Item item = new Item(Constants.ITEM_PROPS);
        item.setRegistryName(Magecraft.MOD_ID, registryName);
        event.getRegistry().register(item);
    }

    //to make new items that are not simple items
    public static void registerItem(String registryName, Item item, RegistryEvent.Register<Item> event)
    {
        item.setRegistryName(Magecraft.MOD_ID, registryName);
        event.getRegistry().register(item);
    }

    //for item blocks
    public static void blockItemFactory(Block block, Item.Properties properties, RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(block, properties).setRegistryName(block.getRegistryName()));
    }
}
