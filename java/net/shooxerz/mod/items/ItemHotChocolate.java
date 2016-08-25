package net.shooxerz.mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.shooxerz.mod.ALLinONEmod;

public class ItemHotChocolate extends ItemFood {

	public ItemHotChocolate() {
		super(6, false);
		setMaxStackSize(1);
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        super.onItemUseFinish(stack, worldIn, playerIn);
        return new ItemStack(ALLinONEmod.cup);
    }

}
