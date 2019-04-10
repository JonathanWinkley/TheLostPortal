package com.atlas.thelostportal.objects.blocks;

import com.atlas.thelostportal.Main;
import com.atlas.thelostportal.commands.util.Teleport;
import com.atlas.thelostportal.objects.init.ModBlocksInit;
import com.atlas.thelostportal.objects.init.ModItemsInit;
import com.atlas.thelostportal.util.StructureDetectionUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTeleporter extends Block
{
	private int dim;
	private Block block1;
	private Block block2;
	
	public BlockTeleporter(String name, int dim, Block block1, Block block2) 
	{
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.lostportaltab);
		
		setHardness(10.0F);
		setResistance(10.0F);
		
		setHarvestLevel("pickaxe", 4);
		
		this.dim = dim;
		this.block1 = block1;
		this.block2 = block2;
		
		ModBlocksInit.BLOCKS.add(this);
		ModItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote && StructureDetectionUtil.structureDetect(block1, block2, 3, pos, worldIn))
		{
			if(dim == 1)
			{
			Teleport.teleportToDimension(playerIn, dim, 0, 67, 0);
			return true;
			}
			else
			{
				Teleport.teleportToDimension(playerIn, dim, playerIn.getPosition().getX(), playerIn.getPosition().getY() + 5, playerIn.getPosition().getZ());
				return true;	
			}
		}
		else
			return false;
	}
}