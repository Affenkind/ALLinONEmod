package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockMagma extends Block {
	
	public BlockMagma() {
		super(Material.rock);
		setHardness(1.0F);
		setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public void onLanded(World worldIn, Entity entityIn) {
		if(entityIn instanceof EntityPlayer && !worldIn.isRemote && !entityIn.isSneaking()) {
			EntityPlayer player = (EntityPlayer) entityIn;
			player.setFire(4);
		}
	}

}
