package com.bagasmc.gym.handlers;

import com.bagasmc.gym.items.DumbBell;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabHandler {
	public static CreativeTabs tabBlocks = new CreativeTabs("gym") {

		  public ItemStack getTabIconItem() {
			  return new ItemStack(DumbBell.dumbBell);
		  }
		 };
}
