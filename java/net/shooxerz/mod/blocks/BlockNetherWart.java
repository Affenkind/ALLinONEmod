package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNetherWart extends Block {
	
	public BlockNetherWart() {
		super(Material.rock);
		setHardness(0.7F);
		setHarvestLevel("pickaxe", 0);
	}

}
