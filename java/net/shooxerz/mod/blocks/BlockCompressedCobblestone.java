package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCompressedCobblestone extends Block {
	
	public BlockCompressedCobblestone() {
		
		super(Material.rock);
		setHarvestLevel("pickaxe", 2);
		
	}

}
