package com.lich.magecraft.common.init;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.blocks.tileentity.TileArcaneAltar;
import com.lich.magecraft.common.init.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTiles {
    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Magecraft.MOD_ID);
    public static final RegistryObject<TileEntityType<TileArcaneAltar>> ARCANE_ALTAR_TILE =
            TILE_ENTITIES.register("arcane_altar",
                    () -> TileEntityType.Builder.create(TileArcaneAltar::new, ModBlocks.ARCANE_ALTAR.get()).build(null));

    public static void register(IEventBus event) {
        TILE_ENTITIES.register(event);
    }
}