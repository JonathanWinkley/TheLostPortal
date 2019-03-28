package com.atlas.thelostportal.objects.blocks.machines.nonenergyforge;

import java.util.Random;

import com.atlas.thelostportal.Main;
import com.atlas.thelostportal.objects.blocks.BlockBase;
import com.atlas.thelostportal.objects.init.ModBlocksInit;
import com.atlas.thelostportal.util.Reference;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNonEnergyForge extends BlockBase implements ITileEntityProvider
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool BURNING = PropertyBool.create("burning");
	
	public BlockNonEnergyForge(String name) 
	{
		super(name, Material.ROCK, Main.lostportaltab, 4.0F, 4.0F, "pickaxe", 1);
		this.setDefaultState(this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, false));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return	Item.getItemFromBlock(ModBlocksInit.NON_ENERGY_FORGE);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) 
	{
		return new ItemStack(ModBlocksInit.NON_ENERGY_FORGE);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
		{
			playerIn.openGui(Main.instance, Reference.GUI_NON_ENERGY_FORGE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) 
	{
		if (!worldIn.isRemote) 
        {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState west = worldIn.getBlockState(pos.west());
            IBlockState east = worldIn.getBlockState(pos.east());
            EnumFacing face = (EnumFacing)state.getValue(FACING);

            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.EAST;
            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.WEST;
            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
        }
	}
	
	public static void setState(boolean active, World worldIn, BlockPos pos) 
	{
		IBlockState state = worldIn.getBlockState(pos);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		
		if(active) worldIn.setBlockState(pos, ModBlocksInit.NON_ENERGY_FORGE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, true), 3);
		else worldIn.setBlockState(pos, ModBlocksInit.NON_ENERGY_FORGE.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, false), 3);
		
		if(tileentity != null) 
		{
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityNonEnergyForge();
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) 
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityNonEnergyForge tileentity = (TileEntityNonEnergyForge)worldIn.getTileEntity(pos);
		
		worldIn.setBlockToAir(pos.north());
		worldIn.setBlockToAir(pos.north().west());
		worldIn.setBlockToAir(pos.west());
		worldIn.setBlockToAir(pos.west().south());
		worldIn.setBlockToAir(pos.south());
		worldIn.setBlockToAir(pos.south().east());
		worldIn.setBlockToAir(pos.east());
		worldIn.setBlockToAir(pos.east().north());
		
		worldIn.setBlockToAir(pos.north().down(4));
		worldIn.setBlockToAir(pos.north().west().down(4));
		worldIn.setBlockToAir(pos.west().down(4));
		worldIn.setBlockToAir(pos.west().south().down(4));
		worldIn.setBlockToAir(pos.south().down(4));
		worldIn.setBlockToAir(pos.south().east().down(4));
		worldIn.setBlockToAir(pos.east().down(4));
		worldIn.setBlockToAir(pos.east().north().down(4));
		worldIn.setBlockToAir(pos.down(4));
		
		worldIn.setBlockToAir(pos.down().north(2));
		worldIn.setBlockToAir(pos.down().west(2));
		worldIn.setBlockToAir(pos.down().south(2));
		worldIn.setBlockToAir(pos.down().east(2));
		worldIn.setBlockToAir(pos.down().north(2).west());
		worldIn.setBlockToAir(pos.down().west(2).south());
		worldIn.setBlockToAir(pos.down().south(2).west());
		worldIn.setBlockToAir(pos.down().east(2).south());
		worldIn.setBlockToAir(pos.down().north(2).east());
		worldIn.setBlockToAir(pos.down().west(2).north());
		worldIn.setBlockToAir(pos.down().south(2).east());
		worldIn.setBlockToAir(pos.down().east(2).north());
		
		worldIn.setBlockToAir(pos.down(2).north(2));
		worldIn.setBlockToAir(pos.down(2).west(2));
		worldIn.setBlockToAir(pos.down(2).south(2));
		worldIn.setBlockToAir(pos.down(2).east(2));
		worldIn.setBlockToAir(pos.down(2).north(2).west());
		worldIn.setBlockToAir(pos.down(2).west(2).south());
		worldIn.setBlockToAir(pos.down(2).south(2).west());
		worldIn.setBlockToAir(pos.down(2).east(2).south());
		worldIn.setBlockToAir(pos.down(2).north(2).east());
		worldIn.setBlockToAir(pos.down(2).west(2).north());
		worldIn.setBlockToAir(pos.down(2).south(2).east());
		worldIn.setBlockToAir(pos.down(2).east(2).north());
		
		worldIn.setBlockToAir(pos.down(3).north(2));
		worldIn.setBlockToAir(pos.down(3).west(2));
		worldIn.setBlockToAir(pos.down(3).south(2));
		worldIn.setBlockToAir(pos.down(3).east(2));
		worldIn.setBlockToAir(pos.down(3).north(2).west());
		worldIn.setBlockToAir(pos.down(3).west(2).south());
		worldIn.setBlockToAir(pos.down(3).south(2).west());
		worldIn.setBlockToAir(pos.down(3).east(2).south());
		worldIn.setBlockToAir(pos.down(3).north(2).east());
		worldIn.setBlockToAir(pos.down(3).west(2).north());
		worldIn.setBlockToAir(pos.down(3).south(2).east());
		worldIn.setBlockToAir(pos.down(3).east(2).north());
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) 
	{
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {BURNING,FACING});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		EnumFacing facing = EnumFacing.getFront(meta);
		if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	} 
}