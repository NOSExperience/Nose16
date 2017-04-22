package tk.fmmc.nose.web;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.text.html.parser.ParserDelegator;

public class Downloader {

	public static void preInit(String urlStr) throws Exception {		
		downloadDefinitions(urlStr);
		downloadResourcePack(urlStr);
	}
	
	public static void postInit(String urlStr) throws IOException {
		downloadConfiguration(urlStr);
	}
	
	private static void downloadDefinitions(String urlStr) throws Exception {
		List<String> dirList = getDirList(urlStr);
		
		for(String i : dirList) {
			System.out.println("dirList: " + i);
			downloadFile(new URL(urlStr + i), Paths.get("dynamic/" + i));
		}
	}
	
	private static List<String> getDirList(String urlStr) throws Exception {
		downloadFile(new URL(urlStr), Paths.get("dynamic/_dirlist.html"));
		
		List<String> dirList = parseDirList("dynamic/_dirlist.html");
		
		return dirList;
	}
	
	private static void downloadFile(URL url, Path save) throws IOException {
		try (InputStream in = url.openStream()) {
		    Files.copy(in, save, StandardCopyOption.REPLACE_EXISTING);
		}
	}
	
	private static List<String> parseDirList(String pathStr) throws IOException {
		Callback c = new Callback();
		
		try (FileReader fr = new FileReader(new File(pathStr))) {
			Parser p = new ParserDelegator();
			p.parse(fr, c, false);
		}
		
		return c.getFileNames();
	}
	
	private static void downloadResourcePack(String urlStr) throws IOException {
		downloadFile(new URL(urlStr + "NoseRes.zip"), Paths.get("resourcepacks/NoseRes.zip"));
	}
	
	private static void downloadConfiguration(String urlStr) throws IOException {
		downloadFile(new URL(urlStr + "options.txt"), Paths.get("options.txt"));
	}
}
