package com.atlas.thelostportal.objects.init;

import com.atlas.thelostportal.worldgen.biomes.BiomeFel;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomesInit 
{
	public static final Biome FEL = new BiomeFel();
	
	public static void registerBiomes()
	{
		initBiome(FEL, "fel", BiomeType.WARM, Type.PLAINS, Type.DRY);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 1));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}