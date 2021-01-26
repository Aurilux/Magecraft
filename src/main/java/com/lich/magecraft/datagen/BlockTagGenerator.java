package com.lich.magecraft.datagen;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.init.ModBlocks;
import com.lich.magecraft.common.init.ModTags;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Magecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        tag(ModTags.Blocks.ELDERWOOD_LOGS).add(ModBlocks.ELDERWOOD_LOG.get(), ModBlocks.ELDERWOOD_STRIPPED.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.ELDERWOOD_LOGS);

        tag(BlockTags.PLANKS).add(ModBlocks.ELDERWOOD_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.ELDERWOOD_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(ModBlocks.ELDERWOOD_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.ELDERWOOD_FENCE.get());

        tag(Tags.Blocks.ORES).add(ModBlocks.AURA_QUARTZ_ORE.get());

        tag(ModTags.Blocks.BLOCKS_AURA_QUARTZ).add(ModBlocks.AURA_QUARTZ_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCKS_AURA_QUARTZ);
        tag(ModTags.Blocks.BLOCKS_COLD_IRON).add(ModBlocks.COLD_IRON_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.BLOCKS_COLD_IRON);
    }

    private TagsProvider.Builder<Block> tag(ITag.INamedTag<Block> tag) {
        return this.getOrCreateBuilder(tag);
    }
}