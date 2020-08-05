package com.lich.magecraft.entities;

import com.lich.magecraft.Magecraft;
import com.lich.magecraft.entities.mote.MoteEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Magecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntitiesInit {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Magecraft.MOD_ID);

    public static RegistryObject<EntityType<MoteEntity>> MOTE = ENTITY_TYPES.register("mote",
            () -> EntityType.Builder.create(MoteEntity::new, EntityClassification.AMBIENT)
                    .size(1.0f, 1.0f)
                    .build(new ResourceLocation(Magecraft.MOD_ID, "mote").toString()));

    @SubscribeEvent
    public static void initEntites(FMLLoadCompleteEvent event) {
        registerEntityWorldSpawn(MOTE.get(), EntityClassification.AMBIENT, true);

        GlobalEntityTypeAttributes.put(MOTE.get(), MoteEntity.healthAttribute().func_233813_a_());
    }


    public static void registerEntityWorldSpawn(EntityType<?> entity, EntityClassification classification, boolean overworldOnly) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (!overworldOnly) {
                biome.getSpawns(classification).add(new Biome.SpawnListEntry(entity, 10, 1,2));
            }
            else {
                if ((biome.getCategory() != Biome.Category.NETHER) && (biome.getCategory() != Biome.Category.THEEND)) {
                    biome.getSpawns(classification).add(new Biome.SpawnListEntry(entity, 10, 1,2));
                }
            }
        }
    }

}
