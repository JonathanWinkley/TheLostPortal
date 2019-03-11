package com.atlas.thelostportal.objects.init;

import java.util.ArrayList;
import java.util.List;

import com.atlas.thelostportal.Main;
import com.atlas.thelostportal.objects.blocks.BlockBase;
import com.atlas.thelostportal.objects.blocks.BlockInfiniteFlammable;
import com.atlas.thelostportal.objects.blocks.BlockNonEnergyForge;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocksInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block STAND_IN = new BlockBase("stand_in", Material.CLOTH, Main.lostportaltab, 1.0F, 1.0F);
	
	public static final Block NETHER_OBI = new BlockInfiniteFlammable("nether_obi", Material.ROCK, Main.lostportaltab, 30.0F, 30.0F);
	public static final Block CHORUS_STONE = new BlockBase("chorus_stone", Material.ROCK, Main.lostportaltab, 2.5F, 2.5F);
	
	public static final Block NON_ENERGY_FORGE = new BlockNonEnergyForge("non_energy_forge");
}
