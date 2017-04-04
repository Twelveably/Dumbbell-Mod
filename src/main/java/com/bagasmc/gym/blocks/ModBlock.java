package com.bagasmc.gym.blocks;

import java.util.Random;

import com.bagasmc.gym.items.DumbBell;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModBlock extends Block {

	public static final PropertyDirection FACING = BlockDirectional.FACING;
	
	public ModBlock(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest, String tool) {
		  super(mat);
		  setUnlocalizedName(name);
		  setRegistryName(name);
		  setCreativeTab(tab);
		  setHardness(hardness);
		  setResistance(resistance);
		  setHarvestLevel(tool, harvest);
		 }
		 
		 public ModBlock(Material mat, String name, CreativeTabs tab, float hardness, float resistance) {
		  super(mat);
		  setUnlocalizedName(name);
		  setRegistryName(name);
		  setCreativeTab(tab);
		  setHardness(hardness);
		  setResistance(resistance);
		  setDefaultState(BlockDumbbell.DumbbellBlock.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH));
		 }
		 
		 @Override
		  public boolean isOpaqueCube(IBlockState iBlockState) {
		    return false;
		  }

		  @Override
		  public boolean isFullCube(IBlockState iBlockState) {
		    return false;
		  }
		  
		  @Override
		  public boolean isFullBlock(IBlockState iBlockState) {
			return false;
		  }
		  
		  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			  return DumbBell.dumbBell;
			 }
		  
		  public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
		    {
		        super.onBlockAdded(worldIn, pos, state);
		        this.setDefaultDirection(worldIn, pos, state);
		    }

		    private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state)
		    {
		        if (!worldIn.isRemote)
		        {
		            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
		            boolean flag = worldIn.getBlockState(pos.north()).isFullBlock();
		            boolean flag1 = worldIn.getBlockState(pos.south()).isFullBlock();

		            if (enumfacing == EnumFacing.NORTH && flag && !flag1)
		            {
		                enumfacing = EnumFacing.SOUTH;
		            }
		            else if (enumfacing == EnumFacing.SOUTH && flag1 && !flag)
		            {
		                enumfacing = EnumFacing.NORTH;
		            }
		            else
		            {
		                boolean flag2 = worldIn.getBlockState(pos.west()).isFullBlock();
		                boolean flag3 = worldIn.getBlockState(pos.east()).isFullBlock();

		                if (enumfacing == EnumFacing.WEST && flag2 && !flag3)
		                {
		                    enumfacing = EnumFacing.EAST;
		                }
		                else if (enumfacing == EnumFacing.EAST && flag3 && !flag2)
		                {
		                    enumfacing = EnumFacing.WEST;
		                }
		            }

		            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		        }
		    }
		    
		    public IBlockState getStateFromMeta(int meta)
		    {
		        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
		    }

		     //* Convert the BlockState into the correct metadata value

		    public int getMetaFromState(IBlockState state)
		    {
		        int i = 0;
		        i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

		        return i;
		    }

		    public IBlockState withRotation(IBlockState state, Rotation rot)
		    {
		        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
		    }

		    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
		    {
		        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
		    }

		    protected BlockStateContainer createBlockState()
		    {
		        return new BlockStateContainer(this, new IProperty[] {FACING});
		    }
}