package me.dyyi.def;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Component {
	private String name = null;   // instance name
	private String modelName = null; // model(cell) name
	private Place place = null; // Place type
	private Double x = null; // x coordinate
	private Double y = null; // y coordinate
	private Orientation orientation = null; // Orientation
	private boolean top = false; // Indicator whether this component is top component, that is to say the top design itself.
	private Hashtable<String, Pin> pins = new Hashtable<String, Pin>();
	
	/* Constructor */
	public Component() { }
	
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
	public boolean isTop() { return top; }
	public void setTop(boolean top) { this.top = top; }
	public Hashtable<String, Pin> getPins() { return pins; }
	public void setPins(Hashtable<String, Pin> pins) { this.pins = pins; }

	public void parse(String str) {
		Matcher matcher;
		matcher = Pattern.compile("^\\s*-\\s+(?<name>\\S+)\\s+(?<modelName>\\S+)").matcher(str);
		if (matcher.find()) {
			this.name = matcher.group("name");
			this.modelName = matcher.group("modelName");
		}
		// Component Position Check
		matcher = Pattern.compile("\\+\\s+(?<type>FIXED|COVER|PLACED)?\\s*\\(\\s*(?<x>[0-9\\.e\\+\\-]+)\\s+(?<y>[0-9\\.e\\+\\-]+)\\s+\\)\\s+(?<orientation>\\S+)").matcher(str);
		if (matcher.find()) {
			this.place= Place.setPlace(matcher.group("type"));
			this.x = Double.parseDouble(matcher.group("x"));
			this.y = Double.parseDouble(matcher.group("y"));
			this.orientation = Orientation.setOrientation(matcher.group("orientation"));
		}
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Component))
			return false;
		return ((Component) obj).getName().equals(this.getName());
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.modelName + " " + this.place + " " + this.x + " " + this.y + " " + this.orientation;
	}
	
	public static void main(String[] args) {
		Component c = new Component();
		c.setName("tesetsetestsetes");
		c.setModelName("TEST16");
		c.setOrientation(Orientation.FN);
		System.out.println(c);
		String test_str = " - core/U1 INVX0_RVT + PLACED ( 15504 3344 ) N ;";
		c = new Component(test_str);
		System.out.println(c);
		// TODO Auto-generated method stub
	}


}
