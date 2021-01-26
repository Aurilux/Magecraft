package com.lich.magecraft.common;

import com.lich.magecraft.client.render.TERArcaneAltar;
import com.lich.magecraft.common.init.ModBlocks;
import com.lich.magecraft.common.init.ModTiles;
import com.lich.magecraft.common.entities.ModEntities;
import com.lich.magecraft.common.entities.mote.MoteEntity;
import com.lich.magecraft.common.init.ModItems;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Magecraft.MOD_ID)
public class Magecraft {
    public static final String MOD_ID = "magecraft";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID.toUpperCase());

    public static final ItemGroup TAB = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.MANA_ORB.get());
        }
    };

    public Magecraft() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::clientSetup);

        ModItems.register(modBus);
        ModBlocks.register(modBus);
        ModTiles.register(modBus);
        ModEntities.register(modBus);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(ModEntities.MOTE.get(), MoteEntity.healthAttribute().create());
    }

    public void clientSetup(final FMLClientSetupEvent event) {
        //RenderTypeLookup.setRenderLayer(ModBlocks.ELDER_DOOR, RenderType.getCutout());
        //RenderTypeLookup.setRenderLayer(ModBlocks.ELDER_TRAPDOOR, RenderType.getCutout());

        //Tile Entities
        ClientRegistry.bindTileEntityRenderer(ModTiles.ARCANE_ALTAR_TILE.get(), TERArcaneAltar::new);
    }
}