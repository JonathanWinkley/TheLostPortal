package com.atlas.thelostportal.objects.items;

import com.atlas.thelostportal.objects.init.ModItemsInit;

import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(com.atlas.thelostportal.Main.lostportaltab);
		
		ModItemsInit.ITEMS.add(this);
	}
}
