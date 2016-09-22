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
		switch (in) {
		case "N":
			return Orientation.N;
		case "S":
			return Orientation.S;
		case "W":
			return Orientation.W;
		case "E":
			return Orientation.E;
		case "FN":
			return Orientation.FN;
		case "FS":
			return Orientation.FS;
		case "FW":
			return Orientation.FW;
		case "FE":
			return Orientation.FE;
		// Need to throw exception!!
		default:
			return Orientation.N;
		}
	}
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
