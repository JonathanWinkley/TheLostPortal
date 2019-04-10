package com.atlas.thelostportal.objects.blocks;

import java.util.Random;

import com.atlas.thelostportal.Main;
import com.atlas.thelostportal.objects.init.ModBlocksInit;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockFelCrust extends BlockBase
{
	public BlockFelCrust(String name) 
	{
		super(name, Material.ROCK, Main.lostportaltab, 3.0F, 3.0F, "shovel", 1);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocksInit.FEL_DIRT);
    }
}