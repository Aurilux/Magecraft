package com.lich.magecraft.common.init;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.blocks.BlockArcaneAltar;
import com.lich.magecraft.common.blocks.BlockAuraQuartzOre;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.*;

public class ModBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Magecraft.MOD_ID);

    public static final RegistryObject<BlockArcaneAltar> ARCANE_ALTAR = BLOCKS.register("arcane_altar", BlockArcaneAltar::new);

    public static final RegistryObject<RotatedPillarBlock> ELDERWOOD_LOG = BLOCKS.register("elderwood_log",
            () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .hardnessAndResistance(3.0f, 6.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<RotatedPillarBlock> ELDERWOOD_STRIPPED = BLOCKS.register("elderwood_stripped",
            () -> new RotatedPillarBlock(Block.Properties.from(ELDERWOOD_LOG.get())));
    public static final RegistryObject<Block> ELDERWOOD_PLANKS = BLOCKS.register("elderwood_planks",
            () -> new Block(Block.Properties.from(ELDERWOOD_LOG.get())));
    public static final RegistryObject<StairsBlock> ELDERWOOD_STAIRS = BLOCKS.register("elderwood_stairs",
            () -> new StairsBlock(() -> ELDERWOOD_LOG.get().getDefaultState(), Block.Properties.from(ELDERWOOD_LOG.get())));
    public static final RegistryObject<SlabBlock> ELDERWOOD_SLAB = BLOCKS.register("elderwood_slab",
            () -> new SlabBlock(Block.Properties.from(ELDERWOOD_LOG.get())));
    public static final RegistryObject<FenceBlock> ELDERWOOD_FENCE = BLOCKS.register("elderwood_fence",
            () -> new FenceBlock(Block.Properties.from(ELDERWOOD_LOG.get())));
    public static final RegistryObject<DoorBlock> ELDERWOOD_DOOR = BLOCKS.register("elderwood_door",
            () -> new DoorBlock(Block.Properties.from(ELDERWOOD_LOG.get())));
    public static final RegistryObject<TrapDoorBlock> ELDERWOOD_TRAPDOOR = BLOCKS.register("elderwood_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.from(ELDERWOOD_LOG.get())));

    public static final RegistryObject<Block> AURA_QUARTZ_ORE = BLOCKS.register("aura_quartz_ore", BlockAuraQuartzOre::new);
    public static final RegistryObject<Block> AURA_QUARTZ_BLOCK = BLOCKS.register("aura_quartz_block",
            () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(.8f, .8f)));
    public static final RegistryObject<RotatedPillarBlock> AURA_QUARTZ_CHISELED = BLOCKS.register("aura_quartz_chiseled",
            () -> new RotatedPillarBlock(Block.Properties.from(AURA_QUARTZ_BLOCK.get())));
    public static final RegistryObject<RotatedPillarBlock> AURA_QUARTZ_PILLAR = BLOCKS.register("aura_quartz_pillar",
            () -> new RotatedPillarBlock(Block.Properties.from(AURA_QUARTZ_BLOCK.get())));

    public static final RegistryObject<Block> COLD_IRON_BLOCK = BLOCKS.register("cold_iron_block",
            () -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        eventBus.addGenericListener(Item.class, ModBlocks::onRegisterItems);
    }

    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .forEach(block -> {
                    Item.Properties properties = new Item.Properties().group(Magecraft.TAB);
                    BlockItem blockItem = new BlockItem(block, properties);
                    blockItem.setRegistryName(block.getRegistryName());
                    registry.register(blockItem);
                });
    }
}