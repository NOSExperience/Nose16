package tk.fmmc.nose;

public class ItemSpecification {

	private ItemType itemType;
	private String registryName;
	private String englishName;
	private String textureName;
	private String materialName;
	
	public ItemSpecification(ItemType iType, String rName, String eName, String tName, String mName) {
		this.itemType = iType;
		this.registryName = rName;
		this.englishName = eName;
		this.textureName = tName;
		this.materialName = mName;
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
}
