/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;

public class IterCoupling {
	Token colonToken;
	ValueCoupling vc1 = null, vc2 = null;
	MathCoupling mc1 = null, mc2 = null;
	public IterCoupling(Token t, ValueCoupling o1, ValueCoupling o2) {
		colonToken = t;
		vc1 = o1;
		vc2 = o2;
	}
	public IterCoupling(Token t, MathCoupling o1, ValueCoupling o2) {
		colonToken = t;
		mc1 = o1;
		vc2 = o2;
	}
	public IterCoupling(Token t, ValueCoupling o1, MathCoupling o2) {
		colonToken = t;
		vc1 = o1;
		mc2 = o2;
	}
	public IterCoupling(Token t, MathCoupling o1, MathCoupling o2) {
		colonToken = t;
		mc1 = o1;
		mc2 = o2;
	}
	
	public void printGrammar(){
		System.out.println("<iter> -> <arithmetic_expression> : <arithmetic_expression>");
		if(vc1 != null && vc2 != null) { // Both objects are ValueCoupling
			System.out.println("<arithmetic_expression> -> " + vc1.valueType() + "\n<arithmetic_expression> -> " + vc2.valueType());
			vc1.printGrammar();
			System.out.println(": -> :");
			vc2.printGrammar();
		}
		else if(mc1 != null && vc2 != null) { // First object is a MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> " + vc2.valueType());
			mc1.printGrammar();
			System.out.println(": -> :");
			vc2.printGrammar();
		}
		else if(vc1 != null && mc2 != null) { // Second object is a MathCoupling
			System.out.println("<arithmetic_expression> -> " + vc1.valueType() + "\n<arithmetic_expression> -> <binary_expression>");
			vc1.printGrammar();
			System.out.println(": -> :");
			mc2.printGrammar();
		}
		else { // Both objects are MathCoupling
			System.out.println("<arithmetic_expression> -> <binary_expression>" + "\n<arithmetic_expression> -> <binary_expression>");
			mc1.printGrammar();
			System.out.println(": -> :");
			mc2.printGrammar();
		}
	}
}
