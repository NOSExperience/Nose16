package tk.fmmc.nose;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Discoverer {
	
	private File[] files = null;
	private DocumentBuilder builder;
	
	public Discoverer() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		this.builder = factory.newDocumentBuilder();
	}
	
	public void run() throws Exception {	
		//Document document = builder.parse("resources/test.xml");
		
		discoverFiles("dynamic");
		parseAndRegisterAll();
	}
	
	private void discoverFiles(String dirStr) throws Exception {
		File dir = new File(dirStr);
		
		files = dir.listFiles();
		if(files == null) {
			throw new Exception("Could not index " + dirStr);
		}
	}
	
	private void parseAndRegisterAll() throws Exception {
		for(File i : files) {
			if(i.getName().endsWith(".xml")) {
				CombinedSpecification spec = Parser.parse(i, builder);
				spec.selfRegister();
			}
		}
	}
	
	/*
	private void parseFile(File file) throws Exception {
		System.out.println(file.getName());

		NodeList itemList = document.getElementsByTagName(ITEM_TAG);
		for(int i = 0; i < itemList.getLength(); i++) {
			Node node = itemList.item(i);
			if(node == null) {
				continue;
			}
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				NodeList children = node.getChildNodes();
				for(int j = 0; j < children.getLength(); j++) {
					Node child = children.item(j);
					if(child == null) {
						continue;
					}
					
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						Node contents = child.getFirstChild();
						if(contents == null) {
							continue;
						}
						
						if(contents.getNodeType() == Node.TEXT_NODE) {
							String text = contents.getTextContent();
							
							System.out.println(text);
						}
					}
				}
			}
		}
	}
	*/
}


/*

package main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Discoverer {

	public static List<String> getAll(String directory) throws Exception {
		File[] files = discoverFiles(directory);
		
		for(File i : files) {
			String contents = loadFile(i.getPath());
		}
		
		System.out.println("DISCOVERER IS NOT FINISHED. EXPECT ERRORS.");
		
		return new ArrayList<String>();
	}
	
	private static File[] discoverFiles(String directory) throws Exception {
		File dir = new File(directory);
		
		File[] dirList = dir.listFiles();
		if(dirList == null) {
			throw new Exception("Failed to get contents of " + directory);
		}
		
		return dirList;
	}
	
	private static String loadFile(String pathStr) throws IOException {
		List<String> lines = Files.readAllLines(
				Paths.get(pathStr), StandardCharsets.UTF_8);
		
		String ret = new String();
		for(String i : lines) {
			ret.concat(i);
		}
		
		return ret;
	}
}

*/
