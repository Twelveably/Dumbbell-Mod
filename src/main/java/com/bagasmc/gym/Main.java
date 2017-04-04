package com.bagasmc.gym;

import com.bagasmc.gym.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Main.MODID, name=Main.NAME, version=Main.VERSION)

public class Main {
	
	@SidedProxy(clientSide=Main.CLIENT_PROXY, serverSide=Main.SERVER_PROXY)
	public static CommonProxy proxy;
	
	public static final String MODID = "gymmod";
	public static final String NAME = "Gym Mod";
	public static final String VERSION = "0.1";
	public static final String CLIENT_PROXY = "com.bagasmc.gym.proxy.ClientProxy";
	public static final String SERVER_PROXY = "com.bagasmc.gym.proxy.CommonProxy";
	
	@EventHandler
	 public void preInit(FMLPreInitializationEvent event){
	  proxy.preInit();
	 }
	 
	 @EventHandler
	 public void init(FMLInitializationEvent event){
	  proxy.init();
	 }
	 
	 @EventHandler
	 public void postInit(FMLPostInitializationEvent event){
	  proxy.postInit();
	 }
}
