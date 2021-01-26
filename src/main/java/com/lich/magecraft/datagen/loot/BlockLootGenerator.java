package com.lich.magecraft.datagen;

import com.lich.magecraft.common.init.ModBlocks;
import com.lich.magecraft.common.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Items;

public class BlockLootGenerator extends BlockLootTables {
    @Override
    protected void addTables() {
        registerDropSelfLootTable(ModBlocks.ARCANE_ALTAR.get());

        registerDropSelfLootTable(ModBlocks.ELDERWOOD_LOG.get());
        registerDropSelfLootTable(ModBlocks.ELDERWOOD_STRIPPED.get());
        registerDropSelfLootTable(ModBlocks.ELDERWOOD_PLANKS.get());
        registerDropSelfLootTable(ModBlocks.ELDERWOOD_STAIRS.get());
        registerDropSelfLootTable(ModBlocks.ELDERWOOD_SLAB.get());
        registerDropSelfLootTable(ModBlocks.ELDERWOOD_FENCE.get());
        registerDropSelfLootTable(ModBlocks.ELDERWOOD_DOOR.get());
        registerDropSelfLootTable(ModBlocks.ELDERWOOD_TRAPDOOR.get());

        this.registerLootTable(ModBlocks.AURA_QUARTZ_ORE.get(),
                (aura_quartz) -> droppingItemWithFortune(aura_quartz, ModItems.AURA_QUARTZ_SHARD.get()));
        registerDropSelfLootTable(ModBlocks.AURA_QUARTZ_BLOCK.get());
        registerDropSelfLootTable(ModBlocks.AURA_QUARTZ_CHISELED.get());
        registerDropSelfLootTable(ModBlocks.AURA_QUARTZ_PILLAR.get());

        registerDropSelfLootTable(ModBlocks.COLD_IRON_BLOCK.get());
    }
}