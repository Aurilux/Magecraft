package com.lich.magecraft.datagen;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, Magecraft.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(ModBlocks.ELDERWOOD_LOG.get());
        logBlock(ModBlocks.ELDERWOOD_STRIPPED.get());
        simpleBlockWithFluff(ModBlocks.ELDERWOOD_PLANKS.get(), ModBlocks.ELDERWOOD_STAIRS.get(),
                ModBlocks.ELDERWOOD_SLAB.get(), ModBlocks.ELDERWOOD_FENCE.get(), null);
        simpleDoorBlock(ModBlocks.ELDERWOOD_DOOR.get());
        simpleTrapdoorBlock(ModBlocks.ELDERWOOD_TRAPDOOR.get());

        simpleBlock(ModBlocks.AURA_QUARTZ_ORE.get());
        simpleBlock(ModBlocks.AURA_QUARTZ_BLOCK.get());
        simpleBlock(ModBlocks.AURA_QUARTZ_CHISELED.get());
        logBlock(ModBlocks.AURA_QUARTZ_PILLAR.get());

        simpleBlock(ModBlocks.COLD_IRON_BLOCK.get());
    }

    private void simpleBlockWithFluff(Block originBlock, StairsBlock stairsBlock, SlabBlock slabBlock,
                                      FenceBlock fenceBlock, WallBlock wallBlock) {
        simpleBlock(originBlock);
        ResourceLocation texture = modLoc("block/" + originBlock.getRegistryName().getPath());
        if (stairsBlock != null) {
            stairsBlock(stairsBlock, texture);
        }
        if (slabBlock != null) {
            slabBlock(slabBlock, texture, texture);
        }
        if (fenceBlock != null) {
            fenceBlock(fenceBlock, texture);
        }
        if (wallBlock != null) {
            wallBlock(wallBlock, texture);
        }
    }

    private void simpleDoorBlock(DoorBlock doorBlock) {
        String name = doorBlock.getRegistryName().getPath();
        doorBlock(doorBlock, modLoc("block/" + name + "_top"), modLoc("block/" + name + "_bottom"));
    }

    private void simpleTrapdoorBlock(TrapDoorBlock trapdoorBlock) {
        String name = trapdoorBlock.getRegistryName().getPath();
        trapdoorBlock(trapdoorBlock, modLoc("block/" + name), true);
    }
}