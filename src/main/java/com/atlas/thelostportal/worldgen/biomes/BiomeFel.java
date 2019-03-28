package com.atlas.thelostportal.worldgen.biomes;

import com.atlas.thelostportal.objects.init.ModBlocksInit;

import net.minecraft.world.biome.Biome;

public class BiomeFel extends Biome 
{
	public BiomeFel() 
	{
		super(new BiomeProperties("fel").setBaseHeight(1.0f).setHeightVariation(0.6f).setTemperature(0.6f).setRainDisabled());
		
		topBlock = ModBlocksInit.CATALYST_BLOCK.getDefaultState();
		fillerBlock = ModBlocksInit.CRYSTAL_CORE.getDefaultState();
		
		this.decorator.treesPerChunk = 2;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}
}