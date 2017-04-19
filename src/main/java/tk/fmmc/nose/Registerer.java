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
		System.out.println("inventory: " + spec.getInventoryTab());
		
		if(spec.getItemType() == ItemType.ITEM) {
			CreativeTabs tab = CreativeTabs.tabMisc;
			Item item = new Item(lastId).setUnlocalizedName(spec.getRegistryName());
			if(spec.getTextureName() != null) {
				item.setTextureName(Main.MODID + ":" + spec.getTextureName());
			}
			
			if(spec.getInventoryTab() != null) {
				tab = determineTab(spec.getInventoryTab());
			}
			
			item.setCreativeTab(tab);
			
			GameRegistry.registerItem(item, spec.getRegistryName());
			
			LanguageRegistry.addName(item, spec.getEnglishName());
		} else if(spec.getItemType() == ItemType.BLOCK){
			//System.out.println("------------- TEST\n\n\n");
			
			Block block = null;
			CreativeTabs tab = CreativeTabs.tabMisc;
			Material mt = Material.rock;
			
			if(spec.getInventoryTab() != null) {
				tab = determineTab(spec.getInventoryTab());
			}
			
			if(spec.getMaterialName() != null) {
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
				
			} 
			
			block = new Block(lastId, mt).setUnlocalizedName(spec.getRegistryName()).setCreativeTab(tab);
			
			if(spec.getTextureName() != null) {
				block.setTextureName(Main.MODID + ":" + spec.getRegistryName());
			}
			
			GameRegistry.registerBlock(block, spec.getRegistryName());
			
			LanguageRegistry.addName(block, spec.getEnglishName());
		}
		
		lastId++;
	}
	
	private static CreativeTabs determineTab(String tabName) {
		if(tabName.contains("blocks")) {
			return CreativeTabs.tabBlock;
		} else if(tabName.contains("decoration")) {
			return CreativeTabs.tabDecorations;
		} else if(tabName.contains("redstone")) {
			return CreativeTabs.tabRedstone;
		} else if(tabName.contains("transportation")) {
			return CreativeTabs.tabTransport;
		} else if(tabName.contains("misc")) {
			return CreativeTabs.tabMisc;
		} else if(tabName.contains("food")) {
			return CreativeTabs.tabFood;
		} else if(tabName.contains("tools")) {
			return CreativeTabs.tabTools;
		} else if(tabName.contains("combat")) {
			return CreativeTabs.tabCombat;
		} else if(tabName.contains("brewing")) {
			return CreativeTabs.tabBrewing;
		} else if(tabName.contains("materials")) {
			return CreativeTabs.tabMaterials;
		} else {
			return CreativeTabs.tabMisc;
		}
	}
}
