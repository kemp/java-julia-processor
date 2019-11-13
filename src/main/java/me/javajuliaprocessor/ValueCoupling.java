/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

public class ValueCoupling {
	int token;
	String lexeme;
	public ValueCoupling(int t, String s) {
		token = t;
		lexeme = s;
	}
	
	public String valueType() {
		if(token == 5001)
			return "<literal_integer>";
		else
			return "<id>";
	}
	
	public void printGrammar() {
		if(token == 5001) {
			System.out.println(lexeme + " -> <literal_integer>");
		}
		else if(token == 5012) {
			System.out.println(lexeme + " -> <id>");
		}
	}
}
