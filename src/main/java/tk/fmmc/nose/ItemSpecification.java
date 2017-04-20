package tk.fmmc.nose;

public class ItemSpecification {

	private ItemType itemType;
	private String registryName;
	private String englishName;
	private String textureName;
	private String materialName;
	private String inventoryTab;
	
	public ItemSpecification(ItemType iType, String rName, String eName, String tName, String mName, String iTab) {
		this.itemType = iType;
		this.registryName = rName;
		this.englishName = eName;
		this.textureName = tName;
		this.materialName = mName;
		inventoryTab = iTab;
	}

	public ItemType getItemType() {
		return itemType;
	}
	
	public String getRegistryName() {
		return registryName;
	}

	public String getEnglishName() {
		return englishName;
	}
	
	public String getTextureName() {
		return textureName;
	}

	public String getMaterialName() {
		return materialName;
	}
	
	public String getInventoryTab(){
		return inventoryTab;
	}
}
