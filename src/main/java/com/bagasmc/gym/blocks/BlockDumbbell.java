package com.bagasmc.gym.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockDumbbell {
	
	public static Block DumbbellBlock;
	public static ItemBlock itemDumbbellBlock;
	IBlockState iblockstate = DumbbellBlock.getDefaultState();

	public static void init(){
		DumbbellBlock = new BlockCreate(Material.SAND, "dumbbelltile", CreativeTabs.MISC, 5F, 0.1F, 3, "hand");
		itemDumbbellBlock = (ItemBlock) new ItemBlock(DumbbellBlock);
		
	 }
	 
	 public static void register(){
		 GameRegistry.register(DumbbellBlock);
		 GameRegistry.register(itemDumbbellBlock, DumbbellBlock.getRegistryName());
	 }
	 
	 public static void registerRenders(){
		 registerRender(DumbbellBlock);
	 }
	 
	 public static void registerRender(Block block){
		 Item item = Item.getItemFromBlock(block);
		 Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	 }
}
