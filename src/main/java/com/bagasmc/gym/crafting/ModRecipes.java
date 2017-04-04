package com.bagasmc.gym.crafting;

import com.bagasmc.gym.items.DumbBell;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(DumbBell.dumbBell), "III", " I ", "III", 'I', Items.IRON_INGOT);
		GameRegistry.addRecipe(new ItemStack(DumbBell.dumbBell), "I I", "III", "I I", 'I', Items.IRON_INGOT);		
	}
}
