package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCompressedDirt extends Block {
	
	public BlockCompressedDirt() {
		
		super(Material.sand);
		setHarvestLevel("spade", 1);
		
	}

}
