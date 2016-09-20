/**
 * 
 */
package me.dyyi.def;


import java.awt.geom.Path2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Hashtable;

/**
 * @author Dongyoun Yi
 *
 */
public class DEF {
	
	private File def_file;
	private String design_name; // Name for the design
	private Path2D.Double die_area; // The corner points of the bounding rectlinear for the design
	private String divider_char; // Specifies the character used to express hierarchy when DEF names are mapped to or from other databases.
	/*
	 * Constructor
	 */
	public DEF() {
		this.def_file = null;
	}
	
	public DEF(File def_file) {
		this();
		this.parse(def_file);			
	}
	
	public DEF(String def_file_name) {
		this.parse(new File(def_file_name));			
	}
	
	public void parse(File def_file) {
		try {
			Scanner scanner = new Scanner(def_file);
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DEF def = new DEF("src/me/dyyi/def/s5378_bench_chip.template.def");
	}

}
