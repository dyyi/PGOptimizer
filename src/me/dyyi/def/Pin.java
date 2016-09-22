package me.dyyi.def;

import java.util.Hashtable;

public class Pin {
	String name = null;
	Component master = null;
	Hashtable<String, Net> nets = null;
	
	public Pin() {
		nets = new Hashtable<String, Net>();
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Component getMaster() { return master; }
	public void setMaster(Component master) { this.master = master;	}	
	public Hashtable<String, Net> getNets() { return nets; }
	public void setNets(Hashtable<String, Net> nets) { this.nets = nets; }

	public void addNet(Net net) {
		this.nets.put(net.getName(), net);
	}
}
