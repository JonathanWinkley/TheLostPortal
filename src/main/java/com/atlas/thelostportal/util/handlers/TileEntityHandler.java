package com.atlas.thelostportal.util.handlers;

import com.atlas.thelostportal.objects.blocks.machines.nonenergyforge.TileEntityNonEnergyForge;
import com.atlas.thelostportal.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityNonEnergyForge.class, new ResourceLocation(Reference.MOD_ID + ":non_energy_forge"));
	}
}