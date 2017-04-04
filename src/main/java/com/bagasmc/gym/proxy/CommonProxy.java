package com.bagasmc.gym.proxy;

import com.bagasmc.gym.blocks.BlockDumbbell;
import com.bagasmc.gym.crafting.ModRecipes;
import com.bagasmc.gym.handlers.BlockHandler;
import com.bagasmc.gym.handlers.ItemHandler;

import net.minecraft.item.Item;

public class CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id) {
		 
	 }
	
	public void preInit() {
		ItemHandler.initialize();
		BlockHandler.initialize();
	 }

	 public void init() {
	  
	 }

	 public void postInit() {
		 ModRecipes.addRecipes();
	 }
}
