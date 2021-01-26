package com.lich.magecraft.common.handler;

import com.lich.magecraft.common.Magecraft;
import com.lich.magecraft.common.init.ModBlocks;
import com.lich.magecraft.common.entities.ModEntities;
import com.lich.magecraft.common.mana.ManaProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Magecraft.MOD_ID)
public class CommonEventHandler {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        Biome.Category biomeCategory = event.getCategory();
        if (biomeCategory != Biome.Category.NETHER && biomeCategory != Biome.Category.THEEND) {
            List<MobSpawnInfo.Spawners> spawns = event.getSpawns().getSpawner(EntityClassification.AMBIENT);
            spawns.add(new MobSpawnInfo.Spawners(ModEntities.MOTE.get(), 10, 1, 2));
        }
    }

    @SubscribeEvent
    //TODO most likely need to remove all of this considering how lich want's mana to be handled
    public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(Magecraft.MOD_ID, "mana"), new ManaProvider());
        }
    }

    @SubscribeEvent
    public static void onBlockClicked(PlayerInteractEvent.RightClickBlock event) {
        if (event.getItemStack().getItem() instanceof AxeItem) {
            World world = event.getWorld();
            BlockPos blockpos = event.getPos();
            BlockState blockstate = world.getBlockState(blockpos);
            if (blockstate.getBlock() == ModBlocks.ELDERWOOD_LOG.get()) {
                PlayerEntity playerentity = event.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isRemote) {
                    world.setBlockState(blockpos, ModBlocks.ELDERWOOD_STRIPPED.get().getDefaultState()
                            .with(RotatedPillarBlock.AXIS, blockstate.get(RotatedPillarBlock.AXIS)), 11);
                    if (playerentity != null) {
                        event.getItemStack().damageItem(1, playerentity, (p_220040_1_) -> {
                            p_220040_1_.sendBreakAnimation(event.getHand());
                        });
                    }
                }
            }
        }
    }
}