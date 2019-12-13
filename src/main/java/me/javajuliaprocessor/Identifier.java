package me.javajuliaprocessor;

// This is a class to allow for easier storage of identifiers and their values
public class Identifier {
	public String id;
	public int value;
	
	public Identifier(String newID, int newValue) {
		id = newID;
		value = newValue;
	} 
	
	public int getValue() {
		return value;
	}
	
	public String getID() {
		return id;
	}
	
	public void setValue(int val) {
		value = val;
	}
}
