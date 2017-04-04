package com.bagasmc.gym.items;

import java.util.List;

import com.bagasmc.gym.handlers.CreativeTabHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DumbBell extends Item {
	public static Item dumbBell;
	
	public static void init(){
	dumbBell = new CustomItem("dumbbell", CreativeTabHandler.tabBlocks, 1);
	}
}

