package com.bagasmc.gym.items;

import java.util.List;

import com.bagasmc.gym.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomItems extends Item {
	public CustomItems(String name, CreativeTabs tab){
		  setUnlocalizedName(name);
		  setRegistryName(name);
		  setCreativeTab(tab);
		  Main.proxy.registerItemRenderer(this, 0, name);
		 }
		 
		 public CustomItems(String name, CreativeTabs tab, int stacksize){
		  setUnlocalizedName(name);
		  setRegistryName(name);
		  setCreativeTab(tab);
		  setMaxStackSize(stacksize);
		 }
}
