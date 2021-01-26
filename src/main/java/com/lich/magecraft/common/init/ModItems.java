package com.lich.magecraft.common.init;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.items.ItemManaOrb;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Magecraft.MOD_ID);

    public static final RegistryObject<ItemManaOrb> MANA_ORB = ITEMS.register("mana_orb",
            () -> new ItemManaOrb(unstackable()));

    public static final RegistryObject<Item> AURA_QUARTZ_SHARD = ITEMS.register("aura_quartz_shard",
            () -> new Item(baseProp()));

    public static final RegistryObject<Item> COLD_IRON_NUGGET = ITEMS.register("cold_iron_nugget",
            () -> new Item(baseProp()));
    public static final RegistryObject<Item> COLD_IRON_INGOT = ITEMS.register("cold_iron_ingot",
            () -> new Item(baseProp()));
    public static final RegistryObject<AxeItem> COLD_IRON_AXE = ITEMS.register("cold_iron_axe",
            () -> new AxeItem(ItemTier.IRON, 1, -2.8F, baseProp()));
    public static final RegistryObject<SwordItem> COLD_IRON_SWORD = ITEMS.register("cold_iron_sword",
            () -> new SwordItem(ItemTier.IRON, 3, -2.4F, baseProp()));
    public static final RegistryObject<HoeItem> COLD_IRON_HOE = ITEMS.register("cold_iron_hoe",
            () -> new HoeItem(ItemTier.IRON, -2, -1.0F, baseProp()));
    public static final RegistryObject<ShovelItem> COLD_IRON_SHOVEL = ITEMS.register("cold_iron_shovel",
            () -> new ShovelItem(ItemTier.IRON, 1.5F, -3.0F, baseProp()));
    public static final RegistryObject<PickaxeItem> COLD_IRON_PICKAXE = ITEMS.register("cold_iron_pickaxe",
            () -> new PickaxeItem(ItemTier.IRON, 1, -2.8F, baseProp()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static Item.Properties baseProp() {
        return new Item.Properties().group(Magecraft.TAB);
    }

    private static Item.Properties unstackable() {
        return baseProp().maxStackSize(1);
    }

    private static Item.Properties quarterStack() {
        return baseProp().maxStackSize(16);
    }
}