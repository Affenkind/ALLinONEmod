package net.shooxerz.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMigmatite extends Block {
	
	public BlockMigmatite() {
		super(Material.rock);
		setHardness(1.5F);
		setHarvestLevel("pickaxe", 0);
	}

}
