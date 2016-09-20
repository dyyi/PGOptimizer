package me.dyyi.def;


enum Place {
	FIXED, // Specifies that the component has a location and cannot be moved by automatic tools, but can be moved using interactive commands. You must specify the components' location and orientation.
	COVER, // Specifies that the component has a location and is a part of a cover macro. A COVER component cannot be moved by automatic tools or interactive commands. You must specify the component's location and its orientation.
	PLACED, // Specifies that the component has a location, but can be moved using automatic layout tools. You must specify tha component's location and orientation.
	UNPLACED // Specifies that the component does not have a location
}

enum Soruce {
	NETLIST,
	DIST,
	USER,
	TIMING
}

enum Orientation {
	N, // North
	S, // South
	W, // West
	E, // East
	FN, // Flipped north
	FS, // Flipped south
	FW, // Flipped west
	FE	// Flpped east
}

public class Component {
	private String name;   // instance name
	private String model_name; // model(cell) name
	private String macro_name; // EEQMaster; Specified that the component being defined should be electrically equivalent to the previous defined macroName
	
	
	/* Constructor */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) || !(obj instanceof Component))
			return false
		return ((Component) obj).getName().equals(this.getName())
	}

}
