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
    public static LogBlock ELDER_LOG;
    @ObjectHolder("stripped_elder_log")
    public static StrippedElderLogBlock STRIPPED_ELDER_LOG;
    @ObjectHolder("infused_stone")
    public static Block INFUSED_STONE;
    @ObjectHolder("infused_bricks")
    public static Block INFUSED_BRICKS;
    @ObjectHolder("chiseled_infused_stone")
    public static Block CHISELED_INFUSED_STONE;

    //stairs
    @ObjectHolder("elder_stairs")
    public static StairsBlock ELDER_STAIRS;
    @ObjectHolder("infused_brick_stairs")
    public static StairsBlock INFUSED_BRICK_STAIRS;

    //slabs
    @ObjectHolder("elder_slab")
    public static SlabBlock ELDER_SLAB;
    @ObjectHolder("infused_brick_slab")
    public static SlabBlock INFUSED_BRICK_SLAB;

    //walls and fences
    @ObjectHolder("elder_fence")
    public static FenceBlock ELDER_FENCE;
    @ObjectHolder("infused_brick_wall")
    public static WallBlock INFUSED_BRICK_WALL;

    //doors gates and trapdoors
    @ObjectHolder("elder_door")
    public static DoorBlock ELDER_DOOR;

    //non simple blocks
    @ObjectHolder("candle")
    public static Block CANDLE;
    @ObjectHolder("circle_test")
    public static Block CIRCLE_TEST;

//Register Blocks here
@SubscribeEvent
    public static void init(RegistryEvent.Register<Block>event){

    //simple blocks
    simpleBlockFactory(event,"infused_stone", Material.ROCK, 3.0F, 5.0f, SoundType.STONE);
    simpleBlockFactory(event,"chiseled_infused_stone", Material.ROCK, 3.0F, 5.0F, SoundType.STONE);

    //blocks with variations
    ELDER_PLANKS = simpleBlockFactory(event, "elder_planks", Material.WOOD, 2.0F, 3.0F, SoundType.WOOD);
    ELDER_STAIRS = stairsFactory(event, ELDER_PLANKS, "elder_stairs");
    ELDER_SLAB = slabFactory(event, ELDER_PLANKS, "elder_slab");
    ELDER_FENCE = fenceFactory(event, ELDER_PLANKS, "elder_fence");
    ELDER_DOOR = doorFactory(event, ELDER_PLANKS, "elder_door");

    INFUSED_BRICKS = simpleBlockFactory(event, "infused_bricks", Material.ROCK, 3.0F, 5.0F, SoundType.STONE);
    INFUSED_BRICK_STAIRS = stairsFactory(event, INFUSED_BRICKS, "infused_brick_stairs");
    INFUSED_BRICK_SLAB = slabFactory(event, INFUSED_BRICKS, "infused_brick_slab");
    INFUSED_BRICK_WALL = wallFactory(event, INFUSED_BRICKS, "infused_brick_wall");

    //non-simple blocks
    registerBlock(new ElderLogBlock(), "elder_log", event);
    registerBlock(new StrippedElderLogBlock(), "stripped_elder_log", event);
    registerBlock(new CandleBlock(), "candle", event);
    registerBlock(new CircleBlock(), "circle_test", event);
}

//Define Block factories here

    //simple block factory
    public static Block simpleBlockFactory(RegistryEvent.Register<Block> event, String registryName, Material material, Float hardness, Float resistance, SoundType sound){
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
