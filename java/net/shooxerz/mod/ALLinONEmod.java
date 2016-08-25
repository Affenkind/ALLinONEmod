package net.shooxerz.mod;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor.EnumHingePosition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.shooxerz.mod.blocks.BlockBone;
import net.shooxerz.mod.blocks.BlockCompressedCobblestone;
import net.shooxerz.mod.blocks.BlockCompressedDirt;
import net.shooxerz.mod.blocks.BlockLimestone;
import net.shooxerz.mod.blocks.BlockLimestoneBrick;
import net.shooxerz.mod.blocks.BlockLimestoneCobble;
import net.shooxerz.mod.blocks.BlockMagma;
import net.shooxerz.mod.blocks.BlockMarble;
import net.shooxerz.mod.blocks.BlockMarbleBrick;
import net.shooxerz.mod.blocks.BlockMigmatite;
import net.shooxerz.mod.blocks.BlockMigmatiteBrick;
import net.shooxerz.mod.blocks.BlockMigmatiteCobble;
import net.shooxerz.mod.blocks.BlockNetherWart;
import net.shooxerz.mod.blocks.BlockRubyOre;
import net.shooxerz.mod.blocks.BlockSapphireOre;
import net.shooxerz.mod.items.AOAxe;
import net.shooxerz.mod.items.AOHoe;
import net.shooxerz.mod.items.AOPickaxe;
import net.shooxerz.mod.items.AOSpade;
import net.shooxerz.mod.items.AOSword;
import net.shooxerz.mod.items.ItemChocolate;
import net.shooxerz.mod.items.ItemCup;
import net.shooxerz.mod.items.ItemCupOfChocolate;
import net.shooxerz.mod.items.ItemHotChocolate;
import net.shooxerz.mod.items.ItemRuby;
import net.shooxerz.mod.items.ItemRubyArmor;
import net.shooxerz.mod.items.ItemSapphire;

@Mod(modid = ALLinONEmod.MODID, version = ALLinONEmod.VERSION)
public class ALLinONEmod
{
    public static final String MODID = "allinonemod";
    public static final String VERSION = "1.0";
    
    /*Items*/
    public static Item ruby;
    public static Item sapphire;
    public static Item chocolate;
    public static Item cup;
    public static Item cup_of_chocolate;
    public static Item hot_chocolate;
    /*Blocks*/
    public static Block marble;
    public static Block marble_brick;
    public static Block bone_block;
    public static Block limestone_brick;
    public static Block limestone_cobble;
    public static Block limestone;
    public static Block magma;
    public static Block migmatite_brick;
    public static Block migmatite_cobble;
    public static Block migmatite;
    public static Block nether_wart_block;
    public static Block ruby_ore;
    public static Block sapphire_ore;
    public static Block compressed_cobblestone;
    public static Block double_compressed_cobblestone;
    public static Block triple_compressed_cobblestone;
    public static Block quadruple_compressed_cobblestone;
    public static Block quintuple_compressed_cobblestone;
    public static Block sextuple_compressed_cobblestone;
    public static Block septuple_compressed_cobblestone;
    public static Block octuple_compressed_cobblestone;
    public static Block compressed_sand;
    public static Block double_compressed_sand;
    public static Block triple_compressed_sand;
    public static Block quadruple_compressed_sand;
    public static Block quintuple_compressed_sand;
    public static Block sextuple_compressed_sand;
    public static Block septuple_compressed_sand;
    public static Block octuple_compressed_sand;
    public static Block compressed_dirt;
    public static Block double_compressed_dirt;
    public static Block triple_compressed_dirt;
    public static Block quadruple_compressed_dirt;
    public static Block quintuple_compressed_dirt;
    public static Block sextuple_compressed_dirt;
    public static Block septuple_compressed_dirt;
    public static Block octuple_compressed_dirt;
    public static Block compressed_gravel;
    public static Block double_compressed_gravel;
    public static Block triple_compressed_gravel;
    public static Block quadruple_compressed_gravel;
    public static Block quintuple_compressed_gravel;
    public static Block sextuple_compressed_gravel;
    public static Block septuple_compressed_gravel;
    public static Block octuple_compressed_gravel;
    
    /*Materials*/
    public static ToolMaterial RUBY;
    public static ToolMaterial SAPPHIRE;
    public static ArmorMaterial RUBY_ARMOR;
    public static ArmorMaterial SAPPHIRE_ARMOR;
    
    /*Armor*/
    public static Item ruby_helmet;
    public static Item ruby_chestplate;
    public static Item ruby_leggins;
    public static Item ruby_boots;
    
    /*Tools*/
    public static Item ruby_axe;
    public static Item ruby_pickaxe;
    public static Item ruby_spade;
    public static Item ruby_hoe;
    public static Item ruby_sword;
    public static Item sapphire_axe;
    public static Item sapphire_pickaxe;
    public static Item sapphire_spade;
    public static Item sapphire_hoe;
    public static Item sapphire_sword;
    
