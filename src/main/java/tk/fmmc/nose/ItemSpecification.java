package tk.fmmc.nose;

public class ItemSpecification {

	private ItemType itemType;
	private String registryName;
	private String englishName;
	private String textureName;
	
	public ItemSpecification(ItemType iType, String rName, String eName, String tName) {
		this.itemType = iType;
		this.registryName = rName;
		this.englishName = eName;
		this.textureName = tName;
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
}

