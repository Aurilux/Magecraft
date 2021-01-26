package com.lich.magecraft.common.init;

import com.lich.magecraft.common.Magecraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static class Blocks {
        public static final ITag.INamedTag<Block> ELDERWOOD_LOGS = tag("elderwood_logs");

        public static final ITag.INamedTag<Block> BLOCKS_AURA_QUARTZ = tagForge("storage_blocks/aura_quartz");
        public static final ITag.INamedTag<Block> BLOCKS_COLD_IRON = tagForge("storage_blocks/cold_iron");

        private static ITag.INamedTag<Block> tag(String name) {
            return BlockTags.makeWrapperTag(new ResourceLocation(Magecraft.MOD_ID, name).toString());
        }

        private static ITag.INamedTag<Block> tagForge(String name) {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", name).toString());
        }
    }

    public static class Items {
        public static final ITag.INamedTag<Item> ELDERWOOD_LOGS = tag("elderwood_logs");

        public static final ITag.INamedTag<Item> BLOCKS_AURA_QUARTZ = tagForge("storage_blocks/aura_quartz");
        public static final ITag.INamedTag<Item> BLOCKS_COLD_IRON = tagForge("storage_blocks/cold_iron");

        public static final ITag.INamedTag<Item> NUGGETS_COLD_IRON = tagForge("nuggets/cold_iron");
        public static final ITag.INamedTag<Item> INGOTS_COLD_IRON = tagForge("ingots/cold_iron");

        private static ITag.INamedTag<Item> tag(String name) {
            return ItemTags.makeWrapperTag(new ResourceLocation(Magecraft.MOD_ID, name).toString());
        }

        private static ITag.INamedTag<Item> tagForge(String name) {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", name).toString());
        }
    }
}