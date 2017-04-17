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
		} else if(spec.getItemType() == ItemType.BLOCK){
			Block block = null;
			
			if(spec.getMaterialName() != null) {
				Material mt = Material.rock;
				
				if(spec.getMaterialName() == "grass") {
					mt = Material.grass;
				} else if(spec.getMaterialName() == "ground") {
					mt = Material.ground;
				} else if(spec.getMaterialName() == "wood") {
					mt = Material.wood;
				} else if(spec.getMaterialName() == "rock") {
					mt = Material.rock;
				} else if(spec.getMaterialName() == "iron") {
					mt = Material.iron;
				} else if(spec.getMaterialName() == "anvil") {
					mt = Material.anvil;
				} else if(spec.getMaterialName() == "water") {
					mt = Material.water;
				} else if(spec.getMaterialName() == "lava") {
					mt = Material.lava;
				} else if(spec.getMaterialName() == "leaves") {
					mt = Material.leaves;
				} else if(spec.getMaterialName() == "plants") {
					mt = Material.plants;
				} else if(spec.getMaterialName() == "vine") {
					mt = Material.vine;
				} else if(spec.getMaterialName() == "sponge") {
					mt = Material.sponge;
				} else if(spec.getMaterialName() == "cloth") {
					mt = Material.cloth;
				} else if(spec.getMaterialName() == "fire") {
					mt = Material.fire;
				} else if(spec.getMaterialName() == "sand") {
					mt = Material.sand;
				} else if(spec.getMaterialName() == "circuits") {
					mt = Material.circuits;
				} else if(spec.getMaterialName() == "materialCarpet") {
					mt = Material.materialCarpet;
				} else if(spec.getMaterialName() == "glass") {
					mt = Material.glass;
				} else if(spec.getMaterialName() == "redstoneLight") {
					mt = Material.redstoneLight;
				} else if(spec.getMaterialName() == "tnt") {
					mt = Material.tnt;
				} else if(spec.getMaterialName() == "coral") {
					mt = Material.coral;
				} else if(spec.getMaterialName() == "ice") {
					mt = Material.ice;
				} else if(spec.getMaterialName() == "snow") {
					mt = Material.snow;
				}
				
				block = new Block(lastId, mt).setUnlocalizedName(spec.getRegistryName());
			} else {
				block = new Block(lastId, Material.rock).setUnlocalizedName(spec.getRegistryName());
			}
			
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
