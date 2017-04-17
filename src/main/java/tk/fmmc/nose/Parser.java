package tk.fmmc.nose;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class Parser {
	
	private static final String REGISTRY_NAME_TAG = "registryname";
	private static final String ENGLISH_NAME_TAG = "englishname";
	private static final String TEXTURE_NAME_TAG = "texturename";
	private static final String MATERIAL_TAG = "material";
	//
	private static final String ITEM_TAG = "item";
	private static final String BLOCK_TAG = "block";
	
	public static CombinedSpecification parse(File file, DocumentBuilder builder) throws Exception {
		System.out.println(file.getName());
		
		Document document = builder.parse(file);
		
		document.getDocumentElement().normalize();
		
		List<ItemSpecification> items = load(document, ItemType.ITEM);
		List<ItemSpecification> blocks = load(document, ItemType.BLOCK);
		
		return new CombinedSpecification(items, blocks);
	}
		
	private static List<ItemSpecification> load(Document document, ItemType type) {
		List<ItemSpecification> items = new ArrayList<ItemSpecification>();
		
		String tagName = new String();
		
		//IF IT'S NOT WORKING: Perhaps you forgot your break.
		switch(type) {
			case ITEM:
				tagName = ITEM_TAG;
				break;
			case BLOCK:
				tagName = BLOCK_TAG;
				break;
			default:
				break;
		}
		
		NodeList itemList = document.getElementsByTagName(tagName);
		System.out.println("itemList length: " + tagName + ": " + itemList.getLength());
		for(int i = 0; i < itemList.getLength(); i++) {
			Node node = itemList.item(i);
			if(node == null) {
				continue;
			}
			
			NodeList children = node.getChildNodes();
			String registryName = null;
			String englishName = null;
			String textureName = null;
			String materialName = null;
			for(int j = 0; j < children.getLength(); j++) {
				Node child = children.item(j);
				if(child == null) {
					continue;
				}
				
				
				String nodeName = child.getNodeName();
				//System.out.println(nodeName);
				
				if(nodeName == REGISTRY_NAME_TAG) {
					String rName = child.getTextContent();
					if(rName != null) {
						registryName = rName;
					}
				} else if(nodeName == ENGLISH_NAME_TAG) {
					String eName = child.getTextContent();
					if(eName != null) {
						englishName = eName;
					}
				} else if(nodeName == TEXTURE_NAME_TAG) {
					String tName = child.getTextContent();
					if(tName != null) {
						textureName = tName;
					}
				} else if(nodeName == MATERIAL_TAG) {
					String mName = child.getTextContent();
					if(mName != null) {
						materialName = mName;
					}
				}
			}
			
			//System.out.println("reg: " + registryName);
			//System.out.println("eng: " + englishName);
			
			//Textures and materials are optional and can be null
			if(registryName != null && englishName != null) {
				items.add(new ItemSpecification(type, registryName, englishName, textureName, materialName));
			}
		}
		
		return items;
	}
	

}
