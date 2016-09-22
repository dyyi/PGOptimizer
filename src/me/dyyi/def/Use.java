package me.dyyi.def;

public enum Use {
	ANALOG,
	CLOCK,
	GROUND,
	POWER,
	RESET,
	SCAN,
	SIGNAL,
	TIEOFF;
	
	public static Use setUse(String use) {
		switch (use) {
		case "ANALOG":
			return ANALOG;
		case "CLOCK":
			return CLOCK;
		case "GROUND":
			return GROUND;
		case "POWER":
			return POWER;
		case "RESET":
			return RESET;
		case "SCAN":
			return SCAN;
		case "SIGNAL":
			return SIGNAL;
		case "TIEOFF":
			return TIEOFF;
		}
		return SIGNAL;
		// Need to throw exception
	}
}
