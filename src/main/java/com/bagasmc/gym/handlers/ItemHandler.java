package com.bagasmc.gym.handlers;

import java.util.List;

import com.bagasmc.gym.items.CustomItem;
import com.bagasmc.gym.items.DumbBell;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	
	public static void initialize(){
		ItemHandler.init();
		ItemHandler.register();
	}
	
	public static void init(){
		 DumbBell.init();
	 }
	 
	 public static void register(){
		 GameRegistry.register(DumbBell.dumbBell);
	  
	 }
	 
	 public static void registerRenders(){
		 registerRender(DumbBell.dumbBell);
	  
	 }
	 
	 public static void registerRender(Item item){
		 Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));  
	 }
}
