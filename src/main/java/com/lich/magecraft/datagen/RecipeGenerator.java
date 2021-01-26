package com.lich.magecraft.datagen;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.init.ModBlocks;
import com.lich.magecraft.common.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    private Consumer<IFinishedRecipe> recipeConsumer;

    public RecipeGenerator(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> recipeConsumer) {
        this.recipeConsumer = recipeConsumer;
        registerCraftingRecipes();
        registerCookingRecipes();
    }

    // TODO later add criterion to these recipes should it be necessary
    private void registerCraftingRecipes() {
        // Storage blocks, ingots, nuggets
        compressAndDecompress3x3(ModBlocks.AURA_QUARTZ_BLOCK.get(), ModItems.AURA_QUARTZ_SHARD.get());
        compressPath(ModBlocks.COLD_IRON_BLOCK.get(), ModItems.COLD_IRON_INGOT.get(), ModItems.COLD_IRON_NUGGET.get());

        // Tools and Armor
        registerToolSet(ModItems.COLD_IRON_INGOT.get(), ModItems.COLD_IRON_AXE.get(), ModItems.COLD_IRON_HOE.get(),
                ModItems.COLD_IRON_PICKAXE.get(), ModItems.COLD_IRON_SHOVEL.get(), ModItems.COLD_IRON_SWORD.get());

        //Fluff Variants
        ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.ELDERWOOD_PLANKS.get(), 4)
                .addIngredient(ModBlocks.ELDERWOOD_LOG.get())
                .addCriterion("has_item", hasItem(ModBlocks.ELDERWOOD_PLANKS.get()))
                .build(recipeConsumer);
        fluffBlocks(ModBlocks.ELDERWOOD_PLANKS.get(), ModBlocks.ELDERWOOD_DOOR.get(), ModBlocks.ELDERWOOD_SLAB.get(),
                ModBlocks.ELDERWOOD_STAIRS.get(), ModBlocks.ELDERWOOD_TRAPDOOR.get());
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.ELDERWOOD_FENCE.get(), 3)
                .patternLine("PSP")
                .patternLine("PSP")
                .key('P', ModBlocks.ELDERWOOD_PLANKS.get())
                .key('S', Tags.Items.RODS_WOODEN)
                .addCriterion("has_item", hasItem(ModBlocks.ELDERWOOD_PLANKS.get()))
                .build(recipeConsumer);
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.AURA_QUARTZ_CHISELED.get(), 4)
                .patternLine(" A ")
                .patternLine("A A")
                .patternLine(" A ")
                .addCriterion("has_item", hasItem(ModBlocks.AURA_QUARTZ_BLOCK.get()))
                .key('A', ModBlocks.AURA_QUARTZ_BLOCK.get())
                .build(recipeConsumer);
        pillar(ModBlocks.AURA_QUARTZ_PILLAR.get(), ModBlocks.AURA_QUARTZ_BLOCK.get());

        // Misc
        ShapedRecipeBuilder.shapedRecipe(Items.STICK, 4)
                .patternLine("P")
                .patternLine("P")
                .key('P', ModBlocks.ELDERWOOD_PLANKS.get())
                .addCriterion("has_item", hasItem(ModBlocks.ELDERWOOD_PLANKS.get()))
                .build(recipeConsumer);
    }

    private void registerCookingRecipes() {
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.ELDERWOOD_LOG.get()),
                Items.CHARCOAL, .15f, 200)
                .addCriterion("has_item", hasItem(ModBlocks.ELDERWOOD_LOG.get()))
                .build(recipeConsumer, Magecraft.MOD_ID + ":charcoal_from_elderwood_log");
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.ELDERWOOD_STRIPPED.get()),
                Items.CHARCOAL, .15f, 200)
                .addCriterion("has_item", hasItem(ModBlocks.ELDERWOOD_STRIPPED.get()))
                .build(recipeConsumer, Magecraft.MOD_ID + ":charcoal_from_stripped_elderwood");
    }

    private void compressPath(IItemProvider storage, IItemProvider ingotOrGem, IItemProvider nugget) {
        compressAndDecompress3x3(storage, ingotOrGem);
        compressAndDecompress3x3(ingotOrGem, nugget);
    }

    private void compressAndDecompress3x3(IItemProvider compressedItem, IItemProvider decompressedItem) {
        String compressingSuffix = Magecraft.MOD_ID + ":" + compressedItem.asItem().getRegistryName().getPath();
        String decompressingSuffix = Magecraft.MOD_ID + ":" + decompressedItem.asItem().getRegistryName().getPath();
        if (compressedItem instanceof Block) {
            compressingSuffix += "_from_ingot";
            decompressingSuffix += "_from_block";
        }
        else {
            compressingSuffix += "_from_nugget";
            decompressingSuffix += "_from_ingot";
        }
        ShapedRecipeBuilder.shapedRecipe(compressedItem)
                .patternLine("III")
                .patternLine("III")
                .patternLine("III")
                .key('I', decompressedItem)
                .addCriterion("has_item", hasItem(decompressedItem))
                .build(recipeConsumer, compressingSuffix);

        ShapelessRecipeBuilder.shapelessRecipe(decompressedItem, 9)
                .addIngredient(compressedItem)
                .addCriterion("has_item", hasItem(compressedItem))
                .build(recipeConsumer, decompressingSuffix);
    }

    private void compressAndDecompress2x2(IItemProvider compressedItem, IItemProvider decompressedItem) {
        ShapedRecipeBuilder.shapedRecipe(compressedItem)
                .patternLine("II")
                .patternLine("II")
                .key('I', decompressedItem)
                .addCriterion("has_item", hasItem(decompressedItem))
                .build(recipeConsumer);

        ShapelessRecipeBuilder.shapelessRecipe(decompressedItem, 4)
                .addIngredient(compressedItem)
                .addCriterion("has_item", hasItem(compressedItem))
                .build(recipeConsumer);
    }

    private void fluffBlocks(IItemProvider material, IItemProvider... fluffBlocks) {
        for (IItemProvider itemProvider : fluffBlocks) {
            if (itemProvider instanceof DoorBlock) {
                door(itemProvider, material);
            }
            else if (itemProvider instanceof SlabBlock) {
                slab(itemProvider, material);
            }
            else if (itemProvider instanceof StairsBlock) {
                stair(itemProvider, material);
            }
            else if (itemProvider instanceof TrapDoorBlock) {
                trapdoor(itemProvider, material);
            }
        }
    }

    private void door(IItemProvider result, IItemProvider ingredient) {
        ShapedRecipeBuilder.shapedRecipe(result, 3)
                .patternLine("II")
                .patternLine("II")
                .patternLine("II")
                .key('I', ingredient)
                .addCriterion("has_item", hasItem(ingredient))
                .build(recipeConsumer);
    }

    private void pillar(IItemProvider result, IItemProvider ingredient) {
        ShapedRecipeBuilder.shapedRecipe(result, 2)
                .patternLine("I")
                .patternLine("I")
                .key('I', ingredient)
                .addCriterion("has_item", hasItem(ingredient))
                .build(recipeConsumer);
    }

    private void slab(IItemProvider result, IItemProvider ingredient) {
        ShapedRecipeBuilder.shapedRecipe(result, 6)
                .patternLine("III")
                .key('I', ingredient)
                .addCriterion("has_item", hasItem(ingredient))
                .build(recipeConsumer);

        slabRecombine(ingredient, result);
    }

    private void slabRecombine(IItemProvider result, IItemProvider ingredient) {
        ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("I")
                .patternLine("I")
                .key('I', ingredient)
                .addCriterion("has_item", hasItem(ingredient))
                .build(recipeConsumer, Magecraft.MOD_ID + ":" + ingredient.asItem().getRegistryName().getPath() + "_recombine");
    }

    private void stair(IItemProvider result, IItemProvider ingredient) {
        ShapedRecipeBuilder.shapedRecipe(result, 4)
                .patternLine("I  ")
                .patternLine("II ")
                .patternLine("III")
                .key('I', ingredient)
                .addCriterion("has_item", hasItem(ingredient))
                .build(recipeConsumer);
    }

    private void trapdoor(IItemProvider result, IItemProvider ingredient) {
        ShapedRecipeBuilder.shapedRecipe(result, 2)
                .patternLine("III")
                .patternLine("III")
                .key('I', ingredient)
                .addCriterion("has_item", hasItem(ingredient))
                .build(recipeConsumer);
    }

    private void registerToolSet(IItemProvider material, IItemProvider axe, IItemProvider hoe, IItemProvider pickaxe,
                                 IItemProvider shovel, IItemProvider sword) {
        ShapedRecipeBuilder.shapedRecipe(axe)
                .patternLine("II")
                .patternLine("IS")
                .patternLine(" S")
                .key('I', material)
                .key('S', Tags.Items.RODS_WOODEN)
                .addCriterion("has_item", hasItem(material))
                .build(recipeConsumer);
        ShapedRecipeBuilder.shapedRecipe(hoe)
                .patternLine("II")
                .patternLine(" S")
                .patternLine(" S")
                .key('I', material)
                .key('S', Tags.Items.RODS_WOODEN)
                .addCriterion("has_item", hasItem(material))
                .build(recipeConsumer);
        ShapedRecipeBuilder.shapedRecipe(pickaxe)
                .patternLine("III")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('I', material)
                .key('S', Tags.Items.RODS_WOODEN)
                .addCriterion("has_item", hasItem(material))
                .build(recipeConsumer);
        ShapedRecipeBuilder.shapedRecipe(shovel)
                .patternLine("I")
                .patternLine("S")
                .patternLine("S")
                .key('I', material)
                .key('S', Tags.Items.RODS_WOODEN)
                .addCriterion("has_item", hasItem(material))
                .build(recipeConsumer);
        ShapedRecipeBuilder.shapedRecipe(sword)
                .patternLine("I")
                .patternLine("I")
                .patternLine("S")
                .key('I', material)
                .key('S', Tags.Items.RODS_WOODEN)
                .addCriterion("has_item", hasItem(material))
                .build(recipeConsumer);
    }
}