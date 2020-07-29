package com.lich.magecraft.items;

import com.lich.magecraft.Magecraft;
import com.lich.magecraft.blocks.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import com.lich.magecraft.util.Constants;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("magecraft")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItem {

    // tool material for coldiron tools/weapons
    @ObjectHolder("coldiron_pickaxe")
    public static Item COLDIRON_PICKAXE;
    @ObjectHolder("coldiron_axe")
    public static Item COLDIRON_AXE;
    @ObjectHolder("coldiron_shovel")
    public static Item COLDIRON_SHOVEL;
    @ObjectHolder("coldiron_hoe")
    public static Item COLDIRON_HOE;
    @ObjectHolder("coldiron_sword")
    public static Item COLDIRON_SWORD;

    // materials
    @ObjectHolder("coldiron_ingot")
    public static Item COLDIRON_INGOT;
    @ObjectHolder("coldiron_nugget")
    public static Item COLDIRON_NUGGET;
    @ObjectHolder("smokey_quartz")
    public static Item SMOKEY_QUARTZ;

    // for icon purposes
    @ObjectHolder("crystal_ash")
    public static Item CRYSTAL_ASH;

    // mana
    @ObjectHolder("mana_crystal")
    public static Item MANA_CRYSTAL;
    @ObjectHolder("mana_orb")
    public static Item MANA_ORB;

    //register items here
    @SubscribeEvent
    public static void init(RegistryEvent.Register<Item> event)
    {
        simpleItemFactory("crystal_ash", event);

        // coldiron tools
        registerItem("coldiron_pickaxe", new PickaxeItem(ItemTier.IRON, 1, -2.8F, (new Item.Properties()).group(Magecraft.TAB)), event);
        registerItem("coldiron_axe", new AxeItem(ItemTier.IRON, 1, -2.8F, (new Item.Properties()).group(Magecraft.TAB)), event);
        registerItem("coldiron_hoe", new HoeItem(ItemTier.IRON, -2, -1.0F, (new Item.Properties()).group(Magecraft.TAB)), event);
        registerItem("coldiron_shovel", new ShovelItem(ItemTier.IRON, 1.5F, -3.0F, (new Item.Properties()).group(Magecraft.TAB)), event);

        // coldiron sword
        registerItem("iron_sword", new SwordItem(ItemTier.IRON, 3, -2.4F, (new Item.Properties()).group(Magecraft.TAB)), event);

        // materials
        registerItem("coldiron_ingot", new Item(new Item.Properties().group(Magecraft.TAB)), event);
        registerItem("coldiron_nugget", new Item(new Item.Properties().group(Magecraft.TAB)), event);
        registerItem("smokey_quartz", new Item(new Item.Properties().group(Magecraft.TAB)), event);

        // mana stuff
        registerItem("mana_crystal", new ManaCrystal(new Item.Properties().group(Magecraft.TAB)), event);
        registerItem("mana_orb", new ManaOrb(new Item.Properties().group(Magecraft.TAB)), event);

        //block items
        blockItemFactory (ModBlock.CHISELED_SMOKEY_QUARTZ, Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.SMOKEY_QUARTZ_BLOCK, Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.SMOKEY_QUARTZ_ORE, Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.SMOKEY_QUARTZ_PILLAR, Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.CRYSTAL_CAPACITOR, Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.CRYSTAL_CAPACITOR_MK2, Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.COLDIRON_BLOCK, Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.ELDER_LOG,Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.STRIPPED_ELDER_LOG,Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.ELDER_PLANKS,Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.ELDER_SLAB,Constants.ITEM_PROPS, event);
        blockItemFactory (ModBlock.ELDER_STAIRS, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.ELDER_FENCE, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.ELDER_DOOR, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.ELDER_BOOKSHELF, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.ELDER_TRAPDOOR, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.INFUSION_TABLE, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.SPELL_TABLE, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.RESEARCH_TABLE, Constants.ITEM_PROPS,event);
        blockItemFactory (ModBlock.MANA_ACCUMULATOR, Constants.ITEM_PROPS,event);
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
