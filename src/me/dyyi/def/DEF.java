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
	private Component topComponent;
	private Double unit;
	private Path2D.Double dieArea; // The corner points of the bounding rectlinear for the design
	private String dividerChar; // Specifies the character used to express hierarchy when DEF names are mapped to or from other databases.
	private Hashtable<String, Component> components;
	private Hashtable<String, Net> nets;
	private Hashtable<String, Net> specialNets;
	private Hashtable<String, Pin> pins;
	
	public File getDefFile() { return defFile; }
	public void setDefFile(File defFile) {
		this.defFile = defFile;
	}
	public String getDesignName() {
		return designName;
	}
	public void setDesignName(String designName) {
		this.designName = designName;
	}
	public Component getTopComponent() {
		return topComponent;
	}
	public void setTopComponent(Component topComponent) {
		this.topComponent = topComponent;
	}
	public Double getUnit() {
		return unit;
	}
	public void setUnit(Double unit) {
		this.unit = unit;
	}
	public Path2D.Double getDieArea() {
		return dieArea;
	}
	public void setDieArea(Path2D.Double dieArea) {
		this.dieArea = dieArea;
	}
	public String getDividerChar() {
		return dividerChar;
	}
	public void setDividerChar(String dividerChar) {
		this.dividerChar = dividerChar;
	}
	public Hashtable<String, Component> getComponents() {
		return components;
	}
	public void setComponents(Hashtable<String, Component> components) {
		this.components = components;
	}
	public Hashtable<String, Net> getNets() {
		return nets;
	}
	public void setNets(Hashtable<String, Net> nets) {
		this.nets = nets;
	}
	public Hashtable<String, Net> getSpecialNets() {
		return specialNets;
	}
	public void setSpecialNets(Hashtable<String, Net> specialNets) {
		this.specialNets = specialNets;
	}
	public Hashtable<String, Pin> getPins() { return pins; }
	public void setPins(Hashtable<String, Pin> pins) { this.pins = pins; }
	/*
	 * Constructor
	 */
	public DEF() {
		this.defFile = null;
		this.designName = null;
		this.topComponent = null;
		this.unit = null;
		this.dieArea = null;
		this.dividerChar = null;
		this.components = new Hashtable<String,Component>();
		this.nets = new Hashtable<String, Net>();
		this.specialNets = new Hashtable<String, Net>();
		this.pins = new Hashtable<String, Pin>();
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
			while ((line = readDefLine(br)) != null) {
				StringTokenizer st = new StringTokenizer(line);
				String firstWord = st.nextToken();
				if (firstWord.equalsIgnoreCase("COMPONENTS")) {
					parseComponents(br);
				//} else if (firstWord.equalsIgnoreCase("PINS")) {
					//parsePins(br);
				} else if (firstWord.equalsIgnoreCase("NETS")) {
					parseNets(br);
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
			System.out.println(comp);
			this.components.put(comp.getName(), comp);
		}
	}
	
	private void parsePins(BufferedReader br) throws IOException {
		String line = null;
		Pin pin = null;
		while ((line = readDefLine(br)) != null) {
			StringTokenizer st = new StringTokenizer(line);
			if (st.nextToken().equalsIgnoreCase("END")) {
				return;
			}			
			pin = new Pin(line);
			this.pins.put(pin.getName(), pin);
		}	
	}
	
	private void parseNets(BufferedReader br) throws IOException {
		parseNets(br, this.nets);
	}
	
	private void parseNets(BufferedReader br, Hashtable<String, Net> nets) throws IOException {
		String line = null;
		Net net = null;
		while ((line = readDefLine(br)) != null) {
			StringTokenizer st = new StringTokenizer(line);
			if (st.nextToken().equalsIgnoreCase("END")) {
				return;
			}			
			net = new Net(line, this);
			this.nets.put(net.getName(), net);
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
