package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockBone extends Block {
	
	public BlockBone() {
		super(Material.rock);
		setHardness(0.7F);
		setStepSound(Block.soundTypeWood);
		setHarvestLevel("pickaxe", 0);
	}

}
