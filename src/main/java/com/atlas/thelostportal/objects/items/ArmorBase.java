package com.atlas.thelostportal.objects.items;

import com.atlas.thelostportal.Main;
import com.atlas.thelostportal.objects.init.ModItemsInit;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor
{
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) 
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.lostportaltab);
		
		ModItemsInit.ITEMS.add(this);
	}
}