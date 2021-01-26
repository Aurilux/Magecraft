package com.lich.magecraft.datagen;

import com.lich.magecraft.datagen.loot.BlockLootGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MagecraftDataGen {
    @SubscribeEvent
    public static void gather(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            BlockTagGenerator blockTagGenerator = new BlockTagGenerator(gen, fileHelper);
            gen.addProvider(blockTagGenerator);
            gen.addProvider(new ItemTagGenerator(gen, blockTagGenerator, fileHelper));
            gen.addProvider(new LootTableGenerator(gen));
            gen.addProvider(new RecipeGenerator(gen));
        }

        if (event.includeClient()) {
            gen.addProvider(new BlockStateGenerator(gen, fileHelper));
            gen.addProvider(new ItemModelGenerator(gen, fileHelper));
        }
    }
}