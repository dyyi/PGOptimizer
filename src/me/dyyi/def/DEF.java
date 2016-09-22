/**
 * 
 */
package me.dyyi.def;

/**
 * @author Dongyoun Yi
 *
 */

import java.awt.geom.Path2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;

public class DEF {
	
	private File defFile;
	private String designName; // Name for the design
	private Double unit;
	private Path2D.Double dieArea; // The corner points of the bounding rectlinear for the design
	private String dividerChar; // Specifies the character used to express hierarchy when DEF names are mapped to or from other databases.
	private Hashtable<String, Component> components;
	
	/*
	 * Constructor
	 */
	public DEF() {
		this.defFile = null;
		this.designName = null;
		this.unit = null;
		this.dieArea = null;
		this.dividerChar = null;
		this.components = new Hashtable<String,Component>();
	}
	
	public DEF(File def_file) {
		this();
		this.parse(def_file);			
	}
	
	public DEF(String def_file_name) {
		this(new File(def_file_name));			
	}
	
	public void parse(File def_file) {
		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(def_file))) {
			String[] tokens = null;
			while ((line = readDefLine(br)) != null) {
				StringTokenizer st = new StringTokenizer(line);
				String firstWord = st.nextToken();
				if (firstWord.equalsIgnoreCase("COMPONENTS")) {
					parseComponents(br);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String readDefLine(BufferedReader br) throws IOException {
		String currentLine = null;
		String resultLine = null;
		Matcher semicolonMatcher = null;
		Matcher sectionEndMatcher = null;
		boolean sectionEndFlag = true;
		while ((currentLine = br.readLine()) != null) {
			if (resultLine == null)
				resultLine = "";
			sectionEndMatcher = Pattern.compile("^\\s*END\\s+\\S+\\s*").matcher(currentLine);
			if (sectionEndFlag && sectionEndMatcher.find()) {
				return currentLine;
			} else {
				sectionEndFlag = false;
			}
			resultLine += currentLine;
			semicolonMatcher = Pattern.compile("\\s*;\\s*").matcher(currentLine);
			if (semicolonMatcher.find()) {
				break;
			}
		}
		return resultLine;
	}
	
	private void parseComponents(BufferedReader br) throws IOException {
		String line = null;
		Component comp = null;
		while ((line = readDefLine(br)) != null) {
			StringTokenizer st = new StringTokenizer(line);
			if (st.nextToken().equalsIgnoreCase("END")) {
				return;
			}			
			comp = new Component(line);
			this.components.put(comp.getName(), comp);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DEF def = new DEF("src/me/dyyi/def/s5378_bench_chip.template.def");
	}

}
