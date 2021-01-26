package com.lich.magecraft.common.entities;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.entities.mote.MoteEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModEntities {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Magecraft.MOD_ID);

    public static RegistryObject<EntityType<MoteEntity>> MOTE = ENTITY_TYPES.register("mote",
            () -> EntityType.Builder.create(MoteEntity::new, EntityClassification.AMBIENT)
                    .size(1.0f, 1.0f)
                    .build(new ResourceLocation(Magecraft.MOD_ID, "mote").toString()));

    public static void register(IEventBus event) {
        ENTITY_TYPES.register(event);
    }
}