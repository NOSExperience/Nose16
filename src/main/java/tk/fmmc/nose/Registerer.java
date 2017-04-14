package tk.fmmc.nose;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class Registerer {
	
	public static int lastId = 4000;
	
	public static void register(ItemSpecification spec) {
		Item item = new Item(lastId).setUnlocalizedName(spec.getRegistryName());
		if(spec.getTextureName() != null) {
			item.setTextureName(Main.MODID + ":" + spec.getTextureName());
		}
		
		GameRegistry.registerItem(item, spec.getRegistryName());
		
		LanguageRegistry.addName(item, spec.getEnglishName());
		
		lastId++;
	}
}
