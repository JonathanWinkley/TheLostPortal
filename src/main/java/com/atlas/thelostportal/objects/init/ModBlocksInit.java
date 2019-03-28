package com.atlas.thelostportal.objects.init;

import java.util.ArrayList;
import java.util.List;

import com.atlas.thelostportal.Main;
import com.atlas.thelostportal.objects.blocks.BlockBase;
import com.atlas.thelostportal.objects.blocks.BlockInfiniteFlammable;
import com.atlas.thelostportal.objects.blocks.BlockTeleporter;
import com.atlas.thelostportal.objects.blocks.machines.nonenergyforge.BlockNonEnergyForge;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocksInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block NETHER_OBI = new BlockInfiniteFlammable("nether_obi", Material.ROCK, Main.lostportaltab, 40.0F, 1700.0F, "pickaxe", 3);
	public static final Block CHORUS_STONE = new BlockBase("chorus_stone", Material.ROCK, Main.lostportaltab, 2.5F, 15.0F, "pickaxe", 1);
	public static final Block CRYSTAL_CORE = new BlockBase("crystal_core", Material.ROCK, Main.lostportaltab, 5.0F, 10.0F, "pickaxe", 2);
	public static final Block CATALYST_BLOCK = new BlockBase("catalyst_block", Material.ROCK, Main.lostportaltab, 4.5F, 10.0F, "pickaxe", 1);
	
	public static final Block END_TELEPORTER = new BlockTeleporter("end_teleporter", 1);
	public static final Block NETHER_TELEPORTER = new BlockTeleporter("nether_teleporter", -1);
	public static final Block OVERWORLD_TELEPORTER = new BlockTeleporter("overworld_teleporter", 0);
	
	public static final Block NON_ENERGY_FORGE = new BlockNonEnergyForge("non_energy_forge");
}
