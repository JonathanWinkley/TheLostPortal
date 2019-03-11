package com.atlas.thelostportal.objects.init;

import java.util.ArrayList;
import java.util.List;

import com.atlas.thelostportal.objects.items.ItemShieldOnlyOffHand;

import net.minecraft.item.Item;

public class ModItemsInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item BASIC_BLADE = new ItemShieldOnlyOffHand("basic_blade", 15, -1.0F);
	public static final Item TIER_1_BLADE = new ItemShieldOnlyOffHand("tier_1_blade", 63, 3.25F);
	public static final Item TIER_2_BLADE = new ItemShieldOnlyOffHand("tier_2_blade", 127, 7.25F);
}