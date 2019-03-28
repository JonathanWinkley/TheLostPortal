package com.atlas.thelostportal.worldgen;

import com.atlas.thelostportal.objects.init.ModBiomesInit;
import com.atlas.thelostportal.objects.init.ModDimensions;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;

public class FelWorldProvider extends WorldProvider {

	public FelWorldProvider() 
	{
		this.biomeProvider = new BiomeProviderSingle(ModBiomesInit.FEL);
	}
	
    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.felDimensionType;
    }
    
    @Override
    public boolean isSurfaceWorld()
    {
        return true;
    }
    
    @Override
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }

    @Override
    public String getSaveFolder() {
        return "FEL";
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new FelChunkGenerator(world);
    }
}