package tk.fmmc.nose.web;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;

public class Callback extends ParserCallback {
	
	private List<String> fileNames = new ArrayList<String>();
	private boolean handlingLink = false;
	
	public Callback() {
	}
	
	public List<String> getFileNames() {
		return fileNames;
	}
	
	public void handleStartTag(Tag tag, MutableAttributeSet attributes, int position) {
		//System.out.println("Start tag: " + tag + " " + tag.equals(Tag.A));
		
		handlingLink = tag.equals(Tag.A);
	}
	
	public void handleText(char[] chars, int position) {
		if(handlingLink) {
			String str = new String(chars);
			
			if(		!str.contains("Name")
					&& !(str.contains("Last modified"))
					&& !(str.contains("Size"))
					&& !(str.contains("Description"))
					&& !(str.contains("Parent Directory"))
					&& !(str.contains("NoseRes.zip"))
					&& !(str.contains("options.txt")) ) {
				//System.out.println(chars);
				fileNames.add(str);
			}	
		}
	}
}
