package com.lich.magecraft;


import com.lich.magecraft.blocks.ModBlock;
import com.lich.magecraft.items.ModItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("magecraft")
public class Magecraft
{

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "magecraft";

    public Magecraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) {

        //to change render types
        RenderTypeLookup.setRenderLayer(ModBlock.ELDER_DOOR, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.RESEARCH_TABLE, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlock.SPELL_TABLE, RenderType.getCutout());
    }

    public static final ItemGroup TAB = new ItemGroup("magecraftTab") {

        @Override
        public ItemStack createIcon(){
            return new ItemStack(ModItem.CRYSTAL_ASH);
        }
    };
}

/* Magecraft TODO
    - add blocks:
    chiseled_smokey_quartz x
    coldiron_block x
    crystal_capacitor x
    crystal_capacitor_mk2 x
    elder_bookshelf 1-4 x
    elder_trapdoor
    smokey_quartz_block x
    smokey_quartz_ore x
    smokey_quartz_pillar x
    infusion_table x
    mana_accumulator x
    research_table x
    spell_table x
    - add items:
    coldiron:
    *coldiron axe /
    *coldiron hoe /
    *coldiron igot
    *coldiron nugget
    *coldiron pickaxe /
    *coldiron shovel /
    *coldiron sword
    mana_crystal
    mana_orb
    smokey_quartz
 */