    /*Other*/
    public static CreativeTabs aotab;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	/*Other*/
    	aotab = new CreativeTabs("aotab") {
			
			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(magma);
			}
		};
    	/*Materials*/
		/**Name, HarvestLevel, MaxUses, Efficiency, Damage, Enchantability*/
		RUBY = EnumHelper.addToolMaterial("ruby_tool", 3, 380, 6.5F, 2.8F, 12).setRepairItem(new ItemStack(ALLinONEmod.ruby, 1));
		SAPPHIRE = EnumHelper.addToolMaterial("sapphire_tool", 2, 300, 6.0F, 2.5F, 12).setRepairItem(new ItemStack(ALLinONEmod.ruby, 1));
		/**Name, TextureName, Durability, reductionAmounts, Enchantability*/
		RUBY_ARMOR = EnumHelper.addArmorMaterial("ruby_armor", "placeholder", 20, new int[]{2, 7, 6, 3}, 9);
		RUBY_ARMOR.customCraftingMaterial = ruby;
		SAPPHIRE_ARMOR = EnumHelper.addArmorMaterial("sapphire_armor", "placeholder", 20, new int[]{3, 6, 5, 3}, 9);
		/*Tools*/
		ruby_axe = new AOAxe(ALLinONEmod.RUBY).setUnlocalizedName("ruby_axe").setCreativeTab(ALLinONEmod.aotab);
		ruby_pickaxe = new AOPickaxe(ALLinONEmod.RUBY).setUnlocalizedName("ruby_pickaxe").setCreativeTab(ALLinONEmod.aotab);
		ruby_spade = new AOSpade(ALLinONEmod.RUBY).setUnlocalizedName("ruby_spade").setCreativeTab(ALLinONEmod.aotab);
		ruby_hoe = new AOHoe(ALLinONEmod.RUBY).setUnlocalizedName("ruby_hoe").setCreativeTab(ALLinONEmod.aotab);
		ruby_sword = new AOSword(ALLinONEmod.RUBY).setUnlocalizedName("ruby_sword").setCreativeTab(ALLinONEmod.aotab);
		sapphire_axe = new AOAxe(ALLinONEmod.SAPPHIRE).setUnlocalizedName("sapphire_axe").setCreativeTab(ALLinONEmod.aotab);
		sapphire_pickaxe = new AOPickaxe(ALLinONEmod.SAPPHIRE).setUnlocalizedName("sapphire_pickaxe").setCreativeTab(ALLinONEmod.aotab);
		sapphire_spade = new AOSpade(ALLinONEmod.SAPPHIRE).setUnlocalizedName("sapphire_spade").setCreativeTab(ALLinONEmod.aotab);
		sapphire_hoe = new AOHoe(ALLinONEmod.SAPPHIRE).setUnlocalizedName("sapphire_hoe").setCreativeTab(ALLinONEmod.aotab);
		sapphire_sword = new AOSword(ALLinONEmod.SAPPHIRE).setUnlocalizedName("sapphire_sword").setCreativeTab(ALLinONEmod.aotab);
    	/*Armor*/
		ruby_helmet = new ItemRubyArmor(RUBY_ARMOR, 0, 0);
		ruby_chestplate = new ItemRubyArmor(RUBY_ARMOR, 0, 1);
		ruby_leggins = new ItemRubyArmor(RUBY_ARMOR, 0, 2);
		ruby_boots = new ItemRubyArmor(RUBY_ARMOR, 0, 3);
		/*Items*/
    	ruby = new ItemRuby().setUnlocalizedName("ruby").setCreativeTab(ALLinONEmod.aotab);
    	sapphire = new ItemSapphire().setUnlocalizedName("sapphire").setCreativeTab(ALLinONEmod.aotab);
    	chocolate = new ItemChocolate().setUnlocalizedName("chocolate").setCreativeTab(ALLinONEmod.aotab);
    	cup = new ItemCup().setUnlocalizedName("cup").setCreativeTab(ALLinONEmod.aotab);
    	cup_of_chocolate = new ItemCupOfChocolate().setUnlocalizedName("cup_of_chocolate").setCreativeTab(ALLinONEmod.aotab);
    	hot_chocolate = new ItemHotChocolate().setUnlocalizedName("hot_chocolate").setCreativeTab(ALLinONEmod.aotab);
    	/*Blocks*/
    	marble = new BlockMarble().setUnlocalizedName("marble").setCreativeTab(ALLinONEmod.aotab);
    	marble_brick = new BlockMarbleBrick().setUnlocalizedName("marble_brick").setCreativeTab(ALLinONEmod.aotab);
    	bone_block = new BlockBone().setUnlocalizedName("bone_block").setCreativeTab(ALLinONEmod.aotab);
    	limestone_brick = new BlockLimestoneBrick().setUnlocalizedName("limestone_brick").setCreativeTab(ALLinONEmod.aotab);
    	limestone_cobble = new BlockLimestoneCobble().setUnlocalizedName("limestone_cobble").setCreativeTab(ALLinONEmod.aotab);
    	limestone = new BlockLimestone().setUnlocalizedName("limestone").setCreativeTab(ALLinONEmod.aotab);
    	magma = new BlockMagma().setUnlocalizedName("magma").setCreativeTab(ALLinONEmod.aotab);
    	migmatite_brick = new BlockMigmatiteBrick().setUnlocalizedName("migmatite_brick").setCreativeTab(ALLinONEmod.aotab);
    	migmatite_cobble = new BlockMigmatiteCobble().setUnlocalizedName("migmatite_cobble").setCreativeTab(ALLinONEmod.aotab);
    	migmatite = new BlockMigmatite().setUnlocalizedName("migmatite").setCreativeTab(ALLinONEmod.aotab);
    	nether_wart_block = new BlockNetherWart().setUnlocalizedName("nether_wart_block").setCreativeTab(ALLinONEmod.aotab);
    	ruby_ore = new BlockRubyOre().setUnlocalizedName("ruby_ore").setCreativeTab(ALLinONEmod.aotab);
    	sapphire_ore = new BlockSapphireOre().setUnlocalizedName("sapphire_ore").setCreativeTab(ALLinONEmod.aotab);
    	/**Compressed Blocks*/
    	compressed_cobblestone = new BlockCompressedCobblestone().setUnlocalizedName("compressed_cobblestone")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(3.0F).setResistance(0.525F);
    	double_compressed_cobblestone = new BlockCompressedCobblestone().setUnlocalizedName("double_compressed_cobblestone")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(12.0F).setResistance(2.1F);
    	triple_compressed_cobblestone = new BlockCompressedCobblestone().setUnlocalizedName("triple_compressed_cobblestone")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(27.0F).setResistance(4.725F);
    	quadruple_compressed_cobblestone = new BlockCompressedCobblestone().setUnlocalizedName("quadruple_compressed_cobblestone")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(48.0F).setResistance(8.4F);
    	quintuple_compressed_cobblestone = new BlockCompressedCobblestone().setUnlocalizedName("quintuple_compressed_cobblestone")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(75.0F).setResistance(12.125F);
    	sextuple_compressed_cobblestone = new BlockCompressedCobblestone().setUnlocalizedName("sextuple_compressed_cobblestone")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(108.0F).setResistance(18.9F);
    	septuple_compressed_cobblestone = new BlockCompressedCobblestone().setUnlocalizedName("septuple_compressed_cobblestone")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(147.0F).setResistance(25.725F);
    	octuple_compressed_cobblestone = new BlockCompressedCobblestone().setUnlocalizedName("octuple_compressed_cobblestone")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(192.0F).setResistance(33.6F);
    	compressed_dirt = new BlockCompressedDirt().setUnlocalizedName("compressed_dirt")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(0.4F).setResistance(0.07F);
    	double_compressed_dirt = new BlockCompressedDirt().setUnlocalizedName("double_compressed_dirt")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(1.6F).setResistance(0.28F);
    	triple_compressed_dirt = new BlockCompressedDirt().setUnlocalizedName("triple_compressed_dirt")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(3.6F).setResistance(0.63F);
    	quadruple_compressed_dirt = new BlockCompressedDirt().setUnlocalizedName("quadruple_compressed_dirt")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(6.4F).setResistance(1.12F);
    	quintuple_compressed_dirt = new BlockCompressedDirt().setUnlocalizedName("quintuple_compressed_dirt")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(10.0F).setResistance(1.75F);
    	sextuple_compressed_dirt = new BlockCompressedDirt().setUnlocalizedName("sextuple_compressed_dirt")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(14.4F).setResistance(2.52F);
    	septuple_compressed_dirt = new BlockCompressedDirt().setUnlocalizedName("septuple_compressed_dirt")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(19.6F).setResistance(3.43F);
    	octuple_compressed_dirt = new BlockCompressedDirt().setUnlocalizedName("octuple_compressed_dirt")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(25.6F).setResistance(4.48F);
    	compressed_sand = new BlockCompressedDirt().setUnlocalizedName("compressed_sand")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(0.4F).setResistance(0.07F);
    	double_compressed_sand = new BlockCompressedDirt().setUnlocalizedName("double_compressed_sand")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(1.6F).setResistance(0.28F);
    	triple_compressed_sand = new BlockCompressedDirt().setUnlocalizedName("triple_compressed_sand")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(3.6F).setResistance(0.63F);
    	quadruple_compressed_sand = new BlockCompressedDirt().setUnlocalizedName("quadruple_compressed_sand")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(6.4F).setResistance(1.12F);
    	quintuple_compressed_sand = new BlockCompressedDirt().setUnlocalizedName("quintuple_compressed_sand")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(10.0F).setResistance(1.75F);
    	sextuple_compressed_sand = new BlockCompressedDirt().setUnlocalizedName("sextuple_compressed_sand")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(14.4F).setResistance(2.52F);
    	septuple_compressed_sand = new BlockCompressedDirt().setUnlocalizedName("septuple_compressed_sand")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(19.6F).setResistance(3.43F);
    	octuple_compressed_sand = new BlockCompressedDirt().setUnlocalizedName("octuple_compressed_sand")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(25.6F).setResistance(4.48F);
    	compressed_gravel = new BlockCompressedDirt().setUnlocalizedName("compressed_gravel")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(0.4F).setResistance(0.07F);
    	double_compressed_gravel = new BlockCompressedDirt().setUnlocalizedName("double_compressed_gravel")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(1.6F).setResistance(0.28F);
    	triple_compressed_gravel = new BlockCompressedDirt().setUnlocalizedName("triple_compressed_gravel")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(3.6F).setResistance(0.63F);
    	quadruple_compressed_gravel = new BlockCompressedDirt().setUnlocalizedName("quadruple_compressed_gravel")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(6.4F).setResistance(1.12F);
    	quintuple_compressed_gravel = new BlockCompressedDirt().setUnlocalizedName("quintuple_compressed_gravel")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(10.0F).setResistance(1.75F);
    	sextuple_compressed_gravel = new BlockCompressedDirt().setUnlocalizedName("sextuple_compressed_gravel")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(14.4F).setResistance(2.52F);
    	septuple_compressed_gravel = new BlockCompressedDirt().setUnlocalizedName("septuple_compressed_gravel")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(19.6F).setResistance(3.43F);
    	octuple_compressed_gravel = new BlockCompressedDirt().setUnlocalizedName("octuple_compressed_gravel")
    			.setCreativeTab(ALLinONEmod.aotab).setHardness(25.6F).setResistance(4.48F);
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {						
    	removeRecipes();
    	registerItems();
    	registerBlocks();
    	
    	/**##############**/
    	/**### Stacks ###**/
    	/**##############**/
    	ItemStack stackString4 = new ItemStack(Items.string, 4);
    	ItemStack stackWool = new ItemStack(Blocks.wool);
    	ItemStack stackCobweb = new ItemStack(Blocks.web);
    	ItemStack stackString = new ItemStack(Items.string);
    	ItemStack stackRuby = new ItemStack(ALLinONEmod.ruby);
    	ItemStack stackSapphire = new ItemStack(ALLinONEmod.sapphire);
    	ItemStack stackMarble = new ItemStack(ALLinONEmod.marble);
    	ItemStack stackMarbleBrick4 = new ItemStack(ALLinONEmod.marble_brick, 4);
    	ItemStack stackBoneBlock = new ItemStack(ALLinONEmod.bone_block);
    	ItemStack stackLimestoneBrick4 = new ItemStack(ALLinONEmod.limestone_brick, 4);
    	ItemStack stackLimestoneCobble = new ItemStack(ALLinONEmod.limestone_cobble);
    	ItemStack stackLimestone = new ItemStack(ALLinONEmod.limestone);
    	ItemStack stackMagma = new ItemStack(ALLinONEmod.magma);
    	ItemStack stackMigmatiteBrick4 = new ItemStack(ALLinONEmod.migmatite_brick, 4);
    	ItemStack stackMigmatiteCobble = new ItemStack(ALLinONEmod.migmatite_cobble);
    	ItemStack stackMigmatite = new ItemStack(ALLinONEmod.migmatite);
    	ItemStack stackNetherWartBlock = new ItemStack(ALLinONEmod.nether_wart_block);
    	ItemStack stackRubyOre = new ItemStack(ALLinONEmod.ruby_ore);
    	ItemStack stackSapphireOre = new ItemStack(ALLinONEmod.sapphire_ore);
    	ItemStack stackChocolate = new ItemStack(ALLinONEmod.chocolate);
    	ItemStack stackCup = new ItemStack(ALLinONEmod.cup);
    	ItemStack stackCupOfChocolate = new ItemStack(ALLinONEmod.cup_of_chocolate);
    	ItemStack stackHotChocolate = new ItemStack(ALLinONEmod.hot_chocolate);
    	ItemStack stackBrick = new ItemStack(Items.brick);
    	ItemStack stackCocoaBeans = new ItemStack(Items.dye,1 , 3);
    	ItemStack stackSugar = new ItemStack(Items.sugar);
    	ItemStack stackNetherWart = new ItemStack(Items.nether_wart);
    	ItemStack stackNetherWart9 = new ItemStack(Items.nether_wart, 9);
    	ItemStack stackBone = new ItemStack(Items.bone);
    	ItemStack stackBone9 = new ItemStack(Items.bone, 9);
    	ItemStack stackSlimeBall = new ItemStack(Items.slime_ball);
    	ItemStack stackSlimeBall4 = new ItemStack(Items.slime_ball, 4);
    	ItemStack stackSlimeBlock = new ItemStack(Blocks.slime_block);
    	ItemStack stackCompressedCobblestone = new ItemStack(ALLinONEmod.compressed_cobblestone);
    	ItemStack stackDoubleCompressedCobblestone = new ItemStack(ALLinONEmod.double_compressed_cobblestone);
    	ItemStack stackTripleCompressedCobblestone = new ItemStack(ALLinONEmod.triple_compressed_cobblestone);
    	ItemStack stackQuadrupleCompressedCobblestone = new ItemStack(ALLinONEmod.quadruple_compressed_cobblestone);
    	ItemStack stackQuintupleCompressedCobblestone = new ItemStack(ALLinONEmod.quintuple_compressed_cobblestone);
    	ItemStack stackSextupleCompressedCobblestone = new ItemStack(ALLinONEmod.sextuple_compressed_cobblestone);
    	ItemStack stackSeptupleCompressedCobblestone = new ItemStack(ALLinONEmod.septuple_compressed_cobblestone);
    	ItemStack stackOctupleCompressedCobblestone = new ItemStack(ALLinONEmod.octuple_compressed_cobblestone);
    	ItemStack stackCompressedDirt = new ItemStack(ALLinONEmod.compressed_dirt);
    	ItemStack stackDoubleCompressedDirt = new ItemStack(ALLinONEmod.double_compressed_dirt);
    	ItemStack stackTripleCompressedDirt = new ItemStack(ALLinONEmod.triple_compressed_dirt);
    	ItemStack stackQuadrupleCompressedDirt = new ItemStack(ALLinONEmod.quadruple_compressed_dirt);
    	ItemStack stackQuintupleCompressedDirt = new ItemStack(ALLinONEmod.quintuple_compressed_dirt);
    	ItemStack stackSextupleCompressedDirt = new ItemStack(ALLinONEmod.sextuple_compressed_dirt);
    	ItemStack stackSeptupleCompressedDirt = new ItemStack(ALLinONEmod.septuple_compressed_dirt);
    	ItemStack stackOctupleCompressedDirt = new ItemStack(ALLinONEmod.octuple_compressed_dirt);
    	ItemStack stackCompressedSand = new ItemStack(ALLinONEmod.compressed_sand);
    	ItemStack stackDoubleCompressedSand = new ItemStack(ALLinONEmod.double_compressed_sand);
    	ItemStack stackTripleCompressedSand = new ItemStack(ALLinONEmod.triple_compressed_sand);
    	ItemStack stackQuadrupleCompressedSand = new ItemStack(ALLinONEmod.quadruple_compressed_sand);
    	ItemStack stackQuintupleCompressedSand = new ItemStack(ALLinONEmod.quintuple_compressed_sand);
    	ItemStack stackSextupleCompressedSand = new ItemStack(ALLinONEmod.sextuple_compressed_sand);
    	ItemStack stackSeptupleCompressedSand = new ItemStack(ALLinONEmod.septuple_compressed_sand);
    	ItemStack stackOctupleCompressedSand = new ItemStack(ALLinONEmod.octuple_compressed_sand);
    	ItemStack stackCompressedGravel = new ItemStack(ALLinONEmod.compressed_gravel);
    	ItemStack stackDoubleCompressedGravel = new ItemStack(ALLinONEmod.double_compressed_gravel);
    	ItemStack stackTripleCompressedGravel = new ItemStack(ALLinONEmod.triple_compressed_gravel);
    	ItemStack stackQuadrupleCompressedGravel = new ItemStack(ALLinONEmod.quadruple_compressed_gravel);
    	ItemStack stackQuintupleCompressedGravel = new ItemStack(ALLinONEmod.quintuple_compressed_gravel);
    	ItemStack stackSextupleCompressedGravel = new ItemStack(ALLinONEmod.sextuple_compressed_gravel);
    	ItemStack stackSeptupleCompressedGravel = new ItemStack(ALLinONEmod.septuple_compressed_gravel);
    	ItemStack stackOctupleCompressedGravel = new ItemStack(ALLinONEmod.octuple_compressed_gravel);
    	ItemStack stackCobblestone = new ItemStack(Blocks.cobblestone);
    	ItemStack stackDirt = new ItemStack(Blocks.dirt);
    	ItemStack stackSand = new ItemStack(Blocks.sand);
    	ItemStack stackGravel = new ItemStack(Blocks.gravel);
    	ItemStack stackCompressedCobblestone9 = new ItemStack(ALLinONEmod.compressed_cobblestone, 9);
    	ItemStack stackDoubleCompressedCobblestone9 = new ItemStack(ALLinONEmod.double_compressed_cobblestone, 9);
    	ItemStack stackTripleCompressedCobblestone9 = new ItemStack(ALLinONEmod.triple_compressed_cobblestone, 9);
    	ItemStack stackQuadrupleCompressedCobblestone9 = new ItemStack(ALLinONEmod.quadruple_compressed_cobblestone, 9);
    	ItemStack stackQuintupleCompressedCobblestone9 = new ItemStack(ALLinONEmod.quintuple_compressed_cobblestone, 9);
    	ItemStack stackSextupleCompressedCobblestone9 = new ItemStack(ALLinONEmod.sextuple_compressed_cobblestone, 9);
    	ItemStack stackSeptupleCompressedCobblestone9 = new ItemStack(ALLinONEmod.septuple_compressed_cobblestone, 9);
    	ItemStack stackOctupleCompressedCobblestone9 = new ItemStack(ALLinONEmod.octuple_compressed_cobblestone, 9);
    	ItemStack stackCompressedDirt9 = new ItemStack(ALLinONEmod.compressed_dirt, 9);
    	ItemStack stackDoubleCompressedDirt9 = new ItemStack(ALLinONEmod.double_compressed_dirt, 9);
    	ItemStack stackTripleCompressedDirt9 = new ItemStack(ALLinONEmod.triple_compressed_dirt, 9);
    	ItemStack stackQuadrupleCompressedDirt9 = new ItemStack(ALLinONEmod.quadruple_compressed_dirt, 9);
    	ItemStack stackQuintupleCompressedDirt9 = new ItemStack(ALLinONEmod.quintuple_compressed_dirt, 9);
    	ItemStack stackSextupleCompressedDirt9 = new ItemStack(ALLinONEmod.sextuple_compressed_dirt, 9);
    	ItemStack stackSeptupleCompressedDirt9 = new ItemStack(ALLinONEmod.septuple_compressed_dirt, 9);
    	ItemStack stackOctupleCompressedDirt9 = new ItemStack(ALLinONEmod.octuple_compressed_dirt, 9);
    	ItemStack stackCompressedSand9 = new ItemStack(ALLinONEmod.compressed_sand, 9);
    	ItemStack stackDoubleCompressedSand9 = new ItemStack(ALLinONEmod.double_compressed_sand, 9);
    	ItemStack stackTripleCompressedSand9 = new ItemStack(ALLinONEmod.triple_compressed_sand, 9);
    	ItemStack stackQuadrupleCompressedSand9 = new ItemStack(ALLinONEmod.quadruple_compressed_sand, 9);
    	ItemStack stackQuintupleCompressedSand9 = new ItemStack(ALLinONEmod.quintuple_compressed_sand, 9);
    	ItemStack stackSextupleCompressedSand9 = new ItemStack(ALLinONEmod.sextuple_compressed_sand, 9);
    	ItemStack stackSeptupleCompressedSand9 = new ItemStack(ALLinONEmod.septuple_compressed_sand, 9);
    	ItemStack stackOctupleCompressedSand9 = new ItemStack(ALLinONEmod.octuple_compressed_sand, 9);
    	ItemStack stackCompressedGravel9 = new ItemStack(ALLinONEmod.compressed_gravel, 9);
    	ItemStack stackDoubleCompressedGravel9 = new ItemStack(ALLinONEmod.double_compressed_gravel, 9);
    	ItemStack stackTripleCompressedGravel9 = new ItemStack(ALLinONEmod.triple_compressed_gravel, 9);
    	ItemStack stackQuadrupleCompressedGravel9 = new ItemStack(ALLinONEmod.quadruple_compressed_gravel, 9);
    	ItemStack stackQuintupleCompressedGravel9 = new ItemStack(ALLinONEmod.quintuple_compressed_gravel, 9);
    	ItemStack stackSextupleCompressedGravel9 = new ItemStack(ALLinONEmod.sextuple_compressed_gravel, 9);
    	ItemStack stackSeptupleCompressedGravel9 = new ItemStack(ALLinONEmod.septuple_compressed_gravel, 9);
    	ItemStack stackOctupleCompressedGravel9 = new ItemStack(ALLinONEmod.octuple_compressed_gravel, 9);
    	ItemStack stackCobblestone9 = new ItemStack(Blocks.cobblestone, 9);
    	ItemStack stackDirt9 = new ItemStack(Blocks.dirt, 9);
    	ItemStack stackSand9 = new ItemStack(Blocks.sand, 9);
    	ItemStack stackGravel9 = new ItemStack(Blocks.gravel, 9);
    	ItemStack stackRubyAxe = new ItemStack(ALLinONEmod.ruby_axe);
    	ItemStack stackRubyPickaxe = new ItemStack(ALLinONEmod.ruby_pickaxe);
    	ItemStack stackRubyShovel = new ItemStack(ALLinONEmod.ruby_spade);
    	ItemStack stackRubyHoe = new ItemStack(ALLinONEmod.ruby_hoe);
    	ItemStack stackRubySword = new ItemStack(ALLinONEmod.ruby_sword);
    	ItemStack stackSapphireAxe = new ItemStack(ALLinONEmod.sapphire_axe);
    	ItemStack stackSapphirePickaxe = new ItemStack(ALLinONEmod.sapphire_pickaxe);
    	ItemStack stackSapphireShovel = new ItemStack(ALLinONEmod.sapphire_spade);
    	ItemStack stackSapphireHoe = new ItemStack(ALLinONEmod.sapphire_hoe);
    	ItemStack stackSapphireSword = new ItemStack(ALLinONEmod.sapphire_sword);
    	
    	/**##############**/
    	/**### Shaped ###**/
    	/**##############**/
    	GameRegistry.addShapedRecipe(stackCobweb,"x x"," x ","x x",	'x', stackString);
    	GameRegistry.addShapedRecipe(stackLimestoneBrick4, "xx", "xx",'x', stackLimestone);
    	GameRegistry.addShapedRecipe(stackMarbleBrick4, "xx", "xx",'x', stackMarble);
    	GameRegistry.addShapedRecipe(stackMigmatiteBrick4, "xx", "xx",'x', stackMigmatite);
    	GameRegistry.addShapedRecipe(stackCup, "x x","xxx",'x', stackBrick);
    	GameRegistry.addShapedRecipe(stackChocolate, "xox",'x', stackCocoaBeans, 'o', stackSugar);
    	GameRegistry.addShapedRecipe(stackBoneBlock, "xxx","xxx","xxx",'x', stackBone);
    	GameRegistry.addShapedRecipe(stackNetherWartBlock, "xxx","xxx","xxx",'x', stackNetherWart);
    	GameRegistry.addShapedRecipe(stackSlimeBlock, "xx","xx",'x', stackSlimeBall);
    	GameRegistry.addShapedRecipe(stackCompressedCobblestone, "xxx","xxx","xxx",'x', stackCobblestone);
    	GameRegistry.addShapedRecipe(stackDoubleCompressedCobblestone, "xxx","xxx","xxx",'x', stackCompressedCobblestone);
    	GameRegistry.addShapedRecipe(stackTripleCompressedCobblestone, "xxx","xxx","xxx",'x', stackDoubleCompressedCobblestone);
    	GameRegistry.addShapedRecipe(stackQuadrupleCompressedCobblestone, "xxx","xxx","xxx",'x', stackTripleCompressedCobblestone);
    	GameRegistry.addShapedRecipe(stackQuintupleCompressedCobblestone, "xxx","xxx","xxx",'x', stackQuadrupleCompressedCobblestone);
    	GameRegistry.addShapedRecipe(stackSextupleCompressedCobblestone, "xxx","xxx","xxx",'x', stackQuintupleCompressedCobblestone);
    	GameRegistry.addShapedRecipe(stackSeptupleCompressedCobblestone, "xxx","xxx","xxx",'x', stackSextupleCompressedCobblestone);
    	GameRegistry.addShapedRecipe(stackOctupleCompressedCobblestone, "xxx","xxx","xxx",'x', stackSeptupleCompressedCobblestone);
    	GameRegistry.addShapedRecipe(stackCompressedDirt, "xxx","xxx","xxx",'x', stackDirt);
    	GameRegistry.addShapedRecipe(stackDoubleCompressedDirt, "xxx","xxx","xxx",'x', stackCompressedDirt);
    	GameRegistry.addShapedRecipe(stackTripleCompressedDirt, "xxx","xxx","xxx",'x', stackDoubleCompressedDirt);
    	GameRegistry.addShapedRecipe(stackQuadrupleCompressedDirt, "xxx","xxx","xxx",'x', stackTripleCompressedDirt);
    	GameRegistry.addShapedRecipe(stackQuintupleCompressedDirt, "xxx","xxx","xxx",'x', stackQuadrupleCompressedDirt);
    	GameRegistry.addShapedRecipe(stackSextupleCompressedDirt, "xxx","xxx","xxx",'x', stackQuintupleCompressedDirt);
    	GameRegistry.addShapedRecipe(stackSeptupleCompressedDirt, "xxx","xxx","xxx",'x', stackSextupleCompressedDirt);
    	GameRegistry.addShapedRecipe(stackOctupleCompressedDirt, "xxx","xxx","xxx",'x', stackSeptupleCompressedDirt);
    	GameRegistry.addShapedRecipe(stackCompressedSand, "xxx","xxx","xxx",'x', stackSand);
    	GameRegistry.addShapedRecipe(stackDoubleCompressedSand, "xxx","xxx","xxx",'x', stackCompressedSand);
    	GameRegistry.addShapedRecipe(stackTripleCompressedSand, "xxx","xxx","xxx",'x', stackDoubleCompressedSand);
    	GameRegistry.addShapedRecipe(stackQuadrupleCompressedSand, "xxx","xxx","xxx",'x', stackTripleCompressedSand);
    	GameRegistry.addShapedRecipe(stackQuintupleCompressedSand, "xxx","xxx","xxx",'x', stackQuadrupleCompressedSand);
    	GameRegistry.addShapedRecipe(stackSextupleCompressedSand, "xxx","xxx","xxx",'x', stackQuintupleCompressedSand);
    	GameRegistry.addShapedRecipe(stackSeptupleCompressedSand, "xxx","xxx","xxx",'x', stackSextupleCompressedSand);
    	GameRegistry.addShapedRecipe(stackOctupleCompressedSand, "xxx","xxx","xxx",'x', stackSeptupleCompressedSand);
    	GameRegistry.addShapedRecipe(stackCompressedGravel, "xxx","xxx","xxx",'x', stackGravel);
    	GameRegistry.addShapedRecipe(stackDoubleCompressedGravel, "xxx","xxx","xxx",'x', stackCompressedGravel);
    	GameRegistry.addShapedRecipe(stackTripleCompressedGravel, "xxx","xxx","xxx",'x', stackDoubleCompressedGravel);
    	GameRegistry.addShapedRecipe(stackQuadrupleCompressedGravel, "xxx","xxx","xxx",'x', stackTripleCompressedGravel);
    	GameRegistry.addShapedRecipe(stackQuintupleCompressedGravel, "xxx","xxx","xxx",'x', stackQuadrupleCompressedGravel);
    	GameRegistry.addShapedRecipe(stackSextupleCompressedGravel,"xxx","xxx","xxx",'x', stackQuintupleCompressedGravel);
    	GameRegistry.addShapedRecipe(stackSeptupleCompressedGravel, "xxx","xxx","xxx",'x', stackSextupleCompressedGravel);
    	GameRegistry.addShapedRecipe(stackOctupleCompressedGravel, "xxx","xxx","xxx",'x', stackSeptupleCompressedGravel);
    	
    	/**#################**/
    	/**### Shapeless ###**/
    	/**#################**/
    	GameRegistry.addShapelessRecipe(stackString4, stackWool);
    	GameRegistry.addShapelessRecipe(stackCupOfChocolate, stackCup, stackChocolate);
    	GameRegistry.addShapelessRecipe(stackBone9, stackBoneBlock);
    	GameRegistry.addShapelessRecipe(stackNetherWart9, stackNetherWartBlock);
    	GameRegistry.addShapelessRecipe(stackSlimeBall4, stackSlimeBlock);
    	GameRegistry.addShapelessRecipe(stackCobblestone9, stackCompressedCobblestone);
    	GameRegistry.addShapelessRecipe(stackCompressedCobblestone9, stackDoubleCompressedCobblestone);
    	GameRegistry.addShapelessRecipe(stackDoubleCompressedCobblestone9, stackTripleCompressedCobblestone);
    	GameRegistry.addShapelessRecipe(stackTripleCompressedCobblestone9, stackQuadrupleCompressedCobblestone);
    	GameRegistry.addShapelessRecipe(stackQuadrupleCompressedCobblestone9, stackQuintupleCompressedCobblestone);
    	GameRegistry.addShapelessRecipe(stackQuintupleCompressedCobblestone9, stackSextupleCompressedCobblestone);
    	GameRegistry.addShapelessRecipe(stackSextupleCompressedCobblestone9, stackSeptupleCompressedCobblestone);
    	GameRegistry.addShapelessRecipe(stackSeptupleCompressedCobblestone9, stackOctupleCompressedCobblestone);
    	GameRegistry.addShapelessRecipe(stackDirt9, stackCompressedDirt);
    	GameRegistry.addShapelessRecipe(stackCompressedDirt9, stackDoubleCompressedDirt);
    	GameRegistry.addShapelessRecipe(stackDoubleCompressedDirt9, stackTripleCompressedDirt);
    	GameRegistry.addShapelessRecipe(stackTripleCompressedDirt9, stackQuadrupleCompressedDirt);
    	GameRegistry.addShapelessRecipe(stackQuadrupleCompressedDirt9, stackQuintupleCompressedDirt);
    	GameRegistry.addShapelessRecipe(stackQuintupleCompressedDirt9, stackSextupleCompressedDirt);
    	GameRegistry.addShapelessRecipe(stackSextupleCompressedDirt9, stackSeptupleCompressedDirt);
    	GameRegistry.addShapelessRecipe(stackSeptupleCompressedDirt9, stackOctupleCompressedDirt);
    	GameRegistry.addShapelessRecipe(stackSand9, stackCompressedSand);
    	GameRegistry.addShapelessRecipe(stackCompressedSand9, stackDoubleCompressedSand);
    	GameRegistry.addShapelessRecipe(stackDoubleCompressedSand9, stackTripleCompressedSand);
    	GameRegistry.addShapelessRecipe(stackTripleCompressedSand9, stackQuadrupleCompressedSand);
    	GameRegistry.addShapelessRecipe(stackQuadrupleCompressedSand9, stackQuintupleCompressedSand);
    	GameRegistry.addShapelessRecipe(stackQuintupleCompressedSand9, stackSextupleCompressedSand);
    	GameRegistry.addShapelessRecipe(stackSextupleCompressedSand9, stackSeptupleCompressedSand);
    	GameRegistry.addShapelessRecipe(stackSeptupleCompressedSand9, stackOctupleCompressedSand);
    	GameRegistry.addShapelessRecipe(stackGravel9, stackCompressedGravel);
    	GameRegistry.addShapelessRecipe(stackCompressedGravel9, stackDoubleCompressedGravel);
    	GameRegistry.addShapelessRecipe(stackDoubleCompressedGravel9, stackTripleCompressedGravel);
    	GameRegistry.addShapelessRecipe(stackTripleCompressedGravel9, stackQuadrupleCompressedGravel);
    	GameRegistry.addShapelessRecipe(stackQuadrupleCompressedGravel9, stackQuintupleCompressedGravel);
    	GameRegistry.addShapelessRecipe(stackQuintupleCompressedGravel9, stackSextupleCompressedGravel);
    	GameRegistry.addShapelessRecipe(stackSextupleCompressedGravel9, stackSeptupleCompressedGravel);
    	GameRegistry.addShapelessRecipe(stackSeptupleCompressedGravel9, stackOctupleCompressedGravel);
    	
    	/**############ ##**/
    	/**### Furnace ###**/
    	/**###############**/
    	GameRegistry.addSmelting(stackLimestoneCobble, stackLimestone, 1.0F);
    	GameRegistry.addSmelting(stackMigmatiteCobble, stackMigmatite, 1.0F);
    	GameRegistry.addSmelting(stackSapphireOre, stackSapphire, 1.0F);
    	GameRegistry.addSmelting(stackRubyOre, stackRuby, 1.0F);
    	GameRegistry.addSmelting(stackCupOfChocolate, stackHotChocolate, 1.0F);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
    
    /*### RegisterItem ###*/
	private void registerItems() {
		GameRegistry.registerItem(ruby, "ruby");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby", "inventory"));
		GameRegistry.registerItem(sapphire, "sapphire");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sapphire, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":sapphire", "inventory"));
		GameRegistry.registerItem(chocolate, "chocolate");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(chocolate, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":chocolate", "inventory"));
		GameRegistry.registerItem(cup, "cup");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(cup, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":cup", "inventory"));
		GameRegistry.registerItem(cup_of_chocolate, "cup_of_chocolate");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(cup_of_chocolate, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":cup_of_chocolate", "inventory"));
		GameRegistry.registerItem(hot_chocolate, "hot_chocolate");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(hot_chocolate, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":hot_chocolate", "inventory"));
		GameRegistry.registerItem(ruby_axe, "ruby_axe");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_axe, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_axe", "inventory"));
		GameRegistry.registerItem(ruby_pickaxe, "ruby_pickaxe");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_pickaxe, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_pickaxe", "inventory"));
		GameRegistry.registerItem(ruby_spade, "ruby_spade");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_spade, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_spade", "inventory"));
		GameRegistry.registerItem(ruby_hoe, "ruby_hoe");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_hoe, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_hoe", "inventory"));
		GameRegistry.registerItem(ruby_sword, "ruby_sword");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_sword, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_sword", "inventory"));
		GameRegistry.registerItem(sapphire_axe, "sapphire_axe");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sapphire_axe, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":sapphire_axe", "inventory"));
		GameRegistry.registerItem(sapphire_pickaxe, "sapphire_pickaxe");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sapphire_pickaxe, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":sapphire_pickaxe", "inventory"));
		GameRegistry.registerItem(sapphire_spade, "sapphire_spade");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sapphire_spade, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":sapphire_spade", "inventory"));
		GameRegistry.registerItem(sapphire_hoe, "sapphire_hoe");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sapphire_hoe, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":sapphire_hoe", "inventory"));
		GameRegistry.registerItem(sapphire_sword, "sapphire_sword");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sapphire_sword, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":sapphire_sword", "inventory"));
		
		/*Armor*/
		GameRegistry.registerItem(ruby_helmet, "ruby_helmet");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_helmet, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_helmet", "inventory"));
		GameRegistry.registerItem(ruby_chestplate, "ruby_chestplate");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_chestplate, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_chestplate", "inventory"));
		GameRegistry.registerItem(ruby_leggins, "ruby_leggins");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_leggins, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_leggins", "inventory"));
		GameRegistry.registerItem(ruby_boots, "ruby_boots");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ruby_boots, 0, new ModelResourceLocation
				(ALLinONEmod.MODID + ":ruby_boots", "inventory"));
		
	}
	/*### RegisterBlock ###*/
	private void registerBlocks() {
		GameRegistry.registerBlock(marble, "marble");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(marble), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":marble", "inventory"));
		GameRegistry.registerBlock(marble_brick, "marble_brick");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(marble_brick), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":marble_brick", "inventory"));
		GameRegistry.registerBlock(bone_block, "bone_block");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(bone_block), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":bone_block", "inventory"));
		GameRegistry.registerBlock(limestone_brick, "limestone_brick");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(limestone_brick), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":limestone_brick", "inventory"));
		GameRegistry.registerBlock(limestone_cobble, "limestone_cobble");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(limestone_cobble), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":limestone_cobble", "inventory"));
		GameRegistry.registerBlock(limestone, "limestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(limestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":limestone", "inventory"));
		GameRegistry.registerBlock(magma, "magma");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(magma), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":magma", "inventory"));
		GameRegistry.registerBlock(migmatite_brick, "migmatite_brick");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(migmatite_brick), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":migmatite_brick", "inventory"));
		GameRegistry.registerBlock(migmatite_cobble, "migmatite_cobble");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(migmatite_cobble), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":migmatite_cobble", "inventory"));
		GameRegistry.registerBlock(migmatite, "migmatite");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(migmatite), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":migmatite", "inventory"));
		GameRegistry.registerBlock(nether_wart_block, "nether_wart_block");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(nether_wart_block), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":nether_wart_block", "inventory"));
		GameRegistry.registerBlock(ruby_ore, "ruby_ore");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ruby_ore), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":ruby_ore", "inventory"));
		GameRegistry.registerBlock(sapphire_ore, "sapphire_ore");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(sapphire_ore), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":sapphire_ore", "inventory"));
		GameRegistry.registerBlock(compressed_cobblestone, "compressed_cobblestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(compressed_cobblestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":compressed_cobblestone", "inventory"));
		GameRegistry.registerBlock(double_compressed_cobblestone, "double_compressed_cobblestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(double_compressed_cobblestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":double_compressed_cobblestone", "inventory"));
		GameRegistry.registerBlock(triple_compressed_cobblestone, "triple_compressed_cobblestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(triple_compressed_cobblestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":triple_compressed_cobblestone", "inventory"));
		GameRegistry.registerBlock(quadruple_compressed_cobblestone, "quadruple_compressed_cobblestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(quadruple_compressed_cobblestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":quadruple_compressed_cobblestone", "inventory"));
		GameRegistry.registerBlock(quintuple_compressed_cobblestone, "quintuple_compressed_cobblestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(quintuple_compressed_cobblestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":quintuple_compressed_cobblestone", "inventory"));
		GameRegistry.registerBlock(sextuple_compressed_cobblestone, "sextuple_compressed_cobblestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(sextuple_compressed_cobblestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":sextuple_compressed_cobblestone", "inventory"));
		GameRegistry.registerBlock(septuple_compressed_cobblestone, "septuple_compressed_cobblestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(septuple_compressed_cobblestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":septuple_compressed_cobblestone", "inventory"));
		GameRegistry.registerBlock(octuple_compressed_cobblestone, "octuple_compressed_cobblestone");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(octuple_compressed_cobblestone), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":octuple_compressed_cobblestone", "inventory"));
		GameRegistry.registerBlock(compressed_dirt, "compressed_dirt");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(compressed_dirt), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":compressed_dirt", "inventory"));
		GameRegistry.registerBlock(double_compressed_dirt, "double_compressed_dirt");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(double_compressed_dirt), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":double_compressed_dirt", "inventory"));
		GameRegistry.registerBlock(triple_compressed_dirt, "triple_compressed_dirt");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(triple_compressed_dirt), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":triple_compressed_dirt", "inventory"));
		GameRegistry.registerBlock(quadruple_compressed_dirt, "quadruple_compressed_dirt");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(quadruple_compressed_dirt), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":quadruple_compressed_dirt", "inventory"));
		GameRegistry.registerBlock(quintuple_compressed_dirt, "quintuple_compressed_dirt");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(quintuple_compressed_dirt), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":quintuple_compressed_dirt", "inventory"));
		GameRegistry.registerBlock(sextuple_compressed_dirt, "sextuple_compressed_dirt");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(sextuple_compressed_dirt), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":sextuple_compressed_dirt", "inventory"));
		GameRegistry.registerBlock(septuple_compressed_dirt, "septuple_compressed_dirt");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(septuple_compressed_dirt), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":septuple_compressed_dirt", "inventory"));
		GameRegistry.registerBlock(octuple_compressed_dirt, "octuple_compressed_dirt");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(octuple_compressed_dirt), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":octuple_compressed_dirt", "inventory"));
		GameRegistry.registerBlock(compressed_sand, "compressed_sand");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(compressed_sand), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":compressed_sand", "inventory"));
		GameRegistry.registerBlock(double_compressed_sand, "double_compressed_sand");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(double_compressed_sand), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":double_compressed_sand", "inventory"));
		GameRegistry.registerBlock(triple_compressed_sand, "triple_compressed_sand");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(triple_compressed_sand), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":triple_compressed_sand", "inventory"));
		GameRegistry.registerBlock(quadruple_compressed_sand, "quadruple_compressed_sand");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(quadruple_compressed_sand), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":quadruple_compressed_sand", "inventory"));
		GameRegistry.registerBlock(quintuple_compressed_sand, "quintuple_compressed_sand");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(quintuple_compressed_sand), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":quintuple_compressed_sand", "inventory"));
		GameRegistry.registerBlock(sextuple_compressed_sand, "sextuple_compressed_sand");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(sextuple_compressed_sand), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":sextuple_compressed_sand", "inventory"));
		GameRegistry.registerBlock(septuple_compressed_sand, "septuple_compressed_sand");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(septuple_compressed_sand), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":septuple_compressed_sand", "inventory"));
		GameRegistry.registerBlock(octuple_compressed_sand, "octuple_compressed_sand");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(octuple_compressed_sand), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":octuple_compressed_sand", "inventory"));
		GameRegistry.registerBlock(compressed_gravel, "compressed_gravel");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(compressed_gravel), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":compressed_gravel", "inventory"));
		GameRegistry.registerBlock(double_compressed_gravel, "double_compressed_gravel");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(double_compressed_gravel), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":double_compressed_gravel", "inventory"));
		GameRegistry.registerBlock(triple_compressed_gravel, "triple_compressed_gravel");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(triple_compressed_gravel), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":triple_compressed_gravel", "inventory"));
		GameRegistry.registerBlock(quadruple_compressed_gravel, "quadruple_compressed_gravel");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(quadruple_compressed_gravel), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":quadruple_compressed_gravel", "inventory"));
		GameRegistry.registerBlock(quintuple_compressed_gravel, "quintuple_compressed_gravel");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(quintuple_compressed_gravel), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":quintuple_compressed_gravel", "inventory"));
		GameRegistry.registerBlock(sextuple_compressed_gravel, "sextuple_compressed_gravel");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(sextuple_compressed_gravel), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":sextuple_compressed_gravel", "inventory"));
		GameRegistry.registerBlock(septuple_compressed_gravel, "septuple_compressed_gravel");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(septuple_compressed_gravel), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":septuple_compressed_gravel", "inventory"));
		GameRegistry.registerBlock(octuple_compressed_gravel, "octuple_compressed_gravel");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(octuple_compressed_gravel), 0, 
				new ModelResourceLocation(ALLinONEmod.MODID + ":octuple_compressed_gravel", "inventory"));
		
	}
	
	//RemoveRecipes
	private void removeRecipes() {
		
		List<IRecipe> craftingrecipes = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> craftingremover = craftingrecipes.iterator();
		while(craftingremover.hasNext()) {
			ItemStack craftingitemstack = craftingremover.next().getRecipeOutput();
			
			/**If-Abfrage für JEDES Rezept*/
			if(craftingitemstack != null && craftingitemstack.getItem() == Item.getItemFromBlock(Blocks.slime_block)) {
				craftingremover.remove();
			}
			if(craftingitemstack != null && craftingitemstack.getItem() == Items.slime_ball) {
				craftingremover.remove();
			}
		}
		
		Map furnacerecipes = FurnaceRecipes.instance().getSmeltingList();
		Iterator furnaceremover = furnacerecipes.entrySet().iterator();
		while(furnaceremover.hasNext()) {
			Entry furnaceentry = (Entry) furnaceremover.next();
			ItemStack furnaceitemstack = (ItemStack) furnaceentry.getValue();
			
			/**If-Abfrage für JEDES Rezept*/
			if(furnaceitemstack != null && furnaceitemstack.getItem() == Items.emerald) {
				furnaceremover.remove();
			}
			
		}
		
	}
	
}
