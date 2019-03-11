package com.atlas.thelostportal.util.handlers;

import com.atlas.thelostportal.objects.blocks.containers.ContainerNonEnergyForge;
import com.atlas.thelostportal.objects.blocks.guis.GuiNonEnergyForge;
import com.atlas.thelostportal.objects.blocks.tileentity.TileEntityNonEnergyForge;
import com.atlas.thelostportal.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_NON_ENERGY_FORGE) return new ContainerNonEnergyForge(player.inventory, (TileEntityNonEnergyForge)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_NON_ENERGY_FORGE) return new GuiNonEnergyForge(player.inventory, (TileEntityNonEnergyForge)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
}