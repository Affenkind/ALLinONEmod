package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMarble extends Block {
	
	public BlockMarble() {
		super(Material.rock);
		setHardness(1.5F);
		setHarvestLevel("pickaxe", 0);
	}

}
