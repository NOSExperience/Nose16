package tk.fmmc.nose;

import java.util.List;

public class CombinedSpecification {

	private List<ItemSpecification> items;
	
	public CombinedSpecification(List<ItemSpecification> itemList) {
		this.items = itemList;
	}
	
	public List<ItemSpecification> getItems() {
		return items;
	}
	
	public void selfRegister() {
		for(ItemSpecification i : items) {
			System.out.println(i.getRegistryName() + ": " + i.getEnglishName());
			
			Registerer.register(i);
		}
	}
}
