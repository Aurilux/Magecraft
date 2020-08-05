package com.lich.magecraft;


import com.lich.magecraft.blocks.ModBlock;
import com.lich.magecraft.entities.EntitiesInit;
import com.lich.magecraft.items.ModItem;
import com.lich.magecraft.mana.IMana;
import com.lich.magecraft.mana.Mana;
import com.lich.magecraft.mana.ManaProvider;
import com.lich.magecraft.mana.ManaStorage;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("magecraft")
public class Magecraft {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "magecraft";

    public Magecraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onAttachCapabilities);

        EntitiesInit.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onCommonSetup(final FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IMana.class, new ManaStorage(), Mana::new);
    }

    @SubscribeEvent
    public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(Magecraft.MOD_ID, "mana"), new ManaProvider());
        }
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        //to change render types
        RenderTypeLookup.setRenderLayer(ModBlock.ELDER_DOOR, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.RESEARCH_TABLE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SPELL_TABLE, RenderType.getCutout());
    }

    public static final ItemGroup TAB = new ItemGroup("magecraftTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItem.MANA_ORB);
        }
    };
}