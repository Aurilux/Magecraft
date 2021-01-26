package com.lich.magecraft.datagen;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.init.ModBlocks;
import com.lich.magecraft.common.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    private final ResourceLocation GENERATED = new ResourceLocation("item/generated");

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Magecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Items
        generatedItem(ModItems.MANA_ORB.get());
        generatedItem(ModItems.AURA_QUARTZ_SHARD.get());
        generatedItem(ModItems.COLD_IRON_NUGGET.get());
        generatedItem(ModItems.COLD_IRON_INGOT.get());
        generatedItem(ModItems.COLD_IRON_AXE.get());
        generatedItem(ModItems.COLD_IRON_SWORD.get());
        generatedItem(ModItems.COLD_IRON_HOE.get());
        generatedItem(ModItems.COLD_IRON_SHOVEL.get());
        generatedItem(ModItems.COLD_IRON_PICKAXE.get());

        // Item Blocks
        simpleItemBlock(ModBlocks.ELDERWOOD_LOG.get());
        simpleItemBlock(ModBlocks.ELDERWOOD_STRIPPED.get());
        simpleItemBlockWithFluff(ModBlocks.ELDERWOOD_PLANKS.get(), ModBlocks.ELDERWOOD_STAIRS.get(),
                ModBlocks.ELDERWOOD_SLAB.get(), ModBlocks.ELDERWOOD_FENCE.get(), null);
        simpleDoorItemBlock(ModBlocks.ELDERWOOD_DOOR.get());
        simpleTrapdoorItemBlock(ModBlocks.ELDERWOOD_TRAPDOOR.get());

        simpleItemBlock(ModBlocks.AURA_QUARTZ_ORE.get());
        simpleItemBlock(ModBlocks.AURA_QUARTZ_BLOCK.get());
        simpleItemBlock(ModBlocks.AURA_QUARTZ_CHISELED.get());
        simpleItemBlock(ModBlocks.AURA_QUARTZ_PILLAR.get());

        simpleItemBlock(ModBlocks.COLD_IRON_BLOCK.get());
    }

    private void generatedItem(Item item) {
        String name = item.getRegistryName().getPath();
        withExistingParent(name, GENERATED)
                .texture("layer0", modLoc("item/" + name));
    }

    private void simpleItemBlock(Block block) {
        String name = block.getRegistryName().getPath();
        withExistingParent(name, modLoc("block/" + name)).getLocation();
    }

    private void simpleItemBlockWithFluff(Block originBlock, StairsBlock stairsBlock, SlabBlock slabBlock,
                                          FenceBlock fenceBlock, WallBlock wallBlock) {
        String name = originBlock.getRegistryName().getPath();
        ResourceLocation texture = modLoc("block/" + name);
        withExistingParent(name, texture);
        if (stairsBlock != null) {
            String stairName = stairsBlock.getRegistryName().getPath();
            stairs(stairName, texture, texture, texture);
        }
        if (slabBlock != null) {
            String slabName = slabBlock.getRegistryName().getPath();
            slab(slabName, texture, texture, texture);
        }
        if (fenceBlock != null) {
            String fenceName = fenceBlock.getRegistryName().getPath();
            fenceInventory(fenceName, texture);
        }
        if (wallBlock != null) {
            String wallName = wallBlock.getRegistryName().getPath();
            wallInventory(wallName, texture);
        }
    }

    private void simpleDoorItemBlock(DoorBlock doorBlock) {
        String name = doorBlock.getRegistryName().getPath();
        singleTexture(name, GENERATED, "layer0", modLoc("item/" + name));
    }

    private void simpleTrapdoorItemBlock(TrapDoorBlock trapDoorBlock) {
        String name = trapDoorBlock.getRegistryName().getPath();
        withExistingParent(name, modLoc("block/" + name + "_bottom"));
    }
}
