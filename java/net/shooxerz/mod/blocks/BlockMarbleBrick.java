package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMarbleBrick extends Block {
	
	public BlockMarbleBrick() {
		super(Material.rock);
		setHardness(1.5F);
		setHarvestLevel("pickaxe", 0);
	}

}
