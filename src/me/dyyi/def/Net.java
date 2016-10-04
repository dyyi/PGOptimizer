package me.dyyi.def;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Net {
	String name = null;
	ArrayList<Pin> pins = pins = new ArrayList<Pin>();
	
	public Net() { }
	public Net(String line, DEF def) {
		this();
		parse(line, def);
	}

	public void parse(String line, DEF def) {
		Matcher nameMatcher = Pattern.compile("\\s*-\\s+(?<name>\\S+)").matcher(line);
		if (nameMatcher.find()) {
			this.name = nameMatcher.group("name");
			System.out.println("NET " + this.name);
		}
		Matcher compPinMatcher = Pattern.compile("\\s*-\\s+\\S+(\\s+\\(\\s+(\\S+)\\s+(\\S+)\\s+\\))*").matcher(line);
		if (compPinMatcher.find()) {
			Matcher pinMatcher = Pattern.compile("\\(\\s+(?<component>\\S+)\\s+(?<pin>\\S+)\\s+\\)").matcher(compPinMatcher.group());
			while (pinMatcher.find()) {
				
				pinMatcher.group("component");
			}
		}
	}
		
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public ArrayList<Pin> getPins() { return pins; }
	public void setPins(ArrayList<Pin> pins) { 
		this.pins = pins;
	}
}
