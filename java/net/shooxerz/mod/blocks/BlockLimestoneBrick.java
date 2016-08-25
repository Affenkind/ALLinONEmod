package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLimestoneBrick extends Block {
	
	public BlockLimestoneBrick() {
		super(Material.rock);
		setHardness(1.5F);
		setHarvestLevel("pickaxe", 0);
	}

}
