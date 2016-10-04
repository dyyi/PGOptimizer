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
		return Enum.valueOf(Use.class, use);
	}
}
