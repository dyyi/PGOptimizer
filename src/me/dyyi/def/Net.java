package me.dyyi.def;

import java.util.ArrayList;

public class Net {
	String name = null;
	ArrayList<Pin> pins = null;
	
	public Net() {
		pins = new ArrayList<Pin>();
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public ArrayList<Pin> getPins() { return pins; }
	public void setPins(ArrayList<Pin> pins) { this.pins = pins; }
}
