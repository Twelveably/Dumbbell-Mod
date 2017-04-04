package com.bagasmc.gym.items;

import java.util.List;

import com.bagasmc.gym.Main;
import com.bagasmc.gym.blocks.BlockDumbbell;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DumbbellGym extends Item {
	
	private int numberOfClicks = 0;
	private int coolDown = 60;
	private int exerciseDone = 0;
	private int dvdr = 10;
	private int time = 12000;
	public int power = 0;
	private boolean cDTF = false;
	
		 public DumbbellGym(String name, CreativeTabs tab, int stacksize){
		  setUnlocalizedName(name);
		  setRegistryName(name);
		  setCreativeTab(tab);
		  setMaxStackSize(stacksize);
		  Main.proxy.registerItemRenderer(this, 0, name);
		 }
		 
		 @Override
		 public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) {
		  list.add("     STAMINA     ");
		  list.add("3 kilos   6.6 lbs");
		 }
		 
		 @Override
		 public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
			 if(cDTF == false) {
			 ItemStack itemStack = playerIn.getHeldItem(hand);
			 numberOfClicks = numberOfClicks + 1;
			 playerIn.swingArm(hand);
			 coolDown = 60;
		 	 cDTF = true;
			 }
		 	 return super.onItemRightClick(worldIn, playerIn, hand);
		}
		 
		 @Override
		 public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected) {
			 if(cDTF == true) {
				 coolDown--;
			 }
			 
			 if(coolDown < 0) {
				 cDTF = false;
			 }
             if (entity instanceof EntityPlayer)
		    	 
		     {          EntityPlayer Player = (EntityPlayer) entity;
			 if(Player.getHeldItemMainhand() != null && Player.getHeldItemMainhand().getItem() instanceof DumbbellGym)
	          {
				 Player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1, 2, false, false));
	          } else {
	        	 Player.removeActivePotionEffect(MobEffects.SLOWNESS);
	        	 Player.removePotionEffect(MobEffects.SLOWNESS);
	          }
		     }
			 if(numberOfClicks > dvdr) {
			 if (entity instanceof EntityPlayer)
		    	 
		     {          EntityPlayer Player = (EntityPlayer) entity;
		          if(Player.getHeldItemMainhand() != null && Player.getHeldItemMainhand().getItem() instanceof DumbbellGym)
		          {
		        	  if(exerciseDone < 3)
		        	  {
		        	  power = power + 1;
		        	  }
		        	  time = time + 3000;
		        	  Player.addPotionEffect(new PotionEffect(Potion.getPotionById(5), time, power, false, false));
		        	  exerciseDone = exerciseDone + 1;
		        	  dvdr = dvdr + 30;
		        	  numberOfClicks = 0;
		          }
		     }
		          else 
		          { 
		        	  
		          }
		     }	 
		}
		 
		 public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
		    {
		        boolean flag = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos);
		        BlockPos blockpos = flag ? pos : pos.offset(facing);
		        ItemStack itemstack = player.getHeldItem(hand);

		        if (player.canPlayerEdit(blockpos, facing, itemstack) && worldIn.mayPlace(worldIn.getBlockState(blockpos).getBlock(), blockpos, false, facing, (Entity)null))
		        {
		            itemstack.shrink(1);
		            worldIn.setBlockState(blockpos, BlockDumbbell.DumbbellBlock.getDefaultState());
		            worldIn.playSound(player, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 5F, 2F);
		            return EnumActionResult.SUCCESS;
		        }
		        else
		        {
		            return EnumActionResult.FAIL;
		        }
		    }
		}
