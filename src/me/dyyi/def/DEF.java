/**
 * 
 */
package me.dyyi.def;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Dongyoun Yi
 *
 */
public class DEF {
	
	private File def_file;
	
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DEF def = new DEF();
	}

}
