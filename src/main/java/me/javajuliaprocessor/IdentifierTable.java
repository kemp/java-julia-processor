/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 3 Interpreter - Java
 */
package me.javajuliaprocessor;

import java.util.ArrayList;
import me.javajuliaprocessor.scanner.Token;

// This class holds all the identifiers and their values from the julia program
public class IdentifierTable {
	ArrayList<Identifier> table;
	public IdentifierTable() {
		table = new ArrayList<Identifier>();
	}
	
	public void addIdentifier(Identifier ID) {
		int temp = searchTable(ID.getID());
		if(temp != -1) {
			table.get(temp).setValue(ID.getValue());
		}
		else if(temp == -1){
			table.add(new Identifier(ID.getID(), ID.getValue()));
		}
	}
	
	public int getValue(String ID, Token tok) {
		int temp = searchTable(ID);
		if(temp != -1) {
			return table.get(temp).getValue();
		}
		else if(temp == -1) {
			System.out.println(ID + " was never initialized in the program.\nFound at line: " + tok.getLineNumber());
			System.exit(0);
		}
		return -1; // This will never be called. It only exists to stop the complier from being unhappy.
	}
	
	private int searchTable(String ID) {
		for(int i = 0; i < table.size(); i++) {
			if(table.get(i).getID().equals(ID)) {
				return i;
			}
		}
		return -1;
	}
}
