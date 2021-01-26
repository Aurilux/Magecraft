package com.lich.magecraft.common.blocks;

import com.lich.magecraft.common.init.ModTiles;
import com.lich.magecraft.common.blocks.tileentity.TileArcaneAltar;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockArcaneAltar extends Block {
    public BlockArcaneAltar() {
        super(AbstractBlock.Properties.create(Material.ROCK)
                .setRequiresTool()
                .hardnessAndResistance(3.0F, 3.0F));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader reader) {
        return ModTiles.ARCANE_ALTAR_TILE.get().create();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (world.isRemote) {
            return ActionResultType.SUCCESS;
        }
        TileArcaneAltar arcaneAltar = (TileArcaneAltar) world.getTileEntity(pos);
        if (arcaneAltar != null) {
            player.sendMessage(new StringTextComponent("Current Mana: " + arcaneAltar.getMana()), player.getUniqueID());
        }
        return ActionResultType.PASS;
    }
}