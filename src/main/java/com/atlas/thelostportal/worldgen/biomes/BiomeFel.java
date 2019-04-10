package com.atlas.thelostportal.worldgen.biomes;

import com.atlas.thelostportal.objects.init.ModBlocksInit;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeFel extends Biome 
{
	public BiomeFel() 
	{
		super(new BiomeProperties("fel").setBaseHeight(1.0f).setHeightVariation(0.2f).setTemperature(0.6f).setRainDisabled().setWaterColor(0x0e2400));
		
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        
        this.topBlock = ModBlocksInit.FEL_CRUST.getDefaultState();
        this.fillerBlock = ModBlocksInit.FEL_DIRT.getDefaultState();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float currentTemperature)
    {
        return 0x0e2400;
    }
}