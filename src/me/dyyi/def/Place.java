package me.dyyi.def;

public enum Place {
	FIXED, // Specifies that the component has a location and cannot be moved by automatic tools, but can be moved using interactive commands. You must specify the components' location and orientation.
	COVER, // Specifies that the component has a location and is a part of a cover macro. A COVER component cannot be moved by automatic tools or interactive commands. You must specify the component's location and its orientation.
	PLACED, // Specifies that the component has a location, but can be moved using automatic layout tools. You must specify tha component's location and orientation.
	UNPLACED; // Specifies that the component does not have a location
		
	public static Place setPlace(String name) {
		switch (name) {
		case "FIXED":
			return Place.FIXED;
		case "COVER":
			return Place.COVER;
		case "PLACED":
			return Place.PLACED;
		case "UNPLACED":
			return Place.UNPLACED;
		}
		return Place.UNPLACED;
		// Need to throw exception!!
	}
	
	@Override
	public String toString() {
		switch(this) {
		case FIXED:
			return "FIXED";
		case COVER:
			return "COVER";
		case PLACED:
			return "PLACED";
		case UNPLACED:
			return "UNPLACED";
		}
		return super.toString();
	}
}
