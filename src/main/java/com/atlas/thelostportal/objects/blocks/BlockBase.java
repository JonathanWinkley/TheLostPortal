package com.atlas.thelostportal.objects.blocks;

import com.atlas.thelostportal.objects.init.ModBlocksInit;
import com.atlas.thelostportal.objects.init.ModItemsInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block
{
	public BlockBase(String name, Material material, CreativeTabs tab, float hardness, float resistence, String tool, int harvestLevel) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		setHardness(hardness);
		setResistance(resistence);
		
		setHarvestLevel(tool, harvestLevel);
		
		ModBlocksInit.BLOCKS.add(this);
		ModItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
}