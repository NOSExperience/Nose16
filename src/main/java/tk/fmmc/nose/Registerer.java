package tk.fmmc.nose;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Registerer {
	
	public static int lastId = 4000;
	
	public static void register(ItemSpecification spec) {
		if(spec.getItemType() == ItemType.ITEM) {
			Item item = new Item(lastId).setUnlocalizedName(spec.getRegistryName());
			if(spec.getTextureName() != null) {
				item.setTextureName(Main.MODID + ":" + spec.getTextureName());
			}
			
			item.setCreativeTab(CreativeTabs.tabMaterials);
			
			GameRegistry.registerItem(item, spec.getRegistryName());
			
			LanguageRegistry.addName(item, spec.getEnglishName());
		}else if(spec.getItemType() == ItemType.BLOCK){
			Block block = new Block(lastId, Material.rock).setUnlocalizedName(spec.getRegistryName());
			if(spec.getTextureName() != null) {
				block.setTextureName(Main.MODID + ":" + spec.getRegistryName());
			}
			
			block.setCreativeTab(CreativeTabs.tabMaterials);
			
			GameRegistry.registerBlock(block, spec.getRegistryName());
			
			LanguageRegistry.addName(block, spec.getEnglishName());
		}
		
		lastId++;
	}
}
