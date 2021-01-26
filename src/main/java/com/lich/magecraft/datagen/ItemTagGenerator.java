package com.lich.magecraft.datagen;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.init.ModItems;
import com.lich.magecraft.common.init.ModTags;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ItemTagGenerator extends ItemTagsProvider {
    public ItemTagGenerator(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, Magecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

        copy(ModTags.Blocks.ELDERWOOD_LOGS, ModTags.Items.ELDERWOOD_LOGS);
        copy(ModTags.Blocks.BLOCKS_AURA_QUARTZ, ModTags.Items.BLOCKS_AURA_QUARTZ);
        copy(ModTags.Blocks.BLOCKS_COLD_IRON, ModTags.Items.BLOCKS_COLD_IRON);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.NUGGETS_COLD_IRON).add(ModItems.COLD_IRON_NUGGET.get());
        tag(Tags.Items.NUGGETS).addTag(ModTags.Items.NUGGETS_COLD_IRON);
        tag(ModTags.Items.INGOTS_COLD_IRON).add(ModItems.COLD_IRON_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_COLD_IRON);
    }

    private TagsProvider.Builder<Item> tag(ITag.INamedTag<Item> tag) {
        return this.getOrCreateBuilder(tag);
    }
}