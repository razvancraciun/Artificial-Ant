package model.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Field {

	private String[][] _field;
	private static Field _instance;
	
	private Field() {
		Scanner sc;
		try {
			 sc = new Scanner(new BufferedReader(new FileReader("resources/field.txt")));
		}
		catch(Exception e) {
			throw new IllegalArgumentException("File not found");
		}
		int rows = 32;
		int columns = 32;
		_field = new String[rows][columns];
		while(sc.hasNextLine()) {
	         for (int i=0; i<_field.length; i++) {
	            String[] line = sc.nextLine().trim().split(" ");
	            for (int j=0; j<line.length; j++) {
	               _field[i][j] = line[j];
	            }
	         }
	      }
		sc.close();
	}
	
	public static Field getInstance( ) {
		if(_instance==null) {
			_instance=new Field();
		}
		return _instance;
	}
	
	public String[][] getNewField() {
		String[][] copy = new String[_field.length][_field[0].length];
		for(int i=0;i<copy.length;i++) {
			for(int j=0;j<copy[i].length;j++) {
				copy[i][j]=_field[i][j].substring(0);
			}
		}
		return copy;
	}
	
	
	public String toString() {
		String result="";
		for(int i=0;i<_field.length;i++) {
			for(int j=0;j<_field[i].length;j++) {
				result+=_field[i][j]+ " ";
			}
			result += "\n";
		}
		return result;
	}
}
