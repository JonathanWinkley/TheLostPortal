package com.atlas.thelostportal.util.handlers;

import com.atlas.thelostportal.Main;
import com.atlas.thelostportal.commands.CommandDimensionTeleport;
import com.atlas.thelostportal.objects.init.ModBiomesInit;
import com.atlas.thelostportal.objects.init.ModBlocksInit;
import com.atlas.thelostportal.objects.init.ModItemsInit;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItemsInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocksInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItemsInit.ITEMS)
		{
			Main.proxy.registerItemRenderer(item, 0, "inventory");
		}
		
		for(Block block : ModBlocksInit.BLOCKS)
		{
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
	}
	
	public static void preInitRegistries()
	{
		ModBiomesInit.registerBiomes();
	}
	
	public static void initRegistries()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
	
	public static void postInitRegistries()
	{
		
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandDimensionTeleport());
	}
}
