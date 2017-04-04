package com.bagasmc.gym.proxy;

import com.bagasmc.gym.Main;
import com.bagasmc.gym.handlers.ItemHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id) {
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Main.MODID + ":" + id, "inventory"));
		 }
	
	@EventHandler
	 public void preInit(FMLPreInitializationEvent event){
	 }
	 
	 @EventHandler
	 public void init(FMLInitializationEvent event){
		 ItemHandler.registerRenders();
	 }
	 
	 @EventHandler
	 public void postInit(FMLPostInitializationEvent event){
	 }
}
