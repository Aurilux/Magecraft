package com.lich.magecraft.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ElderLogBlock extends RotatedPillarBlock
{
    private static Float hardness   = 3.0F;
    private static Float resistance = 6.0F;

    public ElderLogBlock()
    {
        super(Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(hardness, resistance).sound(SoundType.WOOD));
    }

    // To allow "stripping"
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result)
    {
        if (!worldIn.isRemote)
        {
            if (handIn == Hand.OFF_HAND) {
                return ActionResultType.SUCCESS;
            }
            ItemStack itemStack = player.getHeldItem(handIn);
            if (itemStack.getItem() instanceof AxeItem)
            {
                worldIn.setBlockState(pos, ModBlock.STRIPPED_ELDER_LOG.getDefaultState());
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                itemStack.damageItem(1, player, (p_220040_1_) -> p_220040_1_.sendBreakAnimation(handIn));
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }
}
