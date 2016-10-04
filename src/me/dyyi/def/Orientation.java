package me.dyyi.def;

public enum Orientation {
	N, // North
	S, // South
	W, // West
	E, // East
	FN, // Flipped north
	FS, // Flipped south
	FW, // Flipped west
	FE;	// Flpped east
	
	public static Orientation setOrientation(String in) {
		return Enum.valueOf(Orientation.class, in);
	}

}
