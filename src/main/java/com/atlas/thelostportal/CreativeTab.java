package com.atlas.thelostportal;

import com.atlas.thelostportal.objects.init.ModBlocksInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs
{
	public CreativeTab(String label) 
	{ 
		super("creativetab");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(ModBlocksInit.NON_ENERGY_FORGE));
	}
}