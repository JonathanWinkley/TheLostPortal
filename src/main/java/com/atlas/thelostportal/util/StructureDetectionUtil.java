package com.atlas.thelostportal.util;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StructureDetectionUtil 
{
	public static boolean structureDetect(Block block1, Block block2, int structureNumb, BlockPos pos, World worldIn)
	{
		if(structureNumb == 1)
		{
			if(worldIn.getBlockState(pos.up()).getBlock() == block1 && 
				worldIn.getBlockState(pos.up().north()).getBlock() == block2 &&
				worldIn.getBlockState(pos.up().north().east()).getBlock() == block1 &&
				worldIn.getBlockState(pos.up().east()).getBlock() == block2 &&
				worldIn.getBlockState(pos.up().east().south()).getBlock() == block1 &&
				worldIn.getBlockState(pos.up().south()).getBlock() == block2 &&
				worldIn.getBlockState(pos.up().south().west()).getBlock() == block1 &&
				worldIn.getBlockState(pos.up().west()).getBlock() == block2 &&
				worldIn.getBlockState(pos.up().west().north()).getBlock() == block1 &&
				worldIn.getBlockState(pos.north()).getBlock() == block2 &&
				worldIn.getBlockState(pos.north().east()).getBlock() == block1 &&
				worldIn.getBlockState(pos.east()).getBlock() == block2 &&
				worldIn.getBlockState(pos.east().south()).getBlock() == block1 &&
				worldIn.getBlockState(pos.south()).getBlock() == block2 &&
				worldIn.getBlockState(pos.south().west()).getBlock() == block1 &&
				worldIn.getBlockState(pos.west()).getBlock() == block2 &&
				worldIn.getBlockState(pos.west().north()).getBlock() == block1 &&
				worldIn.getBlockState(pos.down()).getBlock() == block1 && 
				worldIn.getBlockState(pos.down().north()).getBlock() == block2 &&
				worldIn.getBlockState(pos.down().north().east()).getBlock() == block1 &&
				worldIn.getBlockState(pos.down().east()).getBlock() == block2 &&
				worldIn.getBlockState(pos.down().east().south()).getBlock() == block1 &&
				worldIn.getBlockState(pos.down().south()).getBlock() == block2 &&
				worldIn.getBlockState(pos.down().south().west()).getBlock() == block1 &&
				worldIn.getBlockState(pos.down().west()).getBlock() == block2 &&
				worldIn.getBlockState(pos.down().west().north()).getBlock() == block1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(structureNumb == 2)
		{
			if(worldIn.getBlockState(pos.north(2).up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.north(2).east().up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.north(2).east(2).up(2)).getBlock() == block2 &&
				worldIn.getBlockState(pos.north().east(2).up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).south().up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).south(2).up(2)).getBlock() == block2 &&
				worldIn.getBlockState(pos.east().south(2).up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).west().up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).west(2).up(2)).getBlock() == block2 &&
				worldIn.getBlockState(pos.south().west(2).up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).north().up(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).north(2).up(2)).getBlock() == block2 &&
				worldIn.getBlockState(pos.west().north(2).up(2)).getBlock() == block1 &&
					
				worldIn.getBlockState(pos.north(2).east(2).up()).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).south(2).up()).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).west(2).up()).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).north(2).up()).getBlock() == block1 &&
				worldIn.getBlockState(pos.north(2).east(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).south(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).west(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).north(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.north(2).east(2).down()).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).south(2).down()).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).west(2).down()).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).north(2).down()).getBlock() == block1 &&
					
				worldIn.getBlockState(pos.north(2).down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.north(2).east().down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.north(2).east(2).down(2)).getBlock() == block2 &&
				worldIn.getBlockState(pos.north().east(2).down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).south().down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.east(2).south(2).down(2)).getBlock() == block2 &&
				worldIn.getBlockState(pos.east().south(2).down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).west().down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.south(2).west(2).down(2)).getBlock() == block2 &&
				worldIn.getBlockState(pos.south().west(2).down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).north().down(2)).getBlock() == block1 &&
				worldIn.getBlockState(pos.west(2).north(2).down(2)).getBlock() == block2 &&
				worldIn.getBlockState(pos.west().north(2).down(2)).getBlock() == block1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(structureNumb == 3)
		{
			if(		worldIn.getBlockState(pos.down()).getBlock() == block1 &&
					worldIn.getBlockState(pos.down().north()).getBlock() == block1 &&
					worldIn.getBlockState(pos.down().north().east()).getBlock() == block1 &&
					worldIn.getBlockState(pos.down().east()).getBlock() == block1 &&
					worldIn.getBlockState(pos.down().east().south()).getBlock() == block1 &&
					worldIn.getBlockState(pos.down().south()).getBlock() == block1 &&
					worldIn.getBlockState(pos.down().south().west()).getBlock() == block1 &&
					worldIn.getBlockState(pos.down().west()).getBlock() == block1 &&
					worldIn.getBlockState(pos.down().west().north()).getBlock() == block1 &&
					
					worldIn.getBlockState(pos.down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.down(2).north()).getBlock() == block2 &&
					worldIn.getBlockState(pos.down(2).north().east()).getBlock() == block2 &&
					worldIn.getBlockState(pos.down(2).east()).getBlock() == block2 &&
					worldIn.getBlockState(pos.down(2).east().south()).getBlock() == block2 &&
					worldIn.getBlockState(pos.down(2).south()).getBlock() == block2 &&
					worldIn.getBlockState(pos.down(2).south().west()).getBlock() == block2 &&
					worldIn.getBlockState(pos.down(2).west()).getBlock() == block2 &&
					worldIn.getBlockState(pos.down(2).west().north()).getBlock() == block2 &&
					worldIn.getBlockState(pos.north(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.north(2).east().down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.north(2).east(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.north().east(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.east(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.east(2).south().down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.east(2).south(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.east().south(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.south(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.south(2).west().down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.south(2).west(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.south().west(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.west(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.west(2).north().down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.west(2).north(2).down(2)).getBlock() == block2 &&
					worldIn.getBlockState(pos.west().north(2).down(2)).getBlock() == block2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
