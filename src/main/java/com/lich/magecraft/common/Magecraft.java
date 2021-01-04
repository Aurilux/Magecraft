package com.lich.magecraft.common;

import com.lich.magecraft.common.blocks.ModBlock;
import com.lich.magecraft.common.entities.ModEntities;
import com.lich.magecraft.common.entities.mote.MoteEntity;
import com.lich.magecraft.common.items.ModItem;
import com.lich.magecraft.common.mana.IMana;
import com.lich.magecraft.common.mana.Mana;
import com.lich.magecraft.common.mana.ManaProvider;
import com.lich.magecraft.common.mana.ManaStorage;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Magecraft.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Magecraft {
    public static final String MOD_ID = "magecraft";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID.toUpperCase());

    public static final ItemGroup TAB = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItem.MANA_ORB);
        }
    };

    public Magecraft() {
        ModEntities.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public void onCommonSetup(final FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IMana.class, new ManaStorage(), Mana::new);
        GlobalEntityTypeAttributes.put(ModEntities.MOTE.get(), MoteEntity.healthAttribute().create());
    }

    @SubscribeEvent
    public void onClientSetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlock.ELDER_DOOR, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.ELDER_TRAPDOOR, RenderType.getCutout());
    }
}