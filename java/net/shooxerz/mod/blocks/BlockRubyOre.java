package net.shooxerz.mod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.shooxerz.mod.ALLinONEmod;

public class BlockRubyOre extends Block {
	
	public BlockRubyOre() {
		super(Material.rock);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", 1);
	}
	@Override
	public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(3);
    }
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ALLinONEmod.ruby;
    }

}
