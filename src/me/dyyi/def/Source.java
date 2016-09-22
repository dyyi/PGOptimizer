package me.dyyi.def;

public enum Source {
	NETLIST,
	DIST,
	USER,
	TIMING;
	
	public static Source setSource(String name) {
		switch (name) {
		case "NETLIST":
			return NETLIST;
		case "DIST":
			return DIST;
		case "USER":
			return USER;
		case "TIMING":
			return TIMING;
		default:
			return NETLIST;
			// Need to throw exception !!
		}
	}
	
	@Override
	public String toString() {
		switch (this) {
		case NETLIST:
			return "NETLIST";
		case DIST:
			return "DIST";
		case USER:
			return "USER";
		case TIMING:
			return "TIMING";
		default:
			return "NETLIST";
			// Need to throw exception !!
		}
	}
}
