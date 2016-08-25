package net.shooxerz.mod.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.shooxerz.mod.ALLinONEmod;

public class ItemRubyArmor extends ItemArmor {

	public ItemRubyArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		
		switch(armorType) {
		case 0: setUnlocalizedName("ruby_helmet"); break;
		case 1: setUnlocalizedName("ruby_chestplate"); break;
		case 2: setUnlocalizedName("ruby_leggins"); break;
		case 3: setUnlocalizedName("ruby_boots"); break;
		}
		
		setCreativeTab(ALLinONEmod.aotab);
	}
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return super.getIsRepairable(toRepair, new ItemStack(ALLinONEmod.ruby));
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) { 
		if(slot == 0 || slot == 1 || slot == 3) {
			return "allinonemod:textures/models/armor/ruby_layer_1.png";
		} else if(slot == 2) {
			return "allinonemod:textures/models/armor/ruby_layer_2.png";
		} else {
			return null;
		}
	}

}
