/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;

//Class to hold the iterator expressions found in the code and output their grammar
public class IterCoupling {
	Token colonToken;
	Object oc1, oc2;
	public IterCoupling(Token t, Object o1, Object o2) {
		colonToken = t;
		oc1 = o1;
		oc2 = o2;
	}
	
	public void printGrammar(){
		System.out.println("<iter> -> <arithmetic_expression> : <arithmetic_expression>");
		if(oc1 instanceof ValueCoupling && oc2 instanceof ValueCoupling) { // Both objects are ValueCoupling
			System.out.println("<arithmetic_expression> -> " + ((ValueCoupling) oc1).valueType() + "\n<arithmetic_expression> -> " 
					+ ((ValueCoupling) oc2).valueType());
			((ValueCoupling) oc1).printGrammar();
			System.out.println(": -> :");
			((ValueCoupling) oc2).printGrammar();
		}
		else if(oc1 instanceof MathCoupling && oc2 instanceof ValueCoupling) { // First object is a MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> " 
					+ ((ValueCoupling) oc2).valueType());
			((MathCoupling) oc1).printGrammar();
			System.out.println(": -> :");
			((ValueCoupling) oc2).printGrammar();
		}
		else if(oc1 instanceof ValueCoupling && oc2 instanceof MathCoupling) { // Second object is a MathCoupling
			System.out.println("<arithmetic_expression> -> " + ((ValueCoupling) oc1).valueType() 
					+ "\n<arithmetic_expression> -> <binary_expression>");
			((ValueCoupling) oc1).printGrammar();
			System.out.println(": -> :");
			((MathCoupling) oc2).printGrammar();
		}
		else { // Both objects are MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> <binary_expression>");
			((MathCoupling) oc1).printGrammar();
			System.out.println(": -> :");
			((MathCoupling) oc2).printGrammar();
		}
	}
}
