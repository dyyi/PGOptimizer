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
	FE;	// Flpped east
	@Override
	public String toString() {
		switch (this) {
			case N:
				return "N";
			case S:
				return "S";
			case W:
				return "W";
			case E:
				return "E";
			case FN:
				return "FN";
			case FS:
				return "FS";
			case FW:
				return "FW";
			case FE:
				return "FE";
		}
		return super.toString();
	}
}

public class Component {
	private String name;   // instance name
	private String modelName; // model(cell) name
	private Place place; // Place type
	private Double x; // x coordinate
	private Double y; // y coordinate
	private Orientation orientation; // Orientation
	
	/* Constructor */
	public Component() {
		this.name = null;
		this.modelName = null;
		//this.macroName = null;
		this.x = null;
		this.y = null;
		this.orientation = null;
	}
	
	public Component(String str) {
		this();
		this.parse(str);
	}
	
		/* Setter and Getter */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getModelName() { return modelName; }
	public void setModelName(String modelName) { this.modelName = modelName; }
	public Place getPlace() { return place; }
	public void setPlace(Place place) { this.place = place; }
	public Double getX() { return x; }
	public void setX(Double x) { this.x = x; }
	public Double getY() { return y; }
	public void setY(Double y) { this.y = y; }
	public Orientation getOrientation() { return orientation; }
	public void setOrientation(Orientation orientation) { this.orientation = orientation; }

	public void parse(String str) {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Component))
			return false;
		return ((Component) obj).getName().equals(this.getName());
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.modelName + " " + x + " " + y + " " + this.orientation;
	}
	
	public static void main(String[] args) {
		Component c = new Component();
		c.setName("tesetsetestsetes");
		c.setModelName("TEST16");
		c.setOrientation(Orientation.FN);
		System.out.println(c);
		String test_str = " - core/U1 INVX0_RVT + PLACED ( 15504 3344 ) N ;";
		// TODO Auto-generated method stub
	}


}
