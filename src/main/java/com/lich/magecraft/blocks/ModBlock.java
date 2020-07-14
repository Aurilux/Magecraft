package com.lich.magecraft.blocks;

import com.lich.magecraft.Magecraft;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("magecraft")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlock {

    //name blocks here

    //simple blocks
    @ObjectHolder("elder_planks")
    public static Block ELDER_PLANKS;
    @ObjectHolder("elder_log")
    public static ElderLogBlock ELDER_LOG;
    @ObjectHolder("stripped_elder_log")
    public static StrippedElderLogBlock STRIPPED_ELDER_LOG;

    //stairs
    @ObjectHolder("elder_stairs")
    public static StairsBlock ELDER_STAIRS;

    //slabs
    @ObjectHolder("elder_slab")
    public static SlabBlock ELDER_SLAB;

    //walls and fences
    @ObjectHolder("elder_fence")
    public static FenceBlock ELDER_FENCE;

    //doors gates and trapdoors
    @ObjectHolder("elder_door")
    public static DoorBlock ELDER_DOOR;

    //Register Blocks here
    @SubscribeEvent
    public static void init(RegistryEvent.Register<Block>event)
    {

        //blocks with variations
        ELDER_PLANKS = simpleBlockFactory(event, "elder_planks", Material.WOOD, 2.0F, 3.0F, SoundType.WOOD);
        ELDER_STAIRS = stairsFactory(event, ELDER_PLANKS, "elder_stairs");
        ELDER_SLAB = slabFactory(event, ELDER_PLANKS, "elder_slab");
        ELDER_FENCE = fenceFactory(event, ELDER_PLANKS, "elder_fence");
        ELDER_DOOR = doorFactory(event, ELDER_PLANKS, "elder_door");

        //non-simple block
        registerBlock(new ElderLogBlock(), "elder_log", event);
        registerBlock(new StrippedElderLogBlock(), "stripped_elder_log", event);
    }

//Define Block factories here

    //simple block factory
    public static Block simpleBlockFactory(RegistryEvent.Register<Block> event, String registryName, Material material, Float hardness, Float resistance, SoundType sound)
    {
        Block block = new Block(Block.Properties
                .create(material)
                .hardnessAndResistance(hardness, resistance)
                .sound(sound));

        block.setRegistryName(Magecraft.MOD_ID, registryName);
        event.getRegistry().register(block);

        return block;
    }

    //stairs factory
    public static StairsBlock stairsFactory(RegistryEvent.Register<Block> event, Block block, String registryName)
    {
        StairsBlock stairsBlock = new StairsMod(block);

        stairsBlock.setRegistryName(registryName);
        event.getRegistry().register(stairsBlock);

        return stairsBlock;
    }

    //slab factory
    public static SlabBlock slabFactory(RegistryEvent.Register<Block> event, Block block, String registryName)
    {
        SlabBlock slabBlock = new SlabBlock(Block.Properties.from(block));

        slabBlock.setRegistryName(registryName);
        event.getRegistry().register(slabBlock);

        return slabBlock;
    }

    //fence factory
    public static FenceBlock fenceFactory(RegistryEvent.Register<Block> event, Block block, String registryName)
    {
        FenceBlock fenceBlock = new FenceBlock(Block.Properties.from(block));

        fenceBlock.setRegistryName(registryName);
        event.getRegistry().register(fenceBlock);

        return fenceBlock;
    }

    //wall factory
    public static WallBlock wallFactory(RegistryEvent.Register<Block> event, Block block, String registryName) {
        WallBlock wallBlock = new WallBlock(Block.Properties.from(block));

        wallBlock.setRegistryName(registryName);
        event.getRegistry().register(wallBlock);

        return wallBlock;
    }

    //door factory
    public static DoorBlock doorFactory(RegistryEvent.Register<Block> event, Block block, String registryName) {
        DoorBlock doorBlock = new DoorMod(block);

        doorBlock.setRegistryName(registryName);
        event.getRegistry().register(doorBlock);

        return doorBlock;
    }
    //non-simple block factory
    public static void registerBlock(Block block, String registryName, RegistryEvent.Register<Block> event)
    {
        block.setRegistryName(registryName);
        event.getRegistry().register(block);
    }

}
