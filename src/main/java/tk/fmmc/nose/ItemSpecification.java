package tk.fmmc.nose;

public class ItemSpecification {

	private String registryName;
	private String englishName;
	private String textureName;
	
	public ItemSpecification(String rName, String eName, String tName) {
		this.registryName = rName;
		this.englishName = eName;
		this.textureName = tName;
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

