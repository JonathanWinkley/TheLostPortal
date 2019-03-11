package com.atlas.thelostportal.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockInfiniteFlammable extends BlockBase
{
	public BlockInfiniteFlammable(String name, Material material, CreativeTabs tab, float hardness, float resistence) 
	{
		super(name, material, tab, resistence, resistence);
		setLightLevel(5.0F);
	}
	
	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side)
    {
        if (side != EnumFacing.UP)
            return false;
        else 
            return true;
    }
}
